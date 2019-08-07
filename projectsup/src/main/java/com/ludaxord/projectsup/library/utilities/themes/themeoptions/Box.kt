package com.ludaxord.projectsup.library.utilities.themes.themeoptions

import android.content.Context
import com.ludaxord.projectsup.library.utilities.themes.Theme

class Box : Theme {

    constructor(context: Context) : super(context) {
        this.themeKey = context.resources.getString(com.ludaxord.projectsup.R.string.key_sup_box_style)
    }

    constructor(context: Context, themeKey: String) : super(context) {
        this.themeKey = themeKey
    }

}