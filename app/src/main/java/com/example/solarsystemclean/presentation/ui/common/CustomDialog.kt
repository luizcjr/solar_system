package com.example.solarsystemclean.presentation.ui.common

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.Window
import android.widget.LinearLayout
import androidx.appcompat.view.ContextThemeWrapper
import androidx.appcompat.widget.AppCompatButton
import androidx.databinding.DataBindingUtil
import com.example.data.remote.dto.CommonDialogDTO
import com.example.solarsystemclean.R
import com.example.solarsystemclean.databinding.LayoutDialogBinding

class CustomDialog(
    context: Context,
    var title: String?,
    var content: String,
    var error: Boolean
) : Dialog(context) {

    private var buttonList: ArrayList<AppCompatButton>? = null
    private var binding: LayoutDialogBinding? = null
    private var dialogModel = CommonDialogDTO("", "")

    init {
        buttonList = ArrayList()

        // disable cancel
        setCancelable(false)
        setCanceledOnTouchOutside(false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        binding = DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.layout_dialog,
            null,
            false
        );
        setContentView(binding!!.root)

        if (error) setErrorAlert() else setSuccessAlert()

        // update content
        dialogModel.content = content
        binding!!.dialog = dialogModel

        // check button
        if (buttonList!!.size == 0) {
            addButton(
                context.getString(R.string.alert_ok_action)
            ) { hide() }
        }

        if (buttonList!!.size > 0) {
            binding!!.actionsContainer.weightSum = buttonList!!.size.toFloat()
            for (button in buttonList!!) {
                binding!!.actionsContainer.addView(button)
            }
        }
    }

    private fun setErrorAlert() {
        binding!!.alertTitle.setCompoundDrawablesRelativeWithIntrinsicBounds(
            R.drawable.ic_sad,
            0,
            0,
            0
        )
        if (title == null) dialogModel.title =
            context.getString(R.string.alert_error_title) else updateTitleLabel()
    }

    private fun setSuccessAlert() {
        binding!!.alertTitle.setCompoundDrawablesRelativeWithIntrinsicBounds(
            R.drawable.ic_success,
            0,
            0,
            0
        )
        if (title == null) dialogModel.title =
            context.getString(R.string.alert_success_title) else updateTitleLabel()
    }

    private fun updateTitleLabel() {
        dialogModel.title = title
    }

    private fun addButton(
        title: String?,
        clickListener: View.OnClickListener?
    ) {
        addButton(title, 0, clickListener)
    }

    fun addButton(
        title: String?,
        styleId: Int,
        clickListener: View.OnClickListener?
    ) {
        var styleId = styleId
        if (styleId == 0) {
            styleId = R.style.ButtonAlert
        }
        val button = AppCompatButton(
            ContextThemeWrapper(context, styleId),
            null,
            0
        )
        button.text = title
        val params = LinearLayout.LayoutParams(
            0,
            LinearLayout.LayoutParams.WRAP_CONTENT,
            1f
        )
        params.setMargins(0, 0, 16, 0)

        button.layoutParams = params

        button.minWidth = 0
        if (clickListener != null) {
            button.setOnClickListener(clickListener)
        }
        buttonList!!.add(button)
    }
}