package com.github.htdangkhoa.cleanarchitecture.ui

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import com.bumptech.glide.Glide
import com.denzcoskun.imageslider.models.SlideModel
import com.github.htdangkhoa.cleanarchitecture.OnQuickLinkClickListener
import com.github.htdangkhoa.cleanarchitecture.R
import com.github.htdangkhoa.cleanarchitecture.base.BaseActivity
import com.github.htdangkhoa.cleanarchitecture.data.model.BannerModel
import com.github.htdangkhoa.cleanarchitecture.data.model.FlashDealModel
import com.github.htdangkhoa.cleanarchitecture.data.model.QuickLinkModel
import com.github.htdangkhoa.cleanarchitecture.resource.ObserverResource
import com.github.htdangkhoa.cleanarchitecture.ui.widget.QuickLinkView
import com.pawegio.kandroid.hide
import com.pawegio.kandroid.show
import com.pawegio.kandroid.toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<MainViewModel>(MainViewModel::class) {
    private val adapter: FlashDealAdapter by lazy { FlashDealAdapter() }

    override val layoutResID: Int
        get() = R.layout.activity_main

    override fun render(savedInstanceState: Bundle?) {
        super.render(savedInstanceState)

        onObserveLiveData()

        viewModel.getBannersAndQuickLinks()

        recyclerView.adapter = adapter

        swipeRefreshLayout.setOnRefreshListener {
            // Clear all data.
            imageSlider.setImageList(mutableListOf())

            quickLinksContainer.removeAllViews()

            adapter.setNewInstance(mutableListOf())

            // Hide views
            imageSlider.hide(true)

            horizontalView.hide(true)

            flashDealContainer.hide(true)

            viewModel.getBannersAndQuickLinks()
        }
    }

    private fun onObserveLiveData() {
        viewModel.resourceBannersAndQuickLinks.observe(this,
            object : ObserverResource<Pair<List<BannerModel?>, List<List<QuickLinkModel>>>>() {
                override fun onSuccess(data: Pair<List<BannerModel?>, List<List<QuickLinkModel>>>) {
                    swipeRefreshLayout.isRefreshing = false

                    val banners = data.first.mapNotNull { it?.imageUrl?.let { SlideModel(it) } }

                    with(imageSlider) {
                        if (banners.isEmpty().not()) {
                            show()

                            setImageList(banners)
                        }
                    }

                    val quickLinks = data.second

                    if (quickLinks.isEmpty().not()) {
                        horizontalView.show()

                        quickLinks.forEach { quickLinksContainer.addView(renderQuickLinks(it)) }
                    }

                    viewModel.getFlashDeals()
                }

                override fun onError(throwable: Throwable?) {
                    showDialog("Error", throwable?.message ?: "Something went wrong.")
                }

                override fun onLoading(isShow: Boolean) {
                    progressBar.visibility = if (isShow) View.VISIBLE
                    else View.GONE
                }

            })

        viewModel.resourceFlashDeals.observe(this,
            object : ObserverResource<List<FlashDealModel>>() {
                override fun onSuccess(data: List<FlashDealModel>) {
                    if (data.isEmpty().not()) {
                        flashDealContainer.show()

                        adapter.setNewInstance(data.toMutableList())
                    }
                }

                override fun onError(throwable: Throwable?) {
                    showDialog("Error", throwable?.message ?: "Something went wrong.")
                }

                override fun onLoading(isShow: Boolean) {
                    progressBar.visibility = if (isShow) View.VISIBLE
                    else View.GONE
                }
            })
    }

    private fun renderQuickLinks(quickLinkModels: List<QuickLinkModel>): View {
        val container = LinearLayout(this).apply {
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
            orientation = LinearLayout.HORIZONTAL

            quickLinkModels.forEach { link ->
                val v = QuickLinkView(this.context, link)
                v.layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)

                v.onQuickLinkClickListener = { v, ql ->
                    try {
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(ql.url))

                        startActivity(intent)
                    } catch (e: ActivityNotFoundException) {
                        toast("Please install Tiki app.")
                    }
                }

                addView(v)
            }
        }

        return container
    }
}