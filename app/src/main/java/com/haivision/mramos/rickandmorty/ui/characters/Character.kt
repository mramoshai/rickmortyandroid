package com.haivision.mramos.rickandmorty.ui.characters

import java.util.Date

data class Character(
    val id: Number,
    val name: String,
    val status: Status,
    val species: String,
    val type: String,
    val gender: Gender,
    val origin: LocationLink,
    val location: LocationLink,
    val image: String,
    val episode: List<String>,
    val url: String,
    val created: Date
)

enum class Status (val status: String) {
    ALIVE("Alive"),
    DEAD("Dead"),
    UNKNOWN("Unknown")
}

enum class Gender (val gender: String) {
    MALE("male"),
    FEMALE("female"),
    GENDERLESS("Genderless"),
    UNKNOWN("Unknown")
}

data class LocationLink(
    val name: String,
    val url: String
)

val STATIC_CHARACTERS = listOf(
    Character(
        1,
        "Rick",
        Status.ALIVE,
        "human",
        "",
        Gender.MALE,
        LocationLink("earth", "https://rickandmortyapi.com/api/location/20"),
        LocationLink("earth", "https://rickandmortyapi.com/api/location/20"),
        "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
        listOf(
            "https://rickandmortyapi.com/api/episode/1",
            "https://rickandmortyapi.com/api/episode/2"
        ),
        "https://rickandmortyapi.com/api/character/1",
        Date()
    ),
    Character(
        2,
        "Morty",
        Status.ALIVE,
        "human",
        "",
        Gender.MALE,
        LocationLink("earth", "https://rickandmortyapi.com/api/location/20"),
        LocationLink("earth", "https://rickandmortyapi.com/api/location/20"),
        "https://rickandmortyapi.com/api/character/avatar/2.jpeg",
        listOf(
            "https://rickandmortyapi.com/api/episode/1",
            "https://rickandmortyapi.com/api/episode/2"
        ),
        "https://rickandmortyapi.com/api/character/2",
        Date()
    ),
    Character(
        3,
        "Summer",
        Status.ALIVE,
        "human",
        "",
        Gender.FEMALE,
        LocationLink("earth", "https://rickandmortyapi.com/api/location/20"),
        LocationLink("earth", "https://rickandmortyapi.com/api/location/20"),
        "https://rickandmortyapi.com/api/character/avatar/3.jpeg",
        listOf(
            "https://rickandmortyapi.com/api/episode/1",
            "https://rickandmortyapi.com/api/episode/2"
        ),
        "https://rickandmortyapi.com/api/character/3",
        Date()
    ),
    Character(
        162,
        "Ice T",
        Status.ALIVE,
        "alien",
        "Alphabetrian",
        Gender.MALE,
        LocationLink("Alphabetrium", "https://rickandmortyapi.com/api/location/43"),
        LocationLink("Alphabetrium", "https://rickandmortyapi.com/api/location/43"),
        "https://rickandmortyapi.com/api/character/avatar/162.jpeg",
        listOf(
            "https://rickandmortyapi.com/api/episode/1",
            "https://rickandmortyapi.com/api/episode/2"
        ),
        "https://rickandmortyapi.com/api/character/162",
        Date()
    )
)
