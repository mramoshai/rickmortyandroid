package com.haivision.mramos.rickandmorty.ui.characters

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.haivision.mramos.rickandmorty.api.ApiClient
import com.haivision.mramos.rickandmorty.api.MyResult
import com.haivision.mramos.rickandmorty.api.MyResult.Failure
import com.haivision.mramos.rickandmorty.api.MyResult.Success
import kotlinx.coroutines.launch

class CharactersViewModel : ViewModel() {

    private val _characters = MutableLiveData<MyResult<List<Character>>>()
    val moreCharacters: LiveData<MyResult<List<Character>>> = _characters
    private val client = ApiClient.client
    private var page = 1
    private var pages = Int.MAX_VALUE

    fun loadMoreCharacters() {
        if (page <= pages)
        viewModelScope.launch {
            _characters.value = try {
                with(client.getCharacters(page++)) {
                    pages = info.pages
                    Success(results)
                }
            } catch (e: Throwable) {
                Log.e("GET CHARACTERS", e.toString())
                Failure(e)
            }
        }
    }
}
