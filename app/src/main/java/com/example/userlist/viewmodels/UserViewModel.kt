package com.example.userlist.viewmodels

import android.util.Log
import androidx.lifecycle.*
import com.example.userlist.data.remote.model.UserRemote
import com.example.userlist.repository.UserRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider


class UserViewModel @Inject constructor(val repository: UserRepository) : ViewModel() {


    var _userList: MutableLiveData<List<UserRemote>?> = MutableLiveData()
    var userList: LiveData<List<UserRemote>?> = _userList

    val TAG = "MoviesListViewModel"

    init {

    }

    fun loadUsers(pageIndex: Int) {
        Log.i(TAG, "loadMovies for pageIndex=${pageIndex}")
        viewModelScope.launch {
            repository.getUsersByPage(pageIndex).collect { result ->
                if (result.isSuccessful) {
                    _userList.postValue(result.body()!!.data)
                } else {
                    _userList.postValue(null)
                }
            }
        }
    }


    class UserListViewModelFactory @Inject constructor(val userListViewModel: Provider<UserViewModel>) :
        ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(UserViewModel::class.java))
                return userListViewModel.get() as T
            else {
                throw IllegalArgumentException("unknown model class $modelClass")
            }
        }
    }
}