package com.ludaxord.projectsup.library.widget.tabswitchbar

import android.content.Context
import android.util.AttributeSet
import android.widget.HorizontalScrollView

abstract class AbstractSupTabSwitchBar : HorizontalScrollView {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

}