package create.develop.di

import create.develop.moviemappers.data.MoviesApi
import create.develop.moviemappers.data.movie.BASE_URL
import create.develop.moviemappers.data.movie.MovieRetrofitApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MoviesModule {

    @MovieRetrofitApi
    @Singleton
    @Provides
    fun provideMoviesApi(): MoviesApi =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MoviesApi::class.java)

}