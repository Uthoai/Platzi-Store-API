package com.platzistoreapi.data.model.login


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class RequestLogin(
    @SerializedName("email")
    val email: String? = null,
    @SerializedName("password")
    val password: String? = null
)