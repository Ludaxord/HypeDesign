package com.ludaxord.projectsup.library.utilities.languages.interfaces

import android.content.Context
import android.content.res.Resources
import android.content.res.TypedArray
import android.view.View
import com.ludaxord.projectsup.R
import com.ludaxord.projectsup.library.utilities.languages.Language
import com.ludaxord.projectsup.library.utilities.languages.languageoptions.*

interface ILanguage {

    fun changeLanguage(actualLanguage: Language, newLanguage: String): Language

    fun setLanguage(language: String, context: Context): Language {
        return when (language) {
            context.resources.getString(R.string.language_option_pl) -> {
                Polish(context)
            }
            context.resources.getString(R.string.language_option_en) -> {
                English(context)
            }
            context.resources.getString(R.string.language_option_fr) -> {
                French(context)
            }
            context.resources.getString(R.string.language_option_de) -> {
                German(context)
            }
            context.resources.getString(R.string.language_option_jp) -> {
                Japanese(context)
            }
            context.resources.getString(R.string.language_option_no) -> {
                Norwegian(context)
            }
            else -> {
                English(context)
            }
        }
    }
}
