package com.ludaxord.projectsup.library.widget.interfaces

import com.ludaxord.projectsup.library.interfaces.IView
import com.ludaxord.projectsup.library.utilities.languages.interfaces.ILanguage
import com.ludaxord.projectsup.library.utilities.setEvents
import java.util.*

interface ICalendar : ILanguage, IView {
    fun addEvents(newEvents: ArrayList<Date>, events: ArrayList<Date>?) {
        events?.setEvents(newEvents)
    }

}