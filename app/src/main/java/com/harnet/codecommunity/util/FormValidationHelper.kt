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

    // check if a password is strong enough
    fun isPasswordStrong(pswTextField: TextInputLayout): Boolean {
        val pswPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&+=])(?=\\S+$).{4,}$"
        val pswMatcher = Regex(pswPattern)
        val psw = pswTextField.editText?.text.toString()

        if (pswMatcher.find(psw) != null && psw.length >= 8) {
            pswTextField.error = null
            return true
        }
        pswTextField.error = "Password length >= 8 & contains: one digit, special char, upper case"

        return false
    }
}