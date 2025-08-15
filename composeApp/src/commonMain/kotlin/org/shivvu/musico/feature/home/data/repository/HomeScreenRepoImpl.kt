package org.shivvu.musico.feature.home.data.repository

import org.shivvu.musico.feature.home.data.datasource.HomeScreenRemoteAPI
import org.shivvu.musico.feature.home.domain.model.NewTrending
import org.shivvu.musico.feature.home.domain.repository.HomeScreenRepo

class HomeScreenRepoImpl(
    private val api: HomeScreenRemoteAPI
) : HomeScreenRepo {

    override suspend fun fetchNewTrendingSongs(): List<NewTrending> {
        try {
            val response = api.fetchTrendingData()
            return response.new_trending
        } catch (e: Exception) {
            e.printStackTrace()
            throw e
        }
    }


}