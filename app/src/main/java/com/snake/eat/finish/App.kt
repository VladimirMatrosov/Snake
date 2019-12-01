package com.snake.eat.finish

import android.app.Application
import android.arch.persistence.room.Room
import com.onesignal.OneSignal
import com.snake.eat.finish.model.ResultDb
import com.yandex.metrica.YandexMetrica
import com.yandex.metrica.YandexMetricaConfig

class App: Application() {

    companion object {
        var resultDb: ResultDb? = null
    }

    override fun onCreate() {
        super.onCreate()

        OneSignal.startInit(this)
            .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification)
            .unsubscribeWhenNotificationsAreDisabled(true)
            .init()

        val configBuilder = YandexMetricaConfig.newConfigBuilder("c87b17de-59cf-4650-b65a-079b77fefe03")
        YandexMetrica.activate(applicationContext, configBuilder.build())
        YandexMetrica.enableActivityAutoTracking(this)

        resultDb = Room.databaseBuilder(this, ResultDb::class.java, "Results").allowMainThreadQueries().build()
    }
}