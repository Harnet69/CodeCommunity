package com.harnet.codecommunity.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.harnet.codecommunity.viewModel.LoginViewModel
import com.harnet.codecommunity.R
import com.harnet.codecommunity.databinding.LoginFragmentBinding
import com.harnet.codecommunity.di.DaggerFormValidatorHelperComponent
import com.harnet.codecommunity.util.FormValidationHelper
import javax.inject.Inject

class LoginFragment : Fragment() {
    private lateinit var viewModel: LoginViewModel
    private lateinit var dataBinding: LoginFragmentBinding

    @Inject
    lateinit var formValidationHelper: FormValidationHelper

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        dataBinding = DataBindingUtil.inflate(inflater, R.layout.login_fragment, container, false)

        // inject form validator component
        DaggerFormValidatorHelperComponent.create().inject(this)

        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        onLogIn()
        observeViewModel()
    }

    private fun onLogIn() {
        dataBinding.loginBtn.setOnClickListener {
            if (isFormValid()) {
                // log in
                viewModel.logIn(
                    dataBinding.userEmail.editText?.text.toString(),
                    dataBinding.userPsw.editText?.text.toString()
                )
            }
        }

    }

    private fun observeViewModel() {
        viewModel.mIsUserLoggedIn.observe(viewLifecycleOwner, {
            if (it) {
                //TODO redirect to an another fragment after login
                Toast.makeText(context, "User logged in", Toast.LENGTH_SHORT).show()
            }
        })

        viewModel.mUserLoggingFailureMsg.observe(viewLifecycleOwner, {errorMsg ->
            Toast.makeText(context, errorMsg, Toast.LENGTH_SHORT).show()
        })
    }

    // validate signUp input form
    private fun isFormValid(): Boolean {
        var result = true

        if (formValidationHelper.fieldIsEmpty(dataBinding.userEmail)) {
            result = false
        } else {
            if (!formValidationHelper.isValidEmail(dataBinding.userEmail)) {
                result = false
            }
        }

        if (formValidationHelper.fieldIsEmpty(dataBinding.userPsw)) {
            result = false
        }

        return result
    }
}