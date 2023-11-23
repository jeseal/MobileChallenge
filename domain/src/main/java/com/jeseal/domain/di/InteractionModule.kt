package com.jeseal.domain.di

import com.jeseal.domain.interactor.GetCharacterUseCase
import com.jeseal.domain.interactor.GetCharacterUseCaseImp
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

    @Provides
    fun getCharacterUseCase(characterRepository: CharacterRepository): GetCharacterUseCase =
        GetCharacterUseCaseImp(characterRepository)
}
