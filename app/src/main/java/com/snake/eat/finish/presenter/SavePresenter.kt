package com.snake.eat.finish.presenter

import com.snake.eat.finish.contract.ISaveContract
import com.snake.eat.finish.model.SaveModel

class SavePresenter(val mView: ISaveContract.View): ISaveContract.Presenter {

    private val mModel = SaveModel()

    override fun frOnCreated() {
        mView.showScores(mView.getScores())
    }

    override fun saveResult() {
        if (mView.getName().isEmpty())
            mView.showInputError()
        else{
            mModel.saveResult(mView.getName(), mView.getScores())
            mView.showLeaders()
        }
    }
}