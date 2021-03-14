package com.example.solarsystemclean.presentation.ui.splash

import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.lifecycle.Observer
import com.example.solarsystemclean.databinding.ActivitySplashBinding
import com.example.solarsystemclean.presentation.common.BaseActivity
import com.example.solarsystemclean.util.ErrorUtil
import com.example.solarsystemclean.util.LoadingUtil
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashActivity : BaseActivity<SplashViewState>() {

    private val viewModel: SplashViewModel by viewModel()
    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.context = this
        binding.viewModel = viewModel
        binding.preferencesHelper = viewModel.getPreferencesHelper()

        viewModel.error.observe(this, Observer {
            ErrorUtil.alertError(it, this)
        })

        val handler = Handler()
        handler.postDelayed({
            viewModel.verifyUserLogged()
        }, 2500)
    }

    override fun updateViewState(viewState: SplashViewState) {
        if(viewState.isLoading) {
            LoadingUtil.onStartLoading(this)
        } else {
            LoadingUtil.onStopLoading()
        }
    }
}