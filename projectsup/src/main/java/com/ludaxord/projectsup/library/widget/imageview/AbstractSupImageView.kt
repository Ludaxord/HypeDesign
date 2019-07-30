package com.ludaxord.projectsup.library.widget.imageview

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView

abstract class AbstractSupImageView : ImageView {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

}