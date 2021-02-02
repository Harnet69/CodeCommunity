package com.harnet.codecommunity.viewModel

import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth

class SignUpViewModel : ViewModel() {
    private var firebaseAuth = FirebaseAuth.getInstance()
    // listens for a state firebase authentication. Called when user created
    private var firebaseAuthListener = FirebaseAuth.AuthStateListener {

    }

}