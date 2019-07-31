package com.ludaxord.projectsup.library.widget.calendarview

import android.content.Context
import android.content.res.Resources
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import com.ludaxord.projectsup.library.text.textview.SupTextView
import com.ludaxord.projectsup.library.utilities.Defaults.DEFAULT_CALENDAR_EVENTS_ARRAY_LIST
import com.ludaxord.projectsup.library.utilities.Defaults.DEFAULT_LANGUAGE
import com.ludaxord.projectsup.library.utilities.languages.Language
import com.ludaxord.projectsup.library.utilities.setEvents
import com.ludaxord.projectsup.library.utilities.setIds
import com.ludaxord.projectsup.library.utilities.setViewsToRoot
import com.ludaxord.projectsup.library.utilities.setWeeksToViews
import com.ludaxord.projectsup.library.widget.gridview.SupGridView
import com.ludaxord.projectsup.library.widget.imageview.SupImageView
import com.ludaxord.projectsup.library.widget.interfaces.ICalendar
import java.util.*
import kotlin.collections.ArrayList

abstract class AbstractSupCalendarView : LinearLayout, ICalendar {

    internal val calendar = Calendar.getInstance()

    internal var events: ArrayList<Date> = ArrayList()

    internal var subViewHelperArrayList: ArrayList<View> = ArrayList()

    internal lateinit var headerLinearLayout: LinearLayout

    internal lateinit var controlsRelativeLayout: RelativeLayout

    internal lateinit var leftImageView: SupImageView

    internal lateinit var rightImageView: SupImageView

    internal lateinit var dateTextView: SupTextView

    internal lateinit var calendarGridView: GridView

    internal lateinit var calendarLanguage: Language

    internal lateinit var languageName: String

    protected constructor(context: Context, events: ArrayList<Date> = ArrayList(), language: String) : super(context) {
        this.events = events
        this.languageName = language
        setInitializer()
    }

    protected constructor(
        context: Context,
        attrs: AttributeSet,
        events: ArrayList<Date> = ArrayList(),
        language: String
    ) : super(
        context,
        attrs
    ) {
        this.events = events
        this.languageName = language
        setInitializer()
    }

    protected constructor(
        context: Context,
        attrs: AttributeSet,
        defStyleAttr: Int,
        events: ArrayList<Date> = ArrayList(),
        language: String
    ) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        this.events = events
        this.languageName = language
        setInitializer()
    }

    constructor(context: Context) : this(context, DEFAULT_CALENDAR_EVENTS_ARRAY_LIST, DEFAULT_LANGUAGE)
    constructor(context: Context, attrs: AttributeSet) : this(
        context,
        attrs,
        DEFAULT_CALENDAR_EVENTS_ARRAY_LIST,
        DEFAULT_LANGUAGE
    )

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : this(
        context,
        attrs,
        defStyleAttr,
        DEFAULT_CALENDAR_EVENTS_ARRAY_LIST,
        DEFAULT_LANGUAGE
    )

    private fun setInitializer() {
        createViews()
        setWeekDays()
    }

    private fun setWeekDays() {
        calendarLanguage = setLanguage(languageName, resources)
        calendarLanguage.setWeeksToViews(headerLinearLayout)
    }

    private fun createViews(fromInflater: Boolean = false) {
        if (fromInflater) {
            inflaterViews()
        } else {
            dynamicViews()
        }
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

}