package com.example.solarsystemclean.di

import com.example.solarsystemclean.data.api.constants.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {

    val connectionTimeoutSeconds = 20 * 1000L

    single {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val okHttpClient = OkHttpClient().newBuilder()
            .readTimeout(connectionTimeoutSeconds, TimeUnit.SECONDS)
            .writeTimeout(connectionTimeoutSeconds, TimeUnit.SECONDS)
            .callTimeout(connectionTimeoutSeconds, TimeUnit.SECONDS)
            .connectTimeout(connectionTimeoutSeconds, TimeUnit.SECONDS)
            .addInterceptor(loggingInterceptor)
            .build()

        Retrofit.Builder()
            .baseUrl(Constants.BASE)
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }
}