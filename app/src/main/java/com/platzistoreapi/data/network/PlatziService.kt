package com.platzistoreapi.data.network

import com.platzistoreapi.data.model.login.RequestLogin
import com.platzistoreapi.data.model.login.ResponseLogin
import com.platzistoreapi.data.model.user.ResponseUser
import com.platzistoreapi.utils.Constants
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface PlatziService {

    @POST(Constants.LOGIN)
    suspend fun login(@Body requestLogin: RequestLogin): Response<ResponseLogin>

}