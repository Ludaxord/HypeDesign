package com.ludaxord.projectsup.library.utilities

import android.content.res.Resources
import com.ludaxord.projectsup.R
import java.util.*
import kotlin.collections.ArrayList

object Defaults {
    internal val DEFAULT_PAIR_OF_THEME_COLOR_SCHEMA =
        Pair(R.integer.sup_default_style, R.integer.sup_default_color_schema)
    internal const val DEFAULT_CORNER_ROUND_FLOAT = 20f
    internal val DEFAULT_CORNER_ROUND_FLOAT_LIST = listOf(20f, 20f, 20f, 20f)
    internal const val DEFAULT_BOTTOM_MARGIN_FLOAT = 20
    internal val DEFAULT_CALENDAR_EVENTS_ARRAY_LIST = ArrayList<Date>()
    internal val DEFAULT_LANGUAGE = Resources.getSystem().getString(R.string.language_option_en)
}