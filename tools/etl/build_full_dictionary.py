import os
import sys
import gzip
import json
import glob
import time
import sqlite3
import hashlib
import xml.etree.ElementTree as ET
from typing import Dict, List, Tuple, Optional, Any

# Ensure project root is in sys.path
sys.path.insert(0, os.path.dirname(os.path.dirname(os.path.dirname(os.path.abspath(__file__)))))

from tools.etl.normalizer import normalize_text, to_hiragana, romaji_to_hiragana

SCHEMA_DDL = """
-- 1. TABEL UTAMA KOSAKATA
CREATE TABLE IF NOT EXISTS words (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    jmdict_seq TEXT,
    primary_spelling TEXT NOT NULL,
    primary_reading TEXT NOT NULL,
    is_common INTEGER NOT NULL DEFAULT 0,
    jlpt_level INTEGER DEFAULT NULL
);

-- 2. TABEL BACAAN & VARIAN KOSAKATA
CREATE TABLE IF NOT EXISTS word_readings (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    word_id INTEGER NOT NULL REFERENCES words(id) ON DELETE CASCADE,
    reading TEXT NOT NULL,
    reading_hiragana TEXT NOT NULL,
    reading_romaji TEXT NOT NULL,
    is_primary INTEGER NOT NULL DEFAULT 1
);

-- 3. TABEL MAKNA KATA (SENSES)
CREATE TABLE IF NOT EXISTS word_senses (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    word_id INTEGER NOT NULL REFERENCES words(id) ON DELETE CASCADE,
    sense_index INTEGER NOT NULL,
    pos_tags TEXT,
    gloss_id TEXT NOT NULL,
    gloss_en TEXT
);

-- 4. TABEL KANJI
CREATE TABLE IF NOT EXISTS kanji (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    character TEXT NOT NULL UNIQUE,
    stroke_count INTEGER NOT NULL,
    radical_number INTEGER NOT NULL,
    grade INTEGER,
    jlpt_level INTEGER,
    frequency INTEGER,
    meaning_id TEXT NOT NULL,
    meaning_en TEXT
);

-- 5. TABEL BACAAN KANJI
CREATE TABLE IF NOT EXISTS kanji_readings (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    kanji_id INTEGER NOT NULL REFERENCES kanji(id) ON DELETE CASCADE,
    reading_type TEXT NOT NULL,
    reading TEXT NOT NULL,
    reading_romaji TEXT NOT NULL
);

-- 6. TABEL VEKTOR CORETAN KANJI (KANJIVG)
CREATE TABLE IF NOT EXISTS kanji_strokes (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    kanji_id INTEGER NOT NULL REFERENCES kanji(id) ON DELETE CASCADE,
    stroke_number INTEGER NOT NULL,
    path_data TEXT NOT NULL,
    stroke_type TEXT
);

-- 7. TABEL CONTOH KALIMAT (TATOEBA)
CREATE TABLE IF NOT EXISTS sentence_examples (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    tatoeba_jpn_id INTEGER,
    tatoeba_ind_id INTEGER,
    japanese_text TEXT NOT NULL,
    indonesian_text TEXT NOT NULL
);

-- 8. TABEL RELASI KOSAKATA DENGAN CONTOH KALIMAT
CREATE TABLE IF NOT EXISTS word_examples_crossref (
    word_id INTEGER NOT NULL REFERENCES words(id) ON DELETE CASCADE,
    sentence_id INTEGER NOT NULL REFERENCES sentence_examples(id) ON DELETE CASCADE,
    PRIMARY KEY (word_id, sentence_id)
);

-- 9. TABEL RELASI KATA DENGAN KANJI
CREATE TABLE IF NOT EXISTS word_kanji_crossref (
    word_id INTEGER NOT NULL REFERENCES words(id) ON DELETE CASCADE,
    kanji_id INTEGER NOT NULL REFERENCES kanji(id) ON DELETE CASCADE,
    PRIMARY KEY (word_id, kanji_id)
);
"""

INDEX_DDL = """
-- INDEX B-TREE UNTUK PREFIX & EXACT LOOKUP CEPAT
CREATE INDEX IF NOT EXISTS idx_words_spelling ON words(primary_spelling);
CREATE INDEX IF NOT EXISTS idx_words_reading ON words(primary_reading);
CREATE INDEX IF NOT EXISTS idx_word_readings_word_id ON word_readings(word_id);
CREATE INDEX IF NOT EXISTS idx_word_readings_hira ON word_readings(reading_hiragana);
CREATE INDEX IF NOT EXISTS idx_word_readings_roma ON word_readings(reading_romaji);
CREATE INDEX IF NOT EXISTS idx_word_senses_word_id ON word_senses(word_id);
CREATE INDEX IF NOT EXISTS idx_word_senses_gloss ON word_senses(gloss_id);
CREATE INDEX IF NOT EXISTS idx_kanji_char ON kanji(character);
CREATE INDEX IF NOT EXISTS idx_kanji_readings_kanji_id ON kanji_readings(kanji_id);
CREATE INDEX IF NOT EXISTS idx_kanji_readings_roma ON kanji_readings(reading_romaji);
CREATE INDEX IF NOT EXISTS idx_kanji_strokes_kanji_id ON kanji_strokes(kanji_id);
CREATE INDEX IF NOT EXISTS idx_word_examples_word_id ON word_examples_crossref(word_id);
CREATE INDEX IF NOT EXISTS idx_word_kanji_word_id ON word_kanji_crossref(word_id);
CREATE INDEX IF NOT EXISTS idx_word_kanji_kanji_id ON word_kanji_crossref(kanji_id);
"""

def load_kanjivg_strokes(kanjivg_path: str) -> Dict[str, List[Tuple[int, str, str]]]:
    print("Memproses KanjiVG XML...")
    strokes_map = {}
    with gzip.open(kanjivg_path, "rb") as f:
        tree = ET.parse(f)
        root = tree.getroot()
        for k in root:
            k_id = k.attrib.get("id", "")
            if not k_id.startswith("kvg:kanji_"):
                continue
            hex_part = k_id.replace("kvg:kanji_", "")
            try:
                char = chr(int(hex_part, 16))
            except ValueError:
                continue
            
            strokes = []
            for idx, p in enumerate(k.iter("path"), start=1):
                d = p.attrib.get("d", "").strip()
                s_type = p.attrib.get("{http://kanjivg.tagaini.net}type", "").strip()
                if d:
                    strokes.append((idx, d, s_type))
            if strokes:
                strokes_map[char] = strokes
    print(f"KanjiVG selesai: {len(strokes_map)} kanji dengan data coretan.")
    return strokes_map

def build_production_database(
    output_db_path: str,
    jaisho_dir: str,
    kanjidic_path: str,
    kanjivg_path: str
) -> Dict[str, Any]:
    t_start = time.time()
    
    if os.path.exists(output_db_path):
        os.remove(output_db_path)
        
    os.makedirs(os.path.dirname(os.path.abspath(output_db_path)), exist_ok=True)
    
    conn = sqlite3.connect(output_db_path)
    conn.execute("PRAGMA synchronous = OFF;")
    conn.execute("PRAGMA journal_mode = OFF;")
    conn.execute("PRAGMA cache_size = 100000;")
    conn.execute("PRAGMA page_size = 4096;")
    conn.execute("PRAGMA user_version = 2;")
    
    conn.executescript(SCHEMA_DDL)
    conn.commit()
    
    # 1. Load KanjiVG Strokes
    kanjivg_map = load_kanjivg_strokes(kanjivg_path)
    
    # 2. Extract single-character meanings from JaIsho
    print("Mengumpulkan arti bahasa Indonesia untuk Kanji dari JaIsho...")
    jaisho_single_kanji_meaning = {}
    jaisho_files = sorted(glob.glob(os.path.join(jaisho_dir, "term_bank_*.json")))
    for jf in jaisho_files:
        with open(jf, "r", encoding="utf-8") as f:
            terms = json.load(f)
            for item in terms:
                term = item[0]
                if len(term) == 1 and 0x4e00 <= ord(term) <= 0x9faf:
                    defs = item[5]
                    if defs:
                        meaning_str = "; ".join(str(d).strip() for d in defs if d)
                        if term not in jaisho_single_kanji_meaning:
                            jaisho_single_kanji_meaning[term] = meaning_str
    print(f"Ditemukan {len(jaisho_single_kanji_meaning)} arti kanji bahasa Indonesia.")
    
    # 3. Parse and Insert KANJIDIC2
    print("Memproses KANJIDIC2 XML dan memasukkan Kanji...")
    kanji_id_map = {}
    with gzip.open(kanjidic_path, "rb") as f:
        tree = ET.parse(f)
        root = tree.getroot()
        
        kanji_batch = []
        readings_batch = []
        strokes_batch = []
        
        k_id_counter = 1
        for char_elem in root.findall("character"):
            lit = char_elem.findtext("literal", "").strip()
            if not lit:
                continue
                
            rad_elem = char_elem.find(".//radical/rad_value[@rad_type='classical']")
            rad_num = int(rad_elem.text) if rad_elem is not None and rad_elem.text else 0
            
            stroke_elem = char_elem.find(".//misc/stroke_count")
            stroke_count = int(stroke_elem.text) if stroke_elem is not None and stroke_elem.text else 0
            
            grade_elem = char_elem.find(".//misc/grade")
            grade = int(grade_elem.text) if grade_elem is not None and grade_elem.text else None
            
            freq_elem = char_elem.find(".//misc/freq")
            freq = int(freq_elem.text) if freq_elem is not None and freq_elem.text else None
            
            jlpt_elem = char_elem.find(".//misc/jlpt")
            jlpt_level = int(jlpt_elem.text) if jlpt_elem is not None and jlpt_elem.text else None
            
            readings = []
            meanings_en = []
            for rm in char_elem.findall(".//reading_meaning/rmgroup"):
                for r in rm.findall("reading"):
                    r_type = r.attrib.get("r_type", "")
                    r_val = r.text.strip() if r.text else ""
                    if not r_val:
                        continue
                    if r_type == "ja_on":
                        readings.append(("onyomi", r_val, ""))
                    elif r_type == "ja_kun":
                        readings.append(("kunyomi", r_val, ""))
                        
                for m in rm.findall("meaning"):
                    if "m_lang" not in m.attrib and m.text:
                        meanings_en.append(m.text.strip())
                        
            meaning_en_str = ", ".join(meanings_en) if meanings_en else None
            meaning_id_str = jaisho_single_kanji_meaning.get(lit) or meaning_en_str or "kanji"
            
            kanji_batch.append((k_id_counter, lit, stroke_count, rad_num, grade, jlpt_level, freq, meaning_id_str, meaning_en_str))
            kanji_id_map[lit] = k_id_counter
            
            for r_type, r_val, r_roma in readings:
                readings_batch.append((k_id_counter, r_type, r_val, r_roma))
                
            if lit in kanjivg_map:
                for s_num, p_data, s_type in kanjivg_map[lit]:
                    strokes_batch.append((k_id_counter, s_num, p_data, s_type))
                    
            k_id_counter += 1
            
        conn.executemany(
            "INSERT INTO kanji (id, character, stroke_count, radical_number, grade, jlpt_level, frequency, meaning_id, meaning_en) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)",
            kanji_batch
        )
        conn.executemany(
            "INSERT INTO kanji_readings (kanji_id, reading_type, reading, reading_romaji) VALUES (?, ?, ?, ?)",
            readings_batch
        )
        conn.executemany(
            "INSERT INTO kanji_strokes (kanji_id, stroke_number, path_data, stroke_type) VALUES (?, ?, ?, ?)",
            strokes_batch
        )
        conn.commit()
    print(f"Berhasil memasukkan {len(kanji_id_map)} kanji!")

    # 4. Process JaIsho Terms
    print("Memproses kosakata JaIsho...")
    word_batch = []
    reading_batch = []
    sense_batch = []
    crossref_batch = []
    
    seen_words: Dict[Tuple[str, str], int] = {}
    word_id_counter = 1
    sense_id_counter = 1
    
    for jf in jaisho_files:
        with open(jf, "r", encoding="utf-8") as f:
            terms = json.load(f)
            for item in terms:
                spelling = normalize_text(item[0])
                reading = normalize_text(item[1])
                pos_tags = str(item[2]).strip()
                defs = item[5]
                
                if not spelling and reading:
                    spelling = reading
                elif not reading and spelling:
                    reading = spelling
                    
                if not spelling:
                    continue
                    
                reading_hiragana = to_hiragana(reading)
                
                key = (spelling, reading)
                if key not in seen_words:
                    w_id = word_id_counter
                    seen_words[key] = w_id
                    word_id_counter += 1
                    
                    word_batch.append((w_id, None, spelling, reading, 1, None))
                    reading_batch.append((w_id, reading, reading_hiragana, "", 1))
                    
                    # Link constituent Kanji
                    for ch in set(spelling):
                        if ch in kanji_id_map:
                            crossref_batch.append((w_id, kanji_id_map[ch]))
                else:
                    w_id = seen_words[key]
                    
                # Add senses
                if defs:
                    for d_idx, d in enumerate(defs, start=1):
                        gloss = str(d).strip()
                        if gloss:
                            sense_batch.append((w_id, d_idx, pos_tags, gloss, None))
                            sense_id_counter += 1
                            
        # Flush every file to keep memory light
        if len(word_batch) >= 10000:
            conn.executemany("INSERT INTO words (id, jmdict_seq, primary_spelling, primary_reading, is_common, jlpt_level) VALUES (?, ?, ?, ?, ?, ?)", word_batch)
            conn.executemany("INSERT INTO word_readings (word_id, reading, reading_hiragana, reading_romaji, is_primary) VALUES (?, ?, ?, ?, ?)", reading_batch)
            conn.executemany("INSERT INTO word_senses (word_id, sense_index, pos_tags, gloss_id, gloss_en) VALUES (?, ?, ?, ?, ?)", sense_batch)
            conn.executemany("INSERT OR IGNORE INTO word_kanji_crossref (word_id, kanji_id) VALUES (?, ?)", crossref_batch)
            conn.commit()
            word_batch.clear()
            reading_batch.clear()
            sense_batch.clear()
            crossref_batch.clear()
            print(f"Tersimpan {len(seen_words)} kata...")

    if word_batch:
        conn.executemany("INSERT INTO words (id, jmdict_seq, primary_spelling, primary_reading, is_common, jlpt_level) VALUES (?, ?, ?, ?, ?, ?)", word_batch)
        conn.executemany("INSERT INTO word_readings (word_id, reading, reading_hiragana, reading_romaji, is_primary) VALUES (?, ?, ?, ?, ?)", reading_batch)
        conn.executemany("INSERT INTO word_senses (word_id, sense_index, pos_tags, gloss_id, gloss_en) VALUES (?, ?, ?, ?, ?)", sense_batch)
        conn.executemany("INSERT OR IGNORE INTO word_kanji_crossref (word_id, kanji_id) VALUES (?, ?)", crossref_batch)
        conn.commit()

    # 5. Insert sample/seed Tatoeba Sentences
    print("Memasukkan contoh kalimat...")
    seed_sentences = [
        (1, 12345, 54321, "私は毎日ご飯を食べます。", "Saya makan nasi setiap hari."),
        (2, 12346, 54322, "水を一杯飲みたいです。", "Saya ingin minum segelas air."),
        (3, 12347, 54323, "日本へ旅行に行きたいです。", "Saya ingin pergi berlibur ke Jepang."),
        (4, 12348, 54324, "先生に質問をしました。", "Saya bertanya kepada guru."),
        (5, 12349, 54325, "この辞書はとても役に立ちます。", "Kamus ini sangat bermanfaat.")
    ]
    conn.executemany("INSERT INTO sentence_examples (id, tatoeba_jpn_id, tatoeba_ind_id, japanese_text, indonesian_text) VALUES (?, ?, ?, ?, ?)", seed_sentences)
    
    # Cross reference sentences with common words
    for s_id, _, _, jpn_text, _ in seed_sentences:
        for (spelling, _), w_id in seen_words.items():
            if len(spelling) >= 2 and spelling in jpn_text:
                conn.execute("INSERT OR IGNORE INTO word_examples_crossref (word_id, sentence_id) VALUES (?, ?)", (w_id, s_id))
    conn.commit()

    # 6. Build Indexes
    print("Membangun indeks B-Tree untuk pencarian cepat...")
    conn.executescript(INDEX_DDL)
    conn.commit()
    
    # 7. Finalize & Manifest
    print("Menjalankan PRAGMA optimize & integrity check...")
    conn.execute("PRAGMA optimize;")
    res = conn.execute("PRAGMA integrity_check;").fetchone()
    print("Integrity check:", res[0])
    
    conn.close()
    
    file_size_mb = os.path.getsize(output_db_path) / (1024 * 1024)
    print(f"Database selesai dibuat! Ukuran file: {file_size_mb:.2f} MB")
    
    sha256 = hashlib.sha256()
    with open(output_db_path, "rb") as f:
        for chunk in iter(lambda: f.read(65536), b""):
            sha256.update(chunk)
            
    manifest = {
        "version_code": 2,
        "version_name": "2.0.0-full",
        "sha256": sha256.hexdigest(),
        "file_size_mb": round(file_size_mb, 2),
        "counts": {
            "words": len(seen_words),
            "kanji": len(kanji_id_map),
            "kanji_with_strokes": len(kanjivg_map)
        },
        "build_time_seconds": round(time.time() - t_start, 2)
    }
    
    manifest_path = output_db_path + ".manifest.json"
    with open(manifest_path, "w", encoding="utf-8") as f:
        json.dump(manifest, f, indent=2, ensure_ascii=False)
        
    print("Manifest:", json.dumps(manifest, indent=2))
    return manifest

if __name__ == "__main__":
    build_production_database(
        output_db_path="tools/etl/data/full_dictionary.db",
        jaisho_dir="tools/etl/data/jaisho",
        kanjidic_path="tools/etl/data/kanjidic2.xml.gz",
        kanjivg_path="tools/etl/data/kanjivg.xml.gz"
    )
