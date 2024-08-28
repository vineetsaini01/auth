package com.testing.auth.auth.presentation.screen.sign_up

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor() : ViewModel() {

    var email by mutableStateOf(TextFieldValue(""))
        private set

    var mobile by mutableStateOf(TextFieldValue(""))
        private set

    var password by mutableStateOf(TextFieldValue(""))
        private set

    var confirmPassword by mutableStateOf(TextFieldValue(""))
        private set

    var passwordVisible by mutableStateOf(false)
        private set

    var confirmPasswordVisible by mutableStateOf(false)
        private set

    var emailError by mutableStateOf(false)
    var passwordError by mutableStateOf(false)
    var mobileError by mutableStateOf(false)
    var confirmPasswordError by mutableStateOf(false)

    fun onChangeEmail(value: TextFieldValue) {
        email = value
        emailError = value.text.isEmpty()
    }

    fun onChangePassword(value: TextFieldValue) {
        password = value
        passwordError = value.text.isEmpty()
    }

    fun onChangeMobile(value: TextFieldValue) {
        mobile = value
        mobileError = value.text.isEmpty()
    }

    fun onChangeConfirmPassword(value: TextFieldValue) {
        confirmPassword = value
        confirmPasswordError = value.text.isEmpty()
    }

    fun togglePassword() {
        passwordVisible = !passwordVisible
    }

    fun toggleConfirmPassword() {
        confirmPasswordVisible = !confirmPasswordVisible
    }

    fun onPressedSignUpButton(goToHome: () -> Unit) {
        if (!isValidate()) return
        goToHome()
    }

    private fun isValidate(): Boolean {
        return when {
            email.text.isEmpty() &&
                    password.text.isEmpty()
                    && mobile.text.isEmpty() && confirmPassword.text.isEmpty() -> {
                emailError = true
                passwordError = true
                confirmPasswordError = true
                mobileError = true
                false
            }
            email.text.isEmpty() -> {
                emailError = true
                false
            }
            mobile.text.isEmpty() -> {
                mobileError = true
                false
            }
            password.text.isEmpty() -> {
                passwordError = true
                false
            }
            confirmPassword.text.isEmpty() -> {
                confirmPasswordError = true
                false
            }

            confirmPassword.text == password.text -> {
                confirmPasswordError = true
                false
            }
            else -> true
        }
    }
}