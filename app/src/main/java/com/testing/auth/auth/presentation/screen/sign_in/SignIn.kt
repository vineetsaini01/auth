package com.testing.auth.auth.presentation.screen.sign_in

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.testing.auth.auth.presentation.component.EditPasswordTextView
import com.testing.auth.auth.presentation.component.EditTextView
import com.testing.auth.auth.presentation.navigation.AppRoute

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SignInScreen(
    navController: NavHostController,
    vm: SignInViewModel = hiltViewModel(),
) {

    val context = LocalContext.current
    Scaffold(Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize()) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .background(
                        color = MaterialTheme.colors.primary
                    ),
                Alignment.BottomCenter
            ) {

                Text(
                    modifier = Modifier.padding(bottom = 16.dp),
                    text = "UN-TITLE", color = Color.White
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 20.dp),
                Arrangement.SpaceBetween,
                Alignment.Start
            ) {
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "Un-Title", fontSize = 19.sp, fontWeight = FontWeight.Bold)
                Text(text = "Welcome Back", fontSize = 19.sp, fontWeight = FontWeight.Bold)
                Text(text = "let's get started by filling out the form below")

                EditTextView(
                    label = "Email",
                    value = vm.email,
                    onValueChange = vm::onChangeEmail,
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Email,
                        imeAction = ImeAction.Next
                    ),
                    isError = vm.emailError,
                    errorText = "Email is required"
                )

                EditPasswordTextView(
                    label = "Password",
                    value = vm.password,
                    onValueChange = vm::onChangePassword,
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Password,
                        imeAction = ImeAction.Done
                    ),
                    isError = vm.passwordError,
                    errorText = "Password is required",
                    passwordVisible = vm.passwordVisible,
                    togglePassword = {
                        vm.togglePassword()
                    }
                )

                Button(modifier = Modifier.fillMaxWidth(), onClick = {
                    vm.onPressedSignInButton {
                        navController.navigate(AppRoute.HomeScreen.route)
                    }

                }) {
                    Text(text = "Sign In")
                }

                val annotatedText = buildAnnotatedString {
                    append("Don't have an account? ")

                    withStyle(
                        style = SpanStyle(
                            color = Color.Blue,
                            textDecoration = TextDecoration.Underline
                        )
                    ) {
                        append("Sign up here")
                    }

                    addStringAnnotation(
                        tag = "SignUp",
                        annotation = "SignUp",
                        start = length - "Sign up here".length,
                        end = length
                    )
                }

                Row(modifier = Modifier.fillMaxWidth(), Arrangement.Center) {
                    ClickableText(
                        text = annotatedText,
                        onClick = { offset ->
                            annotatedText.getStringAnnotations(
                                tag = "SignUp",
                                start = offset,
                                end = offset
                            )
                                .firstOrNull()?.let {
                                    navController.navigate(AppRoute.SignUpScreen.route)
                                }
                        }
                    )
                }

                val annotatedText2 = buildAnnotatedString {
                    append("")

                    withStyle(
                        style = SpanStyle(
                            color = Color.Blue,
                            textDecoration = TextDecoration.Underline
                        )
                    ) {
                        append("Forgot Password")
                    }

                    addStringAnnotation(
                        tag = "Password",
                        annotation = "Password",
                        start = length - "Forgot Password".length,
                        end = length
                    )
                }

                Row(Modifier.fillMaxWidth(), Arrangement.Center) {
                    ClickableText(
                        text = annotatedText2,
                        onClick = { offset ->
                            annotatedText.getStringAnnotations(
                                tag = "Password",
                                start = offset,
                                end = offset
                            )
                                .firstOrNull()?.let {
                                    navController.navigate(AppRoute.ForgotPasswordScreen.route)
                                }
                        },
                    )
                }

                Spacer(modifier = Modifier.height(100.dp))

            }

        }
    }
}