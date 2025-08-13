package org.shivvu.musico.feature.home.domain.model

import kotlinx.serialization.Serializable

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
    val `320kbps`: String,
    val album: String,
    val album_id: String,
    val album_url: String,
    val artistMap: ArtistMap,
    val cache_state: String,
    val copyright_text: String,
    val duration: String,
    val encrypted_cache_url: String,
    val encrypted_drm_cache_url: String,
    val encrypted_drm_media_url: String,
    val encrypted_media_url: String,
    val has_lyrics: String,
    val is_dolby_content: Boolean,
    val label: String,
    val label_id: String,
    val label_url: String,
    val lyrics_snippet: String,
    val music: String,
    val origin: String,
    val release_date: String,
    val request_jiotune_flag: Boolean,
    val rights: Rights,
    val song_count: String,
    val starred: String,
    val triller_available: Boolean,
    val vcode: String,
    val vlink: String,
    val webp: String
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