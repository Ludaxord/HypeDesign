package com.ludaxord.projectsup.library.utilities.colors

import android.content.Context
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.ludaxord.projectsup.R
import com.ludaxord.projectsup.library.utilities.*
import com.ludaxord.projectsup.library.utilities.colors.colorschema.Camo
import com.ludaxord.projectsup.library.utilities.colors.colorschema.Default
import com.ludaxord.projectsup.library.utilities.colors.interfaces.IColor
import com.ludaxord.projectsup.library.utilities.themes.ThemeUtils
import com.ludaxord.projectsup.library.utilities.themes.ThemeUtils.overrideFonts

object ColorSchemaUtils : IColor {

    override fun getColorSchema(context: Context): Color {
        val colorSchema = getColorSchemaResources(context)
        val resourceId = context.getResourceId(colorSchema, context.getString(R.string.key_string), context.packageName)
        return getColorSchemaFromPreferences(resourceId, colorSchema, context)
    }

    fun setColorSchemaResources(view: View, res: Int) {
        val colorKey = res.getColorSchemaKey(view.context)
        val previousColorKey = getColorSchemaResources(view.context)
        if (colorKey != previousColorKey ||
            (
                    previousColorKey != view.context.resources.getString(R.string.key_sup_default_color_schema) &&
                            colorKey != view.context.resources.getString(R.string.key_sup_default_color_schema)
                    )
        ) {
            view.context.getPreferences()
                .setPreference(view.context.resources.getString(R.string.key_project_sup_color_schema), colorKey)
        }
    }

    fun overrideFontColors(context: Context, v: View) {
        try {
            if (v is ViewGroup) {
                for (i in 0 until v.childCount) {
                    val child = v.getChildAt(i)
                    overrideFontColors(context, child)
                }
            } else if (v is TextView) {
                v.setTextColorSchema(getColorSchema(context).color()[context.resources.getString(R.string.key_standard)])
            }
        } catch (e: Exception) {
            Log.e("ProjectSup", "exception ${e.message}")
        }
    }

    private fun getColorSchemaResources(context: Context): String {
        var colorSchemaKey =
            context.getPreferences().getPreference(context.resources.getString(R.string.key_project_sup_color_schema))
        if (colorSchemaKey == null) {
            colorSchemaKey = context.resources.getString(R.string.key_sup_default_color_schema)
        }
        return colorSchemaKey!!
    }

    private fun getColorSchemaFromPreferences(res: Int, colorKey: String, context: Context): Color {
        Log.i("ProjectSup", "colorKey from Preferences -> $colorKey")
        return when (res) {
            com.ludaxord.projectsup.R.string.key_sup_camo_color_schema -> {
                Camo(context, colorKey)
            }
            com.ludaxord.projectsup.R.string.key_sup_default_color_schema -> {
                Default(context, colorKey)
            }
            else -> {
                if (colorKey.contains(context.getString(R.string.key_theme))) {
                    Default(context, colorKey)
                } else {
                    Default(context, colorKey)
                }
            }
        }
    }
}