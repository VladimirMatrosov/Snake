package com.snake.eat.finish.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.snake.eat.finish.R
import com.snake.eat.finish.contract.IGameContract
import com.snake.eat.finish.presenter.GamePresenter
import kotlinx.android.synthetic.main.fragment_game.*

class GameFragment : Fragment(), IGameContract.View {

    private lateinit var mPresenter: IGameContract.Presenter
    private var isRunningGame = true

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_game, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sv_game_main.initSnake(this)

        mPresenter = GamePresenter(this)
        mPresenter.frOnCreated()

        iv_game_bottom.setOnClickListener {
            mPresenter.bottom()
        }
        iv_game_left.setOnClickListener {
            mPresenter.left()
        }
        iv_game_top.setOnClickListener {
            mPresenter.top()
        }
        iv_game_right.setOnClickListener {
            mPresenter.right()
        }

        tv_game_stop_btn.setOnClickListener {
            if (isRunningGame) {
                tv_game_stop_btn.text = "start"
                sv_game_main.pause()
            } else {
                tv_game_stop_btn.text = "pause"
                sv_game_main.invalidate()
            }
            isRunningGame = !isRunningGame
        }
    }

    override fun showScores(scores: Int) {
        tv_game_result.text = "Your scores: $scores"
    }

    override fun showResult(scores: Int) {
        sv_game_main.pause()
        activity!!.supportFragmentManager.beginTransaction().replace(R.id.fl_main_frames, ResultFragment.newInstance(scores)).commit()
    }

    override fun showMessageExit() {

    }

    override fun pauseGame() {
        sv_game_main.pause()
    }

    override fun goRight() {
        sv_game_main.setDirection(SnakeView.RIGHT_DIRECTION)
    }

    override fun goLeft() {
        sv_game_main.setDirection(SnakeView.LEFT_DIRECTION)
    }

    override fun goTop() {
        sv_game_main.setDirection(SnakeView.TOP_DIRECTION)
    }

    override fun goBottom() {
        sv_game_main.setDirection(SnakeView.BOTTOM_DIRECTION)
    }
}