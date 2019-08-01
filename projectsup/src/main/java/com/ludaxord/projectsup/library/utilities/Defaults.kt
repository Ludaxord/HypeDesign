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
    internal val DEFAULT_TEXT_PREFIX = Resources.getSystem().getString(R.string.prefix_text)
    internal val DEFAULT_LANGUAGE_SHORT_PREFIX = Resources.getSystem().getString(R.string.prefix_language_short)
    internal val DEFAULT_LANGUAGE_FULL_PREFIX = Resources.getSystem().getString(R.string.prefix_language_full)

    internal val DEFAULT_SIMPLE_DATE_FORMAT_1 = Resources.getSystem().getString(R.string.date_format_1)
    internal val DEFAULT_SIMPLE_DATE_FORMAT_2 = Resources.getSystem().getString(R.string.date_format_2)
    internal val DEFAULT_SIMPLE_DATE_FORMAT_3 = Resources.getSystem().getString(R.string.date_format_3)
    internal val DEFAULT_SIMPLE_DATE_FORMAT_4 = Resources.getSystem().getString(R.string.date_format_4)
    internal val DEFAULT_SIMPLE_DATE_FORMAT_5 = Resources.getSystem().getString(R.string.date_format_5)

    internal val DEFAULT_COLOR_SCHEMA_KEY = Resources.getSystem().getString(R.string.key_project_sup_color_schema)
    internal val DEFAULT_THEME_KEY = Resources.getSystem().getString(R.string.key_project_sup_theme)

    internal val DEFAULT_COLOR_SCHEMA = Resources.getSystem().getString(R.string.key_sup_default_color_schema)
    internal val DEFAULT_THEME = Resources.getSystem().getString(R.string.key_sup_default_style)

    internal val DEFAULT_CALENDAR_DAYS = Resources.getSystem().getInteger(R.integer.calendar_days)
}