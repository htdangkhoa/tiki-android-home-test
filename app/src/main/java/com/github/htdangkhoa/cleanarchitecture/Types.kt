package com.github.htdangkhoa.cleanarchitecture

import android.view.View
import com.github.htdangkhoa.cleanarchitecture.data.model.QuickLinkModel

typealias OnQuickLinkClickListener = (v: View, quickLinkModel: QuickLinkModel) -> Unit