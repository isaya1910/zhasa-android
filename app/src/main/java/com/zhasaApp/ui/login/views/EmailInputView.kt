package com.zhasaApp.ui.login.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import com.zhasaApp.ui.common.views.SmallText
import com.zhasaApp.ui.theme.Colors
import com.zhasaApp.ui.theme.Size

@Composable
fun EmailInputView() {
    Column(modifier = Modifier.fillMaxWidth()) {
        SmallText(text = "Введите email", textColor = Colors.SecondaryTextColor)
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
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    textColor = Colors.PrimaryTextColor,
                    focusedBorderColor = Colors.BlueSecondaryLight,
                    unfocusedBorderColor = Colors.White
                )
            )
        }
    }
}
