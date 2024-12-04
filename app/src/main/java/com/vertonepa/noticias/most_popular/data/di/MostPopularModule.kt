package com.vertonepa.noticias.most_popular.data.di

import com.vertonepa.noticias.most_popular.data.MostPopularProvider
import com.vertonepa.noticias.most_popular.data.MostPopularRepositoryImpl
import com.vertonepa.noticias.most_popular.domain.repository.MostPopularRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MostPopularModule {

    @Singleton
    @Provides
    fun provideMostPopularProvider(retrofit: Retrofit): MostPopularProvider =
        retrofit.create(MostPopularProvider::class.java)

    @Singleton
    @Provides
    fun provideMostPopularRepository(provider: MostPopularProvider): MostPopularRepository =
        MostPopularRepositoryImpl(provider)

}