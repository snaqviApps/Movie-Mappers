package create.develop.moviemappers.data.movie

import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("Actors") val actors: String?,
    @SerializedName("Awards") val awards: String?,
    @SerializedName("BoxOffice") val boxOffice: String?,
    @SerializedName("Country") val country: String?,
    @SerializedName("DVD") val dvd: String?,
    @SerializedName("Director") val director: String?,
    @SerializedName("Genre") val genre: String?,
    @SerializedName("Language") val language: String?,
    @SerializedName("Metascore") val metascore: String?,
    @SerializedName("Plot") val plot: String?,
    @SerializedName("Poster") val poster: String?,
    @SerializedName("Production") val production: String?,
    @SerializedName("Rated") val rated: String?,
    @SerializedName("Ratings") val ratings: List<Rating>?,
    @SerializedName("Released") val released: String?,
    @SerializedName("Response") val response: String?,
    @SerializedName("Title") val title: String?,
    @SerializedName("Type") val type: String?,
    @SerializedName("Website") val website: String?,
    @SerializedName("Writer") val writer: String?,
    @SerializedName("Year") val year: String?,

    val imdbID: String?,
    val imdbRating: String?,
    val imdbVotes: String?
) {
    val meM = this
}

data class MovieDto(
    val poster: String? = "",
    val ratings: List<Rating> = emptyList(),
    val plot: String? = "",
    val released: String = "",
    val title: String = "",
    val year: String = "",
    val imdbID: String = "",
)

fun Movie.toMovieDto(): MovieDto {
    return MovieDto(
        poster = poster,
        ratings = ratings ?: emptyList(),
        released = released ?: "",
        plot = plot ?: "",
        title = title ?: "",
        year = year ?: "",
        imdbID = imdbID ?: "",
    )
}