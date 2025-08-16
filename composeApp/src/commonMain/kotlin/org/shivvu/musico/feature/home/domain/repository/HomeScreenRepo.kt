package org.shivvu.musico.feature.home.domain.repository

import org.shivvu.musico.feature.home.domain.model.HomeScreenResponse


interface HomeScreenRepo {
    suspend fun fetchHomeScreenData() : HomeScreenResponse
}