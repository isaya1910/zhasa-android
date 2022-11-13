package com.zhasaApp.ui.login.viewmodels

import com.zhasa.mvi.MiddleWare
import com.zhasa.mvi.Reducer
import com.zhasaApp.repository.auth.AuthRepository
import com.zhasaApp.repository.result.RequestResult
import com.zhasaApp.ui.common.viewmodel.BaseViewModel
import com.zhasaApp.ui.login.models.LoginAction
import com.zhasaApp.ui.login.models.LoginState
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class AuthMiddleWare(private val authRepository: AuthRepository) : MiddleWare<LoginAction> {
    override suspend fun effect(action: LoginAction): LoginAction {
        if (action is LoginAction.Login) {
            return when (authRepository.authenticate(action.email, action.password)) {
                is RequestResult.Error -> LoginAction.Error
                is RequestResult.Success -> LoginAction.Succeed
            }
        }
        return LoginAction.NoAction
    }
}

class AuthReducer : Reducer<LoginAction, LoginState> {
    override fun reduce(action: LoginAction, state: LoginState): LoginState =
        when (action) {
            is LoginAction.Error -> LoginState.ErrorState("error")
            is LoginAction.Login -> LoginState.LoadingState
            is LoginAction.NoAction -> LoginState.InitialState
            is LoginAction.Succeed -> LoginState.SuccessState
        }
}

class AuthViewModel(authMiddleWare: AuthMiddleWare, authReducer: AuthReducer) :
    BaseViewModel<LoginState, LoginAction>() {
    override val stateFlow: MutableStateFlow<LoginState> = MutableStateFlow(LoginState.InitialState)
    val publicState: StateFlow<LoginState> = stateFlow.asStateFlow()

    override val actionFlow: MutableSharedFlow<LoginAction> = MutableSharedFlow()

    override val middleWares: List<MiddleWare<LoginAction>> = listOf(authMiddleWare)
    override val reducer: Reducer<LoginAction, LoginState> = authReducer
    override val actionFilter: (action: LoginAction) -> Boolean = { it !is LoginAction.NoAction }
}
