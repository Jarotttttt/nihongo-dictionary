package id.nihongodictionary.app.domain.model

data class RadicalItem(
    val character: String,
    val name: String,
    val meaning: String,
    val strokeCount: Int,
    val exampleKanji: String, // Contoh kanji yang disusun
    val category: String = "Umum"
)

object RadicalData {
    val COMMON_RADICALS = listOf(
        RadicalItem("亻", "Ninben (人)", "Manusia / Orang", 2, "休, 働, 作, 体, 信, 仏"),
        RadicalItem("氵", "Sanzui (水)", "Air / Cairan", 3, "海, 泳, 漢, 池, 洗, 汁, 波"),
        RadicalItem("木", "Kihen (木)", "Pohon / Kayu", 4, "林, 森, 校, 本, 村, 机, 板"),
        RadicalItem("扌", "Tehen (手)", "Tangan / Tindakan", 3, "持, 打, 指, 押, 拾, 払, 投"),
        RadicalItem("言", "Gonben (言)", "Kata / Ucapan", 7, "語, 話, 読, 訳, 談, 謝, 誓"),
        RadicalItem("口", "Kuchi (口)", "Mulut / Lubang", 3, "味, 呼, 吸, 鳴, 咲, 吐, 叫"),
        RadicalItem("日", "Hihen (日)", "Matahari / Waktu", 4, "明, 時, 晴, 早, 昨, 晩, 暖"),
        RadicalItem("月", "Tsuki / Nikuzuki", "Bulan / Tubuh / Daging", 4, "朝, 期, 服, 腕, 脚, 胃, 脳"),
        RadicalItem("心", "Kokoro / Risshinben", "Hati / Perasaan / Emosi", 4, "思, 愛, 忙, 快, 怖, 情, 忘"),
        RadicalItem("艹", "Kusakanmuri (艸)", "Rumput / Tumbuhan", 3, "花, 茶, 草, 若, 苦, 薬, 荷"),
        RadicalItem("門", "Mon / Mongamae", "Pintu Gerbang", 8, "間, 開, 閉, 問, 関, 聞, 閣"),
        RadicalItem("女", "Onnahen (女)", "Wanita / Perempuan", 3, "好, 妹, 姉, 始, 安, 妻, 娘"),
        RadicalItem("火", "Hihen / Rengwa (灬)", "Api / Panas", 4, "炎, 点, 熱, 焼, 焦, 照, 灯"),
        RadicalItem("土", "Tsuchi (土)", "Tanah / Bumi", 3, "地, 場, 城, 坂, 埼, 境, 坊"),
        RadicalItem("糸", "Itohen (糸)", "Benang / Hubungan", 6, "紙, 終, 線, 組, 結, 経, 続"),
        RadicalItem("金", "Kanehen (金)", "Logam / Emas / Besi", 8, "銀, 鉄, 針, 鏡, 銅, 鐘, 鋼"),
        RadicalItem("目", "Mehen (目)", "Mata / Penglihatan", 5, "見, 看, 省, 眠, 眼, 眺, 睡"),
        RadicalItem("車", "Kurumahen (車)", "Kendaraan / Mobil", 7, "連, 軍, 転, 輪, 輸, 軽, 載"),
        RadicalItem("雨", "Amekanmuri (雨)", "Cuaca / Hujan / Langit", 8, "電, 雲, 雪, 震, 霜, 霧, 露"),
        RadicalItem("食", "Shokuhen (飠)", "Makanan / Memakan", 9, "飯, 館, 飲, 飼, 飾, 餓, 餌"),
        RadicalItem("辶", "Shinnyou (辵)", "Berjalan / Bergerak", 3, "道, 進, 通, 近, 返, 運, 遠"),
        RadicalItem("宀", "Ukanmuri (宀)", "Atap / Rumah / Bangunan", 3, "家, 安, 宿, 室, 宝, 守, 完"),
        RadicalItem("广", "Madare (广)", "Gedung Luas / Tempat", 3, "広, 店, 度, 席, 府, 庭, 康"),
        RadicalItem("尸", "Shikabane (尸)", "Tubuh / Bangunan", 3, "屋, 居, 展, 局, 尾, 届, 層"),
        RadicalItem("力", "Chikara (力)", "Kekuatan / Tenaga", 2, "助, 功, 勝, 動, 努, 効, 勇"),
        RadicalItem("貝", "Kaihen (貝)", "Kerang / Uang / Harta", 7, "買, 質, 賃, 貧, 貯, 貴, 販"),
        RadicalItem("鳥", "Tori (鳥)", "Burung / Hewan Unggas", 11, "鳴, 島, 鶏, 鴨, 鶴, 鳩, 鷲"),
        RadicalItem("魚", "Uohen (魚)", "Ikan / Hewan Air", 11, "鮮, 鯉, 鯛, 鮭, 鯨, 鯖, 鰹"),
        RadicalItem("疒", "Yamaidare (疒)", "Penyakit / Sakit", 5, "病, 痛, 疲, 症, 療, 痕, 痩"),
        RadicalItem("刀", "Katana / Rittou (刂)", "Pedang / Memotong", 2, "切, 別, 利, 割, 刑, 列, 創")
    )
}
