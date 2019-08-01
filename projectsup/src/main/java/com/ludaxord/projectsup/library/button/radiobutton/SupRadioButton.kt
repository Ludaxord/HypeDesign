package com.ludaxord.projectsup.library.button.radiobutton

import android.content.Context
import android.util.AttributeSet
import com.ludaxord.projectsup.library.utilities.colors.Color
import com.ludaxord.projectsup.library.utilities.themes.Theme

class SupRadioButton : AbstractSupRadioButton {

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

}