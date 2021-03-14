package com.example.solarsystemclean.presentation.ui.main.components.search

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.solarsystemclean.databinding.ItemsPlanetsSearchBinding
import com.example.solarsystemclean.presentation.ui.model.PlanetUiModel
import com.example.solarsystemclean.util.AdapterDiffUtil
import java.util.*
import kotlin.collections.ArrayList

class SearchAdapter(private val planets: ArrayList<PlanetUiModel>) :
    RecyclerView.Adapter<SearchAdapter.ViewHolder>(),
    Filterable {

    var planetsFilterList = ArrayList<PlanetUiModel>()

    init {
        planetsFilterList = planets
    }

    class ViewHolder(private val binding: ItemsPlanetsSearchBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(planet: PlanetUiModel) {
            binding.planet = planet
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
        val currentResult = planetsFilterList[position]

        holder.bind(currentResult)
    }

    override fun getItemCount() = planetsFilterList.size

    fun setData(newData: List<PlanetUiModel>) {
        val planetDiffUtil = AdapterDiffUtil(planetsFilterList, newData)
        val planetDiffUtilResult = DiffUtil.calculateDiff(planetDiffUtil)
        planetsFilterList.addAll(newData)
        planetDiffUtilResult.dispatchUpdatesTo(this)
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charSearch = constraint.toString()
                if (charSearch.isEmpty()) {
                    planetsFilterList = planets
                } else {
                    val resultList = ArrayList<PlanetUiModel>()
                    for (row in planets) {
                        if (row.name!!.toLowerCase(Locale.ROOT).contains(
                                charSearch.toLowerCase(
                                    Locale.ROOT
                                )
                            )
                        ) {
                            resultList.add(row)
                        }
                    }
                    planetsFilterList = resultList
                }
                val filterResults = FilterResults()
                filterResults.values = planetsFilterList
                return filterResults
            }

            @Suppress("UNCHECKED_CAST")
            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                planetsFilterList = results?.values as ArrayList<PlanetUiModel>
                notifyDataSetChanged()
            }

        }
    }

}