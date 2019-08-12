package com.ludaxord.projectsup.library.widget.webkit.webview

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import com.ludaxord.projectsup.library.utilities.Defaults
import com.ludaxord.projectsup.library.utilities.checkLanguage
import com.ludaxord.projectsup.library.utilities.colors.Color
import com.ludaxord.projectsup.library.utilities.languages.Language
import com.ludaxord.projectsup.library.utilities.themes.Theme

class SupWebView : AbstractSupWebView {

    constructor(context: Context) : super(context) {
        Log.i(Defaults.TAG, "Web ComplexCon")
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        Log.i(Defaults.TAG, "Web MCA")
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        Log.i(Defaults.TAG, "Web MoMA")
    }

    override fun changeLanguage(actualLanguage: Language, newLanguage: String): Language {
        val language = setLanguage(newLanguage, context)
        return if (language.checkLanguage(actualLanguage)) {
            languageName = newLanguage
            language
        } else {
            actualLanguage
        }
    }

}