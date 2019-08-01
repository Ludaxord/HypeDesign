package com.ludaxord.projectsup.library.widget.calendarview

import android.content.Context
import android.util.AttributeSet
import com.ludaxord.projectsup.library.utilities.checkLanguage
import com.ludaxord.projectsup.library.utilities.colors.Color
import com.ludaxord.projectsup.library.utilities.languages.Language
import com.ludaxord.projectsup.library.utilities.themes.Theme

class SupCalendarView : AbstractSupCalendarView {

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun changeLanguageWeekDays(actualLanguage: Language, newLanguage: String) {
        super.changeLanguageWeekDays(actualLanguage, newLanguage)
    }

    override fun changeLanguage(actualLanguage: Language, newLanguage: String): Language {
        val language = setLanguage(newLanguage, resources)
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