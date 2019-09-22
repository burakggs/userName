package com.burak.detail

import com.burak.data.disk.Prefs


class RepoDetailPresenter(val view: RepoDetailContract.View) : RepoDetailContract.Presenter {

    init {
        view.setPresenter(this)
    }

    override fun updateRepoFavorite(repoId: Long) {
        Prefs.handleFavoriteRepoList(repoId)
    }


}