package com.ludaxord.projectsup.library.utilities

import java.util.*
import kotlin.collections.ArrayList

object DateUtils {

    fun setEventsToExistedEvents(events: ArrayList<Date>, newEvents: ArrayList<Date>): ArrayList<Date> {
        for (newEvent in newEvents) {
            events.add(newEvent)
        }
        return events
    }

}