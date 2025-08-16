package org.shivvu.musico.feature.home.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import org.koin.compose.viewmodel.koinViewModel
import org.shivvu.musico.feature.home.presentation.component.AlbumsCard
import org.shivvu.musico.feature.home.presentation.component.DiscoverCard
import org.shivvu.musico.feature.home.presentation.component.GreetingSection
import org.shivvu.musico.feature.home.presentation.component.SectionHeading
import org.shivvu.musico.feature.home.presentation.component.TopPlaylistCard
import org.shivvu.musico.feature.home.presentation.component.TrendingSongsCard
import org.shivvu.musico.feature.home.presentation.viewmodel.HomeViewmodel

@Composable
fun HomeScreen(
    viewmodel: HomeViewmodel = koinViewModel(),
    modifier: Modifier = Modifier
) {

    val trendingSongsList by viewmodel.trendingSongsList.collectAsState()
    val topPlaylists by viewmodel.topPlaylists.collectAsState()
    val albumList by viewmodel.newAlumsList.collectAsState()
    val discoverList by viewmodel.browseDiscoverList.collectAsState()

    val mainLazyColumnState = rememberLazyListState()
    val trendingSongRowState = rememberLazyListState()
    val topPlayListRowState = rememberLazyListState()
    val albumListRowState = rememberLazyListState()
    val browseDiscoverState = rememberLazyListState()

    LazyColumn(
        modifier = Modifier.fillMaxSize()
            .background(color = Color.Black),
        state = mainLazyColumnState
    ) {
        items(1) {
            GreetingSection(modifier = Modifier.padding())
            SectionHeading("New Trending")
            LazyRow(
                state = trendingSongRowState
            ) {
                items(items = trendingSongsList) { song ->
                    TrendingSongsCard(
                        image = song.image,
                        title = song.title,
                        subtitle = song.more_info?.artistMap?.artists[0]?.name,
                        onClick = {}
                    )
                }
            }
            SectionHeading("Top Playlist")
            LazyRow(
                state = topPlayListRowState
            ) {
                items(items = topPlaylists) { song ->
                    TopPlaylistCard(
                        image = song.image,
                        title = song.title,
                        totalTracks = song.more_info?.song_count
                    )
                }
            }
            SectionHeading("New Albums")
            LazyRow(
                state = albumListRowState
            ) {
                items(
                    items = albumList
                ) { album ->
                    AlbumsCard(
                        image = album.image,
                        subtitle = album.subtitle,
                        title = album.title
                    )
                }
            }
            SectionHeading("Browse Discover")
            LazyRow(
                state = browseDiscoverState
            ){
                items(items = discoverList) { discover ->
                    DiscoverCard(
                        image = discover.image,
                        title = discover.title,
                        type = discover.type
                    )
                }
            }

        }


    }

}