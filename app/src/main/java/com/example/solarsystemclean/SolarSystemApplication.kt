package com.example.solarsystemclean

import android.app.Application
import android.content.Context
import com.example.solarsystemclean.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class SolarSystemApplication: Application() {

    companion object {
        var appContext: Context? = null
            private set
    }

    override fun onCreate() {
        super.onCreate()
        appContext = this

        startKoin {
            androidContext(this@SolarSystemApplication)
            modules(
                    listOf(
                        appModule,
                        networkModule,
                        viewModelModule,
                        useCaseModule,
                        repositoryModule,
                        persistenceModule,
                        apiModule
                    )
            )
        }
    }
}