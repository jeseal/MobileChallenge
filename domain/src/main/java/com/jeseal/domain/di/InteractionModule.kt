package com.jeseal.domain.di

import com.jeseal.domain.interactor.GetCharactersUseCase
import com.jeseal.domain.interactor.GetCharactersUseCaseImp
import com.jeseal.domain.repository.CharacterRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object InteractionModule {

    @Provides
    fun getCharactersUseCase(characterRepository: CharacterRepository): GetCharactersUseCase =
        GetCharactersUseCaseImp(characterRepository)
}