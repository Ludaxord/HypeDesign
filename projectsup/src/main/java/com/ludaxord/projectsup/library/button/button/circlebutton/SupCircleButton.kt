package com.ludaxord.projectsup.library.button.button.circlebutton

import android.content.Context
import android.util.AttributeSet
import android.view.View
import com.ludaxord.projectsup.library.button.interfaces.IButton

class SupCircleButton : AbstractSupCircleButton {

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle)

    override fun setColorSchema(colorRes: Int) {
        setDefaultColorSchema(colorRes)
    }

    override fun setTheme(themeRes: Int) {
        setDefaultTheme(themeRes)
    }

    override fun setCorners(cornerList: List<Float>, view: View?) {
        setCornersFromList(cornerList)
    }

    override fun setCorners(corners: Float, view: View?) {
        setCornersFromFloat(corners)
    }

}