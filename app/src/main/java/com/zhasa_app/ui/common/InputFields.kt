package com.zhasa_app.ui.common

import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.google.android.material.datepicker.MaterialDatePicker
import com.zhasa_app.ui.theme.Colors
import com.zhasa_app.ui.theme.Size

@Composable
fun WeekInputField() {
    Box(
        modifier = Modifier
            .background(color = Colors.BackgroundColor)
            .fillMaxWidth()
            .height(Size.SPACE_7)
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
                textColor = Colors.PrimaryTextColor,
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
            .height(Size.SPACE_7)
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
                textColor = Colors.PrimaryTextColor,
                focusedBorderColor = Colors.BlueSecondaryLight,
                unfocusedBorderColor = Colors.White
            )
        )
    }
}

@Composable
fun DateField() {
    val datePicker = MaterialDatePicker.Builder.datePicker().build()

    val context = LocalContext.current
    var text by remember { mutableStateOf("") }

    datePicker.addOnPositiveButtonClickListener {
        text = datePicker.headerText
    }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(Size.SPACE_6)
            .clickable {
                datePicker.show((context as AppCompatActivity).supportFragmentManager, "")
            },
        backgroundColor = Colors.BackgroundColor,
        border = BorderStroke(Size.SPACE_BORDER, Colors.White),
    ) {
        Box(modifier = Modifier.padding(start = Size.SPACE_2)) {
            NormalText(
                text = text,
                textColor = Colors.PrimaryTextColor,
                modifier = Modifier.align(Alignment.CenterStart),
            )
        }
    }
}

@Composable
fun EmailInputField() {
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

@Composable
fun PasswordInputField() {
    var isPasswordVisible by rememberSaveable {
        mutableStateOf(false)
    }
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
                val image = if (isPasswordVisible)
                    Icons.Filled.Visibility
                else Icons.Filled.VisibilityOff
                IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                    Icon(imageVector = image, "")
                }
            }
        )
    }
}
