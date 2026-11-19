import unittest
from tools.etl.tatoeba_linker import parse_tatoeba_tsv_line, link_sentence_to_words, ParsedSentence
from tools.etl.jaisho_parser import ParsedWord, ParsedSense

class TestTatoebaLinker(unittest.TestCase):
    def test_parse_tatoeba_tsv_line(self):
        # Format: jpn_id \t jpn_text \t ind_id \t ind_text
        tsv_line = "12345\t私はりんごを食べます。\t67890\tSaya makan apel."
        sentence = parse_tatoeba_tsv_line(tsv_line)
        self.assertIsNotNone(sentence)
        self.assertEqual(sentence.tatoeba_jpn_id, 12345)
        self.assertEqual(sentence.japanese_text, "私はりんごを食べます。")
        self.assertEqual(sentence.tatoeba_ind_id, 67890)
        self.assertEqual(sentence.indonesian_text, "Saya makan apel.")

    def test_parse_tatoeba_invalid_line(self):
        # Malformed line or missing columns
        bad_line = "12345\t私はりんごを食べます。"
        self.assertIsNone(parse_tatoeba_tsv_line(bad_line))

    def test_link_sentence_to_words(self):
        sentence = ParsedSentence(
            tatoeba_jpn_id=101,
            japanese_text="毎朝パンを食べます。",
            tatoeba_ind_id=202,
            indonesian_text="Saya makan roti setiap pagi."
        )

        word_taberu = ParsedWord(
            jmdict_seq="1001",
            primary_spelling="食べる",
            primary_reading="たべる",
            reading_hiragana="たべる",
            reading_romaji="taberu",
            is_common=True,
            jlpt_level=5,
            senses=[]
        )

        word_pan = ParsedWord(
            jmdict_seq="1002",
            primary_spelling="パン",
            primary_reading="パン",
            reading_hiragana="ぱん",
            reading_romaji="pan",
            is_common=True,
            jlpt_level=5,
            senses=[]
        )

        word_mizu = ParsedWord(
            jmdict_seq="1003",
            primary_spelling="水",
            primary_reading="みず",
            reading_hiragana="みず",
            reading_romaji="mizu",
            is_common=True,
            jlpt_level=5,
            senses=[]
        )

        vocab_index = [word_taberu, word_pan, word_mizu]
        matched_words = link_sentence_to_words(sentence, vocab_index)

        # "毎朝パンを食べます。" contains "パン" and stem/form of "食べる"
        spelling_matches = [w.primary_spelling for w in matched_words]
        self.assertIn("パン", spelling_matches)
        self.assertIn("食べる", spelling_matches)
        self.assertNotIn("水", spelling_matches)

if __name__ == "__main__":
    unittest.main()
