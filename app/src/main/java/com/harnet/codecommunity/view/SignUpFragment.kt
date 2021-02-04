package com.harnet.codecommunity.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.harnet.codecommunity.R
import com.harnet.codecommunity.databinding.SignUpFragmentBinding
import com.harnet.codecommunity.util.FormValidationHelper
import com.harnet.codecommunity.viewModel.SignUpViewModel

class SignUpFragment : Fragment() {
    private lateinit var viewModel: SignUpViewModel
    private lateinit var dataBinding: SignUpFragmentBinding

    //TODO Inject it after implementation
    private val formValidationHelper = FormValidationHelper()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this).get(SignUpViewModel::class.java)
        dataBinding = DataBindingUtil.inflate(inflater, R.layout.sign_up_fragment, container, false)

        return dataBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onSignUp()
    }

    private fun onSignUp() {
        dataBinding.signUpBtnSignUp.setOnClickListener {
            if (isFormValid()) {
                Toast.makeText(context, "register User", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // validate input form
    private fun isFormValid(): Boolean {
        var result = true

        if (formValidationHelper.fieldIsEmpty(dataBinding.userNameSignUp)) {
            result = false
        }

        if (!formValidationHelper.isValidEmail(dataBinding.userEmailSignUp)) {
            result = false
        }

        if (formValidationHelper.fieldIsEmpty(dataBinding.userEmailSignUp)) {
            result = false
        } else {
            if (!formValidationHelper.isValidEmail(dataBinding.userEmailSignUp)) {
                result = false
            }
        }

        if (formValidationHelper.fieldIsEmpty(dataBinding.userPasswordSignUp)) {
            result = false
        }
        return result
    }

    override fun onStart() {
        super.onStart()
        viewModel.addFirebaseListener()
    }

    override fun onStop() {
        super.onStop()
        viewModel.removeFirebaseListener()
    }
}