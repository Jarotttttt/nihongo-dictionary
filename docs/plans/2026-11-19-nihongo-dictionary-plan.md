# Nihongo Dictionary Implementation Plan

> **For agentic workers:** REQUIRED SUB-SKILL: Use superpowers:executing-plans to implement this plan task-by-task under TDD. Steps use checkbox (`- [ ]`) syntax for tracking.

**Goal:** Build a production-ready, 100% offline-first Android native Japanese-to-Indonesian dictionary app (Nihongo Dictionary) in Kotlin + Jetpack Compose + Material 3, backed by pre-populated SQLite (read-only) and Room (user data).

**Architecture:** Layered Architecture with Presentation (MVVM + UDF), Domain (Use Cases), Data (Repositories as error boundaries mapping platform errors to `DataError`), and Storage (read-only SQLite for dictionary, Room for user bookmarks/history, DataStore for preferences).

**Tech Stack:** Kotlin 2.0+, Jetpack Compose, Material 3, Navigation Compose 2.8+ / Navigation 3, Hilt 2.51+, SQLite 3 (FTS5 + Trigram), Room 2.6+, DataStore Preferences, Android native TextToSpeech, Python 3 for ETL pipeline.

**Spec:** Approved Product Requirements & Dataset Feasibility Audit (November 2026).

---

## Global Constraints
- Target platform: Android Native (minSdk 26, targetSdk 35).
- UI Framework: Jetpack Compose with Material 3 design system.
- Offline-first: 100% of core search, kanji inspection, stroke animation, and user bookmarks must function without an internet connection.
- Dictionary Storage: Separate read-only SQLite database file (`dictionary.db`) pre-populated during build or asset extraction.
- User Data Storage: Separate Room database (`user_data.db`) for bookmarks, history, and collections.
- Text-to-Speech: Android system `TextToSpeech` with `Locale.JAPANESE`; graceful fallback when data is missing.
- License Compliance: Attribution display for JaIsho (CC BY-SA 4.0), EDRDG (CC BY-SA 4.0), KanjiVG (CC BY-SA 3.0), and Tatoeba (CC BY 2.0 FR).
- TDD Discipline: Every unit of business logic and data parsing must have a failing test before implementation code is written.

## Review Focus
1. Search latency under 100ms on realistic vocabulary sizes (~100k entries).
2. Proper Japanese NFKC Unicode normalization and bidirectional Romaji <-> Kana mapping.
3. Separation of storage so dictionary upgrades never corrupt or overwrite user bookmarks.
4. Handling devices without Japanese TTS engines installed.
5. Accurate vector parsing and sequential rendering of KanjiVG stroke order paths in Compose Canvas.

---

## Milestone Roadmap & Tasks

### Milestone 1 — Dataset Foundation & ETL Pipeline
- **Task M1-01**: Inisialisasi Environment ETL & Parser Streaming JaIsho NDJSON.
- **Task M1-02**: Parser KANJIDIC2 & KanjiVG SVG Stroke Extractor.
- **Task M1-03**: Tatoeba Sentence Pair Linker & Cross-Reference Generator.
- **Task M1-04**: SQLite Database Synthesizer, FTS5 Virtual Tables, & Checksum Manifest.

### Milestone 2 — Android Foundation
- **Task M2-01**: Inisialisasi Android Studio / Gradle Project, Version Catalog (`libs.versions.toml`).
- **Task M2-02**: Konfigurasi Hilt Dependency Injection & Coroutine Dispatchers.
- **Task M2-03**: Setup Jetpack Compose Material 3 Theme, Typography (CJK Support), & Color Schemes.
- **Task M2-04**: Setup Type-Safe Navigation & Destination Routes.

### Milestone 3 — Dictionary Core
- **Task M3-01**: SQLite Asset Access Helper (Read-Only Driver) & DataError Mapping.
- **Task M3-02**: Japanese Search Engine Normalizer & Romaji-Kana Engine.
- **Task M3-03**: Dictionary Repository & SearchWordsUseCase.
- **Task M3-04**: Search Screen UI with Debounced M3 SearchBar & Shimmer State.
- **Task M3-05**: Word Detail Screen UI, Meanings, POS Badges, and Tatoeba Examples.

### Milestone 4 — Kanji Dictionary
- **Task M4-01**: Kanji Repository & GetKanjiDetailUseCase.
- **Task M4-02**: KanjiVG Stroke Vector Parser & Animated Compose Canvas Component (`StrokeOrderCanvas`).
- **Task M4-03**: Kanji Detail Screen UI with Radical, Stroke Count, Onyomi/Kunyomi, & Related Words.

### Milestone 5 — Personal Vocabulary (User Persistence)
- **Task M5-01**: Room Database Setup (`AppUserDatabase`, DAOs, Entities for Bookmarks, History, Collections).
- **Task M5-02**: User Data Repository & ToggleBookmark / History Use Cases.
- **Task M5-03**: Saved Vocabulary Screen & Collection Manager UI.
- **Task M5-04**: Search History Screen with Clear History & Privacy Toggle.

### Milestone 6 — Pronunciation
- **Task M6-01**: Android `TextToSpeech` Manager (`JapaneseTtsManager`) with Language Detection.
- **Task M6-02**: TTS Integration in Word Detail & Fallback Dialog for Missing Engine.
- **Task M6-03**: Settings Screen with TTS Pitch & Speech Rate Slider via DataStore.

### Milestone 7 — Quality & Release Preparation
- **Task M7-01**: Legal Attribution Screen (JaIsho, EDRDG, KanjiVG, Tatoeba).
- **Task M7-02**: Accessibility Audit (TalkBack semantics, touch targets ≥48dp).
- **Task M7-03**: Offline Verification & Macrobenchmark Performance Validation.
