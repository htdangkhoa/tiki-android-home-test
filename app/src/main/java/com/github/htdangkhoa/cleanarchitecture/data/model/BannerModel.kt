package com.github.htdangkhoa.cleanarchitecture.data.model
import com.google.gson.annotations.SerializedName


data class BannerModel(
    @SerializedName("content")
    val content: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("image_url")
    val imageUrl: String?,
    @SerializedName("mobile_url")
    val mobileUrl: String?,
    @SerializedName("ratio")
    val ratio: Double?,
    @SerializedName("thumbnail_url")
    val thumbnailUrl: String?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("url")
    val url: String?
)