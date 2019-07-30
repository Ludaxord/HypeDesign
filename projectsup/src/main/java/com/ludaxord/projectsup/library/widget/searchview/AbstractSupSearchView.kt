package com.ludaxord.projectsup.library.widget.searchview

import android.content.Context
import android.util.AttributeSet
import android.widget.SearchView

abstract class AbstractSupSearchView: SearchView {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

}