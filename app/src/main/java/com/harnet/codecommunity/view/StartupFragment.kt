package com.harnet.codecommunity.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase
import com.google.firebase.ktx.initialize
import com.harnet.codecommunity.R
import com.harnet.codecommunity.databinding.StartupFragmentBinding

class StartupFragment : Fragment() {
    private lateinit var dataBinding: StartupFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dataBinding =  DataBindingUtil.inflate(inflater, R.layout.startup_fragment, container, false)

        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //check if user have been logged already
        if(FirebaseAuth.getInstance().currentUser != null){
            //TODO create a redirection if user is logged in
            Toast.makeText(context, FirebaseAuth.getInstance().currentUser?.email, Toast.LENGTH_LONG).show()
        }

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

}