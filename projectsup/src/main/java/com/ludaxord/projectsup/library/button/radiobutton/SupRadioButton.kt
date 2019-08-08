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
    }

    override fun setTheme(themeRes: Int) {
    }

    override fun setColorSchema(colorRes: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setTheme(themeRes: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getColorSchema(): Color {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getTheme(): Theme {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}