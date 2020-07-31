package com.github.htdangkhoa.cleanarchitecture.ui

import com.github.htdangkhoa.cleanarchitecture.data.repository.Repository
import com.github.htdangkhoa.cleanarchitecture.data.repository.RepositoryImp
import com.github.htdangkhoa.cleanarchitecture.data.service.ApiService
import com.github.htdangkhoa.cleanarchitecture.domain.UseCase
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object MainModule {
    val module = module {
        single(override = true) { provideRepository(get()) }

        single(override = true) { provideUseCase(get()) }

        viewModel { MainViewModel(get()) }
    }

    private fun provideRepository(apiService: ApiService): Repository = RepositoryImp(apiService)

    private fun provideUseCase(repository: Repository) = UseCase(repository)
}