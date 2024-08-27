package kemalakkus.composetraining.ui.examples

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TextStyles() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(200.dp))

        val shadowOffset = Offset(5f, 10f)

        Text(
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            text = buildAnnotatedString {
                withStyle(
                    SpanStyle(
                        shadow = Shadow(
                            color = Color.Gray,
                            offset = shadowOffset,
                            blurRadius = 9f
                        )
                    )
                ) {
                    append("Hello ")
                }
                withStyle(
                    SpanStyle(
                        color = Color.Red,
                        fontSize = 30.sp,
                        fontStyle = FontStyle.Normal,
                        fontWeight = FontWeight.Bold,
                        textDecoration = TextDecoration.LineThrough
                    )
                ) {
                    append("Android ")
                }
                withStyle(
                    SpanStyle(
                        color = Color.Black,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.ExtraBold,
                        textDecoration = TextDecoration.None
                    )
                ) {
                    append(" Kotlin ")
                }

            },
            color = Color.Blue,
            fontSize = 22.sp,
            fontWeight = FontWeight.ExtraBold,
            fontStyle = FontStyle.Italic,
            textDecoration = TextDecoration.Underline,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
    }
}