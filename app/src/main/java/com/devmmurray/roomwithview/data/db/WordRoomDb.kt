package com.devmmurray.roomwithview.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.devmmurray.roomwithview.data.model.Word

@Database(entities = [Word::class], version = 1, exportSchema = false)
abstract class WordRoomDb: RoomDatabase() {

    abstract fun wordDao(): WordDAO

    companion object {
        @Volatile
        private var INSTANCE: WordRoomDb? = null

        fun getDatabase(context: Context): WordRoomDb {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    WordRoomDb::class.java,
                    "word_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}