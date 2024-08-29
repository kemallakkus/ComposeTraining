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
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Apps
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Apps
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kemalakkus.composetraining.ui.examples.AnimationTraining
import kemalakkus.composetraining.ui.examples.CanvasTraining
import kemalakkus.composetraining.ui.theme.ComposeTrainingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeTrainingTheme {

                CanvasTraining()
                /**
                 * botttom navbar örneğinin state i
                 */

//                var selected by remember {
//                    mutableStateOf(0)
//                }

                /**
                 * botttom navbar örneği
                 */

//                Scaffold(
//                    bottomBar = {
//                        NavigationBar {
//                            bottomNavItems.forEachIndexed { index, bottomNavigationItem ->
//                                NavigationBarItem(
//                                    selected = index == selected,
//                                    onClick = {
//                                        selected = index
////                                        navController.navigate(bottomNavigationItem.route)
//                                    },
//                                    icon = {
//                                        BadgedBox(
//                                            badge = {
//                                                if (bottomNavigationItem.badgeCount != 0) {
//                                                    Badge {
//                                                        Text(text = bottomNavigationItem.badgeCount.toString())
//                                                    }
//                                                } else if (bottomNavigationItem.hasNews) {
//                                                    Badge()
//                                                }
//                                            }
//                                        ) {
//                                            Icon(
//                                                imageVector = if (index == selected) bottomNavigationItem.selectedIcon else bottomNavigationItem.unselectedIcon,
//                                                contentDescription = null
//                                            )
//                                        }
//                                    },
//                                    label = {
//                                        Text(text = bottomNavigationItem.title)
//                                    }
//                                )
//                            }
//
//                        }
//                    }
//                ) {
//                    val paddingValues = it
//                }

                /**
                 * navigation örneği
                 */

//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
//                    val navHostController = rememberNavController()
//                    NavHost(
//                        navController = navHostController,
//                        startDestination = "lazy_components_select_screen"
//                    ) {
//                        composable("lazy_components_select_screen") {
//                            LazyComponentsSelectScreen(navHostController = navHostController)
//                        }
//                        composable("lazy_row_screen") {
//                            LazyRowComponent()
//                        }
//                        composable("lazy_column_screen") {
//                            LazyColumnComponent()
//                    }
//                        composable("lazy_grid_screen") {
//                            LazyGridComponent()
//                        }
//                    }
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

val bottomNavItems = listOf(
    BottomNavigationItem(
        title = "Home",
        route = "home",
        selectedIcon = Icons.Filled.Home,
        unselectedIcon = Icons.Outlined.Home,
        hasNews = false,
        badgeCount = 0
    ),
    BottomNavigationItem(
        title = "Posts",
        route = "posts",
        selectedIcon = Icons.Filled.Apps,
        unselectedIcon = Icons.Outlined.Apps,
        hasNews = false,
        badgeCount = 0
    ),
    BottomNavigationItem(
        title = "Notifications",
        route = "notifications",
        selectedIcon = Icons.Filled.Notifications,
        unselectedIcon = Icons.Outlined.Notifications,
        hasNews = false,
        badgeCount = 5
    ),
    BottomNavigationItem(
        title = "Profile",
        route = "profile",
        selectedIcon = Icons.Filled.Person,
        unselectedIcon = Icons.Outlined.Person,
        hasNews = true,
        badgeCount = 0
    )
)


data class BottomNavigationItem(
    val title: String,
    val route: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val hasNews: Boolean,
    val badgeCount: Int? = null,
)