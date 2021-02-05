package com.harnet.codecommunity.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth

class LoginViewModel : ViewModel() {
    val mIsUserLoggedIn = MutableLiveData<Boolean>()
    val mUserLoggingFailureMsg = MutableLiveData<String>()

    fun logIn(userEmail: String, userPsw: String){
        FirebaseAuth.getInstance().signInWithEmailAndPassword(userEmail, userPsw)
            .addOnCompleteListener {task ->
                if(task.isSuccessful){
                    mIsUserLoggedIn.value = true
                }else{
                    mUserLoggingFailureMsg.value = task.exception?.localizedMessage.toString()
                }
            }
    }
}