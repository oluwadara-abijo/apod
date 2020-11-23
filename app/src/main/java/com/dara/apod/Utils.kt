package com.dara.apod

import android.content.Context

fun Context.readJsonFile(fileName: String): String {
    return assets.open(fileName).bufferedReader().use { it.readText() }
}