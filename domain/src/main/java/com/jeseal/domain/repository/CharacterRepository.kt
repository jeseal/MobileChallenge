package com.jeseal.domain.repository

import com.jeseal.domain.model.Character
import com.jeseal.domain.model.DetailedCharacter

interface CharacterRepository {
    suspend fun getCharacters(): List<Character?>
    suspend fun getCharacter(id: String): DetailedCharacter?
}