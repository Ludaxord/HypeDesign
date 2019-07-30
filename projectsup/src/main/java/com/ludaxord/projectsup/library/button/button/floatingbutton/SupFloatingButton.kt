package com.ludaxord.projectsup.library.button.button.floatingbutton

import android.content.Context
import android.util.AttributeSet

class SupFloatingButton : AbstractSupFloatingButton {

    constructor(context: Context, res: Pair<Int, Int>, corners: Float, bottomMargin: Float) : super(
        context,
        res,
        corners,
        bottomMargin
    )

    constructor(
        context: Context,
        attrs: AttributeSet,
        res: Pair<Int, Int>,
        corners: Float,
        bottomMargin: Float
    ) : super(context, attrs, res, corners, bottomMargin)

    constructor(
        context: Context,
        attrs: AttributeSet,
        defStyle: Int,
        res: Pair<Int, Int>,
        corners: Float,
        bottomMargin: Float
    ) : super(context, attrs, defStyle, res, corners, bottomMargin)

    constructor(context: Context, res: Pair<Int, Int>, cornerList: List<Float>, bottomMargin: Float) : super(
        context,
        res,
        cornerList,
        bottomMargin
    )

    constructor(
        context: Context,
        attrs: AttributeSet,
        res: Pair<Int, Int>,
        cornerList: List<Float>,
        bottomMargin: Float
    ) : super(context, attrs, res, cornerList, bottomMargin)

    constructor(
        context: Context,
        attrs: AttributeSet,
        defStyle: Int,
        res: Pair<Int, Int>,
        cornerList: List<Float>,
        bottomMargin: Float
    ) : super(context, attrs, defStyle, res, cornerList, bottomMargin)

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle)

}