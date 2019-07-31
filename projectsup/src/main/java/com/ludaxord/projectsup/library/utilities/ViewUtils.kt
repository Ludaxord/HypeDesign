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

    fun setViewToBottom(view: View, withMargin: Int) {
        setMargin(view, marginBottom = withMargin)
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

}