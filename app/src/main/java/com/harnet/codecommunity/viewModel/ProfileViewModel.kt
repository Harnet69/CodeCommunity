package com.harnet.codecommunity.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth

class ProfileViewModel : ViewModel() {
    private var firebaseAuth = FirebaseAuth.getInstance()
    val mIsUserLogged = MutableLiveData<Boolean>()

    fun logOut(){
        firebaseAuth.signOut()
        mIsUserLogged.value = false
    }
}