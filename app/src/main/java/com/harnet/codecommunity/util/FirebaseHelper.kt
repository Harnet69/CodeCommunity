package com.harnet.codecommunity.util

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.harnet.codecommunity.model.User

class FirebaseHelper : DatabaseHelper {
    private val USERS = "users"
    private var database = Firebase.database.reference
    private var firebaseAuth = FirebaseAuth.getInstance()

    // create new user
    @Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
    override fun signUp(
        isSignedUp: MutableLiveData<Boolean>,
        mFailureMsg: MutableLiveData<String>,
        login: String,
        password: String
    ) {
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(login, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    addUserToUsersDb()
                    isSignedUp.value = true
                } else {
                    mFailureMsg.value = task.exception?.localizedMessage.toString()
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
    @Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
    override fun logIn(
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
    @Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
    override fun logOut(isLoggedIn: MutableLiveData<Boolean>) {
        firebaseAuth.signOut()
        isLoggedIn.value = false
    }
}