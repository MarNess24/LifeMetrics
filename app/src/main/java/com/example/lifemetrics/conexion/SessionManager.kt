package com.example.lifemetrics.conexion

import android.content.Context
import android.content.SharedPreferences

class SessionManager(context: Context) {
    private val prefs: SharedPreferences = context.getSharedPreferences("AppPreferences", Context.MODE_PRIVATE)

    companion object {
        private const val TOKEN_KEY = "token"
    }

    fun saveToken(token: String) {
        prefs.edit().putString(TOKEN_KEY, token).apply()
    }

    fun getToken(): String? {
        return prefs.getString(TOKEN_KEY, null)
    }

    fun clearSession() {
        prefs.edit().remove(TOKEN_KEY).apply()
    }
}