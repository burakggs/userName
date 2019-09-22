package com.burak.model.response

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class UserRepo(
    var id: Long?,
    @SerializedName("name") var repoName: String? = null, @SerializedName("stargazers_count") var starCount: Int, @SerializedName(
        "owner"
    ) var repoOwner: RepoOwner?, var open_issues: Long?
) : Serializable