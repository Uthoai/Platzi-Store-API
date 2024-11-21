package com.platzistoreapi.view.profile

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.platzistoreapi.base.BaseFragment
import com.platzistoreapi.databinding.FragmentProfileBinding
import com.platzistoreapi.utils.DataState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ProfileFragment : BaseFragment<FragmentProfileBinding>(FragmentProfileBinding::inflate) {
    private val viewModel: ProfileViewmodel by viewModels()
    override fun setListener() {
        viewModel.getProfile()
    }

    override fun allObserver() {
        profileObserver()
    }

    private fun profileObserver() {
        lifecycleScope.launch {
            viewModel.profileResponse.collect { state ->
                when (state) {
                    is DataState.Error -> {
                        loading.dismiss()
                    }
                    is DataState.Loading -> {
                        loading.show()
                    }
                    is DataState.Success -> {
                        loading.dismiss()
                        Log.d("TAGProfile", "allObserver: ${state.data}")
                    }
                }
            }
        }
    }

}