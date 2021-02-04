package com.harnet.codecommunity.util

import com.google.firebase.auth.FirebaseAuth

class FirebaseHelper {
    private var firebaseAuth = FirebaseAuth.getInstance()
    // listens for a state firebase authentication. Called when user created
    private var firebaseAuthListener = FirebaseAuth.AuthStateListener {}

    //add firebase listener
    fun addFirebaseListener(){
        firebaseAuth.addAuthStateListener(firebaseAuthListener)
    }

    //remove firebase listener
    fun removeFirebaseListener(){
        firebaseAuth.removeAuthStateListener(firebaseAuthListener)
    }

    fun isUserLogged(): Boolean{
        if(FirebaseAuth.getInstance().currentUser != null){
            return true
        }
        return false
    }
}