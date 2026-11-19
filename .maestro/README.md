# Maestro Mobile E2E Testing for Nihongo Dictionary

Direktori ini berisi alur pengujian otomatis end-to-end (E2E) menggunakan **Maestro Mobile Testing Framework** untuk aplikasi Android **Nihongo Dictionary**.

---

## 1. Daftar File Pengujian (Flows)

| File | Tag | Deskripsi |
|---|---|---|
| `smoke-test.yaml` | `smoke`, `ci` | Pengujian penuh alur pencarian kata, navigasi antar tab, detail kosakata, dan layar atribusi lisensi |
| `kanji-stroke-flow.yaml` | `kanji` | Pengujian penelusuran kanji, kanvas animasi coretan (*hitsujun*), bacaan Onyomi/Kunyomi, dan kata terkait |

---

## 2. Inventaris testID (Selectors)

| Komponen | testID | Deskripsi |
|---|---|---|
| Bilah Pencarian | `search-input` | Input text query (Kanji, Kana, Romaji, ID) |
| Tombol Hapus Input | `btn-clear-search` | Menghapus kueri pencarian |
| Tab Navigasi Kamus | `tab-kamus` | Bottom bar tab Kamus |
| Tab Navigasi Tersimpan | `tab-saved` | Bottom bar tab Bookmark/Tersimpan |
| Tab Navigasi Pengaturan | `tab-settings` | Bottom bar tab Pengaturan & Audio |
| Tombol Audio TTS | `btn-play-audio` | Tombol pelafalan suara kata Jepang |
| Tombol Bookmark | `btn-bookmark` | Tombol simpan/tandai kata |
| Kanvas Animasi Coretan | `kanji-stroke-canvas` | Kanvas visualisasi urutan goresan kanji |
| Kontrol Coretan Play | `btn-stroke-play` | Tombol play / replay animasi coretan |
| Kontrol Coretan Prev | `btn-stroke-prev` | Mundur satu coretan |
| Kontrol Coretan Next | `btn-stroke-next` | Maju satu coretan |

---

## 3. Cara Menjalankan Tes

### Prasyarat:
1. Hubungkan HP Android fisik (dengan USB Debugging aktif) atau jalankan Android Emulator.
2. Pastikan perangkat terdeteksi dengan perintah:
   ```bash
   adb devices
   ```
3. Install aplikasi debug ke perangkat:
   ```bash
   ./gradlew installDebug
   ```

### Eksekusi Maestro:
Jalankan pengujian smoke test:
```bash
maestro test .maestro/smoke-test.yaml
```

Jalankan pengujian animasi kanji:
```bash
maestro test .maestro/kanji-stroke-flow.yaml
```

Jalankan seluruh tes bertag CI:
```bash
maestro test --include-tags ci .maestro/
```

Jalankan secara interaktif menggunakan Maestro Studio:
```bash
maestro studio
```
