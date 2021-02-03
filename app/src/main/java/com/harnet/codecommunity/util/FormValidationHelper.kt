package com.harnet.codecommunity.util

import android.text.TextUtils
import com.google.android.material.textfield.TextInputLayout

class FormValidationHelper {

    //check is field not empty
    fun isNotEmpty(textField: TextInputLayout): Boolean{
    val required = "Required"
        if (TextUtils.isEmpty(textField.editText?.text.toString())) {
            textField.error = required
            return false
        } else {
            textField.error = null
        }
        return true
    }
}