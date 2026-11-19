package id.nihongodictionary.app.presentation.screens.characters

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.VolumeUp
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import id.nihongodictionary.app.domain.model.KanaCategory
import id.nihongodictionary.app.domain.model.KanaCharacter
import id.nihongodictionary.app.domain.model.KanaData
import id.nihongodictionary.app.domain.model.KanaWord
import id.nihongodictionary.app.domain.model.KanjiFilterCategory
import id.nihongodictionary.app.domain.model.KanjiGridItem
import id.nihongodictionary.app.domain.model.RadicalData
import id.nihongodictionary.app.domain.model.RadicalItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharactersScreen(
    viewModel: CharactersViewModel,
    onKanjiClick: (Long) -> Unit,
    modifier: Modifier = Modifier
) {
    val selectedTab by viewModel.selectedTab.collectAsStateWithLifecycle()
    val selectedKanaCategory by viewModel.selectedKanaCategory.collectAsStateWithLifecycle()
    val selectedKanjiFilter by viewModel.selectedKanjiFilter.collectAsStateWithLifecycle()
    val kanjiState by viewModel.kanjiState.collectAsStateWithLifecycle()

    val snackbarHostState = remember { SnackbarHostState() }
    var detailKana by remember { mutableStateOf<KanaCharacter?>(null) }

    LaunchedEffect(Unit) {
        viewModel.audioFeedback.collect { message ->
            snackbarHostState.showSnackbar(message)
        }
    }

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) },
        modifier = modifier.fillMaxSize()
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            // 1. Top Main ScrollableTabRow (Hiragana, Katakana, Kanji, Radicals)
            ScrollableTabRow(
                selectedTabIndex = selectedTab.ordinal,
                edgePadding = 16.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("tab-row-characters")
            ) {
                Tab(
                    selected = selectedTab == MainCharacterTab.HIRAGANA,
                    onClick = { viewModel.selectTab(MainCharacterTab.HIRAGANA) },
                    text = { Text("Hiragana (ひらがな)", fontWeight = FontWeight.SemiBold) }
                )
                Tab(
                    selected = selectedTab == MainCharacterTab.KATAKANA,
                    onClick = { viewModel.selectTab(MainCharacterTab.KATAKANA) },
                    text = { Text("Katakana (カタカナ)", fontWeight = FontWeight.SemiBold) }
                )
                Tab(
                    selected = selectedTab == MainCharacterTab.KANJI,
                    onClick = { viewModel.selectTab(MainCharacterTab.KANJI) },
                    text = { Text("Kanji (漢字)", fontWeight = FontWeight.SemiBold) }
                )
                Tab(
                    selected = selectedTab == MainCharacterTab.RADICALS,
                    onClick = { viewModel.selectTab(MainCharacterTab.RADICALS) },
                    text = { Text("Kanji Penyusun (部首)", fontWeight = FontWeight.SemiBold) }
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            // 2. Sub-Category Filter Chips
            when (selectedTab) {
                MainCharacterTab.HIRAGANA, MainCharacterTab.KATAKANA -> {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        FilterChip(
                            selected = selectedKanaCategory == KanaCategory.GOJUON,
                            onClick = { viewModel.selectKanaCategory(KanaCategory.GOJUON) },
                            label = { Text("Dasar (46 Huruf)") }
                        )
                        FilterChip(
                            selected = selectedKanaCategory == KanaCategory.DAKUON,
                            onClick = { viewModel.selectKanaCategory(KanaCategory.DAKUON) },
                            label = { Text("Turunan (Dakuon)") }
                        )
                        FilterChip(
                            selected = selectedKanaCategory == KanaCategory.YOON,
                            onClick = { viewModel.selectKanaCategory(KanaCategory.YOON) },
                            label = { Text("Gabungan (Yōon)") }
                        )
                    }
                }
                MainCharacterTab.KANJI -> {
                    LazyRow(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        items(KanjiFilterCategory.entries) { filter ->
                            FilterChip(
                                selected = selectedKanjiFilter == filter,
                                onClick = { viewModel.selectKanjiFilter(filter) },
                                label = { Text(filter.label) }
                            )
                        }
                    }
                }
                MainCharacterTab.RADICALS -> {
                    Text(
                        text = "30 Radikal (Bushu) paling umum pembentuk Kanji",
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // 3. Grid Display Area
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(horizontal = 12.dp)
            ) {
                when (selectedTab) {
                    MainCharacterTab.HIRAGANA -> {
                        val kanaList = when (selectedKanaCategory) {
                            KanaCategory.GOJUON -> KanaData.HIRAGANA_GOJUON
                            KanaCategory.DAKUON -> KanaData.HIRAGANA_DAKUON
                            KanaCategory.YOON -> KanaData.HIRAGANA_YOON
                        }
                        val columns = if (selectedKanaCategory == KanaCategory.YOON) 3 else 5
                        KanaGrid(
                            items = kanaList,
                            columns = columns,
                            onPlayAudio = { viewModel.playAudio(it.character) },
                            onItemClick = { detailKana = it }
                        )
                    }
                    MainCharacterTab.KATAKANA -> {
                        val kanaList = when (selectedKanaCategory) {
                            KanaCategory.GOJUON -> KanaData.KATAKANA_GOJUON
                            KanaCategory.DAKUON -> KanaData.KATAKANA_DAKUON
                            KanaCategory.YOON -> KanaData.KATAKANA_YOON
                        }
                        val columns = if (selectedKanaCategory == KanaCategory.YOON) 3 else 5
                        KanaGrid(
                            items = kanaList,
                            columns = columns,
                            onPlayAudio = { viewModel.playAudio(it.character) },
                            onItemClick = { detailKana = it }
                        )
                    }
                    MainCharacterTab.KANJI -> {
                        when (val state = kanjiState) {
                            is KanjiListUiState.Loading -> {
                                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                                    CircularProgressIndicator()
                                }
                            }
                            is KanjiListUiState.Error -> {
                                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                                    Text(
                                        text = state.message,
                                        color = MaterialTheme.colorScheme.error,
                                        style = MaterialTheme.typography.bodyLarge
                                    )
                                }
                            }
                            is KanjiListUiState.Success -> {
                                KanjiGrid(
                                    kanjiList = state.kanjiList,
                                    onKanjiClick = onKanjiClick,
                                    onPlayAudio = { kanji ->
                                        val readingToSpeak = kanji.kunyomi?.replace(".", "")
                                            ?: kanji.onyomi
                                            ?: kanji.character
                                        viewModel.playAudio(readingToSpeak)
                                    }
                                )
                            }
                        }
                    }
                    MainCharacterTab.RADICALS -> {
                        RadicalList(
                            items = RadicalData.COMMON_RADICALS,
                            onPlayAudio = { radical ->
                                val nameWord = radical.name.substringBefore(" ").substringBefore("(")
                                viewModel.playAudio(nameWord)
                            }
                        )
                    }
                }
            }
        }
    }

    // Modal BottomSheet for Kana Detail
    detailKana?.let { kana ->
        if (kana.character.isNotEmpty()) {
            KanaDetailBottomSheet(
                kana = kana,
                onDismiss = { detailKana = null },
                onPlayAudio = { viewModel.playAudio(it) }
            )
        }
    }
}

@Composable
fun KanaGrid(
    items: List<KanaCharacter>,
    columns: Int,
    onPlayAudio: (KanaCharacter) -> Unit,
    onItemClick: (KanaCharacter) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(columns),
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(vertical = 8.dp)
    ) {
        items(items) { item ->
            if (item.character.isEmpty()) {
                Box(
                    modifier = Modifier
                        .aspectRatio(1f)
                        .fillMaxSize()
                )
            } else {
                KanaCard(
                    kana = item,
                    onClick = {
                        onPlayAudio(item)
                        onItemClick(item)
                    }
                )
            }
        }
    }
}

@Composable
fun KanaCard(
    kana: KanaCharacter,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    ElevatedCard(
        modifier = modifier
            .aspectRatio(1f)
            .clickable(onClick = onClick)
            .testTag("kana-card-${kana.character}"),
        colors = CardDefaults.elevatedCardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        shape = MaterialTheme.shapes.medium
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(4.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = kana.character,
                style = MaterialTheme.typography.titleLarge,
                fontSize = if (kana.character.length > 1) 20.sp else 24.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = kana.romaji,
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                fontWeight = FontWeight.Medium
            )
        }
    }
}

@Composable
fun KanjiGrid(
    kanjiList: List<KanjiGridItem>,
    onKanjiClick: (Long) -> Unit,
    onPlayAudio: (KanjiGridItem) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(vertical = 8.dp)
    ) {
        items(kanjiList, key = { it.id }) { kanji ->
            KanjiCard(
                kanji = kanji,
                onClick = { onKanjiClick(kanji.id) },
                onAudioClick = { onPlayAudio(kanji) }
            )
        }
    }
}

@Composable
fun KanjiCard(
    kanji: KanjiGridItem,
    onClick: () -> Unit,
    onAudioClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    ElevatedCard(
        modifier = modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .testTag("kanji-grid-${kanji.character}"),
        colors = CardDefaults.elevatedCardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        shape = MaterialTheme.shapes.medium
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    shape = MaterialTheme.shapes.extraSmall,
                    color = MaterialTheme.colorScheme.secondaryContainer
                ) {
                    Text(
                        text = "${kanji.strokeCount}g",
                        style = MaterialTheme.typography.labelSmall,
                        modifier = Modifier.padding(horizontal = 4.dp, vertical = 2.dp),
                        color = MaterialTheme.colorScheme.onSecondaryContainer
                    )
                }
                IconButton(
                    onClick = onAudioClick,
                    modifier = Modifier.size(24.dp)
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.VolumeUp,
                        contentDescription = "Dengarkan",
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(16.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = kanji.character,
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = kanji.meaningId,
                style = MaterialTheme.typography.bodySmall,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onSurface
            )

            Spacer(modifier = Modifier.height(2.dp))

            val reading = kanji.kunyomi ?: kanji.onyomi ?: ""
            if (reading.isNotEmpty()) {
                Text(
                    text = reading,
                    style = MaterialTheme.typography.labelSmall,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun KanaDetailBottomSheet(
    kana: KanaCharacter,
    onDismiss: () -> Unit,
    onPlayAudio: (String) -> Unit
) {
    ModalBottomSheet(
        onDismissRequest = onDismiss,
        shape = MaterialTheme.shapes.extraLarge,
        containerColor = MaterialTheme.colorScheme.surface
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .padding(bottom = 32.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // 1. Header: Big Character, Romaji, Badges
            Text(
                text = kana.character,
                style = MaterialTheme.typography.displayLarge,
                fontSize = 56.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "Pelafalan: \"${kana.romaji}\"",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Surface(
                    shape = MaterialTheme.shapes.small,
                    color = MaterialTheme.colorScheme.secondaryContainer
                ) {
                    Text(
                        text = "${kana.strokeCount} Coretan",
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                        style = MaterialTheme.typography.labelMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSecondaryContainer
                    )
                }

                Surface(
                    shape = MaterialTheme.shapes.small,
                    color = MaterialTheme.colorScheme.tertiaryContainer
                ) {
                    Text(
                        text = when (kana.category) {
                            KanaCategory.GOJUON -> "Huruf Dasar"
                            KanaCategory.DAKUON -> "Bunyi Turunan (Dakuon)"
                            KanaCategory.YOON -> "Bunyi Gabungan (Yōon)"
                        },
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                        style = MaterialTheme.typography.labelMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onTertiaryContainer
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Main Audio Button
            FilledTonalButton(
                onClick = { onPlayAudio(kana.character) },
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.VolumeUp,
                    contentDescription = null,
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text("Dengarkan Suara Huruf (${kana.character})", fontWeight = FontWeight.Bold)
            }

            Spacer(modifier = Modifier.height(20.dp))

            // 2. Stroke Order Section (Urutan Penulisan Coretan)
            if (kana.strokeSteps.isNotEmpty()) {
                OutlinedCard(
                    modifier = Modifier.fillMaxWidth(),
                    shape = MaterialTheme.shapes.medium
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Default.Edit,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.primary,
                                modifier = Modifier.size(20.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "Urutan Penulisan (Hitsujun)",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.primary
                            )
                        }

                        Spacer(modifier = Modifier.height(10.dp))

                        kana.strokeSteps.forEachIndexed { index, step ->
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 4.dp),
                                verticalAlignment = Alignment.Top
                            ) {
                                Surface(
                                    shape = MaterialTheme.shapes.extraSmall,
                                    color = MaterialTheme.colorScheme.primaryContainer,
                                    modifier = Modifier.size(22.dp)
                                ) {
                                    Box(contentAlignment = Alignment.Center) {
                                        Text(
                                            text = "${index + 1}",
                                            style = MaterialTheme.typography.labelSmall,
                                            fontWeight = FontWeight.Bold,
                                            color = MaterialTheme.colorScheme.onPrimaryContainer
                                        )
                                    }
                                }
                                Spacer(modifier = Modifier.width(10.dp))
                                Text(
                                    text = step,
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))
            }

            // 3. Related Vocabulary Section (Penyusunan Kosakata)
            if (kana.relatedWords.isNotEmpty()) {
                Column(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = "Kosakata Penyusun (${kana.relatedWords.size} Contoh Kata)",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Spacer(modifier = Modifier.height(8.dp))

                    kana.relatedWords.forEach { word ->
                        ElevatedCard(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 4.dp),
                            shape = MaterialTheme.shapes.medium
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(14.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Column(modifier = Modifier.weight(1f)) {
                                    Text(
                                        text = word.japanese,
                                        style = MaterialTheme.typography.titleLarge,
                                        fontWeight = FontWeight.Bold,
                                        color = MaterialTheme.colorScheme.primary
                                    )
                                    Text(
                                        text = "${word.romaji} • ${word.meaning}",
                                        style = MaterialTheme.typography.bodyMedium,
                                        color = MaterialTheme.colorScheme.onSurfaceVariant
                                    )
                                }

                                IconButton(
                                    onClick = { onPlayAudio(word.japanese) },
                                    modifier = Modifier.size(36.dp)
                                ) {
                                    Icon(
                                        imageVector = Icons.AutoMirrored.Filled.VolumeUp,
                                        contentDescription = "Dengarkan Kata",
                                        tint = MaterialTheme.colorScheme.primary
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun RadicalList(
    items: List<RadicalItem>,
    onPlayAudio: (RadicalItem) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(1),
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(vertical = 8.dp)
    ) {
        items(items) { radical ->
            RadicalCard(
                radical = radical,
                onPlayAudio = { onPlayAudio(radical) }
            )
        }
    }
}

@Composable
fun RadicalCard(
    radical: RadicalItem,
    onPlayAudio: () -> Unit,
    modifier: Modifier = Modifier
) {
    ElevatedCard(
        modifier = modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.medium,
        colors = CardDefaults.elevatedCardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                shape = MaterialTheme.shapes.small,
                color = MaterialTheme.colorScheme.primaryContainer,
                modifier = Modifier.size(52.dp)
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Text(
                        text = radical.character,
                        style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                }
            }

            Spacer(modifier = Modifier.size(14.dp))

            Column(modifier = Modifier.weight(1f)) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = radical.name,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Text(
                        text = "${radical.strokeCount} coretan",
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }

                Spacer(modifier = Modifier.height(2.dp))

                Text(
                    text = "Makna: ${radical.meaning}",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Medium,
                    color = MaterialTheme.colorScheme.onSurface
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "Contoh kanji: ${radical.exampleKanji}",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.secondary
                )
            }

            Spacer(modifier = Modifier.size(8.dp))

            IconButton(onClick = onPlayAudio) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.VolumeUp,
                    contentDescription = "Dengar Suara Radikal",
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}
