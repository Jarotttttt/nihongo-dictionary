from dataclasses import dataclass
from typing import Optional, List
from tools.etl.normalizer import normalize_text
from tools.etl.jaisho_parser import ParsedWord

@dataclass
class ParsedSentence:
    tatoeba_jpn_id: int
    japanese_text: str
    tatoeba_ind_id: int
    indonesian_text: str

def parse_tatoeba_tsv_line(line: str) -> Optional[ParsedSentence]:
    """Parses a TSV line formatted as: jpn_id \\t jpn_text \\t ind_id \\t ind_text."""
    if not line:
        return None
    parts = line.strip().split("\t")
    if len(parts) < 4:
        return None
        
    jpn_id_str, jpn_text, ind_id_str, ind_text = parts[0], parts[1], parts[2], parts[3]
    if not (jpn_id_str.isdigit() and ind_id_str.isdigit()):
        return None
        
    return ParsedSentence(
        tatoeba_jpn_id=int(jpn_id_str),
        japanese_text=normalize_text(jpn_text),
        tatoeba_ind_id=int(ind_id_str),
        indonesian_text=normalize_text(ind_text)
    )

def link_sentence_to_words(sentence: ParsedSentence, words: List[ParsedWord]) -> List[ParsedWord]:
    """Finds vocabulary entries that appear in the given Japanese sentence."""
    matched: List[ParsedWord] = []
    text = sentence.japanese_text
    
    INFLECTION_SUFFIXES = ("る", "う", "つ", "く", "ぐ", "す", "む", "ぬ", "ぶ", "い")
    
    for word in words:
        spelling = word.primary_spelling
        if not spelling:
            continue
            
        # 1. Exact match of headword
        if spelling in text:
            matched.append(word)
            continue
            
        # 2. De-inflected stem match for verbs and i-adjectives (e.g. 食べる -> 食べ, 美しい -> 美し)
        if len(spelling) >= 2 and spelling.endswith(INFLECTION_SUFFIXES):
            stem = spelling[:-1]
            if stem in text:
                matched.append(word)
                continue
                
    return matched
