package com.zhasa_app.ui.auth.viewmodels

import com.zhasa.mvi.MiddleWare
import com.zhasa.mvi.Reducer
import com.zhasa_app.repository.auth.AuthRepository
import com.zhasa_app.repository.result.RequestResult
import com.zhasa_app.ui.auth.models.AuthAction
import com.zhasa_app.ui.auth.models.AuthState
import com.zhasa_app.ui.common.viewmodel.BaseViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class AuthMiddleWare(private val authRepository: AuthRepository) : MiddleWare<AuthAction> {
    override suspend fun effect(action: AuthAction): AuthAction {
        if (action is AuthAction.Login) {
            return when (authRepository.authenticate(action.email, action.password)) {
                is RequestResult.Error -> AuthAction.Error
                is RequestResult.Success -> AuthAction.Succeed
            }
        }
        return AuthAction.NoAction
    }
}

class AuthReducer : Reducer<AuthAction, AuthState> {
    override fun reduce(action: AuthAction, state: AuthState): AuthState =
        when (action) {
            is AuthAction.Error -> AuthState.ErrorState("error")
            is AuthAction.Login -> AuthState.LoadingState
            is AuthAction.NoAction -> AuthState.InitialState
            is AuthAction.Succeed -> AuthState.SuccessState
        }
}


class AuthViewModel(authMiddleWare: AuthMiddleWare, authReducer: AuthReducer) :
    BaseViewModel<AuthState, AuthAction>() {

    override val stateFlow: MutableStateFlow<AuthState> = MutableStateFlow(AuthState.InitialState)
    val publicState: StateFlow<AuthState> = stateFlow.asStateFlow()

    override val actionFlow: MutableSharedFlow<AuthAction> = MutableSharedFlow()

    override val middleWares: List<MiddleWare<AuthAction>> = listOf(authMiddleWare)
    override val reducer: Reducer<AuthAction, AuthState> = authReducer
    override val actionFilter: (action: AuthAction) -> Boolean = { it !is AuthAction.NoAction }


}