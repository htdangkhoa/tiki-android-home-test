package com.github.htdangkhoa.cleanarchitecture.extension

import java.text.NumberFormat
import java.util.*

fun Number.formatPrice(): String {
    val format = NumberFormat.getCurrencyInstance()
    format.maximumFractionDigits = 0
    format.currency = Currency.getInstance("VND")

    return format.format(this)
}