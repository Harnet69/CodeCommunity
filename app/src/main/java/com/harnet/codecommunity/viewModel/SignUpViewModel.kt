package com.harnet.codecommunity.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.harnet.codecommunity.model.User
import com.harnet.codecommunity.util.FirebaseHelper

class SignUpViewModel : ViewModel() {
    val mIsUserCreated = MutableLiveData<Boolean>()
    val mUserCreatedFailureMsg = MutableLiveData<String>()
    //TODO Inject it instead of instantiate
    val firebaseHelper = FirebaseHelper()

    // create a new user
    fun createUser(userEmail: String, userPsw: String) {
        firebaseHelper.createUser(mIsUserCreated, mUserCreatedFailureMsg, userEmail, userPsw)
    }
}