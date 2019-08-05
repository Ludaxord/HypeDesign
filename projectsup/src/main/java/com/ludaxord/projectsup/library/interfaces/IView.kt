package com.ludaxord.projectsup.library.interfaces

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import com.ludaxord.projectsup.R
import com.ludaxord.projectsup.library.utilities.colors.Color
import com.ludaxord.projectsup.library.utilities.themes.Theme

interface IView {

    fun getStyledAttributes(
        context: Context,
        attributeSet: AttributeSet,
        attrs: IntArray,
        defStyle: Int,
        defStyleRes: Int = 0
    ): TypedArray {
        return context.obtainStyledAttributes(attributeSet, attrs, defStyle, defStyleRes)
    }

    fun getStyledAttributesTheme(styledAttributes: TypedArray, index: Int): Int {
        return styledAttributes.getInt(index, R.integer.sup_default_style)
    }

    fun getStyledAttributesThemeName(styledAttributes: TypedArray, index: Int): String? {
        return styledAttributes.getString(index)
    }

    fun getStyledAttributesColorSchema(styledAttributes: TypedArray, index: Int): Int {
        return styledAttributes.getInt(index, R.integer.sup_default_color_schema)
    }

    fun setColorSchema(colorRes: Int)

    fun setTheme(themeRes: Int)

    fun getColorSchema(): Color

    fun getTheme(): Theme

}