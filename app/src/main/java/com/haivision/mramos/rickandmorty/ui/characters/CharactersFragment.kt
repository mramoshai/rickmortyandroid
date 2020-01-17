package com.haivision.mramos.rickandmorty.ui.characters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.haivision.mramos.rickandmorty.R

class CharactersFragment : Fragment() {

    private lateinit var viewModel: CharactersViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        viewModel =
                ViewModelProviders.of(this).get(CharactersViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_characters, container, false)
        val button: Button = root.findViewById(R.id.load_characters_button)
        button.setOnClickListener { viewModel.loadCharacters() }
        viewModel.characters.observe(viewLifecycleOwner, Observer {
            val names = it.joinToString { it.name }
            Toast.makeText(context, names, Toast.LENGTH_SHORT ).show()
        })
        return root
    }
}
