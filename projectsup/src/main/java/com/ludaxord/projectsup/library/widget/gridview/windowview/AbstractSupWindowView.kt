package com.ludaxord.projectsup.library.widget.gridview.windowview

import android.content.Context
import android.util.AttributeSet
import com.ludaxord.projectsup.library.widget.gridview.AbstractSupGridView

abstract class AbstractSupWindowView: AbstractSupGridView {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

}