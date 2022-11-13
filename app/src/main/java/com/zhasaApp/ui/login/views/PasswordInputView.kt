package com.zhasaApp.ui.login.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.zhasaApp.ui.common.views.SmallText
import com.zhasaApp.ui.theme.Colors
import com.zhasaApp.ui.theme.Size

@Composable
fun PasswordInputView() {
    var isPasswordVisible by rememberSaveable {
        mutableStateOf(false)
    }
    Column(modifier = Modifier.fillMaxWidth()) {
        SmallText(text = "Введите пароль", textColor = Colors.SecondaryTextColor)
        Spacer(modifier = Modifier.height(Size.SPACE_0_5))
        Box(
            modifier = Modifier
                .background(color = Colors.BackgroundColor)
                .fillMaxWidth()
                .height(Size.SPACE_7)
        ) {
            var text by remember { mutableStateOf("") }
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = text,
                onValueChange = {
                    text = it
                },
                visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    textColor = Colors.PrimaryTextColor,
                    focusedBorderColor = Colors.BlueSecondaryLight,
                    unfocusedBorderColor = Colors.White
                ),
                trailingIcon = {
                    val image = if (isPasswordVisible) {
                        Icons.Filled.Visibility
                    } else {
                        Icons.Filled.VisibilityOff
                    }
                    IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                        Icon(imageVector = image, "")
                    }
                }
            )
        }
    }
}
