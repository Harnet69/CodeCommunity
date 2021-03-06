package com.harnet.codecommunity.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.harnet.codecommunity.R
import com.harnet.codecommunity.databinding.SignUpFragmentBinding
import com.harnet.codecommunity.di.DaggerFormValidatorHelperComponent
import com.harnet.codecommunity.util.FormValidationHelper
import com.harnet.codecommunity.viewModel.SignUpViewModel
import javax.inject.Inject

class SignUpFragment : Fragment() {
    private lateinit var viewModel: SignUpViewModel
    private lateinit var dataBinding: SignUpFragmentBinding

    @Inject
    lateinit var formValidationHelper: FormValidationHelper

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this).get(SignUpViewModel::class.java)
        dataBinding = DataBindingUtil.inflate(inflater, R.layout.sign_up_fragment, container, false)

        // inject form validator component
        DaggerFormValidatorHelperComponent.create().inject(this)

        return dataBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onSignUp()

        observeViewModel()
    }

    private fun observeViewModel(){
        viewModel.mIsUserCreated.observe(viewLifecycleOwner, {
            if(it)
                Navigation.findNavController(dataBinding.userEmailSignUp).navigate(SignUpFragmentDirections.actionSignUpFragmentToTechsChooserFragment())
        })

        viewModel.mUserCreatedFailureMsg.observe(viewLifecycleOwner,{errorMsg ->
                Toast.makeText(context, errorMsg, Toast.LENGTH_SHORT).show()
        })
    }

    private fun onSignUp() {
        dataBinding.signUpBtnSignUp.setOnClickListener {
            if (isFormValid()) {
                // create new user
                viewModel.signUp(dataBinding.userEmailSignUp.editText?.text.toString(),
                                    dataBinding.userPasswordSignUp.editText?.text.toString())
            }
        }
    }

    // validate signUp input form
    private fun isFormValid(): Boolean {
        var result = true

        if (formValidationHelper.fieldIsEmpty(dataBinding.userEmailSignUp)) {
            result = false
        } else {
            if (!formValidationHelper.isValidEmail(dataBinding.userEmailSignUp)) {
                result = false
            }
        }

        if (formValidationHelper.fieldIsEmpty(dataBinding.userPasswordSignUp)) {
            result = false
        }else{
            //TODO switch on production, disabled for easy testing
//            if(!formValidationHelper.isPasswordStrong(dataBinding.userPasswordSignUp)){
//                result = false
//            }
        }

        return result
    }
}