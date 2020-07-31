package com.github.htdangkhoa.cleanarchitecture.data.remote

import com.github.htdangkhoa.cleanarchitecture.data.model.QuickLinkModel
import com.github.htdangkhoa.cleanarchitecture.data.model.ResponseModel
import com.google.gson.annotations.SerializedName

data class QuickLinksResponse(
    @SerializedName("data")
    override val data: List<List<QuickLinkModel>>
): ResponseModel<List<QuickLinkModel>>()