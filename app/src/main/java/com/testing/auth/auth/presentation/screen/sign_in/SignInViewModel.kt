package com.testing.auth.auth.presentation.screen.sign_in

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor() : ViewModel() {

    var email by mutableStateOf(TextFieldValue(""))
        private set
    var password by mutableStateOf(TextFieldValue(""))
        private set

    var passwordVisible by mutableStateOf(false)
        private set
    var emailError by mutableStateOf(false)
    var passwordError by mutableStateOf(false)

    fun onChangeEmail(value: TextFieldValue) {
        email = value
        emailError = value.text.isEmpty()
    }

    fun onChangePassword(value: TextFieldValue) {
        password = value
        passwordError = value.text.isEmpty()
    }

    fun togglePassword() {
        passwordVisible = !passwordVisible
    }

    fun onPressedSignInButton(goToSignUp: () -> Unit) {
        if (!isValidate()) return
        goToSignUp()

    }

    private fun isValidate(): Boolean {
        return when {
            email.text.isEmpty() && password.text.isEmpty() -> {
                emailError = true
                passwordError = true
                false
            }
            email.text.isEmpty() -> {
                emailError = true
                false
            }
            password.text.isEmpty() -> {
                passwordError = true
                false
            }
            else -> true
        }
    }
}