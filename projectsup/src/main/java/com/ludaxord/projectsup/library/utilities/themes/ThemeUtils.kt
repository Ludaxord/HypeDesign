package com.ludaxord.projectsup.library.utilities.themes

import android.content.Context
import android.graphics.Color
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.ludaxord.projectsup.R
import com.ludaxord.projectsup.library.utilities.Defaults.TAG
import com.ludaxord.projectsup.library.utilities.colors.colorschema.themecolorschema.ThemeBox
import com.ludaxord.projectsup.library.utilities.setTypeFaceTheme
import com.ludaxord.projectsup.library.utilities.themes.interfaces.ITheme
import com.ludaxord.projectsup.library.utilities.themes.themeoptions.*

object ThemeUtils : ITheme {

    override fun getTheme(context: Context, theme: String): Theme {
        return getThemeFromResources(theme, context)
    }

    fun overrideFonts(context: Context, v: View, theme: Theme) {
        try {
            if (v is ViewGroup) {
                for (i in 0 until v.childCount) {
                    val child = v.getChildAt(i)
                    overrideFonts(context, child, theme)
                }
            } else if (v is TextView) {
                v.setTypeFaceTheme(theme.theme()[context.resources.getString(R.string.key_typeface)])
            }
        } catch (e: Exception) {
            Log.e(TAG, "exception theme ${e.message}")
        }
    }


    fun getColorFromTheme(context: Context, theme: Theme): com.ludaxord.projectsup.library.utilities.colors.Color {
        return when (theme.themeKey) {
            context.getString(com.ludaxord.projectsup.R.string.key_sup_default_style) -> {
                com.ludaxord.projectsup.library.utilities.colors.colorschema.Default(context)
            }
            context.getString(com.ludaxord.projectsup.R.string.key_sup_box_style) -> {
                ThemeBox(context)
            }
            context.getString(com.ludaxord.projectsup.R.string.key_sup_champion_style) -> {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
            context.getString(com.ludaxord.projectsup.R.string.key_sup_denim_style) -> {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
            context.getString(com.ludaxord.projectsup.R.string.key_sup_motion_style) -> {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
            context.getString(com.ludaxord.projectsup.R.string.key_sup_olde_english_style) -> {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
            context.getString(com.ludaxord.projectsup.R.string.key_sup_photo_style) -> {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

            }
            context.getString(com.ludaxord.projectsup.R.string.key_sup_jump_man_style) -> {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

            }
            context.getString(com.ludaxord.projectsup.R.string.key_sup_s_style) -> {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

            }
            context.getString(com.ludaxord.projectsup.R.string.key_sup_script_style) -> {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

            }
            context.getString(com.ludaxord.projectsup.R.string.key_sup_arc_style) -> {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

            }
            context.getString(com.ludaxord.projectsup.R.string.key_sup_mini_box_style) -> {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
            context.getString(com.ludaxord.projectsup.R.string.key_sup_swoosh_style) -> {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
            context.getString(com.ludaxord.projectsup.R.string.key_sup_tag_style) -> {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
            else -> {
                com.ludaxord.projectsup.library.utilities.colors.colorschema.Default(context)
            }
        }
    }

    private fun getThemeFromResources(themeKey: String, context: Context): Theme {
        return when (themeKey) {
            context.getString(com.ludaxord.projectsup.R.string.key_sup_default_style) -> {
                Default(context, themeKey)
            }
            context.getString(com.ludaxord.projectsup.R.string.key_sup_box_style) -> {
                Box(context, themeKey)
            }
            context.getString(com.ludaxord.projectsup.R.string.key_sup_champion_style) -> {
                Champion(context, themeKey)
            }
            context.getString(com.ludaxord.projectsup.R.string.key_sup_denim_style) -> {
                Denim(context, themeKey)
            }
            context.getString(com.ludaxord.projectsup.R.string.key_sup_motion_style) -> {
                Motion(context, themeKey)
            }
            context.getString(com.ludaxord.projectsup.R.string.key_sup_olde_english_style) -> {
                OldeEnglish(context, themeKey)
            }
            context.getString(com.ludaxord.projectsup.R.string.key_sup_photo_style) -> {
                Photo(context, themeKey)
            }
            context.getString(com.ludaxord.projectsup.R.string.key_sup_jump_man_style) -> {
                JumpMan(context, themeKey)
            }
            context.getString(com.ludaxord.projectsup.R.string.key_sup_s_style) -> {
                S(context, themeKey)
            }
            context.getString(com.ludaxord.projectsup.R.string.key_sup_script_style) -> {
                Script(context, themeKey)
            }
            context.getString(com.ludaxord.projectsup.R.string.key_sup_arc_style) -> {
                Arc(context, themeKey)
            }
            context.getString(com.ludaxord.projectsup.R.string.key_sup_mini_box_style) -> {
                MiniBox(context, themeKey)
            }
            context.getString(com.ludaxord.projectsup.R.string.key_sup_swoosh_style) -> {
                Swoosh(context, themeKey)
            }
            context.getString(com.ludaxord.projectsup.R.string.key_sup_tag_style) -> {
                Tag(context, themeKey)
            }
            else -> {
                Default(context, themeKey)
            }
        }
    }
}