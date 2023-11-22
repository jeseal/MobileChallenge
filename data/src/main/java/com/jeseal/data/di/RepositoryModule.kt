package com.jeseal.data.di

import com.apollographql.apollo3.ApolloClient
import com.jeseal.data.repository.CharacterRepositoryImp
import com.jeseal.domain.repository.CharacterRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideCharacterRepository(
        apolloClient: ApolloClient
    ): CharacterRepository = CharacterRepositoryImp(apolloClient)
}