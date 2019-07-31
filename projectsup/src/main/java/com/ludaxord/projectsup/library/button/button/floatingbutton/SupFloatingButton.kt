package com.ludaxord.projectsup.library.button.button.floatingbutton

import android.content.Context
import android.util.AttributeSet
import android.view.View

class SupFloatingButton : AbstractSupFloatingButton {

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

    override fun setStickToBottom(withMargin: Float, view: View?) {
        setStickToBottomOfView(withMargin)
    }

}
