package kemalakkus.composetraining.ui.examples

import android.animation.Keyframe
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColor
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun AnimationTraining() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                top = WindowInsets.statusBars
                    .asPaddingValues()
                    .calculateTopPadding()
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        var visible by remember {
            mutableStateOf(false)
        }

        val size by animateDpAsState(
            targetValue = if (visible) 300.dp else 20.dp,
            label = "size",
        )

        val color by animateColorAsState(
            targetValue = if (visible) Color.Blue else Color.Green,
            animationSpec = tween(1000, 100, FastOutSlowInEasing),
            label = "color"
        )

        val transition = rememberInfiniteTransition(label = "transition")

        val color2 by transition.animateColor(
            initialValue = Color.Magenta,
            targetValue = Color.Red,
            animationSpec = infiniteRepeatable(
                tween(durationMillis = 500,  easing = LinearEasing)
            ),
            label = "color2"
        )

        val corner by animateDpAsState(
            targetValue = if (visible) 300.dp else 0.dp,
            label = "size",
        )


        Spacer(modifier = Modifier.height(50.dp))

        Button(onClick = {
            visible = !visible
        }) {
            if (visible) {
                Text(text = "Square")
            } else {
                Text(text = "Circle")
            }
        }

        Spacer(modifier = Modifier.height(50.dp))

        Column(
            modifier = Modifier
                .size(300.dp)
                .clip(RoundedCornerShape(corner))
                .background(color2)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


//            AnimatedVisibility(
//                visible = visible,
//                modifier = Modifier.align(Alignment.CenterHorizontally),
//                enter = slideInHorizontally() + fadeIn(),
//                exit = slideOutHorizontally() + fadeOut(),
//                label = "AnimatedVisibility",
//                content = {
//                    Box(
//                        modifier = Modifier
//                            .size(200.dp)
//                            .background(MaterialTheme.colorScheme.error)
//                    )
//                }
//            )
        }
    }
}