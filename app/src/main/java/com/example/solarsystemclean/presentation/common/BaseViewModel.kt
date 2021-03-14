package com.example.solarsystemclean.presentation.common

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.solarsystemclean.util.helper.SharedPreferencesHelper
import com.example.solarsystemclean.util.ErrorUtil
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

abstract class BaseViewModel<T : BaseViewState> : ViewModel(), KoinComponent {

    lateinit var context: Context

    val prefHelper : SharedPreferencesHelper by inject()

    val error by lazy { MutableLiveData<String>() }

    private val _viewState: MutableLiveData<T> = MutableLiveData()
    val viewState = _viewState

    protected open fun updateViewState(viewState: T) {
        _viewState.postValue(viewState)
    }

    var job : Job? = null

    val exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
       error.postValue(ErrorUtil.getMessageErrorObject(throwable))
    }

    val coroutineScope = CoroutineScope(Dispatchers.IO + exceptionHandler)
}