package com.burak.model.uiobject

import com.burak.model.response.UserRepo
import java.io.Serializable

class UserRepoUIObject(val userRepo: UserRepo) : Serializable {
    var isFavorite: Boolean = false
}