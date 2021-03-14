package com.example.solarsystemclean.presentation.ui.splash

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.example.data.remote.dto.UserDTO
import com.example.solarsystemclean.domain.usecase.UserUseCase
import com.example.solarsystemclean.presentation.common.BaseViewModel
import com.example.solarsystemclean.presentation.ui.main.MainActivity
import com.example.solarsystemclean.util.openActivity
import com.google.gson.Gson
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class SplashViewModel : BaseViewModel<SplashViewState>(), KoinComponent {

    private val userUseCase: UserUseCase by inject()

    var name = MutableLiveData<String>()
    var user = UserDTO(0, "", "", "")

    fun saveUser() {
        if (name.value.toString().isEmpty()) {
            Toast.makeText(context, "Nome", Toast.LENGTH_SHORT).show()
        } else {
            updateViewState(SplashViewState.loadingState())
            user.name = name.value.toString()

            coroutineScope.launch {
                if (prefHelper.getLastUserSession() == null) {
                    userUseCase.invoke(user)
                    redirectToHome()
                    updateViewState(SplashViewState.splashSuccess())
                    prefHelper.setLastUserSession(Gson().toJson(user))
                } else {
                    redirectToHome()
                }
            }
        }
    }

    private fun redirectToHome() {
        context.openActivity<MainActivity>()
    }

    fun verifyUserLogged() {
        if (prefHelper.getLastUserSession() != null) {
            redirectToHome()
        }
    }

    fun getPreferencesHelper() = prefHelper
}