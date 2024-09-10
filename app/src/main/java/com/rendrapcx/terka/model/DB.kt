package com.rendrapcx.terka.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(
    entities = [
        Data.Level::class,
        Data.Question::class,
        Data.UserAnswerTerka::class,
        Data.UserAnswerSlot::class,
        Data.UserAnswerRandom::class,
        Data.UserPreferences::class,
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class DB : RoomDatabase() {
    abstract fun levelDao(): Dao.Level
    abstract fun questionDao(): Dao.Question
    abstract fun userAnswerTerkaDao(): Dao.UserAnswerTerka
    abstract fun userAnswerSlotDao(): Dao.UserAnswerSlot
    abstract fun userAnswerRandomDao(): Dao.UserAnswerRandom
    abstract fun userPreferencesDao(): Dao.UserPreferences

    companion object {
        @Volatile
        private var INSTANCE: DB? = null
        fun getInstance(context: Context): DB {

            var instance = INSTANCE
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    DB::class.java,
                    "db_terka"
                )
                    .createFromAsset("db_terka.db")
                    .build()
                    //.fallbackToDestructiveMigration()
                    //.build()
                    //INSTANCE = instance
            }
            return instance
        }
    }

}

