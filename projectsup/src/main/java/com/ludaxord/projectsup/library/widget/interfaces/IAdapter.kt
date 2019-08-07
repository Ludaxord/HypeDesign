package com.ludaxord.projectsup.library.widget.interfaces

import android.view.View
import android.view.ViewGroup
import com.ludaxord.projectsup.library.interfaces.IDefaults

interface IAdapter : IDefaults {
    fun setItem(position: Int): Any
    fun setView(convertView: View?, parent: ViewGroup?): View
}