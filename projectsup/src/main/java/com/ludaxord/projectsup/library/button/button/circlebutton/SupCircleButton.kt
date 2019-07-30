package com.ludaxord.projectsup.library.button.button.circlebutton

import android.content.Context
import android.util.AttributeSet

class SupCircleButton : AbstractSupCircleButton {

    constructor(context: Context, res: Pair<Int, Int>, corners: Float) : super(context, res, corners)

    constructor(context: Context, attrs: AttributeSet, res: Pair<Int, Int>, corners: Float) : super(
        context,
        attrs,
        res,
        corners
    )

    constructor(context: Context, attrs: AttributeSet, defStyle: Int, res: Pair<Int, Int>, corners: Float) : super(
        context,
        attrs,
        defStyle,
        res,
        corners
    )

    constructor(context: Context, res: Pair<Int, Int>, cornerList: List<Float>) : super(context, res, cornerList)

    constructor(context: Context, attrs: AttributeSet, res: Pair<Int, Int>, cornerList: List<Float>) : super(
        context,
        attrs,
        res,
        cornerList
    )

    constructor(
        context: Context,
        attrs: AttributeSet,
        defStyle: Int,
        res: Pair<Int, Int>,
        cornerList: List<Float>
    ) : super(context, attrs, defStyle, res, cornerList)

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle)

}