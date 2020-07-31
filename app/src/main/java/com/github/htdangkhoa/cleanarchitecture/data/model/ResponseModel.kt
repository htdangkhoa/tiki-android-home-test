package com.github.htdangkhoa.cleanarchitecture.data.model

import com.google.gson.annotations.SerializedName

abstract class ResponseModel<T : Any?> {
    abstract val data: List<T?>
}
