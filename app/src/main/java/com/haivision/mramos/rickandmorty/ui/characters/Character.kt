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

// TODO does not work
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
