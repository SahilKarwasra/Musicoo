package org.shivvu.musico.feature.home.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.shivvu.musico.crypto.UrlDecryptor
import org.shivvu.musico.feature.home.domain.model.AlbumItem
import org.shivvu.musico.feature.home.domain.model.BrowseItem
import org.shivvu.musico.feature.home.domain.model.PlaylistItem
import org.shivvu.musico.feature.home.domain.model.TrendingItem
import org.shivvu.musico.feature.home.domain.repository.HomeScreenRepo

class HomeViewmodel(
    private val homeScreenRepo: HomeScreenRepo,
    private val urlDecryptor: UrlDecryptor
) : ViewModel() {

    private val _trendingSongsList = MutableStateFlow<List<TrendingItem>>(emptyList())
    val trendingSongsList = _trendingSongsList.asStateFlow()

    private val _topPlaylist = MutableStateFlow<List<PlaylistItem>>(emptyList())
    val topPlaylists = _topPlaylist.asStateFlow()

    private val _newAlbumsList = MutableStateFlow<List<AlbumItem>>(emptyList())
    val newAlumsList = _newAlbumsList.asStateFlow()

    private val _browseDiscoverList = MutableStateFlow<List<BrowseItem>>(emptyList())
    val browseDiscoverList = _browseDiscoverList.asStateFlow()

    init {
        getData()
    }

    fun getData() {
        viewModelScope.launch {
            try {
                val result = homeScreenRepo.fetchHomeScreenData()
                _trendingSongsList.value = result.new_trending
                _topPlaylist.value = result.top_playlists
                _newAlbumsList.value = result.new_albums
                _browseDiscoverList.value = result.browse_discover
            } catch (e: Exception) {
                e.printStackTrace()
                throw e
            }
        }
    }

}