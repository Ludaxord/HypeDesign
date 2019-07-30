package com.ludaxord.projectsup.library.widget.view

import android.content.Context
import android.util.AttributeSet
import android.view.View

abstract class AbstractSupView : View {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

}