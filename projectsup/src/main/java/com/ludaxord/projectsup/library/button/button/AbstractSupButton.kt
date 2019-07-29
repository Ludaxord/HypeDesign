package com.ludaxord.projectsup.library.button.button

import android.content.Context
import android.util.AttributeSet
import android.widget.Button
import com.ludaxord.projectsup.library.utilities.initTheme

abstract class AbstractSupButton : Button {

    private constructor(context: Context) : super(context)

    private constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    protected constructor(context: Context, res: Int) : this(context) {
        this.initTheme(res)
    }

    protected constructor(context: Context, attrs: AttributeSet, res: Int) : this(context, attrs) {
        this.initTheme(res)
    }
}