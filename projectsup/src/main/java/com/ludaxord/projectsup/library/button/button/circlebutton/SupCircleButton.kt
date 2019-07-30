package com.ludaxord.projectsup.library.button.button.circlebutton

import android.content.Context
import android.util.AttributeSet
import com.ludaxord.projectsup.library.button.interfaces.IButton

class SupCircleButton : AbstractSupCircleButton, IButton {

    override fun setCorners(cornerList: List<Float>) {
        super.setCorners(cornerList)
        setCornersFromList(cornerList)
    }

    override fun setCorners(corners: Float) {
        super.setCorners(corners)
        setCorners(corners)
    }

    override fun setColorSchema(colorRes: Int) {
        setDefaultColorSchema(colorRes)
    }

    override fun setTheme(themeRes: Int) {
        setDefaultTheme(themeRes)
    }

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle)

}