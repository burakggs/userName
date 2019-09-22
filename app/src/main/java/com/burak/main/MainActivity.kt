package com.burak.main

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.burak.BaseActivity
import com.burak.R
import com.burak.data.disk.Prefs
import com.burak.databinding.ActivityMainBinding
import com.burak.detail.RepoDetailActivity
import com.burak.main.MainContract.Presenter
import com.burak.main.adapter.MainAdapter
import com.burak.model.uiobject.UserRepoUIObject

class MainActivity : BaseActivity(), MainContract.View, MainAdapter.MainAdapterListener {

    companion object {
        const val KEY_ITEM = "KEY_ITEM"
    }

    private lateinit var presenter: Presenter
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainPresenter(this)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val layoutManager = LinearLayoutManager(this)
        binding.recyclerViewRepoList.layoutManager = layoutManager

        binding.btnSubmit.setOnClickListener {
            presenter.getUserRepos(binding.etUserName.text.toString())

        }
    }

    override fun showUserRepoList(userRepoList: List<UserRepoUIObject>?) {
        binding.recyclerViewRepoList.adapter = MainAdapter(userRepoList, this)
    }

    override fun setPresenter(presenter: Presenter) {
        this.presenter = presenter
    }

    override fun showProgress() {
        showProgressDialog()
    }

    override fun hideProgress() {
        hideProgressDialog()
    }

    override fun showEmptyString() {
        binding.etUserName.error = getString(R.string.warning_empty_string)
    }

    override fun showWrongCharacter() {
        binding.etUserName.error = getString(R.string.warning_english_character)
    }

    override fun onFailure(message: String) {
        showToast(message)
    }

    override fun onClick(userRepoUIObject: UserRepoUIObject) {
        val intent = Intent(this, RepoDetailActivity::class.java)
        intent.putExtra(KEY_ITEM, userRepoUIObject)
        this.startActivityForResult(intent, 100)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            presenter.getUserRepos(binding.etUserName.text.toString())

        }
    }
}
