package com.example.dbprojecttask.db.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.dbprojecttask.data.ImageData
import com.example.dbprojecttask.db.Converters
import com.example.dbprojecttask.db.room.dao.ImagesDao


const val DATABASE = "Database-Room"

@Database(
    entities = [ImageData::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)

abstract class AppDatabase : RoomDatabase(){

    abstract val imageDao: ImagesDao?

    override fun clearAllTables() {

    }

//    override fun getDatabase(context: Context): AppDatabase {
//            return Room.databaseBuilder(
//                context.applicationContext,
//                AppDatabase::class.java,
//                DATABASE
//            )
//                .fallbackToDestructiveMigration()
//                .build()
//    }

}