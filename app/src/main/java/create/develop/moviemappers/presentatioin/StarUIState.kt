package create.develop.moviemappers.presentatioin

import create.develop.moviemappers.data.star.Star

data class StarUIState(
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val isEmpty: Boolean = false,
    val errorMessage: String = "",
    val isSuccessful: Boolean = false,
    val stars: List<Star> = emptyList(),
    val starsScreensState: StarsScreensState = StarsScreensState
        .Empty("Empty data received")
)


