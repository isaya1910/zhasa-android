package com.zhasaApp.ui.login.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.zhasaApp.ui.common.views.NormalText
import com.zhasaApp.ui.common.views.PrimaryButton
import com.zhasaApp.ui.theme.Colors
import com.zhasaApp.ui.theme.Size

@Composable
fun LoginView() {
    Column(
        modifier = Modifier.fillMaxHeight()
            .background(color = Colors.BlackPrimary)
            .fillMaxWidth()
            .padding(start = Size.SPACE_2, end = Size.SPACE_2)
    ) {
        NormalText(text = "Войти", modifier = Modifier.padding(top = Size.SPACE_8))
        Spacer(modifier = Modifier.height(Size.SPACE_2))
        EmailInputView()
        Spacer(modifier = Modifier.height(Size.SPACE_2))
        PasswordInputView()
        Spacer(modifier = Modifier.height(Size.SPACE_2))
        PrimaryButton(
            modifier = Modifier
                .fillMaxWidth()
                .height(Size.SPACE_7),
            onClick = {
            },
            text = "Добавить"
        )
    }
}
