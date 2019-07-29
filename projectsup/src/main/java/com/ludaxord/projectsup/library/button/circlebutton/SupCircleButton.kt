package com.ludaxord.projectsup.library.button.circlebutton

import android.content.Context
import android.util.AttributeSet

open class SupCircleButton : AbstractSupCircleButton {

    private constructor(context: Context, res: Int) : super(context, res)

    private constructor(context: Context, attrs: AttributeSet, res: Int) : super(context, attrs, res)

    constructor(context: Context, res: Int, corners: Int) : super(context, res, corners) {

    }

    constructor(context: Context, attrs: AttributeSet, res: Int, corners: Int) : super(context, attrs, res, corners) {

    }
}