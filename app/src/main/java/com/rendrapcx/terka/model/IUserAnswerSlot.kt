package com.rendrapcx.terka.model

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

interface IUserAnswerSlot {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertSlot(userAnswerSlot: Data.UserAnswerSlot){}

    @Query("DELETE FROM user_answer_slot")
    suspend fun deleteAllSlot()

    @Query("SELECT * FROM user_answer_slot")
    suspend fun getAllAnswerSlot(): MutableList<Data.UserAnswerSlot>

    @Query("SELECT * FROM user_answer_slot WHERE level_id = :levelId;")
    suspend fun getAnswerSlot(levelId: String): MutableList<Data.UserAnswerSlot>

    @Query(value = "DELETE FROM user_answer_slot WHERE level_id = :levelId;")
    suspend fun deleteSlotById(levelId: String)

}
