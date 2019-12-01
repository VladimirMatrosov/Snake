package com.snake.eat.finish.view

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.snake.eat.finish.R
import com.snake.eat.finish.contract.IMainContract
import com.snake.eat.finish.presenter.MainPresenter

class MainActivity : AppCompatActivity(), IMainContract.View {

    private lateinit var mPresenter: IMainContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().add(R.id.fl_main_frames, GameFragment()).commit()

        mPresenter = MainPresenter(this)
        mPresenter.acOnCreated()
    }

    override fun showStart() {
        supportFragmentManager.beginTransaction().add(R.id.fl_main_frames, HomeFragment()).commit()
    }
}
