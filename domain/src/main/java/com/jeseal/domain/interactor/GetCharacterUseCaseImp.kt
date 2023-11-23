package com.jeseal.domain.interactor

import com.jeseal.domain.model.DetailedCharacter
import com.jeseal.domain.repository.CharacterRepository
import javax.inject.Inject

class GetCharacterUseCaseImp @Inject constructor(
    private val characterRepository: CharacterRepository
) : GetCharacterUseCase {
    override suspend fun invoke(id: String): DetailedCharacter? {
        return characterRepository.getCharacter(id)
    }
}