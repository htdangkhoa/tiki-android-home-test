package com.github.htdangkhoa.cleanarchitecture.di

import com.github.htdangkhoa.cleanarchitecture.di.module.NetModule
import com.github.htdangkhoa.cleanarchitecture.ui.MainModule

object AppComponent {
    val components = listOf(
        NetModule.module,
        MainModule.module
    )
}
