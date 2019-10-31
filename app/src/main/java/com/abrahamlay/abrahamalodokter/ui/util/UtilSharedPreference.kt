package com.abrahamlay.abrahamalodokter.ui.util

import android.content.Context
import android.content.SharedPreferences

/**
 * Created by Abraham on 05/09/2018.
 */
class UtilSharedPreference(val context: Context, val delegate: SharedPreferences) {


    private val editor: SharedPreferences.Editor = delegate.edit()

    public fun putBoolean(key: String, value: Boolean) {
        editor.putBoolean(key, value)
        editor.apply()
    }

    public fun putString(key: String, value: String) {
        editor.putString(key, value)
        editor.apply()
    }

    public fun putInt(key: String, value: Int) {
        editor.putInt(key, value)
        editor.apply()
    }

    public fun getBoolean(key: String): Boolean {
        return delegate.getBoolean(key, false)
    }

    public fun getString(key: String): String? {
        return delegate.getString(key, "")
    }

    public fun getInt(key: String): Int {
        return delegate.getInt(key, 0)
    }
}