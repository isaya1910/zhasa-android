package com.zhasaApp.ui.login.viewmodels

import com.zhasa.mvi.MiddleWare
import com.zhasa.mvi.Reducer
import com.zhasaApp.repository.auth.AuthRepository
import com.zhasaApp.repository.result.RequestResult
import com.zhasaApp.ui.common.viewmodel.BaseViewModel
import com.zhasaApp.ui.common.viewmodel.DispatcherProvider
import com.zhasaApp.ui.login.models.LoginAction
import com.zhasaApp.ui.login.models.LoginMiddleWare
import com.zhasaApp.ui.login.models.LoginReducer
import com.zhasaApp.ui.login.models.LoginState
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class LoginViewModel(
    loginMiddleWare: LoginMiddleWare,
    loginReducer: LoginReducer,
    dispatcherProvider: DispatcherProvider
) :
    BaseViewModel<LoginState, LoginAction>(dispatcherProvider) {
    override val stateFlow: MutableStateFlow<LoginState> = MutableStateFlow(LoginState.InitialState)
    val publicState: StateFlow<LoginState> = stateFlow.asStateFlow()

    override val actionFlow: MutableSharedFlow<LoginAction> = MutableSharedFlow()

    override val middleWares: List<MiddleWare<LoginAction>> = listOf(loginMiddleWare)
    override val reducer: Reducer<LoginAction, LoginState> = loginReducer
    override val actionFilter: (action: LoginAction) -> Boolean = { it !is LoginAction.NoAction }
}
