import unittest
from tools.etl.kanji_parser import parse_kanjidic_entry, parse_kanjivg_svg, ParsedKanji, ParsedStroke

SAMPLE_KANJIDIC_XML = """
<character>
    <literal>食</literal>
    <codepoint>
        <cp_value cp_type="ucs">98df</cp_value>
    </codepoint>
    <radical>
        <rad_value rad_type="classical">184</rad_value>
    </radical>
    <misc>
        <grade>2</grade>
        <stroke_count>9</stroke_count>
        <freq>336</freq>
        <jlpt>4</jlpt>
    </misc>
    <reading_meaning>
        <rmgroup>
            <reading r_type="ja_on">ショク</reading>
            <reading r_type="ja_on">ジキ</reading>
            <reading r_type="ja_kun">た.べる</reading>
            <reading r_type="ja_kun">く.う</reading>
            <meaning>eat</meaning>
            <meaning>food</meaning>
            <meaning m_lang="fr">manger</meaning>
        </rmgroup>
    </reading_meaning>
</character>
"""

SAMPLE_KANJIVG_SVG = """
<svg xmlns="http://www.w3.org/2000/svg" width="109" height="109" viewBox="0 0 109 109">
<g id="kvg:StrokePaths_098df" style="fill:none;stroke:#000000;stroke-width:3">
    <g id="kvg:098df" kvg:element="食">
        <path id="kvg:098df-s1" kvg:type="㇒" d="M51.5,12.25c0.07,0.85,0.29,2.25-0.15,3.41C48.5,23.25,37.25,37.5,18.75,48"/>
        <path id="kvg:098df-s2" kvg:type="㇏" d="M52.75,17.75c5.38,4.72,25.34,22.28,32.48,27.06c2.42,1.62,4.4,2.32,6.77,2.78"/>
        <path id="kvg:098df-s3" kvg:type="㇑" d="M49.49,36.75c0.88,0.88,1.21,2,1.21,3.25c0,4.25-0.08,9.75-0.08,13.75"/>
    </g>
</g>
</svg>
"""

class TestKanjiParser(unittest.TestCase):
    def test_parse_kanjidic_entry(self):
        kanji = parse_kanjidic_entry(SAMPLE_KANJIDIC_XML)
        self.assertIsInstance(kanji, ParsedKanji)
        self.assertEqual(kanji.character, "食")
        self.assertEqual(kanji.stroke_count, 9)
        self.assertEqual(kanji.radical_number, 184)
        self.assertEqual(kanji.grade, 2)
        self.assertEqual(kanji.frequency, 336)
        # Old JLPT 4 maps to N5
        self.assertEqual(kanji.jlpt_level, 5)
        
        onyomi = [r.reading for r in kanji.readings if r.reading_type == "onyomi"]
        kunyomi = [r.reading for r in kanji.readings if r.reading_type == "kunyomi"]
        self.assertIn("ショク", onyomi)
        self.assertIn("た.べる", kunyomi)
        self.assertIn("eat", kanji.meanings_en)

    def test_parse_kanjivg_svg(self):
        strokes = parse_kanjivg_svg(SAMPLE_KANJIVG_SVG)
        self.assertEqual(len(strokes), 3)
        self.assertIsInstance(strokes[0], ParsedStroke)
        self.assertEqual(strokes[0].stroke_number, 1)
        self.assertTrue(strokes[0].path_data.startswith("M51.5"))
        self.assertEqual(strokes[0].stroke_type, "㇒")
        self.assertEqual(strokes[1].stroke_number, 2)
        self.assertEqual(strokes[2].stroke_number, 3)

if __name__ == "__main__":
    unittest.main()
