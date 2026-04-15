package create.develop.moviemappers.presentatioin

import create.develop.moviemappers.data.movie.MovieDto
import create.develop.moviemappers.data.star.Star

sealed interface StarsScreensState {

    object Loading : StarsScreensState

    data class Empty(val emptyMessage: String) : StarsScreensState
    data class Error(val isError: Boolean) : StarsScreensState
    data class Success(val stars: List<Star> = emptyList()) : StarsScreensState
}

sealed interface MovieScreensState {

    object Loading : MovieScreensState

    data class Empty(val emptyDataMessage: String) : MovieScreensState
    data class Error(val isError: Boolean, val errorMessage: String = "") : MovieScreensState
    data class Success(val screenMovies: List<MovieDto>) : MovieScreensState
}

