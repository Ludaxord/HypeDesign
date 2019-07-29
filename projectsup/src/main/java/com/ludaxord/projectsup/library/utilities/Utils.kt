package com.ludaxord.projectsup.library.utilities

import android.view.View
import com.ludaxord.projectsup.R
import com.ludaxord.projectsup.library.utilities.ThemeUtils.setThemeFromResources
import com.ludaxord.projectsup.library.utilities.ViewUtils.setViewCorners
import com.ludaxord.projectsup.library.utilities.ViewUtils.setViewCustomCorners

fun View.initTheme(res: Int) {
    setThemeFromResources(this, res)
}

fun View.setCorners(corners: Float) {
    setViewCorners(this, corners)
}

fun View.setCorners(corners: List<Float>) {
    if (corners.size == 4) {
        for (corner in corners) {
            setViewCustomCorners(this, corners)
        }
    } else {
        throw UtilsException(this.context.getString(R.string.utils_exception_incorrect_size_message))
    }
}
