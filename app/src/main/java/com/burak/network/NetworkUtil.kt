package com.burak.network

import android.content.Context
import android.net.ConnectivityManager
import java.util.*

class NetworkUtil {

    companion object {
        fun isOnline(context: Context): Boolean {
            val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val netInfo = Objects.requireNonNull(connectivityManager).activeNetworkInfo
            return netInfo != null && netInfo.isConnected
        }
    }
}