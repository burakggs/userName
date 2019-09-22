package com.burak.data.disk

import com.orhanobut.hawk.Hawk

object Prefs {
    private const val FAVORITED_REPO_LIST = "FAVORITED_REPO_LIST"


    fun handleFavoriteRepoList(repoId: Long) {
        var favoriteList = getFavoriteRepoList()!!.toMutableList()
        val filteredList = favoriteList.filter { it != repoId }
        if (filteredList.size == favoriteList.size) {
            favoriteList.add(repoId)

        } else {
            with(favoriteList) {
                clear()
                addAll(filteredList)
            }
        }
        Hawk.put(FAVORITED_REPO_LIST, favoriteList)

    }

    fun getFavoriteRepoList(): List<Long>? {
        return Hawk.get(FAVORITED_REPO_LIST, ArrayList())
    }

}