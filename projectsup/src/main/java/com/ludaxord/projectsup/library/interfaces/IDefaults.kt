package com.ludaxord.projectsup.library.interfaces

import android.view.View
import com.ludaxord.projectsup.library.utilities.colors.Color
import com.ludaxord.projectsup.library.utilities.overrideFontColor
import com.ludaxord.projectsup.library.utilities.overrideFontTypeFace
import com.ludaxord.projectsup.library.utilities.themes.Theme

interface IDefaults {
    fun setFonts(rootView: View, theme: Theme, color: Color, withColor: Boolean = true) {
        rootView.overrideFontTypeFace(theme)
        if (withColor) {
            rootView.overrideFontColor(color)
        }
    }
}