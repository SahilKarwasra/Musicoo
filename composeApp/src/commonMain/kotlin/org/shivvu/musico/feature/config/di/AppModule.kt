package org.shivvu.musico.feature.config.di

import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.engine.cio.endpoint
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module
import org.shivvu.musico.crypto.DesEcbPkcs5
import org.shivvu.musico.crypto.UrlDecryptor
import org.shivvu.musico.crypto.provideDes
import org.shivvu.musico.feature.home.data.datasource.HomeScreenRemoteAPI
import org.shivvu.musico.feature.home.data.repository.HomeScreenRepoImpl
import org.shivvu.musico.feature.home.domain.repository.HomeScreenRepo
import org.shivvu.musico.feature.home.presentation.viewmodel.HomeViewmodel



val sharedModules = module {
    single {
        HttpClient(CIO) {
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys= true
                    isLenient = true
                    prettyPrint = true
                })
            }
            install(Logging) {
                level = LogLevel.ALL
            }
        }
    }

    singleOf(::HomeScreenRemoteAPI)
    singleOf(::HomeScreenRepoImpl).bind(HomeScreenRepo::class)
    viewModelOf(::HomeViewmodel)

    // Crypto
    single<DesEcbPkcs5> { provideDes() }
    single { UrlDecryptor(get()) }


}