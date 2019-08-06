package com.ludaxord.projectsup.library.widget.interfaces

import android.content.res.TypedArray
import android.graphics.drawable.Drawable
import android.view.View
import android.widget.Button
import android.widget.ImageView
import com.ludaxord.projectsup.R
import com.ludaxord.projectsup.library.interfaces.IView
import com.ludaxord.projectsup.library.utilities.languages.interfaces.ILanguage
import com.ludaxord.projectsup.library.utilities.setEvents
import java.util.*

interface ICalendar : ILanguage, IView {
    fun addEvents(newEvents: ArrayList<Date>, events: ArrayList<Date>?) {
        events?.setEvents(newEvents)
    }

    fun getStyledAttributesLanguage(styledAttributes: TypedArray, index: Int): String? {
        return styledAttributes.getString(index)
    }

    fun setNavigationButtonsDrawable(drawables: Pair<Drawable?, Drawable?>, buttons: Pair<View, View>) {
        if (buttons.first is ImageView) {
            (buttons.first as ImageView).setImageDrawable(drawables.first)
        }
        if (buttons.second is ImageView) {
            (buttons.second as ImageView).setImageDrawable(drawables.second)
        }
    }
}