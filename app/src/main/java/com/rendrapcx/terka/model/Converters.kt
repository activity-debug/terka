package com.rendrapcx.terka.model

import androidx.room.TypeConverters
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class Converters {

    @TypeConverters
    fun fromStringToListInt(value: String): ArrayList<Int> {
        val listType: Type = object : TypeToken<ArrayList<Int?>?>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverters
    fun fromStringToListString(value: String?): ArrayList<String> {
        val listType: Type = object : TypeToken<ArrayList<String?>?>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverters
    fun fromListIntToString(list: ArrayList<Int?>?): String {
        val gson = Gson()
        return gson.toJson(list)
    }

    @TypeConverters
    fun fromListStringToString(list: ArrayList<String?>?): String {
        val gson = Gson()
        return gson.toJson(list)
    }

    @TypeConverters
    fun fromMapListIntToString(list: MutableMap<Int, String>?): String {
        val gson = Gson()
        return gson.toJson(list)
    }

}
