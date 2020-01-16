package com.haivision.mramos.rickandmorty.ui.characters

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CharactersViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is characters Fragment"
    }
    val text: LiveData<String> = _text
}