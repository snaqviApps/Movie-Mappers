package create.develop.moviemappers.data.movie

import create.develop.moviemappers.data.MoviesServiceGET
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

const val BASE_URL = "https://www.omdbapi.com/"


class FetchMoviesService @Inject constructor() : MoviesServiceGET {     /** Movie repository Impl */
    override suspend fun getMovie(
        id: String,
        apiKey: String
    ): Movie {
        return RetrofitInstance
            .movieApi
            .getMovie(id, apiKey)
    }
}

object RetrofitInstance {

    val movieApi: MoviesServiceGET by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MoviesServiceGET::class.java)
    }
}