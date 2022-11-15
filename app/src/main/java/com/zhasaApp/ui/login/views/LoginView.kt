package com.zhasaApp.ui.login.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.zhasaApp.ui.common.views.NormalText
import com.zhasaApp.ui.common.views.PrimaryButton
import com.zhasaApp.ui.common.views.ProgressBarButton
import com.zhasaApp.ui.login.models.LoginAction
import com.zhasaApp.ui.login.models.LoginState
import com.zhasaApp.ui.login.viewmodels.LoginViewModel
import com.zhasaApp.ui.theme.Colors
import com.zhasaApp.ui.theme.Size

@Composable
fun LoginView(loginViewModel: LoginViewModel) {
    val viewState = loginViewModel.publicState.collectAsState()
    val email =
        remember {
            mutableStateOf("")
        }
    val password = remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .background(color = Colors.BlackPrimary)
            .fillMaxWidth()
            .padding(start = Size.SPACE_2, end = Size.SPACE_2)
    ) {
        NormalText(text = "Войти", modifier = Modifier.padding(top = Size.SPACE_8))
        Spacer(modifier = Modifier.height(Size.SPACE_2))
        EmailInputView(email)
        Spacer(modifier = Modifier.height(Size.SPACE_2))
        PasswordInputView(password)
        Spacer(modifier = Modifier.height(Size.SPACE_2))
        if (viewState.value == LoginState.LoadingState) {
            ProgressBarButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(Size.SPACE_7)
            )
        } else {
            PrimaryButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(Size.SPACE_7),
                onClick = {
                    loginViewModel.obtainAction(LoginAction.Login(email.value, password.value))
                },
                text = "Добавить"
            )
        }
    }
}
