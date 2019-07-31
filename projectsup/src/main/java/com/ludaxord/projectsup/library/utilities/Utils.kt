package com.ludaxord.projectsup.library.utilities

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.ludaxord.projectsup.R
import com.ludaxord.projectsup.library.utilities.DateUtils.setEventsToExistedEvents
import com.ludaxord.projectsup.library.utilities.ThemeUtils.setColorSchemaResources
import com.ludaxord.projectsup.library.utilities.ThemeUtils.setThemeFromResources
import com.ludaxord.projectsup.library.utilities.ViewUtils.getChildren
import com.ludaxord.projectsup.library.utilities.ViewUtils.setViewCorners
import com.ludaxord.projectsup.library.utilities.ViewUtils.setViewCustomCorners
import com.ludaxord.projectsup.library.utilities.ViewUtils.setViewToBottom
import com.ludaxord.projectsup.library.utilities.ViewUtils.setViewsIds
import com.ludaxord.projectsup.library.utilities.ViewUtils.setViewsToRootView
import com.ludaxord.projectsup.library.utilities.languages.Language
import java.util.*
import kotlin.collections.ArrayList

fun View.initTheme(res: Int) {
    setThemeFromResources(this, res)
}

fun View.initColorsSchema(res: Int) {
    setColorSchemaResources(this, res)
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
        throw UtilsException(this.context.getString(R.string.utils_exception_incorrect_size_message))
    }
}

fun View.stickViewToBottom(withMargin: Int) {
    setViewToBottom(this, withMargin)
}

fun ArrayList<View>.setIds(rootView: View) {
    setViewsIds(rootView, this)
}

fun ViewGroup.setViewsToRoot(views: ArrayList<View>) {
    setViewsToRootView(this, views)
}

fun ArrayList<Date>.setEvents(newEvents: ArrayList<Date>) {
    setEventsToExistedEvents(this, newEvents)
}

fun Language.setWeeksToViews(rootView: View) {
    val children = getChildren(rootView)
    for ((index, child) in children.withIndex()) {
        for ((key, day) in this.getShortDayNames()) {
            if (child is TextView) {
                child.text = day
            }
        }
    }
}