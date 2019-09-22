package com.burak.network

import android.content.Context
import com.burak.R
import java.io.IOException

class NoConnectivityException(val context: Context) : IOException() {

    override fun getLocalizedMessage(): String? {
        return context.getString(R.string.warning_network)
    }
}