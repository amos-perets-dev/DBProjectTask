package com.example.dbprojecttask.db

import androidx.room.TypeConverter
import com.example.dbprojecttask.data.ImageData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
class Converters {
    val gson = Gson()

    @TypeConverter
    fun imagesFromString(value: String?): MutableList<ImageData> {

        val listType = object : TypeToken<MutableList<String?>>() {}.type
        return gson.fromJson(value, listType)
    }

    @TypeConverter
    fun imagesFromList(list: MutableList<ImageData>): String? {
        return gson.toJson(list)
    }
}
