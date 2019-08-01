package com.ludaxord.projectsup.library.button.button.circlebutton

import android.content.Context
import android.util.AttributeSet
import android.view.View
import com.ludaxord.projectsup.library.utilities.colors.Color
import com.ludaxord.projectsup.library.utilities.themes.Theme

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

    override fun getColorSchema(): Color {
        return getDefaultColorSchema()
    }

    override fun getTheme(): Theme {
        return getDefaultTheme()
    }

    override fun setCorners(cornerList: List<Float>, view: View?) {
        setCornersFromList(cornerList)
    }

    override fun setCorners(corners: Float, view: View?) {
        setCornersFromFloat(corners)
    }

}