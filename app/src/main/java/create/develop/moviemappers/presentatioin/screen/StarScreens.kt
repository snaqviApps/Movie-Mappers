package create.develop.moviemappers.presentatioin.screen

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import create.develop.moviemappers.presentatioin.MovieScreensState
import create.develop.moviemappers.presentatioin.StarMainViewModel
import create.develop.moviemappers.data.movie.FetchMoviesService

@Composable
fun StarScreen(
    modifier: Modifier = Modifier,
    starViewModel: StarMainViewModel = StarMainViewModel(
        remoteMoviesRepository = FetchMoviesService()
    ),
) {
    val state by starViewModel.state.collectAsStateWithLifecycle()              // Stars
    val mState by starViewModel.mState.collectAsStateWithLifecycle()            // Movies

    val context = LocalContext.current

//  when {
//        state.isLoading -> {
//            LoadingScreen()
//        }
//
//        state.isError -> {
//            ErrorScreen(
//                modifier = modifier,
//                errorMessage = state.errorMessage
//            )
//        }
//
//        state.isSuccessful -> {
//            StarInfo(
//                modifier = modifier,
//                stars = state.stars,
//                onItemClicked = { name, distance ->
//                    starViewModel.onItemClicked(name, distance)
//                    Toast.makeText(
//                        context,
//                        "Star: $name, Distance: $distance",
//                        Toast.LENGTH_SHORT
//                    ).show()
//                }
//            )
//        }
//
//        state.isEmpty -> {
//            EmptyScreen(modifier = modifier)
//        }
//    }

    when (val movieState = mState) {
        is MovieScreensState.Loading -> {
            LoadingScreen()
        }
        is MovieScreensState.Error -> {
            ErrorScreen(
                modifier = modifier,
                errorMessage = movieState.errorMessage
            )
        }
        is MovieScreensState.Success -> {
            MovieInfo (
                modifier = modifier,
                movies = movieState.screenMovies,
                onItemClicked = { title, year ->
                    starViewModel.onItemClicked(title, year)
                    Toast.makeText(
                        context,
                        "Movie: $title, release year: $year",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            )
        }
        is MovieScreensState.Empty -> {
            EmptyScreen(modifier = modifier)
        }
    }

}

@Composable
fun LoadingScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(
            Modifier
                .size(180.dp)
                .padding(16.dp),
        )
    }
}

@Composable
fun ErrorScreen(modifier: Modifier, errorMessage: String?) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(
            text = errorMessage ?: "Unknown error",
            fontWeight = FontWeight.Bold,
            modifier = modifier.padding(24.dp)
        )
    }
}

@Composable
fun EmptyScreen(modifier: Modifier) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(
            text = "Empty data received",
            fontWeight = FontWeight.Bold,
            modifier = modifier.padding(24.dp)
        )
    }
}
