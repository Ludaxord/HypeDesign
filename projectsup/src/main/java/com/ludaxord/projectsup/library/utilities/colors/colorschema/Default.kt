package com.ludaxord.projectsup.library.utilities.colors.colorschema

import android.content.Context
import com.ludaxord.projectsup.R
import com.ludaxord.projectsup.library.utilities.colors.Color

class Default : Color {

    constructor(context: Context) : super(context) {
        this.colorKey = context.resources.getString(R.string.key_sup_default_color_schema)
    }

    constructor(context: Context, colorKey: String) : super(context) {
        this.colorKey = colorKey
    }
}