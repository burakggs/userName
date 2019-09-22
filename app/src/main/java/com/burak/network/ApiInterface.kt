package com.burak.network

import com.burak.model.response.UserRepo
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.Call
import retrofit2.http.Headers

interface ApiInterface {

    @Headers("Content-Type: application/json")
    @GET("/users/{user}/repos")
    fun getUserRepos(
        @Path("user") userName: String
    ): Call<List<UserRepo>>
}