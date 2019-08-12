package com.ludaxord.projectsup.library.widget.interfaces

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.util.AttributeSet
import com.ludaxord.projectsup.library.interfaces.IView
import com.ludaxord.projectsup.library.utilities.StyledAttributes
import com.ludaxord.projectsup.library.utilities.SupStyledAttributes
import com.ludaxord.projectsup.library.utilities.languages.interfaces.ILanguage
import com.ludaxord.projectsup.library.widget.webkit.elements.webclients.AbstractSupWebViewClient

interface IWeb : ILanguage, IView {

    override fun setViewUtilsFromStyledAttributes(context: Context, attrs: AttributeSet): StyledAttributes {
        val a = getStyledAttributes(context, attrs, com.ludaxord.projectsup.R.styleable.SupWebView)
        val themeRes = getStyledAttributesString(a, com.ludaxord.projectsup.R.styleable.SupWebView_theme_res)
        val colorSchemaRes =
            getStyledAttributesString(a, com.ludaxord.projectsup.R.styleable.SupWebView_color_schema_res)
        a.recycle()
        return SupStyledAttributes(themeRes, colorSchemaRes)
    }

    fun setWebClient(webClient: AbstractSupWebViewClient)

    fun getWebClient(): AbstractSupWebViewClient

    fun setAllowedUrls(urls: ArrayList<String>)

    fun getAllowedUrls(): ArrayList<String>

    fun addAllowedUrls(urls: ArrayList<String>)

    fun setHandlerActivity(activity: Activity)

    fun getHandlerActivity(): Activity

    fun setHandlerDialogAlert(alertDialog: AlertDialog)

    fun setHandlerDialogAlertMessage(alertDialogMessage: String)

    fun getHandlerDialogAlert(): AlertDialog

}