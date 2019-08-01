package com.ludaxord.projectsup.library.utilities.userpreferences

import android.content.Context
import android.preference.PreferenceManager

class UserPreferences(private val _context: Context) {

    private val preferences = PreferenceManager.getDefaultSharedPreferences(_context)
    private var editor = preferences.edit()

    fun getPreference(key: String): String? {
        val value = preferences.getString(key, "")
        return value
    }

    fun getBoolPreference(key: String): Boolean? {
        val value = preferences.getBoolean(key, false)
        return value
    }

    fun setPreference(key: String, value: String) {
        editor.putString(key, value)
        editor.apply()
    }

    fun setBoolPreference(key: String, value: Boolean) {
        editor.putBoolean(key, value)
        editor.apply()
    }

    fun clearPreferences() {
        editor.clear()
        editor.apply()
    }
}