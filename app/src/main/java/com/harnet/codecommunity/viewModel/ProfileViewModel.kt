package com.harnet.codecommunity.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.harnet.codecommunity.util.FirebaseHelper

class ProfileViewModel : ViewModel() {
    val mIsUserLogged = MutableLiveData<Boolean>()

    //TODO Inject it instead of instantiate
    val firebaseHelper = FirebaseHelper()

    fun logOut(){
        firebaseHelper.logOut(mIsUserLogged)
    }
}