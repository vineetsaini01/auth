package com.testing.auth.auth.presentation.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation

@Composable
fun EditTextView(
    label: String,
    value: TextFieldValue,
    isError: Boolean,
    onValueChange: (TextFieldValue) -> Unit,
    keyboardOptions: KeyboardOptions,
    errorText: String,
) {

    Column {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            label = { Text(label) },
            modifier = Modifier.fillMaxWidth(),
            isError = isError,
            keyboardOptions = keyboardOptions
        )
        if (isError) {
            Text(
                text = errorText,
                color = MaterialTheme.colors.error,
                style = MaterialTheme.typography.caption
            )
        }
    }
}

@Composable
fun EditPasswordTextView(
    label: String,
    value: TextFieldValue,
    isError: Boolean,
    onValueChange: (TextFieldValue) -> Unit,
    keyboardOptions: KeyboardOptions,
    errorText: String,
    passwordVisible: Boolean,
    togglePassword: () -> Unit,
) {

    Column {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            label = { Text(label) },
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            isError = isError,
            trailingIcon = {
                val icon = if (passwordVisible) {
                    Icons.Default.Visibility
                } else {
                    Icons.Default.VisibilityOff
                }
                IconButton(onClick = togglePassword) {
                    Icon(imageVector = icon, contentDescription = "Toggle Password Visibility")
                }
            },
            keyboardOptions = keyboardOptions
        )
        if (isError) {
            Text(
                text = errorText,
                color = MaterialTheme.colors.error,
                style = MaterialTheme.typography.caption
            )
        }
    }
}