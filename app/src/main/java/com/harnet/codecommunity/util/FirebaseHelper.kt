package com.harnet.codecommunity.util

import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.navigation.Navigation
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.harnet.codecommunity.R
import com.harnet.codecommunity.model.User
import com.harnet.codecommunity.view.MainActivity
import com.harnet.codecommunity.view.StartupFragmentDirections

class FirebaseHelper {
    private val USERS = "users"
    private var database = Firebase.database.reference
    private var firebaseAuth = FirebaseAuth.getInstance()

    // create new user
    fun sighUp(
        mIsUserCreated: MutableLiveData<Boolean>, mUserCreatedFailureMsg: MutableLiveData<String>,
        userEmail: String, userPsw: String
    ) {
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(userEmail, userPsw)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    addUserToUsersDb()
                    mIsUserCreated.value = true
                } else {
                    mUserCreatedFailureMsg.value = task.exception?.localizedMessage.toString()
                }
            }
    }

    private fun addUserToUsersDb() {
        val currentUser = FirebaseAuth.getInstance().currentUser
        val user = User(currentUser?.uid, "", "", currentUser?.email, "")
        user.uid?.let {
            database.child(USERS).child(it).setValue(user)
                .addOnSuccessListener {
                    Log.i("currentUser", "addUserToUsersDb: Success")
                }
                .addOnFailureListener { e ->
                    Log.i("currentUser", "Error! " + e.message)
                }
        }
    }

    fun logIn(
        mIsUserLoggedIn: MutableLiveData<Boolean>, mUserLoggingFailureMsg: MutableLiveData<String>,
        userEmail: String, userPsw: String
    ) {
        FirebaseAuth.getInstance().signInWithEmailAndPassword(userEmail, userPsw)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    mIsUserLoggedIn.value = true
                } else {
                    mUserLoggingFailureMsg.value = task.exception?.localizedMessage.toString()
                }
            }
    }

    fun logOut(mIsUserLogged: MutableLiveData<Boolean>) {
        firebaseAuth.signOut()
        mIsUserLogged.value = false
    }

}