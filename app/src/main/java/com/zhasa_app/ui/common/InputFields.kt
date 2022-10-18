package com.zhasa_app.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldColors
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import com.zhasa_app.ui.theme.Colors
import com.zhasa_app.ui.theme.Size

@Composable
fun WeekInputField() {
    Box(
        modifier = Modifier
            .background(color = Colors.BackgroundColor)
            .fillMaxWidth()
            .height(Size.SPACE_6)
    ) {
        var text by remember { mutableStateOf("") }
        val regex = Regex("([1-9]|[1-4][0-9]|5[0-3])")
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = text,
            onValueChange = {
                if (it.matches(regex) || it.isEmpty()) {
                    text = it
                }
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                textColor = Color.White,
                focusedBorderColor = Colors.BlueSecondaryLight,
                unfocusedBorderColor = Colors.White
            )
        )
    }
}

@Composable
fun AmountInputField() {
    Box(
        modifier = Modifier
            .background(color = Colors.BackgroundColor)
            .fillMaxWidth()
            .height(Size.SPACE_6)
    ) {
        var text by remember { mutableStateOf("") }
        val regex = Regex("[1-9]{1,5}[.]?[1-9]{0,2}")
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = text,
            onValueChange = {
                if (it.matches(regex) || it.isEmpty()) {
                    text = it
                }
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                textColor = Color.White,
                focusedBorderColor = Colors.BlueSecondaryLight,
                unfocusedBorderColor = Colors.White
            )
        )
    }
}