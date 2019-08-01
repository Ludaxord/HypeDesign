package com.ludaxord.projectsup.library.utilities.colors.interfaces

import android.content.Context
import com.ludaxord.projectsup.library.utilities.colors.Color

interface IColor {
    fun getColorSchema(context: Context): Color
}