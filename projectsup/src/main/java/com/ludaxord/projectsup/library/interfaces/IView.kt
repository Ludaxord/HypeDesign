package com.ludaxord.projectsup.library.interfaces

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.View
import com.ludaxord.projectsup.R
import com.ludaxord.projectsup.library.utilities.colors.Color
import com.ludaxord.projectsup.library.utilities.overrideFontColor
import com.ludaxord.projectsup.library.utilities.overrideFontTypeFace
import com.ludaxord.projectsup.library.utilities.themes.Theme

interface IView {

    fun getStyledAttributes(context: Context, attributeSet: AttributeSet, attrs: IntArray): TypedArray {
        return context.obtainStyledAttributes(attributeSet, attrs)
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

    fun setFonts(rootView: View) {
        rootView.overrideFontTypeFace()
        rootView.overrideFontColor()
    }
}