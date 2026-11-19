package id.nihongodictionary.app.presentation.designsystem.component

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FastForward
import androidx.compose.material.icons.filled.FastRewind
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Replay
import androidx.compose.material3.FilledTonalIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathMeasure
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.graphics.vector.PathParser
import androidx.compose.ui.unit.dp
import id.nihongodictionary.app.domain.model.KanjiStrokeItem
import kotlinx.coroutines.delay

@Composable
fun StrokeOrderCanvas(
    strokes: List<KanjiStrokeItem>,
    modifier: Modifier = Modifier,
    activeStrokeColor: Color = MaterialTheme.colorScheme.secondary,
    completedStrokeColor: Color = MaterialTheme.colorScheme.primary,
    guidelineColor: Color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f)
) {
    var currentStrokeIndex by remember(strokes) { mutableIntStateOf(strokes.size) }
    var isPlaying by remember { mutableStateOf(false) }

    // Parse paths once
    val parsedPaths = remember(strokes) {
        strokes.map { stroke ->
            try {
                PathParser().parsePathString(stroke.pathData).toPath()
            } catch (e: Exception) {
                Path()
            }
        }
    }

    // Auto-play animation loop
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

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Drawing Board
        Box(
            modifier = Modifier
                .size(220.dp)
                .testTag("kanji-stroke-canvas")
                .background(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.3f), MaterialTheme.shapes.medium)
                .border(1.dp, MaterialTheme.colorScheme.outlineVariant, MaterialTheme.shapes.medium)
        ) {
            Canvas(modifier = Modifier.fillMaxSize()) {
                val scaleFactor = size.minDimension / 109f

                // Draw 2x2 Japanese writing grid guidelines
                val halfW = size.width / 2f
                val halfH = size.height / 2f
                drawLine(guidelineColor, Offset(halfW, 0f), Offset(halfW, size.height), strokeWidth = 1.dp.toPx())
                drawLine(guidelineColor, Offset(0f, halfH), Offset(size.width, halfH), strokeWidth = 1.dp.toPx())

                scale(scaleFactor, pivot = Offset.Zero) {
                    for (i in 0 until currentStrokeIndex.coerceAtMost(parsedPaths.size)) {
                        val path = parsedPaths[i]
                        val isLatest = i == currentStrokeIndex - 1
                        val color = if (isLatest && isPlaying) activeStrokeColor else completedStrokeColor

                        drawPath(
                            path = path,
                            color = color,
                            style = Stroke(
                                width = 4f,
                                cap = StrokeCap.Round,
                                join = StrokeJoin.Round
                            )
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        // Control Bar
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
    }
}
