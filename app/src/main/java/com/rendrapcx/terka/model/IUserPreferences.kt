package com.rendrapcx.terka.model

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

interface IUserPreferences {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUserPreferences(userPreferences: Data.UserPreferences)

    @Query("SELECT * FROM user_preferences")
    suspend fun getAllUserPreferences(): MutableList<Data.UserPreferences>

    @Query(value = "UPDATE user_preferences " +
            "SET `active_filter_tab` = :activeFilterTab " +
            "WHERE id = 0;")
    suspend fun updateActiveFilterTab(activeFilterTab: FilterStatus)

    @Query(value = "UPDATE user_preferences " +
            "SET `integrated_keyboard` = :integratedKeyboard " +
            "WHERE id = 0;")
    suspend fun updateIntegratedKeyboard(integratedKeyboard: Boolean)

    @Query(value = "UPDATE user_preferences " +
            "SET `is_music` = :isMusic " +
            "WHERE id = 0;")
    suspend fun updateIsMusic(isMusic: Boolean)

    @Query(value = "UPDATE user_preferences " +
            "SET `is_sound` = :isSound " +
            "WHERE id = 0;")
    suspend fun updateIsSound(isSound: Boolean)

    @Query(value = "UPDATE user_preferences " +
            "SET `is_editor` = :isEditor " +
            "WHERE id = 0;")
    suspend fun updateIsEditor(isEditor: Boolean)

    @Query(value = "UPDATE user_preferences " +
            "SET `last_acak` = :lastAcak " +
            "WHERE id = 0;")
    suspend fun updateLastAcak(lastAcak: String)

    @Query(value = "UPDATE user_preferences " +
            "SET `koin` = :koin " +
            "WHERE id = :0;")
    suspend fun updateKoin(koin: Int)

}
