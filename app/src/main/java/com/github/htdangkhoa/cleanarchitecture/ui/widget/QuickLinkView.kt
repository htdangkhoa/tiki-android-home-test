package com.github.htdangkhoa.cleanarchitecture.ui.widget

import android.content.Context
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.bumptech.glide.Glide
import com.github.htdangkhoa.cleanarchitecture.OnQuickLinkClickListener
import com.github.htdangkhoa.cleanarchitecture.R
import com.github.htdangkhoa.cleanarchitecture.data.model.QuickLinkModel
import com.github.htdangkhoa.cleanarchitecture.extension.dp2px
import kotlinx.android.synthetic.main.item_quick_link.view.*

class QuickLinkView(
    context: Context,
    quickLinkModel: QuickLinkModel
) : LinearLayout(context) {
    var onQuickLinkClickListener: OnQuickLinkClickListener? = null

    init {
        LayoutInflater.from(context).inflate(
            R.layout.item_quick_link, this, true)

        Glide.with(context)
            .load(quickLinkModel.imageUrl)
            .into(imgQuickLink)

        txtQuickLinkTitle.text = quickLinkModel.title

        setOnClickListener {
            onQuickLinkClickListener?.invoke(it, quickLinkModel)
        }
    }
}