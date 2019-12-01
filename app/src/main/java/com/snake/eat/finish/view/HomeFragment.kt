package com.snake.eat.finish.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.snake.eat.finish.R
import com.snake.eat.finish.contract.IHomeContract
import com.snake.eat.finish.presenter.HomePresenter
import com.yandex.metrica.YandexMetrica
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment: Fragment(), IHomeContract.View {

    private lateinit var mPresenter: IHomeContract.Presenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        YandexMetrica.reportEvent("winning_snake_2311: show adv")

        mPresenter = HomePresenter(this)
        iv_home_leaders_btn.setOnClickListener {
            mPresenter.openLeaderboards()
        }
        iv_home_play_btn.setOnClickListener {
            mPresenter.play()
        }
    }

    override fun showGame() {
        activity!!.supportFragmentManager.beginTransaction().replace(R.id.fl_main_frames, GameFragment()).commit()
    }

    override fun showLeaders() {
        activity!!.supportFragmentManager.beginTransaction().replace(R.id.fl_main_frames, LeaderboardFragment()).commit()
    }
}