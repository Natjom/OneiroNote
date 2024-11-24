package com.example.oneironote.utils

import android.content.Context

private const val ALARM_PREFS = "alarm_preferences"
private const val ALARM_KEY = "alarms"

/**
 * Enregistre une liste d'alarmes dans les SharedPreferences.
 *
 * @param context Le contexte Android nécessaire pour accéder aux SharedPreferences.
 * @param alarms La liste d'alarmes à sauvegarder.
 */
fun saveAlarms(context: Context, alarms: List<String>) {
    val prefs = context.getSharedPreferences(ALARM_PREFS, Context.MODE_PRIVATE)
    prefs.edit().putStringSet(ALARM_KEY, alarms.toSet()).apply()
}

/**
 * Charge une liste d'alarmes depuis les SharedPreferences.
 *
 * @param context Le contexte Android nécessaire pour accéder aux SharedPreferences.
 * @return La liste des alarmes sauvegardées ou une liste vide si aucune n'existe.
 */
fun loadAlarms(context: Context): List<String> {
    val prefs = context.getSharedPreferences(ALARM_PREFS, Context.MODE_PRIVATE)
    return prefs.getStringSet(ALARM_KEY, emptySet())?.toList() ?: emptyList()
}
