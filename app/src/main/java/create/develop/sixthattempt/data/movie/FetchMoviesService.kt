package create.develop.moviemappers.data.movie

import create.develop.moviemappers.data.MoviesServiceGET
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://www.omdbapi.com/"

class FetchMoviesService : MoviesServiceGET {
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