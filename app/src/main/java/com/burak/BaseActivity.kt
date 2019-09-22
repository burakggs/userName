package com.burak

import android.app.Activity
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity : AppCompatActivity() {

    private var dialog: Dialog? = null


    protected fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    open fun showProgressDialog() {

        dialog?.dismiss()
        dialog = AppDialog(this)
        dialog?.show()
    }

    open fun hideProgressDialog() {
        dialog?.let {
            it.dismiss()
            dialog = null
        }

    }

    fun openActivity(activityClazz: Class<out Activity>) {
        val mainIntent = Intent(this, activityClazz)
        this.startActivity(mainIntent)
    }

    fun openActivity(activityClazz: Class<out Activity>, bundle: Bundle) {
        val mainIntent = Intent(this, activityClazz)
        mainIntent.putExtras(bundle)
        this.startActivity(mainIntent)
    }

}