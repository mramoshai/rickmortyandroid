package com.haivision.mramos.rickandmorty.ui.characters

import android.opengl.Visibility
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.haivision.mramos.rickandmorty.R

class CharactersFragment : Fragment() {

    private lateinit var viewModel: CharactersViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        viewModel =
                ViewModelProviders.of(this).get(CharactersViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_characters, container, false)

        viewManager = LinearLayoutManager(context)
        viewAdapter = CharacterAdapter(STATIC_CHARACTERS)
        recyclerView = root.findViewById<RecyclerView>(R.id.characters_recycler_view).apply {
            layoutManager = viewManager
            adapter = viewAdapter
        }

        val button: Button = root.findViewById(R.id.load_characters_button)
        button.setOnClickListener { viewModel.loadCharacters() }
        button.visibility = View.GONE

        viewModel.characters.observe(viewLifecycleOwner, Observer {
            // TODO recycler view
            val names = it.joinToString { it.name }
            Toast.makeText(context, names, Toast.LENGTH_SHORT ).show()
        })
        return root
    }
}
