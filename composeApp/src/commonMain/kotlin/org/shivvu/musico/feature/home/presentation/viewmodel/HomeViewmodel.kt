package org.shivvu.musico.feature.home.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.shivvu.musico.feature.home.domain.model.NewTrending
import org.shivvu.musico.feature.home.domain.repository.HomeScreenRepo

class HomeViewmodel(
    private val homeScreenRepo: HomeScreenRepo
) : ViewModel() {

    private val _trendingSongsList = MutableStateFlow<List<NewTrending>>(emptyList())
    val trendingSongsList = _trendingSongsList.asStateFlow()

    init {
        getTrendingSongs()
    }

    fun getTrendingSongs() {
        viewModelScope.launch {
            try {
                val result = homeScreenRepo.fetchNewTrendingSongs()
                _trendingSongsList.value = _trendingSongsList.value + result
            } catch (e: Exception) {
                e.printStackTrace()
                throw e
            }
        }
    }


}