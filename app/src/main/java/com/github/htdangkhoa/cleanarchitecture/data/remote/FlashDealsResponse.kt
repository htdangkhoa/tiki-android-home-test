package com.github.htdangkhoa.cleanarchitecture.data.remote

import com.github.htdangkhoa.cleanarchitecture.data.model.FlashDealModel
import com.github.htdangkhoa.cleanarchitecture.data.model.ResponseModel
import com.google.gson.annotations.SerializedName

data class FlashDealsResponse(
    @SerializedName("data")
    override val data: List<FlashDealModel>
): ResponseModel<FlashDealModel>()