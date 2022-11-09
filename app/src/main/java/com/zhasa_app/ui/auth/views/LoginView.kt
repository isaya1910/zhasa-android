package com.zhasa_app.ui.auth.views

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.zhasa_app.ui.common.views.NormalText
import com.zhasa_app.ui.common.views.PrimaryButton
import com.zhasa_app.ui.theme.Size

@Composable
fun LoginView() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = Size.SPACE_2, end = Size.SPACE_2)
    ) {
        NormalText(text = "Войти")
        Spacer(modifier = Modifier.height(Size.SPACE_2))
        EmailInputView()
        Spacer(modifier = Modifier.height(Size.SPACE_2))
         PasswordInputView()
        Spacer(modifier = Modifier.height(Size.SPACE_2))
        PrimaryButton(modifier = Modifier
            .fillMaxWidth()
            .height(Size.SPACE_7), onClick = {
        }, text = "Добавить")
    }
}