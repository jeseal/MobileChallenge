package com.jeseal.domain.interactor

import com.jeseal.domain.model.Character
import com.jeseal.domain.repository.CharacterRepository
import javax.inject.Inject

class GetCharactersUseCaseImp @Inject constructor(
    private val characterRepository: CharacterRepository
): GetCharactersUseCase {
    override suspend fun invoke(): List<Character?> {
        return characterRepository
            .getCharacters()
            //.sortedBy { it?.name }
    }
}