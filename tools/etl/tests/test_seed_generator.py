import unittest
import os
import tempfile
import sqlite3
from tools.etl.build_dictionary import generate_seed_database

class TestSeedGenerator(unittest.TestCase):
    def setUp(self):
        self.temp_dir = tempfile.TemporaryDirectory()
        self.db_path = os.path.join(self.temp_dir.name, "seed_dictionary.db")

    def tearDown(self):
        self.temp_dir.cleanup()

    def test_generate_seed_database(self):
        manifest = generate_seed_database(self.db_path)
        self.assertTrue(os.path.exists(self.db_path))
        self.assertGreater(manifest["counts"]["words"], 0)
        self.assertGreater(manifest["counts"]["kanji"], 0)
        self.assertGreater(manifest["counts"]["sentences"], 0)
        
        # Verify SQLite integrity
        conn = sqlite3.connect(self.db_path)
        cursor = conn.cursor()
        cursor.execute("PRAGMA integrity_check;")
        self.assertEqual(cursor.fetchone()[0].lower(), "ok")
        
        # Verify word senses populated
        cursor.execute("SELECT COUNT(*) FROM word_senses;")
        self.assertGreater(cursor.fetchone()[0], 0)
        conn.close()

if __name__ == "__main__":
    unittest.main()
