package com.example.solarsystemclean.util

import android.content.Context
import com.example.solarsystemclean.presentation.ui.common.CustomDialog
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.HttpException
import java.io.IOException
import java.net.SocketTimeoutException

object ErrorUtil {
    fun alertError(message: String, context: Context) {
        val alertDefault = CustomDialog(
            context,
            "Erro!",
            message,
            true
        )
        alertDefault.show()
    }

    fun getMessageErrorObject(e: Throwable): String {
        var loadError = String()

        when (e) {
            is HttpException -> {
                val responseBody: ResponseBody =
                    e.response()?.errorBody()!!
                try {
                    val jObject = JSONObject(responseBody.string())
                    loadError = jObject.getString("error")
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
            is SocketTimeoutException -> {
                loadError = e.message!!
            }
            is IOException -> {
                loadError = e.message!!
            }
            else -> {
                loadError = e.message!!
            }
        }

        return loadError
    }
}