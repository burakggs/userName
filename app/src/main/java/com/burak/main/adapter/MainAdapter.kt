package com.burak.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.burak.R
import com.burak.databinding.ItemMainScreenBinding
import com.burak.model.uiobject.UserRepoUIObject

class MainAdapter(val userRepoList: List<UserRepoUIObject>?, var listener: MainAdapterListener) :
    RecyclerView.Adapter<RepoViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        val binding = DataBindingUtil.inflate<ItemMainScreenBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_main_screen,
            parent,
            false
        )
        val holder = RepoViewHolder(binding)
        return holder
    }

    override fun getItemCount(): Int {
        return userRepoList!!.size
    }

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        holder.bind(userRepoList!!.get(position))
        if (position == userRepoList.size - 1) {
            holder.lineView.visibility = View.GONE
        }
        holder.rootView.setOnClickListener {
            listener.onClick(userRepoList.get(position))

        }
    }

    interface MainAdapterListener {
        fun onClick(userRepoUIObject: UserRepoUIObject)
    }
}