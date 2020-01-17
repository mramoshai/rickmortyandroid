package com.haivision.mramos.rickandmorty.api

import com.haivision.mramos.rickandmorty.ui.characters.Character
import retrofit2.http.GET

data class ApiResponse<T>(val info: ResponseInfo, val results: List<T>)
data class ResponseInfo(val count: Number, val pages: Number, val next: String, val prev: String)

interface ApiInterface {

    @GET("character")
    suspend fun getCharacters(): ApiResponse<Character>

}
