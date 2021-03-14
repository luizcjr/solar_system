package com.example.solarsystemclean.util

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.annotation.AnimRes
import com.example.solarsystemclean.R
import com.example.solarsystemclean.SolarSystemApplication.Companion.appContext
import com.example.solarsystemclean.util.helper.NoResultAdapter

fun Context.toast(message: CharSequence) =
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

inline fun <reified T : Activity> Context.openActivity(
    options: Bundle? = null,
    finishWhenOpen: Boolean = false,
    @AnimRes enterAnim: Int = R.anim.activity_slide_pop_vertical_open_in,
    @AnimRes exitAnim: Int = R.anim.activity_slide_pop_vertical_open_out,
    noinline f: Intent.() -> Unit = {}
) {

    val intent = Intent(this, T::class.java)
    intent.f()
    startActivity(intent, options)
    if (finishWhenOpen) (this as Activity).finish()
    (this as Activity).overridePendingTransition(enterAnim, exitAnim)
}

fun hideKeyboard(view: View) {
    val imm = appContext?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(view.windowToken, 0)
}

fun noResultAdapter(context: Context, message: String, image: Int): NoResultAdapter {
    return NoResultAdapter(
        context,
        message,
        R.color.colorGreyAdapter,
        image,
    )
}