package com.ludaxord.projectsup.library.utilities.languages.languageoptions

import android.content.Context
import com.ludaxord.projectsup.R
import com.ludaxord.projectsup.library.utilities.languages.Language

class French(context: Context) : Language(context) {

    override val languageName: String
        get() = context.resources.getString(R.string.language_option_fr)

    override fun getLanguageCredentials(): HashMap<String, String> {
        val languageMap = HashMap<String, String>()

        getFullDayNames().forEach { (t, u) -> languageMap[t] = u }
        getShortDayNames().forEach { (t, u) -> languageMap[t] = u }

        return languageMap
    }

    override fun getFullDayNames(): HashMap<String, String> {
        return hashMapOf(
            context.resources.getString(R.string.key_language_full_monday) to context.resources.getString(R.string.language_fr_full_day_name_monday),
            context.resources.getString(R.string.key_language_full_tuesday) to context.resources.getString(R.string.language_fr_full_day_name_tuesday),
            context.resources.getString(R.string.key_language_full_wednesday) to context.resources.getString(R.string.language_fr_full_day_name_wednesday),
            context.resources.getString(R.string.key_language_full_thursday) to context.resources.getString(R.string.language_fr_full_day_name_thursday),
            context.resources.getString(R.string.key_language_full_friday) to context.resources.getString(R.string.language_fr_full_day_name_friday),
            context.resources.getString(R.string.key_language_full_saturday) to context.resources.getString(R.string.language_fr_full_day_name_saturday),
            context.resources.getString(R.string.key_language_full_sunday) to context.resources.getString(R.string.language_fr_full_day_name_sunday)
        )
    }

    override fun getShortDayNames(): HashMap<String, String> {
        return hashMapOf(
            context.resources.getString(R.string.key_language_short_monday) to context.resources.getString(R.string.language_fr_short_day_name_monday),
            context.resources.getString(R.string.key_language_short_tuesday) to context.resources.getString(R.string.language_fr_short_day_name_tuesday),
            context.resources.getString(R.string.key_language_short_wednesday) to context.resources.getString(R.string.language_fr_short_day_name_wednesday),
            context.resources.getString(R.string.key_language_short_thursday) to context.resources.getString(R.string.language_fr_short_day_name_thursday),
            context.resources.getString(R.string.key_language_short_friday) to context.resources.getString(R.string.language_fr_short_day_name_friday),
            context.resources.getString(R.string.key_language_short_saturday) to context.resources.getString(R.string.language_fr_short_day_name_saturday),
            context.resources.getString(R.string.key_language_short_sunday) to context.resources.getString(R.string.language_fr_short_day_name_sunday)
        )
    }
}