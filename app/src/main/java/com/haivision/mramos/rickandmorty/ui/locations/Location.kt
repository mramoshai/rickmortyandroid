package com.haivision.mramos.rickandmorty.ui.locations

import java.util.*

data class Location (
    val id: Number,
    val name: String,
    val type: String,
    val dimension: String,
    val residents: List<String>,
    val url: String,
    val created: Date
)

val STATIC_LOCATIONS = listOf(
    Location(
        1,
        "Earth",
        "Planet",
        "C-37",
        listOf("https://rickandmortyapi.com/api/character/1",
        "https://rickandmortyapi.com/api/character/2"),
        "https://rickandmortyapi.com/api/location/1",
        Date()
    ),
    Location(
        2,
        "Abadango",
        "Cluster",
        "unknown",
        listOf("https://rickandmortyapi.com/api/character/3",
        "https://rickandmortyapi.com/api/character/5"),
        "https://rickandmortyapi.com/api/location/2",
        Date()
    ),
    Location(
        3,
        "Citadel of Ricks",
        "Space station",
        "unknown",
        listOf("https://rickandmortyapi.com/api/character/1",
        "https://rickandmortyapi.com/api/character/2"),
        "https://rickandmortyapi.com/api/location/1",
        Date()
    )

)
