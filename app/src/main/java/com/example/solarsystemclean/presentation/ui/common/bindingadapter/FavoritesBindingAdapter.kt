package com.example.solarsystemclean.presentation.ui.common.bindingadapter

import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.example.solarsystemclean.R

class FavoritesBindingAdapter {
    companion object {
        @BindingAdapter("applyFavoriteColor")
        @JvmStatic
        fun applyFavoriteColor(view: ImageView, favorite: Boolean?) {
            if (favorite == true) {
                view.setColorFilter(ContextCompat.getColor(view.context, R.color.orange_light))
            } else {
                view.setColorFilter(ContextCompat.getColor(view.context, android.R.color.white))
            }
        }
    }
}