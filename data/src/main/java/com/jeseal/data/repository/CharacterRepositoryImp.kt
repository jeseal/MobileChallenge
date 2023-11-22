package com.jeseal.data.repository

import com.apollographql.apollo3.ApolloClient
import com.jeseal.data.mapper.toDomainCharacter
import com.jeseal.domain.model.Character
import com.jeseal.domain.repository.CharacterRepository
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
}