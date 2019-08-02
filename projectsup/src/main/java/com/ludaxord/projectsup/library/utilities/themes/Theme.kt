package com.ludaxord.projectsup.library.utilities.themes

import android.content.Context
import android.content.res.Resources
import android.graphics.Typeface
import com.ludaxord.projectsup.R
import com.ludaxord.projectsup.library.utilities.Defaults.DEFAULT_STYLE_KEY
import com.ludaxord.projectsup.library.utilities.Defaults.DEFAULT_STYLE_PREFIX
import com.ludaxord.projectsup.library.utilities.Defaults.DEFAULT_THEME
import com.ludaxord.projectsup.library.utilities.Defaults.DEFAULT_TYPEFACE_KEY
import com.ludaxord.projectsup.library.utilities.combine
import com.ludaxord.projectsup.library.utilities.getResourceId

abstract class Theme(private val context: Context, protected val themeKey: String = DEFAULT_THEME) {

    fun theme(themeKey: String = this.themeKey): HashMap<String, Any> {
        val themeCredentials = HashMap<String, Any>()
        themeCredentials.getDefaultThemeCredentials(themeKey)
        return themeCredentials
    }

    private fun getStyleId(key: String): HashMap<String, Any> {
        val styleId = context.getResourceId(key, context.getString(R.string.key_style), context.packageName)

        return hashMapOf(DEFAULT_STYLE_KEY to styleId)
    }

    private fun HashMap<String, Any>.getDefaultThemeCredentials(key: String) {
        val style = getStyleId(getStyleKey(key))
        val typeface = getTypeface(getTypeFaceKey(key))
        this.combine(listOf(style, typeface))
    }

    private fun getTypeface(path: String): HashMap<String, Any> {
        val tf = Typeface.createFromAsset(context.assets, path)
        return hashMapOf(DEFAULT_TYPEFACE_KEY to tf)

    }

    internal fun getStyleKey(key: String): String {
        return "$DEFAULT_STYLE_PREFIX$key"
    }

    internal fun getTypeFaceKey(key: String): String {
        return "${DEFAULT_TYPEFACE_KEY}_$key.tff"
    }

    protected fun getDefaultColorSchemaForTheme(themeKey: String) {

    }

}