package com.platzistoreapi.data.network

import com.platzistoreapi.data.model.login.ResponseRequestLogin
import com.platzistoreapi.utils.Constants
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface PlatziService {

    @POST(Constants.LOGIN)
    suspend fun login(@Body responseRequestLogin: ResponseRequestLogin): Response<ResponseBody>

}