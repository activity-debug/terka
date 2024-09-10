package com.rendrapcx.terka.model

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

interface IUserAnswerRandom {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertRandom(userAnswerRandom: Data.UserAnswerRandom)

    @Query("DELETE FROM user_answer_random")
    suspend fun deleteAllRandom()

    @Query("SELECT * FROM user_answer_random")
    suspend fun getAllAnswerRandom(): MutableList<Data.UserAnswerRandom>

    @Query("SELECT * FROM user_answer_random WHERE level_id = :levelId;")
    suspend fun getAnswerRandom(levelId: String): MutableList<Data.UserAnswerRandom>

    @Query(value = "DELETE FROM user_answer_random WHERE level_id = :levelId;")
    suspend fun deleteAnswerRandomById(levelId: String)

}
