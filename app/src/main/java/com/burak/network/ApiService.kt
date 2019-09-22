package com.burak.network

import retrofit2.Retrofit


object ApiService {
    const val BASE_URL = "https://api.github.com"

    fun apiCall() = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(ApiWorker.gsonConverter)
        .client(ApiWorker.client)
        .build()
        .create(ApiInterface::class.java)
}