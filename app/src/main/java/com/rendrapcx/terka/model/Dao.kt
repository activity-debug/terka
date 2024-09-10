package com.rendrapcx.terka.model

import androidx.room.Dao

class Dao {
    @Dao
    interface Level : ILevel

    @Dao
    interface Question : IQuestion

    @Dao
    interface UserAnswerTerka : IUserAnswerTerka

    @Dao
    interface UserAnswerSlot : IUserAnswerSlot

    @Dao
    interface UserAnswerRandom : IUserAnswerRandom

    @Dao
    interface UserPreferences : IUserPreferences

}

