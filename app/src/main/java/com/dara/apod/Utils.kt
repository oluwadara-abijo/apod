package com.dara.apod

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

fun Context.readJsonFile(fileName: String): String {
    return assets.open(fileName).bufferedReader().use { it.readText() }
}

/**
 * This converts a json string to a data class object
 * @param string - The json string to be converted
 * @return - The data class object
 */
inline fun <reified T> jsonToObject(string: String): T {
    val type: Type = object : TypeToken<T>() {}.type
    return Gson().fromJson(string, type)
}
