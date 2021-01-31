package com.harnet.codecommunity.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.harnet.codecommunity.R
import com.harnet.codecommunity.databinding.StartupFragmentBinding
import com.harnet.codecommunity.viewModel.StartupViewModel

class StartupFragment : Fragment() {
    private lateinit var dataBinding: StartupFragmentBinding
    private lateinit var viewModel: StartupViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dataBinding =  DataBindingUtil.inflate(inflater, R.layout.startup_fragment, container, false)
        viewModel = ViewModelProvider(this).get(StartupViewModel::class.java)

        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onLogin()
        onSignUp()
    }

    private fun onLogin(){
        dataBinding.loginBtn.setOnClickListener {
            viewModel.logIn()
        }
    }

    private fun onSignUp(){
//        dataBinding.si
    }

}