package com.ludaxord.projectsup.library.button.button

import android.content.Context
import android.util.AttributeSet

class SupButton : AbstractSupButton {

    constructor(context: Context, res: Pair<Int, Int>) : super(context, res)

    constructor(context: Context, attrs: AttributeSet, res: Pair<Int, Int>) : super(context, attrs, res)

    constructor(context: Context, attrs: AttributeSet, defStyle: Int, res: Pair<Int, Int>) : super(
        context,
        attrs,
        defStyle,
        res
    )

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle)

}

