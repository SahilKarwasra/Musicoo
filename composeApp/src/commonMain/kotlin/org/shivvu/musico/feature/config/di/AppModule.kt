package org.shivvu.musico.feature.config.di

import io.ktor.client.HttpClient
import org.koin.dsl.module

val appModule = module {
    single {
        HttpClient()
    }
}