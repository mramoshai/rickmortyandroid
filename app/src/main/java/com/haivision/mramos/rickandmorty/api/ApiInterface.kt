package com.haivision.mramos.rickandmorty.api

import com.haivision.mramos.rickandmorty.ui.characters.Character
import com.haivision.mramos.rickandmorty.ui.locations.Location
import retrofit2.http.GET
import retrofit2.http.Query

data class ApiResponse<T>(val info: ResponseInfo, val results: List<T>)
data class ResponseInfo(val count: Int, val pages: Int, val next: String, val prev: String)

interface ApiInterface {

    @GET("character")
    suspend fun getCharacters(@Query("page") page: Int = 1): ApiResponse<Character>

    @GET("location")
    suspend fun getLocations(@Query("page") page: Int = 1): ApiResponse<Location>
}
