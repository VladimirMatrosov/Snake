package com.snake.eat.finish.model

import android.content.Context

class OneSignalTools {
    companion object {
        const val SP_INSTALL_ID = "installation_id"

        fun getFakePlayerId(context: Context) = context.getSharedPreferences("ids", Context.MODE_PRIVATE).getString(SP_INSTALL_ID, "")

        fun addParams(url: String, context: Context): String {
            return url + if (url.contains("?")) "&" else "?" + "installation_id=${(getFakePlayerId(context))}"
        }
    }

}