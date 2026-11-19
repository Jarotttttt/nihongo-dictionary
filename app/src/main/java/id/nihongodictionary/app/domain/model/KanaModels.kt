package id.nihongodictionary.app.domain.model

enum class KanaCategory {
    GOJUON,     // 46 Huruf Dasar (A-I-U-E-O)
    DAKUON,     // Bunyi Turunan (Ga, Za, Da, Ba, Pa)
    YOON        // Bunyi Gabungan (Kya, Shu, Cha, dll.)
}

data class KanaCharacter(
    val character: String,
    val romaji: String,
    val category: KanaCategory,
    val exampleWord: String = "",
    val exampleMeaning: String = ""
)

object KanaData {
    // ==========================================
    // 1. HIRAGANA
    // ==========================================
    val HIRAGANA_GOJUON = listOf(
        // Vokal
        KanaCharacter("あ", "a", KanaCategory.GOJUON, "あさ (asa)", "pagi"),
        KanaCharacter("い", "i", KanaCategory.GOJUON, "いぬ (inu)", "anjing"),
        KanaCharacter("う", "u", KanaCategory.GOJUON, "うみ (umi)", "laut"),
        KanaCharacter("え", "e", KanaCategory.GOJUON, "えき (eki)", "stasiun"),
        KanaCharacter("お", "o", KanaCategory.GOJUON, "おちゃ (ocha)", "teh"),

        // K-line
        KanaCharacter("か", "ka", KanaCategory.GOJUON, "かさ (kasa)", "payung"),
        KanaCharacter("き", "ki", KanaCategory.GOJUON, "き (ki)", "pohon"),
        KanaCharacter("く", "ku", KanaCategory.GOJUON, "くるま (kuruma)", "mobil"),
        KanaCharacter("け", "ke", KanaCategory.GOJUON, "けさ (kesa)", "pagi ini"),
        KanaCharacter("こ", "ko", KanaCategory.GOJUON, "こども (kodomo)", "anak-anak"),

        // S-line
        KanaCharacter("さ", "sa", KanaCategory.GOJUON, "さかな (sakana)", "ikan"),
        KanaCharacter("し", "shi", KanaCategory.GOJUON, "しろ (shiro)", "putih"),
        KanaCharacter("す", "su", KanaCategory.GOJUON, "すし (sushi)", "sushi"),
        KanaCharacter("せ", "se", KanaCategory.GOJUON, "せんせい (sensei)", "guru"),
        KanaCharacter("そ", "so", KanaCategory.GOJUON, "そら (sora)", "langit"),

        // T-line
        KanaCharacter("た", "ta", KanaCategory.GOJUON, "たまご (tamago)", "telur"),
        KanaCharacter("ち", "chi", KanaCategory.GOJUON, "ちず (chizu)", "peta"),
        KanaCharacter("つ", "tsu", KanaCategory.GOJUON, "つき (tsuki)", "bulan"),
        KanaCharacter("て", "te", KanaCategory.GOJUON, "て (te)", "tangan"),
        KanaCharacter("と", "to", KanaCategory.GOJUON, "とり (tori)", "burung"),

        // N-line
        KanaCharacter("な", "na", KanaCategory.GOJUON, "なつ (natsu)", "musim panas"),
        KanaCharacter("に", "ni", KanaCategory.GOJUON, "にほん (nihon)", "Jepang"),
        KanaCharacter("ぬ", "nu", KanaCategory.GOJUON, "いぬ (inu)", "anjing"),
        KanaCharacter("ね", "ne", KanaCategory.GOJUON, "ねこ (neko)", "kucing"),
        KanaCharacter("の", "no", KanaCategory.GOJUON, "のみもの (nomimono)", "minuman"),

        // H-line
        KanaCharacter("は", "ha", KanaCategory.GOJUON, "はな (hana)", "bunga/hidung"),
        KanaCharacter("ひ", "hi", KanaCategory.GOJUON, "ひと (hito)", "orang"),
        KanaCharacter("ふ", "fu", KanaCategory.GOJUON, "ふね (fune)", "kapal"),
        KanaCharacter("へ", "he", KanaCategory.GOJUON, "へや (heya)", "kamar"),
        KanaCharacter("ほ", "ho", KanaCategory.GOJUON, "ほし (hoshi)", "bintang"),

        // M-line
        KanaCharacter("ま", "ma", KanaCategory.GOJUON, "まち (machi)", "kota"),
        KanaCharacter("み", "mi", KanaCategory.GOJUON, "みず (mizu)", "air"),
        KanaCharacter("む", "mu", KanaCategory.GOJUON, "むし (mushi)", "serangga"),
        KanaCharacter("め", "me", KanaCategory.GOJUON, "め (me)", "mata"),
        KanaCharacter("も", "mo", KanaCategory.GOJUON, "もり (mori)", "hutan"),

        // Y-line
        KanaCharacter("や", "ya", KanaCategory.GOJUON, "やま (yama)", "gunung"),
        KanaCharacter("", "", KanaCategory.GOJUON),
        KanaCharacter("ゆ", "yu", KanaCategory.GOJUON, "ゆき (yuki)", "salju"),
        KanaCharacter("", "", KanaCategory.GOJUON),
        KanaCharacter("よ", "yo", KanaCategory.GOJUON, "よる (yoru)", "malam"),

        // R-line
        KanaCharacter("ら", "ra", KanaCategory.GOJUON, "らいしゅう (raishuu)", "minggu depan"),
        KanaCharacter("り", "ri", KanaCategory.GOJUON, "りんご (ringo)", "apel"),
        KanaCharacter("る", "ru", KanaCategory.GOJUON, "よる (yoru)", "malam"),
        KanaCharacter("れ", "re", KanaCategory.GOJUON, "れい (rei)", "contoh/nol"),
        KanaCharacter("ろ", "ro", KanaCategory.GOJUON, "ろうそく (rousoku)", "lilin"),

        // W-line & N
        KanaCharacter("わ", "wa", KanaCategory.GOJUON, "わたし (watashi)", "saya"),
        KanaCharacter("", "", KanaCategory.GOJUON),
        KanaCharacter("", "", KanaCategory.GOJUON),
        KanaCharacter("", "", KanaCategory.GOJUON),
        KanaCharacter("を", "wo", KanaCategory.GOJUON, "partikel objek", "partikel"),

        KanaCharacter("ん", "n", KanaCategory.GOJUON, "ほん (hon)", "buku"),
        KanaCharacter("", "", KanaCategory.GOJUON),
        KanaCharacter("", "", KanaCategory.GOJUON),
        KanaCharacter("", "", KanaCategory.GOJUON),
        KanaCharacter("", "", KanaCategory.GOJUON)
    )

    val HIRAGANA_DAKUON = listOf(
        // G-line
        KanaCharacter("が", "ga", KanaCategory.DAKUON, "がっこう (gakkou)", "sekolah"),
        KanaCharacter("ぎ", "gi", KanaCategory.DAKUON, "ぎんこう (ginkou)", "bank"),
        KanaCharacter("ぐ", "gu", KanaCategory.DAKUON, "ぐあい (guai)", "kondisi"),
        KanaCharacter("げ", "ge", KanaCategory.DAKUON, "げんき (genki)", "sehat"),
        KanaCharacter("ご", "go", KanaCategory.DAKUON, "ごはん (gohan)", "nasi"),

        // Z-line
        KanaCharacter("ざ", "za", KanaCategory.DAKUON, "ざっし (zasshi)", "majalah"),
        KanaCharacter("じ", "ji", KanaCategory.DAKUON, "じかん (jikan)", "waktu"),
        KanaCharacter("ず", "zu", KanaCategory.DAKUON, "みず (mizu)", "air"),
        KanaCharacter("ぜ", "ze", KanaCategory.DAKUON, "ぜんぶ (zembu)", "semua"),
        KanaCharacter("ぞ", "zo", KanaCategory.DAKUON, "ぞう (zou)", "gajah"),

        // D-line
        KanaCharacter("だ", "da", KanaCategory.DAKUON, "だいがく (daigaku)", "universitas"),
        KanaCharacter("ぢ", "ji", KanaCategory.DAKUON, "はなぢ (hanaji)", "mimisan"),
        KanaCharacter("づ", "zu", KanaCategory.DAKUON, "つづく (tsuzuku)", "berlanjut"),
        KanaCharacter("で", "de", KanaCategory.DAKUON, "でんしゃ (densha)", "kereta"),
        KanaCharacter("ど", "do", KanaCategory.DAKUON, "どこ (doko)", "di mana"),

        // B-line
        KanaCharacter("ば", "ba", KanaCategory.DAKUON, "ばんごう (bangou)", "nomor"),
        KanaCharacter("び", "bi", KanaCategory.DAKUON, "びょういん (byouin)", "rumah sakit"),
        KanaCharacter("ぶ", "bu", KanaCategory.DAKUON, "ぶんか (bunka)", "budaya"),
        KanaCharacter("べ", "be", KanaCategory.DAKUON, "べんきょう (benkyou)", "belajar"),
        KanaCharacter("ぼ", "bo", KanaCategory.DAKUON, "ぼうし (boushi)", "topi"),

        // P-line
        KanaCharacter("ぱ", "pa", KanaCategory.DAKUON, "パン (pan)", "roti"),
        KanaCharacter("ぴ", "pi", KanaCategory.DAKUON, "ぴかぴか (pikapika)", "berkilau"),
        KanaCharacter("ぷ", "pu", KanaCategory.DAKUON, "てんぷら (tempura)", "tempura"),
        KanaCharacter("ぺ", "pe", KanaCategory.DAKUON, "ぺこぺこ (pekopeko)", "lapar"),
        KanaCharacter("ぽ", "po", KanaCategory.DAKUON, "さんぽ (sampo)", "jalan-jalan")
    )

    val HIRAGANA_YOON = listOf(
        KanaCharacter("きゃ", "kya", KanaCategory.YOON, "きゃく (kyaku)", "tamu"),
        KanaCharacter("きゅ", "kyu", KanaCategory.YOON, "きゅう (kyuu)", "sembilan"),
        KanaCharacter("きょ", "kyo", KanaCategory.YOON, "きょう (kyou)", "hari ini"),

        KanaCharacter("しゃ", "sha", KanaCategory.YOON, "しゃしん (shashin)", "foto"),
        KanaCharacter("しゅ", "shu", KanaCategory.YOON, "しゅくだい (shukudai)", "PR"),
        KanaCharacter("しょ", "sho", KanaCategory.YOON, "しょくどう (shokudou)", "kantin"),

        KanaCharacter("ちゃ", "cha", KanaCategory.YOON, "おちゃ (ocha)", "teh"),
        KanaCharacter("ちゅ", "chu", KanaCategory.YOON, "ちゅうごく (chuugoku)", "Tiongkok"),
        KanaCharacter("ちょ", "cho", KanaCategory.YOON, "ちょっと (chotto)", "sebentar"),

        KanaCharacter("にゃ", "nya", KanaCategory.YOON, "にゃー (nyaa)", "meong"),
        KanaCharacter("にゅ", "nyu", KanaCategory.YOON, "ぎゅうにゅう (gyuunyuu)", "susu"),
        KanaCharacter("にょ", "nyo", KanaCategory.YOON, "にょうぼう (nyoubou)", "istri"),

        KanaCharacter("ひゃ", "hya", KanaCategory.YOON, "ひゃく (hyaku)", "seratus"),
        KanaCharacter("ひゅ", "hyu", KanaCategory.YOON, "ひょう (hyou)", "tabel"),
        KanaCharacter("ひょ", "hyo", KanaCategory.YOON, "ひょうげん (hyougen)", "ekspresi"),

        KanaCharacter("みゃ", "mya", KanaCategory.YOON, "みゃく (myaku)", "denyut"),
        KanaCharacter("みゅ", "myu", KanaCategory.YOON, "みゅーじっく", "musik"),
        KanaCharacter("みょ", "myo", KanaCategory.YOON, "みょうじ (myouji)", "nama keluarga"),

        KanaCharacter("りゃ", "rya", KanaCategory.YOON, "りゃく (ryaku)", "singkatan"),
        KanaCharacter("りゅ", "ryu", KanaCategory.YOON, "りゅうがく (ryuugaku)", "studi luar negeri"),
        KanaCharacter("りょ", "ryo", KanaCategory.YOON, "りょこう (ryokou)", "wisata"),

        KanaCharacter("ぎゃ", "gya", KanaCategory.YOON, "ぎゃく (gyaku)", "kebalikan"),
        KanaCharacter("ぎゅ", "gyu", KanaCategory.YOON, "ぎゅうにく (gyuuniku)", "daging sapi"),
        KanaCharacter("ぎょ", "gyo", KanaCategory.YOON, "ぎょぎょう (gyogyou)", "perikanan"),

        KanaCharacter("じゃ", "ja", KanaCategory.YOON, "じゃま (jama)", "gangguan"),
        KanaCharacter("じゅ", "ju", KanaCategory.YOON, "じゅぎょう (jugyou)", "pelajaran"),
        KanaCharacter("じょ", "jo", KanaCategory.YOON, "じょせい (josei)", "wanita"),

        KanaCharacter("びゃ", "bya", KanaCategory.YOON, "さんびゃく (sambyaku)", "tiga ratus"),
        KanaCharacter("びゅ", "byu", KanaCategory.YOON, "びゅー (byuu)", "pemandangan"),
        KanaCharacter("びょ", "byo", KanaCategory.YOON, "びょういん (byouin)", "rumah sakit"),

        KanaCharacter("ぴゃ", "pya", KanaCategory.YOON, "ろっぴゃく (roppyaku)", "enam ratus"),
        KanaCharacter("ぴゅ", "pyu", KanaCategory.YOON, "ぴゅーぴゅー", "angin berdesir"),
        KanaCharacter("ぴょ", "pyo", KanaCategory.YOON, "ぴょんぴょん", "melompat")
    )

    // ==========================================
    // 2. KATAKANA
    // ==========================================
    val KATAKANA_GOJUON = listOf(
        // Vokal
        KanaCharacter("ア", "a", KanaCategory.GOJUON, "アイス (aisu)", "es krim"),
        KanaCharacter("イ", "i", KanaCategory.GOJUON, "インド (indo)", "India"),
        KanaCharacter("ウ", "u", KanaCategory.GOJUON, "ウェブ (webu)", "web"),
        KanaCharacter("エ", "e", KanaCategory.GOJUON, "エアコン (eakon)", "AC"),
        KanaCharacter("オ", "o", KanaCategory.GOJUON, "オレンジ (orenji)", "jeruk"),

        // K-line
        KanaCharacter("カ", "ka", KanaCategory.GOJUON, "カメラ (kamera)", "kamera"),
        KanaCharacter("キ", "ki", KanaCategory.GOJUON, "キロ (kiro)", "kilo"),
        KanaCharacter("ク", "ku", KanaCategory.GOJUON, "クラス (kurasu)", "kelas"),
        KanaCharacter("ケ", "ke", KanaCategory.GOJUON, "ケーキ (keeki)", "kue"),
        KanaCharacter("コ", "ko", KanaCategory.GOJUON, "コーヒー (koohii)", "kopi"),

        // S-line
        KanaCharacter("サ", "sa", KanaCategory.GOJUON, "サラダ (sarada)", "salad"),
        KanaCharacter("シ", "shi", KanaCategory.GOJUON, "シャツ (shatsu)", "kemeja"),
        KanaCharacter("ス", "su", KanaCategory.GOJUON, "スポーツ (supootsu)", "olahraga"),
        KanaCharacter("セ", "se", KanaCategory.GOJUON, "セーター (seetaa)", "sweater"),
        KanaCharacter("ソ", "so", KanaCategory.GOJUON, "ソファ (sofa)", "sofa"),

        // T-line
        KanaCharacter("タ", "ta", KanaCategory.GOJUON, "タクシー (takushii)", "taksi"),
        KanaCharacter("チ", "chi", KanaCategory.GOJUON, "チーズ (chiizu)", "keju"),
        KanaCharacter("ツ", "tsu", KanaCategory.GOJUON, "ツアー (tsuaa)", "tur"),
        KanaCharacter("テ", "te", KanaCategory.GOJUON, "テレビ (terebi)", "televisi"),
        KanaCharacter("ト", "to", KanaCategory.GOJUON, "トイレ (toire)", "toilet"),

        // N-line
        KanaCharacter("ナ", "na", KanaCategory.GOJUON, "ナイフ (naifu)", "pisau"),
        KanaCharacter("ニ", "ni", KanaCategory.GOJUON, "ニュース (nyuusu)", "berita"),
        KanaCharacter("ヌ", "nu", KanaCategory.GOJUON, "ヌードル (nuudoru)", "mi"),
        KanaCharacter("ネ", "ne", KanaCategory.GOJUON, "ネクタイ (nekutai)", "dasi"),
        KanaCharacter("ノ", "no", KanaCategory.GOJUON, "ノート (nooto)", "buku catatan"),

        // H-line
        KanaCharacter("ハ", "ha", KanaCategory.GOJUON, "ハンバーガー (hambaagaa)", "hamburger"),
        KanaCharacter("ヒ", "hi", KanaCategory.GOJUON, "ヒーター (hiitaa)", "pemanas"),
        KanaCharacter("フ", "fu", KanaCategory.GOJUON, "フォーク (fooku)", "garpu"),
        KanaCharacter("ヘ", "he", KanaCategory.GOJUON, "ヘルメット (herumetto)", "helm"),
        KanaCharacter("ホ", "ho", KanaCategory.GOJUON, "ホテル (hoteru)", "hotel"),

        // M-line
        KanaCharacter("マ", "ma", KanaCategory.GOJUON, "マスク (masuku)", "masker"),
        KanaCharacter("ミ", "mi", KanaCategory.GOJUON, "ミルク (miruku)", "susu"),
        KanaCharacter("ム", "mu", KanaCategory.GOJUON, "ムービー (muubii)", "film"),
        KanaCharacter("メ", "me", KanaCategory.GOJUON, "メニュー (menyuu)", "menu"),
        KanaCharacter("モ", "mo", KanaCategory.GOJUON, "モデル (moderu)", "model"),

        // Y-line
        KanaCharacter("ヤ", "ya", KanaCategory.GOJUON, "ヤング (yangu)", "muda"),
        KanaCharacter("", "", KanaCategory.GOJUON),
        KanaCharacter("ユ", "yu", KanaCategory.GOJUON, "ユーザー (yuuzaa)", "pengguna"),
        KanaCharacter("", "", KanaCategory.GOJUON),
        KanaCharacter("ヨ", "yo", KanaCategory.GOJUON, "ヨーグルト (yooguruto)", "yogurt"),

        // R-line
        KanaCharacter("ラ", "ra", KanaCategory.GOJUON, "ラジオ (rajio)", "radio"),
        KanaCharacter("リ", "ri", KanaCategory.GOJUON, "リモコン (rimokon)", "remote"),
        KanaCharacter("ル", "ru", KanaCategory.GOJUON, "ルール (ruuru)", "aturan"),
        KanaCharacter("レ", "re", KanaCategory.GOJUON, "レストラン (resutoran)", "restoran"),
        KanaCharacter("ロ", "ro", KanaCategory.GOJUON, "ロボット (robotto)", "robot"),

        // W-line & N
        KanaCharacter("ワ", "wa", KanaCategory.GOJUON, "ワイン (wain)", "anggur/wine"),
        KanaCharacter("", "", KanaCategory.GOJUON),
        KanaCharacter("", "", KanaCategory.GOJUON),
        KanaCharacter("", "", KanaCategory.GOJUON),
        KanaCharacter("ヲ", "wo", KanaCategory.GOJUON, "kata arkaik", "partikel"),

        KanaCharacter("ン", "n", KanaCategory.GOJUON, "パン (pan)", "roti"),
        KanaCharacter("", "", KanaCategory.GOJUON),
        KanaCharacter("", "", KanaCategory.GOJUON),
        KanaCharacter("", "", KanaCategory.GOJUON),
        KanaCharacter("", "", KanaCategory.GOJUON)
    )

    val KATAKANA_DAKUON = listOf(
        // G-line
        KanaCharacter("ガ", "ga", KanaCategory.DAKUON, "ガス (gasu)", "gas"),
        KanaCharacter("ギ", "gi", KanaCategory.DAKUON, "ギター (gitaa)", "gitar"),
        KanaCharacter("グ", "gu", KanaCategory.DAKUON, "グラス (gurasu)", "gelas"),
        KanaCharacter("ゲ", "ge", KanaCategory.DAKUON, "ゲーム (geemu)", "game"),
        KanaCharacter("ゴ", "go", KanaCategory.DAKUON, "ゴルフ (gorufu)", "golf"),

        // Z-line
        KanaCharacter("ザ", "za", KanaCategory.DAKUON, "デザート (dezaato)", "hidangan penutup"),
        KanaCharacter("ジ", "ji", KanaCategory.DAKUON, "ジュース (juusu)", "jus"),
        KanaCharacter("ズ", "zu", KanaCategory.DAKUON, "ズボン (zubon)", "celana"),
        KanaCharacter("ゼ", "ze", KanaCategory.DAKUON, "ゼロ (zero)", "nol"),
        KanaCharacter("ゾ", "zo", KanaCategory.DAKUON, "ゾーン (zoon)", "zona"),

        // D-line
        KanaCharacter("ダ", "da", KanaCategory.DAKUON, "ダンス (dansu)", "tarian"),
        KanaCharacter("ヂ", "ji", KanaCategory.DAKUON, "ヂ", "ji"),
        KanaCharacter("ヅ", "zu", KanaCategory.DAKUON, "ヅ", "zu"),
        KanaCharacter("デ", "de", KanaCategory.DAKUON, "デザート (dezaato)", "dessert"),
        KanaCharacter("ド", "do", KanaCategory.DAKUON, "ドア (doa)", "pintu"),

        // B-line
        KanaCharacter("バ", "ba", KanaCategory.DAKUON, "バス (basu)", "bus"),
        KanaCharacter("ビ", "bi", KanaCategory.DAKUON, "ビル (biru)", "gedung"),
        KanaCharacter("ブ", "bu", KanaCategory.DAKUON, "ブーツ (buutsu)", "sepatu bot"),
        KanaCharacter("ベ", "be", KanaCategory.DAKUON, "ベッド (beddo)", "tempat tidur"),
        KanaCharacter("ボ", "bo", KanaCategory.DAKUON, "ボタン (botan)", "tombol"),

        // P-line
        KanaCharacter("パ", "pa", KanaCategory.DAKUON, "パン (pan)", "roti"),
        KanaCharacter("ピ", "pi", KanaCategory.DAKUON, "ピアノ (piano)", "piano"),
        KanaCharacter("プ", "pu", KanaCategory.DAKUON, "プール (puuru)", "kolam renang"),
        KanaCharacter("ペ", "pe", KanaCategory.DAKUON, "ペン (pen)", "pena"),
        KanaCharacter("ポ", "po", KanaCategory.DAKUON, "ポスト (posuto)", "kotak pos")
    )

    val KATAKANA_YOON = listOf(
        KanaCharacter("キャ", "kya", KanaCategory.YOON, "キャベツ (kyabetsu)", "kubis"),
        KanaCharacter("キュ", "kyu", KanaCategory.YOON, "キューピッド", "cupid"),
        KanaCharacter("キョ", "kyo", KanaCategory.YOON, "キログラム", "kg"),

        KanaCharacter("シャ", "sha", KanaCategory.YOON, "シャワー (shawaa)", "shower"),
        KanaCharacter("シュ", "shu", KanaCategory.YOON, "シュークリーム", "kue sus"),
        KanaCharacter("ショ", "sho", KanaCategory.YOON, "ショップ (shoppu)", "toko"),

        KanaCharacter("チャ", "cha", KanaCategory.YOON, "チャンス (chansu)", "kesempatan"),
        KanaCharacter("チュ", "chu", KanaCategory.YOON, "チューブ (chuubu)", "tabung"),
        KanaCharacter("チョ", "cho", KanaCategory.YOON, "チョコレート (chokoreeto)", "cokelat"),

        KanaCharacter("ニャ", "nya", KanaCategory.YOON, "ニャ", "nya"),
        KanaCharacter("ニュ", "nyu", KanaCategory.YOON, "ニュース (nyuusu)", "berita"),
        KanaCharacter("ニョ", "nyo", KanaCategory.YOON, "ニョッキ (nyokki)", "gnocchi"),

        KanaCharacter("ヒャ", "hya", KanaCategory.YOON, "ヒャ", "hya"),
        KanaCharacter("ヒュ", "hyu", KanaCategory.YOON, "ヒューズ (hyuuzu)", "sekring"),
        KanaCharacter("ヒョ", "hyo", KanaCategory.YOON, "ヒョ", "hyo"),

        KanaCharacter("ミャ", "mya", KanaCategory.YOON, "ミャンマー (myanmaa)", "Myanmar"),
        KanaCharacter("ミュ", "myu", KanaCategory.YOON, "ミュージアム (myuujiamu)", "museum"),
        KanaCharacter("ミョ", "myo", KanaCategory.YOON, "ミョ", "myo"),

        KanaCharacter("リャ", "rya", KanaCategory.YOON, "リャ", "rya"),
        KanaCharacter("リュ", "ryu", KanaCategory.YOON, "リュック (ryukku)", "ransel"),
        KanaCharacter("リョ", "ryo", KanaCategory.YOON, "リョ", "ryo"),

        KanaCharacter("ギャ", "gya", KanaCategory.YOON, "ギャグ (gyagu)", "lelucon"),
        KanaCharacter("ギュ", "gyu", KanaCategory.YOON, "ギュ", "gyu"),
        KanaCharacter("ギョ", "gyo", KanaCategory.YOON, "ギョーザ (gyooza)", "gyoza"),

        KanaCharacter("ジャ", "ja", KanaCategory.YOON, "ジャケット (jaketto)", "jaket"),
        KanaCharacter("ジュ", "ju", KanaCategory.YOON, "ジュース (juusu)", "jus"),
        KanaCharacter("ジョ", "jo", KanaCategory.YOON, "ジョギング (jogingu)", "jogging"),

        KanaCharacter("ビャ", "bya", KanaCategory.YOON, "ビャ", "bya"),
        KanaCharacter("ビュ", "byu", KanaCategory.YOON, "ビュッフェ (byuffe)", "prasmanan"),
        KanaCharacter("ビョ", "byo", KanaCategory.YOON, "ビョ", "byo"),

        KanaCharacter("ピャ", "pya", KanaCategory.YOON, "ピャ", "pya"),
        KanaCharacter("ピュ", "pyu", KanaCategory.YOON, "ピューレ (pyuure)", "puree"),
        KanaCharacter("ピョ", "pyo", KanaCategory.YOON, "ピョ", "pyo")
    )
}
