package com.example.solarsystemclean.presentation.ui.common.bindingadapter

import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.BindingAdapter
import androidx.navigation.Navigation
import com.example.solarsystemclean.presentation.ui.main.components.home.HomeFragmentDirections
import com.example.solarsystemclean.presentation.ui.main.components.search.SearchFragmentDirections
import com.example.solarsystemclean.presentation.ui.model.PlanetUiModel

class PlanetsBingindAdapter {
    companion object {
        @BindingAdapter("planetsHomeClickListener")
        @JvmStatic
        fun planetsHomeClickListener(view: ConstraintLayout, planet: PlanetUiModel) {
            view.setOnClickListener {
                val action = HomeFragmentDirections.actionHomeToDetail(planet)
                Navigation.findNavController(view).navigate(action)
            }
        }

        @BindingAdapter("planetsSearchClickListener")
        @JvmStatic
        fun planetsSearchClickListener(view: ConstraintLayout, planet: PlanetUiModel) {
            view.setOnClickListener {
                val action = SearchFragmentDirections.actionSearchToDetail(planet)
                Navigation.findNavController(view).navigate(action)
            }
        }
    }
}