package com.snake.eat.finish.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.snake.eat.finish.R
import com.snake.eat.finish.contract.ILeaderboardContract
import com.snake.eat.finish.presenter.LeaderboardPresenter
import kotlinx.android.synthetic.main.fragment_leaderboard.*

class LeaderboardFragment: Fragment(), ILeaderboardContract.View {

    private lateinit var mPresenter: ILeaderboardContract.Presenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_leaderboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mPresenter = LeaderboardPresenter(this)
        mPresenter.initLeadersRv(rv_leaders, activity!!.applicationContext)
        iv_leader_back_btn.setOnClickListener {
            mPresenter.goBack()
        }
    }

    override fun showHome() {
        activity!!.supportFragmentManager.beginTransaction().replace(R.id.fl_main_frames, HomeFragment()).commit()
    }

    override fun showEmptyMessage() {
        tv_leader_empty_message.visibility = View.VISIBLE
    }
}