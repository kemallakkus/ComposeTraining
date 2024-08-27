package kemalakkus.composetraining.ui.examples

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle

@Composable
fun TextFieldComponent() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        var textInput by remember {
            mutableStateOf("")
        }

        TextField(
            value = textInput,
            onValueChange = { newText ->
                textInput = newText
            },
//            label = {
//                Text(text = "Enter your name")
//            },
            textStyle = TextStyle(
                color = Color.Blue,
//                fontSize = MaterialTheme.typography.titleLarge.fontSize,
                fontStyle = FontStyle.Normal
            ),
            placeholder = {
                Text(text = "Name")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Person Icon"
                )
            },
//            ,trailingIcon = {
////                Icon(
////                    imageVector = Icons.Default.Call,
////                    contentDescription = "Person Icon"
////                )
////            }
            minLines = 1,
            prefix = {
                Text(text = "Prefix:")
            },
            suffix = {
                Text(text = "Suffix: ")
            },
            supportingText = {
                Text(text = "Supporting Text")
            }
        )
    }
}