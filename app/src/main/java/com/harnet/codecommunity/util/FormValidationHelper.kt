package com.harnet.codecommunity.util

import android.text.TextUtils
import android.util.Patterns
import com.google.android.material.textfield.TextInputLayout

class FormValidationHelper {

    //check is a field not empty
    fun fieldIsEmpty(textField: TextInputLayout): Boolean {
        val required = "Required"
        if (TextUtils.isEmpty(textField.editText?.text.toString())) {
            textField.error = required
            return true
        }
        textField.error = null

        return false
    }

    // check if an email format is valid
    fun isValidEmail(textField: TextInputLayout): Boolean {
        if (Patterns.EMAIL_ADDRESS.matcher(textField.editText?.text.toString()).matches()) {
        textField.error = null
            return true
        }
        textField.error = "Format is not valid"

        return false
    }

    // check if an username is valid
    fun isUsernameLengthValid(textField: TextInputLayout): Boolean {
        val usernameLength = textField.editText?.text.toString().length
        if (usernameLength in 10 downTo 3) {
            textField.error = null
            return true
        }
        textField.error = "3<=username length<=10"

        return false
    }
}