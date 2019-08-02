package com.ludaxord.projectsup.library.utilities.colors

import android.content.Context
import android.support.v4.content.ContextCompat
import com.ludaxord.projectsup.R
import com.ludaxord.projectsup.library.utilities.Defaults
import com.ludaxord.projectsup.library.utilities.Defaults.DEFAULT_COLOR_SCHEMA
import com.ludaxord.projectsup.library.utilities.Defaults.GREYED_OUT_KEY
import com.ludaxord.projectsup.library.utilities.Defaults.STANDARD_KEY
import com.ludaxord.projectsup.library.utilities.Defaults.TODAY_KEY
import com.ludaxord.projectsup.library.utilities.Defaults.WARNING_KEY
import com.ludaxord.projectsup.library.utilities.combine
import com.ludaxord.projectsup.library.utilities.getResourceId

abstract class Color(private val context: Context, protected val colorKey: String = DEFAULT_COLOR_SCHEMA) {

    fun color(colorKey: String = this.colorKey): HashMap<String, Any> {
        val colorCredentials = HashMap<String, Any>()
        colorCredentials.getColorSet(colorKey)
        return colorCredentials
    }

    private fun HashMap<String, Any>.getColorSet(key: String) {
        val grayedOut = getGreyedOut(getColorKey(key))
        val today = getToday(getColorKey(key))
        val standard = getStandard(getColorKey(key))
        val warning = getWarning(getColorKey(key))

        this.combine(listOf(grayedOut,today,standard, warning))
    }

    private fun getGreyedOut(key: String): HashMap<String, Any> {
        val greyedOutKey = "${key}_$GREYED_OUT_KEY"
        val greyedOut =
            context.getResourceId(greyedOutKey, context.getString(R.string.key_color), context.packageName).getColor()
        return hashMapOf(GREYED_OUT_KEY to greyedOut)
    }

    private fun getToday(key: String): HashMap<String, Any> {
        val todayKey = "${key}_$TODAY_KEY"
        val today =
            context.getResourceId(todayKey, context.getString(R.string.key_color), context.packageName).getColor()
        return hashMapOf(TODAY_KEY to today)
    }

    private fun getStandard(key: String): HashMap<String, Any> {
        val todayKey = "${key}_$STANDARD_KEY"
        val today =
            context.getResourceId(todayKey, context.getString(R.string.key_color), context.packageName).getColor()
        return hashMapOf(STANDARD_KEY to today)
    }

    private fun getWarning(key: String): HashMap<String, Any> {
        val todayKey = "${key}_$WARNING_KEY"
        val today =
            context.getResourceId(todayKey, context.getString(R.string.key_color), context.packageName).getColor()
        return hashMapOf(WARNING_KEY to today)
    }

    private fun Int.getColor(): Int {
        return ContextCompat.getColor(context, this)
    }

    internal fun getColorKey(key: String): String {
        return "${Defaults.DEFAULT_COLOR_PREFIX}$key"
    }

}