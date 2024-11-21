package com.platzistoreapi.data.network

import com.platzistoreapi.data.model.user.ResponseUser
import com.platzistoreapi.utils.Constants
import retrofit2.Response
import retrofit2.http.GET

interface PlatziSecuredService {

    @GET(Constants.PROFILE)
    suspend fun getProfile(): Response<ResponseUser>

}