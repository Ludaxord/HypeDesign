package com.ludaxord.projectsup.library.widget.interfaces

import android.view.View
import android.view.ViewGroup

interface IAdapter {
    fun setItem(position: Int): Any
    fun setView(convertView: View?, parent: ViewGroup?): View
}