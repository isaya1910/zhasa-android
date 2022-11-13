package com.zhasaApp.ui.main.models

import com.zhasa.mvi.Action

sealed class MainAction : Action {
    object CheckAuth : MainAction()
    object NoAction : MainAction()
    object SignIn : MainAction()
    object SignOut : MainAction()
}
