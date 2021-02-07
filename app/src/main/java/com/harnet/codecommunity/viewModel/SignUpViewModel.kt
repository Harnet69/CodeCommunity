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

    // create new user
    fun createUser(userEmail: String, userPsw: String) {
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(userEmail, userPsw)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
//                    addUserToUsersDb()
                    firebaseHelper.addUserToUsersDb()
                    mIsUserCreated.value = true
                } else {
                    mUserCreatedFailureMsg.value = task.exception?.localizedMessage.toString()
                }
            }
    }

    //TODO think about moving it to Firebase helper
    fun addUserToUsersDb() {
        val currentUser = FirebaseAuth.getInstance().currentUser
        val user = User(currentUser?.uid, "", "", currentUser?.email, "")
        // record user to users
        currentUser?.uid.let {
            currentUser?.uid?.let { it1 ->
                FirebaseDatabase.getInstance().reference.child("users").child(
                    it1
                ).setValue(user)
            }
        }
    }
}