package com.ludaxord.projectsup.library.widget.listview

import android.content.Context
import android.util.AttributeSet
import android.widget.ListView

abstract class AbstractSupListView : ListView {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

}