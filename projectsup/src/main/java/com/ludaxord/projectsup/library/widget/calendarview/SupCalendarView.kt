package com.ludaxord.projectsup.library.widget.calendarview

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.util.Log
import com.ludaxord.projectsup.R
import com.ludaxord.projectsup.library.utilities.Defaults.TAG
import com.ludaxord.projectsup.library.utilities.StyledAttributes
import com.ludaxord.projectsup.library.utilities.checkLanguage
import com.ludaxord.projectsup.library.utilities.colors.Color
import com.ludaxord.projectsup.library.utilities.languages.Language
import com.ludaxord.projectsup.library.utilities.themes.Theme


class SupCalendarView : AbstractSupCalendarView {

    constructor(context: Context) : super(context) {
        Log.i(TAG, "ComplexCon")
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        Log.i(TAG, "MCA")
        styledAttributes = setViewUtilsFromStyledAttributes(context, attrs)
        setDefaultViewUtils()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        Log.i(TAG, "MoMA")
    }

    override fun changeLanguage(actualLanguage: Language, newLanguage: String): Language {
        val language = setLanguage(newLanguage, context)
        return if (language.checkLanguage(actualLanguage)) {
            languageName = newLanguage
            calendarLanguage = language
            language
        } else {
            actualLanguage
        }
    }

    override fun setColorSchema(colorRes: Int) {
        setDefaultColorSchema(colorRes)
    }

    override fun setTheme(themeRes: Int) {
        setDefaultTheme(themeRes)
    }

    override fun getColorSchema(): Color {
        return getDefaultColorSchema()
    }

    override fun getTheme(): Theme {
        return getDefaultTheme()
    }
}