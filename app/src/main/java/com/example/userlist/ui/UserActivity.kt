package com.example.userlist.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.userlist.data.remote.model.UserRemote
import com.example.userlist.databinding.UserListDataBinding
import com.example.userlist.ui.adapters.UserListAdapter
import com.example.userlist.viewmodels.UserViewModel
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class UserActivity : BaseActivity() {

    lateinit var userViewModel: UserViewModel
    lateinit var userListActivityBinding: UserListDataBinding

    @Inject
    lateinit var userListViewModelFactory: UserViewModel.UserListViewModelFactory

    @Inject
    lateinit var userListAdapter: UserListAdapter

    val TAG = "UserActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        activityComponent.inject(this)
        super.onCreate(savedInstanceState)
        Log.i(TAG, "onCreate: ")
        initialiseView()
        initialiseViewModel()
        userViewModel.loadUsers(0)
    }

    private fun initialiseView() {
        userListActivityBinding = UserListDataBinding.inflate(LayoutInflater.from(this))
        setContentView(userListActivityBinding.root)

        with(userListActivityBinding) {
            lifecycleOwner = this@UserActivity
                recyclerView.setLayoutManager(LinearLayoutManager(
                        this@UserActivity)
                )

            with(recyclerView) {
                setHasFixedSize(true)
                setAdapter(userListAdapter)
            }
        }
    }

    private fun initialiseViewModel() {
        userViewModel = ViewModelProviders.of(this, userListViewModelFactory)
            .get(UserViewModel::class.java)
        userViewModel.userList.observe(this) { movies ->
            if (movies == null) {
                showError();
            } else {
                displayData(movies)
            }
        }
    }

    private fun displayData(usersList: List<UserRemote>) {
        userListAdapter.addData(usersList)
    }

    private fun showError() {

    }

}