package com.ludaxord.projectsup.library.utilities.colors

import android.content.Context
import android.view.View
import com.ludaxord.projectsup.library.utilities.Defaults
import com.ludaxord.projectsup.library.utilities.colors.interfaces.IColor
import com.ludaxord.projectsup.library.utilities.getColorSchemaKey
import com.ludaxord.projectsup.library.utilities.getPreferences

object ColorSchemaUtils : IColor {

    override fun getColorSchema(context: Context): Color {
        val colorSchema = getColorSchemaResources(context)
    }

    fun setColorSchemaResources(view: View, res: Int) {
        val colorKey = res.getColorSchemaKey()
        view.context.getPreferences().setPreference(Defaults.DEFAULT_COLOR_SCHEMA_KEY, colorKey)
    }

    private fun getColorSchemaResources(context: Context): String {
        var colorSchemaKey = context.getPreferences().getPreference(Defaults.DEFAULT_COLOR_SCHEMA_KEY)
        if (colorSchemaKey == null) {
            colorSchemaKey = Defaults.DEFAULT_COLOR_SCHEMA
        }
        return colorSchemaKey!!
    }
}