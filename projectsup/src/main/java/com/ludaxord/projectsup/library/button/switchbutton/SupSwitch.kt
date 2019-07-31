package com.ludaxord.projectsup.library.button.switchbutton

import android.content.Context
import android.util.AttributeSet

class SupSwitch : AbstractSupSwitch {

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle)

    override fun setColorSchema(colorRes: Int) {
        setDefaultColorSchema(colorRes)
    }

    override fun setTheme(themeRes: Int) {
        setDefaultTheme(themeRes)
    }

}