package com.snake.eat.finish.presenter

import com.snake.eat.finish.contract.IHomeContract

class HomePresenter(val mView: IHomeContract.View): IHomeContract.Presenter {

    override fun play() {
        mView.showGame()
    }

    override fun openLeaderboards() {
        mView.showLeaders()
    }
}