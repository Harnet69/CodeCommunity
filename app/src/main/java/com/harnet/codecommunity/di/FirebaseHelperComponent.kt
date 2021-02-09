package com.harnet.codecommunity.di

import com.harnet.codecommunity.viewModel.LoginViewModel
import com.harnet.codecommunity.viewModel.SignUpViewModel
import dagger.Component

@Component
interface FirebaseHelperComponent {
    fun inject(signUpViewModel: SignUpViewModel)
    fun inject(loginViewModel: LoginViewModel)
}