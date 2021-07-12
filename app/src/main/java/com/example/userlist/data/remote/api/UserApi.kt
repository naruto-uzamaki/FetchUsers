package com.example.userlist.data.remote.api

import com.example.userlist.data.remote.model.UserResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface UserApi {

    @GET("users/")
    suspend fun fetchusers(@Query ("page") pageIndex:Int) : Response<UserResponse>
}