package com.ludaxord.projectsup.library.utilities

import android.graphics.drawable.GradientDrawable
import android.view.View


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

    fun setViewToBottom(view: View, withMargin: Float) {
        setMargin(view, marginBottom = withMargin)
    }

    private fun setMargin(
        view: View,
        marginTop: Float = 0f,
        marginBottom: Float = 0f,
        marginLeft: Float = 0f,
        marginRight: Float = 0f
    ) {

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