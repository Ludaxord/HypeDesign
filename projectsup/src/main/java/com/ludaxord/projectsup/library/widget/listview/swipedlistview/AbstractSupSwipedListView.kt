package com.ludaxord.projectsup.library.widget.listview.swipedlistview

import android.content.Context
import android.util.AttributeSet
import com.ludaxord.projectsup.library.widget.listview.AbstractSupListView

abstract class AbstractSupSwipedListView : AbstractSupListView {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

}