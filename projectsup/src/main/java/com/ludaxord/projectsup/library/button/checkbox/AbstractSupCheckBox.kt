package com.ludaxord.projectsup.library.button.checkbox

import android.content.Context
import android.util.AttributeSet
import android.widget.CheckBox
import com.ludaxord.projectsup.library.utilities.initTheme

abstract class AbstractSupCheckBox : CheckBox {

    private constructor(context: Context) : super(context)

    private constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    protected constructor(context: Context, res: Int) : this(context) {
        this.initTheme(res)
    }

    protected constructor(context: Context, attrs: AttributeSet, res: Int) : this(context, attrs) {
        this.initTheme(res)
    }
}