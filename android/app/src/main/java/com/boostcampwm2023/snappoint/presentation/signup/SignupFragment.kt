package com.boostcampwm2023.snappoint.presentation.signup

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.boostcampwm2023.snappoint.R
import com.boostcampwm2023.snappoint.databinding.FragmentSignupBinding
import com.boostcampwm2023.snappoint.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignupFragment : BaseFragment<FragmentSignupBinding>(R.layout.fragment_signup) {

    private val viewModel: SignupViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initBinding()
        loadText()
    }

    private fun initBinding() {
        with(binding) {
            vm = viewModel
        }
    }

    // TODO(임시데이터!!)
    private fun loadText() {
        with(binding) {
            tilSignUpEmail.editText?.setText(viewModel.uiState.value.email)
            tilSignUpPassword.editText?.setText(viewModel.uiState.value.password)
            tilSignUpPasswordConfirm.editText?.setText(viewModel.uiState.value.passwordConfirm)
            tilSignUpNickname.editText?.setText(viewModel.uiState.value.nickname)
        }
    }
}