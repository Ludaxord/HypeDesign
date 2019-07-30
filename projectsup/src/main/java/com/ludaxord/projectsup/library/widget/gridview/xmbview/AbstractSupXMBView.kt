package com.ludaxord.projectsup.library.widget.gridview.xmbview

import android.content.Context
import android.util.AttributeSet
import com.ludaxord.projectsup.library.widget.gridview.AbstractSupGridView

abstract class AbstractSupXMBView : AbstractSupGridView {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)
}