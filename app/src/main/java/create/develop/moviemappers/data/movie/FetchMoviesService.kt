package create.develop.moviemappers.data.movie

import create.develop.moviemappers.data.MoviesApi
import javax.inject.Inject
import javax.inject.Qualifier

const val BASE_URL = "https://www.omdbapi.com/"

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class MovieRetrofitApi

/** Movie repository Impl */
class FetchMoviesService @Inject constructor(
    @MovieRetrofitApi private val moviesApi: MoviesApi
) : MoviesApi {

    override suspend fun getMovie(
        id: String,
        apiKey: String
    ): Movie {
        return moviesApi
            .getMovie(id, apiKey)
    }
}


