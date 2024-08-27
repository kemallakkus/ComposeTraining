package kemalakkus.composetraining.ui.examples

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun LazyComponentsSelectScreen(
    navHostController: NavHostController,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Button(
            onClick = {
                navHostController.navigate("lazy_row_screen")
            },
        ) {
            Text(text = "Lazy Row")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                navHostController.navigate("lazy_column_screen")
            },
        ) {
            Text(text = "Lazy Column")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                navHostController.navigate("lazy_grid_screen")
            },
        ) {
            Text(text = "Lazy Grid")
        }
    }
}