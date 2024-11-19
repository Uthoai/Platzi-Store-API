package com.platzistoreapi.data.model.login


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class ResponseLogin(
    @SerializedName("access_token")
    val accessToken: String? = null,
    @SerializedName("refresh_token")
    val refreshToken: String? = null
)