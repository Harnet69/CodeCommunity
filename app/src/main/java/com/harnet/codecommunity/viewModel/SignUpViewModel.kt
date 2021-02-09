package com.harnet.codecommunity.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.harnet.codecommunity.di.DaggerFirebaseHelperComponent
import com.harnet.codecommunity.util.FirebaseHelper
import javax.inject.Inject

class SignUpViewModel : ViewModel() {
    val mIsUserCreated = MutableLiveData<Boolean>()
    val mUserCreatedFailureMsg = MutableLiveData<String>()

    @Inject
    lateinit var firebaseHelper: FirebaseHelper

    init {
        DaggerFirebaseHelperComponent.create().inject(this)
    }

    // create a new user
    fun signUp(userEmail: String, userPsw: String) {
        firebaseHelper.signUp(mIsUserCreated, mUserCreatedFailureMsg, userEmail, userPsw)
    }
}