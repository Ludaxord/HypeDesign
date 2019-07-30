package com.ludaxord.projectsup.library.text.multiautocompletetextview

import android.content.Context
import android.util.AttributeSet
import android.widget.MultiAutoCompleteTextView
import com.ludaxord.projectsup.library.utilities.Defaults
import com.ludaxord.projectsup.library.utilities.initTheme

abstract class AbstractSupMultiAutoCompleteTextView: MultiAutoCompleteTextView {

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

    protected constructor(context: Context) : this(context, Defaults.DEFAULT_PAIR_OF_THEME_COLOR_SCHEMA)

    protected constructor(context: Context, attrs: AttributeSet) : this(
        context,
        attrs,
        Defaults.DEFAULT_PAIR_OF_THEME_COLOR_SCHEMA
    )

    protected constructor(context: Context, attrs: AttributeSet, defStyle: Int) : this(
        context,
        attrs,
        defStyle,
        Defaults.DEFAULT_PAIR_OF_THEME_COLOR_SCHEMA
    )
}
