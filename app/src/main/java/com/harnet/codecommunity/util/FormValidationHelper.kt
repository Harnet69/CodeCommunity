package com.harnet.codecommunity.util

import android.text.TextUtils
import android.util.Patterns
import com.google.android.material.textfield.TextInputLayout

class FormValidationHelper {

    //check is field not empty
    fun fieldIsEmpty(textField: TextInputLayout): Boolean{
    val required = "Required"
        if (TextUtils.isEmpty(textField.editText?.text.toString())) {
            textField.error = required
            return true
        } else {
            textField.error = null
        }
        return false
    }

    // check if email valid
    fun isValidEmail(textField: TextInputLayout): Boolean {
        if (!Patterns.EMAIL_ADDRESS.matcher(textField.editText?.text.toString()).matches()) {
            textField.error = "Format is not valid"
            return false
        } else {
            textField.error = null
        }
        return true
    }
}