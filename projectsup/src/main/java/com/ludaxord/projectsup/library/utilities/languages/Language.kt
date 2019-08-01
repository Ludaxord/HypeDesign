package com.ludaxord.projectsup.library.utilities.languages

import android.content.res.Resources

abstract class Language {

    abstract val languageName: String

    protected val resources: Resources = Resources.getSystem()

    abstract fun getLanguageCredentials(): HashMap<String, String>

    abstract fun getFullDayNames(): HashMap<String, String>

    abstract fun getShortDayNames(): HashMap<String, String>

}