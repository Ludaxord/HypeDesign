package com.ludaxord.projectsup.library.utilities.colors

import android.content.Context
import android.view.View
import com.ludaxord.projectsup.R
import com.ludaxord.projectsup.library.utilities.*
import com.ludaxord.projectsup.library.utilities.colors.colorschema.Camo
import com.ludaxord.projectsup.library.utilities.colors.colorschema.Default
import com.ludaxord.projectsup.library.utilities.colors.interfaces.IColor

object ColorSchemaUtils : IColor {

    override fun getColorSchema(context: Context): Color {
        val colorSchema = getColorSchemaResources(context)
        val resourceId = context.getResourceId(colorSchema, context.getString(R.string.key_string), context.packageName)
        return getColorSchemaResources(resourceId, context)
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

    private fun getColorSchemaResources(res: Int, context: Context): Color {
        val colorKey = res.getResourceFromInt(context) { resource, ctx ->
            ctx.getString(resource)
        }
        return when (res) {
            com.ludaxord.projectsup.R.string.key_sup_camo_color_schema -> {
                Camo(context, colorKey)
            }
            com.ludaxord.projectsup.R.string.key_sup_default_color_schema -> {
                Default(context, colorKey)
            }
            else -> {
                Default(context, colorKey)
            }
        }
    }
}