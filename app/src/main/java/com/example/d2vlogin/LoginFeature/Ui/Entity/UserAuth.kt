package com.example.d2vlogin.LoginFeature.Ui.Entity

import android.text.TextUtils
import android.util.Patterns


object UserAuth {

    fun CharSequence.isValidEmail(): Boolean {
        return !TextUtils.isEmpty(this) && Patterns.EMAIL_ADDRESS.matcher(this).matches()
    }

    fun String.isValidMobile(): Boolean {
        return Patterns.PHONE.matcher(this).matches()
    }

    fun String.isPasswordValid(): Boolean {
        val passwordPattern = "^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{6,}$".toRegex()
        return passwordPattern.matches(this)
    }

}