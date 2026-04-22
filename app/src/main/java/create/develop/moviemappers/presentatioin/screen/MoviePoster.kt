package create.develop.moviemappers.presentatioin.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.SubcomposeAsyncImage
import create.develop.moviemappers.R

@Composable
fun MoviePoster(
    poster: String,
    imageId: Int = R.drawable.outline_movie_24,
    onItemClicked: (String, Double) -> Unit
) {
    SubcomposeAsyncImage(
        model = poster,
        contentDescription = stringResource(R.string.moviePoster),
        loading = {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(modifier = Modifier.size(24.dp))
            }
        },
        error = {
            painterResource(imageId)
        },
        modifier = Modifier
            .size(80.dp, 100.dp)
    )

//    AsyncImage(
//        model = poster,
//        contentDescription = stringResource(R.string.moviePoster),
//        modifier = Modifier
//            .size(80.dp, 100.dp)
//    )
}
