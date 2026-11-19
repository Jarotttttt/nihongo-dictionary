import gzip
import json
from dataclasses import dataclass, field
from typing import List, Optional, Iterator, Dict, Any
from tools.etl.normalizer import normalize_text, to_hiragana

@dataclass
class ParsedSense:
    sense_index: int
    pos_tags: str
    gloss_id: str
    gloss_en: Optional[str] = None

@dataclass
class ParsedWord:
    jmdict_seq: Optional[str]
    primary_spelling: str
    primary_reading: str
    reading_hiragana: str
    reading_romaji: str
    is_common: bool
    jlpt_level: Optional[int]
    senses: List[ParsedSense] = field(default_factory=list)

def parse_jaisho_entry(raw_json: Dict[str, Any]) -> ParsedWord:
    """Parses a single JaIsho entry JSON dictionary into a normalized ParsedWord."""
    jmdict_seq = str(raw_json.get("id") or raw_json.get("jmdict_seq") or "")
    
    # Primary spelling (Kanji or Kana if kana-only)
    spelling = normalize_text(raw_json.get("kanji") or raw_json.get("spelling") or "")
    reading = normalize_text(raw_json.get("reading") or raw_json.get("kana") or "")
    
    # If no kanji provided, the word is written in kana
    if not spelling and reading:
        spelling = reading
    elif not reading and spelling:
        reading = spelling
        
    reading_hiragana = to_hiragana(reading)
    romaji = normalize_text(raw_json.get("romaji") or "")
    
    is_common = bool(raw_json.get("common") or False)
    jlpt = raw_json.get("jlpt")
    jlpt_level = int(jlpt) if jlpt is not None and str(jlpt).isdigit() else None
    
    parsed_senses: List[ParsedSense] = []
    raw_meanings = raw_json.get("meanings") or raw_json.get("senses") or []
    
    for idx, item in enumerate(raw_meanings, start=1):
        # Format POS tags
        pos_raw = item.get("pos", [])
        if isinstance(pos_raw, list):
            pos_tags = ", ".join(str(p).strip() for p in pos_raw if p)
        else:
            pos_tags = str(pos_raw).strip()
            
        gloss_id = normalize_text(item.get("gloss") or item.get("meaning") or item.get("definition") or "")
        gloss_en = normalize_text(item.get("gloss_en") or "") or None
        
        if gloss_id:
            parsed_senses.append(
                ParsedSense(
                    sense_index=idx,
                    pos_tags=pos_tags,
                    gloss_id=gloss_id,
                    gloss_en=gloss_en
                )
            )
            
    return ParsedWord(
        jmdict_seq=jmdict_seq if jmdict_seq else None,
        primary_spelling=spelling,
        primary_reading=reading,
        reading_hiragana=reading_hiragana,
        reading_romaji=romaji,
        is_common=is_common,
        jlpt_level=jlpt_level,
        senses=parsed_senses
    )

def stream_jaisho_ndjson(file_path: str) -> Iterator[ParsedWord]:
    """Streams and parses records from a JaIsho NDJSON file (.ndjson or .gz)."""
    opener = gzip.open if file_path.endswith(".gz") else open
    with opener(file_path, "rt", encoding="utf-8") as f:
        for line in f:
            line_str = line.strip()
            if not line_str:
                continue
            try:
                data = json.loads(line_str)
                yield parse_jaisho_entry(data)
            except json.JSONDecodeError:
                continue
