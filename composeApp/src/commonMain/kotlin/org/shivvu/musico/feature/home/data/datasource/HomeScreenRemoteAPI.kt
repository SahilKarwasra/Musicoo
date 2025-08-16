package org.shivvu.musico.feature.home.data.datasource

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext
import org.shivvu.musico.feature.home.domain.model.HomeScreenResponse

class HomeScreenRemoteAPI(
    private val httpClient: HttpClient
) {

    suspend fun fetchData(): HomeScreenResponse {
        return withContext(Dispatchers.IO) {
            try {
                httpClient.get("https://jiosaavn.com/api.php?_format=json&_marker=0&api_version=4&ctx=web6dot0&__call=webapi.getLaunchData")
                    .body()
            } catch (e: Exception) {
                e.printStackTrace()
                throw e
            }
        }
    }


}