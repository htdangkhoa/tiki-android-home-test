package com.github.htdangkhoa.cleanarchitecture.data.model
import com.google.gson.annotations.SerializedName


data class FlashDealModel(
    @SerializedName("discount_percent")
    val discountPercent: Int?,
    @SerializedName("from_date")
    val fromDate: String?,
    @SerializedName("product")
    val product: Product?,
    @SerializedName("progress")
    val progress: Progress?,
    @SerializedName("special_from_date")
    val specialFromDate: Double?,
    @SerializedName("special_price")
    val specialPrice: Double?,
    @SerializedName("special_to_date")
    val specialToDate: Double?,
    @SerializedName("status")
    val status: Double?,
    @SerializedName("tags")
    val tags: String?,
    @SerializedName("url")
    val url: String?
) {
    data class Product(
        @SerializedName("badges")
        val badges: List<Badge?>?,
        @SerializedName("discount")
        val discount: Double?,
        @SerializedName("id")
        val id: Double?,
        @SerializedName("inventory")
        val inventory: Inventory?,
        @SerializedName("is_flower")
        val isFlower: Boolean?,
        @SerializedName("is_fresh")
        val isFresh: Boolean?,
        @SerializedName("is_gift_card")
        val isGiftCard: Boolean?,
        @SerializedName("is_visible")
        val isVisible: Boolean?,
        @SerializedName("list_price")
        val listPrice: Double?,
        @SerializedName("master_id")
        val masterId: Double?,
        @SerializedName("name")
        val name: String?,
        @SerializedName("order_count")
        val orderCount: Double?,
        @SerializedName("price")
        val price: Double?,
        @SerializedName("price_prefix")
        val pricePrefix: String?,
        @SerializedName("rating_average")
        val ratingAverage: Double?,
        @SerializedName("review_count")
        val reviewCount: Double?,
        @SerializedName("seller_product_id")
        val sellerProductId: Double?,
        @SerializedName("sku")
        val sku: Any?,
        @SerializedName("thumbnail_url")
        val thumbnailUrl: String?,
        @SerializedName("url_attendant_input_form")
        val urlAttendantInputForm: String?,
        @SerializedName("url_path")
        val urlPath: String?
    ) {
        data class Badge(
            @SerializedName("code")
            val code: String?
        )

        data class Inventory(
            @SerializedName("fulfillment_type")
            val fulfillmentType: String?,
            @SerializedName("product_virtual_type")
            val productVirtualType: Any?
        )
    }

    data class Progress(
        @SerializedName("percent")
        val percent: Double?,
        @SerializedName("qty")
        val qty: Double?,
        @SerializedName("qty_ordered")
        val qtyOrdered: Double?,
        @SerializedName("qty_remain")
        val qtyRemain: Double?,
        @SerializedName("status")
        val status: String?
    )
}