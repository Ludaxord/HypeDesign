package com.ludaxord.projectsup.library.interfaces

import com.ludaxord.projectsup.library.utilities.colors.Color
import com.ludaxord.projectsup.library.utilities.themes.Theme

interface IView {

    fun setColorSchema(colorRes: Int)

    fun setTheme(themeRes: Int)

    fun getColorSchema(): Color

    fun getTheme(): Theme

}