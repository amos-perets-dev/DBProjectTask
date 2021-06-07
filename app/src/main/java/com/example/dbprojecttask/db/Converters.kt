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
//
    @TypeConverter
    fun imagesFromList(list: MutableList<ImageData>): String? {
        return gson.toJson(list)
    }
//
//    @TypeConverter
//    fun eventReminderTimesFromString(value: String?): MutableList<String> {
//        val listType = object : TypeToken<MutableList<String?>>() {}.type
//        return gson.fromJson(value, listType)
//    }
//
//    @TypeConverter
//    fun eventReminderTimesFromList(list: MutableList<String>): String? {
//        return gson.toJson(list)
//    }
//
//    @TypeConverter
//    fun scheduleEventsListFromString(value: String?): ArrayList<MainScheduleDetailsData> {
//
//        val listType = object : TypeToken<ArrayList<MainScheduleDetailsData?>>() {}.type
//        return gson.fromJson(value, listType)
//    }
//
//    @TypeConverter
//    fun scheduleEventFromList(list: MutableList<MainScheduleDetailsData>): String? {
//        return gson.toJson(list)
//    }
//
//
//    @TypeConverter
//    fun scheduleEventEntityFromString(value: String?): MutableList<ScheduleDetailsData> {
//        val listType = object : TypeToken<MutableList<ScheduleDetailsData?>>() {}.type
//        return gson.fromJson(value, listType)
//    }
//
//    @TypeConverter
//    fun scheduleEventEntityFromList(list: MutableList<ScheduleDetailsData>): String? {
//        return gson.toJson(list)
//    }
//
//
//    @TypeConverter
//    fun fromString(value: String): MutableMap<String, String> {
//        val mapType = object : TypeToken<MutableMap<String, String>>() {
//
//        }.type
//        return Gson().fromJson(value, mapType)
//    }
//
//    @TypeConverter
//    fun fromStringMap(map: MutableMap<String, String>): String {
//        val gson = Gson()
//        return gson.toJson(map)
//    }
}
