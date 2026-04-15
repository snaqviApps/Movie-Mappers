package create.develop.moviemappers.data.state

import create.develop.moviemappers.data.movie.Movie

sealed interface MovieUiState {
    object Loading : MovieUiState
    data class Error(val isError: Boolean) : MovieUiState
    data class Success(val movies: List<Movie> = emptyList()) : MovieUiState
}