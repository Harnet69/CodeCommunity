package com.harnet.codecommunity.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth

class SignUpViewModel : ViewModel() {
    private var firebaseAuth = FirebaseAuth.getInstance()
    // listens for a state firebase authentication. Called when user created
//    private var firebaseAuthListener = FirebaseAuth.AuthStateListener {}

    val mIsUserCreated = MutableLiveData<Boolean>()
    val mUserCreatedFailureMsg = MutableLiveData<String>()

//    //add firebase
//    fun addFirebaseListener(){
//        firebaseAuth.addAuthStateListener(firebaseAuthListener)
//    }
//
//    //remove firebase
//    fun removeFirebaseListener(){
//        firebaseAuth.removeAuthStateListener(firebaseAuthListener)
//    }

    // create new user
    fun createUser(userEmail: String, userPsw: String){
        firebaseAuth.createUserWithEmailAndPassword(userEmail, userPsw)
            .addOnCompleteListener {task ->
                if(task.isSuccessful){
                    mIsUserCreated.value = true
                }else{
                    mUserCreatedFailureMsg.value = task.exception?.localizedMessage.toString()
                }
            }
    }

}