package com.burak

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatDialog

class AppDialog (context: Context, theme: Int = R.style.DialogTheme) : AppCompatDialog(context, theme) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_loading)

        setCancelable(false)
        setCanceledOnTouchOutside(false)

    }


}