package com.mustafahasturk.bczal.elprogram.utils

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.mustafahasturk.bczal.elprogram.models.Ogrenci
import java.io.IOException

object JsonUtils {
    fun loadOgrenciler(context: Context): List<Ogrenci> {
        return try {
            val jsonString = context.assets.open("sinav_programi.json")
                .bufferedReader()
                .use { it.readText() }
            
            val gson = Gson()
            val listType = object : TypeToken<List<Ogrenci>>() {}.type
            gson.fromJson(jsonString, listType)
        } catch (e: IOException) {
            e.printStackTrace()
            emptyList()
        }
    }
}

