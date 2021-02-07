package com.harnet.codecommunity.util

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.harnet.codecommunity.model.User

class FirebaseHelper {
    private val USERS = "users"

    private var database = Firebase.database.reference

    private var firebaseAuth = FirebaseAuth.getInstance()

    // listens for a state firebase authentication. Called when user created
    private var firebaseAuthListener = FirebaseAuth.AuthStateListener {}

    //add firebase listener
    fun addFirebaseListener() {
        firebaseAuth.addAuthStateListener(firebaseAuthListener)
    }

    //remove firebase listener
    fun removeFirebaseListener() {
        firebaseAuth.removeAuthStateListener(firebaseAuthListener)
    }

    fun isUserLogged(): Boolean {
        if (FirebaseAuth.getInstance().currentUser != null) {
            return true
        }
        return false
    }

    fun addUserToUsersDb() {
        val currentUserId = FirebaseAuth.getInstance().currentUser?.uid ?: ""
        val user = User(currentUserId, "", "", "", "")
        user.uid?.let { database.child(USERS).child(it).setValue(user)
            .addOnSuccessListener {
                Log.i("currentUser", "addUserToUsersDb: Success")
            }
            .addOnFailureListener { e ->
                Log.i("currentUser", "Error! " + e.message)
            }
        }
    }

}