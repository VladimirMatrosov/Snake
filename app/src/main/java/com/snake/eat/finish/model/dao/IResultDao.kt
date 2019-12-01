package com.snake.eat.finish.model.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.snake.eat.finish.model.entity.Result

@Dao
interface IResultDao {

    @Insert
    fun insert(result: Result)

    @Query("SELECT * FROM Result ORDER BY scores DESC")
    fun getResults(): List<Result>
}