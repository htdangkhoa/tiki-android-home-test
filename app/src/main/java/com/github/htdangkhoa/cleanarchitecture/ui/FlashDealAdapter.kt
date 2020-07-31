package com.github.htdangkhoa.cleanarchitecture.ui

import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.github.htdangkhoa.cleanarchitecture.R
import com.github.htdangkhoa.cleanarchitecture.data.model.FlashDealModel
import com.github.htdangkhoa.cleanarchitecture.extension.formatPrice

class FlashDealAdapter: BaseQuickAdapter<FlashDealModel, BaseViewHolder>(R.layout.item_flash_deal) {
    override fun convert(holder: BaseViewHolder, item: FlashDealModel) {
        Glide.with(holder.itemView)
            .load(item.product?.thumbnailUrl)
            .into(holder.getView(R.id.imgProduct))

        holder.setText(R.id.txtPrice, "${item.product?.price?.formatPrice()}")

        holder.setText(R.id.txtBadgeDiscount, "${item.discountPercent} %")
    }
}