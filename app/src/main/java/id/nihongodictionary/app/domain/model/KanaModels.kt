package id.nihongodictionary.app.domain.model
enum class KanaCategory {
    GOJUON,
    DAKUON,
    YOON
}
data class KanaWord(
    val japanese: String,
    val romaji: String,
    val meaning: String
)

data class KanaCharacter(
    val character: String,
    val romaji: String,
    val category: KanaCategory,
    val strokeCount: Int = 1,
    val strokeSteps: List<String> = emptyList(),
    val relatedWords: List<KanaWord> = emptyList()
)
object KanaData {
    val HIRAGANA_GOJUON = listOf(
        KanaCharacter(
            character = "あ",
            romaji = "a",
            category = KanaCategory.GOJUON,
            strokeCount = 3,
            strokeSteps = listOf("Garis mendatar ke kanan", "Garis melengkung ke bawah memotong garis 1", "Garis memutar melingkar seperti loop"),
            relatedWords = listOf(KanaWord("あさ", "asa", "pagi"), KanaWord("あたま", "atama", "kepala"), KanaWord("あめ", "ame", "hujan"), KanaWord("ありがとう", "arigatou", "terima kasih"))
        ),
        KanaCharacter(
            character = "い",
            romaji = "i",
            category = KanaCategory.GOJUON,
            strokeCount = 2,
            strokeSteps = listOf("Garis kiri melengkung dengan kait di ujung", "Garis kanan lebih pendek melengkung ke dalam"),
            relatedWords = listOf(KanaWord("いぬ", "inu", "anjing"), KanaWord("いえ", "ie", "rumah"), KanaWord("いち", "ichi", "satu"), KanaWord("いま", "ima", "sekarang"))
        ),
        KanaCharacter(
            character = "う",
            romaji = "u",
            category = KanaCategory.GOJUON,
            strokeCount = 2,
            strokeSteps = listOf("Garis pendek miring di atas", "Garis melengkung besar seperti huruf C terbalik"),
            relatedWords = listOf(KanaWord("うみ", "umi", "laut"), KanaWord("うた", "uta", "lagu"), KanaWord("うし", "ushi", "sapi"), KanaWord("うえ", "ue", "atas"))
        ),
        KanaCharacter(
            character = "え",
            romaji = "e",
            category = KanaCategory.GOJUON,
            strokeCount = 2,
            strokeSteps = listOf("Garis pendek miring di atas", "Garis zig-zag meliuk ke kanan bawah"),
            relatedWords = listOf(KanaWord("えき", "eki", "stasiun"), KanaWord("えんぴつ", "empitsu", "pensil"), KanaWord("えいが", "eiga", "film"), KanaWord("え", "e", "gambar"))
        ),
        KanaCharacter(
            character = "お",
            romaji = "o",
            category = KanaCategory.GOJUON,
            strokeCount = 3,
            strokeSteps = listOf("Garis mendatar ke kanan", "Garis vertikal melengkung ke kanan melingkar", "Titik/coretan pendek di kanan atas"),
            relatedWords = listOf(KanaWord("おちゃ", "ocha", "teh"), KanaWord("おんな", "onna", "wanita"), KanaWord("おとこ", "otoko", "pria"), KanaWord("おおきい", "ookii", "besar"))
        ),
        KanaCharacter(
            character = "か",
            romaji = "ka",
            category = KanaCategory.GOJUON,
            strokeCount = 3,
            strokeSteps = listOf("Garis melengkung ke bawah berujung kait", "Garis miring memotong di sebelah kiri", "Titik/coretan di kanan atas"),
            relatedWords = listOf(KanaWord("かさ", "kasa", "payung"), KanaWord("かわ", "kawa", "sungai"), KanaWord("かぞく", "kazoku", "keluarga"), KanaWord("かみ", "kami", "kertas/tuhan"))
        ),
        KanaCharacter(
            character = "き",
            romaji = "ki",
            category = KanaCategory.GOJUON,
            strokeCount = 4,
            strokeSteps = listOf("Dua garis mendatar sejajar", "Garis miring memotong dari atas ke kanan bawah", "Garis melengkung di bagian bawah"),
            relatedWords = listOf(KanaWord("き", "ki", "pohon"), KanaWord("きょう", "kyou", "hari ini"), KanaWord("きっぷ", "kippu", "tiket"), KanaWord("きもの", "kimono", "kimono"))
        ),
        KanaCharacter(
            character = "く",
            romaji = "ku",
            category = KanaCategory.GOJUON,
            strokeCount = 1,
            strokeSteps = listOf("Satu tarikan garis menyudut membentuk tanda kurang dari (<)"),
            relatedWords = listOf(KanaWord("くるま", "kuruma", "mobil"), KanaWord("くち", "kuchi", "mulut"), KanaWord("くだもの", "kudamono", "buah"), KanaWord("くつ", "kutsu", "sepatu"))
        ),
        KanaCharacter(
            character = "け",
            romaji = "ke",
            category = KanaCategory.GOJUON,
            strokeCount = 3,
            strokeSteps = listOf("Garis vertikal kiri berujung kait", "Garis mendatar pendek di kanan", "Garis vertikal melengkung memotong garis mendatar"),
            relatedWords = listOf(KanaWord("けさ", "kesa", "pagi ini"), KanaWord("けいさつ", "keisatsu", "polisi"), KanaWord("けっこん", "kekkon", "menikah"), KanaWord("けむり", "kemuri", "asap"))
        ),
        KanaCharacter(
            character = "こ",
            romaji = "ko",
            category = KanaCategory.GOJUON,
            strokeCount = 2,
            strokeSteps = listOf("Garis mendatar atas sedikit melengkung", "Garis mendatar bawah melengkung sejajar"),
            relatedWords = listOf(KanaWord("こども", "kodomo", "anak-anak"), KanaWord("これ", "kore", "ini"), KanaWord("こえ", "koe", "suara"), KanaWord("ここ", "koko", "di sini"))
        ),
        KanaCharacter(
            character = "さ",
            romaji = "sa",
            category = KanaCategory.GOJUON,
            strokeCount = 3,
            strokeSteps = listOf("Garis mendatar sedikit miring ke atas", "Garis memotong diagonal ke kanan bawah", "Garis melengkung memutar di bawah"),
            relatedWords = listOf(KanaWord("さかな", "sakana", "ikan"), KanaWord("さくら", "sakura", "bunga sakura"), KanaWord("さとう", "satou", "gula"), KanaWord("さいふ", "saifu", "dompet"))
        ),
        KanaCharacter(
            character = "し",
            romaji = "shi",
            category = KanaCategory.GOJUON,
            strokeCount = 1,
            strokeSteps = listOf("Garis vertikal turun lalu melengkung ke kanan atas seperti kail pancing"),
            relatedWords = listOf(KanaWord("しろ", "shiro", "putih"), KanaWord("しんぶん", "shimbun", "koran"), KanaWord("しお", "shio", "garam"), KanaWord("しごと", "shigoto", "pekerjaan"))
        ),
        KanaCharacter(
            character = "す",
            romaji = "su",
            category = KanaCategory.GOJUON,
            strokeCount = 2,
            strokeSteps = listOf("Garis mendatar dari kiri ke kanan", "Garis vertikal membentuk simpul lingkaran di tengah lalu turun ke bawah"),
            relatedWords = listOf(KanaWord("すし", "sushi", "sushi"), KanaWord("すき", "suki", "suka"), KanaWord("すずしい", "suzushii", "sejuk"), KanaWord("すこし", "sukoshi", "sedikit"))
        ),
        KanaCharacter(
            character = "せ",
            romaji = "se",
            category = KanaCategory.GOJUON,
            strokeCount = 3,
            strokeSteps = listOf("Garis mendatar panjang", "Garis vertikal kanan berujung kait", "Garis vertikal kiri melengkung ke kanan"),
            relatedWords = listOf(KanaWord("せんせい", "sensei", "guru"), KanaWord("せかい", "sekai", "dunia"), KanaWord("せなか", "senaka", "punggung"), KanaWord("せまい", "semai", "sempit"))
        ),
        KanaCharacter(
            character = "そ",
            romaji = "so",
            category = KanaCategory.GOJUON,
            strokeCount = 1,
            strokeSteps = listOf("Satu garis berkelanjutan zig-zag: mendatar, diagonal, mendatar, melengkung di bawah"),
            relatedWords = listOf(KanaWord("そら", "sora", "langit"), KanaWord("そこ", "soko", "di situ"), KanaWord("そと", "soto", "luar"), KanaWord("そして", "soshite", "lalu/kemudian"))
        ),
        KanaCharacter(
            character = "た",
            romaji = "ta",
            category = KanaCategory.GOJUON,
            strokeCount = 4,
            strokeSteps = listOf("Garis mendatar", "Garis miring memotong garis pertama", "Dua garis pendek seperti huruf 'ko' kecil di kanan"),
            relatedWords = listOf(KanaWord("たまご", "tamago", "telur"), KanaWord("たべる", "taberu", "makan"), KanaWord("たかい", "takai", "tinggi/mahal"), KanaWord("たいよう", "taiyou", "matahari"))
        ),
        KanaCharacter(
            character = "ち",
            romaji = "chi",
            category = KanaCategory.GOJUON,
            strokeCount = 2,
            strokeSteps = listOf("Garis mendatar sedikit miring ke atas", "Garis vertikal melengkung melingkar seperti angka 5"),
            relatedWords = listOf(KanaWord("ちず", "chizu", "peta"), KanaWord("ちち", "chichi", "ayah"), KanaWord("ちいさい", "chiisai", "kecil"), KanaWord("ちかてつ", "chikatetsu", "kereta bawah tanah"))
        ),
        KanaCharacter(
            character = "つ",
            romaji = "tsu",
            category = KanaCategory.GOJUON,
            strokeCount = 1,
            strokeSteps = listOf("Satu tarikan garis melengkung seperti gelombang ombak besar"),
            relatedWords = listOf(KanaWord("つき", "tsuki", "bulan"), KanaWord("つくえ", "tsukue", "meja"), KanaWord("つよい", "tsuyoi", "kuat"), KanaWord("つぎ", "tsugi", "berikutnya"))
        ),
        KanaCharacter(
            character = "て",
            romaji = "te",
            category = KanaCategory.GOJUON,
            strokeCount = 1,
            strokeSteps = listOf("Garis mendatar lalu melengkung setengah lingkaran ke kanan bawah"),
            relatedWords = listOf(KanaWord("て", "te", "tangan"), KanaWord("てがみ", "tegami", "surat"), KanaWord("てんき", "tenki", "cuaca"), KanaWord("テレビ", "terebi", "televisi"))
        ),
        KanaCharacter(
            character = "と",
            romaji = "to",
            category = KanaCategory.GOJUON,
            strokeCount = 2,
            strokeSteps = listOf("Garis miring pendek ke kanan bawah", "Garis melengkung besar memotong garis pertama"),
            relatedWords = listOf(KanaWord("とり", "tori", "burung"), KanaWord("ともだち", "tomodachi", "teman"), KanaWord("とけい", "tokei", "jam dinding"), KanaWord("としょかん", "toshokan", "perpustakaan"))
        ),
        KanaCharacter(
            character = "な",
            romaji = "na",
            category = KanaCategory.GOJUON,
            strokeCount = 4,
            strokeSteps = listOf("Garis mendatar", "Garis miring ke bawah", "Titik pendek di kanan atas", "Garis melingkar simpul di kanan bawah"),
            relatedWords = listOf(KanaWord("なつ", "natsu", "musim panas"), KanaWord("なまえ", "namae", "nama"), KanaWord("なん/なに", "nani", "apa"), KanaWord("ながい", "nagai", "panjang"))
        ),
        KanaCharacter(
            character = "に",
            romaji = "ni",
            category = KanaCategory.GOJUON,
            strokeCount = 3,
            strokeSteps = listOf("Garis vertikal kiri dengan kait", "Dua garis mendatar sejajar di sebelah kanan (seperti 'ko')"),
            relatedWords = listOf(KanaWord("にほん", "nihon", "Jepang"), KanaWord("にく", "niku", "daging"), KanaWord("にわ", "niwa", "halaman/kebun"), KanaWord("にちようび", "nichiyoubi", "hari Minggu"))
        ),
        KanaCharacter(
            character = "ぬ",
            romaji = "nu",
            category = KanaCategory.GOJUON,
            strokeCount = 2,
            strokeSteps = listOf("Garis miring dari kiri atas ke kanan bawah", "Garis meliuk memutar membentuk simpul kecil di ujung kanan"),
            relatedWords = listOf(KanaWord("いぬ", "inu", "anjing"), KanaWord("ぬの", "nuno", "kain"), KanaWord("ぬるい", "nurui", "hangat suam-suam"), KanaWord("ぬすむ", "nusumu", "mencuri"))
        ),
        KanaCharacter(
            character = "ね",
            romaji = "ne",
            category = KanaCategory.GOJUON,
            strokeCount = 2,
            strokeSteps = listOf("Garis vertikal tegak lurus", "Garis zig-zag melengkung dengan simpul kecil di ujung kanan"),
            relatedWords = listOf(KanaWord("ねこ", "neko", "kucing"), KanaWord("ねつ", "netsu", "demam"), KanaWord("ねる", "neru", "tidur"), KanaWord("ねだん", "nedan", "harga"))
        ),
        KanaCharacter(
            character = "の",
            romaji = "no",
            category = KanaCategory.GOJUON,
            strokeCount = 1,
            strokeSteps = listOf("Satu tarikan garis melengkung melingkar seperti lingkaran spiral"),
            relatedWords = listOf(KanaWord("のみもの", "nomimono", "minuman"), KanaWord("のる", "noru", "naik (kendaraan)"), KanaWord("のど", "nodo", "tenggorokan"), KanaWord("のうか", "nouka", "petani"))
        ),
        KanaCharacter(
            character = "は",
            romaji = "ha",
            category = KanaCategory.GOJUON,
            strokeCount = 3,
            strokeSteps = listOf("Garis vertikal kiri berujung kait", "Garis mendatar kanan", "Garis vertikal memotong garis mendatar dengan simpul lingkaran di bawah"),
            relatedWords = listOf(KanaWord("はな", "hana", "bunga/hidung"), KanaWord("はし", "hashi", "sumpit/jembatan"), KanaWord("はる", "haru", "musim semi"), KanaWord("はやい", "hayai", "cepat"))
        ),
        KanaCharacter(
            character = "ひ",
            romaji = "hi",
            category = KanaCategory.GOJUON,
            strokeCount = 1,
            strokeSteps = listOf("Satu tarikan garis melengkung membentuk lengkungan tapal kuda asimetris"),
            relatedWords = listOf(KanaWord("ひと", "hito", "orang"), KanaWord("ひこうき", "hikouki", "pesawat"), KanaWord("ひだり", "hidari", "kiri"), KanaWord("ひる", "hiru", "siang"))
        ),
        KanaCharacter(
            character = "ふ",
            romaji = "fu",
            category = KanaCategory.GOJUON,
            strokeCount = 4,
            strokeSteps = listOf("Titik atas pendek", "Garis lengkung tengah berbentuk hidung", "Titik miring di kiri", "Titik miring di kanan"),
            relatedWords = listOf(KanaWord("ふね", "fune", "kapal"), KanaWord("ふゆ", "fuyu", "musim dingin"), KanaWord("ふじさん", "fujisan", "Gunung Fuji"), KanaWord("ふく", "fuku", "pakaian"))
        ),
        KanaCharacter(
            character = "へ",
            romaji = "he",
            category = KanaCategory.GOJUON,
            strokeCount = 1,
            strokeSteps = listOf("Satu tarikan garis membentuk puncak bukit/atap miring ke kanan"),
            relatedWords = listOf(KanaWord("へや", "heya", "kamar"), KanaWord("へた", "heta", "tidak pandai"), KanaWord("へいわ", "heiwa", "perdamaian"), KanaWord("へび", "hebi", "ular"))
        ),
        KanaCharacter(
            character = "ほ",
            romaji = "ho",
            category = KanaCategory.GOJUON,
            strokeCount = 4,
            strokeSteps = listOf("Garis vertikal kiri dengan kait", "Dua garis mendatar kanan", "Garis vertikal memotong garis mendatar bawah membentuk simpul"),
            relatedWords = listOf(KanaWord("ほし", "hoshi", "bintang"), KanaWord("ほん", "hon", "buku"), KanaWord("ほね", "hone", "tulang"), KanaWord("ほんとう", "hontou", "benar/nyata"))
        ),
        KanaCharacter(
            character = "ま",
            romaji = "ma",
            category = KanaCategory.GOJUON,
            strokeCount = 3,
            strokeSteps = listOf("Dua garis mendatar sejajar", "Garis vertikal memotong kedua garis dengan simpul melingkar di bawah"),
            relatedWords = listOf(KanaWord("まち", "machi", "kota"), KanaWord("まいにち", "mainichi", "setiap hari"), KanaWord("まえ", "mae", "depan"), KanaWord("まつ", "matsu", "menunggu"))
        ),
        KanaCharacter(
            character = "み",
            romaji = "mi",
            category = KanaCategory.GOJUON,
            strokeCount = 2,
            strokeSteps = listOf("Garis mendatar lalu meliuk ke kiri bawah berujung simpul memanjang", "Garis miring memotong di sebelah kanan"),
            relatedWords = listOf(KanaWord("みず", "mizu", "air"), KanaWord("みち", "michi", "jalan"), KanaWord("みみ", "mimi", "telinga"), KanaWord("みる", "miru", "melihat"))
        ),
        KanaCharacter(
            character = "む",
            romaji = "mu",
            category = KanaCategory.GOJUON,
            strokeCount = 3,
            strokeSteps = listOf("Garis mendatar", "Garis vertikal melengkung dengan simpul di tengah dan melengkung ke kanan atas", "Titik di kanan atas"),
            relatedWords = listOf(KanaWord("むし", "mushi", "serangga"), KanaWord("むすこ", "musuko", "anak laki-laki"), KanaWord("むずかしい", "muzukashii", "sulit"), KanaWord("むら", "mura", "desa"))
        ),
        KanaCharacter(
            character = "め",
            romaji = "me",
            category = KanaCategory.GOJUON,
            strokeCount = 2,
            strokeSteps = listOf("Garis miring dari kiri atas ke kanan bawah", "Garis melengkung besar memotong dan melingkari garis pertama tanpa simpul"),
            relatedWords = listOf(KanaWord("め", "me", "mata"), KanaWord("めがね", "megane", "kacamata"), KanaWord("めいし", "meishi", "kartu nama"), KanaWord("めでたい", "medetai", "menggembirakan"))
        ),
        KanaCharacter(
            character = "も",
            romaji = "mo",
            category = KanaCategory.GOJUON,
            strokeCount = 3,
            strokeSteps = listOf("Garis vertikal melengkung ke kanan seperti pancing", "Dua garis mendatar sejajar memotong garis vertikal"),
            relatedWords = listOf(KanaWord("もり", "mori", "hutan"), KanaWord("もの", "mono", "benda/barang"), KanaWord("もんだい", "mondai", "masalah/soal"), KanaWord("もつ", "motsu", "membawa"))
        ),
        KanaCharacter(
            character = "や",
            romaji = "ya",
            category = KanaCategory.GOJUON,
            strokeCount = 3,
            strokeSteps = listOf("Garis melengkung ke bawah berujung kait", "Coretan pendek di atas", "Garis miring memotong dari atas ke kiri bawah"),
            relatedWords = listOf(KanaWord("やま", "yama", "gunung"), KanaWord("やすみ", "yasumi", "libur/istirahat"), KanaWord("やさい", "yasai", "sayuran"), KanaWord("やくそく", "yakusoku", "janji"))
        ),
        KanaCharacter("", "", KanaCategory.GOJUON),
        KanaCharacter(
            character = "ゆ",
            romaji = "yu",
            category = KanaCategory.GOJUON,
            strokeCount = 2,
            strokeSteps = listOf("Garis vertikal melengkung dengan simpul besar ke kanan", "Garis vertikal panjang memotong dari atas ke bawah"),
            relatedWords = listOf(KanaWord("ゆき", "yuki", "salju"), KanaWord("ゆめ", "yume", "mimpi"), KanaWord("ゆうびんきょく", "yuubinkyoku", "kantor pos"), KanaWord("ゆうべ", "yuube", "kemarin malam"))
        ),
        KanaCharacter("", "", KanaCategory.GOJUON),
        KanaCharacter(
            character = "よ",
            romaji = "yo",
            category = KanaCategory.GOJUON,
            strokeCount = 2,
            strokeSteps = listOf("Garis mendatar pendek", "Garis vertikal memotong garis mendatar dengan simpul melingkar di bawah"),
            relatedWords = listOf(KanaWord("よる", "yoru", "malam"), KanaWord("よく", "yoku", "sering/dengan baik"), KanaWord("よむ", "yomu", "membaca"), KanaWord("よっつ", "yottsu", "empat buah"))
        ),
        KanaCharacter(
            character = "ら",
            romaji = "ra",
            category = KanaCategory.GOJUON,
            strokeCount = 2,
            strokeSteps = listOf("Coretan pendek di atas", "Garis melengkung besar ke bawah seperti angka 5"),
            relatedWords = listOf(KanaWord("らいしゅう", "raishuu", "minggu depan"), KanaWord("らく", "raku", "mudah/nyaman"), KanaWord("らくだ", "rakuda", "unta"), KanaWord("らいねん", "rainen", "tahun depan"))
        ),
        KanaCharacter(
            character = "り",
            romaji = "ri",
            category = KanaCategory.GOJUON,
            strokeCount = 2,
            strokeSteps = listOf("Garis vertikal kiri pendek berujung kait", "Garis vertikal kanan panjang melengkung ke bawah"),
            relatedWords = listOf(KanaWord("りんご", "ringo", "apel"), KanaWord("りょうり", "ryouri", "masakan"), KanaWord("りょこう", "ryokou", "wisata/perjalanan"), KanaWord("りゆう", "riyuu", "alasan"))
        ),
        KanaCharacter(
            character = "る",
            romaji = "ru",
            category = KanaCategory.GOJUON,
            strokeCount = 1,
            strokeSteps = listOf("Garis mendatar, miring ke kiri bawah, melengkung besar dengan simpul lingkaran kecil di ujung"),
            relatedWords = listOf(KanaWord("よる", "yoru", "malam"), KanaWord("くるま", "kuruma", "mobil"), KanaWord("はる", "haru", "musim semi"), KanaWord("ひる", "hiru", "siang"))
        ),
        KanaCharacter(
            character = "れ",
            romaji = "re",
            category = KanaCategory.GOJUON,
            strokeCount = 2,
            strokeSteps = listOf("Garis vertikal tegak lurus", "Garis zig-zag meliuk dengan ekor mengarah ke kanan atas"),
            relatedWords = listOf(KanaWord("れい", "rei", "contoh / nol"), KanaWord("れきし", "rekishi", "sejarah"), KanaWord("れんしゅう", "renshuu", "latihan"), KanaWord("れいぞうこ", "reizouko", "kulkas"))
        ),
        KanaCharacter(
            character = "ろ",
            romaji = "ro",
            category = KanaCategory.GOJUON,
            strokeCount = 1,
            strokeSteps = listOf("Mirip 'ru', tetapi tanpa simpul lingkaran di ujung bawah"),
            relatedWords = listOf(KanaWord("ろうそく", "rousoku", "lilin"), KanaWord("ろく", "roku", "enam"), KanaWord("ろうか", "rouka", "lorong/koridor"), KanaWord("ロシア", "roshia", "Rusia"))
        ),
        KanaCharacter(
            character = "わ",
            romaji = "wa",
            category = KanaCategory.GOJUON,
            strokeCount = 2,
            strokeSteps = listOf("Garis vertikal tegak lurus", "Garis meliuk melengkung bulat besar seperti busur panah"),
            relatedWords = listOf(KanaWord("わたし", "watashi", "saya"), KanaWord("わらう", "warau", "tertawa"), KanaWord("わかる", "wakaru", "mengerti"), KanaWord("わるい", "warui", "buruk/jelek"))
        ),
        KanaCharacter("", "", KanaCategory.GOJUON),
        KanaCharacter("", "", KanaCategory.GOJUON),
        KanaCharacter("", "", KanaCategory.GOJUON),
        KanaCharacter(
            character = "を",
            romaji = "wo",
            category = KanaCategory.GOJUON,
            strokeCount = 3,
            strokeSteps = listOf("Garis mendatar", "Garis miring melengkung", "Garis melengkung memotong di bawah (partikel objek)"),
            relatedWords = listOf(KanaWord("partikel", "wo", "partikel penanda objek kalimat"), KanaWord("ほんをよむ", "hon o yomu", "membaca buku"), KanaWord("ごはんをたべる", "gohan o taberu", "makan nasi"))
        ),
        KanaCharacter(
            character = "ん",
            romaji = "n",
            category = KanaCategory.GOJUON,
            strokeCount = 1,
            strokeSteps = listOf("Satu tarikan garis melengkung menyerupai huruf 'n' kecil latin"),
            relatedWords = listOf(KanaWord("ほん", "hon", "buku"), KanaWord("しんぶん", "shimbun", "koran"), KanaWord("みかん", "mikan", "jeruk"), KanaWord("てんぷら", "tempura", "tempura"))
        ),
        KanaCharacter("", "", KanaCategory.GOJUON),
        KanaCharacter("", "", KanaCategory.GOJUON),
        KanaCharacter("", "", KanaCategory.GOJUON),
        KanaCharacter("", "", KanaCategory.GOJUON),
    )

    val KATAKANA_GOJUON = listOf(
        KanaCharacter(
            character = "ア",
            romaji = "a",
            category = KanaCategory.GOJUON,
            strokeCount = 2,
            strokeSteps = listOf("Garis mendatar lalu miring ke kiri", "Garis melengkung memanjang ke kiri bawah"),
            relatedWords = listOf(KanaWord("アイス", "aisu", "es krim"), KanaWord("アジア", "ajia", "Asia"), KanaWord("アニメ", "anime", "animasi/anime"), KanaWord("アパート", "apaato", "apartemen"))
        ),
        KanaCharacter(
            character = "イ",
            romaji = "i",
            category = KanaCategory.GOJUON,
            strokeCount = 2,
            strokeSteps = listOf("Garis miring dari kanan atas ke kiri bawah", "Garis vertikal lurus ke bawah"),
            relatedWords = listOf(KanaWord("インド", "indo", "India"), KanaWord("インターネット", "intaanetto", "internet"), KanaWord("インク", "inku", "tinta"), KanaWord("イルカ", "iruka", "lumba-lumba"))
        ),
        KanaCharacter(
            character = "ウ",
            romaji = "u",
            category = KanaCategory.GOJUON,
            strokeCount = 3,
            strokeSteps = listOf("Titik pendek di atas", "Garis pendek vertikal kiri", "Garis mendatar berujung melengkung ke kiri bawah"),
            relatedWords = listOf(KanaWord("ウェブ", "webu", "website"), KanaWord("ウイスキー", "uisukii", "whisky"), KanaWord("ウール", "uuru", "wol"), KanaWord("ウイルス", "uirusu", "virus"))
        ),
        KanaCharacter(
            character = "エ",
            romaji = "e",
            category = KanaCategory.GOJUON,
            strokeCount = 3,
            strokeSteps = listOf("Garis mendatar atas", "Garis vertikal tengah", "Garis mendatar bawah lebih panjang"),
            relatedWords = listOf(KanaWord("エアコン", "eakon", "AC (Air Conditioner)"), KanaWord("エレベーター", "erebeetaa", "lift"), KanaWord("エスカレーター", "esukareetaa", "eskalator"), KanaWord("エネルギー", "enerugii", "energi"))
        ),
        KanaCharacter(
            character = "オ",
            romaji = "o",
            category = KanaCategory.GOJUON,
            strokeCount = 3,
            strokeSteps = listOf("Garis mendatar", "Garis vertikal berujung kait ke kiri", "Garis miring ke kanan bawah"),
            relatedWords = listOf(KanaWord("オレンジ", "orenji", "jeruk"), KanaWord("オイル", "oiru", "minyak"), KanaWord("オーストラリア", "oosutoraria", "Australia"), KanaWord("オフィス", "ofisu", "kantor"))
        ),
        KanaCharacter(
            character = "カ",
            romaji = "ka",
            category = KanaCategory.GOJUON,
            strokeCount = 2,
            strokeSteps = listOf("Garis mendatar berujung kait ke bawah", "Garis miring memotong ke kiri bawah"),
            relatedWords = listOf(KanaWord("カメラ", "kamera", "kamera"), KanaWord("カフェ", "kafe", "kafe"), KanaWord("カード", "kaado", "kartu"), KanaWord("カレー", "karee", "kari"))
        ),
        KanaCharacter(
            character = "キ",
            romaji = "ki",
            category = KanaCategory.GOJUON,
            strokeCount = 3,
            strokeSteps = listOf("Dua garis mendatar sejajar", "Garis miring memotong ke bawah"),
            relatedWords = listOf(KanaWord("キロ", "kiro", "kilo/kilometer"), KanaWord("キャンプ", "kyampu", "kemah"), KanaWord("キッチン", "kicchin", "dapur"), KanaWord("キス", "kisu", "ciuman"))
        ),
        KanaCharacter(
            character = "ク",
            romaji = "ku",
            category = KanaCategory.GOJUON,
            strokeCount = 2,
            strokeSteps = listOf("Garis miring pendek ke kiri bawah", "Garis mendatar lalu melengkung panjang ke kiri bawah"),
            relatedWords = listOf(KanaWord("クラス", "kurasu", "kelas"), KanaWord("クラブ", "kurabu", "klub"), KanaWord("クリスマス", "kurisumasu", "natal"), KanaWord("クリーニング", "kuriiningu", "laundry"))
        ),
        KanaCharacter(
            character = "ケ",
            romaji = "ke",
            category = KanaCategory.GOJUON,
            strokeCount = 3,
            strokeSteps = listOf("Garis miring pendek", "Garis mendatar", "Garis melengkung memotong ke kiri bawah"),
            relatedWords = listOf(KanaWord("ケーキ", "keeki", "kue"), KanaWord("ケース", "keesu", "wadah/kasus"), KanaWord("ケチャップ", "kechappu", "saus tomat"), KanaWord("ゲーム", "geemu", "permainan/game"))
        ),
        KanaCharacter(
            character = "コ",
            romaji = "ko",
            category = KanaCategory.GOJUON,
            strokeCount = 2,
            strokeSteps = listOf("Garis mendatar atas dengan sudut ke bawah", "Garis mendatar bawah"),
            relatedWords = listOf(KanaWord("コーヒー", "koohii", "kopi"), KanaWord("コンビニ", "kombini", "minimarket"), KanaWord("コップ", "koppu", "gelas"), KanaWord("コート", "kooto", "mantel"))
        ),
        KanaCharacter(
            character = "サ",
            romaji = "sa",
            category = KanaCategory.GOJUON,
            strokeCount = 3,
            strokeSteps = listOf("Garis mendatar", "Garis vertikal pendek kiri", "Garis vertikal memotong melengkung kanan"),
            relatedWords = listOf(KanaWord("サラダ", "sarada", "salad"), KanaWord("サンドイッチ", "sandoicchi", "roti lapis"), KanaWord("サービス", "saabisu", "layanan gratis"), KanaWord("サイクリング", "saikuringu", "bersepeda"))
        ),
        KanaCharacter(
            character = "シ",
            romaji = "shi",
            category = KanaCategory.GOJUON,
            strokeCount = 3,
            strokeSteps = listOf("Dua titik miring ke bawah", "Garis panjang menyapu dari kiri bawah ke kanan atas"),
            relatedWords = listOf(KanaWord("シャツ", "shatsu", "kemeja"), KanaWord("シャワー", "shawaa", "pancuran mandi"), KanaWord("システム", "shisutemu", "sistem"), KanaWord("ショッピング", "shoppingu", "belanja"))
        ),
        KanaCharacter(
            character = "ス",
            romaji = "su",
            category = KanaCategory.GOJUON,
            strokeCount = 2,
            strokeSteps = listOf("Garis mendatar lalu miring ke kiri", "Garis miring dari tengah ke kanan bawah"),
            relatedWords = listOf(KanaWord("スポーツ", "supootsu", "olahraga"), KanaWord("スーパー", "suupaa", "supermarket"), KanaWord("スキー", "sukii", "ski"), KanaWord("スープ", "suupu", "sup"))
        ),
        KanaCharacter(
            character = "セ",
            romaji = "se",
            category = KanaCategory.GOJUON,
            strokeCount = 2,
            strokeSteps = listOf("Garis mendatar berujung turun ke bawah", "Garis vertikal melengkung ke kanan"),
            relatedWords = listOf(KanaWord("セーター", "seetaa", "sweater"), KanaWord("センター", "sentaa", "pusat"), KanaWord("セット", "setto", "set/paket"), KanaWord("セル", "seru", "sel"))
        ),
        KanaCharacter(
            character = "ソ",
            romaji = "so",
            category = KanaCategory.GOJUON,
            strokeCount = 2,
            strokeSteps = listOf("Titik miring kiri atas", "Garis panjang dari kanan atas menyapu ke kiri bawah"),
            relatedWords = listOf(KanaWord("ソファ", "sofa", "sofa"), KanaWord("ソース", "soosu", "saus"), KanaWord("ソフト", "sofuto", "perangkat lunak"), KanaWord("ソックス", "sokkusu", "kaus kaki"))
        ),
        KanaCharacter(
            character = "タ",
            romaji = "ta",
            category = KanaCategory.GOJUON,
            strokeCount = 3,
            strokeSteps = listOf("Garis miring pendek", "Garis mendatar lalu melengkung ke bawah", "Garis miring memotong di dalam"),
            relatedWords = listOf(KanaWord("タクシー", "takushii", "taksi"), KanaWord("タオル", "taoru", "handuk"), KanaWord("タイプ", "taipu", "tipe/jenis"), KanaWord("タワー", "tawaa", "menara"))
        ),
        KanaCharacter(
            character = "チ",
            romaji = "chi",
            category = KanaCategory.GOJUON,
            strokeCount = 3,
            strokeSteps = listOf("Garis miring pendek di atas", "Garis mendatar tengah", "Garis melengkung memotong ke kiri bawah"),
            relatedWords = listOf(KanaWord("チーズ", "chiizu", "keju"), KanaWord("チーム", "chiimu", "tim"), KanaWord("チケット", "chiketto", "tiket"), KanaWord("チャンス", "chansu", "kesempatan"))
        ),
        KanaCharacter(
            character = "ツ",
            romaji = "tsu",
            category = KanaCategory.GOJUON,
            strokeCount = 3,
            strokeSteps = listOf("Dua titik hampir vertikal sejajar", "Garis panjang menyapu dari kanan atas ke kiri bawah"),
            relatedWords = listOf(KanaWord("ツアー", "tsuaa", "tur/wisata"), KanaWord("ツイン", "tsuin", "kembar/twin bed"), KanaWord("ツール", "tsuuru", "alat/tool"), KanaWord("ツアー", "tsuaa", "tur"))
        ),
        KanaCharacter(
            character = "テ",
            romaji = "te",
            category = KanaCategory.GOJUON,
            strokeCount = 3,
            strokeSteps = listOf("Garis mendatar pendek atas", "Garis mendatar panjang tengah", "Garis melengkung memotong ke kiri bawah"),
            relatedWords = listOf(KanaWord("テレビ", "terebi", "televisi"), KanaWord("テーブル", "teeburu", "meja makan"), KanaWord("テスト", "tesuto", "ujian/tes"), KanaWord("テニス", "tenisu", "tenis"))
        ),
        KanaCharacter(
            character = "ト",
            romaji = "to",
            category = KanaCategory.GOJUON,
            strokeCount = 2,
            strokeSteps = listOf("Garis vertikal tegak lurus", "Garis miring pendek ke kanan bawah"),
            relatedWords = listOf(KanaWord("トイレ", "toire", "toilet"), KanaWord("トマト", "tomato", "tomat"), KanaWord("トースト", "toosuto", "roti panggang"), KanaWord("トラック", "torakku", "truk"))
        ),
        KanaCharacter(
            character = "ナ",
            romaji = "na",
            category = KanaCategory.GOJUON,
            strokeCount = 2,
            strokeSteps = listOf("Garis mendatar", "Garis memotong melengkung ke kiri bawah"),
            relatedWords = listOf(KanaWord("ナイフ", "naifu", "pisau"), KanaWord("ナンバー", "nambaa", "nomor"), KanaWord("ナイロン", "nairon", "nilon"), KanaWord("ナプキン", "napukin", "serbet"))
        ),
        KanaCharacter(
            character = "ニ",
            romaji = "ni",
            category = KanaCategory.GOJUON,
            strokeCount = 2,
            strokeSteps = listOf("Dua garis mendatar sejajar (atas lebih pendek)"),
            relatedWords = listOf(KanaWord("ニュース", "nyuusu", "berita"), KanaWord("ニックネーム", "nikkuneemu", "nama panggilan"), KanaWord("ニコチン", "nikochin", "nikotin"), KanaWord("ニッケル", "nikkeru", "nikel"))
        ),
        KanaCharacter(
            character = "ヌ",
            romaji = "nu",
            category = KanaCategory.GOJUON,
            strokeCount = 2,
            strokeSteps = listOf("Garis mendatar lalu miring ke kiri bawah", "Garis miring memotong ke kanan bawah"),
            relatedWords = listOf(KanaWord("ヌードル", "nuudoru", "mi"), KanaWord("ヌード", "nuudo", "telanjang"), KanaWord("ヌガー", "nugaa", "permen nougat"), KanaWord("ヌバック", "nubakku", "kulit nubuck"))
        ),
        KanaCharacter(
            character = "ネ",
            romaji = "ne",
            category = KanaCategory.GOJUON,
            strokeCount = 4,
            strokeSteps = listOf("Titik atas", "Garis vertikal kiri", "Garis mendatar menyudut", "Garis miring kanan"),
            relatedWords = listOf(KanaWord("ネクタイ", "nekutai", "dasi"), KanaWord("ネット", "netto", "internet"), KanaWord("ネガ", "nega", "film negatif"), KanaWord("ネットワーク", "nettowaaku", "jaringan"))
        ),
        KanaCharacter(
            character = "ノ",
            romaji = "no",
            category = KanaCategory.GOJUON,
            strokeCount = 1,
            strokeSteps = listOf("Satu garis miring melengkung dari kanan atas ke kiri bawah"),
            relatedWords = listOf(KanaWord("ノート", "nooto", "buku catatan"), KanaWord("ノーマル", "noomaru", "normal"), KanaWord("ノック", "nokku", "mengetuk pintu"), KanaWord("ノンアルコール", "non'arukooru", "bebas alkohol"))
        ),
        KanaCharacter(
            character = "ハ",
            romaji = "ha",
            category = KanaCategory.GOJUON,
            strokeCount = 2,
            strokeSteps = listOf("Garis miring ke kiri bawah", "Garis miring ke kanan bawah (membentuk tenda terbuka)"),
            relatedWords = listOf(KanaWord("ハンバーガー", "hambaagaa", "hamburger"), KanaWord("ハワイ", "hawai", "Hawaii"), KanaWord("ハム", "hamu", "daging ham"), KanaWord("ハサミ", "hasami", "gunting"))
        ),
        KanaCharacter(
            character = "ヒ",
            romaji = "hi",
            category = KanaCategory.GOJUON,
            strokeCount = 2,
            strokeSteps = listOf("Garis mendatar lalu vertikal ke bawah", "Garis melengkung dari kiri ke kanan atas"),
            relatedWords = listOf(KanaWord("ヒーター", "hiitaa", "pemanas ruangan"), KanaWord("ヒーロー", "hiiroo", "pahlawan"), KanaWord("ヒント", "hinto", "petunjuk"), KanaWord("ヒット", "hitto", "populer/hit"))
        ),
        KanaCharacter(
            character = "フ",
            romaji = "fu",
            category = KanaCategory.GOJUON,
            strokeCount = 1,
            strokeSteps = listOf("Garis mendatar lalu menyudut miring melengkung ke kiri bawah"),
            relatedWords = listOf(KanaWord("フォーク", "fooku", "garpu"), KanaWord("フランス", "furansu", "Prancis"), KanaWord("フルーツ", "furuutsu", "buah-buahan"), KanaWord("フライト", "furaito", "penerbangan"))
        ),
        KanaCharacter(
            character = "ヘ",
            romaji = "he",
            category = KanaCategory.GOJUON,
            strokeCount = 1,
            strokeSteps = listOf("Satu garis membentuk puncak atap miring ke kanan (identik dengan hiragana)"),
            relatedWords = listOf(KanaWord("ヘルメット", "herumetto", "helm"), KanaWord("ヘッドホン", "heddohon", "headphone"), KanaWord("ヘリコプター", "herikoputaa", "helikopter"), KanaWord("ヘルシー", "herushii", "sehat"))
        ),
        KanaCharacter(
            character = "ホ",
            romaji = "ho",
            category = KanaCategory.GOJUON,
            strokeCount = 4,
            strokeSteps = listOf("Garis mendatar", "Garis vertikal memotong dengan kait", "Dua garis miring di kiri dan kanan"),
            relatedWords = listOf(KanaWord("ホテル", "hoteru", "hotel"), KanaWord("ホット", "hotto", "panas/hangat"), KanaWord("ホーム", "hoomu", "peron stasiun"), KanaWord("ホワイト", "howaito", "putih"))
        ),
        KanaCharacter(
            character = "マ",
            romaji = "ma",
            category = KanaCategory.GOJUON,
            strokeCount = 2,
            strokeSteps = listOf("Garis mendatar lalu miring ke kiri", "Garis miring pendek ke kanan bawah"),
            relatedWords = listOf(KanaWord("マスク", "masuku", "masker"), KanaWord("マンション", "manshon", "apartemen"), KanaWord("マイク", "maiku", "mikrofon"), KanaWord("マッチ", "macchi", "korek api"))
        ),
        KanaCharacter(
            character = "ミ",
            romaji = "mi",
            category = KanaCategory.GOJUON,
            strokeCount = 3,
            strokeSteps = listOf("Tiga garis miring pendek sejajar dari kiri atas ke kanan bawah"),
            relatedWords = listOf(KanaWord("ミルク", "miruku", "susu sapi"), KanaWord("ミス", "misu", "kesalahan/miss"), KanaWord("ミシン", "mishin", "mesin jahit"), KanaWord("ミュージアム", "myuujiamu", "museum"))
        ),
        KanaCharacter(
            character = "ム",
            romaji = "mu",
            category = KanaCategory.GOJUON,
            strokeCount = 2,
            strokeSteps = listOf("Garis miring menyudut ke kanan bawah", "Garis mendatar memotong di bawah"),
            relatedWords = listOf(KanaWord("ムービー", "muubii", "film bioskop"), KanaWord("ムード", "muudo", "suasana hati/mood"), KanaWord("ムール貝", "muurugai", "kerang remis"), KanaWord("ムース", "muusu", "kue mousse"))
        ),
        KanaCharacter(
            character = "メ",
            romaji = "me",
            category = KanaCategory.GOJUON,
            strokeCount = 2,
            strokeSteps = listOf("Garis miring dari kanan atas ke kiri bawah", "Garis miring memotong dari kiri atas ke kanan bawah"),
            relatedWords = listOf(KanaWord("メニュー", "menyuu", "daftar menu"), KanaWord("メール", "meeru", "email/pesan"), KanaWord("メロン", "meron", "melon"), KanaWord("メーター", "meetaa", "meteran"))
        ),
        KanaCharacter(
            character = "モ",
            romaji = "mo",
            category = KanaCategory.GOJUON,
            strokeCount = 3,
            strokeSteps = listOf("Dua garis mendatar sejajar", "Garis vertikal melengkung ke kanan di bawah"),
            relatedWords = listOf(KanaWord("モデル", "moderu", "model"), KanaWord("モダン", "modan", "modern"), KanaWord("モーター", "mootaa", "motor penggerak"), KanaWord("モーニング", "mooningu", "pagi hari"))
        ),
        KanaCharacter(
            character = "ヤ",
            romaji = "ya",
            category = KanaCategory.GOJUON,
            strokeCount = 2,
            strokeSteps = listOf("Garis mendatar menyudut melengkung ke kiri bawah", "Garis miring memotong dari atas ke kanan bawah"),
            relatedWords = listOf(KanaWord("ヤング", "yangu", "muda"), KanaWord("ヤード", "yaado", "yard/halaman"), KanaWord("ダイヤ", "daiya", "berlian/intan"), KanaWord("タイヤ", "taiya", "ban kendaraan"))
        ),
        KanaCharacter("", "", KanaCategory.GOJUON),
        KanaCharacter(
            character = "ユ",
            romaji = "yu",
            category = KanaCategory.GOJUON,
            strokeCount = 2,
            strokeSteps = listOf("Garis mendatar lalu vertikal ke bawah", "Garis mendatar panjang memotong di bawah"),
            relatedWords = listOf(KanaWord("ユーザー", "yuuzaa", "pengguna/user"), KanaWord("ユニフォーム", "yunifoomu", "seragam"), KanaWord("ユーモア", "yuumoa", "humor"), KanaWord("ユーロ", "yuuro", "mata uang Euro"))
        ),
        KanaCharacter("", "", KanaCategory.GOJUON),
        KanaCharacter(
            character = "ヨ",
            romaji = "yo",
            category = KanaCategory.GOJUON,
            strokeCount = 3,
            strokeSteps = listOf("Garis mendatar lalu vertikal", "Dua garis mendatar sejajar di dalam"),
            relatedWords = listOf(KanaWord("ヨーグルト", "yooguruto", "yogurt"), KanaWord("ヨーロッパ", "yooroppa", "Eropa"), KanaWord("ヨット", "yotto", "kapal pesiar yacht"), KanaWord("ヨガ", "yoga", "senam yoga"))
        ),
        KanaCharacter(
            character = "ラ",
            romaji = "ra",
            category = KanaCategory.GOJUON,
            strokeCount = 2,
            strokeSteps = listOf("Garis mendatar pendek atas", "Garis mendatar berujung melengkung panjang ke kiri"),
            relatedWords = listOf(KanaWord("ラジオ", "rajio", "radio"), KanaWord("ライオン", "raion", "singa"), KanaWord("ライト", "raito", "lampu/cahaya"), KanaWord("ラーメン", "raamen", "mi ramen"))
        ),
        KanaCharacter(
            character = "リ",
            romaji = "ri",
            category = KanaCategory.GOJUON,
            strokeCount = 2,
            strokeSteps = listOf("Dua garis vertikal tegak lurus sejajar (kanan lebih panjang)"),
            relatedWords = listOf(KanaWord("リモコン", "rimokon", "remote control"), KanaWord("リーダー", "riidaa", "pemimpin/leader"), KanaWord("リズム", "rizumu", "ritme/irama"), KanaWord("リンス", "rinsu", "kondisioner rambut"))
        ),
        KanaCharacter(
            character = "ル",
            romaji = "ru",
            category = KanaCategory.GOJUON,
            strokeCount = 2,
            strokeSteps = listOf("Garis miring kiri", "Garis melengkung ke kanan bawah berujung kait ke atas"),
            relatedWords = listOf(KanaWord("ルール", "ruuru", "peraturan/aturan"), KanaWord("ルビー", "rubii", "batu permata delima"), KanaWord("ルート", "ruuto", "rute/jalan"), KanaWord("ルックス", "rukkusu", "penampilan luar"))
        ),
        KanaCharacter(
            character = "レ",
            romaji = "re",
            category = KanaCategory.GOJUON,
            strokeCount = 1,
            strokeSteps = listOf("Garis vertikal turun lalu melengkung tajam ke kanan atas"),
            relatedWords = listOf(KanaWord("レストラン", "resutoran", "restoran"), KanaWord("レシート", "reshiito", "struk belanja"), KanaWord("レモン", "remon", "lemon"), KanaWord("レベル", "reberu", "tingkat/level"))
        ),
        KanaCharacter(
            character = "ロ",
            romaji = "ro",
            category = KanaCategory.GOJUON,
            strokeCount = 3,
            strokeSteps = listOf("Membentuk persegi/kotak: vertikal kiri, mendatar berbelok ke bawah, mendatar penutup"),
            relatedWords = listOf(KanaWord("ロボット", "robotto", "robot"), KanaWord("ロッカー", "rokkaa", "loker penyimpanan"), KanaWord("ロケット", "roketto", "roket antariksa"), KanaWord("ロシア", "roshia", "Rusia"))
        ),
        KanaCharacter(
            character = "ワ",
            romaji = "wa",
            category = KanaCategory.GOJUON,
            strokeCount = 2,
            strokeSteps = listOf("Garis vertikal pendek kiri", "Garis mendatar berbelok melengkung ke kiri bawah"),
            relatedWords = listOf(KanaWord("ワイン", "wain", "minuman anggur"), KanaWord("ワイシャツ", "waishatsu", "kemeja putih"), KanaWord("ワンピース", "wanpiisu", "baju terusan gaun"), KanaWord("ワット", "watto", "daya watt"))
        ),
        KanaCharacter("", "", KanaCategory.GOJUON),
        KanaCharacter("", "", KanaCategory.GOJUON),
        KanaCharacter("", "", KanaCategory.GOJUON),
        KanaCharacter(
            character = "ヲ",
            romaji = "wo",
            category = KanaCategory.GOJUON,
            strokeCount = 3,
            strokeSteps = listOf("Garis mendatar atas", "Garis mendatar tengah menyudut miring", "Garis miring bawah"),
            relatedWords = listOf(KanaWord("kata arkaik", "wo", "partikel/kata serapan arkaik"), KanaWord("ヲタク", "wotaku", "penggemar berat anime/otaku"))
        ),
        KanaCharacter(
            character = "ン",
            romaji = "n",
            category = KanaCategory.GOJUON,
            strokeCount = 2,
            strokeSteps = listOf("Titik miring di kiri", "Garis menyapu dari kiri bawah ke kanan atas"),
            relatedWords = listOf(KanaWord("パン", "pan", "roti"), KanaWord("マンション", "manshon", "apartemen"), KanaWord("レストラン", "resutoran", "restoran"), KanaWord("ボタン", "botan", "tombol/kancing"))
        ),
        KanaCharacter("", "", KanaCategory.GOJUON),
        KanaCharacter("", "", KanaCategory.GOJUON),
        KanaCharacter("", "", KanaCategory.GOJUON),
        KanaCharacter("", "", KanaCategory.GOJUON),
    )

    val HIRAGANA_DAKUON = listOf(
        KanaCharacter(
            character = "が",
            romaji = "ga",
            category = KanaCategory.DAKUON,
            strokeCount = 5,
            strokeSteps = listOf("か dengan dua tanda kutip (teng-teng) di kanan atas"),
            relatedWords = listOf(KanaWord("がっこう", "gakkou", "sekolah"), KanaWord("がいこく", "gaikoku", "luar negeri"))
        ),
        KanaCharacter(
            character = "ぎ",
            romaji = "gi",
            category = KanaCategory.DAKUON,
            strokeCount = 6,
            strokeSteps = listOf("き dengan dua tanda kutip di kanan atas"),
            relatedWords = listOf(KanaWord("ぎんこう", "ginkou", "bank"), KanaWord("ぎゅうにく", "gyuuniku", "daging sapi"))
        ),
        KanaCharacter(
            character = "ぐ",
            romaji = "gu",
            category = KanaCategory.DAKUON,
            strokeCount = 3,
            strokeSteps = listOf("く dengan dua tanda kutip di kanan atas"),
            relatedWords = listOf(KanaWord("ぐあい", "guai", "kondisi tubuh"), KanaWord("ぐらい", "gurai", "kira-kira"))
        ),
        KanaCharacter(
            character = "げ",
            romaji = "ge",
            category = KanaCategory.DAKUON,
            strokeCount = 5,
            strokeSteps = listOf("け dengan dua tanda kutip di kanan atas"),
            relatedWords = listOf(KanaWord("げんき", "genki", "sehat/semangat"), KanaWord("げつようび", "getsuyoubi", "hari Senin"))
        ),
        KanaCharacter(
            character = "ご",
            romaji = "go",
            category = KanaCategory.DAKUON,
            strokeCount = 4,
            strokeSteps = listOf("こ dengan dua tanda kutip di kanan atas"),
            relatedWords = listOf(KanaWord("ごはん", "gohan", "nasi/makan"), KanaWord("ごご", "gogo", "sore/p.m."))
        ),
        KanaCharacter(
            character = "ざ",
            romaji = "za",
            category = KanaCategory.DAKUON,
            strokeCount = 5,
            strokeSteps = listOf("さ dengan dua tanda kutip di kanan atas"),
            relatedWords = listOf(KanaWord("ざっし", "zasshi", "majalah"), KanaWord("ざんねん", "zannen", "sayang sekali"))
        ),
        KanaCharacter(
            character = "じ",
            romaji = "ji",
            category = KanaCategory.DAKUON,
            strokeCount = 3,
            strokeSteps = listOf("し dengan dua tanda kutip di kanan atas"),
            relatedWords = listOf(KanaWord("じかん", "jikan", "waktu"), KanaWord("じしょ", "jisho", "kamus"))
        ),
        KanaCharacter(
            character = "ず",
            romaji = "zu",
            category = KanaCategory.DAKUON,
            strokeCount = 4,
            strokeSteps = listOf("す dengan dua tanda kutip di kanan atas"),
            relatedWords = listOf(KanaWord("みず", "mizu", "air"), KanaWord("ずっと", "zutto", "terus-menerus"))
        ),
        KanaCharacter(
            character = "ぜ",
            romaji = "ze",
            category = KanaCategory.DAKUON,
            strokeCount = 5,
            strokeSteps = listOf("せ dengan dua tanda kutip di kanan atas"),
            relatedWords = listOf(KanaWord("ぜんぶ", "zembu", "semua"), KanaWord("ぜろ", "zero", "nol"))
        ),
        KanaCharacter(
            character = "ぞ",
            romaji = "zo",
            category = KanaCategory.DAKUON,
            strokeCount = 3,
            strokeSteps = listOf("そ dengan dua tanda kutip di kanan atas"),
            relatedWords = listOf(KanaWord("ぞう", "zou", "gajah"), KanaWord("ぞくぞく", "zokuzoku", "menggigil/antusias"))
        ),
        KanaCharacter(
            character = "だ",
            romaji = "da",
            category = KanaCategory.DAKUON,
            strokeCount = 6,
            strokeSteps = listOf("た dengan dua tanda kutip di kanan atas"),
            relatedWords = listOf(KanaWord("だいがく", "daigaku", "universitas"), KanaWord("だれ", "dare", "siapa"))
        ),
        KanaCharacter(
            character = "ぢ",
            romaji = "ji",
            category = KanaCategory.DAKUON,
            strokeCount = 4,
            strokeSteps = listOf("ち dengan dua tanda kutip di kanan atas"),
            relatedWords = listOf(KanaWord("はなぢ", "hanaji", "mimisan"), KanaWord("ちぢむ", "chidimu", "menyusut"))
        ),
        KanaCharacter(
            character = "づ",
            romaji = "zu",
            category = KanaCategory.DAKUON,
            strokeCount = 3,
            strokeSteps = listOf("つ dengan dua tanda kutip di kanan atas"),
            relatedWords = listOf(KanaWord("つづく", "tsuzuku", "berlanjut"), KanaWord("つづき", "tsuzuki", "kelanjutan"))
        ),
        KanaCharacter(
            character = "で",
            romaji = "de",
            category = KanaCategory.DAKUON,
            strokeCount = 3,
            strokeSteps = listOf("て dengan dua tanda kutip di kanan atas"),
            relatedWords = listOf(KanaWord("でんしゃ", "densha", "kereta"), KanaWord("でんわ", "denwa", "telepon"))
        ),
        KanaCharacter(
            character = "ど",
            romaji = "do",
            category = KanaCategory.DAKUON,
            strokeCount = 4,
            strokeSteps = listOf("と dengan dua tanda kutip di kanan atas"),
            relatedWords = listOf(KanaWord("どこ", "doko", "di mana"), KanaWord("どうして", "doushite", "kenapa/mengapa"))
        ),
        KanaCharacter(
            character = "ば",
            romaji = "ba",
            category = KanaCategory.DAKUON,
            strokeCount = 5,
            strokeSteps = listOf("は dengan dua tanda kutip di kanan atas"),
            relatedWords = listOf(KanaWord("ばんごう", "bangou", "nomor"), KanaWord("ばんごはん", "bangohan", "makan malam"))
        ),
        KanaCharacter(
            character = "び",
            romaji = "bi",
            category = KanaCategory.DAKUON,
            strokeCount = 3,
            strokeSteps = listOf("ひ dengan dua tanda kutip di kanan atas"),
            relatedWords = listOf(KanaWord("びょういん", "byouin", "rumah sakit"), KanaWord("びじゅつかん", "bijutsukan", "museum seni"))
        ),
        KanaCharacter(
            character = "ぶ",
            romaji = "bu",
            category = KanaCategory.DAKUON,
            strokeCount = 6,
            strokeSteps = listOf("ふ dengan dua tanda kutip di kanan atas"),
            relatedWords = listOf(KanaWord("ぶんか", "bunka", "budaya"), KanaWord("ぶた", "buta", "babi"))
        ),
        KanaCharacter(
            character = "べ",
            romaji = "be",
            category = KanaCategory.DAKUON,
            strokeCount = 3,
            strokeSteps = listOf("へ dengan dua tanda kutip di kanan atas"),
            relatedWords = listOf(KanaWord("べんきょう", "benkyou", "belajar"), KanaWord("べんり", "benri", "praktis"))
        ),
        KanaCharacter(
            character = "ぼ",
            romaji = "bo",
            category = KanaCategory.DAKUON,
            strokeCount = 6,
            strokeSteps = listOf("ほ dengan dua tanda kutip di kanan atas"),
            relatedWords = listOf(KanaWord("ぼうし", "boushi", "topi"), KanaWord("ぼく", "boku", "aku (laki-laki)"))
        ),
        KanaCharacter(
            character = "ぱ",
            romaji = "pa",
            category = KanaCategory.DAKUON,
            strokeCount = 4,
            strokeSteps = listOf("は dengan lingkaran kecil (maru) di kanan atas"),
            relatedWords = listOf(KanaWord("パン", "pan", "roti"), KanaWord("ぱらぱら", "parapara", "gerimis/berhamburan"))
        ),
        KanaCharacter(
            character = "ぴ",
            romaji = "pi",
            category = KanaCategory.DAKUON,
            strokeCount = 2,
            strokeSteps = listOf("ひ dengan lingkaran kecil di kanan atas"),
            relatedWords = listOf(KanaWord("ぴかぴか", "pikapika", "berkilau"), KanaWord("ピアノ", "piano", "piano"))
        ),
        KanaCharacter(
            character = "ぷ",
            romaji = "pu",
            category = KanaCategory.DAKUON,
            strokeCount = 5,
            strokeSteps = listOf("ふ dengan lingkaran kecil di kanan atas"),
            relatedWords = listOf(KanaWord("てんぷら", "tempura", "tempura gorengan"), KanaWord("プール", "puuru", "kolam renang"))
        ),
        KanaCharacter(
            character = "ぺ",
            romaji = "pe",
            category = KanaCategory.DAKUON,
            strokeCount = 2,
            strokeSteps = listOf("へ dengan lingkaran kecil di kanan atas"),
            relatedWords = listOf(KanaWord("ぺこぺこ", "pekopeko", "lapar keroncongan"), KanaWord("ペン", "pen", "pena/pulpen"))
        ),
        KanaCharacter(
            character = "ぽ",
            romaji = "po",
            category = KanaCategory.DAKUON,
            strokeCount = 5,
            strokeSteps = listOf("ほ dengan lingkaran kecil di kanan atas"),
            relatedWords = listOf(KanaWord("さんぽ", "sampo", "jalan-jalan santai"), KanaWord("ポスト", "posuto", "kotak pos"))
        ),
    )

    val KATAKANA_DAKUON = listOf(
        KanaCharacter(
            character = "ガ",
            romaji = "ga",
            category = KanaCategory.DAKUON,
            strokeCount = 4,
            strokeSteps = listOf("カ dengan dua tanda kutip di kanan atas"),
            relatedWords = listOf(KanaWord("ガス", "gasu", "gas"), KanaWord("ガラス", "garasu", "kaca"))
        ),
        KanaCharacter(
            character = "ギ",
            romaji = "gi",
            category = KanaCategory.DAKUON,
            strokeCount = 5,
            strokeSteps = listOf("キ dengan dua tanda kutip di kanan atas"),
            relatedWords = listOf(KanaWord("ギター", "gitaa", "gitar"), KanaWord("ギャング", "gyangu", "geng"))
        ),
        KanaCharacter(
            character = "グ",
            romaji = "gu",
            category = KanaCategory.DAKUON,
            strokeCount = 4,
            strokeSteps = listOf("ク dengan dua tanda kutip di kanan atas"),
            relatedWords = listOf(KanaWord("グラス", "gurasu", "gelas kaca"), KanaWord("グループ", "guruupu", "kelompok/grup"))
        ),
        KanaCharacter(
            character = "ゲ",
            romaji = "ge",
            category = KanaCategory.DAKUON,
            strokeCount = 5,
            strokeSteps = listOf("ケ dengan dua tanda kutip di kanan atas"),
            relatedWords = listOf(KanaWord("ゲーム", "geemu", "permainan/game"), KanaWord("ゲスト", "gesuto", "tamu"))
        ),
        KanaCharacter(
            character = "ゴ",
            romaji = "go",
            category = KanaCategory.DAKUON,
            strokeCount = 4,
            strokeSteps = listOf("コ dengan dua tanda kutip di kanan atas"),
            relatedWords = listOf(KanaWord("ゴルフ", "gorufu", "golf"), KanaWord("ゴール", "gooru", "tujuan/gawang"))
        ),
        KanaCharacter(
            character = "ザ",
            romaji = "za",
            category = KanaCategory.DAKUON,
            strokeCount = 5,
            strokeSteps = listOf("サ dengan dua tanda kutip di kanan atas"),
            relatedWords = listOf(KanaWord("デザート", "dezaato", "hidangan penutup"), KanaWord("サイズ", "saizu", "ukuran/size"))
        ),
        KanaCharacter(
            character = "ジ",
            romaji = "ji",
            category = KanaCategory.DAKUON,
            strokeCount = 5,
            strokeSteps = listOf("シ dengan dua tanda kutip di kanan atas"),
            relatedWords = listOf(KanaWord("ジュース", "juusu", "jus buah"), KanaWord("ジーンズ", "jiinzu", "celana jeans"))
        ),
        KanaCharacter(
            character = "ズ",
            romaji = "zu",
            category = KanaCategory.DAKUON,
            strokeCount = 4,
            strokeSteps = listOf("ス dengan dua tanda kutip di kanan atas"),
            relatedWords = listOf(KanaWord("ズボン", "zubon", "celana panjang"), KanaWord("チーズ", "chiizu", "keju"))
        ),
        KanaCharacter(
            character = "ゼ",
            romaji = "ze",
            category = KanaCategory.DAKUON,
            strokeCount = 4,
            strokeSteps = listOf("セ dengan dua tanda kutip di kanan atas"),
            relatedWords = listOf(KanaWord("ゼロ", "zero", "angka nol"), KanaWord("ゼリー", "zerii", "jeli"))
        ),
        KanaCharacter(
            character = "ゾ",
            romaji = "zo",
            category = KanaCategory.DAKUON,
            strokeCount = 4,
            strokeSteps = listOf("ソ dengan dua tanda kutip di kanan atas"),
            relatedWords = listOf(KanaWord("ゾーン", "zoon", "wilayah/zona"), KanaWord("ゾンビ", "zombi", "zombie"))
        ),
        KanaCharacter(
            character = "ダ",
            romaji = "da",
            category = KanaCategory.DAKUON,
            strokeCount = 5,
            strokeSteps = listOf("タ dengan dua tanda kutip di kanan atas"),
            relatedWords = listOf(KanaWord("ダンス", "dansu", "menari/tarian"), KanaWord("ダイヤ", "daiya", "berlian"))
        ),
        KanaCharacter(
            character = "ヂ",
            romaji = "ji",
            category = KanaCategory.DAKUON,
            strokeCount = 5,
            strokeSteps = listOf("チ dengan dua tanda kutip di kanan atas"),
            relatedWords = listOf(KanaWord("ヂ", "ji", "ji (varian dakuon)"))
        ),
        KanaCharacter(
            character = "ヅ",
            romaji = "zu",
            category = KanaCategory.DAKUON,
            strokeCount = 5,
            strokeSteps = listOf("ツ dengan dua tanda kutip di kanan atas"),
            relatedWords = listOf(KanaWord("ヅ", "zu", "zu (varian dakuon)"))
        ),
        KanaCharacter(
            character = "デ",
            romaji = "de",
            category = KanaCategory.DAKUON,
            strokeCount = 5,
            strokeSteps = listOf("テ dengan dua tanda kutip di kanan atas"),
            relatedWords = listOf(KanaWord("デパート", "depaato", "pusat perbelanjaan"), KanaWord("デザイン", "dezain", "desain"))
        ),
        KanaCharacter(
            character = "ド",
            romaji = "do",
            category = KanaCategory.DAKUON,
            strokeCount = 4,
            strokeSteps = listOf("ト dengan dua tanda kutip di kanan atas"),
            relatedWords = listOf(KanaWord("ドア", "doa", "pintu"), KanaWord("ドラマ", "dorama", "drama"))
        ),
        KanaCharacter(
            character = "バ",
            romaji = "ba",
            category = KanaCategory.DAKUON,
            strokeCount = 4,
            strokeSteps = listOf("ハ dengan dua tanda kutip di kanan atas"),
            relatedWords = listOf(KanaWord("バス", "basu", "bus"), KanaWord("バター", "bataa", "mentega"))
        ),
        KanaCharacter(
            character = "ビ",
            romaji = "bi",
            category = KanaCategory.DAKUON,
            strokeCount = 4,
            strokeSteps = listOf("ヒ dengan dua tanda kutip di kanan atas"),
            relatedWords = listOf(KanaWord("ビル", "biru", "gedung bertingkat"), KanaWord("ビール", "biiru", "bir"))
        ),
        KanaCharacter(
            character = "ブ",
            romaji = "bu",
            category = KanaCategory.DAKUON,
            strokeCount = 3,
            strokeSteps = listOf("フ dengan dua tanda kutip di kanan atas"),
            relatedWords = listOf(KanaWord("ブーツ", "buutsu", "sepatu bot"), KanaWord("ブラシ", "burashi", "sikat"))
        ),
        KanaCharacter(
            character = "ベ",
            romaji = "be",
            category = KanaCategory.DAKUON,
            strokeCount = 3,
            strokeSteps = listOf("ヘ dengan dua tanda kutip di kanan atas"),
            relatedWords = listOf(KanaWord("ベッド", "beddo", "tempat tidur/kasur"), KanaWord("ベルト", "beruto", "ikat pinggang"))
        ),
        KanaCharacter(
            character = "ボ",
            romaji = "bo",
            category = KanaCategory.DAKUON,
            strokeCount = 6,
            strokeSteps = listOf("ホ dengan dua tanda kutip di kanan atas"),
            relatedWords = listOf(KanaWord("ボタン", "botan", "tombol/kancing"), KanaWord("ボール", "booru", "bola"))
        ),
        KanaCharacter(
            character = "パ",
            romaji = "pa",
            category = KanaCategory.DAKUON,
            strokeCount = 3,
            strokeSteps = listOf("ハ dengan lingkaran kecil di kanan atas"),
            relatedWords = listOf(KanaWord("パン", "pan", "roti"), KanaWord("パーティー", "paatii", "pesta"))
        ),
        KanaCharacter(
            character = "ピ",
            romaji = "pi",
            category = KanaCategory.DAKUON,
            strokeCount = 3,
            strokeSteps = listOf("ヒ dengan lingkaran kecil di kanan atas"),
            relatedWords = listOf(KanaWord("ピアノ", "piano", "piano"), KanaWord("ピザ", "piza", "pizza"))
        ),
        KanaCharacter(
            character = "プ",
            romaji = "pu",
            category = KanaCategory.DAKUON,
            strokeCount = 2,
            strokeSteps = listOf("フ dengan lingkaran kecil di kanan atas"),
            relatedWords = listOf(KanaWord("プール", "puuru", "kolam renang"), KanaWord("プレゼント", "purezento", "hadiah"))
        ),
        KanaCharacter(
            character = "ペ",
            romaji = "pe",
            category = KanaCategory.DAKUON,
            strokeCount = 2,
            strokeSteps = listOf("ヘ dengan lingkaran kecil di kanan atas"),
            relatedWords = listOf(KanaWord("ペン", "pen", "pulpen/pena"), KanaWord("ペット", "petto", "hewan peliharaan"))
        ),
        KanaCharacter(
            character = "ポ",
            romaji = "po",
            category = KanaCategory.DAKUON,
            strokeCount = 5,
            strokeSteps = listOf("ホ dengan lingkaran kecil di kanan atas"),
            relatedWords = listOf(KanaWord("ポスト", "posuto", "kotak pos"), KanaWord("ポケット", "poketto", "saku baju"))
        ),
    )

    val HIRAGANA_YOON = listOf(
        KanaCharacter(
            character = "きゃ",
            romaji = "kya",
            category = KanaCategory.YOON,
            strokeCount = 6,
            strokeSteps = listOf("き ditambah ゃ kecil"),
            relatedWords = listOf(KanaWord("きゃく", "kyaku", "tamu/pelanggan"))
        ),
        KanaCharacter(
            character = "きゅ",
            romaji = "kyu",
            category = KanaCategory.YOON,
            strokeCount = 5,
            strokeSteps = listOf("き ditambah ゅ kecil"),
            relatedWords = listOf(KanaWord("きゅう", "kyuu", "angka sembilan"))
        ),
        KanaCharacter(
            character = "きょ",
            romaji = "kyo",
            category = KanaCategory.YOON,
            strokeCount = 5,
            strokeSteps = listOf("き ditambah ょ kecil"),
            relatedWords = listOf(KanaWord("きょう", "kyou", "hari ini"))
        ),
        KanaCharacter(
            character = "しゃ",
            romaji = "sha",
            category = KanaCategory.YOON,
            strokeCount = 3,
            strokeSteps = listOf("し ditambah ゃ kecil"),
            relatedWords = listOf(KanaWord("しゃしん", "shashin", "foto"))
        ),
        KanaCharacter(
            character = "しゅ",
            romaji = "shu",
            category = KanaCategory.YOON,
            strokeCount = 2,
            strokeSteps = listOf("し ditambah ゅ kecil"),
            relatedWords = listOf(KanaWord("しゅくだい", "shukudai", "pekerjaan rumah (PR)"))
        ),
        KanaCharacter(
            character = "しょ",
            romaji = "sho",
            category = KanaCategory.YOON,
            strokeCount = 2,
            strokeSteps = listOf("し ditambah ょ kecil"),
            relatedWords = listOf(KanaWord("しょくどう", "shokudou", "kantin/ruang makan"))
        ),
        KanaCharacter(
            character = "ちゃ",
            romaji = "cha",
            category = KanaCategory.YOON,
            strokeCount = 4,
            strokeSteps = listOf("ち ditambah ゃ kecil"),
            relatedWords = listOf(KanaWord("おちゃ", "ocha", "teh hijau Jepang"))
        ),
        KanaCharacter(
            character = "ちゅ",
            romaji = "chu",
            category = KanaCategory.YOON,
            strokeCount = 3,
            strokeSteps = listOf("ち ditambah ゅ kecil"),
            relatedWords = listOf(KanaWord("ちゅうごく", "chuugoku", "negara Tiongkok"))
        ),
        KanaCharacter(
            character = "ちょ",
            romaji = "cho",
            category = KanaCategory.YOON,
            strokeCount = 3,
            strokeSteps = listOf("ち ditambah ょ kecil"),
            relatedWords = listOf(KanaWord("ちょっと", "chotto", "sebentar/sedikit"))
        ),
        KanaCharacter(
            character = "にゃ",
            romaji = "nya",
            category = KanaCategory.YOON,
            strokeCount = 5,
            strokeSteps = listOf("に ditambah ゃ kecil"),
            relatedWords = listOf(KanaWord("にゃー", "nyaa", "suara kucing mengeong"))
        ),
        KanaCharacter(
            character = "にゅ",
            romaji = "nyu",
            category = KanaCategory.YOON,
            strokeCount = 4,
            strokeSteps = listOf("に ditambah ゅ kecil"),
            relatedWords = listOf(KanaWord("ぎゅうにゅう", "gyuunyuu", "susu sapi segar"))
        ),
        KanaCharacter(
            character = "にょ",
            romaji = "nyo",
            category = KanaCategory.YOON,
            strokeCount = 4,
            strokeSteps = listOf("に ditambah ょ kecil"),
            relatedWords = listOf(KanaWord("にょうぼう", "nyoubou", "istri"))
        ),
        KanaCharacter(
            character = "ひゃ",
            romaji = "hya",
            category = KanaCategory.YOON,
            strokeCount = 3,
            strokeSteps = listOf("ひ ditambah ゃ kecil"),
            relatedWords = listOf(KanaWord("ひゃく", "hyaku", "angka seratus"))
        ),
        KanaCharacter(
            character = "ひゅ",
            romaji = "hyu",
            category = KanaCategory.YOON,
            strokeCount = 2,
            strokeSteps = listOf("ひ ditambah ゅ kecil"),
            relatedWords = listOf(KanaWord("ひょう", "hyou", "tabel/daftar"))
        ),
        KanaCharacter(
            character = "ひょ",
            romaji = "hyo",
            category = KanaCategory.YOON,
            strokeCount = 2,
            strokeSteps = listOf("ひ ditambah ょ kecil"),
            relatedWords = listOf(KanaWord("ひょうげん", "hyougen", "ungkapan/ekspresi"))
        ),
        KanaCharacter(
            character = "みゃ",
            romaji = "mya",
            category = KanaCategory.YOON,
            strokeCount = 4,
            strokeSteps = listOf("み ditambah ゃ kecil"),
            relatedWords = listOf(KanaWord("みゃく", "myaku", "denyut nadi"))
        ),
        KanaCharacter(
            character = "みゅ",
            romaji = "myu",
            category = KanaCategory.YOON,
            strokeCount = 3,
            strokeSteps = listOf("み ditambah ゅ kecil"),
            relatedWords = listOf(KanaWord("みゅーじっく", "myuujikku", "musik"))
        ),
        KanaCharacter(
            character = "みょ",
            romaji = "myo",
            category = KanaCategory.YOON,
            strokeCount = 3,
            strokeSteps = listOf("み ditambah ょ kecil"),
            relatedWords = listOf(KanaWord("みょうじ", "myouji", "nama keluarga/marga"))
        ),
        KanaCharacter(
            character = "りゃ",
            romaji = "rya",
            category = KanaCategory.YOON,
            strokeCount = 4,
            strokeSteps = listOf("り ditambah ゃ kecil"),
            relatedWords = listOf(KanaWord("りゃく", "ryaku", "singkatan"))
        ),
        KanaCharacter(
            character = "りゅ",
            romaji = "ryu",
            category = KanaCategory.YOON,
            strokeCount = 3,
            strokeSteps = listOf("り ditambah ゅ kecil"),
            relatedWords = listOf(KanaWord("りゅうがく", "ryuugaku", "studi di luar negeri"))
        ),
        KanaCharacter(
            character = "りょ",
            romaji = "ryo",
            category = KanaCategory.YOON,
            strokeCount = 3,
            strokeSteps = listOf("り ditambah ょ kecil"),
            relatedWords = listOf(KanaWord("りょこう", "ryokou", "wisata/liburan"))
        ),
        KanaCharacter(
            character = "ぎゃ",
            romaji = "gya",
            category = KanaCategory.YOON,
            strokeCount = 8,
            strokeSteps = listOf("ぎ ditambah ゃ kecil"),
            relatedWords = listOf(KanaWord("ぎゃく", "gyaku", "kebalikan/terbalik"))
        ),
        KanaCharacter(
            character = "ぎゅ",
            romaji = "gyu",
            category = KanaCategory.YOON,
            strokeCount = 7,
            strokeSteps = listOf("ぎ ditambah ゅ kecil"),
            relatedWords = listOf(KanaWord("ぎゅうにく", "gyuuniku", "daging sapi"))
        ),
        KanaCharacter(
            character = "ぎょ",
            romaji = "gyo",
            category = KanaCategory.YOON,
            strokeCount = 7,
            strokeSteps = listOf("ぎ ditambah ょ kecil"),
            relatedWords = listOf(KanaWord("ぎょぎょう", "gyogyou", "industri perikanan"))
        ),
        KanaCharacter(
            character = "じゃ",
            romaji = "ja",
            category = KanaCategory.YOON,
            strokeCount = 5,
            strokeSteps = listOf("じ ditambah ゃ kecil"),
            relatedWords = listOf(KanaWord("じゃま", "jama", "gangguan"))
        ),
        KanaCharacter(
            character = "じゅ",
            romaji = "ju",
            category = KanaCategory.YOON,
            strokeCount = 4,
            strokeSteps = listOf("じ ditambah ゅ kecil"),
            relatedWords = listOf(KanaWord("じゅぎょう", "jugyou", "pelajaran sekolah"))
        ),
        KanaCharacter(
            character = "じょ",
            romaji = "jo",
            category = KanaCategory.YOON,
            strokeCount = 4,
            strokeSteps = listOf("じ ditambah ょ kecil"),
            relatedWords = listOf(KanaWord("じょせい", "josei", "wanita/perempuan"))
        ),
        KanaCharacter(
            character = "びゃ",
            romaji = "bya",
            category = KanaCategory.YOON,
            strokeCount = 5,
            strokeSteps = listOf("び ditambah ゃ kecil"),
            relatedWords = listOf(KanaWord("さんびゃく", "sambyaku", "tiga ratus"))
        ),
        KanaCharacter(
            character = "びゅ",
            romaji = "byu",
            category = KanaCategory.YOON,
            strokeCount = 4,
            strokeSteps = listOf("び ditambah ゅ kecil"),
            relatedWords = listOf(KanaWord("びゅー", "byuu", "pemandangan"))
        ),
        KanaCharacter(
            character = "びょ",
            romaji = "byo",
            category = KanaCategory.YOON,
            strokeCount = 4,
            strokeSteps = listOf("び ditambah ょ kecil"),
            relatedWords = listOf(KanaWord("びょういん", "byouin", "rumah sakit"))
        ),
        KanaCharacter(
            character = "ぴゃ",
            romaji = "pya",
            category = KanaCategory.YOON,
            strokeCount = 4,
            strokeSteps = listOf("ぴ ditambah ゃ kecil"),
            relatedWords = listOf(KanaWord("ろっぴゃく", "roppyaku", "enam ratus"))
        ),
        KanaCharacter(
            character = "ぴゅ",
            romaji = "pyu",
            category = KanaCategory.YOON,
            strokeCount = 3,
            strokeSteps = listOf("ぴ ditambah ゅ kecil"),
            relatedWords = listOf(KanaWord("ぴゅーぴゅー", "pyuupyuu", "suara tiupan angin"))
        ),
        KanaCharacter(
            character = "ぴょ",
            romaji = "pyo",
            category = KanaCategory.YOON,
            strokeCount = 3,
            strokeSteps = listOf("ぴ ditambah ょ kecil"),
            relatedWords = listOf(KanaWord("ぴょんぴょん", "pyompyon", "melompat-lompat"))
        ),
    )

    val KATAKANA_YOON = listOf(
        KanaCharacter(
            character = "キャ",
            romaji = "kya",
            category = KanaCategory.YOON,
            strokeCount = 4,
            strokeSteps = listOf("キ ditambah ャ kecil"),
            relatedWords = listOf(KanaWord("キャベツ", "kyabetsu", "kol/kubis"))
        ),
        KanaCharacter(
            character = "キュ",
            romaji = "kyu",
            category = KanaCategory.YOON,
            strokeCount = 4,
            strokeSteps = listOf("キ ditambah ュ kecil"),
            relatedWords = listOf(KanaWord("キュート", "kyuuto", "lucu/imut"))
        ),
        KanaCharacter(
            character = "キョ",
            romaji = "kyo",
            category = KanaCategory.YOON,
            strokeCount = 5,
            strokeSteps = listOf("キ ditambah ョ kecil"),
            relatedWords = listOf(KanaWord("キログラム", "kiroguramu", "kilogram"))
        ),
        KanaCharacter(
            character = "シャ",
            romaji = "sha",
            category = KanaCategory.YOON,
            strokeCount = 4,
            strokeSteps = listOf("シ ditambah ャ kecil"),
            relatedWords = listOf(KanaWord("シャツ", "shatsu", "kemeja"))
        ),
        KanaCharacter(
            character = "シュ",
            romaji = "shu",
            category = KanaCategory.YOON,
            strokeCount = 4,
            strokeSteps = listOf("シ ditambah ュ kecil"),
            relatedWords = listOf(KanaWord("シュークリーム", "shuukuriimu", "kue sus"))
        ),
        KanaCharacter(
            character = "ショ",
            romaji = "sho",
            category = KanaCategory.YOON,
            strokeCount = 5,
            strokeSteps = listOf("シ ditambah ョ kecil"),
            relatedWords = listOf(KanaWord("ショップ", "shoppu", "toko"))
        ),
        KanaCharacter(
            character = "チャ",
            romaji = "cha",
            category = KanaCategory.YOON,
            strokeCount = 4,
            strokeSteps = listOf("チ ditambah ャ kecil"),
            relatedWords = listOf(KanaWord("チャンス", "chansu", "kesempatan"))
        ),
        KanaCharacter(
            character = "チュ",
            romaji = "chu",
            category = KanaCategory.YOON,
            strokeCount = 4,
            strokeSteps = listOf("チ ditambah ュ kecil"),
            relatedWords = listOf(KanaWord("チューブ", "chuubu", "tabung/pipa"))
        ),
        KanaCharacter(
            character = "チョ",
            romaji = "cho",
            category = KanaCategory.YOON,
            strokeCount = 5,
            strokeSteps = listOf("チ ditambah ョ kecil"),
            relatedWords = listOf(KanaWord("チョコレート", "chokoreeto", "cokelat"))
        ),
        KanaCharacter(
            character = "ニャ",
            romaji = "nya",
            category = KanaCategory.YOON,
            strokeCount = 3,
            strokeSteps = listOf("ニ ditambah ャ kecil"),
            relatedWords = listOf(KanaWord("ニャー", "nyaa", "meong"))
        ),
        KanaCharacter(
            character = "ニュ",
            romaji = "nyu",
            category = KanaCategory.YOON,
            strokeCount = 3,
            strokeSteps = listOf("ニ ditambah ュ kecil"),
            relatedWords = listOf(KanaWord("ニュース", "nyuusu", "berita"))
        ),
        KanaCharacter(
            character = "ニョ",
            romaji = "nyo",
            category = KanaCategory.YOON,
            strokeCount = 4,
            strokeSteps = listOf("ニ ditambah ョ kecil"),
            relatedWords = listOf(KanaWord("ニョッキ", "nyokki", "gnocchi"))
        ),
        KanaCharacter(
            character = "ヒャ",
            romaji = "hya",
            category = KanaCategory.YOON,
            strokeCount = 3,
            strokeSteps = listOf("ヒ ditambah ャ kecil"),
            relatedWords = listOf(KanaWord("ヒャ", "hya", "hya"))
        ),
        KanaCharacter(
            character = "ヒュ",
            romaji = "hyu",
            category = KanaCategory.YOON,
            strokeCount = 3,
            strokeSteps = listOf("ヒ ditambah ュ kecil"),
            relatedWords = listOf(KanaWord("ヒューズ", "hyuuzu", "sekring"))
        ),
        KanaCharacter(
            character = "ヒョ",
            romaji = "hyo",
            category = KanaCategory.YOON,
            strokeCount = 4,
            strokeSteps = listOf("ヒ ditambah ョ kecil"),
            relatedWords = listOf(KanaWord("ヒョ", "hyo", "hyo"))
        ),
        KanaCharacter(
            character = "ミャ",
            romaji = "mya",
            category = KanaCategory.YOON,
            strokeCount = 4,
            strokeSteps = listOf("ミ ditambah ャ kecil"),
            relatedWords = listOf(KanaWord("ミャンマー", "myanmaa", "negara Myanmar"))
        ),
        KanaCharacter(
            character = "ミュ",
            romaji = "myu",
            category = KanaCategory.YOON,
            strokeCount = 4,
            strokeSteps = listOf("ミ ditambah ュ kecil"),
            relatedWords = listOf(KanaWord("ミュージアム", "myuujiamu", "museum"))
        ),
        KanaCharacter(
            character = "ミョ",
            romaji = "myo",
            category = KanaCategory.YOON,
            strokeCount = 5,
            strokeSteps = listOf("ミ ditambah ョ kecil"),
            relatedWords = listOf(KanaWord("ミョ", "myo", "myo"))
        ),
        KanaCharacter(
            character = "リャ",
            romaji = "rya",
            category = KanaCategory.YOON,
            strokeCount = 3,
            strokeSteps = listOf("リ ditambah ャ kecil"),
            relatedWords = listOf(KanaWord("リャ", "rya", "rya"))
        ),
        KanaCharacter(
            character = "リュ",
            romaji = "ryu",
            category = KanaCategory.YOON,
            strokeCount = 3,
            strokeSteps = listOf("リ ditambah ュ kecil"),
            relatedWords = listOf(KanaWord("リュック", "ryukku", "tas ransel"))
        ),
        KanaCharacter(
            character = "リョ",
            romaji = "ryo",
            category = KanaCategory.YOON,
            strokeCount = 4,
            strokeSteps = listOf("リ ditambah ョ kecil"),
            relatedWords = listOf(KanaWord("リョ", "ryo", "ryo"))
        ),
        KanaCharacter(
            character = "ギャ",
            romaji = "gya",
            category = KanaCategory.YOON,
            strokeCount = 6,
            strokeSteps = listOf("ギ ditambah ャ kecil"),
            relatedWords = listOf(KanaWord("ギャグ", "gyagu", "lelucon/lawakan"))
        ),
        KanaCharacter(
            character = "ギュ",
            romaji = "gyu",
            category = KanaCategory.YOON,
            strokeCount = 6,
            strokeSteps = listOf("ギ ditambah ュ kecil"),
            relatedWords = listOf(KanaWord("ギュ", "gyu", "gyu"))
        ),
        KanaCharacter(
            character = "ギョ",
            romaji = "gyo",
            category = KanaCategory.YOON,
            strokeCount = 7,
            strokeSteps = listOf("ギ ditambah ョ kecil"),
            relatedWords = listOf(KanaWord("ギョーザ", "gyooza", "pangsit gyoza"))
        ),
        KanaCharacter(
            character = "ジャ",
            romaji = "ja",
            category = KanaCategory.YOON,
            strokeCount = 6,
            strokeSteps = listOf("ジ ditambah ャ kecil"),
            relatedWords = listOf(KanaWord("ジャケット", "jaketto", "jaket"))
        ),
        KanaCharacter(
            character = "ジュ",
            romaji = "ju",
            category = KanaCategory.YOON,
            strokeCount = 6,
            strokeSteps = listOf("ジ ditambah ュ kecil"),
            relatedWords = listOf(KanaWord("ジュース", "juusu", "minuman jus"))
        ),
        KanaCharacter(
            character = "ジョ",
            romaji = "jo",
            category = KanaCategory.YOON,
            strokeCount = 7,
            strokeSteps = listOf("ジ ditambah ョ kecil"),
            relatedWords = listOf(KanaWord("ジョギング", "jogingu", "lari santai/jogging"))
        ),
        KanaCharacter(
            character = "ビャ",
            romaji = "bya",
            category = KanaCategory.YOON,
            strokeCount = 5,
            strokeSteps = listOf("ビ ditambah ャ kecil"),
            relatedWords = listOf(KanaWord("ビャ", "bya", "bya"))
        ),
        KanaCharacter(
            character = "ビュ",
            romaji = "byu",
            category = KanaCategory.YOON,
            strokeCount = 5,
            strokeSteps = listOf("ビ ditambah ュ kecil"),
            relatedWords = listOf(KanaWord("ビュッフェ", "byuffe", "prasmanan"))
        ),
        KanaCharacter(
            character = "ビョ",
            romaji = "byo",
            category = KanaCategory.YOON,
            strokeCount = 6,
            strokeSteps = listOf("ビ ditambah ョ kecil"),
            relatedWords = listOf(KanaWord("ビョ", "byo", "byo"))
        ),
        KanaCharacter(
            character = "ピャ",
            romaji = "pya",
            category = KanaCategory.YOON,
            strokeCount = 4,
            strokeSteps = listOf("ピ ditambah ャ kecil"),
            relatedWords = listOf(KanaWord("ピャ", "pya", "pya"))
        ),
        KanaCharacter(
            character = "ピュ",
            romaji = "pyu",
            category = KanaCategory.YOON,
            strokeCount = 4,
            strokeSteps = listOf("ピ ditambah ュ kecil"),
            relatedWords = listOf(KanaWord("ピューレ", "pyuure", "pure buah"))
        ),
        KanaCharacter(
            character = "ピョ",
            romaji = "pyo",
            category = KanaCategory.YOON,
            strokeCount = 5,
            strokeSteps = listOf("ピ ditambah ョ kecil"),
            relatedWords = listOf(KanaWord("ピョ", "pyo", "pyo"))
        ),
    )
}
