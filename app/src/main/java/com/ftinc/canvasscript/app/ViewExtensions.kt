package com.ftinc.canvasscript.app

import android.support.annotation.ColorInt
import android.support.annotation.ColorRes
import android.support.v4.content.ContextCompat
import android.view.View


@ColorInt fun View.color(@ColorRes resId: Int) : Int = ContextCompat.getColor(this.context, resId)