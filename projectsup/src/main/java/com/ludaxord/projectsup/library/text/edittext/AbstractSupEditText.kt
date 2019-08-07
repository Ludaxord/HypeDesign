package com.ludaxord.projectsup.library.text.edittext

import android.content.Context
import android.util.AttributeSet
import android.widget.EditText
import com.ludaxord.projectsup.library.utilities.Defaults
import com.ludaxord.projectsup.library.utilities.initTheme

abstract class AbstractSupEditText : EditText {

    protected constructor(context: Context, res: Pair<String, String>) : super(context) {
//        this.initTheme(res.first)
    }

    protected constructor(context: Context, attrs: AttributeSet, res: Pair<String, String>) : super(context, attrs) {
//        this.initTheme(res.first)
    }

    protected constructor(context: Context, attrs: AttributeSet, defStyle: Int, res: Pair<String, String>) : super(
        context,
        attrs,
        defStyle
    ) {
//        this.initTheme(res.first)
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
}