import xml.etree.ElementTree as ET
import re
from dataclasses import dataclass, field
from typing import List, Optional
from tools.etl.normalizer import normalize_text, to_hiragana

@dataclass
class ParsedKanjiReading:
    reading_type: str  # 'onyomi', 'kunyomi', 'nanori'
    reading: str
    reading_romaji: str

@dataclass
class ParsedStroke:
    stroke_number: int
    path_data: str
    stroke_type: str

@dataclass
class ParsedKanji:
    character: str
    stroke_count: int
    radical_number: int
    grade: Optional[int]
    jlpt_level: Optional[int]
    frequency: Optional[int]
    readings: List[ParsedKanjiReading] = field(default_factory=list)
    meanings_en: List[str] = field(default_factory=list)

def map_old_jlpt_to_new(old_level: int) -> int:
    """Maps former 1-4 JLPT scale from KANJIDIC to current N5-N1 scale."""
    if old_level == 4:
        return 5  # N5
    elif old_level == 3:
        return 4  # N4
    elif old_level == 2:
        return 2  # N2
    elif old_level == 1:
        return 1  # N1
    return old_level

def parse_kanjidic_entry(xml_content: str) -> ParsedKanji:
    """Parses a <character> element XML from KANJIDIC2."""
    root = ET.fromstring(xml_content.strip())
    
    char = root.findtext("literal", "").strip()
    
    # Radical
    rad_elem = root.find(".//radical/rad_value[@rad_type='classical']")
    rad_num = int(rad_elem.text) if rad_elem is not None and rad_elem.text else 0
    
    # Misc
    stroke_elem = root.find(".//misc/stroke_count")
    stroke_count = int(stroke_elem.text) if stroke_elem is not None and stroke_elem.text else 0
    
    grade_elem = root.find(".//misc/grade")
    grade = int(grade_elem.text) if grade_elem is not None and grade_elem.text else None
    
    freq_elem = root.find(".//misc/freq")
    freq = int(freq_elem.text) if freq_elem is not None and freq_elem.text else None
    
    jlpt_elem = root.find(".//misc/jlpt")
    jlpt_level = map_old_jlpt_to_new(int(jlpt_elem.text)) if jlpt_elem is not None and jlpt_elem.text else None
    
    # Readings & Meanings
    readings: List[ParsedKanjiReading] = []
    meanings_en: List[str] = []
    
    for rm in root.findall(".//reading_meaning/rmgroup"):
        for r in rm.findall("reading"):
            r_type = r.attrib.get("r_type", "")
            r_val = r.text.strip() if r.text else ""
            if not r_val:
                continue
                
            if r_type == "ja_on":
                readings.append(ParsedKanjiReading("onyomi", r_val, ""))
            elif r_type == "ja_kun":
                readings.append(ParsedKanjiReading("kunyomi", r_val, ""))
                
        for m in rm.findall("meaning"):
            # English meanings have no m_lang attribute
            if "m_lang" not in m.attrib and m.text:
                meanings_en.append(m.text.strip())
                
    return ParsedKanji(
        character=char,
        stroke_count=stroke_count,
        radical_number=rad_num,
        grade=grade,
        jlpt_level=jlpt_level,
        frequency=freq,
        readings=readings,
        meanings_en=meanings_en
    )

def parse_kanjivg_svg(svg_content: str) -> List[ParsedStroke]:
    """Parses KanjiVG SVG file content and extracts sequential stroke paths."""
    strokes: List[ParsedStroke] = []
    
    # Regex extraction works reliably across namespaced SVG elements
    pattern = re.compile(r'<path[^>]*\bid="[^"]+-s(\d+)"[^>]*\bd="([^"]+)"[^>]*>', re.IGNORECASE)
    type_pattern = re.compile(r'kvg:type="([^"]+)"', re.IGNORECASE)
    
    for match in re.finditer(r'<path[^>]+>', svg_content):
        tag = match.group(0)
        id_match = re.search(r'\bid="[^"]+-s(\d+)"', tag)
        d_match = re.search(r'\bd="([^"]+)"', tag)
        type_match = type_pattern.search(tag)
        
        if id_match and d_match:
            stroke_num = int(id_match.group(1))
            path_data = d_match.group(1).strip()
            stroke_type = type_match.group(1).strip() if type_match else ""
            
            strokes.append(
                ParsedStroke(
                    stroke_number=stroke_num,
                    path_data=path_data,
                    stroke_type=stroke_type
                )
            )
            
    # Sort strokes by stroke_number
    strokes.sort(key=lambda s: s.stroke_number)
    return strokes
