package com.burak.model.response

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class RepoOwner(@SerializedName("login") var userName: String? = null, @SerializedName("avatar_url") var avatarUrl: String? = null) : Serializable