package com.example.solarsystemclean.util

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.view.Window
import com.example.solarsystemclean.R
import java.util.*

object LoadingUtil {
    private var dialog: Dialog? = null

    @SuppressLint("ObsoleteSdkInt")
    fun loadingDialog(ctx: Context): Dialog {
        val loading = Dialog(ctx)
        loading.requestWindowFeature(Window.FEATURE_NO_TITLE)
        loading.setContentView(R.layout.dialog_loading)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Objects.requireNonNull<Window>(loading.window)
                .setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        }
        loading.setCanceledOnTouchOutside(false)
        loading.setCancelable(false)
        return loading
    }

    fun onStartLoading(context: Context) {
        dialog = loadingDialog(context)
        dialog!!.show()
    }

    fun onStopLoading() {
        if (dialog!!.isShowing) {
            dialog!!.dismiss()
        }
    }
}