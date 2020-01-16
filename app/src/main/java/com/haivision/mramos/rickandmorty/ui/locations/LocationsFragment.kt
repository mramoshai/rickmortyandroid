package com.haivision.mramos.rickandmorty.ui.locations

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.haivision.mramos.rickandmorty.R

class LocationsFragment : Fragment() {

    private lateinit var locationsViewModel: LocationsViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        locationsViewModel =
                ViewModelProviders.of(this).get(LocationsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_locations, container, false)
        val textView: TextView = root.findViewById(R.id.text_locations)
        locationsViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}
