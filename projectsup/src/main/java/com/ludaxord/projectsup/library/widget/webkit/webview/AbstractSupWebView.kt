package com.ludaxord.projectsup.library.widget.webkit.webview

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.util.Log
import android.webkit.WebView
import com.ludaxord.projectsup.library.utilities.*
import com.ludaxord.projectsup.library.utilities.colors.Color
import com.ludaxord.projectsup.library.utilities.colors.ColorSchemaUtils
import com.ludaxord.projectsup.library.utilities.languages.Language
import com.ludaxord.projectsup.library.utilities.themes.Theme
import com.ludaxord.projectsup.library.utilities.themes.ThemeUtils
import com.ludaxord.projectsup.library.widget.interfaces.IWeb

abstract class AbstractSupWebView : WebView, IWeb {

    data class SupWebStyledAttributes(
        override var themeRes: String?,
        override var colorSchemaRes: String?,
        var languageName: String?
    ) : StyledAttributes(themeRes, colorSchemaRes)

    internal var res: Pair<String, String> = Pair(
        context.getString(com.ludaxord.projectsup.R.string.key_sup_default_style),
        context.getString(com.ludaxord.projectsup.R.string.key_sup_default_color_schema)
    )

    internal lateinit var styledAttributes: StyledAttributes

    internal lateinit var attrs: AttributeSet

    internal var languageName: String = context.resources.getString(com.ludaxord.projectsup.R.string.language_option_en)

    internal lateinit var theme: Theme

    internal lateinit var color: Color

    protected constructor(
        context: Context,
        res: Pair<String, String>,
        language: String
    ) : super(context) {
        Log.i(Defaults.TAG, "Chicago")
        this.res = res
        this.languageName = language
        setInitializer()
    }

    protected constructor(
        context: Context,
        attrs: AttributeSet,
        res: Pair<String, String>,
        language: String
    ) : super(
        context,
        attrs
    ) {
        Log.i(Defaults.TAG, "NRG")
        this.attrs = attrs
        this.res = res
        this.languageName = language
        setInitializer()
    }

    protected constructor(
        context: Context,
        attrs: AttributeSet,
        defStyleAttr: Int,
        res: Pair<String, String>,
        language: String
    ) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        Log.i(Defaults.TAG, "UNC")
        this.attrs = attrs
        this.res = res
        this.languageName = language
        setInitializer()
    }

    constructor(context: Context) : this(
        context,
        Pair(
            context.getString(com.ludaxord.projectsup.R.string.key_sup_default_style),
            context.getString(com.ludaxord.projectsup.R.string.key_sup_default_color_schema)
        ),
        context.resources.getString(com.ludaxord.projectsup.R.string.language_option_en)
    )

    constructor(context: Context, attrs: AttributeSet) : this(
        context,
        attrs,
        Pair(
            context.getString(com.ludaxord.projectsup.R.string.key_sup_default_style),
            context.getString(com.ludaxord.projectsup.R.string.key_sup_default_color_schema)
        ),
        context.resources.getString(com.ludaxord.projectsup.R.string.language_option_en)
    )

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : this(
        context,
        attrs,
        defStyleAttr,
        Pair(
            context.getString(com.ludaxord.projectsup.R.string.key_sup_default_style),
            context.getString(com.ludaxord.projectsup.R.string.key_sup_default_color_schema)
        ),
        context.resources.getString(com.ludaxord.projectsup.R.string.language_option_en)
    )

    internal open fun setDefaultViewUtils() {
        styledAttributes = setViewUtilsFromStyledAttributes(context, attrs)
        setTheme(res.first)
        setColorSchema(res.second)
    }

    private fun setInitializer() {
        setDefaultViewUtils()
    }


    override fun changeLanguage(actualLanguage: Language, newLanguage: String): Language {
        val language = setLanguage(newLanguage, context)
        return if (language.checkLanguage(actualLanguage)) {
            languageName = newLanguage
            language
        } else {
            actualLanguage
        }
    }

    override fun getColorSchema(): Color {
        return color
    }

    override fun setColorSchema(colorRes: Int) {
        val r = colorRes.getResourceFromInt(context) { r, c -> c.getString(r) }
        color = ColorSchemaUtils.getColorSchema(context, r)
    }

    override fun setTheme(themeRes: Int) {
        val r = themeRes.getResourceFromInt(context) { r, c -> c.getString(r) }
        theme = ThemeUtils.getTheme(context, r)
    }

    override fun setColorSchema(colorRes: String) {
        color = if (styledAttributes.themeRes != null && styledAttributes.colorSchemaRes == null) {
            getTheme().getThemeColorSchema(context)
        } else {
            ColorSchemaUtils.getColorSchema(context, colorRes)
        }
    }

    override fun setTheme(themeRes: String) {
        theme = ThemeUtils.getTheme(context, themeRes)
    }

    override fun getTheme(): Theme {
        return theme
    }
}