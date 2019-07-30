package com.ludaxord.projectsup.library.button.interfaces

interface IButton {

    fun setColorSchema(colorRes: Int)

    fun setTheme(themeRes: Int)

    fun setCorners(cornerList: List<Float>) {

    }

    fun setCorners(corners: Float) {

    }
}