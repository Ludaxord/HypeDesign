package com.ludaxord.projectsup.library.widget.interfaces

import com.ludaxord.projectsup.library.utilities.languages.interfaces.ILanguage
import com.ludaxord.projectsup.library.utilities.setEvents
import java.util.*
import kotlin.collections.ArrayList

interface ICalendar: ILanguage {
    fun addEvents(newEvents: ArrayList<Date>, events: ArrayList<Date>?) {
        events?.setEvents(newEvents)
    }
}