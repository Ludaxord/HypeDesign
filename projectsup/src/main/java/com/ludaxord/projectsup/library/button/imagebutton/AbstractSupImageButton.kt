package com.ludaxord.projectsup.library.button.imagebutton

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageButton
import com.ludaxord.projectsup.library.button.interfaces.IButton
import com.ludaxord.projectsup.library.utilities.initColorsSchema
import com.ludaxord.projectsup.library.utilities.initTheme

abstract class AbstractSupImageButton : ImageButton, IButton {

    internal var res: Pair<String, String> =         Pair(
            context.getString(com.ludaxord.projectsup.R.string.key_sup_default_style),
            context.getString(com.ludaxord.projectsup.R.string.key_sup_default_color_schema)
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
            context.getString(com.ludaxord.projectsup.R.string.key_sup_default_style),
            context.getString(com.ludaxord.projectsup.R.string.key_sup_default_color_schema)
        )
    )

    protected constructor(context: Context, attrs: AttributeSet) : this(
        context,
        attrs,
        Pair(
            context.getString(com.ludaxord.projectsup.R.string.key_sup_default_style),
            context.getString(com.ludaxord.projectsup.R.string.key_sup_default_color_schema)
        )
    )

    protected constructor(context: Context, attrs: AttributeSet, defStyle: Int) : this(
        context,
        attrs,
        defStyle,
        Pair(
            context.getString(com.ludaxord.projectsup.R.string.key_sup_default_style),
            context.getString(com.ludaxord.projectsup.R.string.key_sup_default_color_schema)
        )
    )


    private fun setInitializer() {
        setDefaultViewUtils()
    }

    internal open fun setDefaultViewUtils() {
//        setDefaultTheme(res.first)
//        setDefaultColorSchema(res.second)
    }

    protected fun setDefaultColorSchema(colorRes: Int) {
        this.initColorsSchema(colorRes)
    }

    protected fun setDefaultTheme(themeRes: Int) {
        this.initTheme(themeRes)
    }

//    protected fun getDefaultColorSchema(): Color {
//        return context.getColorSchemaFromPreferences()
//    }
//
//    protected fun getDefaultTheme(): Theme {
//        return context.getThemeFromPreferences()
//    }
}