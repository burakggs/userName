package com.burak.main

import android.text.TextUtils
import com.burak.data.disk.Prefs
import com.burak.model.response.UserRepo
import com.burak.model.uiobject.UserRepoUIObject
import com.burak.network.ApiService
import retrofit2.Call
import retrofit2.Response
import java.util.regex.Pattern

class MainPresenter(val view: MainContract.View) : MainContract.Presenter {

    init {
        view.setPresenter(this)
    }

    override fun getUserRepos(userName: String) {

        if (TextUtils.isEmpty(userName)) {
            view.showEmptyString()
            return
        }
        val regex = "^[a-zA-Z0-9-`.+]+$"
        val pattern = Pattern.compile(regex)
        val matcher = pattern.matcher(userName)

        if (!matcher.matches()) {
            view.showWrongCharacter()
            return
        }

        view.showProgress()
        val response = ApiService.apiCall().getUserRepos(userName)
        response.enqueue(object : retrofit2.Callback<List<UserRepo>> {
            override fun onFailure(call: Call<List<UserRepo>>, t: Throwable) {
                view.hideProgress()
                view.onFailure(t.message.toString())
            }

            override fun onResponse(call: Call<List<UserRepo>>, response: Response<List<UserRepo>>) {
                view.hideProgress()
                if (response.isSuccessful) {
                    view.showUserRepoList(generateUIObject(response.body()))

                } else {
                    view.onFailure("response not successful")
                }

            }

        })
    }

    private fun generateUIObject(userRepoList: List<UserRepo>?): List<UserRepoUIObject> {
        val favoritedList = Prefs.getFavoriteRepoList()

        val uiObjects = mutableListOf<UserRepoUIObject>()
        for (userRepo in userRepoList!!) {
            val userRepoUIObj = UserRepoUIObject(userRepo)
            if (favoritedList != null && favoritedList.toMutableList().contains(userRepo.id)) {
                userRepoUIObj.isFavorite = true
            }
            uiObjects.add(userRepoUIObj)
        }
        return uiObjects
    }
}