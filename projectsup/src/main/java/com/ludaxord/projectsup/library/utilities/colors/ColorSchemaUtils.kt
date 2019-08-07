package com.ludaxord.projectsup.library.utilities.colors

import android.content.Context
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.ludaxord.projectsup.R
import com.ludaxord.projectsup.library.utilities.*
import com.ludaxord.projectsup.library.utilities.Defaults.TAG
import com.ludaxord.projectsup.library.utilities.colors.colorschema.Camo
import com.ludaxord.projectsup.library.utilities.colors.colorschema.Default
import com.ludaxord.projectsup.library.utilities.colors.interfaces.IColor
import com.ludaxord.projectsup.library.utilities.themes.ThemeUtils
import com.ludaxord.projectsup.library.utilities.themes.ThemeUtils.overrideFonts

object ColorSchemaUtils : IColor {

    override fun getColorSchema(context: Context, colorSchema: String): Color {
        val resourceId = context.getResourceId(colorSchema, context.getString(R.string.key_string), context.packageName)
        return getColorSchemaFromPreferences(resourceId, colorSchema, context)
    }

    fun overrideFontColors(context: Context, v: View, res: Color) {
        try {
            if (v is ViewGroup) {
                for (i in 0 until v.childCount) {
                    val child = v.getChildAt(i)
                    overrideFontColors(context, child, res)
                }
            } else if (v is TextView) {
                v.setTextColorSchema(res.color()[context.resources.getString(R.string.key_standard)])
            }
        } catch (e: Exception) {
            Log.e(TAG, "exception color ${e.message}")
        }
    }

    private fun getColorSchemaFromPreferences(res: Int, colorKey: String, context: Context): Color {
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