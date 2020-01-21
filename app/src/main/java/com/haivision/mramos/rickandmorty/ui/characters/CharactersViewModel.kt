package com.haivision.mramos.rickandmorty.ui.characters

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.haivision.mramos.rickandmorty.api.ApiClient
import kotlinx.coroutines.launch

class CharactersViewModel : ViewModel() {

    private val _characters = MutableLiveData<List<Character>>()
    val characters: LiveData<List<Character>> = _characters
    private val client = ApiClient.getClient
    private var page = 1
    fun loadCharacters() {
        viewModelScope.launch {
            _characters.value = try {
                client.getCharacters(page++).results
            } catch (e: Throwable) {
                Log.e("GET CHARACTERS", e.toString())
                listOf()
            }
        }
    }
}
