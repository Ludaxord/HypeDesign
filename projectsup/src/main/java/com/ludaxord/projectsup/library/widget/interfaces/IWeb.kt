package com.ludaxord.projectsup.library.widget.interfaces

import android.content.Context
import android.util.AttributeSet
import com.ludaxord.projectsup.library.interfaces.IView
import com.ludaxord.projectsup.library.utilities.StyledAttributes
import com.ludaxord.projectsup.library.utilities.SupStyledAttributes
import com.ludaxord.projectsup.library.utilities.languages.interfaces.ILanguage

interface IWeb : ILanguage, IView {

    override fun setViewUtilsFromStyledAttributes(context: Context, attrs: AttributeSet): StyledAttributes {
        val a = getStyledAttributes(context, attrs, com.ludaxord.projectsup.R.styleable.SupCalendarView)
        val themeRes = getStyledAttributesTheme(a, com.ludaxord.projectsup.R.styleable.SupCalendarView_theme_res)
        val colorSchemaRes =
            getStyledAttributesColorSchema(a, com.ludaxord.projectsup.R.styleable.SupCalendarView_color_schema_res)
        a.recycle()
        return SupStyledAttributes(themeRes, colorSchemaRes)
    }

}