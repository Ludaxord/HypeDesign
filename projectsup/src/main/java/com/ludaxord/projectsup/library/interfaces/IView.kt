package com.ludaxord.projectsup.library.interfaces

import android.content.Context
import android.content.res.TypedArray
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import com.ludaxord.projectsup.library.utilities.StyledAttributes
import com.ludaxord.projectsup.library.utilities.SupStyledAttributes
import com.ludaxord.projectsup.library.utilities.colors.Color
import com.ludaxord.projectsup.library.utilities.themes.Theme


interface IView : IDefaults {

    fun setViewUtilsFromStyledAttributes(context: Context, attrs: AttributeSet): StyledAttributes

    fun getStyledAttributes(context: Context, attributeSet: AttributeSet, attrs: IntArray): TypedArray {
        return context.obtainStyledAttributes(attributeSet, attrs)
    }

    fun getStyledAttributesTheme(styledAttributes: TypedArray, index: Int): String? {
        return styledAttributes.getString(index)
    }

    fun getStyledAttributesThemeName(styledAttributes: TypedArray, index: Int): String? {
        return styledAttributes.getString(index)
    }

    fun getStyledAttributesColorSchema(styledAttributes: TypedArray, index: Int): String? {
        return styledAttributes.getString(index)
    }

    fun getStyledAttributesDrawable(styledAttributes: TypedArray, index: Int): Drawable? {
        return styledAttributes.getDrawable(index)
    }

    fun getStyledAttributesLayout(context: Context, styledAttributes: TypedArray, index: Int): View? {
        val li = LayoutInflater.from(context)
        return li.inflate(styledAttributes.getInt(index, 0), null)
    }

    fun setColorSchema(colorRes: Int)

    fun setTheme(themeRes: Int)

    fun setColorSchema(colorRes: String)

    fun setTheme(themeRes: String)

    fun getColorSchema(): Color

    fun getTheme(): Theme
}