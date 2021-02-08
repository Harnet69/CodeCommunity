package com.harnet.codecommunity.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.harnet.codecommunity.util.FirebaseHelper

class LoginViewModel : ViewModel() {
    val mIsUserLoggedIn = MutableLiveData<Boolean>()
    val mUserLoggingFailureMsg = MutableLiveData<String>()
    //TODO Inject it instead of instantiate
    val firebaseHelper = FirebaseHelper()

    fun logIn(userEmail: String, userPsw: String){
        firebaseHelper.logIn(mIsUserLoggedIn, mUserLoggingFailureMsg, userEmail, userPsw)
    }
}