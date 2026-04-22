package create.develop.di

import create.develop.moviemappers.data.MoviesApi
import create.develop.moviemappers.data.movie.FetchMoviesService
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindsFetchMoviesService(fetchMoviesService: FetchMoviesService): MoviesApi

}