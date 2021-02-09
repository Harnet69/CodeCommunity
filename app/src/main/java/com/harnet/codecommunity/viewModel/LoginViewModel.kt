package com.harnet.codecommunity.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.harnet.codecommunity.di.DaggerFirebaseHelperComponent
import com.harnet.codecommunity.util.FirebaseHelper
import javax.inject.Inject

class LoginViewModel : ViewModel() {
    val mIsUserLoggedIn = MutableLiveData<Boolean>()
    val mUserLoggingFailureMsg = MutableLiveData<String>()

    @Inject
    lateinit var firebaseHelper: FirebaseHelper

    init {
        DaggerFirebaseHelperComponent.create().inject(this)
    }

    fun logIn(userEmail: String, userPsw: String){
        firebaseHelper.logIn(mIsUserLoggedIn, mUserLoggingFailureMsg, userEmail, userPsw)
    }
}