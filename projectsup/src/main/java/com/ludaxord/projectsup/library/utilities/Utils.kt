package com.ludaxord.projectsup.library.utilities

import android.content.Context
import android.graphics.Typeface
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.ludaxord.projectsup.R
import com.ludaxord.projectsup.library.utilities.DateUtils.setEventsToExistedEvents
import com.ludaxord.projectsup.library.utilities.Defaults.TAG
import com.ludaxord.projectsup.library.utilities.colors.Color
import com.ludaxord.projectsup.library.utilities.colors.ColorSchemaUtils
import com.ludaxord.projectsup.library.utilities.languages.Language
import com.ludaxord.projectsup.library.utilities.themes.Theme
import com.ludaxord.projectsup.library.utilities.themes.ThemeUtils
import com.ludaxord.projectsup.library.utilities.views.ViewUtils.getChildren
import com.ludaxord.projectsup.library.utilities.views.ViewUtils.getViewIdName
import com.ludaxord.projectsup.library.utilities.views.ViewUtils.setViewCorners
import com.ludaxord.projectsup.library.utilities.views.ViewUtils.setViewCustomCorners
import com.ludaxord.projectsup.library.utilities.views.ViewUtils.setViewToBottom
import com.ludaxord.projectsup.library.utilities.views.ViewUtils.setViewsIds
import com.ludaxord.projectsup.library.utilities.views.ViewUtils.setViewsToRootView
import com.ludaxord.projectsup.library.utilities.views.ViewUtils.setWeekDayWithDefaultPrefix
import com.ludaxord.projectsup.library.utilities.views.ViewUtils.setWeekDaysManually
import com.ludaxord.projectsup.library.widget.calendarview.AbstractSupCalendarView
import com.ludaxord.projectsup.library.widget.calendarview.elements.adapter.SupCalendarAdapter
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

//Data classes

abstract class StyledAttributes(
    open var themeRes: String?,
    open var colorSchemaRes: String?
)

data class SupStyledAttributes(
    override var themeRes: String?,
    override var colorSchemaRes: String?
) : StyledAttributes(themeRes, colorSchemaRes)

//View extensions

fun View.initTheme(res: Int) {

}

fun View.initColorsSchema(res: Int) {

}

fun View.setCorners(corners: Float) {
    setViewCorners(this, corners)
}

fun View.setCorners(corners: List<Float>) {
    if (corners.size == 4) {
        for (corner in corners) {
            setViewCustomCorners(this, corners)
        }
    } else {
        throw UtilsException(this.context.getString(com.ludaxord.projectsup.R.string.utils_exception_incorrect_size_message))
    }
}

fun View.stickViewToBottom(withMargin: Int) {
    setViewToBottom(this, withMargin)
}

fun View.getIdName(withLibraryName: Boolean = false): String {
    return getViewIdName(this, withLibraryName)
}

fun View.setMonthForCalendarView(calendarView: AbstractSupCalendarView, newEvents: ArrayList<Date>?, amount: Int) {
    if (this is ImageView || this is Button) {
        this.setOnClickListener {
            calendarView.calendar.add(Calendar.MONTH, amount)
            calendarView.setCalendar(newEvents)
        }
    } else {
        throw UtilsException(context.resources.getString(com.ludaxord.projectsup.R.string.utils_exception_calendar_view_button))
    }
}

fun View.getThemeColorsCredentials(colorName: String, themeName: String) {
    Log.d(TAG, "credentials for ${this.javaClass} colorSet => $colorName || theme => $themeName")
}

//ViewGroup extensions

fun ViewGroup.setViewsToRoot(views: ArrayList<View>) {
    setViewsToRootView(this, views)
}

//TextView extensions

fun TextView.setWeekDayNames(language: Language, rootView: ViewGroup, short: Boolean = true) {
    val name = this.getIdName()
    val dayNames = if (short) language.getShortDayNames() else language.getFullDayNames()
    if (name.contains(rootView.context.getString(R.string.prefix_text))) {
        setWeekDayWithDefaultPrefix(this, name, dayNames, short)
    } else {
        setWeekDaysManually(this, name, rootView, dayNames, short)
    }
}

fun TextView.setTextColorSchema(color: Any?) {
    if (color is Int) {
        this.setTextColor(color)
    }
}

fun TextView.setTypeFaceTheme(typeFace: Any?, type: Int? = null) {
    if (typeFace is Typeface) {
        if (type == null) {
            this.typeface = typeFace
        } else {
            this.setTypeface(typeface, type)
        }
    }
}

fun View.overrideFontTypeFace(res: Theme) {
    ThemeUtils.overrideFonts(this.context, this, res)
}

fun View.overrideFontColor(res: Color) {
    ColorSchemaUtils.overrideFontColors(this.context, this, res)
}

//AbstractSupCalendarView extensions

fun AbstractSupCalendarView.setCalendar(events: ArrayList<Date>?) {
    this.updateEventsCalendar(events)
    this.updateCalendarCells()
}

fun AbstractSupCalendarView.updateEventsCalendar(newEvents: ArrayList<Date>?) {
    if (newEvents != null) {
        if (newEvents.isNotEmpty()) {
            for (newEvent in newEvents) {
                if (!this.events.contains(newEvent)) {
                    this.events.add(newEvent)
                }
            }
        }
    }
}

fun AbstractSupCalendarView.updateCalendarCells() {

    val cells = ArrayList<Date>()
    val calendar = this.calendar.clone() as Calendar

    calendar.set(Calendar.DAY_OF_MONTH, 1)
    val monthBeginCell = calendar.get(Calendar.DAY_OF_WEEK) - 1
    calendar.add(Calendar.DAY_OF_MONTH, -monthBeginCell)

    while (cells.count() < context.resources.getInteger(R.integer.calendar_days)) {
        cells.add(calendar.time)
        calendar.add(Calendar.DAY_OF_MONTH, 1)
    }

    this.calendarAdapter = SupCalendarAdapter(
        context,
        cells,
        this.events,
        this.schedule,
        this.calendar.time,
        this.theme,
        this.color
    )
    this.calendarGridView.adapter = calendarAdapter

    val simpleDateFormat = SimpleDateFormat(dateFormat, Locale.getDefault())
    this.dateTextView.text = simpleDateFormat.format(this.calendar.time)

}

//ArrayListOfView extensions

fun ArrayList<View>.setIds(rootView: View) {
    setViewsIds(rootView, this)
}

//Context extensions

fun Context.getResourceId(pVariableName: String, pResourceName: String, pPackageName: String): Int {
    return try {
        this.resources.getIdentifier(pVariableName, pResourceName, pPackageName)
    } catch (e: Exception) {
        e.printStackTrace()
        -1
    }

}

//Int extensions

inline fun Int.getResourceFromInt(context: Context, res: (Int, Context) -> String): String {
    return res(this, context)
}

//Language extensions

fun Language.setWeeksToViews(rootView: ViewGroup) {
    val children = getChildren(rootView)
    for (child in children) {
        if (child is TextView) {
            child.setWeekDayNames(this, rootView)
        }
    }
}

fun Language.checkLanguage(oldLanguage: Language): Boolean {
    if (this.languageName != oldLanguage.languageName) {
        return true
    } else {
        throw UtilsException(this.context.resources.getString(com.ludaxord.projectsup.R.string.utils_exception_change_to_same_language))
    }
}

//Date extensions

fun Date.toCalendar(): Calendar {
    val cal = Calendar.getInstance()
    cal.time = this
    return cal
}

//ArrayListOfDate extensions

fun ArrayList<Date>.setEvents(newEvents: ArrayList<Date>) {
    setEventsToExistedEvents(this, newEvents)
}

//HashMap extensions

fun HashMap<String, Any>.combine(hashMaps: List<HashMap<String, Any>>) {
    for (hashMap in hashMaps) {
        this.putAll(hashMap)
    }
}