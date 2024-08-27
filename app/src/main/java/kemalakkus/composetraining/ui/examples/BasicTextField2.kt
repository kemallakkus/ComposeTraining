package kemalakkus.composetraining.ui.examples

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text2.BasicTextField2
import androidx.compose.foundation.text2.input.TextFieldLineLimits
import androidx.compose.foundation.text2.input.rememberTextFieldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BasicTextField2Component() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        /**
         * burada artık rememberTextFieldState() ile direkt state imizi veririz ve value ve onValueChange'e
         * ihtiyacımız kalmaz.
         */
        /**
         * burada artık rememberTextFieldState() ile direkt state imizi veririz ve value ve onValueChange'e
         * ihtiyacımız kalmaz.
         */
        val textInputState = rememberTextFieldState()

        BasicTextField2(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .clip(RoundedCornerShape(30.dp))
                .background(Color.LightGray)
                .padding(16.dp),
            state = textInputState,
            cursorBrush = SolidColor(Color.Cyan),
            lineLimits = TextFieldLineLimits.SingleLine,
            textStyle = TextStyle(
                color = Color.Blue,
//                fontSize = MaterialTheme.typography.titleLarge.fontSize,
                fontStyle = FontStyle.Italic
            ),
            decorator = { innerTextField ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = null
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Box(
                        modifier = Modifier.weight(1f),
                    ) {
                        if (textInputState.text.isEmpty()) {
                            Text(
                                text = "Search",
                                color = Color.Gray
                            )
                        }
                        innerTextField()
                    }
                    if (textInputState.text.isNotEmpty()) {
                        Spacer(modifier = Modifier.width(8.dp))
                        Icon(
                            modifier = Modifier.clickable {
                                textInputState.edit {
                                    this.replace(0, this.length, "")
                                }
                            },
                            imageVector = Icons.Default.Close,
                            contentDescription = null
                        )
                    }
                }
            }
        )
    }
}