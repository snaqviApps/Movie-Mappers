package create.develop.moviemappers.data.movie

import com.google.gson.annotations.SerializedName

data class Rating(
    @SerializedName("Source") val source: String?,
    @SerializedName("Value") val value: String?
)