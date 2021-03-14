package com.example.solarsystemclean.di

import com.example.solarsystemclean.util.helper.SharedPreferencesHelper
import org.koin.dsl.module

val appModule = module(override = true) {

    single {
        SharedPreferencesHelper(get())
    }
}