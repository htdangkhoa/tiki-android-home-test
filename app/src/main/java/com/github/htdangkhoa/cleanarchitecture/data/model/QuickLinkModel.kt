package com.github.htdangkhoa.cleanarchitecture.data.model
import com.google.gson.annotations.SerializedName


data class QuickLinkModel(
    @SerializedName("authentication")
    val authentication: Boolean?,
    @SerializedName("content")
    val content: String?,
    @SerializedName("image_url")
    val imageUrl: String?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("url")
    val url: String?,
    @SerializedName("web_url")
    val webUrl: String?
)