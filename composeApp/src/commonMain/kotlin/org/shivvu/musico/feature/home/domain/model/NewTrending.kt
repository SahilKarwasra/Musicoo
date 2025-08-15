package org.shivvu.musico.feature.home.domain.model

import kotlinx.serialization.Serializable


@Serializable
data class TrendingResponse(
    val history: List<NewTrending> = emptyList(),
    val new_trending: List<NewTrending> = emptyList()
)

@Serializable
data class NewTrending(
    val explicit_content: String,
    val header_desc: String,
    val id: String,
    val image: String,
    val language: String,
    val list: String,
    val list_count: String,
    val list_type: String,
    val more_info: MoreInfo,
    val perma_url: String,
    val play_count: String,
    val subtitle: String,
    val title: String,
    val type: String,
    val year: String
)

@Serializable
data class Artist(
    val id: String,
    val image: String,
    val name: String,
    val perma_url: String,
    val role: String,
    val type: String
)

@Serializable
data class ArtistMap(
    val artists: List<Artist>,
    val featured_artists: List<String?>,
    val primary_artists: List<PrimaryArtist>
)

@Serializable
data class MoreInfo(
    val `320kbps`: String? = null,
    val album: String? = null,
    val album_id: String? = null,
    val album_url: String? = null,
    val artistMap: ArtistMap? = null,
    val cache_state: String? = null,
    val copyright_text: String? = null,
    val duration: String? = null,
    val encrypted_cache_url: String? = null,
    val encrypted_drm_cache_url: String? = null,
    val encrypted_drm_media_url: String? = null,
    val encrypted_media_url: String? = null,
    val has_lyrics: String? = null,
    val is_dolby_content: Boolean? = null,
    val label: String? = null,
    val label_id: String? = null,
    val label_url: String? = null,
    val lyrics_snippet: String? = null,
    val music: String? = null,
    val origin: String? = null,
    val release_date: String? = null,
    val request_jiotune_flag: Boolean? = null,
    val rights: Rights? = null,
    val song_count: String? = null,
    val starred: String? = null,
    val triller_available: Boolean? = null,
    val vcode: String? = null,
    val vlink: String? = null,
    val webp: String? = null
)

@Serializable
data class PrimaryArtist(
    val id: String,
    val image: String,
    val name: String,
    val perma_url: String,
    val role: String,
    val type: String
)

@Serializable
data class Rights(
    val cacheable: String,
    val code: String,
    val delete_cached_object: String,
    val reason: String
)