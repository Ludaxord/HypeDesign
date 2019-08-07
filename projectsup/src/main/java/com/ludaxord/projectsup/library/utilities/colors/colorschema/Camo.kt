package com.ludaxord.projectsup.library.utilities.colors.colorschema

import android.content.Context
import com.ludaxord.projectsup.R
import com.ludaxord.projectsup.library.utilities.colors.Color

class Camo : Color {

    constructor(context: Context) : super(context) {
        this.colorKey = context.resources.getString(R.string.key_sup_camo_color_schema)
    }

    constructor(context: Context, colorKey: String) : super(context) {
        this.colorKey = colorKey
    }

}