import sqlite3
import hashlib
import json
import os
from typing import List, Optional, Dict, Any
from tools.etl.jaisho_parser import ParsedWord
from tools.etl.kanji_parser import ParsedKanji, ParsedStroke
from tools.etl.tatoeba_linker import ParsedSentence

SCHEMA_SQL = """
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

-- 10. INDEX B-TREE UNTUK PREFIX & EXACT LOOKUP CEPAT
CREATE INDEX IF NOT EXISTS idx_words_spelling ON words(primary_spelling);
CREATE INDEX IF NOT EXISTS idx_words_reading ON words(primary_reading);
CREATE INDEX IF NOT EXISTS idx_word_readings_hira ON word_readings(reading_hiragana);
CREATE INDEX IF NOT EXISTS idx_word_readings_roma ON word_readings(reading_romaji);
CREATE INDEX IF NOT EXISTS idx_kanji_char ON kanji(character);
CREATE INDEX IF NOT EXISTS idx_kanji_readings_roma ON kanji_readings(reading_romaji);

-- 11. VIRTUAL TABLE FULL-TEXT SEARCH (FTS5)
CREATE VIRTUAL TABLE IF NOT EXISTS fts_word_senses USING fts5(
    gloss_id,
    content='word_senses',
    content_rowid='id',
    tokenize='unicode61 remove_diacritics 2'
);

-- Triggers to automatically populate FTS5 on insert
CREATE TRIGGER IF NOT EXISTS trg_word_senses_insert AFTER INSERT ON word_senses BEGIN
    INSERT INTO fts_word_senses(rowid, gloss_id) VALUES (new.id, new.gloss_id);
END;

CREATE VIRTUAL TABLE IF NOT EXISTS fts_sentences USING fts5(
    japanese_text,
    indonesian_text,
    content='sentence_examples',
    content_rowid='id',
    tokenize='trigram'
);

CREATE TRIGGER IF NOT EXISTS trg_sentences_insert AFTER INSERT ON sentence_examples BEGIN
    INSERT INTO fts_sentences(rowid, japanese_text, indonesian_text) VALUES (new.id, new.japanese_text, new.indonesian_text);
END;
"""

class DatabaseBuilder:
    def __init__(self, db_path: str):
        self.db_path = db_path
        self.conn = sqlite3.connect(db_path)
        self.conn.execute("PRAGMA foreign_keys = ON;")
        self.conn.execute("PRAGMA page_size = 4096;")
        self.conn.execute("PRAGMA user_version = 1;")

    def create_schema(self):
        """Creates the relational and virtual FTS5 tables and indexes."""
        self.conn.executescript(SCHEMA_SQL)
        self.conn.commit()

    def insert_word(self, word: ParsedWord) -> int:
        """Inserts a word, its readings, and its senses."""
        cursor = self.conn.cursor()
        cursor.execute(
            """
            INSERT INTO words (jmdict_seq, primary_spelling, primary_reading, is_common, jlpt_level)
            VALUES (?, ?, ?, ?, ?)
            """,
            (
                word.jmdict_seq,
                word.primary_spelling,
                word.primary_reading,
                1 if word.is_common else 0,
                word.jlpt_level
            )
        )
        word_id = cursor.lastrowid
        
        # Insert primary reading
        cursor.execute(
            """
            INSERT INTO word_readings (word_id, reading, reading_hiragana, reading_romaji, is_primary)
            VALUES (?, ?, ?, ?, 1)
            """,
            (word_id, word.primary_reading, word.reading_hiragana, word.reading_romaji)
        )
        
        # Insert senses
        for sense in word.senses:
            cursor.execute(
                """
                INSERT INTO word_senses (word_id, sense_index, pos_tags, gloss_id, gloss_en)
                VALUES (?, ?, ?, ?, ?)
                """,
                (word_id, sense.sense_index, sense.pos_tags, sense.gloss_id, sense.gloss_en)
            )
            
        self.conn.commit()
        return word_id

    def insert_kanji(self, kanji: ParsedKanji, meaning_id: str, strokes: Optional[List[ParsedStroke]] = None) -> int:
        """Inserts a kanji record, its readings, and its stroke paths."""
        cursor = self.conn.cursor()
        meaning_en = ", ".join(kanji.meanings_en) if kanji.meanings_en else None
        
        cursor.execute(
            """
            INSERT INTO kanji (character, stroke_count, radical_number, grade, jlpt_level, frequency, meaning_id, meaning_en)
            VALUES (?, ?, ?, ?, ?, ?, ?, ?)
            """,
            (
                kanji.character,
                kanji.stroke_count,
                kanji.radical_number,
                kanji.grade,
                kanji.jlpt_level,
                kanji.frequency,
                meaning_id,
                meaning_en
            )
        )
        kanji_id = cursor.lastrowid
        
        for r in kanji.readings:
            cursor.execute(
                """
                INSERT INTO kanji_readings (kanji_id, reading_type, reading, reading_romaji)
                VALUES (?, ?, ?, ?)
                """,
                (kanji_id, r.reading_type, r.reading, r.reading_romaji)
            )
            
        if strokes:
            for s in strokes:
                cursor.execute(
                    """
                    INSERT INTO kanji_strokes (kanji_id, stroke_number, path_data, stroke_type)
                    VALUES (?, ?, ?, ?)
                    """,
                    (kanji_id, s.stroke_number, s.path_data, s.stroke_type)
                )
                
        self.conn.commit()
        return kanji_id

    def insert_sentence(self, sentence: ParsedSentence) -> int:
        """Inserts a sentence pair."""
        cursor = self.conn.cursor()
        cursor.execute(
            """
            INSERT INTO sentence_examples (tatoeba_jpn_id, tatoeba_ind_id, japanese_text, indonesian_text)
            VALUES (?, ?, ?, ?)
            """,
            (sentence.tatoeba_jpn_id, sentence.tatoeba_ind_id, sentence.japanese_text, sentence.indonesian_text)
        )
        sentence_id = cursor.lastrowid
        self.conn.commit()
        return sentence_id

    def link_word_sentence(self, word_id: int, sentence_id: int):
        cursor = self.conn.cursor()
        cursor.execute(
            "INSERT OR IGNORE INTO word_examples_crossref (word_id, sentence_id) VALUES (?, ?)",
            (word_id, sentence_id)
        )
        self.conn.commit()

    def link_word_kanji(self, word_id: int, kanji_id: int):
        cursor = self.conn.cursor()
        cursor.execute(
            "INSERT OR IGNORE INTO word_kanji_crossref (word_id, kanji_id) VALUES (?, ?)",
            (word_id, kanji_id)
        )
        self.conn.commit()

    def verify_integrity(self) -> bool:
        """Runs PRAGMA integrity_check on the database."""
        cursor = self.conn.cursor()
        cursor.execute("PRAGMA integrity_check;")
        res = cursor.fetchone()
        return res is not None and res[0].lower() == "ok"

    def generate_manifest(self, version_code: int = 1, version_name: str = "1.0.0") -> Dict[str, Any]:
        """Flushes database and generates a SHA-256 checksum manifest."""
        self.conn.commit()
        
        # Calculate SHA256 of the database file
        sha256 = hashlib.sha256()
        with open(self.db_path, "rb") as f:
            for chunk in iter(lambda: f.read(65536), b""):
                sha256.update(chunk)
                
        cursor = self.conn.cursor()
        cursor.execute("SELECT COUNT(*) FROM words;")
        word_count = cursor.fetchone()[0]
        cursor.execute("SELECT COUNT(*) FROM kanji;")
        kanji_count = cursor.fetchone()[0]
        cursor.execute("SELECT COUNT(*) FROM sentence_examples;")
        sentence_count = cursor.fetchone()[0]
        
        manifest = {
            "version_code": version_code,
            "version_name": version_name,
            "sha256": sha256.hexdigest(),
            "counts": {
                "words": word_count,
                "kanji": kanji_count,
                "sentences": sentence_count
            }
        }
        return manifest

    def close(self):
        self.conn.close()
