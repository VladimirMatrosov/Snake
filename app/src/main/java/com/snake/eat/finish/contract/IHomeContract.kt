package com.snake.eat.finish.contract

interface IHomeContract {

    interface View{
        fun showGame()
        fun showLeaders()
    }

    interface Presenter{
        fun play()
        fun openLeaderboards()
    }
}