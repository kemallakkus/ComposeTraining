package kemalakkus.composetraining

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kemalakkus.composetraining.ui.examples.ImageComponent
import kemalakkus.composetraining.ui.examples.LazyColumnComponent
import kemalakkus.composetraining.ui.examples.LazyComponentsSelectScreen
import kemalakkus.composetraining.ui.examples.LazyGridComponent
import kemalakkus.composetraining.ui.examples.LazyRowComponent
import kemalakkus.composetraining.ui.examples.TextStyles
import kemalakkus.composetraining.ui.theme.ComposeTrainingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeTrainingTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navHostController = rememberNavController()
                    NavHost(
                        navController = navHostController,
                        startDestination = "lazy_components_select_screen"
                    ) {
                        composable("lazy_components_select_screen") {
                            LazyComponentsSelectScreen(navHostController = navHostController)
                        }
                        composable("lazy_row_screen") {
                            LazyRowComponent()
                        }
                        composable("lazy_column_screen") {
                            LazyColumnComponent()
                    }
                        composable("lazy_grid_screen") {
                            LazyGridComponent()
                        }
                    }
                }
            }
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
        SecondUi()
    }
}