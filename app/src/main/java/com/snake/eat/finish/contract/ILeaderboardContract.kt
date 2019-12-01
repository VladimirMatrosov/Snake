package com.snake.eat.finish.contract

import android.content.Context
import android.support.v7.widget.RecyclerView

interface ILeaderboardContract {

    interface View{
        fun showHome()
        fun showEmptyMessage()
    }

    interface Presenter{
        fun goBack()
        fun initLeadersRv(recyclerView: RecyclerView, context: Context)
    }
}