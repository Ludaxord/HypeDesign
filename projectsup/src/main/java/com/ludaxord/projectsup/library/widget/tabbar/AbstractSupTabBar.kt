package com.ludaxord.projectsup.library.widget.tabbar

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout

abstract class AbstractSupTabBar : FrameLayout {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

}