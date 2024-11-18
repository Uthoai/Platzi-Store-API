package com.platzistoreapi.view.login

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.platzistoreapi.R
import com.platzistoreapi.base.BaseFragment
import com.platzistoreapi.data.model.login.ResponseRequestLogin
import com.platzistoreapi.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding>(FragmentLoginBinding::inflate) {
    private val viewModel: LoginViewModel by viewModels()
    override fun setListener() {

        binding.loginBtn.setOnClickListener {
            login()
        }

        binding.registerBtn.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }
    }

    private fun login() {
        val email = binding.etUserEmail.text.toString()
        val password = binding.etPassword.text.toString()
        val responseRequestLogin = ResponseRequestLogin("john@mail.com", "changeme")
        viewModel.login(responseRequestLogin)
    }

    override fun allObserver() {
        //
    }
}