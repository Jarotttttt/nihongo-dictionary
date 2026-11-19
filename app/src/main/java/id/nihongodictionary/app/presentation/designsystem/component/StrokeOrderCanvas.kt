package id.nihongodictionary.app.presentation.designsystem.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.awaitEachGesture
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Undo
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.FastForward
import androidx.compose.material.icons.filled.FastRewind
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Replay
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilledTonalIconButton
import androidx.compose.material3.FilledTonalIconToggleButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.graphics.vector.PathParser
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import id.nihongodictionary.app.domain.model.KanjiStrokeItem
import kotlinx.coroutines.delay

enum class StrokeCanvasMode {
    ANIMATION,
    PRACTICE
}

@Composable
fun StrokeOrderCanvas(
    strokes: List<KanjiStrokeItem>,
    modifier: Modifier = Modifier,
    activeStrokeColor: Color = MaterialTheme.colorScheme.secondary,
    completedStrokeColor: Color = MaterialTheme.colorScheme.primary,
    guidelineColor: Color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f)
) {
    var mode by remember { mutableStateOf(StrokeCanvasMode.ANIMATION) }

    // Animation Mode States
    var currentStrokeIndex by remember(strokes) { mutableIntStateOf(strokes.size) }
    var isPlaying by remember(strokes) { mutableStateOf(false) }

    // Practice Mode States
    var userStrokes by remember(strokes) { mutableStateOf(listOf<List<Offset>>()) }
    var currentStroke by remember(strokes) { mutableStateOf(listOf<Offset>()) }
    var showGhostTemplate by remember { mutableStateOf(true) }

    // Parse KanjiVG paths once per strokes update
    val parsedPaths = remember(strokes) {
        strokes.map { stroke ->
            try {
                PathParser().parsePathString(stroke.pathData).toPath()
            } catch (e: Exception) {
                Path()
            }
        }
    }

    // Auto-play animation loop for ANIMATION mode
    LaunchedEffect(isPlaying) {
        if (isPlaying) {
            currentStrokeIndex = 0
            while (currentStrokeIndex < strokes.size && isPlaying) {
                delay(600)
                currentStrokeIndex++
            }
            isPlaying = false
        }
    }

    val ghostGuideColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.20f)
    val dashEffect = remember { PathEffect.dashPathEffect(floatArrayOf(12f, 10f), 0f) }

    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Mode Selector: Animasi Urutan vs Latihan Tulis
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            FilterChip(
                modifier = Modifier.testTag("btn-stroke-mode-anim"),
                selected = mode == StrokeCanvasMode.ANIMATION,
                onClick = {
                    mode = StrokeCanvasMode.ANIMATION
                    isPlaying = false
                },
                label = { Text("Animasi Urutan") },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.PlayArrow,
                        contentDescription = null,
                        modifier = Modifier.size(16.dp)
                    )
                }
            )

            FilterChip(
                modifier = Modifier.testTag("btn-stroke-mode-practice"),
                selected = mode == StrokeCanvasMode.PRACTICE,
                onClick = {
                    mode = StrokeCanvasMode.PRACTICE
                    isPlaying = false
                },
                label = { Text("Latihan Tulis") },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Edit,
                        contentDescription = null,
                        modifier = Modifier.size(16.dp)
                    )
                }
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        // Drawing / Display Canvas Box
        val drawingModifier = if (mode == StrokeCanvasMode.PRACTICE) {
            Modifier.pointerInput(strokes) {
                awaitEachGesture {
                    val down = awaitFirstDown(requireUnconsumed = false)
                    down.consume()
                    var points = listOf(down.position)
                    currentStroke = points

                    while (true) {
                        val event = awaitPointerEvent()
                        val change = event.changes.firstOrNull { it.id == down.id }
                        if (change == null || !change.pressed) {
                            break
                        }
                        change.consume()
                        points = points + change.position
                        currentStroke = points
                    }

                    if (points.isNotEmpty()) {
                        userStrokes = userStrokes + listOf(points)
                        currentStroke = emptyList()
                    }
                }
            }
        } else {
            Modifier
        }

        Box(
            modifier = Modifier
                .size(200.dp)
                .testTag("kanji-stroke-canvas")
                .clip(MaterialTheme.shapes.medium)
                .background(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.35f), MaterialTheme.shapes.medium)
                .border(1.dp, MaterialTheme.colorScheme.outlineVariant, MaterialTheme.shapes.medium)
                .then(drawingModifier)
        ) {
            Canvas(modifier = Modifier.fillMaxSize()) {
                val scaleFactor = size.minDimension / 109f

                // Draw Japanese 2x2 Masume (square grid) dashed guidelines
                val halfW = size.width / 2f
                val halfH = size.height / 2f
                drawLine(
                    color = guidelineColor,
                    start = Offset(halfW, 0f),
                    end = Offset(halfW, size.height),
                    strokeWidth = 1.dp.toPx(),
                    pathEffect = dashEffect
                )
                drawLine(
                    color = guidelineColor,
                    start = Offset(0f, halfH),
                    end = Offset(size.width, halfH),
                    strokeWidth = 1.dp.toPx(),
                    pathEffect = dashEffect
                )

                if (mode == StrokeCanvasMode.ANIMATION) {
                    // Mode Animasi: Menampilkan goresan bertahap
                    scale(scaleFactor, pivot = Offset.Zero) {
                        for (i in 0 until currentStrokeIndex.coerceAtMost(parsedPaths.size)) {
                            val path = parsedPaths[i]
                            val isLatest = i == currentStrokeIndex - 1
                            val color = if (isLatest && isPlaying) activeStrokeColor else completedStrokeColor

                            drawPath(
                                path = path,
                                color = color,
                                style = Stroke(
                                    width = 4.5f,
                                    cap = StrokeCap.Round,
                                    join = StrokeJoin.Round
                                )
                            )
                        }
                    }
                } else {
                    // Mode Latihan Tulis:
                    // 1. Gambar template bayangan jika diaktifkan
                    if (showGhostTemplate) {
                        scale(scaleFactor, pivot = Offset.Zero) {
                            parsedPaths.forEach { path ->
                                drawPath(
                                    path = path,
                                    color = ghostGuideColor,
                                    style = Stroke(
                                        width = 4.5f,
                                        cap = StrokeCap.Round,
                                        join = StrokeJoin.Round
                                    )
                                )
                            }
                        }
                    }

                    // 2. Gambar goresan jari pengguna secara real-time
                    val userStrokesToDraw = if (currentStroke.isNotEmpty()) {
                        userStrokes + listOf(currentStroke)
                    } else {
                        userStrokes
                    }

                    val userStrokeWidthPx = 7.dp.toPx()
                    userStrokesToDraw.forEach { strokePoints ->
                        if (strokePoints.size > 1) {
                            val path = Path().apply {
                                moveTo(strokePoints[0].x, strokePoints[0].y)
                                for (j in 1 until strokePoints.size - 1) {
                                    val p0 = strokePoints[j]
                                    val p1 = strokePoints[j + 1]
                                    quadraticTo(
                                        p0.x, p0.y,
                                        (p0.x + p1.x) / 2f,
                                        (p0.y + p1.y) / 2f
                                    )
                                }
                                lineTo(strokePoints.last().x, strokePoints.last().y)
                            }
                            drawPath(
                                path = path,
                                color = completedStrokeColor,
                                style = Stroke(
                                    width = userStrokeWidthPx,
                                    cap = StrokeCap.Round,
                                    join = StrokeJoin.Round
                                )
                            )
                        } else if (strokePoints.size == 1) {
                            drawCircle(
                                color = completedStrokeColor,
                                radius = userStrokeWidthPx / 2f,
                                center = strokePoints.first()
                            )
                        }
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        // Control Bars according to Active Mode
        if (mode == StrokeCanvasMode.ANIMATION) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedIconButton(
                    modifier = Modifier.testTag("btn-stroke-prev"),
                    onClick = {
                        isPlaying = false
                        currentStrokeIndex = (currentStrokeIndex - 1).coerceAtLeast(0)
                    },
                    enabled = currentStrokeIndex > 0
                ) {
                    Icon(Icons.Default.FastRewind, contentDescription = "Coretan Sebelumnya")
                }

                FilledTonalIconButton(
                    modifier = Modifier.testTag("btn-stroke-play"),
                    onClick = { isPlaying = !isPlaying }
                ) {
                    Icon(
                        imageVector = if (isPlaying) Icons.Default.Replay else Icons.Default.PlayArrow,
                        contentDescription = if (isPlaying) "Ulangi" else "Putar Animasi"
                    )
                }

                OutlinedIconButton(
                    modifier = Modifier.testTag("btn-stroke-next"),
                    onClick = {
                        isPlaying = false
                        currentStrokeIndex = (currentStrokeIndex + 1).coerceAtMost(strokes.size)
                    },
                    enabled = currentStrokeIndex < strokes.size
                ) {
                    Icon(Icons.Default.FastForward, contentDescription = "Coretan Berikutnya")
                }
            }

            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Coretan: $currentStrokeIndex / ${strokes.size}",
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        } else {
            // PRACTICE MODE CONTROLS
            Row(
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Urungkan Coretan (Undo)
                OutlinedIconButton(
                    modifier = Modifier.testTag("btn-practice-undo"),
                    onClick = {
                        if (userStrokes.isNotEmpty()) {
                            userStrokes = userStrokes.dropLast(1)
                        }
                    },
                    enabled = userStrokes.isNotEmpty()
                ) {
                    Icon(Icons.AutoMirrored.Filled.Undo, contentDescription = "Urungkan Coretan")
                }

                // Toggle Panduan Bayangan (Ghost Guide)
                FilledTonalIconToggleButton(
                    modifier = Modifier.testTag("btn-practice-ghost"),
                    checked = showGhostTemplate,
                    onCheckedChange = { showGhostTemplate = it }
                ) {
                    Icon(
                        imageVector = if (showGhostTemplate) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                        contentDescription = if (showGhostTemplate) "Sembunyikan Panduan Bayangan" else "Tampilkan Panduan Bayangan"
                    )
                }

                // Hapus Semua (Clear)
                OutlinedIconButton(
                    modifier = Modifier.testTag("btn-practice-clear"),
                    onClick = {
                        userStrokes = emptyList()
                        currentStroke = emptyList()
                    },
                    enabled = userStrokes.isNotEmpty()
                ) {
                    Icon(Icons.Default.Delete, contentDescription = "Hapus Semua")
                }
            }

            Spacer(modifier = Modifier.height(6.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(
                    text = "Coretan kamu: ${userStrokes.size} / ${strokes.size}",
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                if (strokes.isNotEmpty() && userStrokes.size == strokes.size) {
                    Text(
                        text = "✓ Jumlah coretan pas!",
                        style = MaterialTheme.typography.labelMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }

            if (userStrokes.isEmpty()) {
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = if (showGhostTemplate) "Tulis dengan jarimu mengikuti bayangan huruf" else "Tulis huruf dari ingatanmu tanpa bayangan",
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.7f),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}
