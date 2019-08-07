package com.ludaxord.projectsup.library.utilities.colors

import android.content.Context
import android.support.v4.content.ContextCompat
import android.util.Log
import com.ludaxord.projectsup.R
import com.ludaxord.projectsup.library.utilities.combine
import com.ludaxord.projectsup.library.utilities.getResourceId

abstract class Color(
    private val context: Context,
    protected val colorKey: String = context.resources.getString(R.string.key_sup_default_color_schema)
) {

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

        this.combine(listOf(grayedOut, today, standard, warning))
    }

    private fun getGreyedOut(key: String): HashMap<String, Any> {
        val greyedOutKey = "${key}_${context.resources.getString(R.string.key_greyed_out)}"
        val greyedOut =
            context.getResourceId(greyedOutKey, context.getString(R.string.key_color), context.packageName).getColor()
        return hashMapOf(context.resources.getString(R.string.key_greyed_out) to greyedOut)
    }

    private fun getToday(key: String): HashMap<String, Any> {
        val todayKey = "${key}_${context.resources.getString(R.string.key_today)}"
        val today =
            context.getResourceId(todayKey, context.getString(R.string.key_color), context.packageName).getColor()
        return hashMapOf(context.resources.getString(R.string.key_today) to today)
    }

    private fun getStandard(key: String): HashMap<String, Any> {
        val standardKey = "${key}_${context.resources.getString(R.string.key_standard)}"
        val today =
            context.getResourceId(standardKey, context.getString(R.string.key_color), context.packageName).getColor()
        return hashMapOf(context.resources.getString(R.string.key_standard) to today)
    }

    private fun getWarning(key: String): HashMap<String, Any> {
        val warningKey = "${key}_${context.resources.getString(R.string.key_warning)}"
        val today =
            context.getResourceId(warningKey, context.getString(R.string.key_color), context.packageName).getColor()
        return hashMapOf(context.resources.getString(R.string.key_warning) to today)
    }

    private fun Int.getColor(): Int {
        return ContextCompat.getColor(context, this)
    }

    internal fun getColorKey(key: String): String {
        return "${context.resources.getString(R.string.prefix_color)}$key"
    }

}