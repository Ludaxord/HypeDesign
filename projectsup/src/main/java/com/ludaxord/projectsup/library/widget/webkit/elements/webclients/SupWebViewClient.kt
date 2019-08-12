package com.ludaxord.projectsup.library.widget.webkit.elements.webclients

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.net.Uri
import com.ludaxord.projectsup.library.utilities.colors.Color
import com.ludaxord.projectsup.library.utilities.themes.Theme
import com.ludaxord.projectsup.library.widget.webkit.webview.AbstractSupWebView

class SupWebViewClient : AbstractSupWebViewClient {

    constructor(context: Context, allowedUrls: ArrayList<String>, res: Pair<String, String>) : super(
        context,
        allowedUrls,
        res
    )

    constructor(context: Context, allowedUrls: ArrayList<String>, webView: AbstractSupWebView) : super(
        context,
        allowedUrls,
        webView
    )

    constructor(context: Context, allowedUrls: ArrayList<String>, theme: Theme, color: Color) : super(
        context,
        allowedUrls,
        theme,
        color
    )

    constructor(
        context: Context,
        allowedUrls: ArrayList<String>,
        webView: AbstractSupWebView,
        handlerActivity: Activity
    ) : super(context, allowedUrls, webView, handlerActivity)

    constructor(
        context: Context,
        allowedUrls: ArrayList<String>,
        theme: Theme,
        color: Color,
        handlerActivity: Activity
    ) : super(context, allowedUrls, theme, color, handlerActivity)

    constructor(context: Context, allowedUrls: ArrayList<String>, webView: AbstractSupWebView, handlerUrl: Uri) : super(
        context,
        allowedUrls,
        webView,
        handlerUrl
    )

    constructor(context: Context, allowedUrls: ArrayList<String>, theme: Theme, color: Color, handlerUrl: Uri) : super(
        context,
        allowedUrls,
        theme,
        color,
        handlerUrl
    )

    constructor(
        context: Context,
        allowedUrls: ArrayList<String>,
        webView: AbstractSupWebView,
        handlerAlertDialogMessage: String
    ) : super(context, allowedUrls, webView, handlerAlertDialogMessage)

    constructor(
        context: Context,
        allowedUrls: ArrayList<String>,
        theme: Theme,
        color: Color,
        handlerAlertDialogMessage: String
    ) : super(context, allowedUrls, theme, color, handlerAlertDialogMessage)

    constructor(
        context: Context,
        allowedUrls: ArrayList<String>,
        webView: AbstractSupWebView,
        handlerAlertDialog: AlertDialog
    ) : super(context, allowedUrls, webView, handlerAlertDialog)

    constructor(
        context: Context,
        allowedUrls: ArrayList<String>,
        theme: Theme,
        color: Color,
        handlerAlertDialog: AlertDialog
    ) : super(context, allowedUrls, theme, color, handlerAlertDialog)

}