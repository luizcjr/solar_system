package com.example.solarsystemclean.presentation.ui.common.bindingadapter

import android.view.View
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.example.solarsystemclean.R
import com.example.solarsystemclean.data.mapper.PlanetUiMapper
import com.example.solarsystemclean.presentation.ui.main.components.favorites.FavoritesViewModel
import com.example.solarsystemclean.presentation.ui.model.PlanetUiModel
import com.example.solarsystemclean.presentation.ui.model.toPlanets
import com.google.android.material.snackbar.Snackbar

class FavoritesBindingAdapter {

    companion object {
        private val planetUiMapper = PlanetUiMapper()

        @BindingAdapter("applyFavoriteColor")
        @JvmStatic
        fun applyFavoriteColor(view: ImageView, favorite: Boolean?) {
            if (favorite == true) {
                view.setColorFilter(ContextCompat.getColor(view.context, R.color.orange_light))
                view.setImageDrawable(
                    ContextCompat.getDrawable(
                        view.context,
                        R.drawable.ic_favorite_orange
                    )
                )
            } else {
                view.setColorFilter(ContextCompat.getColor(view.context, android.R.color.white))
                view.setImageDrawable(ContextCompat.getDrawable(view.context, R.drawable.ic_save))
            }
        }

        @BindingAdapter(
            "favoritePlanetViewModel",
            "favoritePlanet",
            "favoriteFlag",
            requireAll = true
        )
        @JvmStatic
        fun saveFavoritePlanet(
            view: ImageView,
            favoritesViewModel: FavoritesViewModel,
            planets: PlanetUiModel,
            favorite: Boolean
        ) {
            view.setOnClickListener {
                if (favorite) {
                    favoritesViewModel.deleteFavoritePlanet(
                        id = planets.id!!,
                        planets = planetUiMapper.toDto(planets)
                    )
                    showSnackBar(view, "Planeta removido nos favoritos com sucesso!")
                } else {
                    favoritesViewModel.savePlanetsFavorite(planets = planetUiMapper.toDto(planets))
                    showSnackBar(view, "Planeta salvo nos favoritos com sucesso!")
                }

                favoritesViewModel.getPlanetsFavorite()
            }
        }

        private fun showSnackBar(view: View, message: String) {
            Snackbar.make(view, message, Snackbar.LENGTH_SHORT).setAction("Ok") {}
                .show()
        }
    }


}