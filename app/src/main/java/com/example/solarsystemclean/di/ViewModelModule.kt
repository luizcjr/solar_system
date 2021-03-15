package com.example.solarsystemclean.di

import com.example.solarsystemclean.presentation.ui.main.components.favorites.FavoritesViewModel
import com.example.solarsystemclean.presentation.ui.main.components.home.HomeViewModel
import com.example.solarsystemclean.presentation.ui.main.components.search.SearchViewModel
import com.example.solarsystemclean.presentation.ui.splash.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { SplashViewModel() }
    viewModel { HomeViewModel() }
    viewModel { SearchViewModel() }
    viewModel { FavoritesViewModel() }
}