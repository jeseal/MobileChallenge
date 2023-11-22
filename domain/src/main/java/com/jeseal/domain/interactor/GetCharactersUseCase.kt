package com.jeseal.domain.interactor

import com.jeseal.domain.model.Character

interface GetCharactersUseCase{
    suspend fun invoke():List<Character?>
}