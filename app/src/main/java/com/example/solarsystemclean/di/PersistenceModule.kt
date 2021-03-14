package com.example.solarsystemclean.di

import com.example.solarsystemclean.data.persistence.dao.UserDao
import com.example.solarsystemclean.data.persistence.dao.UserDaoImpl
import org.koin.dsl.module

val persistenceModule = module {

    single<UserDao> {
        UserDaoImpl(get())
    }
}