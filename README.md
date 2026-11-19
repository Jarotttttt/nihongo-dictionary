# Nihongo Dictionary (日本語辞書)

> **Aplikasi Kamus Bahasa Jepang – Indonesia Native Android (Offline-First)**  
> **Author:** Xyuraa  
> **Lisensi:** MIT

---

## 📱 Tentang Aplikasi

**Nihongo Dictionary** adalah aplikasi kamus bahasa Jepang–Indonesia modern berbasis native Android (Kotlin & Jetpack Compose Material 3) yang dirancang untuk bekerja **100% offline** tanpa ketergantungan internet, tanpa iklan, dan dengan performa tinggi.

### 🌟 Fitur Utama

1. **Pencarian Kosakata Cepat (160.000+ Entri)**
   - Pencarian real-time multibahasa: Kanji, Hiragana, Katakana, Romaji, dan Bahasa Indonesia.
   - Algoritma pencarian terindeks dengan SQLite FTS / LIKE berkecepatan <50ms.
   - Contoh kalimat dwibahasa (Tatoeba).

2. **Tabel Aksara Lengkap (Aksara Tab)**
   - **Hiragana (ひらがな)**: Gojuon dasar (46 huruf), Dakuon (20 huruf), dan Yōon (36 huruf).
   - **Katakana (カタカナ)**: Gojuon dasar (46 huruf), Dakuon (20 huruf), dan Yōon (36 huruf).
   - **Kanji (漢字)**: Ribuan kanji terindeks berdasarkan JLPT (N5–N1) dan Grade Sekolah Jepang.
   - **Radikal Kanji (部首)**: 30 radikal umum Kangxi sebagai pemahaman penyusun kanji.

3. **Layar Penuh Detail & Urutan Coretan (Hitsujun)**
   - Tampilan penuh (*fullscreen*) konsisten untuk Kanji, Hiragana, dan Katakana.
   - **Animasi Urutan Coretan**: Visualisasi langkah demi langkah berbasis vektor KanjiVG.
   - **Papan Latihan Menulis dengan Jari**: Latihan menulis interaktif di layar dengan panduan bayangan transparan (*ghost template*), fitur *undo*, dan *clear*.

4. **Pengucapan Audio Suara (Native TTS)**
   - Audio pengucapan native untuk kosakata, kanji (onyomi & kunyomi), hiragana, katakana, dan radikal.

5. **Kosakata Tersimpan (Bookmark)**
   - Fitur simpan kosakata favorit dengan kategorisasi status belajar.

6. **Desain Material You 3**
   - Tema gelap/terang adaptif dengan palet warna bernuansa Jepang (*Deep Indigo & Sakura Crimson*).

---

## 🛠️ Tech Stack & Arsitektur

- **Bahasa:** Kotlin 2.0+
- **UI Toolkit:** Jetpack Compose (Material 3)
- **Arsitektur:** Clean Architecture + MVI/MVVM
- **Dependency Injection:** Dagger Hilt
- **Basis Data:** Pre-packaged Read-Only SQLite (`dictionary.db`) + Room Database (Bookmarks & History)
- **DataStore:** Jetpack DataStore Preferences
- **Pengujian E2E:** Maestro Mobile Testing

---

## 👤 Author

- **Xyuraa**
