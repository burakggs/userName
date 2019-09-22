package com.burak.main.adapter

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.burak.databinding.ItemMainScreenBinding
import com.burak.model.response.UserRepo
import com.burak.model.uiobject.UserRepoUIObject

class RepoViewHolder(var binding: ItemMainScreenBinding?) : RecyclerView.ViewHolder(binding!!.root) {
    var imgStar: ImageView
    var lineView: View
    var rootView: View

    init {
        imgStar = binding!!.imgStar
        lineView = binding!!.line
        rootView = binding!!.root
    }

    fun bind(userRepo: UserRepoUIObject) {
        binding!!.item = userRepo
    }
}