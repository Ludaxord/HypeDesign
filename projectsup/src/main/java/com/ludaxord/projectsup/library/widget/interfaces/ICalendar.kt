package com.ludaxord.projectsup.library.widget.interfaces

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import com.ludaxord.projectsup.library.interfaces.IView
import com.ludaxord.projectsup.library.utilities.StyledAttributes
import com.ludaxord.projectsup.library.utilities.SupStyledAttributes
import com.ludaxord.projectsup.library.utilities.languages.interfaces.ILanguage
import com.ludaxord.projectsup.library.utilities.setEvents
import java.util.*

interface ICalendar : ILanguage, IView {
    fun addEvents(newEvents: ArrayList<Date>, events: ArrayList<Date>?) {
        events?.setEvents(newEvents)
    }

    fun setNavigationButtonsDrawable(drawables: Pair<Drawable?, Drawable?>, buttons: Pair<View, View>) {
        if (buttons.first is ImageView) {
            (buttons.first as ImageView).setImageDrawable(drawables.first)
        }
        if (buttons.second is ImageView) {
            (buttons.second as ImageView).setImageDrawable(drawables.second)
        }
    }

    override fun setViewUtilsFromStyledAttributes(context: Context, attrs: AttributeSet): StyledAttributes {
        val a = getStyledAttributes(context, attrs, com.ludaxord.projectsup.R.styleable.SupCalendarView)
        val themeRes = getStyledAttributesString(a, com.ludaxord.projectsup.R.styleable.SupCalendarView_theme_res)
        val colorSchemaRes =
            getStyledAttributesString(a, com.ludaxord.projectsup.R.styleable.SupCalendarView_color_schema_res)
        a.recycle()
        return SupStyledAttributes(themeRes, colorSchemaRes)
    }
}