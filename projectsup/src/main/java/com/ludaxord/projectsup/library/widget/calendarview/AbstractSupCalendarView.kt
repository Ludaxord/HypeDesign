package com.ludaxord.projectsup.library.widget.calendarview

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.ludaxord.projectsup.R
import com.ludaxord.projectsup.library.text.textview.SupTextView
import com.ludaxord.projectsup.library.utilities.*
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

    data class StyledAttributes(
        var themeRes: Int,
        var themeResName: String?,
        var colorSchemaRes: Int,
        var languageRes: String?
    )

    internal val calendar = Calendar.getInstance()

    internal var res: Pair<Int, Int> = Pair(0, 0)

    internal var languageName: String = context.resources.getString(R.string.language_option_en)

    internal var events: ArrayList<Date> = ArrayList()

    internal var schedule: ArrayList<Schedule> = ArrayList()

    internal var subViewHelperArrayList: ArrayList<View> = ArrayList()

    internal var dateFormat = context.resources.getString(com.ludaxord.projectsup.R.string.date_format_4)

    internal lateinit var calendarLanguage: Language

    internal lateinit var headerLinearLayout: LinearLayout

    internal lateinit var controlsRelativeLayout: RelativeLayout

    internal lateinit var leftImageView: ImageView

    internal lateinit var rightImageView: ImageView

    internal lateinit var dateTextView: TextView

    internal lateinit var calendarGridView: GridView

    internal lateinit var calendarAdapter: SupCalendarAdapter

    protected constructor(
        context: Context,
        res: Pair<Int, Int>,
        events: ArrayList<Date> = ArrayList(),
        language: String
    ) : super(context) {
        Log.i("ProjectSup", "Chicago")
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
        Log.i("ProjectSup", "NRG")
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
        Log.i("ProjectSup", "UNC")
        this.res = res
        this.events = events
        this.languageName = language
        setInitializer()
    }

    constructor(context: Context) : this(
        context,
        Pair(
            context.resources.getInteger(com.ludaxord.projectsup.R.integer.sup_default_style),
            context.resources.getInteger(com.ludaxord.projectsup.R.integer.sup_default_color_schema)
        ),
        ArrayList<Date>(),
        context.resources.getString(com.ludaxord.projectsup.R.string.language_option_en)
    )

    constructor(context: Context, attrs: AttributeSet) : this(
        context,
        attrs,
        Pair(
            context.resources.getInteger(com.ludaxord.projectsup.R.integer.sup_default_style),
            context.resources.getInteger(com.ludaxord.projectsup.R.integer.sup_default_color_schema)
        ),
        ArrayList<Date>(),
        context.resources.getString(com.ludaxord.projectsup.R.string.language_option_en)
    )

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : this(
        context,
        attrs,
        defStyleAttr,
        Pair(
            context.resources.getInteger(com.ludaxord.projectsup.R.integer.sup_default_style),
            context.resources.getInteger(com.ludaxord.projectsup.R.integer.sup_default_color_schema)
        ),
        ArrayList<Date>(),
        context.resources.getString(com.ludaxord.projectsup.R.string.language_option_en)
    )


    fun setViewUtilsFromStyledAttributes(attrs: AttributeSet): StyledAttributes {
        val a = getStyledAttributes(context, attrs, R.styleable.SupCalendarView)

        val themeRes = getStyledAttributesTheme(a, R.styleable.SupCalendarView_theme_res)
        val themeNameRes = getStyledAttributesThemeName(a, R.styleable.SupCalendarView_theme_name_res)
        val colorSchemaRes = getStyledAttributesColorSchema(a, R.styleable.SupCalendarView_color_schema_res)
        val languageRes = getStyledAttributesLanguage(a, R.styleable.SupCalendarView_language_res)

        this.res = Pair(themeRes, colorSchemaRes)

        if (languageRes != null) {
            this.languageName = languageRes
        }

        a.recycle()

        return StyledAttributes(themeRes, themeNameRes, colorSchemaRes, languageRes)
    }

    internal open fun setDefaultViewUtils() {
        setDefaultTheme(res.first)
        setDefaultColorSchema(res.second)
        createViews()
        setDefaultWeekDaysLanguage()
        setWeekDays()
        initListeners()
        setCalendarView()
        setFonts(this)
    }

    internal open fun changeLanguageWeekDays(actualLanguage: Language, newLanguage: String) {
        val language = changeLanguage(actualLanguage, newLanguage)
        setWeekDays(language)
    }

    private fun setInitializer() {
        setDefaultViewUtils()
    }

    private fun setDefaultWeekDaysLanguage(languageName: String = this.languageName) {
        calendarLanguage = setLanguage(languageName, context)
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

    private fun createViews(fromInflater: Boolean = true) {
        if (fromInflater) {
            inflaterViews()
        } else {
            dynamicViews()
        }
    }

    protected fun setWeekDays(language: Language = calendarLanguage) {
        language.setWeeksToViews(headerLinearLayout)
    }

    protected fun setCalendarView() {
        this.setCalendar(events)
    }

    protected fun getDefaultColorSchema(): Color {
        return context.getColorSchemaFromPreferences()
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