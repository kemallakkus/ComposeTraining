package kemalakkus.composetraining.ui.examples

import androidx.annotation.FloatRange
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.unit.dp

@Composable
fun CanvasTraining() {

    // Animasyonları tetiklemek için bir state değişkeni oluşturuyoruz
    var startAnimation by remember { mutableStateOf(false) }

    // Animasyonlar için state değişkenlerini tanımlıyoruz
    val rectAnim by animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0f,
        animationSpec = tween(durationMillis = 1000, easing = LinearEasing), label = ""
    )

    val circleAnim by animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0f,
        animationSpec = tween(durationMillis = 1000, easing = LinearEasing), label = ""
    )

    val triangleAnim by animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0f,
        animationSpec = tween(durationMillis = 1000, easing = LinearEasing), label = ""
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        // Animasyonu tetikleyen buton
        Button(onClick = { startAnimation = !startAnimation }) {
            Text(text = "Start Animation")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Canvas(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth()
                .height(500.dp)
                .background(Color.LightGray)
        ) {

            val canvasWidth = size.width
            val canvasHeight = size.height

            val recWidth = canvasWidth * 0.2f * rectAnim
            val recHeight = canvasHeight * 0.4f * rectAnim

            drawRect(
                brush = Brush.verticalGradient(listOf(Color.Green, Color.Blue)),
                size = Size(recWidth, recHeight),
                topLeft = Offset(
                    x = (canvasWidth - recWidth) / 2f,
                    y = (canvasHeight - recHeight) / 2f + 30.dp.toPx()
                ),
                blendMode = BlendMode.Darken
            )

            drawCircle(
                brush = Brush.horizontalGradient(listOf(Color.Blue, Color.Green)),
                radius = (size.minDimension / 6f) * circleAnim,
                center = Offset(
                    x = canvasWidth / 2f,
                    y = 90.dp.toPx()
                )
            )

            val trianglePath = Path().apply {
                moveTo(
                    x = canvasWidth / 2,
                    y = canvasHeight - 100.dp.toPx()
                )

                lineTo(
                    x = (canvasWidth / 2) - 50.dp.toPx() * triangleAnim,
                    y = canvasHeight - 30.dp.toPx() * triangleAnim
                )

                lineTo(
                    x = (canvasWidth / 2) + 50.dp.toPx() * triangleAnim,
                    y = canvasHeight - 30.dp.toPx() * triangleAnim
                )

                lineTo(
                    x = canvasWidth / 2,
                    y = canvasHeight - 100.dp.toPx()
                )
            }

            drawPath(
                path = trianglePath,
                brush = Brush.horizontalGradient(listOf(Color.Green, Color.Blue)),
            )
        }
    }
}