package com.ludaxord.projectsup.library.widget.calendarview

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.ludaxord.projectsup.R
import com.ludaxord.projectsup.library.text.textview.SupTextView
import com.ludaxord.projectsup.library.utilities.*
import com.ludaxord.projectsup.library.utilities.Defaults.TAG
import com.ludaxord.projectsup.library.utilities.colors.Color
import com.ludaxord.projectsup.library.utilities.colors.ColorSchemaUtils
import com.ludaxord.projectsup.library.utilities.languages.Language
import com.ludaxord.projectsup.library.utilities.themes.Theme
import com.ludaxord.projectsup.library.utilities.themes.ThemeUtils
import com.ludaxord.projectsup.library.utilities.themes.ThemeUtils.getTheme
import com.ludaxord.projectsup.library.utilities.themes.themeoptions.Default
import com.ludaxord.projectsup.library.widget.calendarview.elements.adapter.SupCalendarAdapter
import com.ludaxord.projectsup.library.widget.calendarview.elements.models.Schedule
import com.ludaxord.projectsup.library.widget.gridview.SupGridView
import com.ludaxord.projectsup.library.widget.imageview.SupImageView
import com.ludaxord.projectsup.library.widget.interfaces.ICalendar
import java.util.*
import kotlin.collections.ArrayList

abstract class AbstractSupCalendarView : LinearLayout, ICalendar {

    data class SupCalendarStyledAttributes(
        override var themeRes: String?,
        override var colorSchemaRes: String?,
        var languageName: String?,
        var buttonsDrawable: Pair<Drawable?, Drawable?>
    ) : StyledAttributes(themeRes, colorSchemaRes)

    internal val calendar = Calendar.getInstance()

    internal var res: Pair<String, String> = Pair(
        context.getString(com.ludaxord.projectsup.R.string.key_sup_default_style),
        context.getString(com.ludaxord.projectsup.R.string.key_sup_default_color_schema)
    )

    internal var languageName: String = context.resources.getString(R.string.language_option_en)

    internal var events: ArrayList<Date> = ArrayList()

    internal var schedule: ArrayList<Schedule> = ArrayList()

    internal var subViewHelperArrayList: ArrayList<View> = ArrayList()

    internal var dateFormat = context.resources.getString(com.ludaxord.projectsup.R.string.date_format_4)

    internal var theme: Theme = Default(context)

    internal var color: Color = com.ludaxord.projectsup.library.utilities.colors.colorschema.Default(context)

    internal lateinit var navigationRes: Pair<Drawable?, Drawable?>

    internal lateinit var styledAttributes: StyledAttributes

    internal lateinit var attrs: AttributeSet

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
        res: Pair<String, String>,
        events: ArrayList<Date> = ArrayList(),
        language: String
    ) : super(context) {
        Log.i(TAG, "Chicago")
        this.res = res
        this.events = events
        this.languageName = language
        setInitializer()
    }

    protected constructor(
        context: Context,
        attrs: AttributeSet,
        res: Pair<String, String>,
        events: ArrayList<Date> = ArrayList(),
        language: String
    ) : super(
        context,
        attrs
    ) {
        Log.i(TAG, "NRG")
        this.attrs = attrs
        this.res = res
        this.events = events
        this.languageName = language
        setInitializer()
    }

    protected constructor(
        context: Context,
        attrs: AttributeSet,
        defStyleAttr: Int,
        res: Pair<String, String>,
        events: ArrayList<Date> = ArrayList(),
        language: String
    ) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        Log.i(TAG, "UNC")
        this.attrs = attrs
        this.res = res
        this.events = events
        this.languageName = language
        setInitializer()
    }

    constructor(context: Context) : this(
        context,
        Pair(
            context.getString(com.ludaxord.projectsup.R.string.key_sup_default_style),
            context.getString(com.ludaxord.projectsup.R.string.key_sup_default_color_schema)
        ),
        ArrayList<Date>(),
        context.resources.getString(com.ludaxord.projectsup.R.string.language_option_en)
    )

    constructor(context: Context, attrs: AttributeSet) : this(
        context,
        attrs,
        Pair(
            context.getString(com.ludaxord.projectsup.R.string.key_sup_default_style),
            context.getString(com.ludaxord.projectsup.R.string.key_sup_default_color_schema)
        ),
        ArrayList<Date>(),
        context.resources.getString(com.ludaxord.projectsup.R.string.language_option_en)
    )

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : this(
        context,
        attrs,
        defStyleAttr,
        Pair(
            context.getString(com.ludaxord.projectsup.R.string.key_sup_default_style),
            context.getString(com.ludaxord.projectsup.R.string.key_sup_default_color_schema)
        ),
        ArrayList<Date>(),
        context.resources.getString(com.ludaxord.projectsup.R.string.language_option_en)
    )


    override fun setViewUtilsFromStyledAttributes(context: Context, attrs: AttributeSet): StyledAttributes {
        val a = getStyledAttributes(context, attrs, R.styleable.SupCalendarView)

        val themeRes = getStyledAttributesTheme(a, R.styleable.SupCalendarView_theme_res)
        val colorSchemaRes = getStyledAttributesColorSchema(a, R.styleable.SupCalendarView_color_schema_res)
        val languageRes = getStyledAttributesLanguage(a, R.styleable.SupCalendarView_language_res)
        val leftButtonRes = getStyledAttributesDrawable(a, R.styleable.SupCalendarView_button_left_res)
        val rightButtonRes = getStyledAttributesDrawable(a, R.styleable.SupCalendarView_button_right_res)
//        TODO: adding layout from styled attributes

        if (themeRes != null && colorSchemaRes != null) {
            this.res = Pair(themeRes, colorSchemaRes)
        }

        val navigationDrawables = Pair(leftButtonRes, rightButtonRes)

        if (leftButtonRes != null && rightButtonRes != null) {
            this.navigationRes = navigationDrawables
        }

        if (languageRes != null) {
            this.languageName = languageRes
        }

        a.recycle()

        return SupCalendarStyledAttributes(
            themeRes,
            colorSchemaRes,
            languageRes,
            navigationDrawables
        )
    }

    internal open fun setDefaultViewUtils() {
        styledAttributes = setViewUtilsFromStyledAttributes(context, attrs)
        Log.w(TAG, "res -> ${res.first} ${res.second}")
        setTheme(res.first)
        setColorSchema(res.second)
        createViews()
        setDefaultWeekDaysLanguage()
        setWeekDays()
        initListeners()
        setCalendarView()
        setFonts(this, theme, color)
        setNavigationButtons()
    }

    internal open fun changeLanguageWeekDays(actualLanguage: Language, newLanguage: String) {
        val language = changeLanguage(actualLanguage, newLanguage)
        setWeekDays(language)
    }

    private fun setNavigationButtons() {
        val navs = if (::navigationRes.isInitialized) {
            navigationRes
        } else {
            Pair(
                getTheme().theme()[context.getString(R.string.key_drawable_left_button)] as Drawable,
                getTheme().theme()[context.getString(R.string.key_drawable_right_button)] as Drawable
            )
        }
        setNavigationButtonsDrawable(navs, Pair(leftImageView, rightImageView))
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

    override fun getColorSchema(): Color {
        return color
    }

    override fun setColorSchema(colorRes: Int) {
        val r = colorRes.getResourceFromInt(context) { r, c -> c.getString(r) }
        color = ColorSchemaUtils.getColorSchema(context, r)
    }

    override fun setTheme(themeRes: Int) {
        val r = themeRes.getResourceFromInt(context) { r, c -> c.getString(r) }
        theme = getTheme(context, r)
    }

    override fun setColorSchema(colorRes: String) {
        color = ColorSchemaUtils.getColorSchema(context, colorRes)
    }

    override fun setTheme(themeRes: String) {
        theme = getTheme(context, themeRes)
    }

    override fun getTheme(): Theme {
        return theme
    }

}