//package com.example.userlist.repository
//
//import androidx.paging.ExperimentalPagingApi
//import androidx.paging.PagingSource
//import com.example.userlist.Constants.DEFAULT_PAGE_INDEX
//import com.example.userlist.data.remote.api.UserApi
//import com.example.userlist.data.remote.model.UserRemote
//import retrofit2.HttpException
//import retrofit2.Response
//import java.io.IOException
//
//
//@ExperimentalPagingApi
//class UserPagingSource(val userApiService: UserApi) : PagingSource<Int, UserRemote>() {
//
//    /**
//     * calls api if there is any error getting results then return the [LoadResult.Error]
//     * for successful response return the results using [LoadResult.Page] for some reason if the results
//     * are empty from service like in case of no more data from api then we can pass [null] to
//     * send signal that source has reached the end of list
//     */
//    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, UserRemote> {
//        //for first case it will be null, then we can pass some default value, in our case it's 1
//        val page = params.key ?: DEFAULT_PAGE_INDEX
//        try {
//            val response = userApiService.fetchusers(page)
//            var responseData : Response<>
//            if (response.isSuccessful()) {
//                responseData =
//            }else{
//                responseData = response.errorBody()
//            }
//
//        } catch (exception: IOException) {
//            return LoadResult.Error(exception)
//        } catch (exception1: HttpException) {
//            return LoadResult.Error(exception1)
//        }
//    }
//
//}