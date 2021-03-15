package com.example.solarsystemclean.presentation.ui.main.components.favorites

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.solarsystemclean.databinding.ItemsPlanetsSearchBinding
import com.example.solarsystemclean.presentation.ui.model.PlanetUiModel
import com.example.solarsystemclean.util.AdapterDiffUtil

class FavoritesAdapter(private val planets: ArrayList<PlanetUiModel>, private val favoritesViewModel: FavoritesViewModel) :
    RecyclerView.Adapter<FavoritesAdapter.ViewHolder>() {


    class ViewHolder(private val binding: ItemsPlanetsSearchBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(planet: PlanetUiModel, favoritesViewModel: FavoritesViewModel) {
            binding.planet = planet
            binding.favoritesViewModel = favoritesViewModel
            //Atualiza quando tem alguma alteração nos dados
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemsPlanetsSearchBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder.from(parent)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentResult = planets[position]

        holder.bind(currentResult, favoritesViewModel)
    }

    override fun getItemCount() = planets.size

    fun setData(newData: List<PlanetUiModel>) {
        val planetDiffUtil = AdapterDiffUtil(planets, newData)
        val planetDiffUtilResult = DiffUtil.calculateDiff(planetDiffUtil)
        planets.addAll(newData)
        planetDiffUtilResult.dispatchUpdatesTo(this)
    }
}