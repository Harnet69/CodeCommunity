package com.harnet.codecommunity.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.google.firebase.auth.FirebaseAuth
import com.harnet.codecommunity.R
import com.harnet.codecommunity.databinding.StartupFragmentBinding

class StartupFragment : Fragment() {
    private lateinit var dataBinding: StartupFragmentBinding

    private var firebaseAuth = FirebaseAuth.getInstance()
    // listens for a state firebase authentication
    private var firebaseAuthListener = FirebaseAuth.AuthStateListener {
        //check if user have been logged already
        if (it.currentUser != null) {
            Navigation.findNavController((activity as MainActivity).findViewById(R.id.login_btn)).navigate(StartupFragmentDirections.actionStartupFragmentToProfileFragment())
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dataBinding =  DataBindingUtil.inflate(inflater, R.layout.startup_fragment, container, false)

        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onLogin()
        onSignUp()
    }

    private fun onLogin(){
        dataBinding.loginBtn.setOnClickListener {
            Navigation.findNavController(it).navigate(StartupFragmentDirections.actionStartupFragmentToLoginFragment())
        }
    }

    private fun onSignUp(){
        dataBinding.signUpBtn.setOnClickListener {
            Navigation.findNavController(it).navigate(StartupFragmentDirections.actionStartupFragmentToSignUpFragment())
        }
    }

    override fun onStart() {
        super.onStart()
        firebaseAuth.addAuthStateListener(firebaseAuthListener)
    }

    override fun onStop() {
        super.onStop()
        firebaseAuth.removeAuthStateListener(firebaseAuthListener)
    }
}