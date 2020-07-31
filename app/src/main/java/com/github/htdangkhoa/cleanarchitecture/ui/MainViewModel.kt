package com.github.htdangkhoa.cleanarchitecture.ui

import androidx.lifecycle.ViewModel
import com.github.htdangkhoa.cleanarchitecture.data.model.BannerModel
import com.github.htdangkhoa.cleanarchitecture.data.model.FlashDealModel
import com.github.htdangkhoa.cleanarchitecture.data.model.QuickLinkModel
import com.github.htdangkhoa.cleanarchitecture.domain.Param
import com.github.htdangkhoa.cleanarchitecture.domain.UseCase
import com.github.htdangkhoa.cleanarchitecture.extension.liveDataOf
import com.github.htdangkhoa.cleanarchitecture.resource.Resource

class MainViewModel(private val useCase: UseCase): ViewModel() {
    val resourceBannersAndQuickLinks =
        liveDataOf<Resource<Pair<List<BannerModel?>, List<List<QuickLinkModel>>>>>()

    val resourceFlashDeals = liveDataOf<Resource<List<FlashDealModel>>>()

    fun getBannersAndQuickLinks() {
        resourceBannersAndQuickLinks.postValue(Resource.loading())

        val param = Param(Param.Type.GET_BANNERS_AND_QUICK_LINKS)

        useCase.execute<Pair<List<BannerModel?>, List<List<QuickLinkModel>>>>(param) {
            onComplete { resourceBannersAndQuickLinks.postValue(Resource.success(it)) }

            onError { resourceBannersAndQuickLinks.postValue(Resource.error(it)) }

            onCancel { resourceBannersAndQuickLinks.postValue(Resource.error(it)) }
        }
    }

    fun getFlashDeals() {
        resourceFlashDeals.postValue(Resource.loading())

        val param = Param(Param.Type.GET_FLASH_DEALS)

        useCase.execute<List<FlashDealModel>>(param) {
            onComplete { resourceFlashDeals.postValue(Resource.success(it)) }

            onError { resourceFlashDeals.postValue(Resource.error(it)) }

            onCancel { resourceFlashDeals.postValue(Resource.error(it)) }
        }
    }
}