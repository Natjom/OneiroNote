package com.example.oneironote.utils

import android.content.Context

private const val ALARM_PREFS = "alarm_preferences"
private const val ALARM_KEY = "alarms"

fun saveAlarms(context: Context, alarms: List<String>) {
    val prefs = context.getSharedPreferences(ALARM_PREFS, Context.MODE_PRIVATE)
    prefs.edit().putStringSet(ALARM_KEY, alarms.toSet()).apply()
}

fun loadAlarms(context: Context): List<String> {
    val prefs = context.getSharedPreferences(ALARM_PREFS, Context.MODE_PRIVATE)
    return prefs.getStringSet(ALARM_KEY, emptySet())?.toList() ?: emptyList()
}