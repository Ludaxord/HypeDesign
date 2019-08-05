package com.ludaxord.projectsup.library.widget.calendarview

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import com.ludaxord.projectsup.R
import com.ludaxord.projectsup.library.utilities.checkLanguage
import com.ludaxord.projectsup.library.utilities.colors.Color
import com.ludaxord.projectsup.library.utilities.languages.Language
import com.ludaxord.projectsup.library.utilities.themes.Theme


class SupCalendarView : AbstractSupCalendarView {

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {

        val a = getStyledAttributes(context, attrs, R.styleable.SupCalendarView, defStyleAttr)

        val themeRes = getStyledAttributesTheme(a, R.styleable.SupCalendarView_theme_res)
        val themeNameRes = getStyledAttributesThemeName(a, R.styleable.SupCalendarView_theme_name_res)
        val colorSchemaRes = getStyledAttributesColorSchema(a, R.styleable.SupCalendarView_color_schema_res)
        val languageRes = getStyledAttributesLanguage(a, R.styleable.SupCalendarView_language_res)

        a.recycle()

        Log.w(
            "tripoloski",
            "defStyleAttr -> $defStyleAttr theme -> $themeRes, themeName -> $themeNameRes, colorSchema -> $colorSchemaRes, language -> $languageRes"
        )
    }

    override fun changeLanguageWeekDays(actualLanguage: Language, newLanguage: String) {
        super.changeLanguageWeekDays(actualLanguage, newLanguage)
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