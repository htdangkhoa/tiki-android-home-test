package com.github.htdangkhoa.cleanarchitecture.domain

import com.github.htdangkhoa.cleanarchitecture.base.BaseUseCase
import com.github.htdangkhoa.cleanarchitecture.data.repository.Repository

class UseCase(
    repository: Repository) : BaseUseCase<Repository, Param>(repository) {
    override suspend fun buildUseCase(param: Param?): Result<*> {
        return when (param?.type) {
            Param.Type.GET_BANNERS_AND_QUICK_LINKS ->
                repository.getBannersAndQuickLinks()

            Param.Type.GET_FLASH_DEALS ->
                repository.getFlashDeals()

            else -> throw UnsupportedOperationException("This request is not support in this case!")
        }
    }
}