package id.nihongodictionary.app.core.common

import java.text.Normalizer

enum class ScriptType {
    KANJI,
    KANA,
    ROMAJI,
    LATIN_INDONESIAN
}

object JapaneseSearchNormalizer {

    private val ROMAJI_MAP = listOf(
        "kya" to "きゃ", "kyu" to "きゅ", "kyo" to "きょ",
        "sha" to "しゃ", "shu" to "しゅ", "sho" to "しょ",
        "cha" to "ちゃ", "chu" to "ちゅ", "cho" to "ちょ",
        "nya" to "にゃ", "nyu" to "にゅ", "nyo" to "にょ",
        "hya" to "ひゃ", "hyu" to "ひゅ", "hyo" to "ひょ",
        "mya" to "みゃ", "myu" to "みゅ", "myo" to "みょ",
        "rya" to "りゃ", "ryu" to "りゅ", "ryo" to "りょ",
        "gya" to "ぎゃ", "gyu" to "ぎゅ", "gyo" to "ぎょ",
        "ja" to "じゃ", "ju" to "じゅ", "jo" to "じょ",
        "bya" to "びゃ", "byu" to "びゅ", "byo" to "びょ",
        "pya" to "ぴゃ", "pyu" to "ぴゅ", "pyo" to "ぴょ",
        "tsu" to "つ", "shi" to "し", "chi" to "ち",
        "ka" to "か", "ki" to "き", "ku" to "く", "ke" to "け", "ko" to "こ",
        "sa" to "さ", "si" to "し", "su" to "す", "se" to "せ", "so" to "そ",
        "ta" to "た", "ti" to "ち", "tu" to "つ", "te" to "て", "to" to "と",
        "na" to "な", "ni" to "に", "nu" to "ぬ", "ne" to "ね", "no" to "の",
        "ha" to "は", "hi" to "ひ", "fu" to "ふ", "hu" to "ふ", "he" to "へ", "ho" to "ほ",
        "ma" to "ま", "mi" to "み", "mu" to "む", "me" to "め", "mo" to "も",
        "ya" to "や", "yu" to "ゆ", "yo" to "よ",
        "ra" to "ら", "ri" to "り", "ru" to "る", "re" to "れ", "ro" to "ろ",
        "wa" to "わ", "wo" to "を",
        "ga" to "が", "gi" to "ぎ", "gu" to "ぐ", "ge" to "げ", "go" to "ご",
        "za" to "ざ", "ji" to "じ", "zu" to "ず", "ze" to "ぜ", "zo" to "ぞ",
        "da" to "だ", "di" to "ぢ", "du" to "づ", "de" to "で", "do" to "ど",
        "ba" to "ば", "bi" to "び", "bu" to "ぶ", "be" to "べ", "bo" to "ぼ",
        "pa" to "ぱ", "pi" to "ぴ", "pu" to "ぷ", "pe" to "ぺ", "po" to "ぽ",
        "a" to "あ", "i" to "い", "u" to "う", "e" to "え", "o" to "お",
        "nn" to "ん"
    )

    fun normalize(query: String): String {
        val nfkc = Normalizer.normalize(query.trim(), Normalizer.Form.NFKC)
        return nfkc.lowercase()
    }

    fun toHiragana(text: String): String {
        val sb = StringBuilder()
        for (ch in text) {
            val code = ch.code
            // Katakana U+30A1..U+30F6 to Hiragana U+3041..U+3096
            if (code in 0x30A1..0x30F6) {
                sb.append((code - 0x60).toChar())
            } else {
                sb.append(ch)
            }
        }
        return sb.toString()
    }

    fun romajiToHiragana(romaji: String): String {
        val s = normalize(romaji)
        val sb = StringBuilder()
        var i = 0
        val n = s.length

        while (i < n) {
            // Sokuon (double consonants)
            if (i + 1 < n && s[i] == s[i + 1] && s[i] !in "aeioun") {
                sb.append("っ")
                i++
                continue
            }
            // 'm' before b, p -> 'ん'
            if (s[i] == 'm' && i + 1 < n && s[i + 1] in "bp") {
                sb.append("ん")
                i++
                continue
            }
            // 'n' before consonants
            if (s[i] == 'n') {
                if (i + 1 == n) {
                    sb.append("ん")
                    i++
                    continue
                } else if (s[i + 1] == 'n') {
                    sb.append("ん")
                    i += 2
                    continue
                } else if (s[i + 1] !in "aeiouy") {
                    sb.append("ん")
                    i++
                    continue
                }
            }

            var matched = false
            for ((prefix, hira) in ROMAJI_MAP) {
                if (s.startsWith(prefix, i)) {
                    sb.append(hira)
                    i += prefix.length
                    matched = true
                    break
                }
            }

            if (!matched) {
                sb.append(s[i])
                i++
            }
        }

        return sb.toString()
    }

    fun detectScriptType(text: String): ScriptType {
        var hasKanji = false
        var hasKana = false
        var hasLatin = false

        for (ch in text) {
            val ub = Character.UnicodeBlock.of(ch)
            when {
                ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS ||
                ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A -> hasKanji = true
                ub == Character.UnicodeBlock.HIRAGANA ||
                ub == Character.UnicodeBlock.KATAKANA -> hasKana = true
                ub == Character.UnicodeBlock.BASIC_LATIN -> hasLatin = true
            }
        }

        return when {
            hasKanji -> ScriptType.KANJI
            hasKana -> ScriptType.KANA
            hasLatin -> ScriptType.ROMAJI // Or Indonesian
            else -> ScriptType.LATIN_INDONESIAN
        }
    }
}
