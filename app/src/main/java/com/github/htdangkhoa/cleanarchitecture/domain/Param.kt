package com.github.htdangkhoa.cleanarchitecture.domain

class Param(val type: Int) {
    internal annotation class Type {
        companion object {
            const val GET_BANNERS_AND_QUICK_LINKS = 0

            const val GET_FLASH_DEALS = 1
        }
    }
}