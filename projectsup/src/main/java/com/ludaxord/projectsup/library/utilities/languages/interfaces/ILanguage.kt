package com.ludaxord.projectsup.library.utilities.languages.interfaces

import android.content.res.Resources
import android.view.View
import com.ludaxord.projectsup.R
import com.ludaxord.projectsup.library.utilities.languages.Language
import com.ludaxord.projectsup.library.utilities.languages.languageoptions.*

interface ILanguage {

    fun changeLanguage(actualLanguage: Language, newLanguage: String): Language

    fun setLanguage(language: String, resources: Resources): Language {
        return when (language) {
            resources.getString(R.string.language_option_pl) -> {
                Polish()
            }
            resources.getString(R.string.language_option_en) -> {
                English()
            }
            resources.getString(R.string.language_option_fr) -> {
                French()
            }
            resources.getString(R.string.language_option_de) -> {
                German()
            }
            resources.getString(R.string.language_option_jp) -> {
                Japanese()
            }
            resources.getString(R.string.language_option_no) -> {
                Norwegian()
            }
            else -> {
                English()
            }
        }
    }
}
