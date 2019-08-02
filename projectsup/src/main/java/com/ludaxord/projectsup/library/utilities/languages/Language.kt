package com.ludaxord.projectsup.library.utilities.languages

abstract class Language {

    abstract val languageName: String

    abstract fun getLanguageCredentials(): HashMap<String, String>

    abstract fun getFullDayNames(): HashMap<String, String>

    abstract fun getShortDayNames(): HashMap<String, String>

}