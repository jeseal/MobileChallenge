package com.jeseal.domain.repository

import com.jeseal.domain.model.Character

interface CharacterRepository {
    suspend fun getCharacters(): List<Character?>
}