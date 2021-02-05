package com.harnet.codecommunity.di

import com.harnet.codecommunity.view.LoginFragment
import com.harnet.codecommunity.view.SignUpFragment
import dagger.Component

@Component
interface FormValidatorHelperComponent {
    fun inject(signUpFragment: SignUpFragment)
    fun inject(loginFragment: LoginFragment)
}