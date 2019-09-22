package com.burak.detail

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.burak.BaseActivity
import com.burak.databinding.ActivityRepoDetailBinding
import com.burak.main.MainActivity
import com.burak.model.uiobject.UserRepoUIObject
import android.app.Activity
import android.content.Intent
import com.burak.R


class RepoDetailActivity : BaseActivity(), RepoDetailContract.View {

    private lateinit var presenter: RepoDetailContract.Presenter
    lateinit var binding: ActivityRepoDetailBinding
    private var isFavoriteRepo: Boolean = false
    lateinit var item: UserRepoUIObject

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        RepoDetailPresenter(this)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_repo_detail)
        this.item = intent.extras!!.getSerializable(MainActivity.KEY_ITEM) as UserRepoUIObject
        binding.txtOwner.text = item.userRepo.repoOwner?.userName
        val prefix = getString(R.string.prefix_stars)
        val starCount = item.userRepo.starCount.toString()
        binding.txtStarCount.text = prefix.plus(starCount)

        val prefixOpenIssue = getString(R.string.prefix_open_issue)
        val openIssueCount = item.userRepo.open_issues.toString()
        binding.txtOpenIssue.text = prefixOpenIssue.plus(openIssueCount)

        Glide.with(this)
            .load(item.userRepo.repoOwner?.avatarUrl)
            .into(binding.imgAvatar)

        isFavoriteRepo = item.isFavorite
        binding.imgStar.isChecked = item.isFavorite

        binding.toolbar.setTitle(item.userRepo.repoName)
        binding.toolbar.setNavigationOnClickListener {
            onBackPressed()

        }
        binding.imgStar.setOnCheckedChangeListener { compoundButton, b ->
            presenter.updateRepoFavorite(item.userRepo.id!!)
        }
    }

    override fun onBackPressed() {
        if (isFavoriteRepo != binding.imgStar.isChecked) {
            val returnIntent = Intent()
            setResult(Activity.RESULT_OK, returnIntent)
            finish()
        }else{
            super.onBackPressed()
        }

    }

    override fun setPresenter(presenter: RepoDetailContract.Presenter) {
        this.presenter = presenter
    }

    override fun showProgress() {
    }

    override fun hideProgress() {
    }

    override fun onFailure(message: String) {
    }
}