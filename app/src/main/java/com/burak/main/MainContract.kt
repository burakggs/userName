package com.burak.main

import com.burak.BasePresenter
import com.burak.BaseView
import com.burak.model.response.UserRepo
import com.burak.model.uiobject.UserRepoUIObject

interface MainContract {
    interface View : BaseView<Presenter> {
        fun showUserRepoList(userRepoList: List<UserRepoUIObject>?)
        fun showEmptyString()
        fun showWrongCharacter()
    }

    interface Presenter : BasePresenter {
        fun getUserRepos(userName: String)
    }
}