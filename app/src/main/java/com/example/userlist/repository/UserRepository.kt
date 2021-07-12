package com.example.userlist.repository

import com.example.userlist.data.remote.api.UserApi
import com.example.userlist.data.remote.model.UserRemote
import com.example.userlist.data.remote.model.UserResponse
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import javax.inject.Inject

class UserRepository @Inject constructor(val remoteService: UserApi) {
    suspend fun getUsersByPage(pageIndex: Int) = flow{
        emit(remoteService.fetchusers(pageIndex))
    }
}