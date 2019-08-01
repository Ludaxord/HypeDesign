package com.ludaxord.projectsup.library.widget.calendarview

import android.content.Context
import android.util.AttributeSet
import com.ludaxord.projectsup.library.utilities.checkLanguage
import com.ludaxord.projectsup.library.utilities.languages.Language

class SupCalendarView : AbstractSupCalendarView {

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun changeLanguage(actualLanguage: Language, newLanguage: String): Language {
        val language = setLanguage(newLanguage, resources)
        return if (language.checkLanguage(actualLanguage)) {
            calendarLanguage = language
            language
        } else {
            actualLanguage
        }
    }


}