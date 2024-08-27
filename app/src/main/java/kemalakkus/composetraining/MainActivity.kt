package kemalakkus.composetraining

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text2.BasicTextField2
import androidx.compose.foundation.text2.input.TextFieldLineLimits
import androidx.compose.foundation.text2.input.rememberTextFieldState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kemalakkus.composetraining.ui.theme.ComposeTrainingTheme
import kemalakkus.composetraining.ui.theme.font

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeTrainingTheme {
                TextStyles()
            }
        }
    }
}

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


@Composable
fun BasicTextFieldComponent() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        var textInput by remember {
            mutableStateOf("")
        }

        BasicTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .clip(RoundedCornerShape(30.dp))
                .background(Color.LightGray)
                .padding(16.dp),
            value = textInput,
            onValueChange = { newText ->
                textInput = newText
            },
            cursorBrush = SolidColor(Color.Cyan),
            maxLines = 1,
            singleLine = true,
            textStyle = TextStyle(
                color = Color.Blue,
//                fontSize = MaterialTheme.typography.titleLarge.fontSize,
                fontStyle = FontStyle.Italic
            ),
            decorationBox = { innerTextField ->
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
                        if (textInput.isEmpty()) {
                            Text(
                                text = "Search",
                                color = Color.Gray
                            )
                        }
                        innerTextField()
                    }
                    if (textInput.isNotEmpty()) {
                        Spacer(modifier = Modifier.width(8.dp))
                        Icon(
                            modifier = Modifier.clickable {
                                textInput = ""
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

@Composable
fun SecondUi() {
    Column(
        modifier = Modifier
            .padding(
                top = WindowInsets.statusBars
                    .asPaddingValues()
                    .calculateTopPadding()
            )
            .fillMaxWidth()
            .fillMaxHeight(0.5f)
            .padding(12.dp)
            .clip(RoundedCornerShape(12.dp))
            .border(5.dp, Color.Green)
            .padding(12.dp)
            .clip(RoundedCornerShape(12.dp))
            .border(5.dp, Color.Yellow)
            .verticalScroll(rememberScrollState())
            .background(MaterialTheme.colorScheme.error)
    ) {
        Button(
            modifier = Modifier
                .padding(start = 56.dp),
            onClick = { /*TODO*/ }) {
            Text(text = "android")
        }
        Button(onClick = { /*TODO*/ }) {
            Text(text = "compose")
        }
    }
}

@Composable
fun FirstUi() {
    Box(
        modifier = Modifier
            .padding(
                top = WindowInsets.statusBars
                    .asPaddingValues()
                    .calculateTopPadding()
            )
            .fillMaxHeight()
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.primaryContainer)
    ) {
        Button(
            modifier = Modifier.align(Alignment.Center),
            onClick = {}
        ) {
            Text(text = "android")
        }
        Button(
            modifier = Modifier.align(Alignment.BottomEnd),
            onClick = {}
        ) {
            Text(text = "compose")
        }
        Button(
            modifier = Modifier.align(Alignment.TopStart),
            onClick = {}
        ) {
            Text(text = "kotlin")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeTrainingTheme {
        TextFieldComponent()
    }
}