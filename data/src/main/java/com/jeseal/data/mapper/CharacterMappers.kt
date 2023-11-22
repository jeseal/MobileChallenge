package com.jeseal.data.mapper

import com.jeseal.domain.model.Character
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

