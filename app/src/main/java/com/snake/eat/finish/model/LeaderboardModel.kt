package com.snake.eat.finish.model

import com.snake.eat.finish.App
import com.snake.eat.finish.model.entity.Result
import java.util.*

class LeaderboardModel {

    fun getLeaders(): ArrayList<Result>{
        return App.resultDb!!.resultDao().getResults() as ArrayList<Result>
    }

}