package create.develop.moviemappers.data

import create.develop.moviemappers.data.movie.Movie
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface DataService<T> {
    suspend fun fetchStar(): List<T>
}

// https://www.omdbapi.com/?t=Social+Network&apikey=44b9d35c

interface MoviesServiceGET {
    @GET("/")
    suspend fun getMovie(
        @Query("i") id: String = "tt3896198",       // Title: Guardians of the Galaxy Vol. 2
        @Query("apikey") apiKey: String
    ): Movie


}


interface MoviesServicePOST {
    @POST("Movie")
    suspend fun addMovie(movie: Movie) : Unit       // check possible Response type
}
