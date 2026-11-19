package id.nihongodictionary.app.core.common

import org.junit.Assert.assertEquals
import org.junit.Test

class JapaneseSearchNormalizerTest {

    @Test
    fun testNormalizeNfkc() {
        assertEquals("taberu", JapaneseSearchNormalizer.normalize("ｔａｂｅｒｕ"))
        assertEquals("たべる", JapaneseSearchNormalizer.normalize("  たべる  "))
    }

    @Test
    fun testToHiragana() {
        assertEquals("たべる", JapaneseSearchNormalizer.toHiragana("タベル"))
        assertEquals("らーめん", JapaneseSearchNormalizer.toHiragana("ラーメン"))
    }

    @Test
    fun testRomajiToHiragana() {
        assertEquals("たべる", JapaneseSearchNormalizer.romajiToHiragana("taberu"))
        assertEquals("にほん", JapaneseSearchNormalizer.romajiToHiragana("nihon"))
        assertEquals("がっこう", JapaneseSearchNormalizer.romajiToHiragana("gakkou"))
        assertEquals("しんぶん", JapaneseSearchNormalizer.romajiToHiragana("shimbun"))
        assertEquals("せんせい", JapaneseSearchNormalizer.romajiToHiragana("sensei"))
    }

    @Test
    fun testDetectScriptType() {
        assertEquals(ScriptType.KANJI, JapaneseSearchNormalizer.detectScriptType("食べる"))
        assertEquals(ScriptType.KANJI, JapaneseSearchNormalizer.detectScriptType("日本"))
        assertEquals(ScriptType.KANA, JapaneseSearchNormalizer.detectScriptType("たべる"))
        assertEquals(ScriptType.KANA, JapaneseSearchNormalizer.detectScriptType("タベル"))
        assertEquals(ScriptType.ROMAJI, JapaneseSearchNormalizer.detectScriptType("taberu"))
        assertEquals(ScriptType.ROMAJI, JapaneseSearchNormalizer.detectScriptType("makan"))
    }
}
