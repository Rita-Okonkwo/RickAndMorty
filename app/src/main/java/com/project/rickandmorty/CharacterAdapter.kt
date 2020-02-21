package com.project.rickandmorty

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.project.rickandmorty.databinding.ListItemBinding

class CharacterAdapter(var characters : CharacterResult): RecyclerView.Adapter<CharacterAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ListItemBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return characters.results.size
    }

    override fun onBindViewHolder(holder: CharacterAdapter.ViewHolder, position: Int) {
        holder.characterName.text = characters.results[position].name
    }

    class ViewHolder(val binding: ListItemBinding): RecyclerView.ViewHolder(binding.root){
        var characterName: TextView = binding.itemText
    }
}