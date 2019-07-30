package com.ludaxord.projectsup.library.widget.titlebar

import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout

abstract class AbstractSupTitleBar : RelativeLayout {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle)
}