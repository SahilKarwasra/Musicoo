package org.shivvu.musico.feature.home.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
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
import org.koin.compose.viewmodel.koinViewModel
import org.shivvu.musico.feature.home.presentation.component.GreetingSection
import org.shivvu.musico.feature.home.presentation.component.SectionHeading
import org.shivvu.musico.feature.home.presentation.component.TrendingSongsCard
import org.shivvu.musico.feature.home.presentation.viewmodel.HomeViewmodel

@Composable
fun HomeScreen(
    viewmodel: HomeViewmodel = koinViewModel(),
    modifier: Modifier = Modifier
) {

    val trendingSongsList by viewmodel.trendingSongsList.collectAsState()
    val trendingSongRowState = rememberLazyListState()

    Column(
        modifier = Modifier.fillMaxSize()
            .background(color = Color.Black)
    ) {
        GreetingSection(modifier = Modifier.padding())
        SectionHeading("New Trending")
        LazyRow(
            state = trendingSongRowState
        ) {
            items(items = trendingSongsList) { song ->
                TrendingSongsCard(
                    image = song.image,
                    title = song.title,
                    subtitle = song.more_info.artistMap?.artists[0]?.name
                )
            }
        }
    }

}