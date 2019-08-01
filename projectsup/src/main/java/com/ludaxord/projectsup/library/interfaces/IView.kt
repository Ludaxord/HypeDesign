package com.ludaxord.projectsup.library.interfaces

import android.content.Context

interface IView {

    fun setColorSchema(colorRes: Int)

    fun setTheme(themeRes: Int)

    fun getColorSchema(context: Context) {

    }

    fun getTheme(context: Context) {

    }

}