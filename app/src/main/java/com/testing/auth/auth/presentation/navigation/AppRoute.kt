package com.testing.auth.auth.presentation.navigation

sealed class AppRoute(val route: String) {

    object SignInScreen : AppRoute("SignInScreen")
    object SignUpScreen : AppRoute("SignUpScreen")
    object HomeScreen : AppRoute("HomeScreen")
    object ForgotPasswordScreen : AppRoute("ForgotPasswordScreen")
}