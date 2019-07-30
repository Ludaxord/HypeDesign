package com.ludaxord.projectsup.library.widget.gridview

import android.content.Context
import android.util.AttributeSet
import android.widget.GridView

abstract class AbstractSupGridView : GridView {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

}