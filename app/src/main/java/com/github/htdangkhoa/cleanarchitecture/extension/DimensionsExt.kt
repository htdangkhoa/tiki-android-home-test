package com.github.htdangkhoa.cleanarchitecture.extension

import com.blankj.utilcode.util.ConvertUtils

fun Float.dp2px(): Int {
    return ConvertUtils.dp2px(this)
}

fun Float.px2dp(): Int {
    return ConvertUtils.px2dp(this)
}

fun Float.sp2px(): Int {
    return ConvertUtils.sp2px(this)
}

fun Float.px2sp(): Int {
    return ConvertUtils.px2sp(this)
}

fun Int.dp2px(): Int {
    return ConvertUtils.dp2px(this.toFloat())
}

fun Int.px2dp(): Int {
    return ConvertUtils.px2dp(this.toFloat())
}

fun Int.sp2px(): Int {
    return ConvertUtils.sp2px(this.toFloat())
}

fun Int.px2sp(): Int {
    return ConvertUtils.px2sp(this.toFloat())
}
