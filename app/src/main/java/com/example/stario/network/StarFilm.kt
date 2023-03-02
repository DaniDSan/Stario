package com.example.stario.network

import com.squareup.moshi.Json

//JSON with pair value data
data class StarFilm (
    val title: String,
    @Json(name = "episode_id") val episodeId: Int
        )