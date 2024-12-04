package com.vertonepa.noticias.most_popular.data.dto.most_popular


import com.google.gson.annotations.SerializedName

data class MediaMetadata(
    @SerializedName("format")
    val format: String,
    @SerializedName("height")
    val height: Int,
    @SerializedName("url")
    val url: String,
    @SerializedName("width")
    val width: Int
)