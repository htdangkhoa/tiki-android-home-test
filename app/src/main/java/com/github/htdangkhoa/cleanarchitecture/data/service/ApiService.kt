package com.github.htdangkhoa.cleanarchitecture.data.service

import com.github.htdangkhoa.cleanarchitecture.data.remote.BannersResponse
import com.github.htdangkhoa.cleanarchitecture.data.remote.FlashDealsResponse
import com.github.htdangkhoa.cleanarchitecture.data.remote.QuickLinksResponse
import retrofit2.http.GET

interface ApiService {
    @GET("v2/home/banners/v2")
    suspend fun getBanners(): BannersResponse

    @GET("shopping/v2/widgets/quick_link")
    suspend fun getQuickLinks(): QuickLinksResponse

    @GET("v2/widget/deals/hot")
    suspend fun getFlashDeals(): FlashDealsResponse
}
