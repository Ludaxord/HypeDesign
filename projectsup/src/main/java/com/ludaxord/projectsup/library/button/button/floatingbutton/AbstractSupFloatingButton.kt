package com.ludaxord.projectsup.library.button.button.floatingbutton

import android.content.Context
import android.util.AttributeSet
import com.ludaxord.projectsup.library.button.button.circlebutton.AbstractSupCircleButton
import com.ludaxord.projectsup.library.utilities.Defaults.DEFAULT_BOTTOM_MARGIN_FLOAT
import com.ludaxord.projectsup.library.utilities.Defaults.DEFAULT_CORNER_ROUND_FLOAT
import com.ludaxord.projectsup.library.utilities.Defaults.DEFAULT_PAIR_OF_THEME_COLOR_SCHEMA
import com.ludaxord.projectsup.library.utilities.stickViewToBottom

abstract class AbstractSupFloatingButton : AbstractSupCircleButton {

    protected constructor(context: Context, res: Pair<Int, Int>, corners: Float, bottomMargin: Float) : super(
        context,
        res,
        corners
    ) {
        this.stickViewToBottom(bottomMargin)
    }

    protected constructor(
        context: Context,
        attrs: AttributeSet,
        res: Pair<Int, Int>,
        corners: Float,
        bottomMargin: Float
    ) : super(
        context,
        attrs,
        res,
        corners
    ) {
        this.stickViewToBottom(bottomMargin)
    }

    protected constructor(
        context: Context,
        attrs: AttributeSet,
        defStyle: Int,
        res: Pair<Int, Int>,
        corners: Float,
        bottomMargin: Float
    ) : super(
        context,
        attrs,
        defStyle,
        res,
        corners
    ) {
        this.stickViewToBottom(bottomMargin)
    }

    protected constructor(context: Context, res: Pair<Int, Int>, cornerList: List<Float>, bottomMargin: Float) : super(
        context,
        res,
        cornerList
    ) {
        this.stickViewToBottom(bottomMargin)
    }

    protected constructor(
        context: Context,
        attrs: AttributeSet,
        res: Pair<Int, Int>,
        cornerList: List<Float>,
        bottomMargin: Float
    ) : super(
        context,
        attrs,
        res,
        cornerList
    ) {
        this.stickViewToBottom(bottomMargin)
    }

    protected constructor(
        context: Context,
        attrs: AttributeSet,
        defStyle: Int,
        res: Pair<Int, Int>,
        cornerList: List<Float>,
        bottomMargin: Float
    ) : super(
        context,
        attrs,
        defStyle,
        res,
        cornerList
    ) {
        this.stickViewToBottom(bottomMargin)
    }


    protected constructor(context: Context) : this(
        context,
        DEFAULT_PAIR_OF_THEME_COLOR_SCHEMA,
        DEFAULT_CORNER_ROUND_FLOAT,
        DEFAULT_BOTTOM_MARGIN_FLOAT
    )

    protected constructor(context: Context, attrs: AttributeSet) : this(
        context,
        attrs,
        DEFAULT_PAIR_OF_THEME_COLOR_SCHEMA,
        DEFAULT_CORNER_ROUND_FLOAT,
        DEFAULT_BOTTOM_MARGIN_FLOAT
    )

    protected constructor(context: Context, attrs: AttributeSet, defStyle: Int) : this(
        context,
        attrs,
        defStyle,
        DEFAULT_PAIR_OF_THEME_COLOR_SCHEMA,
        DEFAULT_CORNER_ROUND_FLOAT,
        DEFAULT_BOTTOM_MARGIN_FLOAT
    )

}