package com.ludaxord.projectsup.library.button.button

import android.content.Context
import android.util.AttributeSet
import android.widget.Button
import com.ludaxord.projectsup.library.utilities.Defaults.DEFAULT_PAIR_OF_THEME_COLOR_SCHEMA
import com.ludaxord.projectsup.library.button.button.interfaces.IButton
import com.ludaxord.projectsup.library.utilities.initTheme

abstract class AbstractSupButton : Button, IButton {

    protected constructor(context: Context, res: Pair<Int, Int>) : super(context) {
        this.initTheme(res.first)
    }

    protected constructor(context: Context, attrs: AttributeSet, res: Pair<Int, Int>) : super(context, attrs) {
        this.initTheme(res.first)
    }

    protected constructor(context: Context, attrs: AttributeSet, defStyle: Int, res: Pair<Int, Int>) : super(
        context,
        attrs,
        defStyle
    ) {
        this.initTheme(res.first)
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
}