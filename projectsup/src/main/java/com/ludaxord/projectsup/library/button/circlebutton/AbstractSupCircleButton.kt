package com.ludaxord.projectsup.library.button.circlebutton

import android.content.Context
import android.util.AttributeSet
import com.ludaxord.projectsup.library.button.button.SupButton
import com.ludaxord.projectsup.library.utilities.setCorners

abstract class AbstractSupCircleButton : SupButton {

    protected constructor(context: Context, res: Int) : super(context, res)

    protected constructor(context: Context, attrs: AttributeSet, res: Int) : super(context, attrs, res)

    protected constructor(context: Context, res: Int, corners: Int) : this(context, res) {
        this.setCorners(corners)
    }

    protected constructor(context: Context, attrs: AttributeSet, res: Int, corners: Int) : this(context, attrs, res) {
        this.setCorners(corners)
    }

    protected constructor(context: Context, res: Int, cornerList: List<Int>) : this(context, res) {
        this.setCorners(cornerList)
    }

    protected constructor(context: Context, attrs: AttributeSet, res: Int, cornerList: List<Int>) : this(
        context,
        attrs,
        res
    ) {
        this.setCorners(cornerList)
    }

}