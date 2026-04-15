package create.develop.moviemappers.presentatioin

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import create.develop.moviemappers.BuildConfig
import create.develop.moviemappers.data.star.Star
import create.develop.moviemappers.data.DataService
import create.develop.moviemappers.data.MoviesServiceGET
import create.develop.moviemappers.data.movie.FetchMoviesService
import create.develop.moviemappers.data.movie.Movie
import create.develop.moviemappers.data.movie.MovieDto
import create.develop.moviemappers.data.movie.toMovieDto
import create.develop.moviemappers.data.star.FetchLocalStarsService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class StarMainViewModel : ViewModel() {

    private val localStarsRepository: DataService<Star> = FetchLocalStarsService()
    private val remoteMoviesRepository: MoviesServiceGET = FetchMoviesService()
    private val _state = MutableStateFlow(StarUIState(isLoading = false))
    val state = _state.asStateFlow()

    private val _mState = MutableStateFlow<MovieScreensState>(MovieScreensState.Loading)
    val mState = _mState.asStateFlow()

    init {
        initiateServices()
    }

    private fun initiateServices() {

        val mList: MutableList<MovieDto> = mutableListOf()

        /** main coroutine with viewModel level scope */
        viewModelScope.launch {

            /** remote-service coroutine with with IO dispatcher */
            launch(Dispatchers.IO) {
                try {
                    for (movieCount in 0..9) {
                        when (movieCount) {
                            0 -> {
                                remoteMoviesRepository
                                    .getMovie(apiKey = BuildConfig.API_KEY)
                                    .apply {
                                        addMovie(mList = mList, movieDto = toMovieDto())
                                    }
                            }

                            1 -> {
                                remoteMoviesRepository
                                    .getMovie(id = "tt0111503", apiKey = BuildConfig.API_KEY)
                                    .apply {
                                        addMovie(mList = mList, movieDto = toMovieDto())
                                    }
                            }

                            2 -> {
                                remoteMoviesRepository
                                    .getMovie(
                                        id = "tt0107290",                                                // Title: Jurassic Park
                                        apiKey = BuildConfig.API_KEY
                                    )
                                    .apply {
                                        addMovie(mList = mList, movieDto = toMovieDto())
                                    }
                            }

                            3 -> {
                                remoteMoviesRepository
                                    .getMovie(
                                        id = "tt0086250",
                                        apiKey = BuildConfig.API_KEY
                                    )          // Title: Scarface
                                    .apply {
                                        addMovie(mList = mList, movieDto = toMovieDto())
                                    }
                            }

                            4 -> {
                                remoteMoviesRepository
                                    .getMovie(
                                        id = "tt0116629",
                                        apiKey = BuildConfig.API_KEY
                                    )          // Title: Independence Day
                                    .apply {
                                        addMovie(mList = mList, movieDto = toMovieDto())
                                    }
                            }

                            5 -> {
                                remoteMoviesRepository
                                    .getMovie(
                                        id = "tt0160009",                                               // Title: Independence Day
                                        apiKey = BuildConfig.API_KEY
                                    )
                                    .apply {
                                        addMovie(mList = mList, movieDto = toMovieDto())
                                    }
                            }

                            6 -> {
                                remoteMoviesRepository
                                    .getMovie(
                                        id = "tt0043654",                                               // Title: Independence Day
                                        apiKey = BuildConfig.API_KEY
                                    )
                                    .apply {
                                        addMovie(mList = mList, movieDto = toMovieDto())
                                    }
                                Log.d(
                                    "movieList",
                                    "repo ${movieCount}. : ${mList[0]}\nrepo ${movieCount}. : ${mList[6]}\n"
                                )
                            }

                            7 -> {
                                remoteMoviesRepository
                                    .getMovie(
                                        id = "tt7131622",                                               // Title: Independence Day
                                        apiKey = BuildConfig.API_KEY
                                    )
                                    .apply {
                                        addMovie(mList = mList, movieDto = toMovieDto())
                                    }
                            }

                            8 -> {
                                remoteMoviesRepository
                                    .getMovie(
                                        id = "tt0062622",                                               // Title: Independence Day
                                        apiKey = BuildConfig.API_KEY
                                    )
                                    .apply {
                                        addMovie(mList = mList, movieDto = toMovieDto())
                                    }
                            }

                            9 -> {
                                remoteMoviesRepository
                                    .getMovie(
                                        id = "tt24714414",                                               // Title: Sherri Papini: Lies, Lies, and More Lies
                                        apiKey = BuildConfig.API_KEY
                                    )
                                    .apply {
                                        addMovie(mList = mList, movieDto = toMovieDto())
                                    }
                            }

                        }
                    }

                    _mState.update {
                        MovieScreensState.Success(screenMovies = mList)
                    }

                } catch (e: Exception) {
                    _state.update {
                        StarUIState(
                            isLoading = false,
                            isError = true,
                            isEmpty = false,
                            errorMessage = "unable to receive movie-data"
                        )
                    }
                    Log.e(
                        "movieList",
                        e.message ?: "Error fetching movie", e.also { it.printStackTrace() }
                    )
                }
            }

            /**
             * Local-service coroutine with with Default dispatcher
             * 'LocalStarsRepository()'
             * */
//            launch {
//                withContext(Dispatchers.Default) {
//
//                    _state.update {
//                        StarUIState(isLoading = true)
//                    }
//                    delay(3.seconds)
//                    _state.update {
//                        StarUIState(isLoading = false)
//                    }
//
//                    //fetch Stars
//                    when ((0..2).random()) {
//                        0 -> {
//                            _state.update {
//                                StarUIState(
//                                    isError = true,
//                                    errorMessage = "something went wrong"
//                                )
//                            }
//                        }
//
//                        1 -> {
//                            _state.update {
//                                StarUIState(
//                                    isEmpty = true,
//                                )
//                            }
//                        }
//
//                        2 -> {
//                            _state.update {
//                                StarUIState(
//                                    isSuccessful = true,
//                                    stars = localStarsRepository.fetchStar()
//                                )
//                            }
//                        }
//                    }
//                }
//            }

        }
    }

    private fun Movie.addMovie(
        mList: MutableList<MovieDto>,
        movieDto: MovieDto
    ) {
        mList.add(movieDto)
    }


    fun onItemClicked(
        name: String,
        index: Double = 0.0
    ) {
        val triple = Triple(name, index, "Hello:     $name + $index")
        Log.d("TAG", "onItemClicked: $name, distance: $index, ${triple.third}")
    }
}
