package com.ludaxord.projectsup.library.utilities.themes

import android.content.Context
import android.view.View
import com.ludaxord.projectsup.library.utilities.Defaults.DEFAULT_THEME
import com.ludaxord.projectsup.library.utilities.Defaults.DEFAULT_THEME_KEY
import com.ludaxord.projectsup.library.utilities.getPreferences
import com.ludaxord.projectsup.library.utilities.getResourceId
import com.ludaxord.projectsup.library.utilities.getThemeKey
import com.ludaxord.projectsup.library.utilities.themes.interfaces.ITheme
import com.ludaxord.projectsup.library.utilities.themes.themeoptions.Arc
import com.ludaxord.projectsup.library.utilities.themes.themeoptions.Default

object ThemeUtils : ITheme {

    override fun getTheme(context: Context): Theme {
        val theme = getThemeFromResources(context)
        val resourceId = context.getResourceId(theme, "string", context.packageName)
        return getThemeFromResources(resourceId)
    }

    fun setThemeFromResources(view: View, res: Int) {
        val themeKey = res.getThemeKey()
        view.context.getPreferences().setPreference(DEFAULT_THEME_KEY, themeKey)
    }

    private fun getThemeFromResources(context: Context): String {
        var themeKey = context.getPreferences().getPreference(DEFAULT_THEME_KEY)
        if (themeKey == null) {
            themeKey = DEFAULT_THEME
        }
        return themeKey!!
    }

    private fun getThemeFromResources(res: Int): Theme {
        return when (res) {
            com.ludaxord.projectsup.R.string.key_sup_default_style -> {
                Default()
            }
            com.ludaxord.projectsup.R.string.key_sup_box_style -> {
                Default()
            }
            com.ludaxord.projectsup.R.string.key_sup_champion_style -> {
                Default()
            }
            com.ludaxord.projectsup.R.string.key_sup_denim_style -> {
                Default()
            }
            com.ludaxord.projectsup.R.string.key_sup_motion_style -> {
                Default()
            }
            com.ludaxord.projectsup.R.string.key_sup_photo_style -> {
                Default()
            }
            com.ludaxord.projectsup.R.string.key_sup_jump_man_style -> {
                Default()
            }
            com.ludaxord.projectsup.R.string.key_sup_s_style -> {
                Default()
            }
            com.ludaxord.projectsup.R.string.key_sup_script_style -> {
                Default()
            }
            com.ludaxord.projectsup.R.string.key_sup_arc_style -> {
                Arc()
            }
            else -> {
                Default()
            }
        }
    }
}