package com.snake.eat.finish.contract

interface ISaveContract {

    interface View{
        fun getScores(): Int
        fun getName(): String
        fun showLeaders()
        fun showScores(scores: Int)
        fun showInputError()
    }

    interface Presenter{
        fun frOnCreated()
        fun saveResult()
    }
}