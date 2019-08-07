package com.ludaxord.projectsup.library.utilities.colors.colorschema.themecolorschema

import android.content.Context
import com.ludaxord.projectsup.library.utilities.colors.Color

class ThemeBox : Color {

    constructor(context: Context) : super(context) {
        this.colorKey = context.resources.getString(com.ludaxord.projectsup.R.string.key_sup_box_color_schema)
    }

    constructor(context: Context, colorKey: String) : super(context) {
        this.colorKey = colorKey
    }

}