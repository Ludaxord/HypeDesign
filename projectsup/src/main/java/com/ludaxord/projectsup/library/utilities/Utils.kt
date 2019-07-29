package com.ludaxord.projectsup.library.utilities

import android.view.View
import com.ludaxord.projectsup.library.utilities.Utils.setThemeFromResources
import com.ludaxord.projectsup.library.utilities.Utils.setViewCorners

fun View.initTheme(res: Int) {
    setThemeFromResources(this, res)
}

fun View.setCorners(corners: Int) {
    setViewCorners(this, corners)
}

fun View.setCorners(corners: List<Int>) {
    for (corner in corners) {
        try {
            setViewCorners(this, corner)
        } catch (exception: UtilsException) {

        }
    }
}

private object Utils {

    fun setViewCorners(view: View, corner: Int) {

    }

    fun setThemeFromResources(view: View, res: Int) {
        when (res) {
            com.ludaxord.projectsup.R.integer.sup_default_style -> {

            }
            com.ludaxord.projectsup.R.integer.sup_box_style -> {

            }
            com.ludaxord.projectsup.R.integer.sup_arc_style -> {

            }
            com.ludaxord.projectsup.R.integer.sup_s_style -> {

            }
            com.ludaxord.projectsup.R.integer.sup_script_style -> {

            }
            com.ludaxord.projectsup.R.integer.sup_photo_style -> {

            }
            com.ludaxord.projectsup.R.integer.sup_mini_box_style -> {

            }
            com.ludaxord.projectsup.R.integer.sup_swoosh_style -> {

            }
            com.ludaxord.projectsup.R.integer.sup_jump_man_style -> {

            }
            com.ludaxord.projectsup.R.integer.sup_champion_style -> {

            }
            com.ludaxord.projectsup.R.integer.sup_denim_style -> {

            }
            com.ludaxord.projectsup.R.integer.sup_tag_style -> {

            }
            else -> {

            }
        }
    }
}
