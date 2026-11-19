import unittest
from tools.etl.normalizer import normalize_text, to_hiragana, romaji_to_hiragana
from tools.etl.jaisho_parser import parse_jaisho_entry, ParsedWord, ParsedSense

class TestJaIshoParser(unittest.TestCase):
    def test_normalize_text_nfkc(self):
        # Half-width katakana to standard full-width katakana
        self.assertEqual(normalize_text("ﾀﾍﾞﾙ"), "タベル")
        # Full-width alphanumeric to standard ASCII
        self.assertEqual(normalize_text("ｔａｂｅｒｕ"), "taberu")
        # Trailing/leading whitespace stripped
        self.assertEqual(normalize_text("  食べる  "), "食べる")

    def test_to_hiragana(self):
        # Katakana to Hiragana conversion
        self.assertEqual(to_hiragana("タベル"), "たべる")
        self.assertEqual(to_hiragana("ラーメン"), "らーめん")
        self.assertEqual(to_hiragana("たべる"), "たべる")

    def test_romaji_to_hiragana(self):
        # Basic romaji conversion
        self.assertEqual(romaji_to_hiragana("taberu"), "たべる")
        self.assertEqual(romaji_to_hiragana("nihon"), "にほん")
        self.assertEqual(romaji_to_hiragana("gakkou"), "がっこう")
        self.assertEqual(romaji_to_hiragana("shimbun"), "しんぶん")
        self.assertEqual(romaji_to_hiragana("sensei"), "せんせい")

    def test_parse_jaisho_entry(self):
        # Sample JaIsho raw JSON format
        sample_entry = {
            "id": "1358280",
            "kanji": "食べる",
            "reading": "たべる",
            "common": True,
            "jlpt": 5,
            "meanings": [
                {
                    "pos": ["v1", "vt"],
                    "gloss": "makan; mengonsumsi"
                },
                {
                    "pos": ["v1"],
                    "gloss": "hidup dari; mencari nafkah"
                }
            ]
        }

        parsed = parse_jaisho_entry(sample_entry)
        self.assertIsInstance(parsed, ParsedWord)
        self.assertEqual(parsed.primary_spelling, "食べる")
        self.assertEqual(parsed.primary_reading, "たべる")
        self.assertTrue(parsed.is_common)
        self.assertEqual(parsed.jlpt_level, 5)
        self.assertEqual(len(parsed.senses), 2)
        self.assertEqual(parsed.senses[0].gloss_id, "makan; mengonsumsi")
        self.assertEqual(parsed.senses[0].pos_tags, "v1, vt")

if __name__ == "__main__":
    unittest.main()
