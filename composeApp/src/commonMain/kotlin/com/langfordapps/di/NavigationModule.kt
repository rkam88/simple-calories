package com.langfordapps.di

import com.langfordapps.navigation.VoyagerRouter
import com.langfordapps.simplecalories.core.navigation.api.Router
import org.koin.dsl.module

val navigationModule = module {
    single<Router> {
        VoyagerRouter
    }
}
