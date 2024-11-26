package com.example.oneironote.utils

import java.text.SimpleDateFormat
import java.util.*
import android.content.Context
import android.content.SharedPreferences


private const val ALARM_PREFS = "alarm_prefs"
private const val ALARM_LIST_KEY = "alarm_list_key"



fun getCurrentTime(): String {
    val sdf = SimpleDateFormat("HH:mm:ss", Locale.getDefault())
    return sdf.format(Date())
}