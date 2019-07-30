package com.ludaxord.projectsup.library.button.button

import android.content.Context
import android.util.AttributeSet
import com.ludaxord.projectsup.library.button.interfaces.IButton

class SupButton : AbstractSupButton, IButton {

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

