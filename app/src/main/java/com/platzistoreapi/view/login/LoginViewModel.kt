package com.platzistoreapi.view.login

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.platzistoreapi.data.model.login.ResponseRequestLogin
import com.platzistoreapi.data.repo.PlatziRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val loginRepository: PlatziRepository): ViewModel() {

    fun login(responseRequestLogin: ResponseRequestLogin){
        viewModelScope.launch {
            val response = loginRepository.login(responseRequestLogin)
            if (response.isSuccessful){
                Log.d("TAG", "login: ${response.body()}")
            }else{
                Log.d("TAG1", "login: error")
            }
        }
    }
}