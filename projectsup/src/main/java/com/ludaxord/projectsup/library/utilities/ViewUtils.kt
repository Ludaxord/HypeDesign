package com.ludaxord.projectsup.library.utilities

import android.graphics.drawable.GradientDrawable
import android.view.View
import android.view.ViewGroup


object ViewUtils {

    fun setViewCorners(view: View, corner: Float) {
        val backgroundShape = view.background
        if (backgroundShape is GradientDrawable) {
            setCornerRadius(backgroundShape, corner)
        } else {
            throw UtilsException(view.context.getString(com.ludaxord.projectsup.R.string.utils_exception_gradient_drawable_message))
        }
    }

    fun setViewCustomCorners(view: View, corners: List<Float>) {
        val backgroundShape = view.background
        if (backgroundShape is GradientDrawable) {
            setCornerRadius(backgroundShape, corners[0], corners[1], corners[2], corners[3])
        } else {
            throw UtilsException(view.context.getString(com.ludaxord.projectsup.R.string.utils_exception_gradient_drawable_message))
        }
    }

    fun getChildren(view: View): ArrayList<View> {
        return getAllChildren(view)
    }

    fun setViewToBottom(view: View, withMargin: Int) {
        setMargin(view, marginBottom = withMargin)
    }

    fun setViewsIds(rootView: View, views: ArrayList<View>) {
        if (views.isNotEmpty()) {
            for (view in views) {
                setViewId(view)
            }
        } else {
            throw UtilsException(rootView.context.getString(com.ludaxord.projectsup.R.string.utils_exception_empty_view_array_list_message))
        }
    }

    fun setViewsToRootView(rootView: ViewGroup, views: ArrayList<View>) {
        if (views.isNotEmpty()) {
            for (view in views) {
                setSubViewToView(rootView, view)
            }
        } else {
            throw UtilsException(rootView.context.getString(com.ludaxord.projectsup.R.string.utils_exception_empty_view_array_list_message))
        }
    }

    private fun setViewId(view: View) {
        if (view.id == View.NO_ID) {
            view.id = View.generateViewId()
        }
    }

    private fun setSubViewToView(rootView: ViewGroup, view: View) {
        rootView.addView(view)
    }

    private fun setMargin(
        view: View,
        marginTop: Int = 0,
        marginBottom: Int = 0,
        marginLeft: Int = 0,
        marginRight: Int = 0
    ) {
        if (view.layoutParams is ViewGroup.MarginLayoutParams) {
            val params = view.layoutParams as ViewGroup.MarginLayoutParams
            params.setMargins(marginLeft, marginTop, marginRight, marginBottom)
            view.requestLayout()
        } else {
            throw UtilsException(view.context.getString(com.ludaxord.projectsup.R.string.utils_exception_margin_message))
        }
    }

    private fun setCornerRadius(
        drawable: GradientDrawable,
        topLeft: Float,
        topRight: Float,
        bottomRight: Float,
        bottomLeft: Float
    ) {
        drawable.cornerRadii =
            floatArrayOf(topLeft, topLeft, topRight, topRight, bottomRight, bottomRight, bottomLeft, bottomLeft)
    }

    private fun setCornerRadius(drawable: GradientDrawable, radius: Float) {
        drawable.cornerRadius = radius
    }

    private fun getAllChildren(v: View): ArrayList<View> {
        if (v !is ViewGroup) {
            val viewArrayList = ArrayList<View>()
            viewArrayList.add(v)
            return viewArrayList
        }
        val result = ArrayList<View>()
        for (i in 0 until v.childCount) {

            val child = v.getChildAt(i)

            val viewArrayList = ArrayList<View>()
            viewArrayList.add(v)
            viewArrayList.addAll(getAllChildren(child))

            result.addAll(viewArrayList)
        }
        return result
    }

}