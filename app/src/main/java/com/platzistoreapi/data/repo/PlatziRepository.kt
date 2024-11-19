package com.platzistoreapi.data.repo

import com.platzistoreapi.data.model.login.RequestLogin
import com.platzistoreapi.data.network.PlatziService
import okhttp3.ResponseBody
import retrofit2.Response
import javax.inject.Inject

class PlatziRepository @Inject constructor(private val platziService: PlatziService){

    suspend fun login(requestLogin: RequestLogin): Response<ResponseBody>{
        return platziService.login(requestLogin)
    }
}