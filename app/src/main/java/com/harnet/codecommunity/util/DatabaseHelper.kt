package com.harnet.codecommunity.util

import androidx.lifecycle.MutableLiveData

interface DatabaseHelper {
    fun signUp(isSignedUp: MutableLiveData<Boolean>, mFailureMsg: MutableLiveData<String>,
               login: String, password: String)

    fun logIn(isLoggedIn: MutableLiveData<Boolean>, mFailureMsg: MutableLiveData<String>,
              login: String, password: String)

    fun logOut(isLoggedIn: MutableLiveData<Boolean>)
}