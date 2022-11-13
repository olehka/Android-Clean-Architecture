package com.olehka.cleanandroid.core.util

import java.text.SimpleDateFormat
import java.util.*

private val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.US)

fun getDateFormatted(minusDays: Int): String {
    val calendar = Calendar.getInstance().apply { add(Calendar.DAY_OF_YEAR, -minusDays) }
    return dateFormat.format(calendar.time)
}
