package com.ludaxord.projectsup.library.widget.calendarview

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import com.ludaxord.projectsup.library.utilities.checkLanguage
import com.ludaxord.projectsup.library.utilities.colors.Color
import com.ludaxord.projectsup.library.utilities.languages.Language
import com.ludaxord.projectsup.library.utilities.themes.Theme


class SupCalendarView : AbstractSupCalendarView {

    private lateinit var styledAttributes: StyledAttributes

    constructor(context: Context) : super(context) {
        Log.i("ProjectSup", "ComplexCon")
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        Log.i("ProjectSup", "MCA")
        styledAttributes = setViewUtilsFromStyledAttributes(attrs)
        setDefaultViewUtils()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        Log.i("ProjectSup", "MoMA")
    }

    override fun setDefaultViewUtils() {
        super.setDefaultViewUtils()
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