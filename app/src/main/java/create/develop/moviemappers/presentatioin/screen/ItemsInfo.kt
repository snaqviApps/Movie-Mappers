package create.develop.moviemappers.presentatioin.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import create.develop.moviemappers.data.movie.MovieDto
import create.develop.moviemappers.data.star.Star

@Composable
fun StarInfo(
    modifier: Modifier = Modifier,
    stars: List<Star>,
    onItemClicked: (String, Double) -> Unit
) {
    LazyColumn(modifier
        .padding(top = 18.dp)
    ) {
        items(stars) { star ->
            StarCard(
                name = star.name,
                distanceFromSun = star.distanceFromSun,
                description = star.description,
                onItemClicked = onItemClicked
            )
        }
    }
}

@Composable
fun MovieInfo(
    modifier: Modifier = Modifier,
    movies: List<MovieDto>,
    onItemClicked: (String, Double) -> Unit
) {
    LazyColumn(modifier
        .padding(top = 18.dp)
    ){
        items(movies) { movie ->
            MovieCard(
                title = movie.title,
                poster = movie.poster ?: "",
                year = movie.year,
                plot = movie.plot ?: "",
                onItemClicked = onItemClicked
            )
        }
    }
}
