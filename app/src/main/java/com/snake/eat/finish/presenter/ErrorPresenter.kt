package com.snake.eat.finish.presenter

import com.snake.eat.finish.contract.IErrorContract

class ErrorPresenter(val mView: IErrorContract.View): IErrorContract.Presenter {

    override fun goHome() {
        mView.showInfo()
    }
}