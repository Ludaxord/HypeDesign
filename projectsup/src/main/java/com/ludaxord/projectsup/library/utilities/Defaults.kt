package com.ludaxord.projectsup.library.utilities

import android.content.res.Resources
import com.ludaxord.projectsup.R
import java.util.*
import kotlin.collections.ArrayList

object Defaults {
    internal val resources = Resources.getSystem()
    
    internal val DEFAULT_PAIR_OF_THEME_COLOR_SCHEMA =
        Pair(R.integer.sup_default_style, R.integer.sup_default_color_schema)
    internal const val DEFAULT_CORNER_ROUND_FLOAT = 20f
    internal val DEFAULT_CORNER_ROUND_FLOAT_LIST = listOf(20f, 20f, 20f, 20f)
    internal const val DEFAULT_BOTTOM_MARGIN_FLOAT = 20
    internal val DEFAULT_CALENDAR_EVENTS_ARRAY_LIST = ArrayList<Date>()
    internal val DEFAULT_LANGUAGE = resources.getString(R.string.language_option_en)
    internal val DEFAULT_TEXT_PREFIX = resources.getString(R.string.prefix_text)
    internal val DEFAULT_LANGUAGE_SHORT_PREFIX = resources.getString(R.string.prefix_language_short)
    internal val DEFAULT_LANGUAGE_FULL_PREFIX = resources.getString(R.string.prefix_language_full)
    internal val DEFAULT_STYLE_PREFIX = resources.getString(R.string.prefix_style)
    internal val DEFAULT_COLOR_PREFIX = resources.getString(R.string.prefix_color)

    internal val GREYED_OUT_KEY = resources.getString(R.string.key_greyed_out)
    internal val TODAY_KEY = resources.getString(R.string.key_today)
    internal val STANDARD_KEY = resources.getString(R.string.key_standard)
    internal val WARNING_KEY = resources.getString(R.string.key_warning)

    internal val DEFAULT_SIMPLE_DATE_FORMAT_1 = resources.getString(R.string.date_format_1)
    internal val DEFAULT_SIMPLE_DATE_FORMAT_2 = resources.getString(R.string.date_format_2)
    internal val DEFAULT_SIMPLE_DATE_FORMAT_3 = resources.getString(R.string.date_format_3)
    internal val DEFAULT_SIMPLE_DATE_FORMAT_4 = resources.getString(R.string.date_format_4)
    internal val DEFAULT_SIMPLE_DATE_FORMAT_5 = resources.getString(R.string.date_format_5)

    internal val DEFAULT_COLOR_SCHEMA_KEY = resources.getString(R.string.key_project_sup_color_schema)
    internal val DEFAULT_THEME_KEY = resources.getString(R.string.key_project_sup_theme)
    internal val DEFAULT_COLOR_SCHEMA = resources.getString(R.string.key_sup_default_color_schema)
    internal val DEFAULT_THEME = resources.getString(R.string.key_sup_default_style)

    internal val DEFAULT_STYLE_KEY = resources.getString(R.string.key_style)
    internal val DEFAULT_TYPEFACE_KEY = resources.getString(R.string.key_typeface)
    internal val DEFAULT_THEME_NAME_KEY = resources.getString(R.string.key_theme_name)
    internal val DEFAULT_COLOR_NAME_KEY = resources.getString(R.string.key_color_name)

    internal val DEFAULT_CALENDAR_DAYS = resources.getInteger(R.integer.calendar_days)
}