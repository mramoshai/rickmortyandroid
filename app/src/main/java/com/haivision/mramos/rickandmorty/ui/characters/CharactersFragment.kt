package com.haivision.mramos.rickandmorty.ui.characters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
    private val characters = mutableListOf<Character>()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProviders.of(this).get(CharactersViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_characters, container, false)

        setUpRecyclerView(root)
        viewModel.loadCharacters()
        viewModel.characters.observe(viewLifecycleOwner, Observer(this::processCharacters))
        return root
    }

    private fun processCharacters(it: List<Character>) {
        if (it.isNotEmpty()){
            characters.addAll(it)
            viewAdapter.notifyDataSetChanged()
        }
    }

    private fun setUpRecyclerView(root: View) {
        viewManager = LinearLayoutManager(context)
        viewAdapter = CharacterAdapter(characters)
        recyclerView = root.findViewById<RecyclerView>(R.id.characters_recycler_view).apply {
            layoutManager = viewManager
            adapter = viewAdapter
        }
    }
}
