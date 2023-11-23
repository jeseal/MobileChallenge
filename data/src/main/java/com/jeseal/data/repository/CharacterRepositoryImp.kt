package com.jeseal.data.repository

import com.apollographql.apollo3.ApolloClient
import com.jeseal.data.mapper.toDetailedCharacter
import com.jeseal.data.mapper.toDomainCharacter
import com.jeseal.domain.model.Character
import com.jeseal.domain.model.DetailedCharacter
import com.jeseal.domain.repository.CharacterRepository
import com.jeseal.mobilechallenge.CharacterQuery
import com.jeseal.mobilechallenge.CharactersQuery
import javax.inject.Inject

class CharacterRepositoryImp @Inject constructor(
    private val apolloClient: ApolloClient
) : CharacterRepository {
    override suspend fun getCharacters(): List<Character?> {
        return apolloClient
            .query(CharactersQuery())
            .execute()
            .data
            ?.characters
            ?.results
            ?.map { it?.toDomainCharacter() }
            ?: emptyList()
    }

    override suspend fun getCharacter(id: String): DetailedCharacter? {
        return apolloClient
            .query(CharacterQuery(id))
            .execute()
            .data
            ?.character
            ?.toDetailedCharacter()

    }
}