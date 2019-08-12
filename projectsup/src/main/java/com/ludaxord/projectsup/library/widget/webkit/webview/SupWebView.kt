package com.ludaxord.projectsup.library.widget.webkit.webview

import android.content.Context
import android.util.AttributeSet
import com.ludaxord.projectsup.library.utilities.colors.Color
import com.ludaxord.projectsup.library.utilities.languages.Language
import com.ludaxord.projectsup.library.utilities.themes.Theme

class SupWebView : AbstractSupWebView {

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun changeLanguage(actualLanguage: Language, newLanguage: String): Language {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}