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
    val strokes: List<KanjiStrokeItem> = emptyList(),
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
            strokes = listOf(KanjiStrokeItem(1, "M31.01,33c0.88,0.88,2.75,1.82,5.25,1.75c8.62-0.25,20-2.12,29.5-4.25c1.51-0.34,4.62-0.88,6.62-0.5", null), KanjiStrokeItem(2, "M49.76,17.62c0.88,1,1.82,3.26,1.38,5.25c-3.75,16.75-6.25,38.13-5.13,53.63c0.41,5.7,1.88,10.88,3.38,13.62", null), KanjiStrokeItem(3, "M65.63,44.12c0.75,1.12,1.16,4.39,0.5,6.12c-4.62,12.26-11.24,23.76-25.37,35.76c-6.86,5.83-15.88,3.75-16.25-8.38c-0.34-10.87,13.38-23.12,32.38-26.74c12.42-2.37,27,1.38,30.5,12.75c4.05,13.18-3.76,26.37-20.88,30.49", null)),
            relatedWords = listOf(KanaWord("あさ", "asa", "pagi"), KanaWord("あたま", "atama", "kepala"), KanaWord("あめ", "ame", "hujan"), KanaWord("ありがとう", "arigatou", "terima kasih"))
        ),
        KanaCharacter(
            character = "い",
            romaji = "i",
            category = KanaCategory.GOJUON,
            strokeCount = 2,
            strokeSteps = listOf("Garis kiri melengkung dengan kait di ujung", "Garis kanan lebih pendek melengkung ke dalam"),
            strokes = listOf(KanjiStrokeItem(1, "M21.5,29.66c2.01,2.17,2.61,4.68,2.17,7.43c-3.09,19.16-1.03,32.01,7.93,41.45c6.12,6.45,6.26,3.14,7.04-5.21", null), KanjiStrokeItem(2, "M72.96,36.51c9.44,8.05,17.79,18.82,18.41,33.83", null)),
            relatedWords = listOf(KanaWord("いぬ", "inu", "anjing"), KanaWord("いえ", "ie", "rumah"), KanaWord("いち", "ichi", "satu"), KanaWord("いま", "ima", "sekarang"))
        ),
        KanaCharacter(
            character = "う",
            romaji = "u",
            category = KanaCategory.GOJUON,
            strokeCount = 2,
            strokeSteps = listOf("Garis pendek miring di atas", "Garis melengkung besar seperti huruf C terbalik"),
            strokes = listOf(KanjiStrokeItem(1, "M42,15.5c5.62,2.12,9.62,3,12.88,3c8.27,0,8,1.12-0.38,5.5", null), KanjiStrokeItem(2, "M33,42.38c2.12,1.12,4.12,2.88,8.5,1.38c4.38-1.5,12.75-7.12,18.5-7c5.75,0.12,10.25,5,10.25,18c0,15.49-8.25,30.24-24.37,41.24", null)),
            relatedWords = listOf(KanaWord("うみ", "umi", "laut"), KanaWord("うた", "uta", "lagu"), KanaWord("うし", "ushi", "sapi"), KanaWord("うえ", "ue", "atas"))
        ),
        KanaCharacter(
            character = "え",
            romaji = "e",
            category = KanaCategory.GOJUON,
            strokeCount = 2,
            strokeSteps = listOf("Garis pendek miring di atas", "Garis zig-zag meliuk ke kanan bawah"),
            strokes = listOf(KanjiStrokeItem(1, "M40.52,13.25c5.62,2.12,10,3,14.12,3c8.27,0,8,1.12-0.38,5.5", null), KanjiStrokeItem(2, "M32.52,45.12c1.88,1.25,4.5,1.75,7.38,0.62c3.29-1.29,17-7.88,21.25-9.88c4.25-2,8.32,0.04,4.38,4.62c-12.26,14.27-27.26,31.52-39.51,44.4c-3.26,3.42-0.58,3.54,1.5,1.37c13.5-14.12,18.12-20.12,23.62-20.12c7.13,0,3.5,16.75,6.75,22.38c3.25,5.63,19.12,3.75,26.12,2.12", null)),
            relatedWords = listOf(KanaWord("えき", "eki", "stasiun"), KanaWord("えんぴつ", "empitsu", "pensil"), KanaWord("えいが", "eiga", "film"), KanaWord("え", "e", "gambar"))
        ),
        KanaCharacter(
            character = "お",
            romaji = "o",
            category = KanaCategory.GOJUON,
            strokeCount = 3,
            strokeSteps = listOf("Garis mendatar ke kanan", "Garis vertikal melengkung ke kanan melingkar", "Titik/coretan pendek di kanan atas"),
            strokes = listOf(KanjiStrokeItem(1, "M22.88,35.12c1.38,1,3.62,2.38,6,2.12c2.38-0.26,19.62-5.12,21.12-5.74c1.5-0.62,4-1.25,5.88-2", null), KanjiStrokeItem(2, "M41.5,16.12c2.25,1,3.59,4.39,3.12,7.38c-2.5,16.12-3.37,45.53-2.25,58.38c0.75,8.62-0.64,10.45-7.12,7.12c-5.13-2.62-13.75-8-13.75-12.38c0-7.5,24.38-23.62,44.75-23.62c17.25,0,25,8.25,25,17.25c0,8.25-9.38,18.88-26.75,21", null), KanjiStrokeItem(3, "M73,22.12c5.38,2.62,8.88,5.88,10.62,8.25c2.27,3.08,0.38,4.5-1.12,5", null)),
            relatedWords = listOf(KanaWord("おちゃ", "ocha", "teh"), KanaWord("おんな", "onna", "wanita"), KanaWord("おとこ", "otoko", "pria"), KanaWord("おおきい", "ookii", "besar"))
        ),
        KanaCharacter(
            character = "か",
            romaji = "ka",
            category = KanaCategory.GOJUON,
            strokeCount = 3,
            strokeSteps = listOf("Garis melengkung ke bawah berujung kait", "Garis miring memotong di sebelah kiri", "Titik/coretan di kanan atas"),
            strokes = listOf(KanjiStrokeItem(1, "M24.62,38.62c1.88,1.62,4.65,2.33,8.62,1c25.5-8.5,29.5-4.13,29.5,7.62c0,9.38-1.24,17.46-4.25,25.25c-7.62,19.76-10.87,17.39-16.12,10.89", null), KanjiStrokeItem(2, "M48.5,17.5c1,1.38,1.29,4.7,0.5,7.12c-5,15.25-18.02,40.93-19.62,43.88c-3.12,5.75-6.38,11.88-9.38,16.25", null), KanjiStrokeItem(3, "M77.37,31.62c7.5,6.88,13.25,15.75,15,24.88", null)),
            relatedWords = listOf(KanaWord("かさ", "kasa", "payung"), KanaWord("かわ", "kawa", "sungai"), KanaWord("かぞく", "kazoku", "keluarga"), KanaWord("かみ", "kami", "kertas/tuhan"))
        ),
        KanaCharacter(
            character = "き",
            romaji = "ki",
            category = KanaCategory.GOJUON,
            strokeCount = 4,
            strokeSteps = listOf("Dua garis mendatar sejajar", "Garis miring memotong dari atas ke kanan bawah", "Garis melengkung di bagian bawah"),
            strokes = listOf(KanjiStrokeItem(1, "M30.5,30.25c1.88,0.75,4.64,1.06,5.88,0.88c6.75-1,22.25-4.5,26.5-6c2.17-0.76,3.5-1.25,4.88-2.12", null), KanjiStrokeItem(2, "M36.25,48.7c2.01,0.85,4.97,1.2,6.29,0.99c7.23-1.13,23.82-5.09,28.37-6.79c2.32-0.86,3.75-1.41,5.22-2.4", null), KanjiStrokeItem(3, "M42,14.12c1.5,0.88,3.13,2.94,4,5.12c5.5,13.76,16,29.26,26.37,40.76c7.64,8.47,9.12,9.38-6,3.88", null), KanjiStrokeItem(4, "M33.75,83.25c10.62,9.75,27.25,8.62,38.12,5", null)),
            relatedWords = listOf(KanaWord("き", "ki", "pohon"), KanaWord("きょう", "kyou", "hari ini"), KanaWord("きっぷ", "kippu", "tiket"), KanaWord("きもの", "kimono", "kimono"))
        ),
        KanaCharacter(
            character = "く",
            romaji = "ku",
            category = KanaCategory.GOJUON,
            strokeCount = 1,
            strokeSteps = listOf("Satu tarikan garis menyudut membentuk tanda kurang dari (<)"),
            strokes = listOf(KanjiStrokeItem(1, "M60.66,15c0.5,1.62,0.35,5.44-1,7.38c-6.75,9.62-14.3,19.08-18.62,24.5c-4,5-3.79,7.03-0.88,11c5.5,7.5,12.75,18.75,17.62,27.25c1.48,2.59,2.75,4.75,4.5,8.62", null)),
            relatedWords = listOf(KanaWord("くるま", "kuruma", "mobil"), KanaWord("くち", "kuchi", "mulut"), KanaWord("くだもの", "kudamono", "buah"), KanaWord("くつ", "kutsu", "sepatu"))
        ),
        KanaCharacter(
            character = "け",
            romaji = "ke",
            category = KanaCategory.GOJUON,
            strokeCount = 3,
            strokeSteps = listOf("Garis vertikal kiri berujung kait", "Garis mendatar pendek di kanan", "Garis vertikal melengkung memotong garis mendatar"),
            strokes = listOf(KanjiStrokeItem(1, "M24.67,19.75c1.25,1.5,2.62,3.75,2.12,6.38c-3,15.88-6.5,29.5-4.88,44.62c2.02,18.84,2.25,4.75,6.75-3.5", null), KanjiStrokeItem(2, "M53.67,38.62c2.12,1.38,4.28,1.89,6.88,1.5c8.25-1.25,15.39-2.57,20.62-4c2.76-0.74,5.26-1.12,6.88-1.12", null), KanjiStrokeItem(3, "M71.67,14.38c2.13,1.37,2.88,3.35,2.88,5.12c0,11.62,0.12,20.38,0.12,30.12c0,20.75-0.62,30.88-12.5,42.25", null)),
            relatedWords = listOf(KanaWord("けさ", "kesa", "pagi ini"), KanaWord("けいさつ", "keisatsu", "polisi"), KanaWord("けっこん", "kekkon", "menikah"), KanaWord("けむり", "kemuri", "asap"))
        ),
        KanaCharacter(
            character = "こ",
            romaji = "ko",
            category = KanaCategory.GOJUON,
            strokeCount = 2,
            strokeSteps = listOf("Garis mendatar atas sedikit melengkung", "Garis mendatar bawah melengkung sejajar"),
            strokes = listOf(KanjiStrokeItem(1, "M34.75,26.75c1.12,0.88,2.91,2.01,6,1.5c7.62-1.25,14.11-2.56,22.38-2.62c15.5-0.12,5.88,5-5.75,9", null), KanjiStrokeItem(2, "M30,68.12c2.25,14.5,15.26,17.96,31,16.75c6.5-0.5,11.88-1.25,17.62-2.88", null)),
            relatedWords = listOf(KanaWord("こども", "kodomo", "anak-anak"), KanaWord("これ", "kore", "ini"), KanaWord("こえ", "koe", "suara"), KanaWord("ここ", "koko", "di sini"))
        ),
        KanaCharacter(
            character = "さ",
            romaji = "sa",
            category = KanaCategory.GOJUON,
            strokeCount = 3,
            strokeSteps = listOf("Garis mendatar sedikit miring ke atas", "Garis memotong diagonal ke kanan bawah", "Garis melengkung memutar di bawah"),
            strokes = listOf(KanjiStrokeItem(1, "M27,38.9c2.42,1.33,5.38,1.47,8.32,1.06c8.79-1.24,28.67-7.76,34.15-10.43c2.79-1.36,3.78-1.91,6.28-3.53", null), KanjiStrokeItem(2, "M41.5,13.88c1.5,0.88,3.63,2.94,4.5,5.12c5.5,13.75,15.25,27.62,26.87,39.5c7.98,8.15,6.38,10-6,3.12", null), KanjiStrokeItem(3, "M35.25,80.5c4.5,11.75,20.88,12.5,38.38,7.5", null)),
            relatedWords = listOf(KanaWord("さかな", "sakana", "ikan"), KanaWord("さくら", "sakura", "bunga sakura"), KanaWord("さとう", "satou", "gula"), KanaWord("さいふ", "saifu", "dompet"))
        ),
        KanaCharacter(
            character = "し",
            romaji = "shi",
            category = KanaCategory.GOJUON,
            strokeCount = 1,
            strokeSteps = listOf("Garis vertikal turun lalu melengkung ke kanan atas seperti kail pancing"),
            strokes = listOf(KanjiStrokeItem(1, "M39.12,17.5c1.25,3.12,0.93,6.74,0.38,10.25c-2.12,13.5-3,26.5-3,39.12c0,27.38,19.88,30.12,45.5,17.25", null)),
            relatedWords = listOf(KanaWord("しろ", "shiro", "putih"), KanaWord("しんぶん", "shimbun", "koran"), KanaWord("しお", "shio", "garam"), KanaWord("しごと", "shigoto", "pekerjaan"))
        ),
        KanaCharacter(
            character = "す",
            romaji = "su",
            category = KanaCategory.GOJUON,
            strokeCount = 2,
            strokeSteps = listOf("Garis mendatar dari kiri ke kanan", "Garis vertikal membentuk simpul lingkaran di tengah lalu turun ke bawah"),
            strokes = listOf(KanjiStrokeItem(1, "M15.5,37.12c2.88,2.12,6.94,1.51,12.75,0.25c16.12-3.5,36.14-5.38,46.62-6.5c7-0.75,11.88-0.62,17.75,0.12", null), KanjiStrokeItem(2, "M57.62,13.38c2,1.5,2.75,3.25,2.75,5.88c0,10.38,0,35.12,0,40.75c0,14.62-15.62,16.38-15.62,1.75c0-14.25,18-14.12,18,6.38c0,13.25-7.75,21.5-16,28.38", null)),
            relatedWords = listOf(KanaWord("すし", "sushi", "sushi"), KanaWord("すき", "suki", "suka"), KanaWord("すずしい", "suzushii", "sejuk"), KanaWord("すこし", "sukoshi", "sedikit"))
        ),
        KanaCharacter(
            character = "せ",
            romaji = "se",
            category = KanaCategory.GOJUON,
            strokeCount = 3,
            strokeSteps = listOf("Garis mendatar panjang", "Garis vertikal kanan berujung kait", "Garis vertikal kiri melengkung ke kanan"),
            strokes = listOf(KanjiStrokeItem(1, "M16.5,49.93c2.88,2.42,6.86,1.57,12.75,0.53c19-3.34,33-5.72,47.12-7.64c6.99-0.95,11.88-1.21,17.75-0.36", null), KanjiStrokeItem(2, "M69.74,17.75c2,1.5,2.75,3.25,2.75,5.88c0,10.38,0,17.88,0,23.5c0,25.62-5.75,23.25-11.88,19", null), KanjiStrokeItem(3, "M35.62,26.25c2,1.5,2.75,3.25,2.75,5.88c0,10.38,0,28.38,0,34c0,14.5,6.38,19.55,20.14,19.55c10.24,0,13.74,0.07,22.61-1.68", null)),
            relatedWords = listOf(KanaWord("せんせい", "sensei", "guru"), KanaWord("せかい", "sekai", "dunia"), KanaWord("せなか", "senaka", "punggung"), KanaWord("せまい", "semai", "sempit"))
        ),
        KanaCharacter(
            character = "そ",
            romaji = "so",
            category = KanaCategory.GOJUON,
            strokeCount = 1,
            strokeSteps = listOf("Satu garis berkelanjutan zig-zag: mendatar, diagonal, mendatar, melengkung di bawah"),
            strokes = listOf(KanjiStrokeItem(1, "M38.4,22c1.88,1.25,4.98,1.05,7.5,0.38c6.5-1.75,13.25-3.75,19.38-5.38c4.63-1.23,7.18,2.06,3.62,5.25c-12.12,10.87-31.14,24.4-40,30.25c-6.25,4.12-5.88,5.75,1.38,3.88c17.08-4.42,35.96-8.68,50.12-10.38c9.38-1.12,9.62,0.12,0.5,1.38c-15.82,2.17-34.38,14.25-34.38,26.5c0,12.88,11.62,20.38,31.5,16.62", null)),
            relatedWords = listOf(KanaWord("そら", "sora", "langit"), KanaWord("そこ", "soko", "di situ"), KanaWord("そと", "soto", "luar"), KanaWord("そして", "soshite", "lalu/kemudian"))
        ),
        KanaCharacter(
            character = "た",
            romaji = "ta",
            category = KanaCategory.GOJUON,
            strokeCount = 4,
            strokeSteps = listOf("Garis mendatar", "Garis miring memotong garis pertama", "Dua garis pendek seperti huruf 'ko' kecil di kanan"),
            strokes = listOf(KanjiStrokeItem(1, "M24.38,35.38c1.38,0.62,3.88,1.51,6.38,1.12c6.5-1,16.25-2.88,24.88-4.75c2.64-0.57,5.38-1.5,7.62-2.38", null), KanjiStrokeItem(2, "M45,16.88c0.75,1.25,0.87,3.62,0.38,5.25c-6.35,20.94-12.75,36.37-18.88,52.37c-1.36,3.56-4.75,11.75-6,14.62", null), KanjiStrokeItem(3, "M56.38,53.25c12.38-2.75,18.25-3.7,23.62-3.12c15.12,1.62-1.12,2.25-4.25,4.88", null), KanjiStrokeItem(4, "M54.13,82.25c4.38,7,14.25,8.12,34.5,5.62", null)),
            relatedWords = listOf(KanaWord("たまご", "tamago", "telur"), KanaWord("たべる", "taberu", "makan"), KanaWord("たかい", "takai", "tinggi/mahal"), KanaWord("たいよう", "taiyou", "matahari"))
        ),
        KanaCharacter(
            character = "ち",
            romaji = "chi",
            category = KanaCategory.GOJUON,
            strokeCount = 2,
            strokeSteps = listOf("Garis mendatar sedikit miring ke atas", "Garis vertikal melengkung melingkar seperti angka 5"),
            strokes = listOf(KanjiStrokeItem(1, "M24.5,32.62c1.38,0.62,3.88,1.51,6.38,1.12c6.5-1,18.25-4.12,26.88-6c2.64-0.57,5.38-1.5,7.62-2.38", null), KanjiStrokeItem(2, "M45.62,15.62c0.75,1.25,0.71,3.58,0.38,5.25c-3,15-4.25,22.59-8.38,38.62c-3.25,12.62-5.38,11.12,3.62,4.38c8.29-6.21,19.75-9.5,28.5-9.5c8.62,0,14.58,5.88,14.5,14.5c-0.12,13.5-16.5,20.62-29.88,23.25", null)),
            relatedWords = listOf(KanaWord("ちず", "chizu", "peta"), KanaWord("ちち", "chichi", "ayah"), KanaWord("ちいさい", "chiisai", "kecil"), KanaWord("ちかてつ", "chikatetsu", "kereta bawah tanah"))
        ),
        KanaCharacter(
            character = "つ",
            romaji = "tsu",
            category = KanaCategory.GOJUON,
            strokeCount = 1,
            strokeSteps = listOf("Satu tarikan garis melengkung seperti gelombang ombak besar"),
            strokes = listOf(KanjiStrokeItem(1, "M14,44.75c1.88,1.62,4.68,2.09,8.12,0.62c17.88-7.62,30-11.12,44.88-10.88c12.56,0.21,22.98,7.17,22.87,19.17c-0.18,18.77-24.75,28.71-45.01,32.08", null)),
            relatedWords = listOf(KanaWord("つき", "tsuki", "bulan"), KanaWord("つくえ", "tsukue", "meja"), KanaWord("つよい", "tsuyoi", "kuat"), KanaWord("つぎ", "tsugi", "berikutnya"))
        ),
        KanaCharacter(
            character = "て",
            romaji = "te",
            category = KanaCategory.GOJUON,
            strokeCount = 1,
            strokeSteps = listOf("Garis mendatar lalu melengkung setengah lingkaran ke kanan bawah"),
            strokes = listOf(KanjiStrokeItem(1, "M20.5,26.38c1.87,1.62,4.42,1.97,8.12,1.37c21.75-3.5,33-5.12,50.12-8.38c12.34-2.34,13-0.88,0.38,1.38c-17.89,3.19-33.78,19.12-33.78,37.62c0,20.5,17.91,30.25,35.16,30.25", null)),
            relatedWords = listOf(KanaWord("て", "te", "tangan"), KanaWord("てがみ", "tegami", "surat"), KanaWord("てんき", "tenki", "cuaca"), KanaWord("テレビ", "terebi", "televisi"))
        ),
        KanaCharacter(
            character = "と",
            romaji = "to",
            category = KanaCategory.GOJUON,
            strokeCount = 2,
            strokeSteps = listOf("Garis miring pendek ke kanan bawah", "Garis melengkung besar memotong garis pertama"),
            strokes = listOf(KanjiStrokeItem(1, "M35.5,18.38c1.74,0.74,3.62,2.62,4.12,5.37c0.5,2.75,4.75,25,5.38,28.12", null), KanjiStrokeItem(2, "M78.12,25.5c0.25,1.88,0.04,4.09-2.25,5.75c-6.37,4.63-13.22,8.49-22.75,15.25c-12.88,9.12-21.62,18.38-21.62,27.5c0,10.12,8.5,13.88,26.88,13.88c6.25,0,14.75-0.12,21.62-1.25", null)),
            relatedWords = listOf(KanaWord("とり", "tori", "burung"), KanaWord("ともだち", "tomodachi", "teman"), KanaWord("とけい", "tokei", "jam dinding"), KanaWord("としょかん", "toshokan", "perpustakaan"))
        ),
        KanaCharacter(
            character = "な",
            romaji = "na",
            category = KanaCategory.GOJUON,
            strokeCount = 4,
            strokeSteps = listOf("Garis mendatar", "Garis miring ke bawah", "Titik pendek di kanan atas", "Garis melingkar simpul di kanan bawah"),
            strokes = listOf(KanjiStrokeItem(1, "M22.88,28.96c1.18,0.58,3.3,1.1,5.47,1.05c5.53-0.13,10.9-0.98,16.52-2.42c4.82-1.23,9.13-3.12,11.38-4.22", null), KanjiStrokeItem(2, "M42.99,14c0.63,0.89,0.56,2.52,0.31,3.72c-2.96,14.16-7.95,26.56-14.25,37.87c-2.05,3.69-4.25,7.24-6.55,10.65", null), KanjiStrokeItem(3, "M72.26,23.25c6.88,2.5,12.62,5.62,14.75,9.5c4.06,7.41-0.25,3.38-3.5,3.88", null), KanjiStrokeItem(4, "M68.88,44.62c-1,1.88-2.14,5.24-1.88,8.25c0.62,7,1.5,13.12,1.5,20.62c0,20-27.88,19.75-27.88,9.38c0-5.62,8.25-8.25,13.88-8.25c8.75,0,21.5,3.25,29.75,11.5", null)),
            relatedWords = listOf(KanaWord("なつ", "natsu", "musim panas"), KanaWord("なまえ", "namae", "nama"), KanaWord("なん/なに", "nani", "apa"), KanaWord("ながい", "nagai", "panjang"))
        ),
        KanaCharacter(
            character = "に",
            romaji = "ni",
            category = KanaCategory.GOJUON,
            strokeCount = 3,
            strokeSteps = listOf("Garis vertikal kiri dengan kait", "Dua garis mendatar sejajar di sebelah kanan (seperti 'ko')"),
            strokes = listOf(KanjiStrokeItem(1, "M24.53,22.75c1.25,1.5,1.62,3.75,1.12,6.38c-3,15.88-9,32.5-7.38,47.62c2.02,18.84,4.5,5.75,8.5-3.5", null), KanjiStrokeItem(2, "M53.2,30.64c0.96,0.79,2.44,1.58,5.1,1.35c6.98-0.61,15.01-3.3,22.04-3.36c13.19-0.11,1.5,3.75-8.39,7.35", null), KanjiStrokeItem(3, "M52.53,68c1.76,12.92,11.92,16.01,24.23,14.93c5.08-0.45,8.9-0.8,14.27-2.06", null)),
            relatedWords = listOf(KanaWord("にほん", "nihon", "Jepang"), KanaWord("にく", "niku", "daging"), KanaWord("にわ", "niwa", "halaman/kebun"), KanaWord("にちようび", "nichiyoubi", "hari Minggu"))
        ),
        KanaCharacter(
            character = "ぬ",
            romaji = "nu",
            category = KanaCategory.GOJUON,
            strokeCount = 2,
            strokeSteps = listOf("Garis miring dari kiri atas ke kanan bawah", "Garis meliuk memutar membentuk simpul kecil di ujung kanan"),
            strokes = listOf(KanjiStrokeItem(1, "M25.38,28.5c2,1.38,2.97,3.23,3.38,5.88c1.87,12.18,4.12,23.92,8.54,34.67c1.79,4.36,3.96,8.33,6.84,12.46", null), KanjiStrokeItem(2, "M57.12,19.25c0.88,2.12,1.06,3.79,0.62,5.88c-3.12,15-13.14,39.81-18.12,48.62c-11.87,21-20.62,1.25-20.62-4.5c0-22.63,43.75-44.25,62.36-29.59c7.66,6.03,9.8,14.58,9.14,23.34c-2,26.75-32.88,28.38-32.88,16.88c0-9.38,17.38-7.12,27.12-1.12c3.1,1.91,7.25,5.25,9.5,7.5", null)),
            relatedWords = listOf(KanaWord("いぬ", "inu", "anjing"), KanaWord("ぬの", "nuno", "kain"), KanaWord("ぬるい", "nurui", "hangat suam-suam"), KanaWord("ぬすむ", "nusumu", "mencuri"))
        ),
        KanaCharacter(
            character = "ね",
            romaji = "ne",
            category = KanaCategory.GOJUON,
            strokeCount = 2,
            strokeSteps = listOf("Garis vertikal tegak lurus", "Garis zig-zag meliuk dengan simpul kecil di ujung kanan"),
            strokes = listOf(KanjiStrokeItem(1, "M33.29,14.5c1.62,1.62,2.1,3.21,1.88,5.88c-1.03,11.93-2.06,31.66-2.53,53.12c-0.1,4.62-0.18,9.31-0.22,14", null), KanjiStrokeItem(2, "M17.16,37.88c1.62,0.88,3.25,1.38,5.62,0.75c2.14-0.56,7.8-2.31,12.37-4.03c6.26-2.35,6.88-1.47,3.12,3.63c-5.56,7.53-13.02,17.38-18.48,26.77c-5.6,9.62-3.45,8.3,2,3c19.12-18.62,38.5-39.12,54.12-39.12c11.38,0,12.88,11.25,12.88,32.5c0,28.62-30.18,24.88-30.18,16.26c0-9.63,18.73-7.82,28.06-1.88c2.75,1.75,5.88,4.88,7.5,6.75", null)),
            relatedWords = listOf(KanaWord("ねこ", "neko", "kucing"), KanaWord("ねつ", "netsu", "demam"), KanaWord("ねる", "neru", "tidur"), KanaWord("ねだん", "nedan", "harga"))
        ),
        KanaCharacter(
            character = "の",
            romaji = "no",
            category = KanaCategory.GOJUON,
            strokeCount = 1,
            strokeSteps = listOf("Satu tarikan garis melengkung melingkar seperti lingkaran spiral"),
            strokes = listOf(KanjiStrokeItem(1, "M53.82,28.62c1,1.5,1.34,4.12,0.88,6.62c-1.75,9.5-6.89,25-10.75,33.12c-9.63,20.26-16.55,14.74-24.38-1.98c-9.13-19.5,23.5-48.88,50.63-40.38c32.38,10.15,28,54.62-4.75,60.88", null)),
            relatedWords = listOf(KanaWord("のみもの", "nomimono", "minuman"), KanaWord("のる", "noru", "naik (kendaraan)"), KanaWord("のど", "nodo", "tenggorokan"), KanaWord("のうか", "nouka", "petani"))
        ),
        KanaCharacter(
            character = "は",
            romaji = "ha",
            category = KanaCategory.GOJUON,
            strokeCount = 3,
            strokeSteps = listOf("Garis vertikal kiri berujung kait", "Garis mendatar kanan", "Garis vertikal memotong garis mendatar dengan simpul lingkaran di bawah"),
            strokes = listOf(KanjiStrokeItem(1, "M24.51,18c1.25,1.5,2.15,4,1.62,6.62c-3.5,17.62-6.98,36.4-4,54.88c2.5,15.5,1.12,2,5.62-6.25", null), KanjiStrokeItem(2, "M49.64,37.89c2.41,1.57,4.85,2.16,7.8,1.71c9.36-1.43,17.46-2.94,23.4-4.57c3.12-0.86,5.96-1.29,7.8-1.29", null), KanjiStrokeItem(3, "M69.77,16.5c2.25,2.12,2.88,4.12,2.88,6.5c0,2.38,1.5,38.62,1.5,48c0,22.5-30.62,19.62-30.62,10.5c0-9.75,23.88-5.62,29.5-2.88c5.62,2.74,11.98,8.26,13.36,9.38", null)),
            relatedWords = listOf(KanaWord("はな", "hana", "bunga/hidung"), KanaWord("はし", "hashi", "sumpit/jembatan"), KanaWord("はる", "haru", "musim semi"), KanaWord("はやい", "hayai", "cepat"))
        ),
        KanaCharacter(
            character = "ひ",
            romaji = "hi",
            category = KanaCategory.GOJUON,
            strokeCount = 1,
            strokeSteps = listOf("Satu tarikan garis melengkung membentuk lengkungan tapal kuda asimetris"),
            strokes = listOf(KanjiStrokeItem(1, "M20,25.12c1.25,0.88,3.75,2.25,6.5,1.38c2.75-0.87,7.31-2.38,11.38-4.5c6-3.12,8.42-1.01,4.25,4c-27.13,32.62-23.76,58.5-1.52,62.88c18.07,3.56,37.63-16.38,35.63-56.51c-0.72-14.5-0.17-14.78,4.12-1.75c3.76,11.38,10.26,20.76,16.14,26.5", null)),
            relatedWords = listOf(KanaWord("ひと", "hito", "orang"), KanaWord("ひこうき", "hikouki", "pesawat"), KanaWord("ひだり", "hidari", "kiri"), KanaWord("ひる", "hiru", "siang"))
        ),
        KanaCharacter(
            character = "ふ",
            romaji = "fu",
            category = KanaCategory.GOJUON,
            strokeCount = 4,
            strokeSteps = listOf("Titik atas pendek", "Garis lengkung tengah berbentuk hidung", "Titik miring di kiri", "Titik miring di kanan"),
            strokes = listOf(KanjiStrokeItem(1, "M42.63,15.62c3.62,3.38,7.5,5.38,12.74,6.13c9.59,1.37,3.5,3.38-1.88,6.12", null), KanjiStrokeItem(2, "M43.63,46.88c1.88,4.62,7.5,9.41,14.25,17.5c10.62,12.74,0.49,30-19.13,21.62", null), KanjiStrokeItem(3, "M16.5,73.38c0.75,4,1.88,8.12,5,10.12c1.16,0.74,0.12-3.38,13.25-9.12", null), KanjiStrokeItem(4, "M80.13,61.88c5.12,3.38,10.28,7.49,11.38,8.88c6.75,8.5-0.25,4.62-4.62,7.12", null)),
            relatedWords = listOf(KanaWord("ふね", "fune", "kapal"), KanaWord("ふゆ", "fuyu", "musim dingin"), KanaWord("ふじさん", "fujisan", "Gunung Fuji"), KanaWord("ふく", "fuku", "pakaian"))
        ),
        KanaCharacter(
            character = "へ",
            romaji = "he",
            category = KanaCategory.GOJUON,
            strokeCount = 1,
            strokeSteps = listOf("Satu tarikan garis membentuk puncak bukit/atap miring ke kanan"),
            strokes = listOf(KanjiStrokeItem(1, "M15,48.75c2.25,1.62,4.67,1.96,7-0.38c3.62-3.62,7.46-6.54,11.25-10.5c5.5-5.75,8.48-4.75,13.12-0.88c12.12,10.12,30.38,25.12,33.38,27.38c3,2.26,12.37,10.38,13.87,11.63", null)),
            relatedWords = listOf(KanaWord("へや", "heya", "kamar"), KanaWord("へた", "heta", "tidak pandai"), KanaWord("へいわ", "heiwa", "perdamaian"), KanaWord("へび", "hebi", "ular"))
        ),
        KanaCharacter(
            character = "ほ",
            romaji = "ho",
            category = KanaCategory.GOJUON,
            strokeCount = 4,
            strokeSteps = listOf("Garis vertikal kiri dengan kait", "Dua garis mendatar kanan", "Garis vertikal memotong garis mendatar bawah membentuk simpul"),
            strokes = listOf(KanjiStrokeItem(1, "M24.51,18.75c1.25,1.5,2.15,4,1.62,6.62c-3.5,17.63-6.98,37.4-4,55.88c2.5,15.5,1.12,2,5.62-6.25", null), KanjiStrokeItem(2, "M53.08,21.13c1.9,1.28,3.82,1.76,6.14,1.4c7.36-1.17,13.73-2.4,18.41-3.73c2.46-0.7,4.69-1.05,6.13-1.05", null), KanjiStrokeItem(3, "M53.83,44.3c2.21,1.44,4.46,1.98,7.16,1.57c8.59-1.31,15.78-2.44,21.23-3.94c2.87-0.79,5.72-1.18,7.41-1.18", null), KanjiStrokeItem(4, "M72.51,23c1.38,1.62,1.62,4.12,1.62,6.5c0,2.38,2,35.12,2,44.5c0,17.5-29.88,17.12-29.88,8c0-9.75,21.38-7.88,29.5-2.88c5.33,3.28,12,8.25,13.38,9.38", null)),
            relatedWords = listOf(KanaWord("ほし", "hoshi", "bintang"), KanaWord("ほん", "hon", "buku"), KanaWord("ほね", "hone", "tulang"), KanaWord("ほんとう", "hontou", "benar/nyata"))
        ),
        KanaCharacter(
            character = "ま",
            romaji = "ma",
            category = KanaCategory.GOJUON,
            strokeCount = 3,
            strokeSteps = listOf("Dua garis mendatar sejajar", "Garis vertikal memotong kedua garis dengan simpul melingkar di bawah"),
            strokes = listOf(KanjiStrokeItem(1, "M29.83,32.28c2.2,1.15,4.43,1.5,7.14,1.26c11.54-1.04,25.94-3.12,34.66-4.85c2.87-0.57,5.45-0.44,7.13-0.44", null), KanjiStrokeItem(2, "M33.83,51.84c2.45,1.61,4.94,1.72,7.94,1.26c9.52-1.46,17.87-3.1,27.03-5.16c3.22-0.72,6.34-1.32,8.21-1.32", null), KanjiStrokeItem(3, "M55.81,14c1.52,1.8,1.8,4.57,1.8,7.19c0,2.63,0.46,43.88,0.46,54.25c0,21.3-30.07,19.96-30.07,9.86c0-10.79,25.88-9.93,38.57-3.18c6.12,3.25,11.55,6.38,14.8,9.13", null)),
            relatedWords = listOf(KanaWord("まち", "machi", "kota"), KanaWord("まいにち", "mainichi", "setiap hari"), KanaWord("まえ", "mae", "depan"), KanaWord("まつ", "matsu", "menunggu"))
        ),
        KanaCharacter(
            character = "み",
            romaji = "mi",
            category = KanaCategory.GOJUON,
            strokeCount = 2,
            strokeSteps = listOf("Garis mendatar lalu meliuk ke kiri bawah berujung simpul memanjang", "Garis miring memotong di sebelah kanan"),
            strokes = listOf(KanjiStrokeItem(1, "M32.5,26c1.88,1.75,4.06,1.7,6.88,1.25c3.88-0.62,7.62-1.75,11.88-3.12c4.26-1.37,6.25-0.12,4.5,5.12c-1.75,5.24-6.66,17.39-12,30.12c-13.63,32.51-29.26,29.26-29.26,18.63c0-14.25,20.48-15.36,33-13.5c18.5,2.75,30,6.62,44.38,14.25", null), KanjiStrokeItem(2, "M79.38,54.75c0.75,2.38,0.49,4.37,0,6.25c-2.12,8.12-7.5,25-22.12,33.75", null)),
            relatedWords = listOf(KanaWord("みず", "mizu", "air"), KanaWord("みち", "michi", "jalan"), KanaWord("みみ", "mimi", "telinga"), KanaWord("みる", "miru", "melihat"))
        ),
        KanaCharacter(
            character = "む",
            romaji = "mu",
            category = KanaCategory.GOJUON,
            strokeCount = 3,
            strokeSteps = listOf("Garis mendatar", "Garis vertikal melengkung dengan simpul di tengah dan melengkung ke kanan atas", "Titik di kanan atas"),
            strokes = listOf(KanjiStrokeItem(1, "M19.59,31.65c2.1,1.55,4.24,1.66,6.81,1.21c8.17-1.41,15.33-2.98,23.19-4.96c2.76-0.69,5.44-1.27,7.05-1.27", null), KanjiStrokeItem(2, "M37.02,15.5c1.62,1.25,2.31,2.88,2.12,5.25c-0.88,11.12-1.5,20.75-4,34.88c-3.61,20.44-19.25,16.99-18.62,7.37c0.5-7.74,6.25-12.86,12.62-13.5c5-0.5,14.28,1.93,5.88,15c-12.62,19.62-11.42,24.51,5.11,25.54c10.98,0.68,19.26,0.72,28.49-0.92c14.15-2.5,7.4-2.63,7.4-11.13", null), KanjiStrokeItem(3, "M78.52,36.25c6.88,3.12,11.71,5.95,14.88,10.12c6.25,8.25-1.38,3.62-4.5,4.5", null)),
            relatedWords = listOf(KanaWord("むし", "mushi", "serangga"), KanaWord("むすこ", "musuko", "anak laki-laki"), KanaWord("むずかしい", "muzukashii", "sulit"), KanaWord("むら", "mura", "desa"))
        ),
        KanaCharacter(
            character = "め",
            romaji = "me",
            category = KanaCategory.GOJUON,
            strokeCount = 2,
            strokeSteps = listOf("Garis miring dari kiri atas ke kanan bawah", "Garis melengkung besar memotong dan melingkari garis pertama tanpa simpul"),
            strokes = listOf(KanjiStrokeItem(1, "M27.48,31.75c1.75,1,2.41,3.09,2.5,5.25c0.5,11.62,2.75,23.5,7.25,31.38c1.39,2.44,5.38,8.5,7.25,10.38", null), KanjiStrokeItem(2, "M59.6,19.38c1,1.5,1.35,4.12,0.88,6.62c-2.75,14.62-13.62,37.75-20.1,47.24c-12.28,17.14-16.78,13.14-22.28,0.64c-5.38-15.38,26.4-42.18,53.42-35.28c29.08,8.27,23.96,46.02-7.98,50.15", null)),
            relatedWords = listOf(KanaWord("め", "me", "mata"), KanaWord("めがね", "megane", "kacamata"), KanaWord("めいし", "meishi", "kartu nama"), KanaWord("めでたい", "medetai", "menggembirakan"))
        ),
        KanaCharacter(
            character = "も",
            romaji = "mo",
            category = KanaCategory.GOJUON,
            strokeCount = 3,
            strokeSteps = listOf("Garis vertikal melengkung ke kanan seperti pancing", "Dua garis mendatar sejajar memotong garis vertikal"),
            strokes = listOf(KanjiStrokeItem(1, "M49.17,14.75c1.88,1.88,1.86,4.52,1.12,8c-3,14.25-5,26.62-7,42.12c-2.55,19.73-0.75,29.88,17,29.86c20.25-0.02,28.63-13.11,20.01-35.73", null), KanjiStrokeItem(2, "M26.54,34.62c1.12,0.88,2.87,2.21,6,2c11.12-0.75,20-2.12,27.74-3.46c3.88-0.67,5.88-1.17,8.88-1.04", null), KanjiStrokeItem(3, "M26.42,53.38c-1.5,4,1,6.75,7.75,6.75c8.75,0,17.62-1,22.88-1.88c2.01-0.33,5.38-1,7.5-1.75", null)),
            relatedWords = listOf(KanaWord("もり", "mori", "hutan"), KanaWord("もの", "mono", "benda/barang"), KanaWord("もんだい", "mondai", "masalah/soal"), KanaWord("もつ", "motsu", "membawa"))
        ),
        KanaCharacter(
            character = "や",
            romaji = "ya",
            category = KanaCategory.GOJUON,
            strokeCount = 3,
            strokeSteps = listOf("Garis melengkung ke bawah berujung kait", "Coretan pendek di atas", "Garis miring memotong dari atas ke kiri bawah"),
            strokes = listOf(KanjiStrokeItem(1, "M18,49.38c1.88,1.62,5.25,2.5,8.62,0.88c18.51-8.88,35.76-19.38,50.83-19.26c9.02,0.14,16.01,4.13,15.93,12.29c0,8.33-10.88,16.58-24.5,17.83", null), KanjiStrokeItem(2, "M47.13,15.88c5.12,0.88,10.41,4.05,11.5,6.62c2.12,5-1,2.38-2.88,2.62", null), KanjiStrokeItem(3, "M30,24.38c2.38,1.88,3.28,2.87,3.88,5.25c2.62,10.5,11.12,41.12,14.75,52.5c0.65,2.04,1.88,6.25,2.88,9.38", null)),
            relatedWords = listOf(KanaWord("やま", "yama", "gunung"), KanaWord("やすみ", "yasumi", "libur/istirahat"), KanaWord("やさい", "yasai", "sayuran"), KanaWord("やくそく", "yakusoku", "janji"))
        ),
        KanaCharacter("", "", KanaCategory.GOJUON),
        KanaCharacter(
            character = "ゆ",
            romaji = "yu",
            category = KanaCategory.GOJUON,
            strokeCount = 2,
            strokeSteps = listOf("Garis vertikal melengkung dengan simpul besar ke kanan", "Garis vertikal panjang memotong dari atas ke bawah"),
            strokes = listOf(KanjiStrokeItem(1, "M21.05,25.38c1.38,1.5,2.02,4.13,1.5,6.25c-2.88,11.75-4,22.25-2.12,35c2.77,18.85,1.12,3.88,3.25-1.5c9-22.75,27.24-34.5,44.38-34.5c16.88,0,21.88,11.38,21.88,20.25c0,27.38-30.88,29.62-43,16.75", null), KanjiStrokeItem(2, "M58.42,16.75c2.62,1.75,3.17,3.13,3.5,7.12c0.88,10.5,1.4,18.72,1.62,29.38c0.5,24-6.25,32-12.38,39.25", null)),
            relatedWords = listOf(KanaWord("ゆき", "yuki", "salju"), KanaWord("ゆめ", "yume", "mimpi"), KanaWord("ゆうびんきょく", "yuubinkyoku", "kantor pos"), KanaWord("ゆうべ", "yuube", "kemarin malam"))
        ),
        KanaCharacter("", "", KanaCategory.GOJUON),
        KanaCharacter(
            character = "よ",
            romaji = "yo",
            category = KanaCategory.GOJUON,
            strokeCount = 2,
            strokeSteps = listOf("Garis mendatar pendek", "Garis vertikal memotong garis mendatar dengan simpul melingkar di bawah"),
            strokes = listOf(KanjiStrokeItem(1, "M58.24,35.38c7.5-1.28,13.74-2.63,18.5-4.1c2.5-0.77,4.77-1.15,6.25-1.15", null), KanjiStrokeItem(2, "M54.62,13.88c2.25,2.12,2.98,4.13,2.88,6.5c-0.75,17-0.12,34.88,1.39,53.5c1.88,23.07-34.89,20.88-34.89,11.5c0-12,26.25-8,35.98-4.12c8.1,3.23,11.52,4.88,18.52,10.38", null)),
            relatedWords = listOf(KanaWord("よる", "yoru", "malam"), KanaWord("よく", "yoku", "sering/dengan baik"), KanaWord("よむ", "yomu", "membaca"), KanaWord("よっつ", "yottsu", "empat buah"))
        ),
        KanaCharacter(
            character = "ら",
            romaji = "ra",
            category = KanaCategory.GOJUON,
            strokeCount = 2,
            strokeSteps = listOf("Coretan pendek di atas", "Garis melengkung besar ke bawah seperti angka 5"),
            strokes = listOf(KanjiStrokeItem(1, "M35.33,15c3.75,3,9.22,4.41,16.5,4.25c11.12-0.25-0.25,2.38-1.25,3.5", null), KanjiStrokeItem(2, "M35.83,35.75c-2.14,4.34-2.79,8.67-3.11,13.24c-0.42,5.84-0.31,12.05-2.14,19.13c-3.16,12.27,1.49,4.77,3,3.5c11.88-10,21.7-12.67,32.61-12.49c9.21,0.15,16.85,5.19,16.76,13.88c-0.12,13.6-14.24,21.49-32.49,22.49", null)),
            relatedWords = listOf(KanaWord("らいしゅう", "raishuu", "minggu depan"), KanaWord("らく", "raku", "mudah/nyaman"), KanaWord("らくだ", "rakuda", "unta"), KanaWord("らいねん", "rainen", "tahun depan"))
        ),
        KanaCharacter(
            character = "り",
            romaji = "ri",
            category = KanaCategory.GOJUON,
            strokeCount = 2,
            strokeSteps = listOf("Garis vertikal kiri pendek berujung kait", "Garis vertikal kanan panjang melengkung ke bawah"),
            strokes = listOf(KanjiStrokeItem(1, "M38.75,25.25c1.25,1.5,2.24,4.03,1.62,6.62c-2.88,12.13-6.29,29.65-4.25,42.38c2,12.5,1.75-0.75,5.62-6.25", null), KanjiStrokeItem(2, "M69.37,18.75c2.25,2.12,2.88,4.12,2.88,6.5c0,2.38,0,26.38,0,35.75c0,16.5-5,25.75-12.62,33.12", null)),
            relatedWords = listOf(KanaWord("りんご", "ringo", "apel"), KanaWord("りょうり", "ryouri", "masakan"), KanaWord("りょこう", "ryokou", "wisata/perjalanan"), KanaWord("りゆう", "riyuu", "alasan"))
        ),
        KanaCharacter(
            character = "る",
            romaji = "ru",
            category = KanaCategory.GOJUON,
            strokeCount = 1,
            strokeSteps = listOf("Garis mendatar, miring ke kiri bawah, melengkung besar dengan simpul lingkaran kecil di ujung"),
            strokes = listOf(KanjiStrokeItem(1, "M34.31,20.38c1.75,1.25,4.62,2.62,8.5,1.5c3.88-1.12,9.62-2.5,15.62-4.62c6-2.12,7.5-0.12,4.38,4.25c-3.12,4.37-18.89,24.62-27.75,34c-8.5,9-13.09,11.89,0.75,3.25c15.62-9.75,43-10.88,43,13.38c0,22.5-40.88,24.5-40.88,12.62c0-11.25,18.12-8.75,24.38-0.38", null)),
            relatedWords = listOf(KanaWord("よる", "yoru", "malam"), KanaWord("くるま", "kuruma", "mobil"), KanaWord("はる", "haru", "musim semi"), KanaWord("ひる", "hiru", "siang"))
        ),
        KanaCharacter(
            character = "れ",
            romaji = "re",
            category = KanaCategory.GOJUON,
            strokeCount = 2,
            strokeSteps = listOf("Garis vertikal tegak lurus", "Garis zig-zag meliuk dengan ekor mengarah ke kanan atas"),
            strokes = listOf(KanjiStrokeItem(1, "M34.48,13c1.5,1.38,2.83,3.74,2.5,6.38c-0.5,4-2.75,44.5-2.75,52.88c0,8.38,0.12,16.62,0.12,19.5", null), KanjiStrokeItem(2, "M16.98,40.75c2.12,1.38,3.74,1.46,7.5,0c4.5-1.75,6.55-2.66,13-5.5c4.25-1.88,4.4,0.24,2.5,3.5c-5.25,9-10.5,16.75-18.88,27.62c-7.55,9.81-6.93,12.85,3.25,3.12c14-13.38,20.34-19.76,33.88-32.5c6.38-6,19.39-12.09,18.14,0.88c-1.02,10.63-1.89,22.13-2.29,30.75c-1.02,21.71,11.53,18,20.15,8.63", null)),
            relatedWords = listOf(KanaWord("れい", "rei", "contoh / nol"), KanaWord("れきし", "rekishi", "sejarah"), KanaWord("れんしゅう", "renshuu", "latihan"), KanaWord("れいぞうこ", "reizouko", "kulkas"))
        ),
        KanaCharacter(
            character = "ろ",
            romaji = "ro",
            category = KanaCategory.GOJUON,
            strokeCount = 1,
            strokeSteps = listOf("Mirip 'ru', tetapi tanpa simpul lingkaran di ujung bawah"),
            strokes = listOf(KanjiStrokeItem(1, "M36.95,21.88c1.5,2,4.62,3.62,8.5,2.5c3.88-1.12,8.12-2.25,14.12-4.38c6-2.13,6.53-0.1,3.38,4.25c-7.88,10.88-18,22.75-27.5,35.25c-7.49,9.86-10.68,11.32,2.88,2.25c17.38-11.62,46.62-14,46.62,8.12c0,15.62-16,22.5-32.12,25.12", null)),
            relatedWords = listOf(KanaWord("ろうそく", "rousoku", "lilin"), KanaWord("ろく", "roku", "enam"), KanaWord("ろうか", "rouka", "lorong/koridor"), KanaWord("ロシア", "roshia", "Rusia"))
        ),
        KanaCharacter(
            character = "わ",
            romaji = "wa",
            category = KanaCategory.GOJUON,
            strokeCount = 2,
            strokeSteps = listOf("Garis vertikal tegak lurus", "Garis meliuk melengkung bulat besar seperti busur panah"),
            strokes = listOf(KanjiStrokeItem(1, "M38.53,14.75c1.5,1.38,2.22,3.73,2,6.38c-1,11.87-2.75,44.49-2.75,52.87c0,8.38-0.62,16.62-0.62,19.5", null), KanjiStrokeItem(2, "M17.53,40.75c2.12,1.38,3.68,1.3,7.5,0c5.88-2,9.8-3.16,16.25-6c4.25-1.88,6.12,0,2.75,4c-6.72,7.96-13,16.5-22.12,27.88c-7.75,9.66-7.54,12.21,3,2.88c21.88-19.38,49.75-35.62,63.5-21c14.36,15.27,1.62,36.62-23.38,42.62", null)),
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
            strokes = listOf(KanjiStrokeItem(1, "M28.56,27.87c1.62,1.13,3.17,1.64,6.01,1.12c10.86-1.99,16.74-3.37,24.71-4.72c3.64-0.62,5.65-0.93,8.4-0.75", null), KanjiStrokeItem(2, "M49.93,14.38c0.75,1,1.48,3.22,0.38,5.62c-4.62,10.12-10,20.75-17.12,30.25c-9.25,12.33-9.25,11.19,2.12,2.5c9-6.88,23.75-12.12,22.88,19.88", null), KanjiStrokeItem(3, "M83.06,39.88c0.62,1.75,0,4-3,5.75c-3,1.75-49.62,24.16-44.75,38.25c3.28,9.48,17.93,9.12,29.98,7.75c4.48-0.51,9.15-1.12,12.4-1.75", null)),
            relatedWords = listOf(KanaWord("partikel", "wo", "partikel penanda objek kalimat"), KanaWord("ほんをよむ", "hon o yomu", "membaca buku"), KanaWord("ごはんをたべる", "gohan o taberu", "makan nasi"))
        ),
        KanaCharacter(
            character = "ん",
            romaji = "n",
            category = KanaCategory.GOJUON,
            strokeCount = 1,
            strokeSteps = listOf("Satu tarikan garis melengkung menyerupai huruf 'n' kecil latin"),
            strokes = listOf(KanjiStrokeItem(1, "M56.35,16.5c0.75,1.75,1.13,5.83-0.38,8.25c-7,11.25-27.22,43.47-33.88,54.37c-9,14.75-7.62,16.25,1.5,1.25c17.86-29.36,32-23.76,32-6.75c0,25,19,26.5,34.25-5", null)),
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
            strokes = listOf(KanjiStrokeItem(1, "M23.5,26.25c2.41,1.56,3.98,1.44,8.51,0.75c11.4-1.75,37.77-5.5,48.28-6.78c5.23-0.64,7.99,2.06,2.62,6.04c-6.75,5-13.12,9.5-23.25,16", null), KanjiStrokeItem(2, "M53.12,41.12c0.79,1.5,1.02,3.24,0.58,5.28c-4.04,18.48-9.92,31.85-19.92,45.48", null)),
            relatedWords = listOf(KanaWord("アイス", "aisu", "es krim"), KanaWord("アジア", "ajia", "Asia"), KanaWord("アニメ", "anime", "animasi/anime"), KanaWord("アパート", "apaato", "apartemen"))
        ),
        KanaCharacter(
            character = "イ",
            romaji = "i",
            category = KanaCategory.GOJUON,
            strokeCount = 2,
            strokeSteps = listOf("Garis miring dari kanan atas ke kiri bawah", "Garis vertikal lurus ke bawah"),
            strokes = listOf(KanjiStrokeItem(1, "M69.75,16.75c0.12,1.75-0.34,3.86-1.62,5.5c-10.13,12.87-23.75,29.63-45.63,42.87", null), KanjiStrokeItem(2, "M56.38,43.88c1,1.12,1.25,3,1.25,4.62c0,1.62,0,32.75,0,34.62c0,1.87-0.13,9.13-0.13,11.76", null)),
            relatedWords = listOf(KanaWord("インド", "indo", "India"), KanaWord("インターネット", "intaanetto", "internet"), KanaWord("インク", "inku", "tinta"), KanaWord("イルカ", "iruka", "lumba-lumba"))
        ),
        KanaCharacter(
            character = "ウ",
            romaji = "u",
            category = KanaCategory.GOJUON,
            strokeCount = 3,
            strokeSteps = listOf("Titik pendek di atas", "Garis pendek vertikal kiri", "Garis mendatar berujung melengkung ke kiri bawah"),
            strokes = listOf(KanjiStrokeItem(1, "M53.25,14.62c1,1.12,1.25,3,1.25,4.62c0,1.62,0,10.76,0,12.64", null), KanjiStrokeItem(2, "M26.5,31.25c1,1.12,1.22,3,1.25,4.62c0.09,4.45,0.29,10.95,0.45,16.37c0.07,2.5,0.14,4.77,0.18,6.5", null), KanjiStrokeItem(3, "M29.12,35.88c19.38-2.25,40.25-4.25,49-5.5c8.75-1.25,8.28,0.84,6.25,6.88c-5,14.88-20.12,43.5-41,56.62", null)),
            relatedWords = listOf(KanaWord("ウェブ", "webu", "website"), KanaWord("ウイスキー", "uisukii", "whisky"), KanaWord("ウール", "uuru", "wol"), KanaWord("ウイルス", "uirusu", "virus"))
        ),
        KanaCharacter(
            character = "エ",
            romaji = "e",
            category = KanaCategory.GOJUON,
            strokeCount = 3,
            strokeSteps = listOf("Garis mendatar atas", "Garis vertikal tengah", "Garis mendatar bawah lebih panjang"),
            strokes = listOf(KanjiStrokeItem(1, "M31.87,35.68c2.32,0.71,5.14,0.66,7.48,0.29c8.57-1.35,22.4-2.85,33.66-3.85c2.26-0.2,4.52-0.19,6.77,0.22", null), KanjiStrokeItem(2, "M53.34,38.13c1,1.12,1.31,3,1.25,4.62c-0.18,4.74-0.51,12.89-0.83,22.25c-0.08,2.31-0.16,4.7-0.23,7.12", null), KanjiStrokeItem(3, "M19,75.46c3.41,0.94,7.57,0.88,11.01,0.39c17.78-2.48,34.53-3.86,50.55-3.9c3.34-0.01,7.23,0.42,10.46,1.8", null)),
            relatedWords = listOf(KanaWord("エアコン", "eakon", "AC (Air Conditioner)"), KanaWord("エレベーター", "erebeetaa", "lift"), KanaWord("エスカレーター", "esukareetaa", "eskalator"), KanaWord("エネルギー", "enerugii", "energi"))
        ),
        KanaCharacter(
            character = "オ",
            romaji = "o",
            category = KanaCategory.GOJUON,
            strokeCount = 3,
            strokeSteps = listOf("Garis mendatar", "Garis vertikal berujung kait ke kiri", "Garis miring ke kanan bawah"),
            strokes = listOf(KanjiStrokeItem(1, "M19.5,37.85c3.91,1.78,7.55,1.55,11.01,1.02c18.03-2.75,34.4-4.5,50.55-5.41c3.34-0.19,6.35,0.17,10.46,1.38", null), KanjiStrokeItem(2, "M60.38,16.38c1.32,1.49,1.65,3.97,1.65,6.12c0,8-0.25,46.23-0.25,58.63c0,20.38-5.88,7.5-9.25,5.5", null), KanjiStrokeItem(3, "M60.29,36.38c0,1.62-1.64,3.61-3.62,6c-7.88,9.5-21.12,22.75-34.62,33", null)),
            relatedWords = listOf(KanaWord("オレンジ", "orenji", "jeruk"), KanaWord("オイル", "oiru", "minyak"), KanaWord("オーストラリア", "oosutoraria", "Australia"), KanaWord("オフィス", "ofisu", "kantor"))
        ),
        KanaCharacter(
            character = "カ",
            romaji = "ka",
            category = KanaCategory.GOJUON,
            strokeCount = 2,
            strokeSteps = listOf("Garis mendatar berujung kait ke bawah", "Garis miring memotong ke kiri bawah"),
            strokes = listOf(KanjiStrokeItem(1, "M25.5,40.62c1.88,1.25,4.51,1.87,7.12,1.5c17.88-2.5,32.78-4.51,42.5-5.88c7.12-1,10.59,0.24,8.62,7.88c-2.12,8.25-4.47,17.81-9.25,29.12c-10.49,24.88-14.11,14.51-19.24,11.88", null), KanjiStrokeItem(2, "M55.88,17.12c0.88,1.62,1.29,3.83,0.75,6.75c-4.25,22.88-15.88,45.25-30.25,58.88", null)),
            relatedWords = listOf(KanaWord("カメラ", "kamera", "kamera"), KanaWord("カフェ", "kafe", "kafe"), KanaWord("カード", "kaado", "kartu"), KanaWord("カレー", "karee", "kari"))
        ),
        KanaCharacter(
            character = "キ",
            romaji = "ki",
            category = KanaCategory.GOJUON,
            strokeCount = 3,
            strokeSteps = listOf("Dua garis mendatar sejajar", "Garis miring memotong ke bawah"),
            strokes = listOf(KanjiStrokeItem(1, "M27,40.5c1.75,0.62,4.77,1.09,7.25,0.38c11.75-3.38,30.62-8.13,37.5-9.88c2.62-0.67,6.75-1.12,9-1", null), KanjiStrokeItem(2, "M19.5,65.8c2.28,0.84,6.24,1.18,9.46,0.17c17.79-5.59,32.67-9.09,49.17-12.99c3.43-0.81,8.81-1.52,11.74-1.35", null), KanjiStrokeItem(3, "M48.87,16.75c2.5,1.75,3.43,3.24,3.88,6.12c2.12,13.62,6.38,45.38,8.25,59.25c0.4,3,1,8.38,1.38,11.12", null)),
            relatedWords = listOf(KanaWord("キロ", "kiro", "kilo/kilometer"), KanaWord("キャンプ", "kyampu", "kemah"), KanaWord("キッチン", "kicchin", "dapur"), KanaWord("キス", "kisu", "ciuman"))
        ),
        KanaCharacter(
            character = "ク",
            romaji = "ku",
            category = KanaCategory.GOJUON,
            strokeCount = 2,
            strokeSteps = listOf("Garis miring pendek ke kiri bawah", "Garis mendatar lalu melengkung panjang ke kiri bawah"),
            strokes = listOf(KanjiStrokeItem(1, "M50,19.62c0.38,1.5,0.34,3.48-0.5,5.12c-4.12,8.12-7.88,15.5-16.12,24.12", null), KanjiStrokeItem(2, "M51.25,28.62c2.62,0.25,5.67-0.39,7.62-0.88c6-1.5,9.75-2.38,15.12-3.88c5.79-1.62,7.53-0.42,5.12,4.88c-10.36,22.88-26.24,44.14-48.61,60.51", null)),
            relatedWords = listOf(KanaWord("クラス", "kurasu", "kelas"), KanaWord("クラブ", "kurabu", "klub"), KanaWord("クリスマス", "kurisumasu", "natal"), KanaWord("クリーニング", "kuriiningu", "laundry"))
        ),
        KanaCharacter(
            character = "ケ",
            romaji = "ke",
            category = KanaCategory.GOJUON,
            strokeCount = 3,
            strokeSteps = listOf("Garis miring pendek", "Garis mendatar", "Garis melengkung memotong ke kiri bawah"),
            strokes = listOf(KanjiStrokeItem(1, "M40.96,17.88c0.44,1.9,0.39,4.42-0.59,6.5c-4.82,10.31-9.21,19.67-18.87,30.62", null), KanjiStrokeItem(2, "M37.88,37.62c2.12,0.88,4.15,1.04,6.62,0.5c12.62-2.75,25.5-4.88,35.75-6.5c3.61-0.57,6.25-0.75,9.25-0.5", null), KanjiStrokeItem(3, "M64.46,38.88c0.44,1.9,0.5,4.27-0.08,6.5c-3.63,13.75-9.25,31.25-24.63,43.87", null)),
            relatedWords = listOf(KanaWord("ケーキ", "keeki", "kue"), KanaWord("ケース", "keesu", "wadah/kasus"), KanaWord("ケチャップ", "kechappu", "saus tomat"), KanaWord("ゲーム", "geemu", "permainan/game"))
        ),
        KanaCharacter(
            character = "コ",
            romaji = "ko",
            category = KanaCategory.GOJUON,
            strokeCount = 2,
            strokeSteps = listOf("Garis mendatar atas dengan sudut ke bawah", "Garis mendatar bawah"),
            strokes = listOf(KanjiStrokeItem(1, "M30.13,35c1.75,1,3.01,2.18,6.5,1.62c14.25-2.25,29.62-4.25,37.38-5.5c9.37-1.51,9.88,0.25,8,7.5c-2.77,10.71-5.25,22.12-7,34.88", null), KanjiStrokeItem(2, "M27.5,77.38c2.62,1.12,4.38,1.51,8.25,1c11.38-1.5,22.62-3,33.75-3.38c4-0.13,5.88,0,9.62,0.5", null)),
            relatedWords = listOf(KanaWord("コーヒー", "koohii", "kopi"), KanaWord("コンビニ", "kombini", "minimarket"), KanaWord("コップ", "koppu", "gelas"), KanaWord("コート", "kooto", "mantel"))
        ),
        KanaCharacter(
            character = "サ",
            romaji = "sa",
            category = KanaCategory.GOJUON,
            strokeCount = 3,
            strokeSteps = listOf("Garis mendatar", "Garis vertikal pendek kiri", "Garis vertikal memotong melengkung kanan"),
            strokes = listOf(KanjiStrokeItem(1, "M16.5,44.34c2.84,1.27,4.77,1.91,8.93,1.13c17.2-3.22,40.45-5.35,58.53-5.34c4.33,0,6.92,0.37,10.42,0.82", null), KanjiStrokeItem(2, "M36.63,23.38c1.12,1.38,1.19,2.5,1.25,4.75c0.25,9,0.38,20.25,0.75,28.88c0.14,3.25,0.38,7.12,0.38,9.25", null), KanjiStrokeItem(3, "M69.63,16.62c1.5,2,1.62,2.87,1.62,6.25c0,8.25-0.16,9-0.16,15.88c0,23.25-9.34,42.5-23.21,53", null)),
            relatedWords = listOf(KanaWord("サラダ", "sarada", "salad"), KanaWord("サンドイッチ", "sandoicchi", "roti lapis"), KanaWord("サービス", "saabisu", "layanan gratis"), KanaWord("サイクリング", "saikuringu", "bersepeda"))
        ),
        KanaCharacter(
            character = "シ",
            romaji = "shi",
            category = KanaCategory.GOJUON,
            strokeCount = 3,
            strokeSteps = listOf("Dua titik miring ke bawah", "Garis panjang menyapu dari kiri bawah ke kanan atas"),
            strokes = listOf(KanjiStrokeItem(1, "M39.87,19.75c5.14,1.57,9.79,6.01,11.5,8.62", null), KanjiStrokeItem(2, "M26,42.62c3.25,0.88,10.25,5.5,12.25,8.13", null), KanjiStrokeItem(3, "M33,85c3.75,0.88,7.12,0.49,10.38-1.38c17.87-10.24,32.37-23.87,46.12-42.87", null)),
            relatedWords = listOf(KanaWord("シャツ", "shatsu", "kemeja"), KanaWord("シャワー", "shawaa", "pancuran mandi"), KanaWord("システム", "shisutemu", "sistem"), KanaWord("ショッピング", "shoppingu", "belanja"))
        ),
        KanaCharacter(
            character = "ス",
            romaji = "su",
            category = KanaCategory.GOJUON,
            strokeCount = 2,
            strokeSteps = listOf("Garis mendatar lalu miring ke kiri", "Garis miring dari tengah ke kanan bawah"),
            strokes = listOf(KanjiStrokeItem(1, "M30.13,29.38c1.75,1.5,4.15,1.98,6.62,1.38c13.25-3.25,24.25-5.62,31.25-7.38c7-1.76,8.64,1.16,6.5,5.75c-11.24,24.12-28.37,45.87-53.5,57.25", null), KanjiStrokeItem(2, "M61,57.25c11,7.38,21,17,28,28.62", null)),
            relatedWords = listOf(KanaWord("スポーツ", "supootsu", "olahraga"), KanaWord("スーパー", "suupaa", "supermarket"), KanaWord("スキー", "sukii", "ski"), KanaWord("スープ", "suupu", "sup"))
        ),
        KanaCharacter(
            character = "セ",
            romaji = "se",
            category = KanaCategory.GOJUON,
            strokeCount = 2,
            strokeSteps = listOf("Garis mendatar berujung turun ke bawah", "Garis vertikal melengkung ke kanan"),
            strokes = listOf(KanjiStrokeItem(1, "M17,49.38c3.12,1.5,5.04,2.18,8.62,1.38c23.5-5.25,31.24-7.43,50.62-11.62c23.12-5,6.5,7.75-3.25,18.12", null), KanjiStrokeItem(2, "M42.38,19.5c2,2.25,2.15,3.5,2.12,6.62c-0.12,17.5-0.88,31.75-0.88,41.12c0,14,3.13,16.99,12.38,17.12c8.38,0.12,14.12,0.12,18,0.12c3.88,0,7.5-0.5,10.5-1.12", null)),
            relatedWords = listOf(KanaWord("セーター", "seetaa", "sweater"), KanaWord("センター", "sentaa", "pusat"), KanaWord("セット", "setto", "set/paket"), KanaWord("セル", "seru", "sel"))
        ),
        KanaCharacter(
            character = "ソ",
            romaji = "so",
            category = KanaCategory.GOJUON,
            strokeCount = 2,
            strokeSteps = listOf("Titik miring kiri atas", "Garis panjang dari kanan atas menyapu ke kiri bawah"),
            strokes = listOf(KanjiStrokeItem(1, "M23.5,25.5c3.92,4.1,7.71,9.93,10.75,17.88", null), KanjiStrokeItem(2, "M83.5,21c1.25,2.5,1.3,4.44,0.12,8.5c-5.87,20.38-26.24,49.5-45.62,61.25", null)),
            relatedWords = listOf(KanaWord("ソファ", "sofa", "sofa"), KanaWord("ソース", "soosu", "saus"), KanaWord("ソフト", "sofuto", "perangkat lunak"), KanaWord("ソックス", "sokkusu", "kaus kaki"))
        ),
        KanaCharacter(
            character = "タ",
            romaji = "ta",
            category = KanaCategory.GOJUON,
            strokeCount = 3,
            strokeSteps = listOf("Garis miring pendek", "Garis mendatar lalu melengkung ke bawah", "Garis miring memotong di dalam"),
            strokes = listOf(KanjiStrokeItem(1, "M48.83,19.75c0.43,1.72,0.39,4-0.58,5.89c-4.77,9.34-9.1,17.82-18.63,27.73", null), KanjiStrokeItem(2, "M49.75,30.38c2.75,0.5,5,0,7.62-0.62c6.02-1.43,10.5-2.62,15.88-4.12c5.79-1.62,8.22,0.31,5.88,5.62c-10.88,24.62-22.13,43.99-50.13,59.99", null), KanjiStrokeItem(3, "M43.38,45.62c6.75,3.5,10.62,7.88,14.75,15.25", null)),
            relatedWords = listOf(KanaWord("タクシー", "takushii", "taksi"), KanaWord("タオル", "taoru", "handuk"), KanaWord("タイプ", "taipu", "tipe/jenis"), KanaWord("タワー", "tawaa", "menara"))
        ),
        KanaCharacter(
            character = "チ",
            romaji = "chi",
            category = KanaCategory.GOJUON,
            strokeCount = 3,
            strokeSteps = listOf("Garis miring pendek di atas", "Garis mendatar tengah", "Garis melengkung memotong ke kiri bawah"),
            strokes = listOf(KanjiStrokeItem(1, "M69.76,15.25c-0.38,2.62-2.01,4.37-3.88,5.38c-7.88,4.25-18.62,9.75-35.5,13.25", null), KanjiStrokeItem(2, "M18.5,51.5c2.88,0.88,4.39,1.65,7.88,1.25c22-2.5,36.38-4.25,56.12-4.88c4.88-0.15,7.88,0.51,10.88,1.51", null), KanjiStrokeItem(3, "M54.88,30.75c0.88,0.75,1.75,2.49,1.75,4.75c0,6.03,0.03,11.25,0.03,18.27c0,14.98-5.03,29.48-16.53,39.23", null)),
            relatedWords = listOf(KanaWord("チーズ", "chiizu", "keju"), KanaWord("チーム", "chiimu", "tim"), KanaWord("チケット", "chiketto", "tiket"), KanaWord("チャンス", "chansu", "kesempatan"))
        ),
        KanaCharacter(
            character = "ツ",
            romaji = "tsu",
            category = KanaCategory.GOJUON,
            strokeCount = 3,
            strokeSteps = listOf("Dua titik hampir vertikal sejajar", "Garis panjang menyapu dari kanan atas ke kiri bawah"),
            strokes = listOf(KanjiStrokeItem(1, "M21.5,31.38c2.38,3,4.5,9.38,4.88,13.88", null), KanjiStrokeItem(2, "M45.62,23.75c3.38,3.5,6.62,9.5,7,14.88", null), KanjiStrokeItem(3, "M84.62,27.88c0.75,2.25,0.39,5.26-0.75,8c-7.63,18.37-21.25,41.12-46,52.5", null)),
            relatedWords = listOf(KanaWord("ツアー", "tsuaa", "tur/wisata"), KanaWord("ツイン", "tsuin", "kembar/twin bed"), KanaWord("ツール", "tsuuru", "alat/tool"), KanaWord("ツアー", "tsuaa", "tur"))
        ),
        KanaCharacter(
            character = "テ",
            romaji = "te",
            category = KanaCategory.GOJUON,
            strokeCount = 3,
            strokeSteps = listOf("Garis mendatar pendek atas", "Garis mendatar panjang tengah", "Garis melengkung memotong ke kiri bawah"),
            strokes = listOf(KanjiStrokeItem(1, "M36.5,21.5c2.12,1.25,4.38,1.59,7.25,1.25c10.62-1.25,16.88-2.25,24.62-3.25c3.73-0.48,5.63-0.5,8.13-0.25", null), KanjiStrokeItem(2, "M20,44.12c2.88,1,5.26,1.05,7.5,0.75c22.38-3,37-5.62,54.13-6.12c5.62-0.16,7.75,0,10.38,0.62", null), KanjiStrokeItem(3, "M58,43.25c0.88,1,1.32,2.63,1.12,4.38c-1.74,15.37-11.62,34.99-24.62,41.87", null)),
            relatedWords = listOf(KanaWord("テレビ", "terebi", "televisi"), KanaWord("テーブル", "teeburu", "meja makan"), KanaWord("テスト", "tesuto", "ujian/tes"), KanaWord("テニス", "tenisu", "tenis"))
        ),
        KanaCharacter(
            character = "ト",
            romaji = "to",
            category = KanaCategory.GOJUON,
            strokeCount = 2,
            strokeSteps = listOf("Garis vertikal tegak lurus", "Garis miring pendek ke kanan bawah"),
            strokes = listOf(KanjiStrokeItem(1, "M44,16.38c1.25,1.12,2.12,3.25,2.12,5.5c0,26.12,0,53.5,0,57.62c0,4.12,0,10.5,0,13.38", null), KanjiStrokeItem(2, "M49.24,43.12c11.75,4.12,18.25,10.62,24.5,18.75", null)),
            relatedWords = listOf(KanaWord("トイレ", "toire", "toilet"), KanaWord("トマト", "tomato", "tomat"), KanaWord("トースト", "toosuto", "roti panggang"), KanaWord("トラック", "torakku", "truk"))
        ),
        KanaCharacter(
            character = "ナ",
            romaji = "na",
            category = KanaCategory.GOJUON,
            strokeCount = 2,
            strokeSteps = listOf("Garis mendatar", "Garis memotong melengkung ke kiri bawah"),
            strokes = listOf(KanjiStrokeItem(1, "M18.5,44.12c2.62,1,4.77,1.17,9.12,0.5c19.38-3,37.75-4.75,52.38-5.62c3.75-0.22,8.88-0.25,11.88,0.12", null), KanjiStrokeItem(2, "M53.26,14.5c1.75,1.25,2.75,3,2.75,6c0,3,0.12,21.5,0.12,24.25c0,20-6,37.62-18.38,49.12", null)),
            relatedWords = listOf(KanaWord("ナイフ", "naifu", "pisau"), KanaWord("ナンバー", "nambaa", "nomor"), KanaWord("ナイロン", "nairon", "nilon"), KanaWord("ナプキン", "napukin", "serbet"))
        ),
        KanaCharacter(
            character = "ニ",
            romaji = "ni",
            category = KanaCategory.GOJUON,
            strokeCount = 2,
            strokeSteps = listOf("Dua garis mendatar sejajar (atas lebih pendek)"),
            strokes = listOf(KanjiStrokeItem(1, "M32.63,34.69c2.5,1.19,4.33,1.6,7.45,1.35c11.55-0.91,18.3-2.41,27.04-3.18c2.64-0.23,6.27-0.16,8.39,0.08", null), KanjiStrokeItem(2, "M20,74.88c2.62,1,4.78,1.45,9.12,0.75c20.25-3.25,36.5-3.88,52.38-3.88c3.75,0,8,1,11.12,2.38", null)),
            relatedWords = listOf(KanaWord("ニュース", "nyuusu", "berita"), KanaWord("ニックネーム", "nikkuneemu", "nama panggilan"), KanaWord("ニコチン", "nikochin", "nikotin"), KanaWord("ニッケル", "nikkeru", "nikel"))
        ),
        KanaCharacter(
            character = "ヌ",
            romaji = "nu",
            category = KanaCategory.GOJUON,
            strokeCount = 2,
            strokeSteps = listOf("Garis mendatar lalu miring ke kiri bawah", "Garis miring memotong ke kanan bawah"),
            strokes = listOf(KanjiStrokeItem(1, "M33.38,27.62c2.75,1.25,5.38,1.16,8.5,0.62c10.12-1.75,19-3.12,28.62-5c6.67-1.3,7.75-0.12,5.38,5.62c-6.7,16.22-20.63,40.52-48.88,57.89", null), KanjiStrokeItem(2, "M44.88,46.38c12,6.75,22.38,15.38,30.62,28.12", null)),
            relatedWords = listOf(KanaWord("ヌードル", "nuudoru", "mi"), KanaWord("ヌード", "nuudo", "telanjang"), KanaWord("ヌガー", "nugaa", "permen nougat"), KanaWord("ヌバック", "nubakku", "kulit nubuck"))
        ),
        KanaCharacter(
            character = "ネ",
            romaji = "ne",
            category = KanaCategory.GOJUON,
            strokeCount = 4,
            strokeSteps = listOf("Titik atas", "Garis vertikal kiri", "Garis mendatar menyudut", "Garis miring kanan"),
            strokes = listOf(KanjiStrokeItem(1, "M51.38,12.38c3.38,2.12,8,5.88,11,10.88", null), KanjiStrokeItem(2, "M26.88,36.16c2.62,1.46,5.45,1.93,8.5,1.19c10.75-2.6,20.75-4.98,30.88-7.5c6.53-1.62,7.81,1.27,4.62,4.68c-11.63,12.47-22.76,23.35-48.88,37.97", null), KanjiStrokeItem(3, "M54.38,54.12c1.38,1.75,1.62,3.5,1.62,6c0,2.5,0,27.5,0,29.38c0,1.88,0,4,0,6.88", null), KanjiStrokeItem(4, "M65.38,53.62c12.5,6,19.88,11.75,24.88,18.88", null)),
            relatedWords = listOf(KanaWord("ネクタイ", "nekutai", "dasi"), KanaWord("ネット", "netto", "internet"), KanaWord("ネガ", "nega", "film negatif"), KanaWord("ネットワーク", "nettowaaku", "jaringan"))
        ),
        KanaCharacter(
            character = "ノ",
            romaji = "no",
            category = KanaCategory.GOJUON,
            strokeCount = 1,
            strokeSteps = listOf("Satu garis miring melengkung dari kanan atas ke kiri bawah"),
            strokes = listOf(KanjiStrokeItem(1, "M72.37,25.25c0.75,2,0.92,4.89,0.25,7.25c-7.12,25-25.38,44.75-43.62,56.88", null)),
            relatedWords = listOf(KanaWord("ノート", "nooto", "buku catatan"), KanaWord("ノーマル", "noomaru", "normal"), KanaWord("ノック", "nokku", "mengetuk pintu"), KanaWord("ノンアルコール", "non'arukooru", "bebas alkohol"))
        ),
        KanaCharacter(
            character = "ハ",
            romaji = "ha",
            category = KanaCategory.GOJUON,
            strokeCount = 2,
            strokeSteps = listOf("Garis miring ke kiri bawah", "Garis miring ke kanan bawah (membentuk tenda terbuka)"),
            strokes = listOf(KanjiStrokeItem(1, "M39.33,36.88c0.38,1.14,0.46,2.88-0.12,4.14c-6.33,13.73-13.33,23.86-22.21,32.23", null), KanjiStrokeItem(2, "M65.5,36.38c13,9.12,23.12,22.62,28,33.38", null)),
            relatedWords = listOf(KanaWord("ハンバーガー", "hambaagaa", "hamburger"), KanaWord("ハワイ", "hawai", "Hawaii"), KanaWord("ハム", "hamu", "daging ham"), KanaWord("ハサミ", "hasami", "gunting"))
        ),
        KanaCharacter(
            character = "ヒ",
            romaji = "hi",
            category = KanaCategory.GOJUON,
            strokeCount = 2,
            strokeSteps = listOf("Garis mendatar lalu vertikal ke bawah", "Garis melengkung dari kiri ke kanan atas"),
            strokes = listOf(KanjiStrokeItem(1, "M35.38,44.5c1.75,1.38,4.51,2.19,6.88,1.88c10.24-1.38,17.24-2.88,24.24-4.26c3.01-0.59,7.12-1,9.38-0.88", null), KanjiStrokeItem(2, "M31,17.62c1.38,1.26,1.88,3.38,1.88,6.13c0,2.75-0.88,44-0.88,47.25c0,9.75,4,14.62,13.75,14.62c6,0,16.38,0.12,21.38,0c5-0.12,9.5-0.62,13.5-1.5", null)),
            relatedWords = listOf(KanaWord("ヒーター", "hiitaa", "pemanas ruangan"), KanaWord("ヒーロー", "hiiroo", "pahlawan"), KanaWord("ヒント", "hinto", "petunjuk"), KanaWord("ヒット", "hitto", "populer/hit"))
        ),
        KanaCharacter(
            character = "フ",
            romaji = "fu",
            category = KanaCategory.GOJUON,
            strokeCount = 1,
            strokeSteps = listOf("Garis mendatar lalu menyudut miring melengkung ke kiri bawah"),
            strokes = listOf(KanjiStrokeItem(1, "M24.5,30c1.88,1.88,3.5,2.04,6.5,1.62c14.5-2,29-4.38,43.75-6.88c6.82-1.16,10.58,2.29,6.88,9.12c-10.38,19.14-21.25,39.52-50.01,53.64", null)),
            relatedWords = listOf(KanaWord("フォーク", "fooku", "garpu"), KanaWord("フランス", "furansu", "Prancis"), KanaWord("フルーツ", "furuutsu", "buah-buahan"), KanaWord("フライト", "furaito", "penerbangan"))
        ),
        KanaCharacter(
            character = "ヘ",
            romaji = "he",
            category = KanaCategory.GOJUON,
            strokeCount = 1,
            strokeSteps = listOf("Satu garis membentuk puncak atap miring ke kanan (identik dengan hiragana)"),
            strokes = listOf(KanjiStrokeItem(1, "M15.5,49.02c2.78,1.55,5.39,0.64,6.95-0.9c4.05-4.01,9.47-8.3,12-10.88c3.16-3.23,7.32-5.26,12.01-1.16c11.25,9.82,25.03,21.45,35.78,30.36c4.28,3.55,7.71,6.85,11.25,9.56", null)),
            relatedWords = listOf(KanaWord("ヘルメット", "herumetto", "helm"), KanaWord("ヘッドホン", "heddohon", "headphone"), KanaWord("ヘリコプター", "herikoputaa", "helikopter"), KanaWord("ヘルシー", "herushii", "sehat"))
        ),
        KanaCharacter(
            character = "ホ",
            romaji = "ho",
            category = KanaCategory.GOJUON,
            strokeCount = 4,
            strokeSteps = listOf("Garis mendatar", "Garis vertikal memotong dengan kait", "Dua garis miring di kiri dan kanan"),
            strokes = listOf(KanjiStrokeItem(1, "M22.63,40.38c2.62,1,4.75,1.71,9.12,1.25c17.75-1.88,29.25-2.75,45.38-3.88c3.74-0.26,7.38-0.12,11.12,0.62", null), KanjiStrokeItem(2, "M53.75,17.12c1.38,1.88,1.38,4.5,1.38,7.38c0,2.88-0.12,46.62-0.12,51.88c0,23.12-6.25,11.25-9.75,9.62", null), KanjiStrokeItem(3, "M27.38,59.38c0.5,9.25-1.38,16.62-6.38,21.88", null), KanjiStrokeItem(4, "M73.25,52.75c10.88,9.63,15.5,17.63,16.63,24.87", null)),
            relatedWords = listOf(KanaWord("ホテル", "hoteru", "hotel"), KanaWord("ホット", "hotto", "panas/hangat"), KanaWord("ホーム", "hoomu", "peron stasiun"), KanaWord("ホワイト", "howaito", "putih"))
        ),
        KanaCharacter(
            character = "マ",
            romaji = "ma",
            category = KanaCategory.GOJUON,
            strokeCount = 2,
            strokeSteps = listOf("Garis mendatar lalu miring ke kiri", "Garis miring pendek ke kanan bawah"),
            strokes = listOf(KanjiStrokeItem(1, "M21.5,33.75c1.88,1.88,3.5,1.99,6.5,1.62c19.62-2.38,33.5-4,51.25-6.38c6.85-0.92,9.37,1.67,4.38,7.62c-7.12,8.5-17.88,20-28.75,31.62", null), KanjiStrokeItem(2, "M43.38,58.88c8.43,6.5,16.6,15.93,20.25,26.25", null)),
            relatedWords = listOf(KanaWord("マスク", "masuku", "masker"), KanaWord("マンション", "manshon", "apartemen"), KanaWord("マイク", "maiku", "mikrofon"), KanaWord("マッチ", "macchi", "korek api"))
        ),
        KanaCharacter(
            character = "ミ",
            romaji = "mi",
            category = KanaCategory.GOJUON,
            strokeCount = 3,
            strokeSteps = listOf("Tiga garis miring pendek sejajar dari kiri atas ke kanan bawah"),
            strokes = listOf(KanjiStrokeItem(1, "M41.87,20c10.4,2.57,20.5,6.3,25,10.38", null), KanjiStrokeItem(2, "M42,46.88c10.72,2.69,21.11,6.6,25.75,10.88", null), KanjiStrokeItem(3, "M36.5,75c15.71,4.49,30.95,11,37.75,18.12", null)),
            relatedWords = listOf(KanaWord("ミルク", "miruku", "susu sapi"), KanaWord("ミス", "misu", "kesalahan/miss"), KanaWord("ミシン", "mishin", "mesin jahit"), KanaWord("ミュージアム", "myuujiamu", "museum"))
        ),
        KanaCharacter(
            character = "ム",
            romaji = "mu",
            category = KanaCategory.GOJUON,
            strokeCount = 2,
            strokeSteps = listOf("Garis miring menyudut ke kanan bawah", "Garis mendatar memotong di bawah"),
            strokes = listOf(KanjiStrokeItem(1, "M53.84,22.5c0.88,1.75,0.78,4.57-0.38,6.88c-9.25,18.38-16.19,30.96-25.25,45.75c-3.75,6.12-3,8.38,4.38,7.12c7.38-1.26,46.62-8.12,49.62-8.88", null), KanjiStrokeItem(2, "M72.21,60.12c6.88,6.38,13.62,14.88,16,25.38", null)),
            relatedWords = listOf(KanaWord("ムービー", "muubii", "film bioskop"), KanaWord("ムード", "muudo", "suasana hati/mood"), KanaWord("ムール貝", "muurugai", "kerang remis"), KanaWord("ムース", "muusu", "kue mousse"))
        ),
        KanaCharacter(
            character = "メ",
            romaji = "me",
            category = KanaCategory.GOJUON,
            strokeCount = 2,
            strokeSteps = listOf("Garis miring dari kanan atas ke kiri bawah", "Garis miring memotong dari kiri atas ke kanan bawah"),
            strokes = listOf(KanjiStrokeItem(1, "M73.38,19.12c0.88,1.75,0.48,4.44-0.38,6.88c-7.75,22.12-21.75,47.62-45,62.88", null), KanjiStrokeItem(2, "M39.51,39.5c16.54,7.76,32.12,18,38.5,30.88", null)),
            relatedWords = listOf(KanaWord("メニュー", "menyuu", "daftar menu"), KanaWord("メール", "meeru", "email/pesan"), KanaWord("メロン", "meron", "melon"), KanaWord("メーター", "meetaa", "meteran"))
        ),
        KanaCharacter(
            character = "モ",
            romaji = "mo",
            category = KanaCategory.GOJUON,
            strokeCount = 3,
            strokeSteps = listOf("Dua garis mendatar sejajar", "Garis vertikal melengkung ke kanan di bawah"),
            strokes = listOf(KanjiStrokeItem(1, "M27.88,26.19c2.5,1.19,4.33,1.6,7.45,1.35c11.55-0.91,21.93-2.16,32.79-3.93c2.62-0.42,6.27-0.41,8.39-0.17", null), KanjiStrokeItem(2, "M17.5,54.38c2.62,1,4.78,1.45,9.12,0.75c20.26-3.25,33.88-5.38,51.64-6.13c3.75-0.16,7.38,0.25,11.12,0.88", null), KanjiStrokeItem(3, "M48.76,29.88c1.12,1.62,1.42,3.62,1.42,6.12c0,6.53-0.65,33.56-0.65,35.88c0,7.67,3.09,11.08,10.53,11.76c5.33,0.49,12.31,0.24,16.37,0c4.46-0.26,6.52-0.74,9.59-1.43", null)),
            relatedWords = listOf(KanaWord("モデル", "moderu", "model"), KanaWord("モダン", "modan", "modern"), KanaWord("モーター", "mootaa", "motor penggerak"), KanaWord("モーニング", "mooningu", "pagi hari"))
        ),
        KanaCharacter(
            character = "ヤ",
            romaji = "ya",
            category = KanaCategory.GOJUON,
            strokeCount = 2,
            strokeSteps = listOf("Garis mendatar menyudut melengkung ke kiri bawah", "Garis miring memotong dari atas ke kanan bawah"),
            strokes = listOf(KanjiStrokeItem(1, "M18,45.75c2.12,1.62,6.15,2.35,10.12,1.38c18.88-4.62,33.39-7.83,48.88-11.88c22-5.75,1.5,14.25-2.75,20", null), KanjiStrokeItem(2, "M38.47,19.38c1.65,1.4,2.54,2.67,3.18,5.21c0.64,2.54,11.95,52.9,12.59,55.57c0.64,2.67,2.16,9.16,3.05,12.46", null)),
            relatedWords = listOf(KanaWord("ヤング", "yangu", "muda"), KanaWord("ヤード", "yaado", "yard/halaman"), KanaWord("ダイヤ", "daiya", "berlian/intan"), KanaWord("タイヤ", "taiya", "ban kendaraan"))
        ),
        KanaCharacter("", "", KanaCategory.GOJUON),
        KanaCharacter(
            character = "ユ",
            romaji = "yu",
            category = KanaCategory.GOJUON,
            strokeCount = 2,
            strokeSteps = listOf("Garis mendatar lalu vertikal ke bawah", "Garis mendatar panjang memotong di bawah"),
            strokes = listOf(KanjiStrokeItem(1, "M29.5,35.38c2.38,1.5,5.14,2.08,9.25,1.5c13.25-1.88,18.02-2.4,27.62-4c6.75-1.12,7.78,0.16,6.5,6.38c-2.38,11.5-4.88,24.5-6.5,34.5", null), KanjiStrokeItem(2, "M17,76.88c2.75,1.5,4.76,2.05,9.12,1.5c22.62-2.88,36-3.88,54.12-3.88c3.75,0,7.38,0.5,11.12,1.12", null)),
            relatedWords = listOf(KanaWord("ユーザー", "yuuzaa", "pengguna/user"), KanaWord("ユニフォーム", "yunifoomu", "seragam"), KanaWord("ユーモア", "yuumoa", "humor"), KanaWord("ユーロ", "yuuro", "mata uang Euro"))
        ),
        KanaCharacter("", "", KanaCategory.GOJUON),
        KanaCharacter(
            character = "ヨ",
            romaji = "yo",
            category = KanaCategory.GOJUON,
            strokeCount = 3,
            strokeSteps = listOf("Garis mendatar lalu vertikal", "Dua garis mendatar sejajar di dalam"),
            strokes = listOf(KanjiStrokeItem(1, "M29.13,30.12c2.38,1.5,5.12,1.98,9.25,1.5c14-1.62,26.71-3.04,36.38-4.25c6-0.75,6.88,0.5,6.5,6.38c-1,15.51-1.89,30.63-3.01,42.25", null), KanjiStrokeItem(2, "M29.25,52.88c2.38,1.5,5.12,1.98,9.25,1.5c10.5-1.22,22.81-2.29,31.11-3.04c2.77-0.25,5.27,0.04,7.77,0.54", null), KanjiStrokeItem(3, "M23.5,78.84c2.75,1.3,4.74,1.68,9.12,1.3c12.5-1.08,29.37-2.9,41.38-2.9c3.38,0,5.62,0,9.38,0.54", null)),
            relatedWords = listOf(KanaWord("ヨーグルト", "yooguruto", "yogurt"), KanaWord("ヨーロッパ", "yooroppa", "Eropa"), KanaWord("ヨット", "yotto", "kapal pesiar yacht"), KanaWord("ヨガ", "yoga", "senam yoga"))
        ),
        KanaCharacter(
            character = "ラ",
            romaji = "ra",
            category = KanaCategory.GOJUON,
            strokeCount = 2,
            strokeSteps = listOf("Garis mendatar pendek atas", "Garis mendatar berujung melengkung panjang ke kiri"),
            strokes = listOf(KanjiStrokeItem(1, "M38.63,21.06c2.07,1.86,4.43,2.53,8.05,2.15c9.2-0.96,14.34-2.01,21.57-2.95c2.41-0.31,4.13-0.53,6.51-0.19", null), KanjiStrokeItem(2, "M26,41.89c2.38,1.7,5.12,2.24,9.25,1.7c14-1.84,31.21-4.95,40.88-6.32c6-0.85,8.14,0.62,6.25,5.72c-6.88,18.62-22,38.25-45.25,48.62", null)),
            relatedWords = listOf(KanaWord("ラジオ", "rajio", "radio"), KanaWord("ライオン", "raion", "singa"), KanaWord("ライト", "raito", "lampu/cahaya"), KanaWord("ラーメン", "raamen", "mi ramen"))
        ),
        KanaCharacter(
            character = "リ",
            romaji = "ri",
            category = KanaCategory.GOJUON,
            strokeCount = 2,
            strokeSteps = listOf("Dua garis vertikal tegak lurus sejajar (kanan lebih panjang)"),
            strokes = listOf(KanjiStrokeItem(1, "M35,18.38c1.12,1.5,1.62,3,1.62,4.88c0,1.88,0,25,0,27c0,2,0,6.12,0,7.75", null), KanjiStrokeItem(2, "M71,15.38c1.5,1.25,2.38,3.12,2.38,5.38c0,2.26-0.12,28.88-0.12,32.88c0,19.62-9.5,32.25-21.75,40.38", null)),
            relatedWords = listOf(KanaWord("リモコン", "rimokon", "remote control"), KanaWord("リーダー", "riidaa", "pemimpin/leader"), KanaWord("リズム", "rizumu", "ritme/irama"), KanaWord("リンス", "rinsu", "kondisioner rambut"))
        ),
        KanaCharacter(
            character = "ル",
            romaji = "ru",
            category = KanaCategory.GOJUON,
            strokeCount = 2,
            strokeSteps = listOf("Garis miring kiri", "Garis melengkung ke kanan bawah berujung kait ke atas"),
            strokes = listOf(KanjiStrokeItem(1, "M34.38,31.88c1.12,1.5,1.72,3,1.62,4.88c-1.12,22.88-8.88,40.62-17.5,49.5", null), KanjiStrokeItem(2, "M56.51,19.62c1.5,1.25,2.38,3.12,2.38,5.38c0,2.26-0.12,47.62-0.12,51.62c0,10.5,0.52,10.21,9.38,2.75c9.5-8,16.5-14.62,26.38-25.62", null)),
            relatedWords = listOf(KanaWord("ルール", "ruuru", "peraturan/aturan"), KanaWord("ルビー", "rubii", "batu permata delima"), KanaWord("ルート", "ruuto", "rute/jalan"), KanaWord("ルックス", "rukkusu", "penampilan luar"))
        ),
        KanaCharacter(
            character = "レ",
            romaji = "re",
            category = KanaCategory.GOJUON,
            strokeCount = 1,
            strokeSteps = listOf("Garis vertikal turun lalu melengkung tajam ke kanan atas"),
            strokes = listOf(KanjiStrokeItem(1, "M34.5,19.75c1.5,1.25,2.38,3.12,2.38,5.38c0,2.26-0.12,50.12-0.12,54.12c-0.02,8.75-0.14,8.63,9.36,3.75c13.23-6.79,33.38-22.5,43.25-33.5", null)),
            relatedWords = listOf(KanaWord("レストラン", "resutoran", "restoran"), KanaWord("レシート", "reshiito", "struk belanja"), KanaWord("レモン", "remon", "lemon"), KanaWord("レベル", "reberu", "tingkat/level"))
        ),
        KanaCharacter(
            character = "ロ",
            romaji = "ro",
            category = KanaCategory.GOJUON,
            strokeCount = 3,
            strokeSteps = listOf("Membentuk persegi/kotak: vertikal kiri, mendatar berbelok ke bawah, mendatar penutup"),
            strokes = listOf(KanjiStrokeItem(1, "M25,33.25c1.5,1.25,2.16,3.14,2.38,5.38c0.96,10.07,2.14,23.67,3.14,34.88c0.31,3.4,0.59,6.58,0.86,9.38", null), KanjiStrokeItem(2, "M28.13,36.12c9.25-1,37.62-3.12,45.62-4.25c8-1.13,9.57,0.53,8.38,6.62c-2.13,10.89-4.13,21.89-6.75,34.89", null), KanjiStrokeItem(3, "M32,78.12c5.38-0.5,33.62-3,36.5-3c2.88,0,7.88-0.25,11.5,0.25", null)),
            relatedWords = listOf(KanaWord("ロボット", "robotto", "robot"), KanaWord("ロッカー", "rokkaa", "loker penyimpanan"), KanaWord("ロケット", "roketto", "roket antariksa"), KanaWord("ロシア", "roshia", "Rusia"))
        ),
        KanaCharacter(
            character = "ワ",
            romaji = "wa",
            category = KanaCategory.GOJUON,
            strokeCount = 2,
            strokeSteps = listOf("Garis vertikal pendek kiri", "Garis mendatar berbelok melengkung ke kiri bawah"),
            strokes = listOf(KanjiStrokeItem(1, "M25,23.62c1.5,1.25,2.16,3.14,2.38,5.38c0.96,10.07,0.89,8.17,1.89,19.38c0.31,3.4,0.59,6.58,0.86,9.38", null), KanjiStrokeItem(2, "M27.75,26.38c3.12,0.38,5.16,0.22,8.23-0.06c13.77-1.29,27.15-2.32,41.65-3.7c8.04-0.76,9.44,0.51,8.38,6.62c-4.76,27.26-20.64,47.64-43.88,61.51", null)),
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
            strokes = listOf(KanjiStrokeItem(1, "M30.24,25.14c2.38,1.7,5.11,2.13,9.25,1.7c12.32-1.29,21.94-2.6,30.48-3.64c2.81-0.34,5.51-0.65,8.14-0.93", null), KanjiStrokeItem(2, "M29,46.69c2.25,1.44,4.44,1.9,8.05,1.4c8.19-1.15,19.93-2.64,28.56-3.79c2.38-0.31,4.65-0.62,6.75-0.92", null), KanjiStrokeItem(3, "M78,22.88c0.88,2,0.62,4.64,0.12,7c-4.88,22.5-23.5,47.12-44.12,60.74", null)),
            relatedWords = listOf(KanaWord("kata arkaik", "wo", "partikel/kata serapan arkaik"), KanaWord("ヲタク", "wotaku", "penggemar berat anime/otaku"))
        ),
        KanaCharacter(
            character = "ン",
            romaji = "n",
            category = KanaCategory.GOJUON,
            strokeCount = 2,
            strokeSteps = listOf("Titik miring di kiri", "Garis menyapu dari kiri bawah ke kanan atas"),
            strokes = listOf(KanjiStrokeItem(1, "M26.5,24.88c5.76,2.15,12.68,8.47,15.75,14.25", null), KanjiStrokeItem(2, "M28.62,83.75c2.5,1.62,5.12,0.96,7.75-0.62c20.13-12.13,35-24.63,49.63-41.13", null)),
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
            strokes = listOf(KanjiStrokeItem(1, "M24.62,38.62c1.88,1.62,4.65,2.33,8.62,1c25.5-8.5,29.5-4.13,29.5,7.62c0,9.38-1.24,17.46-4.25,25.25c-7.62,19.76-10.87,17.39-16.12,10.89", null), KanjiStrokeItem(2, "M48.5,17.5c1,1.38,1.29,4.7,0.5,7.12c-5,15.25-18.02,40.93-19.62,43.88c-3.12,5.75-6.38,11.88-9.38,16.25", null), KanjiStrokeItem(3, "M77.37,31.62c7.5,6.88,13.25,15.75,15,24.88", null), KanjiStrokeItem(4, "M80.5,18.25c2.75,1.75,6,5.38,7.75,8.5", null), KanjiStrokeItem(5, "M86.87,13.38c3.06,1.57,6.68,4.82,8.62,7.62", null)),
            relatedWords = listOf(KanaWord("がっこう", "gakkou", "sekolah"), KanaWord("がいこく", "gaikoku", "luar negeri"))
        ),
        KanaCharacter(
            character = "ぎ",
            romaji = "gi",
            category = KanaCategory.DAKUON,
            strokeCount = 6,
            strokeSteps = listOf("き dengan dua tanda kutip di kanan atas"),
            strokes = listOf(KanjiStrokeItem(1, "M30.5,30.5c1.88,0.75,4.64,1.06,5.88,0.88c6.75-1,22.25-4.5,26.5-6c2.17-0.76,3.5-1.25,4.88-2.12", null), KanjiStrokeItem(2, "M36.25,48.95c2.01,0.85,4.97,1.2,6.29,0.99c7.23-1.13,23.82-5.09,28.37-6.79c2.32-0.86,3.75-1.41,5.22-2.4", null), KanjiStrokeItem(3, "M42,14.38c1.5,0.88,3.13,2.94,4,5.12c5.5,13.75,16,29.25,26.38,40.75c7.64,8.47,9.12,9.38-6,3.88", null), KanjiStrokeItem(4, "M33.75,83.5c10.62,9.75,27.25,8.62,38.12,5", null), KanjiStrokeItem(5, "M77.37,19c2.75,1.75,6,5.38,7.75,8.5", null), KanjiStrokeItem(6, "M83.75,14.12c3.06,1.57,6.68,4.82,8.62,7.62", null)),
            relatedWords = listOf(KanaWord("ぎんこう", "ginkou", "bank"), KanaWord("ぎゅうにく", "gyuuniku", "daging sapi"))
        ),
        KanaCharacter(
            character = "ぐ",
            romaji = "gu",
            category = KanaCategory.DAKUON,
            strokeCount = 3,
            strokeSteps = listOf("く dengan dua tanda kutip di kanan atas"),
            strokes = listOf(KanjiStrokeItem(1, "M60.66,15c0.5,2.12,0.75,5-1,7.38c-6.97,9.46-14.29,19.09-18.62,24.5c-4,5-3.79,7.03-0.88,11c5.5,7.5,12.75,18.75,17.62,27.25c1.48,2.59,2.75,4.75,4.5,8.62", null), KanjiStrokeItem(2, "M73.54,30c2.75,1.75,6,5.38,7.75,8.5", null), KanjiStrokeItem(3, "M79.91,25.12c3.06,1.57,6.68,4.82,8.62,7.62", null)),
            relatedWords = listOf(KanaWord("ぐあい", "guai", "kondisi tubuh"), KanaWord("ぐらい", "gurai", "kira-kira"))
        ),
        KanaCharacter(
            character = "げ",
            romaji = "ge",
            category = KanaCategory.DAKUON,
            strokeCount = 5,
            strokeSteps = listOf("け dengan dua tanda kutip di kanan atas"),
            strokes = listOf(KanjiStrokeItem(1, "M24.91,20.25c1.25,1.5,2.37,3.75,1.88,6.38c-3,15.88-6.5,29.5-4.88,44.62c2.02,18.84,2.25,4.75,6.75-3.5", null), KanjiStrokeItem(2, "M53.67,39.12c2.12,1.38,4.28,1.89,6.88,1.5c8.25-1.25,15.39-2.57,20.62-4c2.75-0.75,5.25-1.12,6.88-1.12", null), KanjiStrokeItem(3, "M71.67,14.62c2.12,1.38,2.87,3.61,2.87,5.38c0,11.62,0.12,20.38,0.12,30.12c0,20.75-0.62,30.88-12.5,42.25", null), KanjiStrokeItem(4, "M86.17,13c2.75,1.75,6,5.38,7.75,8.5", null), KanjiStrokeItem(5, "M92.54,8.12c3.06,1.57,6.68,4.82,8.62,7.62", null)),
            relatedWords = listOf(KanaWord("げんき", "genki", "sehat/semangat"), KanaWord("げつようび", "getsuyoubi", "hari Senin"))
        ),
        KanaCharacter(
            character = "ご",
            romaji = "go",
            category = KanaCategory.DAKUON,
            strokeCount = 4,
            strokeSteps = listOf("こ dengan dua tanda kutip di kanan atas"),
            strokes = listOf(KanjiStrokeItem(1, "M34.75,27c1.12,0.88,2.91,2.01,6,1.5c7.62-1.25,14.11-2.56,22.38-2.62c15.5-0.12,5.88,5-5.75,9", null), KanjiStrokeItem(2, "M30,68.38c2.25,14.5,15.26,17.96,31,16.75c6.5-0.5,11.88-1.25,17.62-2.88", null), KanjiStrokeItem(3, "M80.37,16.25c2.75,1.75,6,5.38,7.75,8.5", null), KanjiStrokeItem(4, "M86.75,11.38c3.06,1.57,6.68,4.82,8.62,7.62", null)),
            relatedWords = listOf(KanaWord("ごはん", "gohan", "nasi/makan"), KanaWord("ごご", "gogo", "sore/p.m."))
        ),
        KanaCharacter(
            character = "ざ",
            romaji = "za",
            category = KanaCategory.DAKUON,
            strokeCount = 5,
            strokeSteps = listOf("さ dengan dua tanda kutip di kanan atas"),
            strokes = listOf(KanjiStrokeItem(1, "M27,39.15c2.42,1.33,5.38,1.47,8.32,1.06c8.79-1.24,28.67-8.01,34.15-10.68c2.79-1.36,3.78-1.91,6.28-3.53", null), KanjiStrokeItem(2, "M41.5,14.12c1.5,0.88,3.63,2.95,4.5,5.13c5.5,13.75,15.25,27.63,26.88,39.5c7.98,8.15,6.38,10-6,3.12", null), KanjiStrokeItem(3, "M35.25,80.75c4.5,11.75,20.88,12.5,38.38,7.5", null), KanjiStrokeItem(4, "M79.88,14.25c2.75,1.75,6,5.38,7.75,8.5", null), KanjiStrokeItem(5, "M86.25,9.38c3.06,1.57,6.68,4.82,8.62,7.62", null)),
            relatedWords = listOf(KanaWord("ざっし", "zasshi", "majalah"), KanaWord("ざんねん", "zannen", "sayang sekali"))
        ),
        KanaCharacter(
            character = "じ",
            romaji = "ji",
            category = KanaCategory.DAKUON,
            strokeCount = 3,
            strokeSteps = listOf("し dengan dua tanda kutip di kanan atas"),
            strokes = listOf(KanjiStrokeItem(1, "M39.12,17.25c1.25,3.12,0.93,6.74,0.38,10.25c-2.12,13.5-3,26.5-3,39.12c0,27.38,19.88,30.12,45.5,17.25", null), KanjiStrokeItem(2, "M64.24,27c2.75,1.75,6,5.38,7.75,8.5", null), KanjiStrokeItem(3, "M70.62,22.12c3.06,1.57,6.68,4.82,8.62,7.62", null)),
            relatedWords = listOf(KanaWord("じかん", "jikan", "waktu"), KanaWord("じしょ", "jisho", "kamus"))
        ),
        KanaCharacter(
            character = "ず",
            romaji = "zu",
            category = KanaCategory.DAKUON,
            strokeCount = 4,
            strokeSteps = listOf("す dengan dua tanda kutip di kanan atas"),
            strokes = listOf(KanjiStrokeItem(1, "M15.5,37.12c2.88,2.12,6.94,1.51,12.75,0.25c16.12-3.5,36.14-5.38,46.62-6.5c7-0.75,11.88-0.62,17.75,0.12", null), KanjiStrokeItem(2, "M57.62,13.38c2,1.5,2.75,3.25,2.75,5.88c0,10.38,0,35.12,0,40.75c0,14.62-15.62,16.38-15.62,1.75c0-14.25,18-14.12,18,6.38c0,13.25-7.75,21.5-16,28.38", null), KanjiStrokeItem(3, "M77,13c2.75,1.75,6,5.38,7.75,8.5", null), KanjiStrokeItem(4, "M83.37,8.12c3.06,1.57,6.68,4.82,8.62,7.62", null)),
            relatedWords = listOf(KanaWord("みず", "mizu", "air"), KanaWord("ずっと", "zutto", "terus-menerus"))
        ),
        KanaCharacter(
            character = "ぜ",
            romaji = "ze",
            category = KanaCategory.DAKUON,
            strokeCount = 5,
            strokeSteps = listOf("せ dengan dua tanda kutip di kanan atas"),
            strokes = listOf(KanjiStrokeItem(1, "M16.5,49.93c2.88,2.42,6.86,1.57,12.75,0.53c19-3.34,32.5-5.34,47.12-7.64c6.97-1.1,11.88-1.21,17.75-0.36", null), KanjiStrokeItem(2, "M69.74,17.75c2,1.5,2.75,3.25,2.75,5.88c0,10.38,0,17.88,0,23.5c0,25.62-5.75,23.25-11.88,19", null), KanjiStrokeItem(3, "M35.62,26.25c2,1.5,2.75,3.25,2.75,5.88c0,10.38,0,28.38,0,34c0,14.5,6.38,19.55,20.14,19.55c10.24,0,13.74,0.07,22.61-1.68", null), KanjiStrokeItem(4, "M84.5,17.25c2.75,1.75,6,5.38,7.75,8.5", null), KanjiStrokeItem(5, "M90.87,12.38c3.06,1.57,6.68,4.82,8.62,7.62", null)),
            relatedWords = listOf(KanaWord("ぜんぶ", "zembu", "semua"), KanaWord("ぜろ", "zero", "nol"))
        ),
        KanaCharacter(
            character = "ぞ",
            romaji = "zo",
            category = KanaCategory.DAKUON,
            strokeCount = 3,
            strokeSteps = listOf("そ dengan dua tanda kutip di kanan atas"),
            strokes = listOf(KanjiStrokeItem(1, "M38.4,22c1.88,1.25,4.98,1.05,7.5,0.38c6.5-1.75,13.25-3.75,19.38-5.38c4.63-1.23,7.18,2.06,3.62,5.25c-12.12,10.87-31.14,24.4-40,30.25c-6.25,4.12-5.88,5.75,1.38,3.88c17.08-4.42,35.96-8.68,50.12-10.38c9.38-1.12,9.62,0.12,0.5,1.38c-15.82,2.17-34.38,14.25-34.38,26.5c0,12.88,11.62,20.38,31.5,16.62", null), KanjiStrokeItem(2, "M81.78,26.75c2.75,1.75,6,5.38,7.75,8.5", null), KanjiStrokeItem(3, "M88.15,21.88c3.06,1.57,6.68,4.82,8.62,7.62", null)),
            relatedWords = listOf(KanaWord("ぞう", "zou", "gajah"), KanaWord("ぞくぞく", "zokuzoku", "menggigil/antusias"))
        ),
        KanaCharacter(
            character = "だ",
            romaji = "da",
            category = KanaCategory.DAKUON,
            strokeCount = 6,
            strokeSteps = listOf("た dengan dua tanda kutip di kanan atas"),
            strokes = listOf(KanjiStrokeItem(1, "M24.38,35.38c1.38,0.62,3.88,1.51,6.38,1.12c6.5-1,16.25-2.88,24.88-4.75c2.64-0.57,5.38-1.5,7.62-2.38", null), KanjiStrokeItem(2, "M45,16.88c0.75,1.25,0.87,3.62,0.38,5.25c-6.35,20.94-12.75,36.37-18.88,52.37c-1.36,3.56-4.75,11.75-6,14.62", null), KanjiStrokeItem(3, "M56.38,53.25c12.38-2.75,18.25-3.7,23.62-3.12c15.12,1.62-1.12,2.25-4.25,4.88", null), KanjiStrokeItem(4, "M54.13,82.25c4.38,7,14.25,8.12,34.5,5.62", null), KanjiStrokeItem(5, "M76,22.5c2.75,1.75,6,5.38,7.75,8.5", null), KanjiStrokeItem(6, "M82.38,17.62c3.06,1.57,6.68,4.82,8.62,7.62", null)),
            relatedWords = listOf(KanaWord("だいがく", "daigaku", "universitas"), KanaWord("だれ", "dare", "siapa"))
        ),
        KanaCharacter(
            character = "ぢ",
            romaji = "ji",
            category = KanaCategory.DAKUON,
            strokeCount = 4,
            strokeSteps = listOf("ち dengan dua tanda kutip di kanan atas"),
            strokes = listOf(KanjiStrokeItem(1, "M24.5,32.88c1.38,0.62,3.88,1.51,6.38,1.12c6.5-1,18.25-4.12,26.88-6c2.64-0.57,5.38-1.5,7.62-2.38", null), KanjiStrokeItem(2, "M45.63,15.88c0.75,1.25,0.71,3.58,0.38,5.25c-3,15-4.25,22.59-8.38,38.62c-3.26,12.63-5.38,11.13,3.62,4.37c8.29-6.21,19.75-9.5,28.5-9.5c8.62,0,14.58,5.88,14.5,14.5c-0.12,13.5-16.5,20.62-29.88,23.25", null), KanjiStrokeItem(3, "M74.63,21.75c2.75,1.75,6,5.38,7.75,8.5", null), KanjiStrokeItem(4, "M81,16.88c3.06,1.57,6.68,4.82,8.62,7.62", null)),
            relatedWords = listOf(KanaWord("はなぢ", "hanaji", "mimisan"), KanaWord("ちぢむ", "chidimu", "menyusut"))
        ),
        KanaCharacter(
            character = "づ",
            romaji = "zu",
            category = KanaCategory.DAKUON,
            strokeCount = 3,
            strokeSteps = listOf("つ dengan dua tanda kutip di kanan atas"),
            strokes = listOf(KanjiStrokeItem(1, "M14,44.75c1.88,1.62,4.68,2.09,8.12,0.62c17.88-7.62,30-11.12,44.88-10.88c12.56,0.21,22.98,7.17,22.87,19.17c-0.18,18.77-24.75,28.71-45.01,32.08", null), KanjiStrokeItem(2, "M81,18c2.75,1.75,6,5.38,7.75,8.5", null), KanjiStrokeItem(3, "M87.38,13.12c3.06,1.57,6.68,4.82,8.62,7.62", null)),
            relatedWords = listOf(KanaWord("つづく", "tsuzuku", "berlanjut"), KanaWord("つづき", "tsuzuki", "kelanjutan"))
        ),
        KanaCharacter(
            character = "で",
            romaji = "de",
            category = KanaCategory.DAKUON,
            strokeCount = 3,
            strokeSteps = listOf("て dengan dua tanda kutip di kanan atas"),
            strokes = listOf(KanjiStrokeItem(1, "M20.5,26.38c1.87,1.62,4.42,1.97,8.12,1.37c21.75-3.5,33-5.12,50.12-8.38c12.34-2.34,13-0.88,0.38,1.38c-17.89,3.19-33.78,19.12-33.78,37.62c0,20.5,17.91,30.25,35.16,30.25", null), KanjiStrokeItem(2, "M75,41.75c2.75,1.75,6,5.38,7.75,8.5", null), KanjiStrokeItem(3, "M81.37,36.88c3.06,1.57,6.68,4.82,8.62,7.62", null)),
            relatedWords = listOf(KanaWord("でんしゃ", "densha", "kereta"), KanaWord("でんわ", "denwa", "telepon"))
        ),
        KanaCharacter(
            character = "ど",
            romaji = "do",
            category = KanaCategory.DAKUON,
            strokeCount = 4,
            strokeSteps = listOf("と dengan dua tanda kutip di kanan atas"),
            strokes = listOf(KanjiStrokeItem(1, "M35.5,18.38c1.74,0.74,3.62,2.62,4.12,5.37c0.5,2.75,4.75,25,5.38,28.12", null), KanjiStrokeItem(2, "M78.12,25.5c0.25,1.88,0.04,4.09-2.25,5.75c-6.37,4.63-13.21,8.49-22.75,15.25c-12.88,9.12-21.62,18.38-21.62,27.5c0,10.12,8.5,13.88,26.88,13.88c6.25,0,14.75-0.12,21.62-1.25", null), KanjiStrokeItem(3, "M84.24,14.5c2.75,1.75,6,5.38,7.75,8.5", null), KanjiStrokeItem(4, "M90.62,9.62c3.06,1.57,6.68,4.82,8.62,7.62", null)),
            relatedWords = listOf(KanaWord("どこ", "doko", "di mana"), KanaWord("どうして", "doushite", "kenapa/mengapa"))
        ),
        KanaCharacter(
            character = "ば",
            romaji = "ba",
            category = KanaCategory.DAKUON,
            strokeCount = 5,
            strokeSteps = listOf("は dengan dua tanda kutip di kanan atas"),
            strokes = listOf(KanjiStrokeItem(1, "M24.75,17.75c1.25,1.5,1.9,4.25,1.38,6.88c-3.5,17.62-6.98,36.4-4,54.88c2.5,15.5,1.12,2,5.62-6.25", null), KanjiStrokeItem(2, "M49.88,37.89c2.41,1.57,4.85,2.41,7.8,1.96c9.36-1.43,17.21-3.19,23.15-4.82c3.12-0.86,5.96-1.29,7.8-1.29", null), KanjiStrokeItem(3, "M69.75,16.5c2.26,2.12,2.88,4.12,2.88,6.5c0,2.38,1.5,38.62,1.5,48c0,22.5-30.62,19.62-30.62,10.5c0-9.75,23.88-5.62,29.5-2.88c5.62,2.74,12,8.25,13.38,9.38", null), KanjiStrokeItem(4, "M84.75,15.25c2.75,1.75,6,5.38,7.75,8.5", null), KanjiStrokeItem(5, "M91.13,10.38c3.06,1.57,6.68,4.82,8.62,7.62", null)),
            relatedWords = listOf(KanaWord("ばんごう", "bangou", "nomor"), KanaWord("ばんごはん", "bangohan", "makan malam"))
        ),
        KanaCharacter(
            character = "び",
            romaji = "bi",
            category = KanaCategory.DAKUON,
            strokeCount = 3,
            strokeSteps = listOf("ひ dengan dua tanda kutip di kanan atas"),
            strokes = listOf(KanjiStrokeItem(1, "M20,25.12c1.25,0.88,3.75,2.25,6.5,1.38c2.75-0.87,7.31-2.38,11.38-4.5c6-3.12,8.42-1.01,4.25,4c-27.13,32.62-23.76,58.5-1.52,62.88c18.07,3.56,37.63-16.38,35.63-56.51c-0.72-14.5-0.17-14.78,4.12-1.75c3.76,11.38,10.26,20.76,16.14,26.5", null), KanjiStrokeItem(2, "M86.5,13.5c2.75,1.75,6,5.38,7.75,8.5", null), KanjiStrokeItem(3, "M92.87,8.62c3.06,1.57,6.68,4.82,8.62,7.62", null)),
            relatedWords = listOf(KanaWord("びょういん", "byouin", "rumah sakit"), KanaWord("びじゅつかん", "bijutsukan", "museum seni"))
        ),
        KanaCharacter(
            character = "ぶ",
            romaji = "bu",
            category = KanaCategory.DAKUON,
            strokeCount = 6,
            strokeSteps = listOf("ふ dengan dua tanda kutip di kanan atas"),
            strokes = listOf(KanjiStrokeItem(1, "M42.12,15.62c3.62,3.38,7.5,5.38,12.75,6.12c9.59,1.37,3.5,3.38-1.88,6.12", null), KanjiStrokeItem(2, "M43.12,46.88c1.88,4.62,7.5,9.41,14.25,17.5c10.62,12.75,0.5,30-19.12,21.62", null), KanjiStrokeItem(3, "M16.5,73.88c0.75,4,1.88,8.12,5,10.12c1.16,0.74,0.12-3.38,13.25-9.12", null), KanjiStrokeItem(4, "M79.62,61.88c5.5,3.38,10.28,7.49,11.38,8.88c6.75,8.5-0.25,4.62-4.62,7.12", null), KanjiStrokeItem(5, "M73.62,16.25c2.75,1.75,6,5.38,7.75,8.5", null), KanjiStrokeItem(6, "M80,11.38c3.06,1.57,6.68,4.82,8.62,7.62", null)),
            relatedWords = listOf(KanaWord("ぶんか", "bunka", "budaya"), KanaWord("ぶた", "buta", "babi"))
        ),
        KanaCharacter(
            character = "べ",
            romaji = "be",
            category = KanaCategory.DAKUON,
            strokeCount = 3,
            strokeSteps = listOf("へ dengan dua tanda kutip di kanan atas"),
            strokes = listOf(KanjiStrokeItem(1, "M15,48.75c2.25,1.62,5,1.38,7.62-1c3.89-3.52,6.12-5.75,10.62-9.88c5.88-5.37,8.49-4.75,13.14-0.87c12.12,10.12,30.38,25.12,33.38,27.38c3,2.26,12.37,10.37,13.87,11.62", null), KanjiStrokeItem(2, "M66.76,26.75c2.75,1.75,6,5.38,7.75,8.5", null), KanjiStrokeItem(3, "M73.13,21.88c3.06,1.57,6.68,4.82,8.62,7.62", null)),
            relatedWords = listOf(KanaWord("べんきょう", "benkyou", "belajar"), KanaWord("べんり", "benri", "praktis"))
        ),
        KanaCharacter(
            character = "ぼ",
            romaji = "bo",
            category = KanaCategory.DAKUON,
            strokeCount = 6,
            strokeSteps = listOf("ほ dengan dua tanda kutip di kanan atas"),
            strokes = listOf(KanjiStrokeItem(1, "M24.51,18.75c1.25,1.5,2.15,4,1.62,6.62c-3.5,17.63-6.98,37.4-4,55.88c2.5,15.5,1.12,2,5.62-6.25", null), KanjiStrokeItem(2, "M53.08,21.13c1.9,1.28,3.82,1.76,6.14,1.4c7.36-1.17,13.73-2.4,18.41-3.73c2.46-0.7,4.69-1.05,6.13-1.05", null), KanjiStrokeItem(3, "M53.83,44.3c2.21,1.44,4.46,1.98,7.16,1.57c8.59-1.31,15.78-2.44,21.23-3.94c2.87-0.79,5.72-1.18,7.41-1.18", null), KanjiStrokeItem(4, "M72.51,23c1.38,1.62,1.62,4.12,1.62,6.5c0,2.38,2,35.12,2,44.5c0,17.5-29.88,17.12-29.88,8c0-9.75,21.38-7.88,29.5-2.88c5.33,3.28,12,8.25,13.38,9.38", null), KanjiStrokeItem(5, "M87.51,26c2.75,1.75,6,5.38,7.75,8.5", null), KanjiStrokeItem(6, "M93.88,21.12c3.06,1.57,6.68,4.82,8.62,7.62", null)),
            relatedWords = listOf(KanaWord("ぼうし", "boushi", "topi"), KanaWord("ぼく", "boku", "aku (laki-laki)"))
        ),
        KanaCharacter(
            character = "ぱ",
            romaji = "pa",
            category = KanaCategory.DAKUON,
            strokeCount = 4,
            strokeSteps = listOf("は dengan lingkaran kecil (maru) di kanan atas"),
            strokes = listOf(KanjiStrokeItem(1, "M24.51,18c1.25,1.5,2.15,4,1.62,6.62c-3.5,17.62-6.98,36.4-4,54.88c2.5,15.5,1.12,2,5.62-6.25", null), KanjiStrokeItem(2, "M49.64,37.89c2.41,1.57,4.85,2.16,7.8,1.71c9.36-1.43,17.46-2.94,23.4-4.57c3.12-0.86,5.96-1.29,7.8-1.29", null), KanjiStrokeItem(3, "M69.77,16.5c2.25,2.12,2.88,4.12,2.88,6.5c0,2.38,1.5,38.62,1.5,48c0,22.5-30.62,19.62-30.62,10.5c0-9.75,23.88-5.62,29.5-2.88c5.62,2.74,11.98,8.26,13.36,9.38", null), KanjiStrokeItem(4, "M91.01,24.38c-9.62,0-9.25-14.25,0-14.25c9.76-0.01,9.5,14.25,0,14.25", null)),
            relatedWords = listOf(KanaWord("パン", "pan", "roti"), KanaWord("ぱらぱら", "parapara", "gerimis/berhamburan"))
        ),
        KanaCharacter(
            character = "ぴ",
            romaji = "pi",
            category = KanaCategory.DAKUON,
            strokeCount = 2,
            strokeSteps = listOf("ひ dengan lingkaran kecil di kanan atas"),
            strokes = listOf(KanjiStrokeItem(1, "M20,25.12c1.25,0.88,3.75,2.25,6.5,1.38c2.75-0.87,7.31-2.38,11.38-4.5c6-3.12,8.42-1.01,4.25,4c-27.13,32.62-23.76,58.5-1.52,62.88c18.07,3.56,37.63-16.38,35.63-56.51c-0.72-14.5-0.17-14.78,4.12-1.75c3.76,11.38,10.26,20.76,16.14,26.5", null), KanjiStrokeItem(2, "M93.87,22.12c-9.62,0-9.25-14.25,0-14.25c9.75,0.01,9.5,14.25,0,14.25", null)),
            relatedWords = listOf(KanaWord("ぴかぴか", "pikapika", "berkilau"), KanaWord("ピアノ", "piano", "piano"))
        ),
        KanaCharacter(
            character = "ぷ",
            romaji = "pu",
            category = KanaCategory.DAKUON,
            strokeCount = 5,
            strokeSteps = listOf("ふ dengan lingkaran kecil di kanan atas"),
            strokes = listOf(KanjiStrokeItem(1, "M42.13,15.62c3.62,3.38,7.5,5.38,12.74,6.13c9.59,1.37,3.5,3.38-1.88,6.12", null), KanjiStrokeItem(2, "M43.13,46.88c1.88,4.62,7.5,9.41,14.25,17.5c10.62,12.74,0.49,30-19.13,21.62", null), KanjiStrokeItem(3, "M16.5,73.88c0.75,4,1.88,8.12,5,10.12c1.16,0.74,0.12-3.38,13.25-9.12", null), KanjiStrokeItem(4, "M79.63,61.88c5.5,3.38,10.28,7.49,11.38,8.88c6.75,8.5-0.25,4.62-4.62,7.12", null), KanjiStrokeItem(5, "M80.87,26.62c-9.62,0-9.25-14.25,0-14.25c9.76,0.01,9.5,14.25,0,14.25", null)),
            relatedWords = listOf(KanaWord("てんぷら", "tempura", "tempura gorengan"), KanaWord("プール", "puuru", "kolam renang"))
        ),
        KanaCharacter(
            character = "ぺ",
            romaji = "pe",
            category = KanaCategory.DAKUON,
            strokeCount = 2,
            strokeSteps = listOf("へ dengan lingkaran kecil di kanan atas"),
            strokes = listOf(KanjiStrokeItem(1, "M15,48.75c2.25,1.62,4.67,1.96,7-0.38c3.62-3.62,7.46-6.54,11.25-10.5c5.5-5.75,8.48-4.75,13.12-0.88c12.12,10.12,30.38,25.12,33.38,27.38c3,2.26,12.38,10.38,13.88,11.63", null), KanjiStrokeItem(2, "M73.63,36.75c-9.62,0-9.25-14.25,0-14.25c9.75,0,9.5,14.25,0,14.25", null)),
            relatedWords = listOf(KanaWord("ぺこぺこ", "pekopeko", "lapar keroncongan"), KanaWord("ペン", "pen", "pena/pulpen"))
        ),
        KanaCharacter(
            character = "ぽ",
            romaji = "po",
            category = KanaCategory.DAKUON,
            strokeCount = 5,
            strokeSteps = listOf("ほ dengan lingkaran kecil di kanan atas"),
            strokes = listOf(KanjiStrokeItem(1, "M24.51,19c1.25,1.5,2.15,4,1.62,6.62c-3.5,17.62-6.98,37.4-4,55.88c2.5,15.5,1.12,2,5.62-6.25", null), KanjiStrokeItem(2, "M53.08,21.38c1.9,1.28,3.82,1.76,6.14,1.4c7.36-1.17,13.73-2.4,18.41-3.73c2.46-0.7,4.69-1.05,6.13-1.05", null), KanjiStrokeItem(3, "M53.83,44.55c2.21,1.44,4.46,1.98,7.16,1.57c8.59-1.31,15.78-2.44,21.23-3.94c2.87-0.79,5.72-1.18,7.41-1.18", null), KanjiStrokeItem(4, "M72.51,23.25c1.38,1.62,1.62,4.12,1.62,6.5c0,2.38,2,35.12,2,44.5c0,17.5-29.88,17.12-29.88,8c0-9.75,21.38-7.88,29.5-2.88c5.33,3.28,12,8.25,13.38,9.38", null), KanjiStrokeItem(5, "M95.13,34.5c-9.62,0-9.25-14.25,0-14.25c9.75,0,9.5,14.25,0,14.25", null)),
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
            strokes = listOf(KanjiStrokeItem(1, "M25.5,40.62c1.88,1.25,4.51,1.87,7.12,1.5c17.88-2.5,32.78-4.51,42.5-5.88c7.12-1,10.59,0.24,8.62,7.88c-2.12,8.25-4.47,17.81-9.25,29.12c-10.49,24.88-14.11,14.51-19.24,11.88", null), KanjiStrokeItem(2, "M55.88,17.12c0.88,1.62,1.29,3.83,0.75,6.75c-4.25,22.88-15.88,45.25-30.25,58.88", null), KanjiStrokeItem(3, "M83,19.75c2.75,1.75,6,5.38,7.75,8.5", null), KanjiStrokeItem(4, "M89.38,14.88c3.06,1.57,6.68,4.82,8.62,7.62", null)),
            relatedWords = listOf(KanaWord("ガス", "gasu", "gas"), KanaWord("ガラス", "garasu", "kaca"))
        ),
        KanaCharacter(
            character = "ギ",
            romaji = "gi",
            category = KanaCategory.DAKUON,
            strokeCount = 5,
            strokeSteps = listOf("キ dengan dua tanda kutip di kanan atas"),
            strokes = listOf(KanjiStrokeItem(1, "M27,40.5c1.75,0.62,4.77,1.09,7.25,0.38c11.75-3.38,30.62-8.13,37.5-9.88c2.62-0.67,6.75-1.12,9-1", null), KanjiStrokeItem(2, "M19.5,65.8c2.28,0.84,6.24,1.18,9.46,0.17c17.79-5.59,32.67-9.09,49.17-12.99c3.43-0.81,8.81-1.52,11.74-1.35", null), KanjiStrokeItem(3, "M48.87,16.75c2.5,1.75,3.43,3.24,3.88,6.12c2.12,13.62,6.38,45.38,8.25,59.25c0.4,3,1,8.38,1.38,11.12", null), KanjiStrokeItem(4, "M81.87,15.13c2.75,1.93,6,5.93,7.75,9.37", null), KanjiStrokeItem(5, "M88.25,10c2.71,1.73,5.9,5.32,7.62,8.41", null)),
            relatedWords = listOf(KanaWord("ギター", "gitaa", "gitar"), KanaWord("ギャング", "gyangu", "geng"))
        ),
        KanaCharacter(
            character = "グ",
            romaji = "gu",
            category = KanaCategory.DAKUON,
            strokeCount = 4,
            strokeSteps = listOf("ク dengan dua tanda kutip di kanan atas"),
            strokes = listOf(KanjiStrokeItem(1, "M50,19.62c0.38,1.5,0.34,3.48-0.5,5.12c-4.12,8.12-7.88,15.5-16.12,24.12", null), KanjiStrokeItem(2, "M51.25,28.62c2.62,0.25,5.67-0.39,7.62-0.88c6-1.5,9.75-2.38,15.12-3.88c5.79-1.62,7.53-0.42,5.12,4.88c-10.36,22.88-26.24,44.14-48.61,60.51", null), KanjiStrokeItem(3, "M83.75,13.5c2.75,1.75,6,5.38,7.75,8.5", null), KanjiStrokeItem(4, "M90.13,8.62c3.06,1.57,6.68,4.82,8.62,7.62", null)),
            relatedWords = listOf(KanaWord("グラス", "gurasu", "gelas kaca"), KanaWord("グループ", "guruupu", "kelompok/grup"))
        ),
        KanaCharacter(
            character = "ゲ",
            romaji = "ge",
            category = KanaCategory.DAKUON,
            strokeCount = 5,
            strokeSteps = listOf("ケ dengan dua tanda kutip di kanan atas"),
            strokes = listOf(KanjiStrokeItem(1, "M40.96,17.88c0.44,1.9,0.39,4.42-0.59,6.5c-4.82,10.31-9.21,19.67-18.87,30.62", null), KanjiStrokeItem(2, "M37.88,37.62c2.12,0.88,4.15,1.04,6.62,0.5c12.62-2.75,25.5-4.88,35.75-6.5c3.61-0.57,6.25-0.75,9.25-0.5", null), KanjiStrokeItem(3, "M64.46,38.88c0.44,1.9,0.5,4.27-0.08,6.5c-3.63,13.75-9.25,31.25-24.63,43.87", null), KanjiStrokeItem(4, "M83.62,13.94c2.95,1.81,6.43,5.57,8.3,8.81", null), KanjiStrokeItem(5, "M90.12,9.12c3.02,1.63,6.58,5,8.5,7.9", null)),
            relatedWords = listOf(KanaWord("ゲーム", "geemu", "permainan/game"), KanaWord("ゲスト", "gesuto", "tamu"))
        ),
        KanaCharacter(
            character = "ゴ",
            romaji = "go",
            category = KanaCategory.DAKUON,
            strokeCount = 4,
            strokeSteps = listOf("コ dengan dua tanda kutip di kanan atas"),
            strokes = listOf(KanjiStrokeItem(1, "M30.13,35c1.75,1,3.01,2.18,6.5,1.62c14.25-2.25,29.62-4.25,37.38-5.5c9.37-1.51,9.88,0.25,8,7.5c-2.77,10.71-5.25,22.12-7,34.88", null), KanjiStrokeItem(2, "M27.5,77.38c2.62,1.12,4.38,1.51,8.25,1c11.38-1.5,22.62-3,33.75-3.38c4-0.13,5.88,0,9.62,0.5", null), KanjiStrokeItem(3, "M84.75,15.5c2.75,1.75,6,5.38,7.75,8.5", null), KanjiStrokeItem(4, "M90.87,10.38c3.06,1.57,6.68,4.82,8.62,7.62", null)),
            relatedWords = listOf(KanaWord("ゴルフ", "gorufu", "golf"), KanaWord("ゴール", "gooru", "tujuan/gawang"))
        ),
        KanaCharacter(
            character = "ザ",
            romaji = "za",
            category = KanaCategory.DAKUON,
            strokeCount = 5,
            strokeSteps = listOf("サ dengan dua tanda kutip di kanan atas"),
            strokes = listOf(KanjiStrokeItem(1, "M16.5,44.34c2.84,1.27,4.77,1.91,8.93,1.13c17.2-3.22,40.45-5.35,58.53-5.34c4.33,0,6.92,0.37,10.42,0.82", null), KanjiStrokeItem(2, "M36.63,23.38c1.12,1.38,1.19,2.5,1.25,4.75c0.25,9,0.38,20.25,0.75,28.88c0.14,3.25,0.38,7.12,0.38,9.25", null), KanjiStrokeItem(3, "M69.63,16.62c1.5,2,1.62,2.87,1.62,6.25c0,8.25-0.16,9-0.16,15.88c0,23.25-9.34,42.5-23.21,53", null), KanjiStrokeItem(4, "M82.75,18.73c2.85,1.78,6.21,5.47,8.03,8.65", null), KanjiStrokeItem(5, "M89.5,14.12c2.93,1.57,6.39,4.83,8.25,7.63", null)),
            relatedWords = listOf(KanaWord("デザート", "dezaato", "hidangan penutup"), KanaWord("サイズ", "saizu", "ukuran/size"))
        ),
        KanaCharacter(
            character = "ジ",
            romaji = "ji",
            category = KanaCategory.DAKUON,
            strokeCount = 5,
            strokeSteps = listOf("シ dengan dua tanda kutip di kanan atas"),
            strokes = listOf(KanjiStrokeItem(1, "M39.87,19.75c5.14,1.57,9.79,6.01,11.5,8.62", null), KanjiStrokeItem(2, "M26,42.62c3.25,0.88,10.25,5.5,12.25,8.13", null), KanjiStrokeItem(3, "M33,85c3.62,1.62,6.5,0.88,10.38-1.38c17.81-10.34,32.37-23.87,46.12-42.87", null), KanjiStrokeItem(4, "M78.5,18.98c2.85,1.78,6.21,5.47,8.03,8.65", null), KanjiStrokeItem(5, "M85.25,14.38c2.93,1.57,6.39,4.83,8.25,7.63", null)),
            relatedWords = listOf(KanaWord("ジュース", "juusu", "jus buah"), KanaWord("ジーンズ", "jiinzu", "celana jeans"))
        ),
        KanaCharacter(
            character = "ズ",
            romaji = "zu",
            category = KanaCategory.DAKUON,
            strokeCount = 4,
            strokeSteps = listOf("ス dengan dua tanda kutip di kanan atas"),
            strokes = listOf(KanjiStrokeItem(1, "M30.13,29.38c1.75,1.5,4.15,1.98,6.62,1.38c13.25-3.25,24.25-5.62,31.25-7.38c7-1.76,8.64,1.16,6.5,5.75c-11.24,24.12-28.37,45.87-53.5,57.25", null), KanjiStrokeItem(2, "M61,57.25c11,7.38,21,17,28,28.62", null), KanjiStrokeItem(3, "M85.38,16.5c2.75,1.75,6,5.38,7.75,8.5", null), KanjiStrokeItem(4, "M91.76,11.62c3.06,1.57,6.68,4.82,8.62,7.62", null)),
            relatedWords = listOf(KanaWord("ズボン", "zubon", "celana panjang"), KanaWord("チーズ", "chiizu", "keju"))
        ),
        KanaCharacter(
            character = "ゼ",
            romaji = "ze",
            category = KanaCategory.DAKUON,
            strokeCount = 4,
            strokeSteps = listOf("セ dengan dua tanda kutip di kanan atas"),
            strokes = listOf(KanjiStrokeItem(1, "M17,49.38c3.12,1.5,5.04,2.18,8.62,1.38c23.5-5.25,31.24-7.43,50.62-11.62c23.12-5,6.5,7.75-3.25,18.12", null), KanjiStrokeItem(2, "M42.38,19.5c2,2.25,2.15,3.5,2.12,6.62c-0.12,17.5-0.88,31.75-0.88,41.12c0,14,3.13,16.99,12.38,17.12c8.38,0.12,14.12,0.12,18,0.12c3.88,0,7.5-0.5,10.5-1.12", null), KanjiStrokeItem(3, "M83.38,20.25c2.75,1.75,6,5.38,7.75,8.5", null), KanjiStrokeItem(4, "M89.76,15.38c3.06,1.57,6.68,4.82,8.62,7.62", null)),
            relatedWords = listOf(KanaWord("ゼロ", "zero", "angka nol"), KanaWord("ゼリー", "zerii", "jeli"))
        ),
        KanaCharacter(
            character = "ゾ",
            romaji = "zo",
            category = KanaCategory.DAKUON,
            strokeCount = 4,
            strokeSteps = listOf("ソ dengan dua tanda kutip di kanan atas"),
            strokes = listOf(KanjiStrokeItem(1, "M23.5,26.65c3.83,4.02,7.54,9.72,10.5,17.5", null), KanjiStrokeItem(2, "M83,21.9c1.25,2.5,1.3,4.44,0.12,8.5c-5.87,20.37-26.24,49-45.62,60.75", null), KanjiStrokeItem(3, "M86.25,10.65c2.75,1.75,6,5.38,7.75,8.5", null), KanjiStrokeItem(4, "M92.62,5.77c3.06,1.57,6.68,4.82,8.62,7.62", null)),
            relatedWords = listOf(KanaWord("ゾーン", "zoon", "wilayah/zona"), KanaWord("ゾンビ", "zombi", "zombie"))
        ),
        KanaCharacter(
            character = "ダ",
            romaji = "da",
            category = KanaCategory.DAKUON,
            strokeCount = 5,
            strokeSteps = listOf("タ dengan dua tanda kutip di kanan atas"),
            strokes = listOf(KanjiStrokeItem(1, "M48.83,19.75c0.43,1.72,0.39,4-0.58,5.89c-4.77,9.34-9.1,17.82-18.63,27.73", null), KanjiStrokeItem(2, "M49.75,30.38c2.5,0.62,5.67-0.14,7.62-0.62c6-1.5,10.5-2.62,15.88-4.12c5.79-1.62,8.22,0.31,5.88,5.62c-10.88,24.62-22.13,43.99-50.13,59.99", null), KanjiStrokeItem(3, "M43.38,45.62c6.75,3.5,10.62,7.88,14.75,15.25", null), KanjiStrokeItem(4, "M83.62,14.19c2.95,1.81,6.43,5.57,8.3,8.81", null), KanjiStrokeItem(5, "M90.12,9.38c3.02,1.63,6.58,5,8.5,7.9", null)),
            relatedWords = listOf(KanaWord("ダンス", "dansu", "menari/tarian"), KanaWord("ダイヤ", "daiya", "berlian"))
        ),
        KanaCharacter(
            character = "ヂ",
            romaji = "ji",
            category = KanaCategory.DAKUON,
            strokeCount = 5,
            strokeSteps = listOf("チ dengan dua tanda kutip di kanan atas"),
            strokes = listOf(KanjiStrokeItem(1, "M70,15.25c-0.38,2.62-2.26,4.37-4.12,5.38c-7.88,4.25-18.62,9.75-35.5,13.25", null), KanjiStrokeItem(2, "M18.5,51.5c2.88,0.88,4.39,1.65,7.88,1.25c22-2.5,36.38-4.25,56.12-4.88c4.88-0.15,7.88,0.51,10.88,1.51", null), KanjiStrokeItem(3, "M54.88,30.75c0.88,0.75,1.75,2.49,1.75,4.75c0,6.03,0.03,11.25,0.03,18.27c0,14.98-5.03,29.48-16.53,39.23", null), KanjiStrokeItem(4, "M79.88,25.73c2.85,1.78,6.21,5.47,8.03,8.65", null), KanjiStrokeItem(5, "M86.63,21.12c2.93,1.57,6.39,4.83,8.25,7.63", null)),
            relatedWords = listOf(KanaWord("ヂ", "ji", "ji (varian dakuon)"))
        ),
        KanaCharacter(
            character = "ヅ",
            romaji = "zu",
            category = KanaCategory.DAKUON,
            strokeCount = 5,
            strokeSteps = listOf("ツ dengan dua tanda kutip di kanan atas"),
            strokes = listOf(KanjiStrokeItem(1, "M21.5,30.62c2.38,3,5,9.38,5.38,13.88", null), KanjiStrokeItem(2, "M45.87,23c3.38,3.5,6.62,9.5,7,14.88", null), KanjiStrokeItem(3, "M84.62,27.62c0.75,2.25,0.39,5.26-0.75,8c-7.63,18.38-21.25,41.38-46,52.76", null), KanjiStrokeItem(4, "M86.5,14.58c2.61,1.91,5.7,5.88,7.36,9.3", null), KanjiStrokeItem(5, "M92.68,9.62c2.73,1.8,5.95,5.53,7.69,8.75", null)),
            relatedWords = listOf(KanaWord("ヅ", "zu", "zu (varian dakuon)"))
        ),
        KanaCharacter(
            character = "デ",
            romaji = "de",
            category = KanaCategory.DAKUON,
            strokeCount = 5,
            strokeSteps = listOf("テ dengan dua tanda kutip di kanan atas"),
            strokes = listOf(KanjiStrokeItem(1, "M36.5,21.5c2.12,1.25,4.38,1.59,7.25,1.25c10.62-1.25,16.88-2.25,24.62-3.25c3.73-0.48,5.63-0.5,8.13-0.25", null), KanjiStrokeItem(2, "M20,44.12c2.88,1,5.26,1.05,7.5,0.75c22.38-3,37-5.62,54.13-6.12c5.62-0.16,7.75,0,10.38,0.62", null), KanjiStrokeItem(3, "M58,43.25c0.88,1,1.32,2.63,1.12,4.38c-1.74,15.37-11.62,34.99-24.62,41.87", null), KanjiStrokeItem(4, "M84.25,16.98c2.85,1.78,6.21,5.47,8.03,8.65", null), KanjiStrokeItem(5, "M91,12.38c2.93,1.57,6.39,4.83,8.25,7.63", null)),
            relatedWords = listOf(KanaWord("デパート", "depaato", "pusat perbelanjaan"), KanaWord("デザイン", "dezain", "desain"))
        ),
        KanaCharacter(
            character = "ド",
            romaji = "do",
            category = KanaCategory.DAKUON,
            strokeCount = 4,
            strokeSteps = listOf("ト dengan dua tanda kutip di kanan atas"),
            strokes = listOf(KanjiStrokeItem(1, "M44,16.38c1.25,1.12,2.12,3.25,2.12,5.5c0,26.12,0,53.5,0,57.62c0,4.12,0,10.5,0,13.38", null), KanjiStrokeItem(2, "M49.24,43.12c11.75,4.12,18.25,10.62,24.5,18.75", null), KanjiStrokeItem(3, "M66.87,26.75c2.75,1.75,6,5.38,7.75,8.5", null), KanjiStrokeItem(4, "M73.24,21.88c3.06,1.57,6.68,4.82,8.62,7.62", null)),
            relatedWords = listOf(KanaWord("ドア", "doa", "pintu"), KanaWord("ドラマ", "dorama", "drama"))
        ),
        KanaCharacter(
            character = "バ",
            romaji = "ba",
            category = KanaCategory.DAKUON,
            strokeCount = 4,
            strokeSteps = listOf("ハ dengan dua tanda kutip di kanan atas"),
            strokes = listOf(KanjiStrokeItem(1, "M39.08,36.62c0.38,1.14,0.38,2.84-0.12,4.14c-5.46,13.99-13.08,24.12-21.96,32.49", null), KanjiStrokeItem(2, "M65.5,36.38c13,9.12,23.12,22.62,28,33.38", null), KanjiStrokeItem(3, "M81.13,21c2.75,1.75,6,5.38,7.75,8.5", null), KanjiStrokeItem(4, "M87.5,16.12c3.06,1.57,6.68,4.82,8.62,7.62", null)),
            relatedWords = listOf(KanaWord("バス", "basu", "bus"), KanaWord("バター", "bataa", "mentega"))
        ),
        KanaCharacter(
            character = "ビ",
            romaji = "bi",
            category = KanaCategory.DAKUON,
            strokeCount = 4,
            strokeSteps = listOf("ヒ dengan dua tanda kutip di kanan atas"),
            strokes = listOf(KanjiStrokeItem(1, "M35.38,44.5c1.75,1.38,4.51,2.19,6.88,1.88c10.24-1.38,17.24-2.88,24.24-4.26c3.01-0.59,7.12-1,9.38-0.88", null), KanjiStrokeItem(2, "M31,17.62c1.38,1.26,1.88,3.38,1.88,6.13c0,2.75-0.88,44-0.88,47.25c0,9.75,4,14.62,13.75,14.62c6,0,16.38,0.12,21.38,0c5-0.12,9.5-0.62,13.5-1.5", null), KanjiStrokeItem(3, "M78.13,26.25c2.75,1.75,6,5.38,7.75,8.5", null), KanjiStrokeItem(4, "M84.5,21.38c3.06,1.57,6.68,4.82,8.62,7.62", null)),
            relatedWords = listOf(KanaWord("ビル", "biru", "gedung bertingkat"), KanaWord("ビール", "biiru", "bir"))
        ),
        KanaCharacter(
            character = "ブ",
            romaji = "bu",
            category = KanaCategory.DAKUON,
            strokeCount = 3,
            strokeSteps = listOf("フ dengan dua tanda kutip di kanan atas"),
            strokes = listOf(KanjiStrokeItem(1, "M24.5,30c1.88,1.88,3.5,2.04,6.5,1.62c14.5-2,29-4.38,43.75-6.88c6.82-1.16,10.58,2.29,6.88,9.12c-10.38,19.14-21.25,39.52-50.01,53.64", null), KanjiStrokeItem(2, "M86,15.63c2.61,1.93,5.7,5.93,7.36,9.37", null), KanjiStrokeItem(3, "M92.06,10.5c2.82,1.78,6.15,5.48,7.94,8.66", null)),
            relatedWords = listOf(KanaWord("ブーツ", "buutsu", "sepatu bot"), KanaWord("ブラシ", "burashi", "sikat"))
        ),
        KanaCharacter(
            character = "ベ",
            romaji = "be",
            category = KanaCategory.DAKUON,
            strokeCount = 3,
            strokeSteps = listOf("ヘ dengan dua tanda kutip di kanan atas"),
            strokes = listOf(KanjiStrokeItem(1, "M15.5,49c2.75,1.5,5.33,0.62,6.88-0.88c4-3.88,9.38-8.5,11.88-11c3.12-3.12,7.23-5.08,11.87-1.12c11.13,9.5,26.25,22.5,36.87,31.12c4.23,3.43,7.62,6.62,11.12,9.25", null), KanjiStrokeItem(2, "M66.88,27c2.75,1.75,6,5.38,7.75,8.5", null), KanjiStrokeItem(3, "M73.26,22.12c3.06,1.57,6.68,4.82,8.62,7.62", null)),
            relatedWords = listOf(KanaWord("ベッド", "beddo", "tempat tidur/kasur"), KanaWord("ベルト", "beruto", "ikat pinggang"))
        ),
        KanaCharacter(
            character = "ボ",
            romaji = "bo",
            category = KanaCategory.DAKUON,
            strokeCount = 6,
            strokeSteps = listOf("ホ dengan dua tanda kutip di kanan atas"),
            strokes = listOf(KanjiStrokeItem(1, "M22.63,40.38c2.62,1,4.75,1.71,9.12,1.25c17.75-1.88,29.25-2.75,45.38-3.88c3.74-0.26,7.38-0.12,11.12,0.62", null), KanjiStrokeItem(2, "M53.75,17.12c1.38,1.88,1.38,4.5,1.38,7.38c0,2.88-0.12,46.62-0.12,51.88c0,23.12-6.25,11.25-9.75,9.62", null), KanjiStrokeItem(3, "M27.38,59.38c0.5,9.25-1.38,16.62-6.38,21.88", null), KanjiStrokeItem(4, "M73.51,53c10.87,9.62,15.5,17.62,16.62,24.88", null), KanjiStrokeItem(5, "M72.63,17.5c2.75,1.75,6,5.38,7.75,8.5", null), KanjiStrokeItem(6, "M79.01,12.62c3.06,1.57,6.68,4.82,8.62,7.62", null)),
            relatedWords = listOf(KanaWord("ボタン", "botan", "tombol/kancing"), KanaWord("ボール", "booru", "bola"))
        ),
        KanaCharacter(
            character = "パ",
            romaji = "pa",
            category = KanaCategory.DAKUON,
            strokeCount = 3,
            strokeSteps = listOf("ハ dengan lingkaran kecil di kanan atas"),
            strokes = listOf(KanjiStrokeItem(1, "M39.08,36.62c0.38,1.14,0.38,2.84-0.12,4.14c-5.46,13.99-13.08,24.12-21.96,32.49", null), KanjiStrokeItem(2, "M65.5,36.38c13,9.12,23.12,22.62,28,33.38", null), KanjiStrokeItem(3, "M86,30.12c-9.62,0-9.25-14.25,0-14.25c9.76,0.01,9.5,14.25,0,14.25", null)),
            relatedWords = listOf(KanaWord("パン", "pan", "roti"), KanaWord("パーティー", "paatii", "pesta"))
        ),
        KanaCharacter(
            character = "ピ",
            romaji = "pi",
            category = KanaCategory.DAKUON,
            strokeCount = 3,
            strokeSteps = listOf("ヒ dengan lingkaran kecil di kanan atas"),
            strokes = listOf(KanjiStrokeItem(1, "M35.38,44.5c1.75,1.38,4.51,2.19,6.88,1.88c10.24-1.38,17.24-2.88,24.24-4.26c3.01-0.59,7.12-1,9.38-0.88", null), KanjiStrokeItem(2, "M31,17.62c1.38,1.26,1.88,3.38,1.88,6.13c0,2.75-0.88,44-0.88,47.25c0,9.75,4,14.62,13.75,14.62c6,0,16.38,0.12,21.38,0c5-0.12,9.5-0.62,13.5-1.5", null), KanjiStrokeItem(3, "M83,32.88c-9.62,0-9.25-14.25,0-14.25c9.76-0.01,9.5,14.25,0,14.25", null)),
            relatedWords = listOf(KanaWord("ピアノ", "piano", "piano"), KanaWord("ピザ", "piza", "pizza"))
        ),
        KanaCharacter(
            character = "プ",
            romaji = "pu",
            category = KanaCategory.DAKUON,
            strokeCount = 2,
            strokeSteps = listOf("フ dengan lingkaran kecil di kanan atas"),
            strokes = listOf(KanjiStrokeItem(1, "M24.5,30c1.88,1.88,3.5,2.04,6.5,1.62c14.5-2,29-4.38,43.75-6.88c6.82-1.16,10.58,2.29,6.88,9.12c-10.38,19.14-21.25,39.52-50.01,53.64", null), KanjiStrokeItem(2, "M92.62,23.88c-9.62,0-9.25-14.25,0-14.25c9.76-0.01,9.5,14.25,0,14.25", null)),
            relatedWords = listOf(KanaWord("プール", "puuru", "kolam renang"), KanaWord("プレゼント", "purezento", "hadiah"))
        ),
        KanaCharacter(
            character = "ペ",
            romaji = "pe",
            category = KanaCategory.DAKUON,
            strokeCount = 2,
            strokeSteps = listOf("ヘ dengan lingkaran kecil di kanan atas"),
            strokes = listOf(KanjiStrokeItem(1, "M15.5,49.25c2.75,1.5,5.33,0.62,6.88-0.88c4-3.88,9.12-8.75,11.62-11.25c3.12-3.12,7.23-5.08,11.87-1.12c11.13,9.5,26.25,22,36.87,30.62c4.23,3.43,7.62,6.62,11.12,9.25", null), KanjiStrokeItem(2, "M72.74,36.12c-9.62,0-9.25-14.25,0-14.25c9.76,0.01,9.5,14.25,0,14.25", null)),
            relatedWords = listOf(KanaWord("ペン", "pen", "pulpen/pena"), KanaWord("ペット", "petto", "hewan peliharaan"))
        ),
        KanaCharacter(
            character = "ポ",
            romaji = "po",
            category = KanaCategory.DAKUON,
            strokeCount = 5,
            strokeSteps = listOf("ホ dengan lingkaran kecil di kanan atas"),
            strokes = listOf(KanjiStrokeItem(1, "M22.63,40.38c2.62,1,4.75,1.71,9.12,1.25c17.75-1.88,29.25-2.75,45.38-3.88c3.74-0.26,7.38-0.12,11.12,0.62", null), KanjiStrokeItem(2, "M53.75,17.12c1.38,1.88,1.38,4.5,1.38,7.38c0,2.88-0.12,46.62-0.12,51.88c0,23.12-6.25,11.25-9.75,9.62", null), KanjiStrokeItem(3, "M27.38,59.38c0.5,9.25-1.38,16.62-6.38,21.88", null), KanjiStrokeItem(4, "M73.51,53c10.87,9.62,15.5,17.62,16.62,24.88", null), KanjiStrokeItem(5, "M79.75,25.62c-9.62,0-9.25-14.25,0-14.25c9.76,0.01,9.5,14.25,0,14.25", null)),
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
            strokes = listOf(KanjiStrokeItem(1, "M30.5,30.25c1.88,0.75,4.64,1.06,5.88,0.88c6.75-1,22.25-4.5,26.5-6c2.17-0.76,3.5-1.25,4.88-2.12", null), KanjiStrokeItem(2, "M36.25,48.7c2.01,0.85,4.97,1.2,6.29,0.99c7.23-1.13,23.82-5.09,28.37-6.79c2.32-0.86,3.75-1.41,5.22-2.4", null), KanjiStrokeItem(3, "M42,14.12c1.5,0.88,3.13,2.94,4,5.12c5.5,13.76,16,29.26,26.37,40.76c7.64,8.47,9.12,9.38-6,3.88", null), KanjiStrokeItem(4, "M33.75,83.25c10.62,9.75,27.25,8.62,38.12,5", null), KanjiStrokeItem(5, "M26,61.07c1.49,1.29,4.16,1.98,6.84,0.69c14.68-7.03,28.36-15.36,40.32-15.26c7.16,0.11,12.7,3.28,12.63,9.75c0,6.61-8.63,13.15-19.43,14.14", null), KanjiStrokeItem(6, "M49.1,34.5c4.07,0.69,8.25,3.21,9.12,5.25c1.69,3.97-0.79,1.88-2.28,2.08", null), KanjiStrokeItem(7, "M35.77,40.99c1.88,1.49,2.35,2.77,2.82,4.67c2.08,8.33,8.82,32.37,11.7,41.39c0.51,1.62,1.49,4.96,2.28,7.44", null)),
            relatedWords = listOf(KanaWord("きゃく", "kyaku", "tamu/pelanggan"))
        ),
        KanaCharacter(
            character = "きゅ",
            romaji = "kyu",
            category = KanaCategory.YOON,
            strokeCount = 5,
            strokeSteps = listOf("き ditambah ゅ kecil"),
            strokes = listOf(KanjiStrokeItem(1, "M30.5,30.25c1.88,0.75,4.64,1.06,5.88,0.88c6.75-1,22.25-4.5,26.5-6c2.17-0.76,3.5-1.25,4.88-2.12", null), KanjiStrokeItem(2, "M36.25,48.7c2.01,0.85,4.97,1.2,6.29,0.99c7.23-1.13,23.82-5.09,28.37-6.79c2.32-0.86,3.75-1.41,5.22-2.4", null), KanjiStrokeItem(3, "M42,14.12c1.5,0.88,3.13,2.94,4,5.12c5.5,13.76,16,29.26,26.37,40.76c7.64,8.47,9.12,9.38-6,3.88", null), KanjiStrokeItem(4, "M33.75,83.25c10.62,9.75,27.25,8.62,38.12,5", null), KanjiStrokeItem(5, "M27.74,40.79c1.1,1.2,1.61,3.3,1.2,5c-2.3,9.4-3.2,17.79-1.7,27.99c2.22,15.08,0.9,3.1,2.6-1.2c7.19-18.19,21.79-27.59,35.49-27.59c13.5,0,17.49,9.1,17.49,16.2c0,21.89-24.69,23.69-34.39,13.4", null), KanjiStrokeItem(6, "M57.63,33.89c2.1,1.4,2.53,2.5,2.8,5.7c0.7,8.4,1.12,14.97,1.3,23.49c0.4,19.19-5,25.59-9.9,31.39", null)),
            relatedWords = listOf(KanaWord("きゅう", "kyuu", "angka sembilan"))
        ),
        KanaCharacter(
            character = "きょ",
            romaji = "kyo",
            category = KanaCategory.YOON,
            strokeCount = 5,
            strokeSteps = listOf("き ditambah ょ kecil"),
            strokes = listOf(KanjiStrokeItem(1, "M30.5,30.25c1.88,0.75,4.64,1.06,5.88,0.88c6.75-1,22.25-4.5,26.5-6c2.17-0.76,3.5-1.25,4.88-2.12", null), KanjiStrokeItem(2, "M36.25,48.7c2.01,0.85,4.97,1.2,6.29,0.99c7.23-1.13,23.82-5.09,28.37-6.79c2.32-0.86,3.75-1.41,5.22-2.4", null), KanjiStrokeItem(3, "M42,14.12c1.5,0.88,3.13,2.94,4,5.12c5.5,13.76,16,29.26,26.37,40.76c7.64,8.47,9.12,9.38-6,3.88", null), KanjiStrokeItem(4, "M33.75,83.25c10.62,9.75,27.25,8.62,38.12,5", null), KanjiStrokeItem(5, "M57.8,50.06c5.98-1.02,10.95-2.09,14.74-3.25c1.99-0.61,3.8-0.91,4.98-0.91", null), KanjiStrokeItem(6, "M54.91,33c1.79,1.69,2.38,3.28,2.29,5.16c-0.6,13.49-0.1,27.68,1.11,42.47c1.5,18.31-27.81,16.56-27.81,9.12c0-9.53,20.92-6.35,28.68-3.27c6.46,2.56,9.18,3.87,14.76,8.23", null)),
            relatedWords = listOf(KanaWord("きょう", "kyou", "hari ini"))
        ),
        KanaCharacter(
            character = "しゃ",
            romaji = "sha",
            category = KanaCategory.YOON,
            strokeCount = 3,
            strokeSteps = listOf("し ditambah ゃ kecil"),
            strokes = listOf(KanjiStrokeItem(1, "M39.12,17.5c1.25,3.12,0.93,6.74,0.38,10.25c-2.12,13.5-3,26.5-3,39.12c0,27.38,19.88,30.12,45.5,17.25", null), KanjiStrokeItem(2, "M26,61.07c1.49,1.29,4.16,1.98,6.84,0.69c14.68-7.03,28.36-15.36,40.32-15.26c7.16,0.11,12.7,3.28,12.63,9.75c0,6.61-8.63,13.15-19.43,14.14", null), KanjiStrokeItem(3, "M49.1,34.5c4.07,0.69,8.25,3.21,9.12,5.25c1.69,3.97-0.79,1.88-2.28,2.08", null), KanjiStrokeItem(4, "M35.77,40.99c1.88,1.49,2.35,2.77,2.82,4.67c2.08,8.33,8.82,32.37,11.7,41.39c0.51,1.62,1.49,4.96,2.28,7.44", null)),
            relatedWords = listOf(KanaWord("しゃしん", "shashin", "foto"))
        ),
        KanaCharacter(
            character = "しゅ",
            romaji = "shu",
            category = KanaCategory.YOON,
            strokeCount = 2,
            strokeSteps = listOf("し ditambah ゅ kecil"),
            strokes = listOf(KanjiStrokeItem(1, "M39.12,17.5c1.25,3.12,0.93,6.74,0.38,10.25c-2.12,13.5-3,26.5-3,39.12c0,27.38,19.88,30.12,45.5,17.25", null), KanjiStrokeItem(2, "M27.74,40.79c1.1,1.2,1.61,3.3,1.2,5c-2.3,9.4-3.2,17.79-1.7,27.99c2.22,15.08,0.9,3.1,2.6-1.2c7.19-18.19,21.79-27.59,35.49-27.59c13.5,0,17.49,9.1,17.49,16.2c0,21.89-24.69,23.69-34.39,13.4", null), KanjiStrokeItem(3, "M57.63,33.89c2.1,1.4,2.53,2.5,2.8,5.7c0.7,8.4,1.12,14.97,1.3,23.49c0.4,19.19-5,25.59-9.9,31.39", null)),
            relatedWords = listOf(KanaWord("しゅくだい", "shukudai", "pekerjaan rumah (PR)"))
        ),
        KanaCharacter(
            character = "しょ",
            romaji = "sho",
            category = KanaCategory.YOON,
            strokeCount = 2,
            strokeSteps = listOf("し ditambah ょ kecil"),
            strokes = listOf(KanjiStrokeItem(1, "M39.12,17.5c1.25,3.12,0.93,6.74,0.38,10.25c-2.12,13.5-3,26.5-3,39.12c0,27.38,19.88,30.12,45.5,17.25", null), KanjiStrokeItem(2, "M57.8,50.06c5.98-1.02,10.95-2.09,14.74-3.25c1.99-0.61,3.8-0.91,4.98-0.91", null), KanjiStrokeItem(3, "M54.91,33c1.79,1.69,2.38,3.28,2.29,5.16c-0.6,13.49-0.1,27.68,1.11,42.47c1.5,18.31-27.81,16.56-27.81,9.12c0-9.53,20.92-6.35,28.68-3.27c6.46,2.56,9.18,3.87,14.76,8.23", null)),
            relatedWords = listOf(KanaWord("しょくどう", "shokudou", "kantin/ruang makan"))
        ),
        KanaCharacter(
            character = "ちゃ",
            romaji = "cha",
            category = KanaCategory.YOON,
            strokeCount = 4,
            strokeSteps = listOf("ち ditambah ゃ kecil"),
            strokes = listOf(KanjiStrokeItem(1, "M24.5,32.62c1.38,0.62,3.88,1.51,6.38,1.12c6.5-1,18.25-4.12,26.88-6c2.64-0.57,5.38-1.5,7.62-2.38", null), KanjiStrokeItem(2, "M45.62,15.62c0.75,1.25,0.71,3.58,0.38,5.25c-3,15-4.25,22.59-8.38,38.62c-3.25,12.62-5.38,11.12,3.62,4.38c8.29-6.21,19.75-9.5,28.5-9.5c8.62,0,14.58,5.88,14.5,14.5c-0.12,13.5-16.5,20.62-29.88,23.25", null), KanjiStrokeItem(3, "M26,61.07c1.49,1.29,4.16,1.98,6.84,0.69c14.68-7.03,28.36-15.36,40.32-15.26c7.16,0.11,12.7,3.28,12.63,9.75c0,6.61-8.63,13.15-19.43,14.14", null), KanjiStrokeItem(4, "M49.1,34.5c4.07,0.69,8.25,3.21,9.12,5.25c1.69,3.97-0.79,1.88-2.28,2.08", null), KanjiStrokeItem(5, "M35.77,40.99c1.88,1.49,2.35,2.77,2.82,4.67c2.08,8.33,8.82,32.37,11.7,41.39c0.51,1.62,1.49,4.96,2.28,7.44", null)),
            relatedWords = listOf(KanaWord("おちゃ", "ocha", "teh hijau Jepang"))
        ),
        KanaCharacter(
            character = "ちゅ",
            romaji = "chu",
            category = KanaCategory.YOON,
            strokeCount = 3,
            strokeSteps = listOf("ち ditambah ゅ kecil"),
            strokes = listOf(KanjiStrokeItem(1, "M24.5,32.62c1.38,0.62,3.88,1.51,6.38,1.12c6.5-1,18.25-4.12,26.88-6c2.64-0.57,5.38-1.5,7.62-2.38", null), KanjiStrokeItem(2, "M45.62,15.62c0.75,1.25,0.71,3.58,0.38,5.25c-3,15-4.25,22.59-8.38,38.62c-3.25,12.62-5.38,11.12,3.62,4.38c8.29-6.21,19.75-9.5,28.5-9.5c8.62,0,14.58,5.88,14.5,14.5c-0.12,13.5-16.5,20.62-29.88,23.25", null), KanjiStrokeItem(3, "M27.74,40.79c1.1,1.2,1.61,3.3,1.2,5c-2.3,9.4-3.2,17.79-1.7,27.99c2.22,15.08,0.9,3.1,2.6-1.2c7.19-18.19,21.79-27.59,35.49-27.59c13.5,0,17.49,9.1,17.49,16.2c0,21.89-24.69,23.69-34.39,13.4", null), KanjiStrokeItem(4, "M57.63,33.89c2.1,1.4,2.53,2.5,2.8,5.7c0.7,8.4,1.12,14.97,1.3,23.49c0.4,19.19-5,25.59-9.9,31.39", null)),
            relatedWords = listOf(KanaWord("ちゅうごく", "chuugoku", "negara Tiongkok"))
        ),
        KanaCharacter(
            character = "ちょ",
            romaji = "cho",
            category = KanaCategory.YOON,
            strokeCount = 3,
            strokeSteps = listOf("ち ditambah ょ kecil"),
            strokes = listOf(KanjiStrokeItem(1, "M24.5,32.62c1.38,0.62,3.88,1.51,6.38,1.12c6.5-1,18.25-4.12,26.88-6c2.64-0.57,5.38-1.5,7.62-2.38", null), KanjiStrokeItem(2, "M45.62,15.62c0.75,1.25,0.71,3.58,0.38,5.25c-3,15-4.25,22.59-8.38,38.62c-3.25,12.62-5.38,11.12,3.62,4.38c8.29-6.21,19.75-9.5,28.5-9.5c8.62,0,14.58,5.88,14.5,14.5c-0.12,13.5-16.5,20.62-29.88,23.25", null), KanjiStrokeItem(3, "M57.8,50.06c5.98-1.02,10.95-2.09,14.74-3.25c1.99-0.61,3.8-0.91,4.98-0.91", null), KanjiStrokeItem(4, "M54.91,33c1.79,1.69,2.38,3.28,2.29,5.16c-0.6,13.49-0.1,27.68,1.11,42.47c1.5,18.31-27.81,16.56-27.81,9.12c0-9.53,20.92-6.35,28.68-3.27c6.46,2.56,9.18,3.87,14.76,8.23", null)),
            relatedWords = listOf(KanaWord("ちょっと", "chotto", "sebentar/sedikit"))
        ),
        KanaCharacter(
            character = "にゃ",
            romaji = "nya",
            category = KanaCategory.YOON,
            strokeCount = 5,
            strokeSteps = listOf("に ditambah ゃ kecil"),
            strokes = listOf(KanjiStrokeItem(1, "M24.53,22.75c1.25,1.5,1.62,3.75,1.12,6.38c-3,15.88-9,32.5-7.38,47.62c2.02,18.84,4.5,5.75,8.5-3.5", null), KanjiStrokeItem(2, "M53.2,30.64c0.96,0.79,2.44,1.58,5.1,1.35c6.98-0.61,15.01-3.3,22.04-3.36c13.19-0.11,1.5,3.75-8.39,7.35", null), KanjiStrokeItem(3, "M52.53,68c1.76,12.92,11.92,16.01,24.23,14.93c5.08-0.45,8.9-0.8,14.27-2.06", null), KanjiStrokeItem(4, "M26,61.07c1.49,1.29,4.16,1.98,6.84,0.69c14.68-7.03,28.36-15.36,40.32-15.26c7.16,0.11,12.7,3.28,12.63,9.75c0,6.61-8.63,13.15-19.43,14.14", null), KanjiStrokeItem(5, "M49.1,34.5c4.07,0.69,8.25,3.21,9.12,5.25c1.69,3.97-0.79,1.88-2.28,2.08", null), KanjiStrokeItem(6, "M35.77,40.99c1.88,1.49,2.35,2.77,2.82,4.67c2.08,8.33,8.82,32.37,11.7,41.39c0.51,1.62,1.49,4.96,2.28,7.44", null)),
            relatedWords = listOf(KanaWord("にゃー", "nyaa", "suara kucing mengeong"))
        ),
        KanaCharacter(
            character = "にゅ",
            romaji = "nyu",
            category = KanaCategory.YOON,
            strokeCount = 4,
            strokeSteps = listOf("に ditambah ゅ kecil"),
            strokes = listOf(KanjiStrokeItem(1, "M24.53,22.75c1.25,1.5,1.62,3.75,1.12,6.38c-3,15.88-9,32.5-7.38,47.62c2.02,18.84,4.5,5.75,8.5-3.5", null), KanjiStrokeItem(2, "M53.2,30.64c0.96,0.79,2.44,1.58,5.1,1.35c6.98-0.61,15.01-3.3,22.04-3.36c13.19-0.11,1.5,3.75-8.39,7.35", null), KanjiStrokeItem(3, "M52.53,68c1.76,12.92,11.92,16.01,24.23,14.93c5.08-0.45,8.9-0.8,14.27-2.06", null), KanjiStrokeItem(4, "M27.74,40.79c1.1,1.2,1.61,3.3,1.2,5c-2.3,9.4-3.2,17.79-1.7,27.99c2.22,15.08,0.9,3.1,2.6-1.2c7.19-18.19,21.79-27.59,35.49-27.59c13.5,0,17.49,9.1,17.49,16.2c0,21.89-24.69,23.69-34.39,13.4", null), KanjiStrokeItem(5, "M57.63,33.89c2.1,1.4,2.53,2.5,2.8,5.7c0.7,8.4,1.12,14.97,1.3,23.49c0.4,19.19-5,25.59-9.9,31.39", null)),
            relatedWords = listOf(KanaWord("ぎゅうにゅう", "gyuunyuu", "susu sapi segar"))
        ),
        KanaCharacter(
            character = "にょ",
            romaji = "nyo",
            category = KanaCategory.YOON,
            strokeCount = 4,
            strokeSteps = listOf("に ditambah ょ kecil"),
            strokes = listOf(KanjiStrokeItem(1, "M24.53,22.75c1.25,1.5,1.62,3.75,1.12,6.38c-3,15.88-9,32.5-7.38,47.62c2.02,18.84,4.5,5.75,8.5-3.5", null), KanjiStrokeItem(2, "M53.2,30.64c0.96,0.79,2.44,1.58,5.1,1.35c6.98-0.61,15.01-3.3,22.04-3.36c13.19-0.11,1.5,3.75-8.39,7.35", null), KanjiStrokeItem(3, "M52.53,68c1.76,12.92,11.92,16.01,24.23,14.93c5.08-0.45,8.9-0.8,14.27-2.06", null), KanjiStrokeItem(4, "M57.8,50.06c5.98-1.02,10.95-2.09,14.74-3.25c1.99-0.61,3.8-0.91,4.98-0.91", null), KanjiStrokeItem(5, "M54.91,33c1.79,1.69,2.38,3.28,2.29,5.16c-0.6,13.49-0.1,27.68,1.11,42.47c1.5,18.31-27.81,16.56-27.81,9.12c0-9.53,20.92-6.35,28.68-3.27c6.46,2.56,9.18,3.87,14.76,8.23", null)),
            relatedWords = listOf(KanaWord("にょうぼう", "nyoubou", "istri"))
        ),
        KanaCharacter(
            character = "ひゃ",
            romaji = "hya",
            category = KanaCategory.YOON,
            strokeCount = 3,
            strokeSteps = listOf("ひ ditambah ゃ kecil"),
            strokes = listOf(KanjiStrokeItem(1, "M20,25.12c1.25,0.88,3.75,2.25,6.5,1.38c2.75-0.87,7.31-2.38,11.38-4.5c6-3.12,8.42-1.01,4.25,4c-27.13,32.62-23.76,58.5-1.52,62.88c18.07,3.56,37.63-16.38,35.63-56.51c-0.72-14.5-0.17-14.78,4.12-1.75c3.76,11.38,10.26,20.76,16.14,26.5", null), KanjiStrokeItem(2, "M26,61.07c1.49,1.29,4.16,1.98,6.84,0.69c14.68-7.03,28.36-15.36,40.32-15.26c7.16,0.11,12.7,3.28,12.63,9.75c0,6.61-8.63,13.15-19.43,14.14", null), KanjiStrokeItem(3, "M49.1,34.5c4.07,0.69,8.25,3.21,9.12,5.25c1.69,3.97-0.79,1.88-2.28,2.08", null), KanjiStrokeItem(4, "M35.77,40.99c1.88,1.49,2.35,2.77,2.82,4.67c2.08,8.33,8.82,32.37,11.7,41.39c0.51,1.62,1.49,4.96,2.28,7.44", null)),
            relatedWords = listOf(KanaWord("ひゃく", "hyaku", "angka seratus"))
        ),
        KanaCharacter(
            character = "ひゅ",
            romaji = "hyu",
            category = KanaCategory.YOON,
            strokeCount = 2,
            strokeSteps = listOf("ひ ditambah ゅ kecil"),
            strokes = listOf(KanjiStrokeItem(1, "M20,25.12c1.25,0.88,3.75,2.25,6.5,1.38c2.75-0.87,7.31-2.38,11.38-4.5c6-3.12,8.42-1.01,4.25,4c-27.13,32.62-23.76,58.5-1.52,62.88c18.07,3.56,37.63-16.38,35.63-56.51c-0.72-14.5-0.17-14.78,4.12-1.75c3.76,11.38,10.26,20.76,16.14,26.5", null), KanjiStrokeItem(2, "M27.74,40.79c1.1,1.2,1.61,3.3,1.2,5c-2.3,9.4-3.2,17.79-1.7,27.99c2.22,15.08,0.9,3.1,2.6-1.2c7.19-18.19,21.79-27.59,35.49-27.59c13.5,0,17.49,9.1,17.49,16.2c0,21.89-24.69,23.69-34.39,13.4", null), KanjiStrokeItem(3, "M57.63,33.89c2.1,1.4,2.53,2.5,2.8,5.7c0.7,8.4,1.12,14.97,1.3,23.49c0.4,19.19-5,25.59-9.9,31.39", null)),
            relatedWords = listOf(KanaWord("ひょう", "hyou", "tabel/daftar"))
        ),
        KanaCharacter(
            character = "ひょ",
            romaji = "hyo",
            category = KanaCategory.YOON,
            strokeCount = 2,
            strokeSteps = listOf("ひ ditambah ょ kecil"),
            strokes = listOf(KanjiStrokeItem(1, "M20,25.12c1.25,0.88,3.75,2.25,6.5,1.38c2.75-0.87,7.31-2.38,11.38-4.5c6-3.12,8.42-1.01,4.25,4c-27.13,32.62-23.76,58.5-1.52,62.88c18.07,3.56,37.63-16.38,35.63-56.51c-0.72-14.5-0.17-14.78,4.12-1.75c3.76,11.38,10.26,20.76,16.14,26.5", null), KanjiStrokeItem(2, "M57.8,50.06c5.98-1.02,10.95-2.09,14.74-3.25c1.99-0.61,3.8-0.91,4.98-0.91", null), KanjiStrokeItem(3, "M54.91,33c1.79,1.69,2.38,3.28,2.29,5.16c-0.6,13.49-0.1,27.68,1.11,42.47c1.5,18.31-27.81,16.56-27.81,9.12c0-9.53,20.92-6.35,28.68-3.27c6.46,2.56,9.18,3.87,14.76,8.23", null)),
            relatedWords = listOf(KanaWord("ひょうげん", "hyougen", "ungkapan/ekspresi"))
        ),
        KanaCharacter(
            character = "みゃ",
            romaji = "mya",
            category = KanaCategory.YOON,
            strokeCount = 4,
            strokeSteps = listOf("み ditambah ゃ kecil"),
            strokes = listOf(KanjiStrokeItem(1, "M32.5,26c1.88,1.75,4.06,1.7,6.88,1.25c3.88-0.62,7.62-1.75,11.88-3.12c4.26-1.37,6.25-0.12,4.5,5.12c-1.75,5.24-6.66,17.39-12,30.12c-13.63,32.51-29.26,29.26-29.26,18.63c0-14.25,20.48-15.36,33-13.5c18.5,2.75,30,6.62,44.38,14.25", null), KanjiStrokeItem(2, "M79.38,54.75c0.75,2.38,0.49,4.37,0,6.25c-2.12,8.12-7.5,25-22.12,33.75", null), KanjiStrokeItem(3, "M26,61.07c1.49,1.29,4.16,1.98,6.84,0.69c14.68-7.03,28.36-15.36,40.32-15.26c7.16,0.11,12.7,3.28,12.63,9.75c0,6.61-8.63,13.15-19.43,14.14", null), KanjiStrokeItem(4, "M49.1,34.5c4.07,0.69,8.25,3.21,9.12,5.25c1.69,3.97-0.79,1.88-2.28,2.08", null), KanjiStrokeItem(5, "M35.77,40.99c1.88,1.49,2.35,2.77,2.82,4.67c2.08,8.33,8.82,32.37,11.7,41.39c0.51,1.62,1.49,4.96,2.28,7.44", null)),
            relatedWords = listOf(KanaWord("みゃく", "myaku", "denyut nadi"))
        ),
        KanaCharacter(
            character = "みゅ",
            romaji = "myu",
            category = KanaCategory.YOON,
            strokeCount = 3,
            strokeSteps = listOf("み ditambah ゅ kecil"),
            strokes = listOf(KanjiStrokeItem(1, "M32.5,26c1.88,1.75,4.06,1.7,6.88,1.25c3.88-0.62,7.62-1.75,11.88-3.12c4.26-1.37,6.25-0.12,4.5,5.12c-1.75,5.24-6.66,17.39-12,30.12c-13.63,32.51-29.26,29.26-29.26,18.63c0-14.25,20.48-15.36,33-13.5c18.5,2.75,30,6.62,44.38,14.25", null), KanjiStrokeItem(2, "M79.38,54.75c0.75,2.38,0.49,4.37,0,6.25c-2.12,8.12-7.5,25-22.12,33.75", null), KanjiStrokeItem(3, "M27.74,40.79c1.1,1.2,1.61,3.3,1.2,5c-2.3,9.4-3.2,17.79-1.7,27.99c2.22,15.08,0.9,3.1,2.6-1.2c7.19-18.19,21.79-27.59,35.49-27.59c13.5,0,17.49,9.1,17.49,16.2c0,21.89-24.69,23.69-34.39,13.4", null), KanjiStrokeItem(4, "M57.63,33.89c2.1,1.4,2.53,2.5,2.8,5.7c0.7,8.4,1.12,14.97,1.3,23.49c0.4,19.19-5,25.59-9.9,31.39", null)),
            relatedWords = listOf(KanaWord("みゅーじっく", "myuujikku", "musik"))
        ),
        KanaCharacter(
            character = "みょ",
            romaji = "myo",
            category = KanaCategory.YOON,
            strokeCount = 3,
            strokeSteps = listOf("み ditambah ゅ kecil"),
            strokes = listOf(KanjiStrokeItem(1, "M32.5,26c1.88,1.75,4.06,1.7,6.88,1.25c3.88-0.62,7.62-1.75,11.88-3.12c4.26-1.37,6.25-0.12,4.5,5.12c-1.75,5.24-6.66,17.39-12,30.12c-13.63,32.51-29.26,29.26-29.26,18.63c0-14.25,20.48-15.36,33-13.5c18.5,2.75,30,6.62,44.38,14.25", null), KanjiStrokeItem(2, "M79.38,54.75c0.75,2.38,0.49,4.37,0,6.25c-2.12,8.12-7.5,25-22.12,33.75", null), KanjiStrokeItem(3, "M57.8,50.06c5.98-1.02,10.95-2.09,14.74-3.25c1.99-0.61,3.8-0.91,4.98-0.91", null), KanjiStrokeItem(4, "M54.91,33c1.79,1.69,2.38,3.28,2.29,5.16c-0.6,13.49-0.1,27.68,1.11,42.47c1.5,18.31-27.81,16.56-27.81,9.12c0-9.53,20.92-6.35,28.68-3.27c6.46,2.56,9.18,3.87,14.76,8.23", null)),
            relatedWords = listOf(KanaWord("みょうじ", "myouji", "nama keluarga/marga"))
        ),
        KanaCharacter(
            character = "りゃ",
            romaji = "rya",
            category = KanaCategory.YOON,
            strokeCount = 4,
            strokeSteps = listOf("り ditambah ゃ kecil"),
            strokes = listOf(KanjiStrokeItem(1, "M38.75,25.25c1.25,1.5,2.24,4.03,1.62,6.62c-2.88,12.13-6.29,29.65-4.25,42.38c2,12.5,1.75-0.75,5.62-6.25", null), KanjiStrokeItem(2, "M69.37,18.75c2.25,2.12,2.88,4.12,2.88,6.5c0,2.38,0,26.38,0,35.75c0,16.5-5,25.75-12.62,33.12", null), KanjiStrokeItem(3, "M26,61.07c1.49,1.29,4.16,1.98,6.84,0.69c14.68-7.03,28.36-15.36,40.32-15.26c7.16,0.11,12.7,3.28,12.63,9.75c0,6.61-8.63,13.15-19.43,14.14", null), KanjiStrokeItem(4, "M49.1,34.5c4.07,0.69,8.25,3.21,9.12,5.25c1.69,3.97-0.79,1.88-2.28,2.08", null), KanjiStrokeItem(5, "M35.77,40.99c1.88,1.49,2.35,2.77,2.82,4.67c2.08,8.33,8.82,32.37,11.7,41.39c0.51,1.62,1.49,4.96,2.28,7.44", null)),
            relatedWords = listOf(KanaWord("りゃく", "ryaku", "singkatan"))
        ),
        KanaCharacter(
            character = "りゅ",
            romaji = "ryu",
            category = KanaCategory.YOON,
            strokeCount = 3,
            strokeSteps = listOf("り ditambah ゅ kecil"),
            strokes = listOf(KanjiStrokeItem(1, "M38.75,25.25c1.25,1.5,2.24,4.03,1.62,6.62c-2.88,12.13-6.29,29.65-4.25,42.38c2,12.5,1.75-0.75,5.62-6.25", null), KanjiStrokeItem(2, "M69.37,18.75c2.25,2.12,2.88,4.12,2.88,6.5c0,2.38,0,26.38,0,35.75c0,16.5-5,25.75-12.62,33.12", null), KanjiStrokeItem(3, "M27.74,40.79c1.1,1.2,1.61,3.3,1.2,5c-2.3,9.4-3.2,17.79-1.7,27.99c2.22,15.08,0.9,3.1,2.6-1.2c7.19-18.19,21.79-27.59,35.49-27.59c13.5,0,17.49,9.1,17.49,16.2c0,21.89-24.69,23.69-34.39,13.4", null), KanjiStrokeItem(4, "M57.63,33.89c2.1,1.4,2.53,2.5,2.8,5.7c0.7,8.4,1.12,14.97,1.3,23.49c0.4,19.19-5,25.59-9.9,31.39", null)),
            relatedWords = listOf(KanaWord("りゅうがく", "ryuugaku", "studi di luar negeri"))
        ),
        KanaCharacter(
            character = "りょ",
            romaji = "ryo",
            category = KanaCategory.YOON,
            strokeCount = 3,
            strokeSteps = listOf("り ditambah ょ kecil"),
            strokes = listOf(KanjiStrokeItem(1, "M38.75,25.25c1.25,1.5,2.24,4.03,1.62,6.62c-2.88,12.13-6.29,29.65-4.25,42.38c2,12.5,1.75-0.75,5.62-6.25", null), KanjiStrokeItem(2, "M69.37,18.75c2.25,2.12,2.88,4.12,2.88,6.5c0,2.38,0,26.38,0,35.75c0,16.5-5,25.75-12.62,33.12", null), KanjiStrokeItem(3, "M57.8,50.06c5.98-1.02,10.95-2.09,14.74-3.25c1.99-0.61,3.8-0.91,4.98-0.91", null), KanjiStrokeItem(4, "M54.91,33c1.79,1.69,2.38,3.28,2.29,5.16c-0.6,13.49-0.1,27.68,1.11,42.47c1.5,18.31-27.81,16.56-27.81,9.12c0-9.53,20.92-6.35,28.68-3.27c6.46,2.56,9.18,3.87,14.76,8.23", null)),
            relatedWords = listOf(KanaWord("りょこう", "ryokou", "wisata/liburan"))
        ),
        KanaCharacter(
            character = "ぎゃ",
            romaji = "gya",
            category = KanaCategory.YOON,
            strokeCount = 8,
            strokeSteps = listOf("ぎ ditambah ゃ kecil"),
            strokes = listOf(KanjiStrokeItem(1, "M30.5,30.5c1.88,0.75,4.64,1.06,5.88,0.88c6.75-1,22.25-4.5,26.5-6c2.17-0.76,3.5-1.25,4.88-2.12", null), KanjiStrokeItem(2, "M36.25,48.95c2.01,0.85,4.97,1.2,6.29,0.99c7.23-1.13,23.82-5.09,28.37-6.79c2.32-0.86,3.75-1.41,5.22-2.4", null), KanjiStrokeItem(3, "M42,14.38c1.5,0.88,3.13,2.94,4,5.12c5.5,13.75,16,29.25,26.38,40.75c7.64,8.47,9.12,9.38-6,3.88", null), KanjiStrokeItem(4, "M33.75,83.5c10.62,9.75,27.25,8.62,38.12,5", null), KanjiStrokeItem(5, "M77.37,19c2.75,1.75,6,5.38,7.75,8.5", null), KanjiStrokeItem(6, "M83.75,14.12c3.06,1.57,6.68,4.82,8.62,7.62", null), KanjiStrokeItem(7, "M26,61.07c1.49,1.29,4.16,1.98,6.84,0.69c14.68-7.03,28.36-15.36,40.32-15.26c7.16,0.11,12.7,3.28,12.63,9.75c0,6.61-8.63,13.15-19.43,14.14", null), KanjiStrokeItem(8, "M49.1,34.5c4.07,0.69,8.25,3.21,9.12,5.25c1.69,3.97-0.79,1.88-2.28,2.08", null), KanjiStrokeItem(9, "M35.77,40.99c1.88,1.49,2.35,2.77,2.82,4.67c2.08,8.33,8.82,32.37,11.7,41.39c0.51,1.62,1.49,4.96,2.28,7.44", null)),
            relatedWords = listOf(KanaWord("ぎゃく", "gyaku", "kebalikan/terbalik"))
        ),
        KanaCharacter(
            character = "ぎゅ",
            romaji = "gyu",
            category = KanaCategory.YOON,
            strokeCount = 7,
            strokeSteps = listOf("ぎ ditambah ゅ kecil"),
            strokes = listOf(KanjiStrokeItem(1, "M30.5,30.5c1.88,0.75,4.64,1.06,5.88,0.88c6.75-1,22.25-4.5,26.5-6c2.17-0.76,3.5-1.25,4.88-2.12", null), KanjiStrokeItem(2, "M36.25,48.95c2.01,0.85,4.97,1.2,6.29,0.99c7.23-1.13,23.82-5.09,28.37-6.79c2.32-0.86,3.75-1.41,5.22-2.4", null), KanjiStrokeItem(3, "M42,14.38c1.5,0.88,3.13,2.94,4,5.12c5.5,13.75,16,29.25,26.38,40.75c7.64,8.47,9.12,9.38-6,3.88", null), KanjiStrokeItem(4, "M33.75,83.5c10.62,9.75,27.25,8.62,38.12,5", null), KanjiStrokeItem(5, "M77.37,19c2.75,1.75,6,5.38,7.75,8.5", null), KanjiStrokeItem(6, "M83.75,14.12c3.06,1.57,6.68,4.82,8.62,7.62", null), KanjiStrokeItem(7, "M27.74,40.79c1.1,1.2,1.61,3.3,1.2,5c-2.3,9.4-3.2,17.79-1.7,27.99c2.22,15.08,0.9,3.1,2.6-1.2c7.19-18.19,21.79-27.59,35.49-27.59c13.5,0,17.49,9.1,17.49,16.2c0,21.89-24.69,23.69-34.39,13.4", null), KanjiStrokeItem(8, "M57.63,33.89c2.1,1.4,2.53,2.5,2.8,5.7c0.7,8.4,1.12,14.97,1.3,23.49c0.4,19.19-5,25.59-9.9,31.39", null)),
            relatedWords = listOf(KanaWord("ぎゅうにく", "gyuuniku", "daging sapi"))
        ),
        KanaCharacter(
            character = "ぎょ",
            romaji = "gyo",
            category = KanaCategory.YOON,
            strokeCount = 7,
            strokeSteps = listOf("ぎ ditambah ょ kecil"),
            strokes = listOf(KanjiStrokeItem(1, "M30.5,30.5c1.88,0.75,4.64,1.06,5.88,0.88c6.75-1,22.25-4.5,26.5-6c2.17-0.76,3.5-1.25,4.88-2.12", null), KanjiStrokeItem(2, "M36.25,48.95c2.01,0.85,4.97,1.2,6.29,0.99c7.23-1.13,23.82-5.09,28.37-6.79c2.32-0.86,3.75-1.41,5.22-2.4", null), KanjiStrokeItem(3, "M42,14.38c1.5,0.88,3.13,2.94,4,5.12c5.5,13.75,16,29.25,26.38,40.75c7.64,8.47,9.12,9.38-6,3.88", null), KanjiStrokeItem(4, "M33.75,83.5c10.62,9.75,27.25,8.62,38.12,5", null), KanjiStrokeItem(5, "M77.37,19c2.75,1.75,6,5.38,7.75,8.5", null), KanjiStrokeItem(6, "M83.75,14.12c3.06,1.57,6.68,4.82,8.62,7.62", null), KanjiStrokeItem(7, "M57.8,50.06c5.98-1.02,10.95-2.09,14.74-3.25c1.99-0.61,3.8-0.91,4.98-0.91", null), KanjiStrokeItem(8, "M54.91,33c1.79,1.69,2.38,3.28,2.29,5.16c-0.6,13.49-0.1,27.68,1.11,42.47c1.5,18.31-27.81,16.56-27.81,9.12c0-9.53,20.92-6.35,28.68-3.27c6.46,2.56,9.18,3.87,14.76,8.23", null)),
            relatedWords = listOf(KanaWord("ぎょぎょう", "gyogyou", "industri perikanan"))
        ),
        KanaCharacter(
            character = "じゃ",
            romaji = "ja",
            category = KanaCategory.YOON,
            strokeCount = 5,
            strokeSteps = listOf("じ ditambah ゃ kecil"),
            strokes = listOf(KanjiStrokeItem(1, "M39.12,17.25c1.25,3.12,0.93,6.74,0.38,10.25c-2.12,13.5-3,26.5-3,39.12c0,27.38,19.88,30.12,45.5,17.25", null), KanjiStrokeItem(2, "M64.24,27c2.75,1.75,6,5.38,7.75,8.5", null), KanjiStrokeItem(3, "M70.62,22.12c3.06,1.57,6.68,4.82,8.62,7.62", null), KanjiStrokeItem(4, "M26,61.07c1.49,1.29,4.16,1.98,6.84,0.69c14.68-7.03,28.36-15.36,40.32-15.26c7.16,0.11,12.7,3.28,12.63,9.75c0,6.61-8.63,13.15-19.43,14.14", null), KanjiStrokeItem(5, "M49.1,34.5c4.07,0.69,8.25,3.21,9.12,5.25c1.69,3.97-0.79,1.88-2.28,2.08", null), KanjiStrokeItem(6, "M35.77,40.99c1.88,1.49,2.35,2.77,2.82,4.67c2.08,8.33,8.82,32.37,11.7,41.39c0.51,1.62,1.49,4.96,2.28,7.44", null)),
            relatedWords = listOf(KanaWord("じゃま", "jama", "gangguan"))
        ),
        KanaCharacter(
            character = "じゅ",
            romaji = "ju",
            category = KanaCategory.YOON,
            strokeCount = 4,
            strokeSteps = listOf("じ ditambah ゅ kecil"),
            strokes = listOf(KanjiStrokeItem(1, "M39.12,17.25c1.25,3.12,0.93,6.74,0.38,10.25c-2.12,13.5-3,26.5-3,39.12c0,27.38,19.88,30.12,45.5,17.25", null), KanjiStrokeItem(2, "M64.24,27c2.75,1.75,6,5.38,7.75,8.5", null), KanjiStrokeItem(3, "M70.62,22.12c3.06,1.57,6.68,4.82,8.62,7.62", null), KanjiStrokeItem(4, "M27.74,40.79c1.1,1.2,1.61,3.3,1.2,5c-2.3,9.4-3.2,17.79-1.7,27.99c2.22,15.08,0.9,3.1,2.6-1.2c7.19-18.19,21.79-27.59,35.49-27.59c13.5,0,17.49,9.1,17.49,16.2c0,21.89-24.69,23.69-34.39,13.4", null), KanjiStrokeItem(5, "M57.63,33.89c2.1,1.4,2.53,2.5,2.8,5.7c0.7,8.4,1.12,14.97,1.3,23.49c0.4,19.19-5,25.59-9.9,31.39", null)),
            relatedWords = listOf(KanaWord("じゅぎょう", "jugyou", "pelajaran sekolah"))
        ),
        KanaCharacter(
            character = "じょ",
            romaji = "jo",
            category = KanaCategory.YOON,
            strokeCount = 4,
            strokeSteps = listOf("じ ditambah ょ kecil"),
            strokes = listOf(KanjiStrokeItem(1, "M39.12,17.25c1.25,3.12,0.93,6.74,0.38,10.25c-2.12,13.5-3,26.5-3,39.12c0,27.38,19.88,30.12,45.5,17.25", null), KanjiStrokeItem(2, "M64.24,27c2.75,1.75,6,5.38,7.75,8.5", null), KanjiStrokeItem(3, "M70.62,22.12c3.06,1.57,6.68,4.82,8.62,7.62", null), KanjiStrokeItem(4, "M57.8,50.06c5.98-1.02,10.95-2.09,14.74-3.25c1.99-0.61,3.8-0.91,4.98-0.91", null), KanjiStrokeItem(5, "M54.91,33c1.79,1.69,2.38,3.28,2.29,5.16c-0.6,13.49-0.1,27.68,1.11,42.47c1.5,18.31-27.81,16.56-27.81,9.12c0-9.53,20.92-6.35,28.68-3.27c6.46,2.56,9.18,3.87,14.76,8.23", null)),
            relatedWords = listOf(KanaWord("じょせい", "josei", "wanita/perempuan"))
        ),
        KanaCharacter(
            character = "びゃ",
            romaji = "bya",
            category = KanaCategory.YOON,
            strokeCount = 5,
            strokeSteps = listOf("び ditambah ゃ kecil"),
            strokes = listOf(KanjiStrokeItem(1, "M20,25.12c1.25,0.88,3.75,2.25,6.5,1.38c2.75-0.87,7.31-2.38,11.38-4.5c6-3.12,8.42-1.01,4.25,4c-27.13,32.62-23.76,58.5-1.52,62.88c18.07,3.56,37.63-16.38,35.63-56.51c-0.72-14.5-0.17-14.78,4.12-1.75c3.76,11.38,10.26,20.76,16.14,26.5", null), KanjiStrokeItem(2, "M86.5,13.5c2.75,1.75,6,5.38,7.75,8.5", null), KanjiStrokeItem(3, "M92.87,8.62c3.06,1.57,6.68,4.82,8.62,7.62", null), KanjiStrokeItem(4, "M26,61.07c1.49,1.29,4.16,1.98,6.84,0.69c14.68-7.03,28.36-15.36,40.32-15.26c7.16,0.11,12.7,3.28,12.63,9.75c0,6.61-8.63,13.15-19.43,14.14", null), KanjiStrokeItem(5, "M49.1,34.5c4.07,0.69,8.25,3.21,9.12,5.25c1.69,3.97-0.79,1.88-2.28,2.08", null), KanjiStrokeItem(6, "M35.77,40.99c1.88,1.49,2.35,2.77,2.82,4.67c2.08,8.33,8.82,32.37,11.7,41.39c0.51,1.62,1.49,4.96,2.28,7.44", null)),
            relatedWords = listOf(KanaWord("さんびゃく", "sambyaku", "tiga ratus"))
        ),
        KanaCharacter(
            character = "びゅ",
            romaji = "byu",
            category = KanaCategory.YOON,
            strokeCount = 4,
            strokeSteps = listOf("び ditambah ゅ kecil"),
            strokes = listOf(KanjiStrokeItem(1, "M20,25.12c1.25,0.88,3.75,2.25,6.5,1.38c2.75-0.87,7.31-2.38,11.38-4.5c6-3.12,8.42-1.01,4.25,4c-27.13,32.62-23.76,58.5-1.52,62.88c18.07,3.56,37.63-16.38,35.63-56.51c-0.72-14.5-0.17-14.78,4.12-1.75c3.76,11.38,10.26,20.76,16.14,26.5", null), KanjiStrokeItem(2, "M86.5,13.5c2.75,1.75,6,5.38,7.75,8.5", null), KanjiStrokeItem(3, "M92.87,8.62c3.06,1.57,6.68,4.82,8.62,7.62", null), KanjiStrokeItem(4, "M27.74,40.79c1.1,1.2,1.61,3.3,1.2,5c-2.3,9.4-3.2,17.79-1.7,27.99c2.22,15.08,0.9,3.1,2.6-1.2c7.19-18.19,21.79-27.59,35.49-27.59c13.5,0,17.49,9.1,17.49,16.2c0,21.89-24.69,23.69-34.39,13.4", null), KanjiStrokeItem(5, "M57.63,33.89c2.1,1.4,2.53,2.5,2.8,5.7c0.7,8.4,1.12,14.97,1.3,23.49c0.4,19.19-5,25.59-9.9,31.39", null)),
            relatedWords = listOf(KanaWord("びゅー", "byuu", "pemandangan"))
        ),
        KanaCharacter(
            character = "びょ",
            romaji = "byo",
            category = KanaCategory.YOON,
            strokeCount = 4,
            strokeSteps = listOf("び ditambah ょ kecil"),
            strokes = listOf(KanjiStrokeItem(1, "M20,25.12c1.25,0.88,3.75,2.25,6.5,1.38c2.75-0.87,7.31-2.38,11.38-4.5c6-3.12,8.42-1.01,4.25,4c-27.13,32.62-23.76,58.5-1.52,62.88c18.07,3.56,37.63-16.38,35.63-56.51c-0.72-14.5-0.17-14.78,4.12-1.75c3.76,11.38,10.26,20.76,16.14,26.5", null), KanjiStrokeItem(2, "M86.5,13.5c2.75,1.75,6,5.38,7.75,8.5", null), KanjiStrokeItem(3, "M92.87,8.62c3.06,1.57,6.68,4.82,8.62,7.62", null), KanjiStrokeItem(4, "M57.8,50.06c5.98-1.02,10.95-2.09,14.74-3.25c1.99-0.61,3.8-0.91,4.98-0.91", null), KanjiStrokeItem(5, "M54.91,33c1.79,1.69,2.38,3.28,2.29,5.16c-0.6,13.49-0.1,27.68,1.11,42.47c1.5,18.31-27.81,16.56-27.81,9.12c0-9.53,20.92-6.35,28.68-3.27c6.46,2.56,9.18,3.87,14.76,8.23", null)),
            relatedWords = listOf(KanaWord("びょういん", "byouin", "rumah sakit"))
        ),
        KanaCharacter(
            character = "ぴゃ",
            romaji = "pya",
            category = KanaCategory.YOON,
            strokeCount = 4,
            strokeSteps = listOf("ぴ ditambah ゃ kecil"),
            strokes = listOf(KanjiStrokeItem(1, "M20,25.12c1.25,0.88,3.75,2.25,6.5,1.38c2.75-0.87,7.31-2.38,11.38-4.5c6-3.12,8.42-1.01,4.25,4c-27.13,32.62-23.76,58.5-1.52,62.88c18.07,3.56,37.63-16.38,35.63-56.51c-0.72-14.5-0.17-14.78,4.12-1.75c3.76,11.38,10.26,20.76,16.14,26.5", null), KanjiStrokeItem(2, "M93.87,22.12c-9.62,0-9.25-14.25,0-14.25c9.75,0.01,9.5,14.25,0,14.25", null), KanjiStrokeItem(3, "M26,61.07c1.49,1.29,4.16,1.98,6.84,0.69c14.68-7.03,28.36-15.36,40.32-15.26c7.16,0.11,12.7,3.28,12.63,9.75c0,6.61-8.63,13.15-19.43,14.14", null), KanjiStrokeItem(4, "M49.1,34.5c4.07,0.69,8.25,3.21,9.12,5.25c1.69,3.97-0.79,1.88-2.28,2.08", null), KanjiStrokeItem(5, "M35.77,40.99c1.88,1.49,2.35,2.77,2.82,4.67c2.08,8.33,8.82,32.37,11.7,41.39c0.51,1.62,1.49,4.96,2.28,7.44", null)),
            relatedWords = listOf(KanaWord("ろっぴゃく", "roppyaku", "enam ratus"))
        ),
        KanaCharacter(
            character = "ぴゅ",
            romaji = "pyu",
            category = KanaCategory.YOON,
            strokeCount = 3,
            strokeSteps = listOf("ぴ ditambah ゅ kecil"),
            strokes = listOf(KanjiStrokeItem(1, "M20,25.12c1.25,0.88,3.75,2.25,6.5,1.38c2.75-0.87,7.31-2.38,11.38-4.5c6-3.12,8.42-1.01,4.25,4c-27.13,32.62-23.76,58.5-1.52,62.88c18.07,3.56,37.63-16.38,35.63-56.51c-0.72-14.5-0.17-14.78,4.12-1.75c3.76,11.38,10.26,20.76,16.14,26.5", null), KanjiStrokeItem(2, "M93.87,22.12c-9.62,0-9.25-14.25,0-14.25c9.75,0.01,9.5,14.25,0,14.25", null), KanjiStrokeItem(3, "M27.74,40.79c1.1,1.2,1.61,3.3,1.2,5c-2.3,9.4-3.2,17.79-1.7,27.99c2.22,15.08,0.9,3.1,2.6-1.2c7.19-18.19,21.79-27.59,35.49-27.59c13.5,0,17.49,9.1,17.49,16.2c0,21.89-24.69,23.69-34.39,13.4", null), KanjiStrokeItem(4, "M57.63,33.89c2.1,1.4,2.53,2.5,2.8,5.7c0.7,8.4,1.12,14.97,1.3,23.49c0.4,19.19-5,25.59-9.9,31.39", null)),
            relatedWords = listOf(KanaWord("ぴゅーぴゅー", "pyuupyuu", "suara tiupan angin"))
        ),
        KanaCharacter(
            character = "ぴょ",
            romaji = "pyo",
            category = KanaCategory.YOON,
            strokeCount = 3,
            strokeSteps = listOf("ぴ ditambah ょ kecil"),
            strokes = listOf(KanjiStrokeItem(1, "M20,25.12c1.25,0.88,3.75,2.25,6.5,1.38c2.75-0.87,7.31-2.38,11.38-4.5c6-3.12,8.42-1.01,4.25,4c-27.13,32.62-23.76,58.5-1.52,62.88c18.07,3.56,37.63-16.38,35.63-56.51c-0.72-14.5-0.17-14.78,4.12-1.75c3.76,11.38,10.26,20.76,16.14,26.5", null), KanjiStrokeItem(2, "M93.87,22.12c-9.62,0-9.25-14.25,0-14.25c9.75,0.01,9.5,14.25,0,14.25", null), KanjiStrokeItem(3, "M57.8,50.06c5.98-1.02,10.95-2.09,14.74-3.25c1.99-0.61,3.8-0.91,4.98-0.91", null), KanjiStrokeItem(4, "M54.91,33c1.79,1.69,2.38,3.28,2.29,5.16c-0.6,13.49-0.1,27.68,1.11,42.47c1.5,18.31-27.81,16.56-27.81,9.12c0-9.53,20.92-6.35,28.68-3.27c6.46,2.56,9.18,3.87,14.76,8.23", null)),
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
            strokes = listOf(KanjiStrokeItem(1, "M27,40.5c1.75,0.62,4.77,1.09,7.25,0.38c11.75-3.38,30.62-8.13,37.5-9.88c2.62-0.67,6.75-1.12,9-1", null), KanjiStrokeItem(2, "M19.5,65.8c2.28,0.84,6.24,1.18,9.46,0.17c17.79-5.59,32.67-9.09,49.17-12.99c3.43-0.81,8.81-1.52,11.74-1.35", null), KanjiStrokeItem(3, "M48.87,16.75c2.5,1.75,3.43,3.24,3.88,6.12c2.12,13.62,6.38,45.38,8.25,59.25c0.4,3,1,8.38,1.38,11.12", null), KanjiStrokeItem(4, "M25,56.25c1.67,1.28,4.84,1.85,7.96,1.08c14.85-3.64,26.27-6.16,38.45-9.34c17.31-4.52,1.18,11.21-2.16,15.73", null), KanjiStrokeItem(5, "M41.1,35.5c1.3,1.1,2,2.1,2.5,4.1c0.5,2,9.4,41.62,9.9,43.72c0.5,2.1,1.7,7.2,2.4,9.8", null)),
            relatedWords = listOf(KanaWord("キャベツ", "kyabetsu", "kol/kubis"))
        ),
        KanaCharacter(
            character = "キュ",
            romaji = "kyu",
            category = KanaCategory.YOON,
            strokeCount = 4,
            strokeSteps = listOf("キ ditambah ュ kecil"),
            strokes = listOf(KanjiStrokeItem(1, "M27,40.5c1.75,0.62,4.77,1.09,7.25,0.38c11.75-3.38,30.62-8.13,37.5-9.88c2.62-0.67,6.75-1.12,9-1", null), KanjiStrokeItem(2, "M19.5,65.8c2.28,0.84,6.24,1.18,9.46,0.17c17.79-5.59,32.67-9.09,49.17-12.99c3.43-0.81,8.81-1.52,11.74-1.35", null), KanjiStrokeItem(3, "M48.87,16.75c2.5,1.75,3.43,3.24,3.88,6.12c2.12,13.62,6.38,45.38,8.25,59.25c0.4,3,1,8.38,1.38,11.12", null), KanjiStrokeItem(4, "M34.8,52.84c1.91,1.21,4.13,1.67,7.44,1.21c10.65-1.51,13.99-1.68,21.71-2.97c5.43-0.9,6.26,0.13,5.23,5.12c-1.91,9.25-3.92,19.45-5.23,27.49", null), KanjiStrokeItem(5, "M24.5,86.21c2.21,1.21,3.84,1.73,7.34,1.21c18.54-2.79,28.95-3.12,43.52-3.12c3.02,0,5.93,0.4,8.95,0.9", null)),
            relatedWords = listOf(KanaWord("キュート", "kyuuto", "lucu/imut"))
        ),
        KanaCharacter(
            character = "キョ",
            romaji = "kyo",
            category = KanaCategory.YOON,
            strokeCount = 5,
            strokeSteps = listOf("キ ditambah ョ kecil"),
            strokes = listOf(KanjiStrokeItem(1, "M27,40.5c1.75,0.62,4.77,1.09,7.25,0.38c11.75-3.38,30.62-8.13,37.5-9.88c2.62-0.67,6.75-1.12,9-1", null), KanjiStrokeItem(2, "M19.5,65.8c2.28,0.84,6.24,1.18,9.46,0.17c17.79-5.59,32.67-9.09,49.17-12.99c3.43-0.81,8.81-1.52,11.74-1.35", null), KanjiStrokeItem(3, "M48.87,16.75c2.5,1.75,3.43,3.24,3.88,6.12c2.12,13.62,6.38,45.38,8.25,59.25c0.4,3,1,8.38,1.38,11.12", null), KanjiStrokeItem(4, "M33.5,50.62c1.9,1.21,4.09,1.6,7.39,1.21c11.19-1.32,21.35-2.46,29.07-3.44c4.79-0.61,5.49,0.4,5.2,5.16c-0.79,12.56-1.5,24.79-2.4,34.21", null), KanjiStrokeItem(5, "M33.6,69.04c1.9,1.21,4.09,1.6,7.39,1.21c8.39-0.99,18.23-1.85,24.86-2.47c2.21-0.2,4.21,0.04,6.21,0.44", null), KanjiStrokeItem(6, "M29,90.06c2.2,1.05,3.79,1.36,7.29,1.05c9.99-0.88,23.47-2.35,33.07-2.35c2.7,0,4.49,0,7.49,0.44", null)),
            relatedWords = listOf(KanaWord("キログラム", "kiroguramu", "kilogram"))
        ),
        KanaCharacter(
            character = "シャ",
            romaji = "sha",
            category = KanaCategory.YOON,
            strokeCount = 4,
            strokeSteps = listOf("シ ditambah ャ kecil"),
            strokes = listOf(KanjiStrokeItem(1, "M39.87,19.75c5.14,1.57,9.79,6.01,11.5,8.62", null), KanjiStrokeItem(2, "M26,42.62c3.25,0.88,10.25,5.5,12.25,8.13", null), KanjiStrokeItem(3, "M33,85c3.75,0.88,7.12,0.49,10.38-1.38c17.87-10.24,32.37-23.87,46.12-42.87", null), KanjiStrokeItem(4, "M25,56.25c1.67,1.28,4.84,1.85,7.96,1.08c14.85-3.64,26.27-6.16,38.45-9.34c17.31-4.52,1.18,11.21-2.16,15.73", null), KanjiStrokeItem(5, "M41.1,35.5c1.3,1.1,2,2.1,2.5,4.1c0.5,2,9.4,41.62,9.9,43.72c0.5,2.1,1.7,7.2,2.4,9.8", null)),
            relatedWords = listOf(KanaWord("シャツ", "shatsu", "kemeja"))
        ),
        KanaCharacter(
            character = "シュ",
            romaji = "shu",
            category = KanaCategory.YOON,
            strokeCount = 4,
            strokeSteps = listOf("シ ditambah ュ kecil"),
            strokes = listOf(KanjiStrokeItem(1, "M39.87,19.75c5.14,1.57,9.79,6.01,11.5,8.62", null), KanjiStrokeItem(2, "M26,42.62c3.25,0.88,10.25,5.5,12.25,8.13", null), KanjiStrokeItem(3, "M33,85c3.75,0.88,7.12,0.49,10.38-1.38c17.87-10.24,32.37-23.87,46.12-42.87", null), KanjiStrokeItem(4, "M34.8,52.84c1.91,1.21,4.13,1.67,7.44,1.21c10.65-1.51,13.99-1.68,21.71-2.97c5.43-0.9,6.26,0.13,5.23,5.12c-1.91,9.25-3.92,19.45-5.23,27.49", null), KanjiStrokeItem(5, "M24.5,86.21c2.21,1.21,3.84,1.73,7.34,1.21c18.54-2.79,28.95-3.12,43.52-3.12c3.02,0,5.93,0.4,8.95,0.9", null)),
            relatedWords = listOf(KanaWord("シュークリーム", "shuukuriimu", "kue sus"))
        ),
        KanaCharacter(
            character = "ショ",
            romaji = "sho",
            category = KanaCategory.YOON,
            strokeCount = 5,
            strokeSteps = listOf("シ ditambah ョ kecil"),
            strokes = listOf(KanjiStrokeItem(1, "M39.87,19.75c5.14,1.57,9.79,6.01,11.5,8.62", null), KanjiStrokeItem(2, "M26,42.62c3.25,0.88,10.25,5.5,12.25,8.13", null), KanjiStrokeItem(3, "M33,85c3.75,0.88,7.12,0.49,10.38-1.38c17.87-10.24,32.37-23.87,46.12-42.87", null), KanjiStrokeItem(4, "M33.5,50.62c1.9,1.21,4.09,1.6,7.39,1.21c11.19-1.32,21.35-2.46,29.07-3.44c4.79-0.61,5.49,0.4,5.2,5.16c-0.79,12.56-1.5,24.79-2.4,34.21", null), KanjiStrokeItem(5, "M33.6,69.04c1.9,1.21,4.09,1.6,7.39,1.21c8.39-0.99,18.23-1.85,24.86-2.47c2.21-0.2,4.21,0.04,6.21,0.44", null), KanjiStrokeItem(6, "M29,90.06c2.2,1.05,3.79,1.36,7.29,1.05c9.99-0.88,23.47-2.35,33.07-2.35c2.7,0,4.49,0,7.49,0.44", null)),
            relatedWords = listOf(KanaWord("ショップ", "shoppu", "toko"))
        ),
        KanaCharacter(
            character = "チャ",
            romaji = "cha",
            category = KanaCategory.YOON,
            strokeCount = 4,
            strokeSteps = listOf("チ ditambah ャ kecil"),
            strokes = listOf(KanjiStrokeItem(1, "M69.76,15.25c-0.38,2.62-2.01,4.37-3.88,5.38c-7.88,4.25-18.62,9.75-35.5,13.25", null), KanjiStrokeItem(2, "M18.5,51.5c2.88,0.88,4.39,1.65,7.88,1.25c22-2.5,36.38-4.25,56.12-4.88c4.88-0.15,7.88,0.51,10.88,1.51", null), KanjiStrokeItem(3, "M54.88,30.75c0.88,0.75,1.75,2.49,1.75,4.75c0,6.03,0.03,11.25,0.03,18.27c0,14.98-5.03,29.48-16.53,39.23", null), KanjiStrokeItem(4, "M25,56.25c1.67,1.28,4.84,1.85,7.96,1.08c14.85-3.64,26.27-6.16,38.45-9.34c17.31-4.52,1.18,11.21-2.16,15.73", null), KanjiStrokeItem(5, "M41.1,35.5c1.3,1.1,2,2.1,2.5,4.1c0.5,2,9.4,41.62,9.9,43.72c0.5,2.1,1.7,7.2,2.4,9.8", null)),
            relatedWords = listOf(KanaWord("チャンス", "chansu", "kesempatan"))
        ),
        KanaCharacter(
            character = "チュ",
            romaji = "chu",
            category = KanaCategory.YOON,
            strokeCount = 4,
            strokeSteps = listOf("チ ditambah ュ kecil"),
            strokes = listOf(KanjiStrokeItem(1, "M69.76,15.25c-0.38,2.62-2.01,4.37-3.88,5.38c-7.88,4.25-18.62,9.75-35.5,13.25", null), KanjiStrokeItem(2, "M18.5,51.5c2.88,0.88,4.39,1.65,7.88,1.25c22-2.5,36.38-4.25,56.12-4.88c4.88-0.15,7.88,0.51,10.88,1.51", null), KanjiStrokeItem(3, "M54.88,30.75c0.88,0.75,1.75,2.49,1.75,4.75c0,6.03,0.03,11.25,0.03,18.27c0,14.98-5.03,29.48-16.53,39.23", null), KanjiStrokeItem(4, "M34.8,52.84c1.91,1.21,4.13,1.67,7.44,1.21c10.65-1.51,13.99-1.68,21.71-2.97c5.43-0.9,6.26,0.13,5.23,5.12c-1.91,9.25-3.92,19.45-5.23,27.49", null), KanjiStrokeItem(5, "M24.5,86.21c2.21,1.21,3.84,1.73,7.34,1.21c18.54-2.79,28.95-3.12,43.52-3.12c3.02,0,5.93,0.4,8.95,0.9", null)),
            relatedWords = listOf(KanaWord("チューブ", "chuubu", "tabung/pipa"))
        ),
        KanaCharacter(
            character = "チョ",
            romaji = "cho",
            category = KanaCategory.YOON,
            strokeCount = 5,
            strokeSteps = listOf("チ ditambah ョ kecil"),
            strokes = listOf(KanjiStrokeItem(1, "M69.76,15.25c-0.38,2.62-2.01,4.37-3.88,5.38c-7.88,4.25-18.62,9.75-35.5,13.25", null), KanjiStrokeItem(2, "M18.5,51.5c2.88,0.88,4.39,1.65,7.88,1.25c22-2.5,36.38-4.25,56.12-4.88c4.88-0.15,7.88,0.51,10.88,1.51", null), KanjiStrokeItem(3, "M54.88,30.75c0.88,0.75,1.75,2.49,1.75,4.75c0,6.03,0.03,11.25,0.03,18.27c0,14.98-5.03,29.48-16.53,39.23", null), KanjiStrokeItem(4, "M33.5,50.62c1.9,1.21,4.09,1.6,7.39,1.21c11.19-1.32,21.35-2.46,29.07-3.44c4.79-0.61,5.49,0.4,5.2,5.16c-0.79,12.56-1.5,24.79-2.4,34.21", null), KanjiStrokeItem(5, "M33.6,69.04c1.9,1.21,4.09,1.6,7.39,1.21c8.39-0.99,18.23-1.85,24.86-2.47c2.21-0.2,4.21,0.04,6.21,0.44", null), KanjiStrokeItem(6, "M29,90.06c2.2,1.05,3.79,1.36,7.29,1.05c9.99-0.88,23.47-2.35,33.07-2.35c2.7,0,4.49,0,7.49,0.44", null)),
            relatedWords = listOf(KanaWord("チョコレート", "chokoreeto", "cokelat"))
        ),
        KanaCharacter(
            character = "ニャ",
            romaji = "nya",
            category = KanaCategory.YOON,
            strokeCount = 3,
            strokeSteps = listOf("ニ ditambah ャ kecil"),
            strokes = listOf(KanjiStrokeItem(1, "M32.63,34.69c2.5,1.19,4.33,1.6,7.45,1.35c11.55-0.91,18.3-2.41,27.04-3.18c2.64-0.23,6.27-0.16,8.39,0.08", null), KanjiStrokeItem(2, "M20,74.88c2.62,1,4.78,1.45,9.12,0.75c20.25-3.25,36.5-3.88,52.38-3.88c3.75,0,8,1,11.12,2.38", null), KanjiStrokeItem(3, "M25,56.25c1.67,1.28,4.84,1.85,7.96,1.08c14.85-3.64,26.27-6.16,38.45-9.34c17.31-4.52,1.18,11.21-2.16,15.73", null), KanjiStrokeItem(4, "M41.1,35.5c1.3,1.1,2,2.1,2.5,4.1c0.5,2,9.4,41.62,9.9,43.72c0.5,2.1,1.7,7.2,2.4,9.8", null)),
            relatedWords = listOf(KanaWord("ニャー", "nyaa", "meong"))
        ),
        KanaCharacter(
            character = "ニュ",
            romaji = "nyu",
            category = KanaCategory.YOON,
            strokeCount = 3,
            strokeSteps = listOf("ニ ditambah ュ kecil"),
            strokes = listOf(KanjiStrokeItem(1, "M32.63,34.69c2.5,1.19,4.33,1.6,7.45,1.35c11.55-0.91,18.3-2.41,27.04-3.18c2.64-0.23,6.27-0.16,8.39,0.08", null), KanjiStrokeItem(2, "M20,74.88c2.62,1,4.78,1.45,9.12,0.75c20.25-3.25,36.5-3.88,52.38-3.88c3.75,0,8,1,11.12,2.38", null), KanjiStrokeItem(3, "M34.8,52.84c1.91,1.21,4.13,1.67,7.44,1.21c10.65-1.51,13.99-1.68,21.71-2.97c5.43-0.9,6.26,0.13,5.23,5.12c-1.91,9.25-3.92,19.45-5.23,27.49", null), KanjiStrokeItem(4, "M24.5,86.21c2.21,1.21,3.84,1.73,7.34,1.21c18.54-2.79,28.95-3.12,43.52-3.12c3.02,0,5.93,0.4,8.95,0.9", null)),
            relatedWords = listOf(KanaWord("ニュース", "nyuusu", "berita"))
        ),
        KanaCharacter(
            character = "ニョ",
            romaji = "nyo",
            category = KanaCategory.YOON,
            strokeCount = 4,
            strokeSteps = listOf("ニ ditambah ュ kecil"),
            strokes = listOf(KanjiStrokeItem(1, "M32.63,34.69c2.5,1.19,4.33,1.6,7.45,1.35c11.55-0.91,18.3-2.41,27.04-3.18c2.64-0.23,6.27-0.16,8.39,0.08", null), KanjiStrokeItem(2, "M20,74.88c2.62,1,4.78,1.45,9.12,0.75c20.25-3.25,36.5-3.88,52.38-3.88c3.75,0,8,1,11.12,2.38", null), KanjiStrokeItem(3, "M33.5,50.62c1.9,1.21,4.09,1.6,7.39,1.21c11.19-1.32,21.35-2.46,29.07-3.44c4.79-0.61,5.49,0.4,5.2,5.16c-0.79,12.56-1.5,24.79-2.4,34.21", null), KanjiStrokeItem(4, "M33.6,69.04c1.9,1.21,4.09,1.6,7.39,1.21c8.39-0.99,18.23-1.85,24.86-2.47c2.21-0.2,4.21,0.04,6.21,0.44", null), KanjiStrokeItem(5, "M29,90.06c2.2,1.05,3.79,1.36,7.29,1.05c9.99-0.88,23.47-2.35,33.07-2.35c2.7,0,4.49,0,7.49,0.44", null)),
            relatedWords = listOf(KanaWord("ニョッキ", "nyokki", "gnocchi"))
        ),
        KanaCharacter(
            character = "ヒャ",
            romaji = "hya",
            category = KanaCategory.YOON,
            strokeCount = 3,
            strokeSteps = listOf("ヒ ditambah ャ kecil"),
            strokes = listOf(KanjiStrokeItem(1, "M35.38,44.5c1.75,1.38,4.51,2.19,6.88,1.88c10.24-1.38,17.24-2.88,24.24-4.26c3.01-0.59,7.12-1,9.38-0.88", null), KanjiStrokeItem(2, "M31,17.62c1.38,1.26,1.88,3.38,1.88,6.13c0,2.75-0.88,44-0.88,47.25c0,9.75,4,14.62,13.75,14.62c6,0,16.38,0.12,21.38,0c5-0.12,9.5-0.62,13.5-1.5", null), KanjiStrokeItem(3, "M25,56.25c1.67,1.28,4.84,1.85,7.96,1.08c14.85-3.64,26.27-6.16,38.45-9.34c17.31-4.52,1.18,11.21-2.16,15.73", null), KanjiStrokeItem(4, "M41.1,35.5c1.3,1.1,2,2.1,2.5,4.1c0.5,2,9.4,41.62,9.9,43.72c0.5,2.1,1.7,7.2,2.4,9.8", null)),
            relatedWords = listOf(KanaWord("ヒャ", "hya", "hya"))
        ),
        KanaCharacter(
            character = "ヒュ",
            romaji = "hyu",
            category = KanaCategory.YOON,
            strokeCount = 3,
            strokeSteps = listOf("ヒ ditambah ュ kecil"),
            strokes = listOf(KanjiStrokeItem(1, "M35.38,44.5c1.75,1.38,4.51,2.19,6.88,1.88c10.24-1.38,17.24-2.88,24.24-4.26c3.01-0.59,7.12-1,9.38-0.88", null), KanjiStrokeItem(2, "M31,17.62c1.38,1.26,1.88,3.38,1.88,6.13c0,2.75-0.88,44-0.88,47.25c0,9.75,4,14.62,13.75,14.62c6,0,16.38,0.12,21.38,0c5-0.12,9.5-0.62,13.5-1.5", null), KanjiStrokeItem(3, "M34.8,52.84c1.91,1.21,4.13,1.67,7.44,1.21c10.65-1.51,13.99-1.68,21.71-2.97c5.43-0.9,6.26,0.13,5.23,5.12c-1.91,9.25-3.92,19.45-5.23,27.49", null), KanjiStrokeItem(4, "M24.5,86.21c2.21,1.21,3.84,1.73,7.34,1.21c18.54-2.79,28.95-3.12,43.52-3.12c3.02,0,5.93,0.4,8.95,0.9", null)),
            relatedWords = listOf(KanaWord("ヒューズ", "hyuuzu", "sekring"))
        ),
        KanaCharacter(
            character = "ヒョ",
            romaji = "hyo",
            category = KanaCategory.YOON,
            strokeCount = 4,
            strokeSteps = listOf("ヒ ditambah ョ kecil"),
            strokes = listOf(KanjiStrokeItem(1, "M35.38,44.5c1.75,1.38,4.51,2.19,6.88,1.88c10.24-1.38,17.24-2.88,24.24-4.26c3.01-0.59,7.12-1,9.38-0.88", null), KanjiStrokeItem(2, "M31,17.62c1.38,1.26,1.88,3.38,1.88,6.13c0,2.75-0.88,44-0.88,47.25c0,9.75,4,14.62,13.75,14.62c6,0,16.38,0.12,21.38,0c5-0.12,9.5-0.62,13.5-1.5", null), KanjiStrokeItem(3, "M33.5,50.62c1.9,1.21,4.09,1.6,7.39,1.21c11.19-1.32,21.35-2.46,29.07-3.44c4.79-0.61,5.49,0.4,5.2,5.16c-0.79,12.56-1.5,24.79-2.4,34.21", null), KanjiStrokeItem(4, "M33.6,69.04c1.9,1.21,4.09,1.6,7.39,1.21c8.39-0.99,18.23-1.85,24.86-2.47c2.21-0.2,4.21,0.04,6.21,0.44", null), KanjiStrokeItem(5, "M29,90.06c2.2,1.05,3.79,1.36,7.29,1.05c9.99-0.88,23.47-2.35,33.07-2.35c2.7,0,4.49,0,7.49,0.44", null)),
            relatedWords = listOf(KanaWord("ヒョ", "hyo", "hyo"))
        ),
        KanaCharacter(
            character = "ミャ",
            romaji = "mya",
            category = KanaCategory.YOON,
            strokeCount = 4,
            strokeSteps = listOf("ミ ditambah ャ kecil"),
            strokes = listOf(KanjiStrokeItem(1, "M41.87,20c10.4,2.57,20.5,6.3,25,10.38", null), KanjiStrokeItem(2, "M42,46.88c10.72,2.69,21.11,6.6,25.75,10.88", null), KanjiStrokeItem(3, "M36.5,75c15.71,4.49,30.95,11,37.75,18.12", null), KanjiStrokeItem(4, "M25,56.25c1.67,1.28,4.84,1.85,7.96,1.08c14.85-3.64,26.27-6.16,38.45-9.34c17.31-4.52,1.18,11.21-2.16,15.73", null), KanjiStrokeItem(5, "M41.1,35.5c1.3,1.1,2,2.1,2.5,4.1c0.5,2,9.4,41.62,9.9,43.72c0.5,2.1,1.7,7.2,2.4,9.8", null)),
            relatedWords = listOf(KanaWord("ミャンマー", "myanmaa", "negara Myanmar"))
        ),
        KanaCharacter(
            character = "ミュ",
            romaji = "myu",
            category = KanaCategory.YOON,
            strokeCount = 4,
            strokeSteps = listOf("ミ ditambah ュ kecil"),
            strokes = listOf(KanjiStrokeItem(1, "M41.87,20c10.4,2.57,20.5,6.3,25,10.38", null), KanjiStrokeItem(2, "M42,46.88c10.72,2.69,21.11,6.6,25.75,10.88", null), KanjiStrokeItem(3, "M36.5,75c15.71,4.49,30.95,11,37.75,18.12", null), KanjiStrokeItem(4, "M34.8,52.84c1.91,1.21,4.13,1.67,7.44,1.21c10.65-1.51,13.99-1.68,21.71-2.97c5.43-0.9,6.26,0.13,5.23,5.12c-1.91,9.25-3.92,19.45-5.23,27.49", null), KanjiStrokeItem(5, "M24.5,86.21c2.21,1.21,3.84,1.73,7.34,1.21c18.54-2.79,28.95-3.12,43.52-3.12c3.02,0,5.93,0.4,8.95,0.9", null)),
            relatedWords = listOf(KanaWord("ミュージアム", "myuujiamu", "museum"))
        ),
        KanaCharacter(
            character = "ミョ",
            romaji = "myo",
            category = KanaCategory.YOON,
            strokeCount = 5,
            strokeSteps = listOf("ミ ditambah ョ kecil"),
            strokes = listOf(KanjiStrokeItem(1, "M41.87,20c10.4,2.57,20.5,6.3,25,10.38", null), KanjiStrokeItem(2, "M42,46.88c10.72,2.69,21.11,6.6,25.75,10.88", null), KanjiStrokeItem(3, "M36.5,75c15.71,4.49,30.95,11,37.75,18.12", null), KanjiStrokeItem(4, "M33.5,50.62c1.9,1.21,4.09,1.6,7.39,1.21c11.19-1.32,21.35-2.46,29.07-3.44c4.79-0.61,5.49,0.4,5.2,5.16c-0.79,12.56-1.5,24.79-2.4,34.21", null), KanjiStrokeItem(5, "M33.6,69.04c1.9,1.21,4.09,1.6,7.39,1.21c8.39-0.99,18.23-1.85,24.86-2.47c2.21-0.2,4.21,0.04,6.21,0.44", null), KanjiStrokeItem(6, "M29,90.06c2.2,1.05,3.79,1.36,7.29,1.05c9.99-0.88,23.47-2.35,33.07-2.35c2.7,0,4.49,0,7.49,0.44", null)),
            relatedWords = listOf(KanaWord("ミョ", "myo", "myo"))
        ),
        KanaCharacter(
            character = "リャ",
            romaji = "rya",
            category = KanaCategory.YOON,
            strokeCount = 3,
            strokeSteps = listOf("リ ditambah ャ kecil"),
            strokes = listOf(KanjiStrokeItem(1, "M35,18.38c1.12,1.5,1.62,3,1.62,4.88c0,1.88,0,25,0,27c0,2,0,6.12,0,7.75", null), KanjiStrokeItem(2, "M71,15.38c1.5,1.25,2.38,3.12,2.38,5.38c0,2.26-0.12,28.88-0.12,32.88c0,19.62-9.5,32.25-21.75,40.38", null), KanjiStrokeItem(3, "M25,56.25c1.67,1.28,4.84,1.85,7.96,1.08c14.85-3.64,26.27-6.16,38.45-9.34c17.31-4.52,1.18,11.21-2.16,15.73", null), KanjiStrokeItem(4, "M41.1,35.5c1.3,1.1,2,2.1,2.5,4.1c0.5,2,9.4,41.62,9.9,43.72c0.5,2.1,1.7,7.2,2.4,9.8", null)),
            relatedWords = listOf(KanaWord("リャ", "rya", "rya"))
        ),
        KanaCharacter(
            character = "リュ",
            romaji = "ryu",
            category = KanaCategory.YOON,
            strokeCount = 3,
            strokeSteps = listOf("リ ditambah ュ kecil"),
            strokes = listOf(KanjiStrokeItem(1, "M35,18.38c1.12,1.5,1.62,3,1.62,4.88c0,1.88,0,25,0,27c0,2,0,6.12,0,7.75", null), KanjiStrokeItem(2, "M71,15.38c1.5,1.25,2.38,3.12,2.38,5.38c0,2.26-0.12,28.88-0.12,32.88c0,19.62-9.5,32.25-21.75,40.38", null), KanjiStrokeItem(3, "M34.8,52.84c1.91,1.21,4.13,1.67,7.44,1.21c10.65-1.51,13.99-1.68,21.71-2.97c5.43-0.9,6.26,0.13,5.23,5.12c-1.91,9.25-3.92,19.45-5.23,27.49", null), KanjiStrokeItem(4, "M24.5,86.21c2.21,1.21,3.84,1.73,7.34,1.21c18.54-2.79,28.95-3.12,43.52-3.12c3.02,0,5.93,0.4,8.95,0.9", null)),
            relatedWords = listOf(KanaWord("リュック", "ryukku", "tas ransel"))
        ),
        KanaCharacter(
            character = "リョ",
            romaji = "ryo",
            category = KanaCategory.YOON,
            strokeCount = 4,
            strokeSteps = listOf("リ ditambah ョ kecil"),
            strokes = listOf(KanjiStrokeItem(1, "M35,18.38c1.12,1.5,1.62,3,1.62,4.88c0,1.88,0,25,0,27c0,2,0,6.12,0,7.75", null), KanjiStrokeItem(2, "M71,15.38c1.5,1.25,2.38,3.12,2.38,5.38c0,2.26-0.12,28.88-0.12,32.88c0,19.62-9.5,32.25-21.75,40.38", null), KanjiStrokeItem(3, "M33.5,50.62c1.9,1.21,4.09,1.6,7.39,1.21c11.19-1.32,21.35-2.46,29.07-3.44c4.79-0.61,5.49,0.4,5.2,5.16c-0.79,12.56-1.5,24.79-2.4,34.21", null), KanjiStrokeItem(4, "M33.6,69.04c1.9,1.21,4.09,1.6,7.39,1.21c8.39-0.99,18.23-1.85,24.86-2.47c2.21-0.2,4.21,0.04,6.21,0.44", null), KanjiStrokeItem(5, "M29,90.06c2.2,1.05,3.79,1.36,7.29,1.05c9.99-0.88,23.47-2.35,33.07-2.35c2.7,0,4.49,0,7.49,0.44", null)),
            relatedWords = listOf(KanaWord("リョ", "ryo", "ryo"))
        ),
        KanaCharacter(
            character = "ギャ",
            romaji = "gya",
            category = KanaCategory.YOON,
            strokeCount = 6,
            strokeSteps = listOf("ギ ditambah ャ kecil"),
            strokes = listOf(KanjiStrokeItem(1, "M27,40.5c1.75,0.62,4.77,1.09,7.25,0.38c11.75-3.38,30.62-8.13,37.5-9.88c2.62-0.67,6.75-1.12,9-1", null), KanjiStrokeItem(2, "M19.5,65.8c2.28,0.84,6.24,1.18,9.46,0.17c17.79-5.59,32.67-9.09,49.17-12.99c3.43-0.81,8.81-1.52,11.74-1.35", null), KanjiStrokeItem(3, "M48.87,16.75c2.5,1.75,3.43,3.24,3.88,6.12c2.12,13.62,6.38,45.38,8.25,59.25c0.4,3,1,8.38,1.38,11.12", null), KanjiStrokeItem(4, "M81.87,15.13c2.75,1.93,6,5.93,7.75,9.37", null), KanjiStrokeItem(5, "M88.25,10c2.71,1.73,5.9,5.32,7.62,8.41", null), KanjiStrokeItem(6, "M25,56.25c1.67,1.28,4.84,1.85,7.96,1.08c14.85-3.64,26.27-6.16,38.45-9.34c17.31-4.52,1.18,11.21-2.16,15.73", null), KanjiStrokeItem(7, "M41.1,35.5c1.3,1.1,2,2.1,2.5,4.1c0.5,2,9.4,41.62,9.9,43.72c0.5,2.1,1.7,7.2,2.4,9.8", null)),
            relatedWords = listOf(KanaWord("ギャグ", "gyagu", "lelucon/lawakan"))
        ),
        KanaCharacter(
            character = "ギュ",
            romaji = "gyu",
            category = KanaCategory.YOON,
            strokeCount = 6,
            strokeSteps = listOf("ギ ditambah ュ kecil"),
            strokes = listOf(KanjiStrokeItem(1, "M27,40.5c1.75,0.62,4.77,1.09,7.25,0.38c11.75-3.38,30.62-8.13,37.5-9.88c2.62-0.67,6.75-1.12,9-1", null), KanjiStrokeItem(2, "M19.5,65.8c2.28,0.84,6.24,1.18,9.46,0.17c17.79-5.59,32.67-9.09,49.17-12.99c3.43-0.81,8.81-1.52,11.74-1.35", null), KanjiStrokeItem(3, "M48.87,16.75c2.5,1.75,3.43,3.24,3.88,6.12c2.12,13.62,6.38,45.38,8.25,59.25c0.4,3,1,8.38,1.38,11.12", null), KanjiStrokeItem(4, "M81.87,15.13c2.75,1.93,6,5.93,7.75,9.37", null), KanjiStrokeItem(5, "M88.25,10c2.71,1.73,5.9,5.32,7.62,8.41", null), KanjiStrokeItem(6, "M34.8,52.84c1.91,1.21,4.13,1.67,7.44,1.21c10.65-1.51,13.99-1.68,21.71-2.97c5.43-0.9,6.26,0.13,5.23,5.12c-1.91,9.25-3.92,19.45-5.23,27.49", null), KanjiStrokeItem(7, "M24.5,86.21c2.21,1.21,3.84,1.73,7.34,1.21c18.54-2.79,28.95-3.12,43.52-3.12c3.02,0,5.93,0.4,8.95,0.9", null)),
            relatedWords = listOf(KanaWord("ギュ", "gyu", "gyu"))
        ),
        KanaCharacter(
            character = "ギョ",
            romaji = "gyo",
            category = KanaCategory.YOON,
            strokeCount = 7,
            strokeSteps = listOf("ギ ditambah ョ kecil"),
            strokes = listOf(KanjiStrokeItem(1, "M27,40.5c1.75,0.62,4.77,1.09,7.25,0.38c11.75-3.38,30.62-8.13,37.5-9.88c2.62-0.67,6.75-1.12,9-1", null), KanjiStrokeItem(2, "M19.5,65.8c2.28,0.84,6.24,1.18,9.46,0.17c17.79-5.59,32.67-9.09,49.17-12.99c3.43-0.81,8.81-1.52,11.74-1.35", null), KanjiStrokeItem(3, "M48.87,16.75c2.5,1.75,3.43,3.24,3.88,6.12c2.12,13.62,6.38,45.38,8.25,59.25c0.4,3,1,8.38,1.38,11.12", null), KanjiStrokeItem(4, "M81.87,15.13c2.75,1.93,6,5.93,7.75,9.37", null), KanjiStrokeItem(5, "M88.25,10c2.71,1.73,5.9,5.32,7.62,8.41", null), KanjiStrokeItem(6, "M33.5,50.62c1.9,1.21,4.09,1.6,7.39,1.21c11.19-1.32,21.35-2.46,29.07-3.44c4.79-0.61,5.49,0.4,5.2,5.16c-0.79,12.56-1.5,24.79-2.4,34.21", null), KanjiStrokeItem(7, "M33.6,69.04c1.9,1.21,4.09,1.6,7.39,1.21c8.39-0.99,18.23-1.85,24.86-2.47c2.21-0.2,4.21,0.04,6.21,0.44", null), KanjiStrokeItem(8, "M29,90.06c2.2,1.05,3.79,1.36,7.29,1.05c9.99-0.88,23.47-2.35,33.07-2.35c2.7,0,4.49,0,7.49,0.44", null)),
            relatedWords = listOf(KanaWord("ギョーザ", "gyooza", "pangsit gyoza"))
        ),
        KanaCharacter(
            character = "ジャ",
            romaji = "ja",
            category = KanaCategory.YOON,
            strokeCount = 6,
            strokeSteps = listOf("ジ ditambah ャ kecil"),
            strokes = listOf(KanjiStrokeItem(1, "M39.87,19.75c5.14,1.57,9.79,6.01,11.5,8.62", null), KanjiStrokeItem(2, "M26,42.62c3.25,0.88,10.25,5.5,12.25,8.13", null), KanjiStrokeItem(3, "M33,85c3.62,1.62,6.5,0.88,10.38-1.38c17.81-10.34,32.37-23.87,46.12-42.87", null), KanjiStrokeItem(4, "M78.5,18.98c2.85,1.78,6.21,5.47,8.03,8.65", null), KanjiStrokeItem(5, "M85.25,14.38c2.93,1.57,6.39,4.83,8.25,7.63", null), KanjiStrokeItem(6, "M25,56.25c1.67,1.28,4.84,1.85,7.96,1.08c14.85-3.64,26.27-6.16,38.45-9.34c17.31-4.52,1.18,11.21-2.16,15.73", null), KanjiStrokeItem(7, "M41.1,35.5c1.3,1.1,2,2.1,2.5,4.1c0.5,2,9.4,41.62,9.9,43.72c0.5,2.1,1.7,7.2,2.4,9.8", null)),
            relatedWords = listOf(KanaWord("ジャケット", "jaketto", "jaket"))
        ),
        KanaCharacter(
            character = "ジュ",
            romaji = "ju",
            category = KanaCategory.YOON,
            strokeCount = 6,
            strokeSteps = listOf("ジ ditambah ュ kecil"),
            strokes = listOf(KanjiStrokeItem(1, "M39.87,19.75c5.14,1.57,9.79,6.01,11.5,8.62", null), KanjiStrokeItem(2, "M26,42.62c3.25,0.88,10.25,5.5,12.25,8.13", null), KanjiStrokeItem(3, "M33,85c3.62,1.62,6.5,0.88,10.38-1.38c17.81-10.34,32.37-23.87,46.12-42.87", null), KanjiStrokeItem(4, "M78.5,18.98c2.85,1.78,6.21,5.47,8.03,8.65", null), KanjiStrokeItem(5, "M85.25,14.38c2.93,1.57,6.39,4.83,8.25,7.63", null), KanjiStrokeItem(6, "M34.8,52.84c1.91,1.21,4.13,1.67,7.44,1.21c10.65-1.51,13.99-1.68,21.71-2.97c5.43-0.9,6.26,0.13,5.23,5.12c-1.91,9.25-3.92,19.45-5.23,27.49", null), KanjiStrokeItem(7, "M24.5,86.21c2.21,1.21,3.84,1.73,7.34,1.21c18.54-2.79,28.95-3.12,43.52-3.12c3.02,0,5.93,0.4,8.95,0.9", null)),
            relatedWords = listOf(KanaWord("ジュース", "juusu", "minuman jus"))
        ),
        KanaCharacter(
            character = "ジョ",
            romaji = "jo",
            category = KanaCategory.YOON,
            strokeCount = 7,
            strokeSteps = listOf("ジ ditambah ョ kecil"),
            strokes = listOf(KanjiStrokeItem(1, "M39.87,19.75c5.14,1.57,9.79,6.01,11.5,8.62", null), KanjiStrokeItem(2, "M26,42.62c3.25,0.88,10.25,5.5,12.25,8.13", null), KanjiStrokeItem(3, "M33,85c3.62,1.62,6.5,0.88,10.38-1.38c17.81-10.34,32.37-23.87,46.12-42.87", null), KanjiStrokeItem(4, "M78.5,18.98c2.85,1.78,6.21,5.47,8.03,8.65", null), KanjiStrokeItem(5, "M85.25,14.38c2.93,1.57,6.39,4.83,8.25,7.63", null), KanjiStrokeItem(6, "M33.5,50.62c1.9,1.21,4.09,1.6,7.39,1.21c11.19-1.32,21.35-2.46,29.07-3.44c4.79-0.61,5.49,0.4,5.2,5.16c-0.79,12.56-1.5,24.79-2.4,34.21", null), KanjiStrokeItem(7, "M33.6,69.04c1.9,1.21,4.09,1.6,7.39,1.21c8.39-0.99,18.23-1.85,24.86-2.47c2.21-0.2,4.21,0.04,6.21,0.44", null), KanjiStrokeItem(8, "M29,90.06c2.2,1.05,3.79,1.36,7.29,1.05c9.99-0.88,23.47-2.35,33.07-2.35c2.7,0,4.49,0,7.49,0.44", null)),
            relatedWords = listOf(KanaWord("ジョギング", "jogingu", "lari santai/jogging"))
        ),
        KanaCharacter(
            character = "ビャ",
            romaji = "bya",
            category = KanaCategory.YOON,
            strokeCount = 5,
            strokeSteps = listOf("ビ ditambah ャ kecil"),
            strokes = listOf(KanjiStrokeItem(1, "M35.38,44.5c1.75,1.38,4.51,2.19,6.88,1.88c10.24-1.38,17.24-2.88,24.24-4.26c3.01-0.59,7.12-1,9.38-0.88", null), KanjiStrokeItem(2, "M31,17.62c1.38,1.26,1.88,3.38,1.88,6.13c0,2.75-0.88,44-0.88,47.25c0,9.75,4,14.62,13.75,14.62c6,0,16.38,0.12,21.38,0c5-0.12,9.5-0.62,13.5-1.5", null), KanjiStrokeItem(3, "M78.13,26.25c2.75,1.75,6,5.38,7.75,8.5", null), KanjiStrokeItem(4, "M84.5,21.38c3.06,1.57,6.68,4.82,8.62,7.62", null), KanjiStrokeItem(5, "M25,56.25c1.67,1.28,4.84,1.85,7.96,1.08c14.85-3.64,26.27-6.16,38.45-9.34c17.31-4.52,1.18,11.21-2.16,15.73", null), KanjiStrokeItem(6, "M41.1,35.5c1.3,1.1,2,2.1,2.5,4.1c0.5,2,9.4,41.62,9.9,43.72c0.5,2.1,1.7,7.2,2.4,9.8", null)),
            relatedWords = listOf(KanaWord("ビャ", "bya", "bya"))
        ),
        KanaCharacter(
            character = "ビュ",
            romaji = "byu",
            category = KanaCategory.YOON,
            strokeCount = 5,
            strokeSteps = listOf("ビ ditambah ュ kecil"),
            strokes = listOf(KanjiStrokeItem(1, "M35.38,44.5c1.75,1.38,4.51,2.19,6.88,1.88c10.24-1.38,17.24-2.88,24.24-4.26c3.01-0.59,7.12-1,9.38-0.88", null), KanjiStrokeItem(2, "M31,17.62c1.38,1.26,1.88,3.38,1.88,6.13c0,2.75-0.88,44-0.88,47.25c0,9.75,4,14.62,13.75,14.62c6,0,16.38,0.12,21.38,0c5-0.12,9.5-0.62,13.5-1.5", null), KanjiStrokeItem(3, "M78.13,26.25c2.75,1.75,6,5.38,7.75,8.5", null), KanjiStrokeItem(4, "M84.5,21.38c3.06,1.57,6.68,4.82,8.62,7.62", null), KanjiStrokeItem(5, "M34.8,52.84c1.91,1.21,4.13,1.67,7.44,1.21c10.65-1.51,13.99-1.68,21.71-2.97c5.43-0.9,6.26,0.13,5.23,5.12c-1.91,9.25-3.92,19.45-5.23,27.49", null), KanjiStrokeItem(6, "M24.5,86.21c2.21,1.21,3.84,1.73,7.34,1.21c18.54-2.79,28.95-3.12,43.52-3.12c3.02,0,5.93,0.4,8.95,0.9", null)),
            relatedWords = listOf(KanaWord("ビュッフェ", "byuffe", "prasmanan"))
        ),
        KanaCharacter(
            character = "ビョ",
            romaji = "byo",
            category = KanaCategory.YOON,
            strokeCount = 6,
            strokeSteps = listOf("ビ ditambah ョ kecil"),
            strokes = listOf(KanjiStrokeItem(1, "M35.38,44.5c1.75,1.38,4.51,2.19,6.88,1.88c10.24-1.38,17.24-2.88,24.24-4.26c3.01-0.59,7.12-1,9.38-0.88", null), KanjiStrokeItem(2, "M31,17.62c1.38,1.26,1.88,3.38,1.88,6.13c0,2.75-0.88,44-0.88,47.25c0,9.75,4,14.62,13.75,14.62c6,0,16.38,0.12,21.38,0c5-0.12,9.5-0.62,13.5-1.5", null), KanjiStrokeItem(3, "M78.13,26.25c2.75,1.75,6,5.38,7.75,8.5", null), KanjiStrokeItem(4, "M84.5,21.38c3.06,1.57,6.68,4.82,8.62,7.62", null), KanjiStrokeItem(5, "M33.5,50.62c1.9,1.21,4.09,1.6,7.39,1.21c11.19-1.32,21.35-2.46,29.07-3.44c4.79-0.61,5.49,0.4,5.2,5.16c-0.79,12.56-1.5,24.79-2.4,34.21", null), KanjiStrokeItem(6, "M33.6,69.04c1.9,1.21,4.09,1.6,7.39,1.21c8.39-0.99,18.23-1.85,24.86-2.47c2.21-0.2,4.21,0.04,6.21,0.44", null), KanjiStrokeItem(7, "M29,90.06c2.2,1.05,3.79,1.36,7.29,1.05c9.99-0.88,23.47-2.35,33.07-2.35c2.7,0,4.49,0,7.49,0.44", null)),
            relatedWords = listOf(KanaWord("ビョ", "byo", "byo"))
        ),
        KanaCharacter(
            character = "ピャ",
            romaji = "pya",
            category = KanaCategory.YOON,
            strokeCount = 4,
            strokeSteps = listOf("ピ ditambah ャ kecil"),
            strokes = listOf(KanjiStrokeItem(1, "M35.38,44.5c1.75,1.38,4.51,2.19,6.88,1.88c10.24-1.38,17.24-2.88,24.24-4.26c3.01-0.59,7.12-1,9.38-0.88", null), KanjiStrokeItem(2, "M31,17.62c1.38,1.26,1.88,3.38,1.88,6.13c0,2.75-0.88,44-0.88,47.25c0,9.75,4,14.62,13.75,14.62c6,0,16.38,0.12,21.38,0c5-0.12,9.5-0.62,13.5-1.5", null), KanjiStrokeItem(3, "M83,32.88c-9.62,0-9.25-14.25,0-14.25c9.76-0.01,9.5,14.25,0,14.25", null), KanjiStrokeItem(4, "M25,56.25c1.67,1.28,4.84,1.85,7.96,1.08c14.85-3.64,26.27-6.16,38.45-9.34c17.31-4.52,1.18,11.21-2.16,15.73", null), KanjiStrokeItem(5, "M41.1,35.5c1.3,1.1,2,2.1,2.5,4.1c0.5,2,9.4,41.62,9.9,43.72c0.5,2.1,1.7,7.2,2.4,9.8", null)),
            relatedWords = listOf(KanaWord("ピャ", "pya", "pya"))
        ),
        KanaCharacter(
            character = "ピュ",
            romaji = "pyu",
            category = KanaCategory.YOON,
            strokeCount = 4,
            strokeSteps = listOf("ピ ditambah ュ kecil"),
            strokes = listOf(KanjiStrokeItem(1, "M35.38,44.5c1.75,1.38,4.51,2.19,6.88,1.88c10.24-1.38,17.24-2.88,24.24-4.26c3.01-0.59,7.12-1,9.38-0.88", null), KanjiStrokeItem(2, "M31,17.62c1.38,1.26,1.88,3.38,1.88,6.13c0,2.75-0.88,44-0.88,47.25c0,9.75,4,14.62,13.75,14.62c6,0,16.38,0.12,21.38,0c5-0.12,9.5-0.62,13.5-1.5", null), KanjiStrokeItem(3, "M83,32.88c-9.62,0-9.25-14.25,0-14.25c9.76-0.01,9.5,14.25,0,14.25", null), KanjiStrokeItem(4, "M34.8,52.84c1.91,1.21,4.13,1.67,7.44,1.21c10.65-1.51,13.99-1.68,21.71-2.97c5.43-0.9,6.26,0.13,5.23,5.12c-1.91,9.25-3.92,19.45-5.23,27.49", null), KanjiStrokeItem(5, "M24.5,86.21c2.21,1.21,3.84,1.73,7.34,1.21c18.54-2.79,28.95-3.12,43.52-3.12c3.02,0,5.93,0.4,8.95,0.9", null)),
            relatedWords = listOf(KanaWord("ピューレ", "pyuure", "pure buah"))
        ),
        KanaCharacter(
            character = "ピョ",
            romaji = "pyo",
            category = KanaCategory.YOON,
            strokeCount = 5,
            strokeSteps = listOf("ピ ditambah ョ kecil"),
            strokes = listOf(KanjiStrokeItem(1, "M35.38,44.5c1.75,1.38,4.51,2.19,6.88,1.88c10.24-1.38,17.24-2.88,24.24-4.26c3.01-0.59,7.12-1,9.38-0.88", null), KanjiStrokeItem(2, "M31,17.62c1.38,1.26,1.88,3.38,1.88,6.13c0,2.75-0.88,44-0.88,47.25c0,9.75,4,14.62,13.75,14.62c6,0,16.38,0.12,21.38,0c5-0.12,9.5-0.62,13.5-1.5", null), KanjiStrokeItem(3, "M83,32.88c-9.62,0-9.25-14.25,0-14.25c9.76-0.01,9.5,14.25,0,14.25", null), KanjiStrokeItem(4, "M33.5,50.62c1.9,1.21,4.09,1.6,7.39,1.21c11.19-1.32,21.35-2.46,29.07-3.44c4.79-0.61,5.49,0.4,5.2,5.16c-0.79,12.56-1.5,24.79-2.4,34.21", null), KanjiStrokeItem(5, "M33.6,69.04c1.9,1.21,4.09,1.6,7.39,1.21c8.39-0.99,18.23-1.85,24.86-2.47c2.21-0.2,4.21,0.04,6.21,0.44", null), KanjiStrokeItem(6, "M29,90.06c2.2,1.05,3.79,1.36,7.29,1.05c9.99-0.88,23.47-2.35,33.07-2.35c2.7,0,4.49,0,7.49,0.44", null)),
            relatedWords = listOf(KanaWord("ピョ", "pyo", "pyo"))
        ),
    )

    val ALL_KANA: List<KanaCharacter> by lazy {
        HIRAGANA_GOJUON + HIRAGANA_DAKUON + HIRAGANA_YOON +
        KATAKANA_GOJUON + KATAKANA_DAKUON + KATAKANA_YOON
    }

    fun findKana(character: String): KanaCharacter? {
        return ALL_KANA.firstOrNull { it.character == character }
    }
}
