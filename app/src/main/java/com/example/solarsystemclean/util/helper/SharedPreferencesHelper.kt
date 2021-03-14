package com.example.solarsystemclean.util.helper

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager
import androidx.core.content.edit
import com.example.data.remote.dto.UserDTO
import com.google.gson.Gson

class SharedPreferencesHelper {
    companion object {
        private var prefs: SharedPreferences? = null

        @Volatile
        private var instance: SharedPreferencesHelper? = null
        private val LOCK = Any()

        operator fun invoke(context: Context): SharedPreferencesHelper = instance ?: synchronized(
            LOCK
        ) {
            instance ?: buildHelper(context).also {
                instance = it
            }
        }

        private fun buildHelper(context: Context): SharedPreferencesHelper {
            prefs = PreferenceManager.getDefaultSharedPreferences(context)
            return SharedPreferencesHelper()
        }
    }

    fun setLastUserSession(json: String) {
        prefs?.edit(commit = true) {
            putString("lastUser", json)
        }
    }

    fun getLastUserSession(): UserDTO? {
        return Gson().fromJson(prefs?.getString("lastUser", null), UserDTO::class.java)
    }
}