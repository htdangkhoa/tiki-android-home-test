package com.github.htdangkhoa.cleanarchitecture.data.repository

import com.github.htdangkhoa.cleanarchitecture.base.BaseRepositoryImp
import com.github.htdangkhoa.cleanarchitecture.data.model.BannerModel
import com.github.htdangkhoa.cleanarchitecture.data.model.FlashDealModel
import com.github.htdangkhoa.cleanarchitecture.data.model.QuickLinkModel
import com.github.htdangkhoa.cleanarchitecture.data.service.ApiService

class RepositoryImp(
    apiService: ApiService
) : BaseRepositoryImp(apiService), Repository {
    override suspend fun getBannersAndQuickLinks():
            Result<Pair<List<BannerModel?>, List<List<QuickLinkModel>>>> {
        val res: Pair<MutableList<BannerModel?>, MutableList<List<QuickLinkModel>>>
                = Pair(mutableListOf(), mutableListOf())

        return try {
            val resBanners = apiService.getBanners()

            res.first.addAll(resBanners.data)

            val resQuickLinks = apiService.getQuickLinks()

            res.second.addAll(resQuickLinks.data)

            Result.success(res)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun getFlashDeals(): Result<List<FlashDealModel>> {
        return try {
            val res = apiService.getFlashDeals();

            Result.success(res.data)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}