package com.github.htdangkhoa.cleanarchitecture.data.repository

import com.github.htdangkhoa.cleanarchitecture.base.BaseRepository
import com.github.htdangkhoa.cleanarchitecture.data.model.BannerModel
import com.github.htdangkhoa.cleanarchitecture.data.model.FlashDealModel
import com.github.htdangkhoa.cleanarchitecture.data.model.QuickLinkModel

interface Repository: BaseRepository {
    suspend fun getBannersAndQuickLinks():
            Result<Pair<List<BannerModel?>, List<List<QuickLinkModel>>>>

    suspend fun getFlashDeals(): Result<List<FlashDealModel>>
}