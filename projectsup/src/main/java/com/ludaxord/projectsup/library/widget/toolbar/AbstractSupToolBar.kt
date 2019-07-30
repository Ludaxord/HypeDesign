package com.ludaxord.projectsup.library.widget.toolbar

import android.content.Context
import android.support.v7.widget.Toolbar
import android.util.AttributeSet


abstract class AbstractSupToolBar : Toolbar {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

}