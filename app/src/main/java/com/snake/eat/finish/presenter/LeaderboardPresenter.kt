package com.snake.eat.finish.presenter

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.snake.eat.finish.R
import com.snake.eat.finish.contract.ILeaderboardContract
import com.snake.eat.finish.model.LeaderboardModel
import kotlinx.android.synthetic.main.item_leader.view.*

class LeaderboardPresenter(val mView: ILeaderboardContract.View) : ILeaderboardContract.Presenter {

    private val mModel = LeaderboardModel()

    override fun goBack() {
        mView.showHome()
    }

    override fun initLeadersRv(recyclerView: RecyclerView, context: Context) {
        val mLeaders = mModel.getLeaders()
        if (mLeaders.isEmpty())
            mView.showEmptyMessage()
        else {
            recyclerView.layoutManager = LinearLayoutManager(context)
            recyclerView.adapter = object : RecyclerView.Adapter<LeaderHolder>() {
                override fun onCreateViewHolder(p0: ViewGroup, p1: Int): LeaderHolder {
                    return LeaderHolder(LayoutInflater.from(context).inflate(R.layout.item_leader, p0, false))
                }

                override fun getItemCount(): Int {
                    return mLeaders.size
                }

                override fun onBindViewHolder(p0: LeaderHolder, p1: Int) {
                    p0.setNumber(p1 + 1)
                    p0.setName(mLeaders[p1].name)
                    p0.setScores(mLeaders[p1].scores)
                }
            }
        }
    }

    private inner class LeaderHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val mImageNumber = itemView.iv_leader_number_image
        private val mTextNumber = itemView.tv_leader_number_text
        private val mName = itemView.tv_leader_name
        private val mScores = itemView.tv_leader_scores

        fun setNumber(number: Int) {
            when (number) {
                1 -> {
                    mTextNumber.visibility = View.GONE
                    mImageNumber.setImageResource(R.drawable.group_92)
                }
                2 -> {
                    mTextNumber.visibility = View.GONE
                    mImageNumber.setImageResource(R.drawable.group_93)
                }
                3 -> {
                    mTextNumber.visibility = View.GONE
                    mImageNumber.setImageResource(R.drawable.group_94)
                }
                else -> {
                    mImageNumber.visibility = View.GONE
                    mTextNumber.text = number.toString()

                }
            }
        }

        fun setName(name: String) {
            mName.text = name
        }

        fun setScores(scores: Int) {
            mScores.text = scores.toString()
        }
    }
}
