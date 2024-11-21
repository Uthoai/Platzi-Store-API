package com.platzistoreapi.data.repo

import com.platzistoreapi.data.model.login.RequestLogin
import com.platzistoreapi.data.model.login.ResponseLogin
import com.platzistoreapi.data.model.user.ResponseUser
import com.platzistoreapi.data.network.PlatziSecuredService
import com.platzistoreapi.data.network.PlatziService
import retrofit2.Response
import javax.inject.Inject

class PlatziRepository @Inject constructor(
    private val platziService: PlatziService,
    private val platziSecuredService: PlatziSecuredService
){

    suspend fun login(requestLogin: RequestLogin): Response<ResponseLogin>{
        return platziService.login(requestLogin)
    }

    suspend fun getProfile(): Response<ResponseUser>{
        return platziSecuredService.getProfile()
    }

}