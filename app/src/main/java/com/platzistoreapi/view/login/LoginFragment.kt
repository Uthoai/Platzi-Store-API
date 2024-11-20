package com.platzistoreapi.view.login

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.platzistoreapi.R
import com.platzistoreapi.base.BaseFragment
import com.platzistoreapi.data.model.login.RequestLogin
import com.platzistoreapi.data.pref.PrefsManager
import com.platzistoreapi.databinding.FragmentLoginBinding
import com.platzistoreapi.utils.DataState
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding>(FragmentLoginBinding::inflate) {
    private val viewModel: LoginViewModel by viewModels()

    @Inject
    lateinit var prefsManager: PrefsManager

    override fun setListener() {

        val email = binding.etUserEmail.text.toString()
        val password = binding.etPassword.text.toString()

        // handleLogin(email, password)

        binding.loginBtn.setOnClickListener {
            handleLogin("john@mail.com", "changeme")
        }

        binding.registerBtn.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }
    }

    private fun handleLogin(email: String, password: String) {
        val requestLogin = RequestLogin(email = email, password = password)
        viewModel.login(requestLogin)
    }

    override fun allObserver() {
        viewModel.loginResponse.observe(viewLifecycleOwner){response->
            when(response){
                is DataState.Error -> {
                    loading.dismiss()
                    Log.d("ERROR", "Error: ${response.message}")
                }
                is DataState.Loading -> {
                    loading.show()
                }
                is DataState.Success -> {
                    loading.dismiss()

                    prefsManager.setPrefs(ACCESS_TOKEN, response.data?.accessToken.toString())
                    prefsManager.setPrefs(REFRESH_TOKEN, response.data?.refreshToken.toString())

                    Log.d("TagToken", "ACCESS_TOKEN: ${prefsManager.getPrefs(ACCESS_TOKEN)}")
                    Log.d("TagToken", "REFRESH_TOKEN: ${prefsManager.getPrefs(REFRESH_TOKEN)}")

                    //findNavController().navigate(R.id.action_loginFragment_to_profileFragment)
                }
            }
        }
    }


    companion object{
        const val ACCESS_TOKEN = "accessToken"
        const val REFRESH_TOKEN = "refreshToken"
    }
}