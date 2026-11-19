import os
import sys
import argparse
import json

# Ensure project root is in sys.path
sys.path.insert(0, os.path.dirname(os.path.dirname(os.path.dirname(os.path.abspath(__file__)))))

from typing import Dict, Any
from tools.etl.database_builder import DatabaseBuilder
from tools.etl.jaisho_parser import ParsedWord, ParsedSense
from tools.etl.kanji_parser import ParsedKanji, ParsedKanjiReading, ParsedStroke
from tools.etl.tatoeba_linker import ParsedSentence

SEED_WORDS = [
    ParsedWord(
        jmdict_seq="1358280",
        primary_spelling="食べる",
        primary_reading="たべる",
        reading_hiragana="たべる",
        reading_romaji="taberu",
        is_common=True,
        jlpt_level=5,
        senses=[
            ParsedSense(1, "v1, vt", "makan; mengonsumsi", "to eat"),
            ParsedSense(2, "v1, vi", "mencari nafkah; bertahan hidup", "to make a living")
        ]
    ),
    ParsedWord(
        jmdict_seq="1195650",
        primary_spelling="飲む",
        primary_reading="のむ",
        reading_hiragana="のむ",
        reading_romaji="nomu",
        is_common=True,
        jlpt_level=5,
        senses=[
            ParsedSense(1, "v5m, vt", "minum", "to drink"),
            ParsedSense(2, "v5m, vt", "menelan (obat)", "to take medicine")
        ]
    ),
    ParsedWord(
        jmdict_seq="1445210",
        primary_spelling="日本",
        primary_reading="にほん",
        reading_hiragana="にほん",
        reading_romaji="nihon",
        is_common=True,
        jlpt_level=5,
        senses=[
            ParsedSense(1, "n", "Jepang; Negeri Sakura", "Japan")
        ]
    ),
    ParsedWord(
        jmdict_seq="1271120",
        primary_spelling="言葉",
        primary_reading="ことば",
        reading_hiragana="ことば",
        reading_romaji="kotoba",
        is_common=True,
        jlpt_level=5,
        senses=[
            ParsedSense(1, "n", "kata; bahasa; perkataan", "word; language")
        ]
    ),
    ParsedWord(
        jmdict_seq="1476720",
        primary_spelling="本",
        primary_reading="ほん",
        reading_hiragana="ほん",
        reading_romaji="hon",
        is_common=True,
        jlpt_level=5,
        senses=[
            ParsedSense(1, "n", "buku; jilid", "book"),
            ParsedSense(2, "pref, suf", "pokok; asal; batang", "main; origin")
        ]
    ),
    ParsedWord(
        jmdict_seq="1512830",
        primary_spelling="水",
        primary_reading="みず",
        reading_hiragana="みず",
        reading_romaji="mizu",
        is_common=True,
        jlpt_level=5,
        senses=[
            ParsedSense(1, "n", "air; air dingin", "water; cold water")
        ]
    ),
    ParsedWord(
        jmdict_seq="1098450",
        primary_spelling="パン",
        primary_reading="パン",
        reading_hiragana="ぱん",
        reading_romaji="pan",
        is_common=True,
        jlpt_level=5,
        senses=[
            ParsedSense(1, "n", "roti", "bread")
        ]
    ),
    ParsedWord(
        jmdict_seq="1361250",
        primary_spelling="辞書",
        primary_reading="じしょ",
        reading_hiragana="じしょ",
        reading_romaji="jisho",
        is_common=True,
        jlpt_level=5,
        senses=[
            ParsedSense(1, "n", "kamus; leksikon", "dictionary; lexicon")
        ]
    ),
    ParsedWord(
        jmdict_seq="1382990",
        primary_spelling="先生",
        primary_reading="せんせい",
        reading_hiragana="せんせい",
        reading_romaji="sensei",
        is_common=True,
        jlpt_level=5,
        senses=[
            ParsedSense(1, "n", "guru; dosen; instruktur; dokter", "teacher; master; doctor")
        ]
    ),
    ParsedWord(
        jmdict_seq="1203490",
        primary_spelling="学生",
        primary_reading="がくせい",
        reading_hiragana="がくせい",
        reading_romaji="gakusei",
        is_common=True,
        jlpt_level=5,
        senses=[
            ParsedSense(1, "n", "pelajar; siswa; mahasiswa", "student")
        ]
    ),
]

SEED_KANJI = [
    (
        ParsedKanji(
            character="食",
            stroke_count=9,
            radical_number=184,
            grade=2,
            jlpt_level=5,
            frequency=336,
            readings=[
                ParsedKanjiReading("onyomi", "ショク", "shoku"),
                ParsedKanjiReading("onyomi", "ジキ", "jiki"),
                ParsedKanjiReading("kunyomi", "た.べる", "taberu"),
                ParsedKanjiReading("kunyomi", "く.う", "kuu")
            ],
            meanings_en=["eat", "food"]
        ),
        "makan, makanan, santapan",
        [
            ParsedStroke(1, "M51.5,12.25c0.07,0.85,0.29,2.25-0.15,3.41C48.5,23.25,37.25,37.5,18.75,48", "㇒"),
            ParsedStroke(2, "M52.75,17.75c5.38,4.72,25.34,22.28,32.48,27.06c2.42,1.62,4.4,2.32,6.77,2.78", "㇏"),
            ParsedStroke(3, "M49.49,36.75c0.88,0.88,1.21,2,1.21,3.25c0,4.25-0.08,9.75-0.08,13.75", "㇑"),
            ParsedStroke(4, "M37.5,45.25c0.75,0.75,1.25,1.75,1.48,2.75c0.88,3.75,1.52,7.25,2.27,11.25", "㇑"),
            ParsedStroke(5, "M39.75,47.25c7.25-1.25,24.25-3.5,28.25-3.75c2.75-0.17,3.5,1.25,3.25,3.25c-0.5,4-1.5,8-2.5,11.25", "㇇"),
            ParsedStroke(6, "M42,57.75c6.5-0.75,20.25-2.25,28.25-2.75", "㇐"),
            ParsedStroke(7, "M34,68.75c1.25,0.5,3.5,0.75,4.75,0.5c9.25-1.5,26.5-3.5,35.25-4c2-0.12,3.25,0.25,4.25,0.5", "㇐"),
            ParsedStroke(8, "M41.75,71.25c0.88,0.88,1.25,2.12,1.25,3.5c0,5.25,0.12,14.5,0.12,17.25c0,3,1.12,3.75,3.38,2.25c3-2,8-5.75,11-8", "𠄌"),
            ParsedStroke(9, "M64.75,69.5c0.88,1.12,1.25,2.38,1.25,3.88c0,4.62,0.12,16.88,0.12,19.88c0,2.5-1.5,3.5-3.75,1.5", "㇑")
        ]
    ),
    (
        ParsedKanji(
            character="本",
            stroke_count=5,
            radical_number=75,
            grade=1,
            jlpt_level=5,
            frequency=10,
            readings=[
                ParsedKanjiReading("onyomi", "ホン", "hon"),
                ParsedKanjiReading("kunyomi", "もと", "moto")
            ],
            meanings_en=["book", "origin", "main"]
        ),
        "buku, asal-usul, pokok",
        [
            ParsedStroke(1, "M18.75,39.5c1.75,0.62,4.88,0.38,6.75,0.12c14.75-1.88,43.25-4.88,58.75-5.88c2.88-0.18,4.62,0.12,6.12,0.38", "㇐"),
            ParsedStroke(2, "M52.75,13.75c1.12,1.12,1.62,2.62,1.62,4.25c0,9.75-0.12,65.25-0.12,71.75c0,11.5-5.25,3.25-6.75,1.75", "㇑"),
            ParsedStroke(3, "M52.25,40.5c-6.88,12.25-22.12,28.88-34.75,36.5", "㇒"),
            ParsedStroke(4, "M55.75,44.75c6.5,7.5,23.38,22.12,31.75,28c2.38,1.68,4.25,2.62,6.75,3.25", "㇏"),
            ParsedStroke(5, "M33.25,75.25c1.75,0.62,3.88,0.5,5.62,0.25c8.38-1.25,18.88-2.62,27.12-3.38c1.75-0.16,3.38,0.12,4.75,0.38", "㇐")
        ]
    ),
    (
        ParsedKanji(
            character="日",
            stroke_count=4,
            radical_number=72,
            grade=1,
            jlpt_level=5,
            frequency=1,
            readings=[
                ParsedKanjiReading("onyomi", "ニチ", "nichi"),
                ParsedKanjiReading("onyomi", "ジツ", "jitsu"),
                ParsedKanjiReading("kunyomi", "ひ", "hi"),
                ParsedKanjiReading("kunyomi", "-び", "bi"),
                ParsedKanjiReading("kunyomi", "-か", "ka")
            ],
            meanings_en=["day", "sun", "Japan"]
        ),
        "hari, matahari, Jepang",
        [
            ParsedStroke(1, "M30,19.25c0.88,0.88,1.38,2.25,1.38,3.75c0,13.25-0.12,49.25-0.12,65.5", "㇑"),
            ParsedStroke(2, "M32.25,21.5c6.25-0.88,34.25-4,39.5-4.5c3.25-0.31,4.75,1.25,4.75,3.75c0,12.75-0.25,46.5-0.25,64.25", "𠃍"),
            ParsedStroke(3, "M32.75,52.25c8.75-1,34.5-3.5,42.25-3.75", "㇐"),
            ParsedStroke(4, "M32.75,85.5c9.25-0.75,32.25-2.25,42.25-2.75", "㇐")
        ]
    ),
]

SEED_SENTENCES = [
    ParsedSentence(1, "私は毎朝パンを食べます。", 101, "Saya makan roti setiap pagi."),
    ParsedSentence(2, "冷たい水を一杯飲みました。", 102, "Saya minum segelas air dingin."),
    ParsedSentence(3, "日本の言葉と文化を勉強しています。", 103, "Saya sedang belajar bahasa dan budaya Jepang."),
    ParsedSentence(4, "この辞書はとても役に立ちます。", 104, "Kamus ini sangat bermanfaat."),
    ParsedSentence(5, "先生は学生に日本語を教えます。", 105, "Guru mengajar bahasa Jepang kepada para siswa."),
]

def generate_seed_database(output_path: str) -> Dict[str, Any]:
    """Builds a complete offline SQLite dictionary database populated with seed entries."""
    os.makedirs(os.path.dirname(os.path.abspath(output_path)), exist_ok=True)
    if os.path.exists(output_path):
        os.remove(output_path)
        
    builder = DatabaseBuilder(output_path)
    builder.create_schema()
    
    # 1. Insert Words
    word_id_map = {}
    for word in SEED_WORDS:
        w_id = builder.insert_word(word)
        word_id_map[word.primary_spelling] = w_id
        
    # 2. Insert Kanji
    kanji_id_map = {}
    for kanji_obj, meaning_id, strokes in SEED_KANJI:
        k_id = builder.insert_kanji(kanji_obj, meaning_id, strokes)
        kanji_id_map[kanji_obj.character] = k_id
        
    # 3. Cross-reference words and kanji
    for spelling, w_id in word_id_map.items():
        for char in spelling:
            if char in kanji_id_map:
                builder.link_word_kanji(w_id, kanji_id_map[char])
                
    # 4. Insert sentences and cross-reference with words
    for sent in SEED_SENTENCES:
        s_id = builder.insert_sentence(sent)
        for spelling, w_id in word_id_map.items():
            if spelling in sent.japanese_text:
                builder.link_word_sentence(w_id, s_id)
            elif len(spelling) >= 2 and spelling.endswith(("る", "む")):
                stem = spelling[:-1]
                if stem in sent.japanese_text:
                    builder.link_word_sentence(w_id, s_id)
                    
    manifest = builder.generate_manifest(version_code=1, version_name="1.0.0")
    builder.close()
    
    # Write manifest file
    manifest_path = output_path + ".manifest.json"
    with open(manifest_path, "w", encoding="utf-8") as f:
        json.dump(manifest, f, indent=2, ensure_ascii=False)
        
    return manifest

if __name__ == "__main__":
    parser = argparse.ArgumentParser(description="Build Nihongo Dictionary SQLite Database")
    parser.add_argument("--output", default="tools/etl/data/dictionary.db", help="Path to output SQLite database")
    args = parser.parse_args()
    
    print(f"Generating SQLite database at: {args.output}")
    m = generate_seed_database(args.output)
    print(f"Database generation complete!")
    print(f"Manifest: {json.dumps(m, indent=2)}")
