package com.ludaxord.projectsup.library.utilities

import android.content.res.Resources
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.ludaxord.projectsup.R
import com.ludaxord.projectsup.library.utilities.DateUtils.setEventsToExistedEvents
import com.ludaxord.projectsup.library.utilities.Defaults.DEFAULT_TEXT_PREFIX
import com.ludaxord.projectsup.library.utilities.ThemeUtils.setColorSchemaResources
import com.ludaxord.projectsup.library.utilities.ThemeUtils.setThemeFromResources
import com.ludaxord.projectsup.library.utilities.ViewUtils.getChildren
import com.ludaxord.projectsup.library.utilities.ViewUtils.getViewIdName
import com.ludaxord.projectsup.library.utilities.ViewUtils.setViewCorners
import com.ludaxord.projectsup.library.utilities.ViewUtils.setViewCustomCorners
import com.ludaxord.projectsup.library.utilities.ViewUtils.setViewToBottom
import com.ludaxord.projectsup.library.utilities.ViewUtils.setViewsIds
import com.ludaxord.projectsup.library.utilities.ViewUtils.setViewsToRootView
import com.ludaxord.projectsup.library.utilities.ViewUtils.setWeekDayWithDefaultPrefix
import com.ludaxord.projectsup.library.utilities.ViewUtils.setWeekDaysManually
import com.ludaxord.projectsup.library.utilities.languages.Language
import java.util.*

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
        throw UtilsException(Resources.getSystem().getString(R.string.utils_exception_change_to_same_language))
    }
}

fun TextView.setWeekDayNames(language: Language, rootView: ViewGroup, short: Boolean = true) {
    val name = this.getIdName()
    val dayNames = if (short) language.getShortDayNames() else language.getFullDayNames()

    if (name.contains(DEFAULT_TEXT_PREFIX)) {
        setWeekDayWithDefaultPrefix(this, name, dayNames, rootView, short)
    } else {
        setWeekDaysManually(this, name, rootView, dayNames, short)
    }
}

fun View.getIdName(): String {
    return getViewIdName(this)
}