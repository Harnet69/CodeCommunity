package com.harnet.codecommunity.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth

class SignUpViewModel : ViewModel() {
    private var firebaseAuth = FirebaseAuth.getInstance()

    val mIsUserCreated = MutableLiveData<Boolean>()
    val mUserCreatedFailureMsg = MutableLiveData<String>()

    // create new user
    fun createUser(userEmail: String, userPsw: String) {
        firebaseAuth.createUserWithEmailAndPassword(userEmail, userPsw)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    mIsUserCreated.value = true
                } else {
                    mUserCreatedFailureMsg.value = task.exception?.localizedMessage.toString()
                }
            }
    }
}