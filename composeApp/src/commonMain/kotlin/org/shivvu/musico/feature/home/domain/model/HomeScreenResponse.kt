package org.shivvu.musico.feature.home.domain.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

@Serializable
data class HomeScreenResponse(
    val history: List<JsonElement> = emptyList(),
    val new_trending: List<TrendingItem> = emptyList(),
    val top_playlists: List<PlaylistItem> = emptyList(),
    val new_albums: List<AlbumItem> = emptyList(),
    val browse_discover: List<BrowseItem> = emptyList(),
    val global_config: GlobalConfig? = null,
    val charts: List<ChartItem> = emptyList(),
    val radio: List<RadioItem> = emptyList(),
    val artist_recos: List<ArtistRecoItem> = emptyList(),
    val tag_mixes: List<MixItem> = emptyList(),
    val city_mod: List<CityItem> = emptyList(),

    // dynamic keys like "promo:vx:data:68"
    val promo_vx_data_68: List<PromoItem>? = null,
    val promo_vx_data_185: List<PromoItem>? = null
)

@Serializable
data class TrendingItem(
    val id: String? = null,
    val title: String? = null,
    val subtitle: String? = null,
    val header_desc: String? = null,
    val type: String? = null,
    val perma_url: String? = null,
    val image: String? = null,
    val language: String? = null,
    val year: String? = null,
    val play_count: String? = null,
    val explicit_content: String? = null,
    val list_count: String? = null,
    val list_type: String? = null,
    val list: String? = null,
    val more_info: MoreInfo? = null,
    val modules: JsonElement? = null,
    val button_tooltip_info: List<JsonElement> = emptyList()
)

@Serializable
data class AlbumItem(
    val id: String? = null,
    val title: String? = null,
    val subtitle: String? = null,
    val header_desc: String? = null,
    val type: String? = null,
    val perma_url: String? = null,
    val image: String? = null,
    val language: String? = null,
    val year: String? = null,
    val play_count: String? = null,
    val explicit_content: String? = null,
    val list_count: String? = null,
    val list_type: String? = null,
    val list: String? = null,
    val more_info: MoreInfo? = null,
    val button_tooltip_info: List<JsonElement> = emptyList()
)

@Serializable
data class PlaylistItem(
    val id: String? = null,
    val title: String? = null,
    val subtitle: String? = null,
    val type: String? = null,
    val image: String? = null,
    val perma_url: String? = null,
    val more_info: PlaylistMoreInfo? = null,
    val explicit_content: String? = null,
    val mini_obj: Boolean? = null
)

@Serializable
data class BrowseItem(
    val id: String? = null,
    val title: String? = null,
    val subtitle: String? = null,
    val type: String? = null,
    val image: String? = null,
    val perma_url: String? = null,
    val more_info: BrowseMoreInfo? = null,
    val explicit_content: String? = null,
    val mini_obj: Boolean? = null
)

@Serializable
data class ChartItem(
    val id: String? = null,
    val image: String? = null,
    val title: String? = null,
    val type: String? = null,
    val count: Int? = null, // ✅ safe
    val perma_url: String? = null,
    val more_info: ChartMoreInfo? = null
)

@Serializable
data class RadioItem(
    val id: String? = null,
    val title: String? = null,
    val subtitle: String? = null,
    val type: String? = null,
    val image: String? = null,
    val perma_url: String? = null,
    val more_info: RadioMoreInfo? = null,
    val explicit_content: String? = null,
    val mini_obj: Boolean? = null
)

@Serializable
data class ArtistRecoItem(
    val id: String? = null,
    val title: String? = null,
    val subtitle: String? = null,
    val type: String? = null,
    val image: String? = null,
    val perma_url: String? = null,
    val more_info: ArtistRecoMoreInfo? = null,
    val explicit_content: String? = null,
    val mini_obj: Boolean? = null
)

@Serializable
data class MixItem(
    val id: String? = null,
    val title: String? = null,
    val subtitle: String? = null,
    val header_desc: String? = null,
    val type: String? = null,
    val perma_url: String? = null,
    val image: String? = null,
    val language: String? = null,
    val year: String? = null,
    val play_count: String? = null,
    val explicit_content: String? = null,
    val list_count: String? = null,
    val list_type: String? = null,
    val list: String? = null,
    val more_info: MixMoreInfo? = null,
    val button_tooltip_info: List<JsonElement> = emptyList(),
    val description: String? = null
)

@Serializable
data class CityItem(
    val id: String? = null,
    val type: String? = null,
    val title: String? = null,
    val subtitle: String? = null,
    val secondary_subtitle: String? = null,
    val perma_url: String? = null,
    val image: String? = null,
    val mini_obj: Boolean? = null,
    val explicit_content: String? = null,
    val more_info: CityMoreInfo? = null
)

@Serializable
data class PromoItem(
    val id: String? = null,
    val type: String? = null,
    val title: String? = null,
    val subtitle: String? = null,
    val secondary_subtitle: String? = null,
    val image: String? = null,
    val mini_obj: Boolean? = null,
    val perma_url: String? = null,
    val explicit_content: String? = null,
    val more_info: JsonElement? = null
)

// ------- Nested Info Models --------

@Serializable
data class MoreInfo(
    val release_date: String? = null,
    val song_count: String? = null,
    val artistMap: ArtistMap? = null
)

@Serializable
data class PlaylistMoreInfo(
    val song_count: String? = null,
    val firstname: String? = null,
    val follower_count: String? = null,
    val last_updated: String? = null,
    val uid: String? = null
)

@Serializable
data class BrowseMoreInfo(
    val badge: String? = null,
    val sub_type: String? = null,
    val available: String? = null,
    val is_featured: String? = null,
    val tags: JsonElement? = null, // ✅ safe (array or object)
    val video_url: String? = null,
    val video_thumbnail: String? = null
)

@Serializable
data class ChartMoreInfo(
    val firstname: String? = null
)

@Serializable
data class RadioMoreInfo(
    val description: String? = null,
    val featured_station_type: String? = null,
    val query: String? = null,
    val color: String? = null,
    val language: String? = null,
    val station_display_text: String? = null
)

@Serializable
data class ArtistRecoMoreInfo(
    val featured_station_type: String? = null,
    val query: String? = null,
    val station_display_text: String? = null
)

@Serializable
data class MixMoreInfo(
    val firstname: String? = null,
    val lastname: String? = null,
    val type: String? = null
)

@Serializable
data class CityMoreInfo(
    val editorial_language: String? = null
)

@Serializable
data class GlobalConfig(
    val weekly_top_songs_listid: Map<String, WeeklyTopSongs>? = null,
    val random_songs_listid: Map<String, RandomSongs>? = null,
    val phn_otp_providers: Map<String, String>? = null
)

@Serializable
data class WeeklyTopSongs(
    val listid: String? = null,
    val image: String? = null,
    val title: String? = null,
    val count: Int? = null
)

@Serializable
data class RandomSongs(
    val listid: String? = null,
    val image: String? = null,
    val count: Int? = null
)

@Serializable
data class ArtistMap(
    val primary_artists: List<Artist> = emptyList(),
    val featured_artists: List<Artist> = emptyList(),
    val artists: List<Artist> = emptyList()
)

@Serializable
data class Artist(
    val id: String? = null,
    val name: String? = null,
    val role: String? = null,
    val image: String? = null,
    val type: String? = null,
    val perma_url: String? = null
)
