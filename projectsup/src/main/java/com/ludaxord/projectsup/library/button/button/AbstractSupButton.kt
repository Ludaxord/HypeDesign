package com.ludaxord.projectsup.library.button.button

import android.content.Context
import android.util.AttributeSet
import android.widget.Button
import com.ludaxord.projectsup.R
import com.ludaxord.projectsup.library.button.interfaces.IButton
import com.ludaxord.projectsup.library.utilities.initColorsSchema
import com.ludaxord.projectsup.library.utilities.initTheme

abstract class AbstractSupButton : Button, IButton {

    internal var res: Pair<String, String> =
        Pair(
            context.getString(R.string.key_sup_default_style),
            context.getString(R.string.key_sup_default_color_schema)
        )

    protected constructor(context: Context, res: Pair<String, String>) : super(context) {
        this.res = res
        setInitializer()
    }

    protected constructor(context: Context, attrs: AttributeSet, res: Pair<String, String>) : super(context, attrs) {
        this.res = res
        setInitializer()
    }

    protected constructor(context: Context, attrs: AttributeSet, defStyle: Int, res: Pair<String, String>) : super(
        context,
        attrs,
        defStyle
    ) {
        this.res = res
        setInitializer()
    }

    protected constructor(context: Context) : this(
        context,
        Pair(
            context.getString(R.string.key_sup_default_style),
            context.getString(R.string.key_sup_default_color_schema)
        )
    )

    protected constructor(context: Context, attrs: AttributeSet) : this(
        context,
        attrs,
        Pair(
            context.getString(R.string.key_sup_default_style),
            context.getString(R.string.key_sup_default_color_schema)
        )
    )

    protected constructor(context: Context, attrs: AttributeSet, defStyle: Int) : this(
        context,
        attrs,
        defStyle,
        Pair(
            context.getString(R.string.key_sup_default_style),
            context.getString(R.string.key_sup_default_color_schema)
        )
    )

    internal open fun setDefaultViewUtils() {
//        setDefaultTheme(res.first)
//        setDefaultColorSchema(res.second)
    }

    private fun setInitializer() {
        setDefaultViewUtils()
    }

//    protected fun getDefaultColorSchema(): Color {
//        return context.getColorSchemaFromPreferences()
//    }
//
//    protected fun getDefaultTheme(): Theme {
//        return context.getThemeFromPreferences()
//    }

    protected fun setDefaultColorSchema(colorRes: Int) {
        this.initColorsSchema(colorRes)
    }

    protected fun setDefaultTheme(themeRes: Int) {
        this.initTheme(themeRes)
    }
}