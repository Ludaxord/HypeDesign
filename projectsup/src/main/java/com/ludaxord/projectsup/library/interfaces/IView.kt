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

    fun setViewUtilsFromStyledAttributes(context: Context, attrs: AttributeSet): StyledAttributes {
        val a = getStyledAttributes(context, attrs, com.ludaxord.projectsup.R.styleable.SupCalendarView)
        val themeRes = getStyledAttributesTheme(a, com.ludaxord.projectsup.R.styleable.SupCalendarView_theme_res)
        val themeNameRes =
            getStyledAttributesThemeName(a, com.ludaxord.projectsup.R.styleable.SupCalendarView_theme_name_res)
        val colorSchemaRes =
            getStyledAttributesColorSchema(a, com.ludaxord.projectsup.R.styleable.SupCalendarView_color_schema_res)
        a.recycle()
        return SupStyledAttributes(themeRes, themeNameRes, colorSchemaRes)
    }

    fun getStyledAttributes(context: Context, attributeSet: AttributeSet, attrs: IntArray): TypedArray {
        return context.obtainStyledAttributes(attributeSet, attrs)
    }

    fun getStyledAttributesTheme(styledAttributes: TypedArray, index: Int): Int {
        return styledAttributes.getInt(index, com.ludaxord.projectsup.R.integer.sup_default_style)
    }

    fun getStyledAttributesThemeName(styledAttributes: TypedArray, index: Int): String? {
        return styledAttributes.getString(index)
    }

    fun getStyledAttributesColorSchema(styledAttributes: TypedArray, index: Int): Int {
        return styledAttributes.getInt(index, com.ludaxord.projectsup.R.integer.sup_default_color_schema)
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

    fun getColorSchema(): Color

    fun getTheme(): Theme
}