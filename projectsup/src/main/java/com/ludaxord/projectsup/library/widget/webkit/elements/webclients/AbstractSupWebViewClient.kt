package com.ludaxord.projectsup.library.widget.webkit.elements.webclients

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.webkit.WebView
import android.webkit.WebViewClient
import com.ludaxord.projectsup.library.utilities.Defaults.TAG
import com.ludaxord.projectsup.library.utilities.colors.Color
import com.ludaxord.projectsup.library.utilities.colors.ColorSchemaUtils
import com.ludaxord.projectsup.library.utilities.colors.ColorSchemaUtils.getColorSchema
import com.ludaxord.projectsup.library.utilities.getThemeColorSchema
import com.ludaxord.projectsup.library.utilities.themes.Theme
import com.ludaxord.projectsup.library.utilities.themes.ThemeUtils.getTheme
import com.ludaxord.projectsup.library.widget.webkit.webview.AbstractSupWebView

abstract class AbstractSupWebViewClient : WebViewClient {

    private var context: Context

    private lateinit var theme: Theme

    private lateinit var color: Color

    private lateinit var webView: AbstractSupWebView

    internal var allowedUrls: ArrayList<String>

    internal var handlerAlertDialogMessage: String? = null

    internal var handlerUrl: Uri? = null

    internal lateinit var handlerActivity: Activity

    internal lateinit var handlerAlertDialog: AlertDialog

    private constructor(context: Context, allowedUrls: ArrayList<String> = ArrayList()) {
        this.context = context
        this.allowedUrls = allowedUrls
    }

    protected constructor(
        context: Context,
        allowedUrls: ArrayList<String> = ArrayList(),
        webView: AbstractSupWebView
    ) : this(
        context,
        allowedUrls
    ) {
        this.webView = webView
        this.theme = webView.getTheme()
        this.color = webView.getColorSchema()
    }

    protected constructor(
        context: Context,
        allowedUrls: ArrayList<String> = ArrayList(),
        theme: Theme,
        color: Color
    ) : this(
        context,
        allowedUrls
    ) {
        this.theme = theme
        this.color = color
    }

    protected constructor(
        context: Context,
        allowedUrls: ArrayList<String> = ArrayList(),
        res: Pair<String, String>
    ) : this(
        context,
        allowedUrls
    ) {
        setTheme(res.first)
        setColorSchema(res.second)
    }

    constructor(
        context: Context,
        allowedUrls: ArrayList<String> = ArrayList(),
        webView: AbstractSupWebView,
        handlerActivity: Activity
    ) : this(
        context,
        allowedUrls,
        webView
    ) {
        this.handlerActivity = handlerActivity
    }

    constructor(
        context: Context,
        allowedUrls: ArrayList<String> = ArrayList(),
        theme: Theme,
        color: Color,
        handlerActivity: Activity
    ) : this(
        context,
        allowedUrls,
        theme,
        color
    ) {
        this.handlerActivity = handlerActivity
    }

    constructor(
        context: Context,
        allowedUrls: ArrayList<String> = ArrayList(),
        webView: AbstractSupWebView,
        handlerUrl: Uri
    ) : this(
        context,
        allowedUrls,
        webView
    ) {
        this.handlerUrl = handlerUrl
    }

    constructor(
        context: Context,
        allowedUrls: ArrayList<String> = ArrayList(),
        theme: Theme,
        color: Color,
        handlerUrl: Uri
    ) : this(
        context,
        allowedUrls,
        theme,
        color
    ) {
        this.handlerUrl = handlerUrl
    }

    constructor(
        context: Context,
        allowedUrls: ArrayList<String> = ArrayList(),
        webView: AbstractSupWebView,
        handlerAlertDialogMessage: String
    ) : this(
        context,
        allowedUrls,
        webView
    ) {
        this.handlerAlertDialogMessage = handlerAlertDialogMessage
    }

    constructor(
        context: Context,
        allowedUrls: ArrayList<String> = ArrayList(),
        theme: Theme,
        color: Color,
        handlerAlertDialogMessage: String
    ) : this(
        context,
        allowedUrls,
        theme,
        color
    ) {
        this.handlerAlertDialogMessage = handlerAlertDialogMessage
    }

    constructor(
        context: Context,
        allowedUrls: ArrayList<String> = ArrayList(),
        webView: AbstractSupWebView,
        handlerAlertDialog: AlertDialog
    ) : this(
        context,
        allowedUrls,
        webView
    ) {
        this.handlerAlertDialog = handlerAlertDialog
    }

    constructor(
        context: Context,
        allowedUrls: ArrayList<String> = ArrayList(),
        theme: Theme,
        color: Color,
        handlerAlertDialog: AlertDialog
    ) : this(
        context,
        allowedUrls,
        theme,
        color
    ) {
        this.handlerAlertDialog = handlerAlertDialog
    }

    private fun setTheme(themeRes: String) {
        theme = getTheme(context, themeRes)
    }

    private fun setColorSchema(colorRes: String) {
        color = getColorSchema(context, colorRes)
    }

    private fun setOverrideUrls(view: WebView?, url: String?): Boolean {

        Log.d(TAG, "url: $url")

        Log.d(TAG, "urls: $allowedUrls")

        Uri.parse(url).host?.let { host ->

            var h = host

            if (h.startsWith("www.")) {
                h = host.replace("www.", "")
            }

            Log.d(TAG, "host: $h")

            if (allowedUrls.contains(h)) {
                return false
            }

            when {
                ::handlerActivity.isInitialized -> {

                }
                ::handlerAlertDialog.isInitialized -> {

                }
                handlerAlertDialogMessage != null -> {

                }
                handlerUrl != null -> Intent(Intent.ACTION_VIEW, handlerUrl).apply {
                    context.startActivity(this)
                }
                else -> Intent(Intent.ACTION_VIEW, Uri.parse(url)).apply {
                    context.startActivity(this)
                }
            }
        }

        return true
    }

    override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
        val overrideUrls = setOverrideUrls(view, url)
        Log.v(TAG, "overrideUrls = $overrideUrls")
        return overrideUrls
    }

}