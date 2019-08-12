package com.ludaxord.projectsup.library.widget.webkit.webview

import android.annotation.SuppressLint
import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.net.Uri
import android.util.AttributeSet
import android.util.Log
import android.webkit.WebView
import com.ludaxord.projectsup.library.utilities.*
import com.ludaxord.projectsup.library.utilities.colors.Color
import com.ludaxord.projectsup.library.utilities.colors.ColorSchemaUtils
import com.ludaxord.projectsup.library.utilities.themes.Theme
import com.ludaxord.projectsup.library.utilities.themes.ThemeUtils
import com.ludaxord.projectsup.library.widget.interfaces.IWeb
import com.ludaxord.projectsup.library.widget.webkit.elements.webclients.AbstractSupWebViewClient
import com.ludaxord.projectsup.library.widget.webkit.elements.webclients.SupWebViewClient


abstract class AbstractSupWebView : WebView, IWeb {

    data class SupWebStyledAttributes(
        override var themeRes: String?,
        override var colorSchemaRes: String?,
        var languageName: String?,
        var handlerUrl: Uri?
    ) : StyledAttributes(themeRes, colorSchemaRes)

    internal var res: Pair<String, String> = Pair(
        context.getString(com.ludaxord.projectsup.R.string.key_sup_default_style),
        context.getString(com.ludaxord.projectsup.R.string.key_sup_default_color_schema)
    )

    internal lateinit var styledAttributes: StyledAttributes

    internal lateinit var webClient: AbstractSupWebViewClient

    internal lateinit var attrs: AttributeSet

    internal var languageName: String = context.resources.getString(com.ludaxord.projectsup.R.string.language_option_en)

    internal lateinit var theme: Theme

    internal lateinit var color: Color

    private var allowedUrls: ArrayList<String> = ArrayList()

    protected constructor(
        context: Context,
        res: Pair<String, String>,
        language: String,
        webClient: AbstractSupWebViewClient,
        allowedUrls: ArrayList<String> = ArrayList()
    ) : super(context) {
        Log.i(Defaults.TAG, "Web Chicago")
        this.res = res
        this.languageName = language
        this.allowedUrls = allowedUrls
        this.webClient = webClient
        setInitializer()
    }

    protected constructor(
        context: Context,
        attrs: AttributeSet,
        res: Pair<String, String>,
        language: String,
        webClient: AbstractSupWebViewClient,
        allowedUrls: ArrayList<String> = ArrayList()
    ) : super(
        context,
        attrs
    ) {
        Log.i(Defaults.TAG, "Web NRG")
        this.attrs = attrs
        this.res = res
        this.languageName = language
        this.allowedUrls = allowedUrls
        this.webClient = webClient
        setInitializer()
    }

    protected constructor(
        context: Context,
        attrs: AttributeSet,
        defStyleAttr: Int,
        res: Pair<String, String>,
        language: String,
        webClient: AbstractSupWebViewClient,
        allowedUrls: ArrayList<String> = ArrayList()
    ) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        Log.i(Defaults.TAG, "Web UNC")
        this.attrs = attrs
        this.res = res
        this.languageName = language
        this.allowedUrls = allowedUrls
        this.webClient = webClient
        setInitializer()
    }

    constructor(context: Context) : this(
        context,
        Pair(
            context.getString(com.ludaxord.projectsup.R.string.key_sup_default_style),
            context.getString(com.ludaxord.projectsup.R.string.key_sup_default_color_schema)
        ),
        context.resources.getString(com.ludaxord.projectsup.R.string.language_option_en),
        SupWebViewClient(
            context, ArrayList(),
            Pair(
                context.getString(com.ludaxord.projectsup.R.string.key_sup_default_style),
                context.getString(com.ludaxord.projectsup.R.string.key_sup_default_color_schema)
            )
        )
    )

    constructor(context: Context, attrs: AttributeSet) : this(
        context,
        attrs,
        Pair(
            context.getString(com.ludaxord.projectsup.R.string.key_sup_default_style),
            context.getString(com.ludaxord.projectsup.R.string.key_sup_default_color_schema)
        ),
        context.resources.getString(com.ludaxord.projectsup.R.string.language_option_en),
        SupWebViewClient(
            context, ArrayList(),
            Pair(
                context.getString(com.ludaxord.projectsup.R.string.key_sup_default_style),
                context.getString(com.ludaxord.projectsup.R.string.key_sup_default_color_schema)
            )
        )
    )

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : this(
        context,
        attrs,
        defStyleAttr,
        Pair(
            context.getString(com.ludaxord.projectsup.R.string.key_sup_default_style),
            context.getString(com.ludaxord.projectsup.R.string.key_sup_default_color_schema)
        ),
        context.resources.getString(com.ludaxord.projectsup.R.string.language_option_en),
        SupWebViewClient(
            context, ArrayList(),
            Pair(
                context.getString(com.ludaxord.projectsup.R.string.key_sup_default_style),
                context.getString(com.ludaxord.projectsup.R.string.key_sup_default_color_schema)
            )
        )
    )

    internal open fun setDefaultViewUtils() {
        styledAttributes = setViewUtilsFromStyledAttributes(context, attrs)
        enableFullSettings()
        setTheme(res.first)
        setColorSchema(res.second)
        setWebClient(webClient)
    }

    override fun loadUrl(url: String?) {
        var u = url
        url?.let {
            if (!url.startsWith("https://") || !url.startsWith("http://")) {
                u = "https://$url"
            }
        }
        super.loadUrl(u)
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun enableFullSettings() {
        this.settings.javaScriptEnabled = true
        this.settings.domStorageEnabled = true
        this.settings.loadWithOverviewMode = true
        this.settings.useWideViewPort = true
        this.settings.builtInZoomControls = true
        this.settings.displayZoomControls = false
        this.settings.setSupportZoom(true)
        this.settings.defaultTextEncodingName = "utf-8"
    }

    private fun setInitializer() {
        setDefaultViewUtils()
    }

    override fun setViewUtilsFromStyledAttributes(context: Context, attrs: AttributeSet): StyledAttributes {
        val a = getStyledAttributes(context, attrs, com.ludaxord.projectsup.R.styleable.SupWebView)

        val themeRes = getStyledAttributesString(a, com.ludaxord.projectsup.R.styleable.SupWebView_theme_res)
        val colorSchemaRes =
            getStyledAttributesString(a, com.ludaxord.projectsup.R.styleable.SupWebView_color_schema_res)
        val languageRes =
            getStyledAttributesString(a, com.ludaxord.projectsup.R.styleable.SupWebView_language_res)
        val handlerUrl =
            getStyledAttributesString(a, com.ludaxord.projectsup.R.styleable.SupWebView_handler_url_res)

        val modifiedRes = if (themeRes != null && colorSchemaRes != null) {
            Pair(themeRes, colorSchemaRes)
        } else if (themeRes != null && colorSchemaRes == null) {
            Pair(themeRes, this.res.second)
        } else if (themeRes == null && colorSchemaRes != null) {
            Pair(this.res.first, colorSchemaRes)
        } else {
            this.res
        }

        this.res = modifiedRes

        if (languageRes != null) {
            this.languageName = languageRes
        }

        val handlerUri = if (handlerUrl != null) {
            Uri.parse(handlerUrl)
        } else {
            null
        }

        a.recycle()

        return SupWebStyledAttributes(
            themeRes,
            colorSchemaRes,
            languageRes,
            handlerUri
        )
    }

    override fun setWebClient(webClient: AbstractSupWebViewClient) {
        this.webClient = webClient
        this.webViewClient = webClient
    }

    override fun getWebClient(): AbstractSupWebViewClient {
        return webClient
    }

    override fun getColorSchema(): Color {
        return color
    }

    override fun setColorSchema(colorRes: Int) {
        val r = colorRes.getResourceFromInt(context) { r, c -> c.getString(r) }
        color = ColorSchemaUtils.getColorSchema(context, r)
    }

    override fun setTheme(themeRes: Int) {
        val r = themeRes.getResourceFromInt(context) { r, c -> c.getString(r) }
        theme = ThemeUtils.getTheme(context, r)
    }

    override fun setColorSchema(colorRes: String) {
        color = if (styledAttributes.themeRes != null && styledAttributes.colorSchemaRes == null) {
            getTheme().getThemeColorSchema(context)
        } else {
            ColorSchemaUtils.getColorSchema(context, colorRes)
        }
    }

    override fun setTheme(themeRes: String) {
        theme = ThemeUtils.getTheme(context, themeRes)
    }

    override fun getTheme(): Theme {
        return theme
    }

    override fun setAllowedUrls(urls: ArrayList<String>) {
        this.allowedUrls = urls
        this.allowedUrls.refactorUrls()
        this.webClient.allowedUrls = this.allowedUrls
    }

    override fun getAllowedUrls(): ArrayList<String> {
        return allowedUrls
    }

    override fun addAllowedUrls(urls: ArrayList<String>) {
        this.allowedUrls.addAll(urls)
        this.webClient.allowedUrls = this.allowedUrls
    }

    override fun setHandlerActivity(activity: Activity) {
        this.webClient.handlerActivity = activity
    }

    override fun getHandlerActivity(): Activity {
        return this.webClient.handlerActivity
    }

    override fun setHandlerDialogAlert(alertDialog: AlertDialog) {
        this.webClient.handlerAlertDialog = alertDialog
    }

    override fun setHandlerDialogAlertMessage(alertDialogMessage: String) {
        this.webClient.handlerAlertDialogMessage = alertDialogMessage
    }

    override fun getHandlerDialogAlert(): AlertDialog {
        return this.webClient.handlerAlertDialog
    }
}