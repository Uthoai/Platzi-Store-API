package com.platzistoreapi.data.repo

import com.platzistoreapi.data.model.login.ResponseRequestLogin
import com.platzistoreapi.data.network.PlatziService
import okhttp3.ResponseBody
import retrofit2.Response
import javax.inject.Inject

class PlatziRepository @Inject constructor(private val platziService: PlatziService){

    suspend fun login(responseRequestLogin: ResponseRequestLogin): Response<ResponseBody>{
        return platziService.login(responseRequestLogin)
    }
}