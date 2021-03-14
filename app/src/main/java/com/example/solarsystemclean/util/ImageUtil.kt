package com.example.solarsystemclean.util

import android.content.Context
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.solarsystemclean.R

fun getProgressDrawable(context: Context?): CircularProgressDrawable? {
    val circularProgressDrawable = CircularProgressDrawable(context!!)
    circularProgressDrawable.strokeWidth = 10f
    circularProgressDrawable.centerRadius = 50f
    circularProgressDrawable.start()
    return circularProgressDrawable
}

fun loadImage(imageView: ImageView, uri: String?, progressDrawable: CircularProgressDrawable?) {

    val options: RequestOptions = RequestOptions()
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .placeholder(progressDrawable)
        .fitCenter()
        .error(R.drawable.image_not_found)

    Glide.with(imageView.context)
        .setDefaultRequestOptions(options)
        .load(uri)
        .thumbnail(0.5f)
        .into(imageView)
}

@BindingAdapter("android:imageUrl")
fun loadImage(view: ImageView, url: String?) {
    loadImage(view, url, getProgressDrawable(view.context))
}

@BindingAdapter("android:drawableImage")
fun drawableImage(view: ImageView, image: Int) {
    view.setImageResource(image)
}