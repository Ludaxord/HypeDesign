package com.ludaxord.projectsup.library.utilities.themes

import android.content.Context
import android.graphics.Typeface
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.ludaxord.projectsup.R
import com.ludaxord.projectsup.library.utilities.getPreferences
import com.ludaxord.projectsup.library.utilities.getResourceId
import com.ludaxord.projectsup.library.utilities.getThemeKey
import com.ludaxord.projectsup.library.utilities.setTypeFaceTheme
import com.ludaxord.projectsup.library.utilities.themes.interfaces.ITheme
import com.ludaxord.projectsup.library.utilities.themes.themeoptions.*

object ThemeUtils : ITheme {

    override fun getTheme(context: Context): Theme {
        val theme = getThemeFromPreferences(context)
        val resourceId = context.getResourceId(theme, context.getString(R.string.key_string), context.packageName)
        return getThemeFromResources(resourceId, theme, context)
    }

    fun overrideFonts(context: Context, v: View) {
        try {
            if (v is ViewGroup) {
                for (i in 0 until v.childCount) {
                    val child = v.getChildAt(i)
                    overrideFonts(context, child)
                }
            } else if (v is TextView) {
                v.setTypeFaceTheme(getTheme(context).theme()[context.resources.getString(R.string.key_typeface)])
            }
        } catch (e: Exception) {
            Log.e("ProjectSup", "exception ${e.message}")
        }
    }

    fun setThemeFromResources(view: View, res: Int) {
        val themeKey = res.getThemeKey(view.context)
        val previousThemeKey = getThemeFromPreferences(view.context)
        if (themeKey != previousThemeKey ||
            (
                    previousThemeKey != view.context.resources.getString(R.string.key_sup_default_style) &&
                            themeKey != view.context.resources.getString(R.string.key_sup_default_style)
                    )
        ) {
            view.context.getPreferences()
                .setPreference(view.resources.getString(R.string.key_project_sup_theme), themeKey)
        }
    }

    private fun getThemeFromPreferences(context: Context): String {
        var themeKey =
            context.getPreferences().getPreference(context.resources.getString(R.string.key_project_sup_theme))
        if (themeKey == null) {
            themeKey = context.resources.getString(R.string.key_sup_default_style)
        }
        return themeKey!!
    }

    private fun getThemeFromResources(res: Int, themeKey: String, context: Context): Theme {
        return when (res) {
            com.ludaxord.projectsup.R.string.key_sup_default_style -> {
                Default(context, themeKey)
            }
            com.ludaxord.projectsup.R.string.key_sup_box_style -> {
                Box(context, themeKey)
            }
            com.ludaxord.projectsup.R.string.key_sup_champion_style -> {
                Champion(context, themeKey)
            }
            com.ludaxord.projectsup.R.string.key_sup_denim_style -> {
                Denim(context, themeKey)
            }
            com.ludaxord.projectsup.R.string.key_sup_motion_style -> {
                Motion(context, themeKey)
            }
            com.ludaxord.projectsup.R.string.key_sup_olde_english_style -> {
                OldeEnglish(context, themeKey)
            }
            com.ludaxord.projectsup.R.string.key_sup_photo_style -> {
                Photo(context, themeKey)
            }
            com.ludaxord.projectsup.R.string.key_sup_jump_man_style -> {
                JumpMan(context, themeKey)
            }
            com.ludaxord.projectsup.R.string.key_sup_s_style -> {
                S(context, themeKey)
            }
            com.ludaxord.projectsup.R.string.key_sup_script_style -> {
                Script(context, themeKey)
            }
            com.ludaxord.projectsup.R.string.key_sup_arc_style -> {
                Arc(context, themeKey)
            }
            com.ludaxord.projectsup.R.string.key_sup_mini_box_style -> {
                MiniBox(context, themeKey)
            }
            com.ludaxord.projectsup.R.string.key_sup_swoosh_style -> {
                Swoosh(context, themeKey)
            }
            com.ludaxord.projectsup.R.string.key_sup_tag_style -> {
                Tag(context, themeKey)
            }
            else -> {
                Default(context, themeKey)
            }
        }
    }
}