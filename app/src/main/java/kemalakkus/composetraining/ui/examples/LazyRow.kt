package kemalakkus.composetraining.ui.examples

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun LazyRowComponent() {
    LazyRow(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(12.dp),
    ) {
        itemsIndexed(List.items) { index, item ->
            Spacer(modifier = Modifier.width(8.dp))
            RowItem(item = item)
            Spacer(modifier = Modifier.width(8.dp))
        }
    }
}

@Composable
fun RowItem(
    item: Item,
) {
    Column(
        modifier = Modifier
            .height(400.dp)
            .width(200.dp)
            .padding(
                top = WindowInsets.statusBars.asPaddingValues().calculateTopPadding()
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .clip(RoundedCornerShape(12.dp)),
            painter = painterResource(id = item.image),
            contentDescription = item.title,
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = item.title,
            fontWeight = FontWeight.ExtraBold
        )

    }
}