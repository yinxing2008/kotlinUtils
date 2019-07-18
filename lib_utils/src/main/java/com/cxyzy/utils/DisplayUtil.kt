package com.cxyzy.utils

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.graphics.Point

/**
 * 显示相关，像素dp转换
 */
object DisplayUtil {

    @SuppressLint("PrivateApi")
    fun getStatusBarHeight(context: Context): Int {
        var statusBarHeight = 0
        try {
            val c = Class.forName("com.android.internal.R\$dimen")
            val o = c.newInstance()
            val field = c.getField("status_bar_height")
            val x = field.get(o) as Int
            statusBarHeight = context.resources.getDimensionPixelSize(x)
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return statusBarHeight
    }

    /**
     * 获取屏幕高度和宽度
     */
    fun getScreenSize(activity: Activity): Point {
        val defaultDisplay = activity.windowManager.defaultDisplay
        val point = Point()
        defaultDisplay.getSize(point)
        return point
    }

    /**
     * 获取除去状态栏的屏幕高度
     */
    fun getScreenHeightExcludeStatusbar(context: Context): Int {
        return context.resources.displayMetrics.heightPixels - getStatusBarHeight(context)
    }

    fun px2dp(context: Context, pxValue: Float): Int {
        val density = context.resources.displayMetrics.density
        return (pxValue / density + 0.5f).toInt()
    }

    fun dp2px(context: Context, dpValue: Float): Int {
        val density = context.resources.displayMetrics.density
        return (dpValue * density + 0.5f).toInt()
    }

    fun px2sp(context: Context, pxValue: Float): Int {
        val scaleDensity = context.resources.displayMetrics.scaledDensity
        return (pxValue / scaleDensity + 0.5f).toInt()
    }

    fun sp2px(context: Context, spValue: Float): Int {
        val scaleDensity = context.resources.displayMetrics.scaledDensity
        return (spValue * scaleDensity + 0.5f).toInt()
    }
}