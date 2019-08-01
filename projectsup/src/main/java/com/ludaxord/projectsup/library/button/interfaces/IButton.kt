package com.ludaxord.projectsup.library.button.interfaces

import android.view.View
import com.ludaxord.projectsup.library.interfaces.IView
import com.ludaxord.projectsup.library.utilities.setCorners
import com.ludaxord.projectsup.library.utilities.stickViewToBottom

interface IButton : IView {

    fun setCorners(cornerList: List<Float>, view: View? = null) {
        view?.setCorners(cornerList)
    }

    fun setCorners(corners: Float, view: View? = null) {
        view?.setCorners(corners)
    }

    fun setStickToBottom(withMargin: Int, view: View? = null) {
        view?.stickViewToBottom(withMargin)
    }
}