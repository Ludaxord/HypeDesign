package com.ludaxord.projectsup.library.widget.calendarview.elements.adapter

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.ludaxord.projectsup.library.widget.calendarview.elements.models.Schedule
import java.util.*

class SupEventsAdapter(context: Context) : BaseAdapter() {

    private lateinit var inflater: LayoutInflater
    private lateinit var _scheduleEvents: ArrayList<Schedule>
    private lateinit var _dialog: AlertDialog

    constructor(context: Context, scheduleEvents: ArrayList<Schedule>, dialog: AlertDialog) : this(context) {
        inflater = LayoutInflater.from(context)
        _scheduleEvents = scheduleEvents
        _dialog = dialog
        sortByDate(_scheduleEvents)
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItem(position: Int): Any {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemId(position: Int): Long {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun sortByDate(list: ArrayList<Schedule> = _scheduleEvents) {
        list.sortWith(Comparator { o1, o2 -> o1.beginDate!!.compareTo(o2.beginDate!!) })
    }

}