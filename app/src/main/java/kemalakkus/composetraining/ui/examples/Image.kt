package kemalakkus.composetraining.ui.examples

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ImagesearchRoller
import androidx.compose.material.icons.rounded.ImageNotSupported
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import kemalakkus.composetraining.R

@Composable
fun ImageComponent() {

    Column(
        modifier = Modifier
            .padding(
                top = WindowInsets.statusBars
                    .asPaddingValues()
                    .calculateTopPadding()
            )
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            modifier = Modifier
                .clip(RoundedCornerShape(12.dp)),
            painter = painterResource(id = R.drawable.image),
            contentDescription = null
        )

        Spacer(modifier = Modifier.height(20.dp))

        val imageUrl =
            "https://dfstudio-d420.kxcdn.com/wordpress/wp-content/uploads/2019/06/digital_camera_photo-980x653.jpg"

        val model = ImageRequest
            .Builder(LocalContext.current)
            .data(imageUrl)
            .size(Size.ORIGINAL)
            .build()

        Spacer(modifier = Modifier.height(20.dp))


        val imageState = rememberAsyncImagePainter(model = model).state

        Box(
            modifier = Modifier
                .size(300.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(Color.LightGray),
        ) {

            when(imageState) {
                is AsyncImagePainter.State.Error -> {
                    Icon(
                        modifier = Modifier.size(20.dp).align(Alignment.Center),
                        imageVector = Icons.Filled.ImagesearchRoller,
                        contentDescription = null
                    )
                }
                is AsyncImagePainter.State.Loading -> {
                    CircularProgressIndicator(
                        color = Color.Blue,
                        modifier = Modifier.size(20.dp).align(Alignment.Center),
                        strokeWidth = 2.dp
                    )
                }
                is AsyncImagePainter.State.Success -> {
                    Image(
                        modifier = Modifier
                            .fillMaxSize(),
                        contentScale = ContentScale.Crop,
                        painter = imageState.painter,
                        contentDescription = null
                    )
                }

                AsyncImagePainter.State.Empty -> TODO()
            }

//            if (imageState is AsyncImagePainter.State.Success) {
//                Image(
//                    modifier = Modifier
//                        .fillMaxSize(),
//                    contentScale = ContentScale.Crop,
//                    painter = imageState.painter,
//                    contentDescription = null
//                )
//            }
//
//            if (imageState is AsyncImagePainter.State.Loading) {
//                CircularProgressIndicator(
//                    color = Color.Blue,
//                    modifier = Modifier.size(20.dp).align(Alignment.Center),
//                    strokeWidth = 2.dp
//                )
//            }
//
//            if (imageState is AsyncImagePainter.State.Error) {
//                Icon(
//                    modifier = Modifier.size(20.dp).align(Alignment.Center),
//                    imageVector = Icons.Filled.ImagesearchRoller,
//                    contentDescription = null
//                )
//            }
        }
    }
}