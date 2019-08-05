package com.ludaxord.projectsup.library.utilities.themes

import android.content.Context
import android.view.View
import com.ludaxord.projectsup.R
import com.ludaxord.projectsup.library.utilities.getPreferences
import com.ludaxord.projectsup.library.utilities.getResourceFromInt
import com.ludaxord.projectsup.library.utilities.getResourceId
import com.ludaxord.projectsup.library.utilities.getThemeKey
import com.ludaxord.projectsup.library.utilities.themes.interfaces.ITheme
import com.ludaxord.projectsup.library.utilities.themes.themeoptions.*

object ThemeUtils : ITheme {

    override fun getTheme(context: Context): Theme {
        val theme = getThemeFromResources(context)
        val resourceId = context.getResourceId(theme, context.getString(R.string.key_string), context.packageName)
        return getThemeFromResources(resourceId, context)
    }

    fun setThemeFromResources(view: View, res: Int) {
        val themeKey = res.getThemeKey(view.context)
        view.context.getPreferences().setPreference(view.resources.getString(R.string.key_project_sup_theme), themeKey)
    }

    private fun getThemeFromResources(context: Context): String {
        var themeKey = context.getPreferences().getPreference(context.resources.getString(R.string.key_project_sup_theme))
        if (themeKey == null) {
            themeKey = context.resources.getString(R.string.key_sup_default_style)
        }
        return themeKey!!
    }

    private fun getThemeFromResources(res: Int, context: Context): Theme {
        val themeKey = res.getResourceFromInt(context) { resource, ctx ->
            ctx.getString(resource)
        }
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