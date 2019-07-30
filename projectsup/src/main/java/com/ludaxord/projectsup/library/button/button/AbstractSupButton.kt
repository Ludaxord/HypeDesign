package com.ludaxord.projectsup.library.button.button

import android.content.Context
import android.util.AttributeSet
import android.widget.Button
import com.ludaxord.projectsup.library.utilities.Defaults.DEFAULT_PAIR_OF_THEME_COLOR_SCHEMA
import com.ludaxord.projectsup.library.utilities.initColorsSchema
import com.ludaxord.projectsup.library.utilities.initTheme

abstract class AbstractSupButton : Button {

    internal var res: Pair<Int, Int> = Pair(0, 0)

    protected constructor(context: Context, res: Pair<Int, Int>) : super(context) {
        this.res = res
        setInitializer()
    }

    protected constructor(context: Context, attrs: AttributeSet, res: Pair<Int, Int>) : super(context, attrs) {
        this.res = res
        setInitializer()
    }

    protected constructor(context: Context, attrs: AttributeSet, defStyle: Int, res: Pair<Int, Int>) : super(
        context,
        attrs,
        defStyle
    ) {
        this.res = res
        setInitializer()
    }

    protected constructor(context: Context) : this(context, DEFAULT_PAIR_OF_THEME_COLOR_SCHEMA)

    protected constructor(context: Context, attrs: AttributeSet) : this(
        context,
        attrs,
        DEFAULT_PAIR_OF_THEME_COLOR_SCHEMA
    )

    protected constructor(context: Context, attrs: AttributeSet, defStyle: Int) : this(
        context,
        attrs,
        defStyle,
        DEFAULT_PAIR_OF_THEME_COLOR_SCHEMA
    )

    private fun setInitializer() {
        setDefaultViewUtils()
    }

    internal open fun setDefaultViewUtils() {
        setDefaultTheme(res.first)
        setDefaultColorSchema(res.second)
    }

    protected fun setDefaultColorSchema(colorRes: Int) {
        this.initColorsSchema(colorRes)
    }

    protected fun setDefaultTheme(themeRes: Int) {
        this.initTheme(themeRes)
    }
}