package com.ludaxord.projectsup.library.utilities.themes

import android.content.Context
import android.graphics.Typeface
import android.util.Log
import com.ludaxord.projectsup.library.utilities.combine
import com.ludaxord.projectsup.library.utilities.getResourceId
import java.lang.Exception


abstract class Theme(
    private val context: Context,
    protected val themeKey: String = context.resources.getString(com.ludaxord.projectsup.R.string.key_sup_default_style)
) {

    fun theme(themeKey: String = this.themeKey): HashMap<String, Any> {
        val themeCredentials = HashMap<String, Any>()
        themeCredentials.getDefaultThemeCredentials(themeKey)
        return themeCredentials
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
        val style = getStyleId(getStyleKey(key))
        val typeface = try {
            getTypeface(getTypeFaceKey(key))
        } catch (e: Exception) {
            getTypeface(getTypeFaceKey(key, "otf"))
        }
        this.combine(listOf(style, typeface))
    }

    private fun getTypeface(path: String): HashMap<String, Any> {
        val tf = Typeface.createFromAsset(context.resources.assets, path)
        return hashMapOf(context.resources.getString(com.ludaxord.projectsup.R.string.key_typeface) to tf)

    }

    internal fun getStyleKey(key: String): String {
        return "${context.resources.getString(com.ludaxord.projectsup.R.string.prefix_style)}$key"
    }

    internal fun getTypeFaceKey(key: String, extension: String = "ttf"): String {
        return "${context.resources.getString(com.ludaxord.projectsup.R.string.key_typeface)}_$key.$extension"
    }

    protected fun getDefaultColorSchemaForTheme(themeKey: String) {

    }

}