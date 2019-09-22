package com.burak

interface BaseView<in T> {

    fun setPresenter(presenter: T)
    fun showProgress()
    fun hideProgress()
    fun onFailure(message: String)

}