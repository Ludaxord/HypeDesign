package com.ludaxord.projectsup.library.button.button.floatingbutton

import android.content.Context
import android.util.AttributeSet
import com.ludaxord.projectsup.library.button.button.circlebutton.AbstractSupCircleButton
import com.ludaxord.projectsup.library.utilities.Defaults.DEFAULT_BOTTOM_MARGIN_FLOAT
import com.ludaxord.projectsup.library.utilities.Defaults.DEFAULT_CORNER_ROUND_FLOAT
import com.ludaxord.projectsup.library.utilities.Defaults.DEFAULT_PAIR_OF_THEME_COLOR_SCHEMA
import com.ludaxord.projectsup.library.utilities.stickViewToBottom

abstract class AbstractSupFloatingButton : AbstractSupCircleButton {

    internal var withMargin: Float = 0.0f

    protected constructor(context: Context, res: Pair<Int, Int>, corners: Float, bottomMargin: Float) : super(
        context,
        res,
        corners
    ) {
        this.res = res
        this.corners = corners
        this.withMargin = bottomMargin
        setInitializer()
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
        this.res = res
        this.corners = corners
        this.withMargin = bottomMargin
        setInitializer()
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
        this.res = res
        this.corners = corners
        this.withMargin = bottomMargin
        setInitializer()
    }

    protected constructor(context: Context, res: Pair<Int, Int>, cornerList: List<Float>, bottomMargin: Float) : super(
        context,
        res,
        cornerList
    ) {
        this.res = res
        this.cornerList = cornerList
        this.withMargin = bottomMargin
        setInitializer()
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
        this.res = res
        this.cornerList = cornerList
        this.withMargin = bottomMargin
        setInitializer()
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
        this.res = res
        this.cornerList = cornerList
        this.withMargin = bottomMargin
        setInitializer()
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

    override fun setDefaultViewUtils() {
        super.setDefaultViewUtils()
        setDefaultStickToBottom()
    }

    private fun setInitializer() {
        setDefaultViewUtils()
    }

    private fun setDefaultStickToBottom() {
        setStickToBottomOfView(withMargin)
    }

    protected fun setStickToBottomOfView(withMargin: Float) {
        this.stickViewToBottom(withMargin)
    }

}