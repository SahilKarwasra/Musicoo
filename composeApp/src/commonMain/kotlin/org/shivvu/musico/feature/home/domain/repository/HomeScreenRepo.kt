package org.shivvu.musico.feature.home.domain.repository

import org.shivvu.musico.feature.home.domain.model.NewTrending

interface HomeScreenRepo {
    suspend fun fetchNewTrendingSongs() : List<NewTrending>
}