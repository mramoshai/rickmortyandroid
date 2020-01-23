package com.haivision.mramos.rickandmorty.ui.locations

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
import com.haivision.mramos.rickandmorty.api.MyResult

class LocationsFragment : Fragment() {

    private lateinit var locationsViewModel: LocationsViewModel

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    private val locations = mutableListOf<Location>()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        locationsViewModel =
                ViewModelProviders.of(this).get(LocationsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_locations, container, false)

        setUpRecyclerView(root)
        locationsViewModel.loadLocations()
        locationsViewModel.location.observe(viewLifecycleOwner, Observer(this::processLocations))
        return root
    }

    private fun processLocations(it: MyResult<List<Location>>?) {
        if (it is MyResult.Success) addLocations(it)
    }

    private fun addLocations(it: MyResult.Success<List<Location>>) {
        locations.addAll(it.data)
        viewAdapter.notifyDataSetChanged()
    }

    private fun setUpRecyclerView(root: View) {
        viewManager = LinearLayoutManager(context)
        viewAdapter = LocationAdapter(locations)
        recyclerView = root.findViewById<RecyclerView>(R.id.locations_recycler_view).apply {
            layoutManager = viewManager
            adapter = viewAdapter
        }
    }
}
