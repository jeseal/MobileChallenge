package com.jeseal.domain.interactor

import com.jeseal.domain.model.DetailedCharacter

interface GetCharacterUseCase {
    suspend fun invoke(id: String?): DetailedCharacter?
}