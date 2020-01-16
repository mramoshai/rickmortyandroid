package com.haivision.mramos.rickandmorty.ui.characters

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CharactersViewModel : ViewModel() {

    private val _characters = MutableLiveData<List<Character>>().apply {
        value = getCharacters()
    }
    val characters: LiveData<List<Character>> = _characters

    private fun getCharacters(): List<Character> {
        return STATIC_CHARACTERS
    }
}