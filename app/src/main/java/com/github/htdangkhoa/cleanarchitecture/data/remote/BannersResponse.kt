package com.github.htdangkhoa.cleanarchitecture.data.remote

import com.github.htdangkhoa.cleanarchitecture.data.model.BannerModel
import com.github.htdangkhoa.cleanarchitecture.data.model.ResponseModel
import com.google.gson.annotations.SerializedName

data class BannersResponse(
    @SerializedName("data")
    override val data: List<BannerModel?>
): ResponseModel<BannerModel>()