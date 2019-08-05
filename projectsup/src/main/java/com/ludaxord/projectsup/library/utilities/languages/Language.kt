package com.ludaxord.projectsup.library.utilities.languages

import android.content.Context

abstract class Language(val context: Context) {

    abstract val languageName: String

    abstract fun getLanguageCredentials(): HashMap<String, String>

    abstract fun getFullDayNames(): HashMap<String, String>

    abstract fun getShortDayNames(): HashMap<String, String>

}