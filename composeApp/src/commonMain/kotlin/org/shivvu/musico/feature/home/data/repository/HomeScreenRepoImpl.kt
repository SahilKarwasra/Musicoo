package org.shivvu.musico.feature.home.data.repository

import org.shivvu.musico.feature.home.data.datasource.HomeScreenRemoteAPI
import org.shivvu.musico.feature.home.domain.model.HomeScreenResponse
import org.shivvu.musico.feature.home.domain.repository.HomeScreenRepo

class HomeScreenRepoImpl(
    private val api: HomeScreenRemoteAPI
) : HomeScreenRepo {

    override suspend fun fetchHomeScreenData(): HomeScreenResponse {
        try {
            val response = api.fetchData()
            return response
        } catch (e: Exception) {
            e.printStackTrace()
            throw e
        }
    }


}