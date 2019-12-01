package com.snake.eat.finish.model

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.snake.eat.finish.model.dao.IResultDao
import com.snake.eat.finish.model.entity.Result

@Database(entities = arrayOf(Result::class), version = 1, exportSchema = false)
abstract class ResultDb: RoomDatabase() {

    abstract fun resultDao(): IResultDao
}