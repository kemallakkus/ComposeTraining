package kemalakkus.composetraining.ui.examples

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun TextComponent() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        val textVisibilityState = remember {
            mutableStateOf(true)
        }

//        val textState = remember {
//            mutableStateOf("Visibility")
//        }

//        textState.value = if (textVisibilityState.value) "Text Visible" else "Text Invisible"

        val text = if (textVisibilityState.value) "Text Visible" else "Text Invisible"

        Text(
            modifier = Modifier
                .alpha(if (textVisibilityState.value) 1f else 0.3f)
                .background(if (textVisibilityState.value) Color.Green else Color.Red),
            text = text
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                textVisibilityState.value = !textVisibilityState.value
            }
        ) {
            Text(text = "Change Text Visibility")
        }
    }
}