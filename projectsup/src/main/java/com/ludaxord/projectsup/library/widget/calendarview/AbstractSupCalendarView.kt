package com.ludaxord.projectsup.library.widget.calendarview

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import com.ludaxord.projectsup.library.text.textview.SupTextView
import com.ludaxord.projectsup.library.utilities.*
import com.ludaxord.projectsup.library.utilities.Defaults.DEFAULT_CALENDAR_EVENTS_ARRAY_LIST
import com.ludaxord.projectsup.library.utilities.Defaults.DEFAULT_LANGUAGE
import com.ludaxord.projectsup.library.utilities.Defaults.DEFAULT_PAIR_OF_THEME_COLOR_SCHEMA
import com.ludaxord.projectsup.library.utilities.Defaults.DEFAULT_SIMPLE_DATE_FORMAT_4
import com.ludaxord.projectsup.library.utilities.colors.Color
import com.ludaxord.projectsup.library.utilities.languages.Language
import com.ludaxord.projectsup.library.utilities.themes.Theme
import com.ludaxord.projectsup.library.widget.calendarview.elements.adapter.SupCalendarAdapter
import com.ludaxord.projectsup.library.widget.calendarview.elements.models.Schedule
import com.ludaxord.projectsup.library.widget.gridview.SupGridView
import com.ludaxord.projectsup.library.widget.imageview.SupImageView
import com.ludaxord.projectsup.library.widget.interfaces.ICalendar
import java.util.*
import kotlin.collections.ArrayList

abstract class AbstractSupCalendarView : LinearLayout, ICalendar {

    internal val calendar = Calendar.getInstance()

    internal var res: Pair<Int, Int> = Pair(0, 0)

    internal var languageName: String

    internal var events: ArrayList<Date> = ArrayList()

    internal var schedule: ArrayList<Schedule> = ArrayList()

    internal var subViewHelperArrayList: ArrayList<View> = ArrayList()

    internal var dateFormat = DEFAULT_SIMPLE_DATE_FORMAT_4

    internal lateinit var calendarLanguage: Language

    internal lateinit var headerLinearLayout: LinearLayout

    internal lateinit var controlsRelativeLayout: RelativeLayout

    internal lateinit var leftImageView: SupImageView

    internal lateinit var rightImageView: SupImageView

    internal lateinit var dateTextView: SupTextView

    internal lateinit var calendarGridView: GridView

    internal lateinit var calendarAdapter: SupCalendarAdapter

    protected constructor(
        context: Context,
        res: Pair<Int, Int>,
        events: ArrayList<Date> = ArrayList(),
        language: String
    ) : super(context) {
        this.res = res
        this.events = events
        this.languageName = language
        setInitializer()
    }

    protected constructor(
        context: Context,
        attrs: AttributeSet,
        res: Pair<Int, Int>,
        events: ArrayList<Date> = ArrayList(),
        language: String
    ) : super(
        context,
        attrs
    ) {
        this.res = res
        this.events = events
        this.languageName = language
        setInitializer()
    }

    protected constructor(
        context: Context,
        attrs: AttributeSet,
        defStyleAttr: Int,
        res: Pair<Int, Int>,
        events: ArrayList<Date> = ArrayList(),
        language: String
    ) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        this.res = res
        this.events = events
        this.languageName = language
        setInitializer()
    }

    constructor(context: Context) : this(
        context,
        DEFAULT_PAIR_OF_THEME_COLOR_SCHEMA,
        DEFAULT_CALENDAR_EVENTS_ARRAY_LIST,
        DEFAULT_LANGUAGE
    )

    constructor(context: Context, attrs: AttributeSet) : this(
        context,
        attrs,
        DEFAULT_PAIR_OF_THEME_COLOR_SCHEMA,
        DEFAULT_CALENDAR_EVENTS_ARRAY_LIST,
        DEFAULT_LANGUAGE
    )

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : this(
        context,
        attrs,
        defStyleAttr,
        DEFAULT_PAIR_OF_THEME_COLOR_SCHEMA,
        DEFAULT_CALENDAR_EVENTS_ARRAY_LIST,
        DEFAULT_LANGUAGE
    )

    internal open fun setDefaultViewUtils() {
        setDefaultTheme(res.first)
        setDefaultColorSchema(res.second)
        createViews()
        setDefaultWeekDaysLanguage()
        setWeekDays()
        initListeners()
    }

    internal open fun changeLanguageWeekDays(actualLanguage: Language, newLanguage: String) {
        val language = changeLanguage(actualLanguage, newLanguage)
        setWeekDays(language)
    }

    private fun setInitializer() {
        setDefaultViewUtils()
    }

    private fun setDefaultWeekDaysLanguage(languageName: String = this.languageName) {
        calendarLanguage = setLanguage(languageName, resources)
    }

    private fun inflaterViews(root: ViewGroup = this) {
        val layoutInflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        layoutInflater.inflate(com.ludaxord.projectsup.R.layout.sup_calendar_view, root)

        controlsRelativeLayout = findViewById(com.ludaxord.projectsup.R.id.sup_calendar_controls)

        headerLinearLayout = findViewById(com.ludaxord.projectsup.R.id.sup_calendar_header)

        leftImageView = findViewById(com.ludaxord.projectsup.R.id.sup_calendar_left)

        rightImageView = findViewById(com.ludaxord.projectsup.R.id.sup_calendar_right)

        dateTextView = findViewById(com.ludaxord.projectsup.R.id.sup_calendar_date)

        calendarGridView = findViewById(com.ludaxord.projectsup.R.id.sup_calendar_grid)

    }

    private fun initListeners() {
        leftImageView.setMonthForCalendarView(this, null, -1)
        rightImageView.setMonthForCalendarView(this, null, 1)
    }

    private fun dynamicViews() {
        controlsRelativeLayout = RelativeLayout(context)
        subViewHelperArrayList.add(controlsRelativeLayout)

        headerLinearLayout = LinearLayout(context)
        subViewHelperArrayList.add(headerLinearLayout)

        leftImageView = SupImageView(context)
        subViewHelperArrayList.add(leftImageView)

        rightImageView = SupImageView(context)
        subViewHelperArrayList.add(rightImageView)

        dateTextView = SupTextView(context)
        subViewHelperArrayList.add(dateTextView)

        calendarGridView = SupGridView(context)
        subViewHelperArrayList.add(calendarGridView)

        setIdsForViews()
        setViewsInRoot()
    }

    private fun setIdsForViews() {
        subViewHelperArrayList.setIds(this)
    }

    private fun setViewsInRoot() {
        this.setViewsToRoot(subViewHelperArrayList)
    }

    private fun createViews(fromInflater: Boolean = false) {
        if (fromInflater) {
            inflaterViews()
        } else {
            dynamicViews()
        }
    }

    protected fun setWeekDays(language: Language = calendarLanguage) {
        language.setWeeksToViews(headerLinearLayout)
    }

    protected fun getDefaultColorSchema(): Color {
        return context.getColorSchemaFromPreferneces()
    }

    protected fun getDefaultTheme(): Theme {
        return context.getThemeFromPreferences()
    }

    protected fun setDefaultColorSchema(colorRes: Int) {
        this.initColorsSchema(colorRes)
    }

    protected fun setDefaultTheme(themeRes: Int) {
        this.initTheme(themeRes)
    }

}