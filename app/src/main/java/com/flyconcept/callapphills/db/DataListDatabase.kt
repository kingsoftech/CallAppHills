package com.flyconcept.callapphills.db

import android.content.Context
import androidx.room.*
import com.flyconcept.callapphills.ColorListArrayTypeConverter
import com.flyconcept.callapphills.DataList

@Database(entities = [DataList::class], version = 1, exportSchema = false)
@TypeConverters(ColorListArrayTypeConverter::class)
public abstract class DataListDatabase : RoomDatabase() {

    abstract fun DataListDao(): DataListDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: DataListDatabase? = null

        fun getDatabase(context: Context): DataListDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DataListDatabase::class.java,
                    "list_of_color"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}