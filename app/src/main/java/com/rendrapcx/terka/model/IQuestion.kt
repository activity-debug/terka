package com.rendrapcx.terka.model

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

interface IQuestion {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQuestion(question: Data.Question)

    @Query("SELECT * FROM question WHERE level_id = :levelId;")
    suspend fun getQuestion(levelId: String): MutableList<Data.Question>

    @Query("DELETE FROM question WHERE level_id = :levelId;")
    suspend fun deleteQuestionByLevelId(levelId: String)
}
