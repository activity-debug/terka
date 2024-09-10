package com.rendrapcx.terka.model

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

interface IUserAnswerTerka {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUserAnswerTerka(userAnswerTerka: Data.UserAnswerTerka)


    @Update
    suspend fun updateUserAnswerTerka(userAnswerTerka: Data.UserAnswerTerka)

    @Query("DELETE FROM user_answer_terka")
    suspend fun deleteAllUserAnswerTerka()

    @Query("DELETE FROm user_answer_terka WHERE level_id = :levelId")
    suspend fun deleteByLevelId(levelId: String)

    @Query("SELECT * FROM user_answer_terka")
    suspend fun getAllUserAnswerTerka(): MutableList<Data.UserAnswerTerka>

    @Query("SELECT * FROM user_answer_terka WHERE status = :status;")
    suspend fun getStatus(status: String): MutableList<Data.UserAnswerTerka>

    @Query("SELECT * FROM user_answer_terka WHERE level_id = :levelId;")
    suspend fun getLevelAnswer(levelId: String): MutableList<Data.UserAnswerTerka>

    @Query("SELECT user_answer_terka SET `status` = :status WHERE id = :id;")
    suspend fun updateStatus(id: String, status: AnswerStatus)

}
