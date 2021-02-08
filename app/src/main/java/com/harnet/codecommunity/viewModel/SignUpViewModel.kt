package com.harnet.codecommunity.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.harnet.codecommunity.util.FirebaseHelper

class SignUpViewModel : ViewModel() {
    val mIsUserCreated = MutableLiveData<Boolean>()
    val mUserCreatedFailureMsg = MutableLiveData<String>()
    //TODO Inject it instead of instantiate
    val firebaseHelper = FirebaseHelper()

    // create a new user
    fun signUp(userEmail: String, userPsw: String) {
        firebaseHelper.sighUp(mIsUserCreated, mUserCreatedFailureMsg, userEmail, userPsw)
    }
}