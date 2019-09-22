package com.burak.detail

import com.burak.BaseView

interface RepoDetailContract {
    interface View : BaseView<Presenter> {
    }

    interface Presenter {
        fun updateRepoFavorite(repoId: Long)
    }
}