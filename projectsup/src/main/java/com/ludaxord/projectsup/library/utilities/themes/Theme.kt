package com.ludaxord.projectsup.library.utilities.themes

import android.content.Context
import android.graphics.Typeface
import com.ludaxord.projectsup.library.utilities.combine
import com.ludaxord.projectsup.library.utilities.getResourceId
import java.lang.Exception
import android.support.v4.content.ContextCompat
import android.util.Log
import com.ludaxord.projectsup.R
import com.ludaxord.projectsup.library.utilities.Defaults
import com.ludaxord.projectsup.library.utilities.Defaults.TAG
import com.ludaxord.projectsup.library.utilities.colors.colorschema.Default
import com.ludaxord.projectsup.library.utilities.colors.colorschema.themecolorschema.ThemeBox


abstract class Theme(private val context: Context) {

    protected var themeKey: String = context.resources.getString(com.ludaxord.projectsup.R.string.key_sup_default_style)

    fun theme(): HashMap<String, Any> {
        val themeCredentials = HashMap<String, Any>()
        themeCredentials.getDefaultThemeCredentials(themeKey)
        return themeCredentials
    }

    private fun getThemeName(key: String): HashMap<String, Any> {
        val themeName = removeStyleFromThemeKey(key)
        return hashMapOf(context.resources.getString(com.ludaxord.projectsup.R.string.key_theme_name) to themeName)
    }

    private fun getStyleId(key: String): HashMap<String, Any> {
        val styleId = context.getResourceId(
            key,
            context.getString(com.ludaxord.projectsup.R.string.key_style),
            context.packageName
        )

        return hashMapOf(context.resources.getString(com.ludaxord.projectsup.R.string.key_style) to styleId)
    }

    private fun HashMap<String, Any>.getDefaultThemeCredentials(key: String) {

        val themeName = getThemeName(key)

        val style = getStyleId(getStyleKey(key))

        val drawableLeftButton =
            getDrawable(
                getDrawableKey("${key}_${context.getString(com.ludaxord.projectsup.R.string.key_left_button)}"),
                com.ludaxord.projectsup.R.string.key_drawable_left_button
            )

        val drawableRightButton =
            getDrawable(
                getDrawableKey("${key}_${context.getString(com.ludaxord.projectsup.R.string.key_right_button)}"),
                com.ludaxord.projectsup.R.string.key_drawable_right_button
            )

        val drawableBackground1 =
            getDrawable(
                getDrawableKey("${key}_${context.getString(com.ludaxord.projectsup.R.string.key_background_1)}"),
                com.ludaxord.projectsup.R.string.key_drawable_background_1
            )

        val typeface = try {
            getTypeface(getTypeFaceKey(key))
        } catch (e: Exception) {
            getTypeface(getTypeFaceKey(key, "otf"))
        }

        val color = getColorSchemaKeyFromTheme(key)

        val colorSchema =
            getColorSchema(color[context.resources.getString(com.ludaxord.projectsup.R.string.key_color)] as String)

        this.combine(
            listOf(
                themeName,
                style,
                typeface,
                drawableLeftButton,
                drawableRightButton,
                drawableBackground1,
                color,
                colorSchema
            )
        )
    }

    private fun getTypeface(path: String): HashMap<String, Any> {
        val tf = Typeface.createFromAsset(context.resources.assets, path)
        return hashMapOf(context.resources.getString(com.ludaxord.projectsup.R.string.key_typeface) to tf)
    }

    private fun getDrawable(resource: String, key: Int): HashMap<String, Any> {
        val res = context.getResourceId(
            resource,
            context.getString(com.ludaxord.projectsup.R.string.key_drawable),
            context.packageName
        )
        val drawable = ContextCompat.getDrawable(context, res)!!
        return hashMapOf(context.resources.getString(key) to drawable)
    }

    private fun getColorSchemaKeyFromTheme(resource: String): HashMap<String, Any> {
        val key = removeStyleFromThemeKey(resource)
        val r =
            "${key}_${context.resources.getString(com.ludaxord.projectsup.R.string.key_theme)}${context.resources.getString(
                com.ludaxord.projectsup.R.string.prefix_color_schema
            )}"
        return hashMapOf(context.resources.getString(com.ludaxord.projectsup.R.string.key_color) to r)
    }

    private fun getColorSchema(key: String): HashMap<String, Any> {
        val color = when (key) {
            removeStyleFromThemeKey(context.getString(R.string.key_sup_box_style)) -> {
                ThemeBox(context, key)
            }
            else -> {
                Default(context, key)
            }
        }
        return hashMapOf(context.resources.getString(com.ludaxord.projectsup.R.string.key_project_sup_color_schema) to color)
    }

    private fun removeStyleFromThemeKey(resource: String): String {
        val replacement = context.getString(com.ludaxord.projectsup.R.string.key_style)
        return if (resource.contains(replacement)) {
            resource.replace("_$replacement", "")
        } else {
            resource
        }
    }

    internal fun getStyleKey(key: String): String {
        return "${context.resources.getString(com.ludaxord.projectsup.R.string.prefix_style)}$key"
    }

    internal fun getDrawableKey(key: String): String {
        return "${context.resources.getString(com.ludaxord.projectsup.R.string.key_drawable)}_$key"
    }

    internal fun getTypeFaceKey(key: String, extension: String = "ttf"): String {
        return "${context.resources.getString(com.ludaxord.projectsup.R.string.key_typeface)}_$key.$extension"
    }

}