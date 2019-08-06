package com.ludaxord.projectsup.library.widget.calendarview.elements.adapter

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import com.ludaxord.projectsup.R
import com.ludaxord.projectsup.library.utilities.setTextColorSchema
import com.ludaxord.projectsup.library.utilities.setTypeFaceTheme
import com.ludaxord.projectsup.library.utilities.themes.Theme
import com.ludaxord.projectsup.library.utilities.toCalendar
import com.ludaxord.projectsup.library.widget.calendarview.AbstractSupCalendarView
import com.ludaxord.projectsup.library.widget.calendarview.elements.models.Schedule
import com.ludaxord.projectsup.library.widget.interfaces.IAdapter
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class SupCalendarAdapter(private val context: Context) : BaseAdapter(), IAdapter {

    private var days = java.util.ArrayList<Date>()
    private var events = java.util.ArrayList<Date>()
    private var date: Date? = null
    private var schedule: ArrayList<Schedule> = ArrayList()

    private data class Time(val date: Calendar, val day: Int, val month: Int, val year: Int, val today: Calendar?)

    private lateinit var colorSet: HashMap<String, Any>

    private lateinit var themeCredentials: HashMap<String, Any>

    private lateinit var inflater: LayoutInflater

    constructor(
        context: Context,
        calendarView: AbstractSupCalendarView,
        date: Date,
        days: ArrayList<Date>
    ) : this(context) {
        val theme = calendarView.getTheme()
        val color = calendarView.getColorSchema()
        this.days = days
        this.events = calendarView.events
        this.schedule = calendarView.schedule
        this.themeCredentials = theme.theme()
        this.colorSet = color.color()
        this.date = date
        inflater = LayoutInflater.from(context)
    }

    constructor(
        context: Context,
        days: ArrayList<Date>,
        events: ArrayList<Date>,
        schedule: ArrayList<Schedule>,
        date: Date?,
        theme: Theme,
        color: com.ludaxord.projectsup.library.utilities.colors.Color
    ) : this(context) {
        this.days = days
        this.events = events
        this.schedule = schedule
        this.themeCredentials = theme.theme()
        this.colorSet = color.color()
        this.date = date
        inflater = LayoutInflater.from(context)
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = setView(convertView, parent)
        val item = setItem(position) as Calendar
        val time = getItemDetails(item)
        setItemDetails(view, time)
        return view
    }

    override fun getItem(position: Int): Any {
        return days[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return days.count()
    }

    private fun setView(convertView: View?, parent: ViewGroup?): View {
        var view = convertView

        if (view == null) {
            view = inflater.inflate(R.layout.sup_calendar_adapter, parent, false)
        }

        return view!!
    }

    override fun setItem(position: Int): Any {
        val item = getItem(position) as Date
        return item.toCalendar()
    }

    private fun getItemDetails(item: Calendar): Time {
        val day = item.get(Calendar.DAY_OF_MONTH)
        val month = item.get(Calendar.MONTH)
        val year = item.get(Calendar.YEAR)
        val today = if (date == null) Date() else date
        return Time(item, day, month, year, today?.toCalendar())
    }

    private fun setItemDetails(view: View, time: Time) {
        if (view is TextView) {
            view.setTypeFaceTheme(themeCredentials[context.resources.getString(R.string.key_typeface)])
            view.setTextColorSchema(colorSet[context.resources.getString(R.string.key_day)])

            val (date, day, month, year, today) = time

            val simpleDateFormat =
                SimpleDateFormat(context.resources.getString(R.string.date_format_3), Locale.getDefault())

            val timeStamp = simpleDateFormat.format(Calendar.getInstance().time)

            val formatDate = simpleDateFormat.format(date.time)

            today?.let {
                if (month != today.get(Calendar.MONTH) || year != today.get(Calendar.YEAR)) {
                    view.setTextColorSchema(colorSet[context.resources.getString(R.string.key_greyed_out)])
                } else if (day == Calendar.getInstance().get(Calendar.DAY_OF_MONTH) && formatDate == timeStamp) {
                    view.setTypeFaceTheme(themeCredentials[context.resources.getString(R.string.key_typeface)])
                    view.setTextColorSchema(colorSet[context.resources.getString(R.string.key_today)])
                } else {
                    view.setTypeFaceTheme(themeCredentials[context.resources.getString(R.string.key_typeface)])
                    view.setTextColorSchema(colorSet[context.resources.getString(R.string.key_day)])
                }
            }

            val format = SimpleDateFormat(context.resources.getString(R.string.date_format_4), Locale.getDefault())
            val form = SimpleDateFormat(context.resources.getString(R.string.date_format_3), Locale.getDefault())

            for (event in schedule) {
                val begin = event.beginDate
                val end = event.endDate
                val id = event.id
                val f = SimpleDateFormat(context.resources.getString(R.string.date_format_1), Locale.getDefault())

                val formattedDate = f.format(date.time)

                val bS = f.parse(begin)
                val fDS = f.parse(formattedDate)

                val parsebS = form.format(bS)
                val parsefDS = form.format(fDS)

                if (parsebS == parsefDS) {
                    view.setTextColorSchema(colorSet[context.resources.getString(R.string.key_warning)])
                    break
                } else {
//                    view.setBackgroundResource(0)
                }
            }

            view.text = "${date.get(Calendar.DAY_OF_MONTH)}"

            view.setOnClickListener {
                val convertedDate = form.format(date)
                val matchDate = ArrayList<Schedule>()
                for (event in schedule) {
                    if (event.date == convertedDate) {
                        if (!matchDate.contains(event)) {
                            matchDate.add(event)
                        }
                    }
                }
                calendarDetails(matchDate, convertedDate)
            }
        }
    }

    @SuppressLint("InflateParams")
    private fun calendarDetails(events: ArrayList<Schedule>, date: String) {
        val layoutInflater = LayoutInflater.from(context)
        val calendarDetailsView = layoutInflater.inflate(R.layout.sup_calendar_details_view, null)
        val alert = AlertDialog.Builder(context)

        alert.setView(calendarDetailsView)

        val add = calendarDetailsView.findViewById<ImageView>(R.id.calendar_event_add)
        val cancel = calendarDetailsView.findViewById<ImageView>(R.id.calendar_event_cancel)
        val eventsList = calendarDetailsView.findViewById<ListView>(R.id.events)
        val dateEvent = calendarDetailsView.findViewById<TextView>(R.id.date_events)
        val noEvents = calendarDetailsView.findViewById<TextView>(R.id.no_events)

        val dialog = alert.create()

        eventsList.adapter = SupEventsAdapter(context, events, dialog)

        if (events.isNotEmpty()) {
            eventsList.visibility = View.VISIBLE
            noEvents.visibility = View.GONE
        } else {
            eventsList.visibility = View.GONE
            noEvents.visibility = View.VISIBLE
        }

        val color = ColorDrawable((Color.TRANSPARENT))

        dialog.window!!.setBackgroundDrawable(color)

        cancel.setOnClickListener {
            dialog.dismiss()
            dialog.cancel()
        }
        add.setOnClickListener {
            dialog.dismiss()
            dialog.cancel()
        }

        dateEvent.text = date
        dialog.show()
    }
}