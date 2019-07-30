package com.ludaxord.projectsup.library.button.button.circlebutton

import android.content.Context
import android.util.AttributeSet
import com.ludaxord.projectsup.library.button.button.AbstractSupButton
import com.ludaxord.projectsup.library.utilities.Defaults.DEFAULT_CORNER_ROUND_FLOAT
import com.ludaxord.projectsup.library.utilities.Defaults.DEFAULT_PAIR_OF_THEME_COLOR_SCHEMA
import com.ludaxord.projectsup.library.utilities.setCorners

abstract class AbstractSupCircleButton : AbstractSupButton {

    protected constructor(context: Context, res: Pair<Int, Int>, corners: Float) : super(context, res) {
        this.setCorners(corners)
    }

    protected constructor(context: Context, attrs: AttributeSet, res: Pair<Int, Int>, corners: Float) : super(
        context,
        attrs,
        res
    ) {
        this.setCorners(corners)
    }

    protected constructor(
        context: Context,
        attrs: AttributeSet,
        defStyle: Int,
        res: Pair<Int, Int>,
        corners: Float
    ) : super(
        context,
        attrs,
        defStyle,
        res
    ) {
        this.setCorners(corners)
    }

    protected constructor(context: Context, res: Pair<Int, Int>, cornerList: List<Float>) : super(context, res) {
        this.setCorners(cornerList)
    }

    protected constructor(context: Context, attrs: AttributeSet, res: Pair<Int, Int>, cornerList: List<Float>) : super(
        context,
        attrs,
        res
    ) {
        this.setCorners(cornerList)
    }

    protected constructor(
        context: Context,
        attrs: AttributeSet,
        defStyle: Int,
        res: Pair<Int, Int>,
        cornerList: List<Float>
    ) : super(
        context,
        attrs,
        defStyle,
        res
    ) {
        this.setCorners(cornerList)
    }

    protected constructor(context: Context) : this(
        context,
        DEFAULT_PAIR_OF_THEME_COLOR_SCHEMA,
        DEFAULT_CORNER_ROUND_FLOAT
    )

    protected constructor(context: Context, attrs: AttributeSet) : this(
        context,
        attrs,
        DEFAULT_PAIR_OF_THEME_COLOR_SCHEMA,
        DEFAULT_CORNER_ROUND_FLOAT
    )

    protected constructor(context: Context, attrs: AttributeSet, defStyle: Int) : this(
        context,
        attrs,
        defStyle,
        DEFAULT_PAIR_OF_THEME_COLOR_SCHEMA,
        DEFAULT_CORNER_ROUND_FLOAT
    )

}