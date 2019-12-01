package com.snake.eat.finish.contract

interface IErrorContract {

    interface View{
        fun showInfo()
    }

    interface Presenter{
        fun goHome()
    }
}