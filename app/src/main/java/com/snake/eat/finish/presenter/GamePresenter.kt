package com.snake.eat.finish.presenter

import com.snake.eat.finish.contract.IGameContract

class GamePresenter(val mVIew: IGameContract.View): IGameContract.Presenter {

    override fun frOnCreated() {
        mVIew.showScores(0)
    }

    override fun right() {
        mVIew.goRight()
    }

    override fun left() {
        mVIew.goLeft()
    }

    override fun top() {
        mVIew.goTop()
    }

    override fun bottom() {
        mVIew.goBottom()
    }
}