package com.olehka.cleanandroid.core.extension

import java.util.Calendar
import java.util.Date

fun Calendar.minusDays(days: Int): Date {
    val calendar = Calendar.getInstance()
    calendar.timeInMillis = this.timeInMillis
    calendar.add(Calendar.DAY_OF_YEAR, -days)
    return calendar.time
}
