import unittest
import os
import tempfile
import sqlite3
from tools.etl.database_builder import DatabaseBuilder
from tools.etl.jaisho_parser import ParsedWord, ParsedSense
from tools.etl.kanji_parser import ParsedKanji, ParsedKanjiReading, ParsedStroke
from tools.etl.tatoeba_linker import ParsedSentence

class TestDatabaseBuilder(unittest.TestCase):
    def setUp(self):
        self.temp_dir = tempfile.TemporaryDirectory()
        self.db_path = os.path.join(self.temp_dir.name, "test_dictionary.db")
        self.builder = DatabaseBuilder(self.db_path)

    def tearDown(self):
        self.builder.close()
        self.temp_dir.cleanup()

    def test_schema_creation_and_integrity(self):
        self.builder.create_schema()
        self.assertTrue(self.builder.verify_integrity())

    def test_insert_and_query_word_and_fts(self):
        self.builder.create_schema()
        
        sample_word = ParsedWord(
            jmdict_seq="1358280",
            primary_spelling="食べる",
            primary_reading="たべる",
            reading_hiragana="たべる",
            reading_romaji="taberu",
            is_common=True,
            jlpt_level=5,
            senses=[
                ParsedSense(sense_index=1, pos_tags="v1, vt", gloss_id="makan; mengonsumsi", gloss_en="to eat")
            ]
        )

        word_id = self.builder.insert_word(sample_word)
        self.assertGreater(word_id, 0)
        
        # Test query via SQLite cursor
        cursor = self.builder.conn.cursor()
        cursor.execute("SELECT primary_spelling, primary_reading, is_common FROM words WHERE id = ?", (word_id,))
        row = cursor.fetchone()
        self.assertEqual(row[0], "食べる")
        self.assertEqual(row[1], "たべる")
        self.assertEqual(row[2], 1)

        # Test search for Indonesian gloss "makan"
        cursor.execute("""
            SELECT w.primary_spelling, s.gloss_id 
            FROM word_senses s
            JOIN words w ON s.word_id = w.id
            WHERE s.gloss_id LIKE '%makan%'
        """)
        search_result = cursor.fetchall()
        self.assertEqual(len(search_result), 1)
        self.assertEqual(search_result[0][0], "食べる")

    def test_insert_kanji_and_strokes(self):
        self.builder.create_schema()

        kanji = ParsedKanji(
            character="食",
            stroke_count=9,
            radical_number=184,
            grade=2,
            jlpt_level=5,
            frequency=336,
            readings=[
                ParsedKanjiReading(reading_type="onyomi", reading="ショク", reading_romaji="shoku"),
                ParsedKanjiReading(reading_type="kunyomi", reading="た.べる", reading_romaji="taberu")
            ],
            meanings_en=["eat", "food"]
        )

        strokes = [
            ParsedStroke(stroke_number=1, path_data="M51.5,12.25", stroke_type="㇒"),
            ParsedStroke(stroke_number=2, path_data="M52.75,17.75", stroke_type="㇏")
        ]

        kanji_id = self.builder.insert_kanji(kanji, meaning_id="makan, makanan", strokes=strokes)
        self.assertGreater(kanji_id, 0)

        cursor = self.builder.conn.cursor()
        cursor.execute("SELECT character, meaning_id FROM kanji WHERE id = ?", (kanji_id,))
        row = cursor.fetchone()
        self.assertEqual(row[0], "食")
        self.assertEqual(row[1], "makan, makanan")

        cursor.execute("SELECT stroke_number, path_data FROM kanji_strokes WHERE kanji_id = ? ORDER BY stroke_number", (kanji_id,))
        stroke_rows = cursor.fetchall()
        self.assertEqual(len(stroke_rows), 2)
        self.assertEqual(stroke_rows[0][0], 1)
        self.assertEqual(stroke_rows[0][1], "M51.5,12.25")

    def test_manifest_generation(self):
        self.builder.create_schema()
        manifest = self.builder.generate_manifest(version_code=1, version_name="1.0.0")
        self.assertEqual(manifest["version_code"], 1)
        self.assertIn("sha256", manifest)
        self.assertEqual(len(manifest["sha256"]), 64)

if __name__ == "__main__":
    unittest.main()
