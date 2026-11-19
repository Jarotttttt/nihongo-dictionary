import unicodedata
import re

ROMAJI_MAP = [
    # Trigraphs / special digraphs
    ("kya", "きゃ"), ("kyu", "きゅ"), ("kyo", "きょ"),
    ("sha", "しゃ"), ("shu", "しゅ"), ("sho", "しょ"),
    ("cha", "ちゃ"), ("chu", "ちゅ"), ("cho", "ちょ"),
    ("nya", "にゃ"), ("nyu", "にゅ"), ("nyo", "にょ"),
    ("hya", "ひゃ"), ("hyu", "ひゅ"), ("hyo", "ひょ"),
    ("mya", "みゃ"), ("myu", "みゅ"), ("myo", "みょ"),
    ("rya", "りゃ"), ("ryu", "りゅ"), ("ryo", "りょ"),
    ("gya", "ぎゃ"), ("gyu", "ぎゅ"), ("gyo", "ぎょ"),
    ("ja", "じゃ"), ("ju", "じゅ"), ("jo", "じょ"),
    ("bya", "びゃ"), ("byu", "びゅ"), ("byo", "びょ"),
    ("pya", "ぴゃ"), ("pyu", "ぴゅ"), ("pyo", "ぴょ"),
    ("tsu", "つ"), ("shi", "し"), ("chi", "ち"),
    
    # Digraphs
    ("ka", "か"), ("ki", "き"), ("ku", "く"), ("ke", "け"), ("ko", "こ"),
    ("sa", "さ"), ("si", "し"), ("su", "す"), ("se", "せ"), ("so", "そ"),
    ("ta", "た"), ("ti", "ち"), ("tu", "つ"), ("te", "て"), ("to", "と"),
    ("na", "な"), ("ni", "に"), ("nu", "ぬ"), ("ne", "ね"), ("no", "の"),
    ("ha", "は"), ("hi", "ひ"), ("fu", "ふ"), ("hu", "ふ"), ("he", "へ"), ("ho", "ほ"),
    ("ma", "ま"), ("mi", "み"), ("mu", "む"), ("me", "め"), ("mo", "も"),
    ("ya", "や"), ("yu", "ゆ"), ("yo", "よ"),
    ("ra", "ら"), ("ri", "り"), ("ru", "る"), ("re", "れ"), ("ro", "ろ"),
    ("wa", "わ"), ("wo", "を"),
    ("ga", "が"), ("gi", "ぎ"), ("gu", "ぐ"), ("ge", "げ"), ("go", "ご"),
    ("za", "ざ"), ("ji", "じ"), ("zu", "ず"), ("ze", "ぜ"), ("zo", "ぞ"),
    ("da", "だ"), ("di", "ぢ"), ("du", "づ"), ("de", "で"), ("do", "ど"),
    ("ba", "ば"), ("bi", "び"), ("bu", "ぶ"), ("be", "べ"), ("bo", "ぼ"),
    ("pa", "ぱ"), ("pi", "ぴ"), ("pu", "ぷ"), ("pe", "ぺ"), ("po", "ぽ"),
    
    # Single vowels
    ("a", "あ"), ("i", "い"), ("u", "う"), ("e", "え"), ("o", "お"),
    ("nn", "ん"),
]

def normalize_text(text: str) -> str:
    """Normalizes string using Unicode NFKC and strips surrounding whitespace."""
    if not text:
        return ""
    normalized = unicodedata.normalize("NFKC", text)
    return normalized.strip()

def to_hiragana(text: str) -> str:
    """Converts Katakana characters within text to Hiragana."""
    if not text:
        return ""
    chars = []
    for char in text:
        code = ord(char)
        # Katakana block 0x30A1 - 0x30F6 maps to Hiragana 0x3041 - 0x3096
        if 0x30A1 <= code <= 0x30F6:
            chars.append(chr(code - 0x60))
        else:
            chars.append(char)
    return "".join(chars)

def romaji_to_hiragana(romaji: str) -> str:
    """Converts Romaji string (Hepburn/Wapuro) to Hiragana."""
    if not romaji:
        return ""
    s = normalize_text(romaji).lower()
    
    # Handle gemination (sokuon: kk, tt, ss, pp, etc.)
    result = []
    i = 0
    n = len(s)
    
    while i < n:
        # Check sokuon (double consonants excluding 'n')
        if i + 1 < n and s[i] == s[i + 1] and s[i] not in "aeioun":
            result.append("っ")
            i += 1
            continue
            
        # Check 'm' before b, p -> ん (e.g. shimbun -> shinbun)
        if s[i] == 'm' and i + 1 < n and s[i + 1] in "bp":
            result.append("ん")
            i += 1
            continue
            
        # Check 'n' before consonants (not vowels or y) or at end of word
        if s[i] == 'n':
            if i + 1 == n:
                result.append("ん")
                i += 1
                continue
            elif s[i + 1] == 'n':
                result.append("ん")
                i += 2
                continue
            elif s[i + 1] not in "aeiouy":
                result.append("ん")
                i += 1
                continue
                
        # Try matching table from longest to shortest
        matched = False
        for prefix, hira in ROMAJI_MAP:
            if s.startswith(prefix, i):
                result.append(hira)
                i += len(prefix)
                matched = True
                break
                
        if not matched:
            result.append(s[i])
            i += 1
            
    return "".join(result)
