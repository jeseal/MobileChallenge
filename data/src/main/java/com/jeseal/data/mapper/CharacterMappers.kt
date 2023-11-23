package com.jeseal.data.mapper

import com.jeseal.domain.model.Character
import com.jeseal.domain.model.DetailedCharacter
import com.jeseal.mobilechallenge.CharacterQuery
import com.jeseal.mobilechallenge.CharactersQuery

fun CharactersQuery.Result.toDomainCharacter(): Character {
    return Character(
        id = id,
        name = name,
        species = species,
        gender = gender,
        image = image
    )
}

fun CharacterQuery.Character.toDetailedCharacter(): DetailedCharacter{
    return DetailedCharacter(
        id = id,
        name = name,
        type = type,
        gender = gender,
        status = status,
        location = location?.name,
        origin = origin?.name,
        image = image,
        species = species
    )
}

