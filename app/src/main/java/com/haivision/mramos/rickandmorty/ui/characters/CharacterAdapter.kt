package com.haivision.mramos.rickandmorty.ui.characters

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.haivision.mramos.rickandmorty.R
import com.haivision.mramos.rickandmorty.inflate
import com.haivision.mramos.rickandmorty.loadUrl
import kotlinx.android.synthetic.main.item_character.view.*

class CharacterAdapter(private val characters: List<Character>) :
    RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    class CharacterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(character: Character) = with(itemView) {
            character_name.text = character.name
            character_species.text = when {
                character.type.isNotEmpty() -> "${character.species} - ${character.type}"
                else -> character.species
            }
            character_img.loadUrl(character.image)
            character_origin.text = character.origin.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder =
        CharacterViewHolder(parent.inflate(R.layout.item_character))

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) =
        holder.bind(characters[position])

    override fun getItemCount(): Int =
        characters.size
}