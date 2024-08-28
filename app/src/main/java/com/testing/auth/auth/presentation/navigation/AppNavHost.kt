package com.testing.auth.auth.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.testing.auth.auth.presentation.screen.forgot_password.ForgotPasswordScreen
import com.testing.auth.home.presentation.screen.HomeScreen
import com.testing.auth.auth.presentation.screen.sign_in.SignInScreen
import com.testing.auth.auth.presentation.screen.sign_up.SignUpScreen

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
) {

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = AppRoute.SignInScreen.route,
    ) {

        composable(AppRoute.SignInScreen.route) {
            SignInScreen(navController)
        }

        composable(AppRoute.SignUpScreen.route) {
            SignUpScreen(navController)
        }

        composable(AppRoute.HomeScreen.route) {
            HomeScreen()
        }
        composable(AppRoute.HomeScreen.route) {
            ForgotPasswordScreen()
        }

    }
}