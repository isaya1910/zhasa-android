package com.zhasaApp.ui.main

import com.zhasa.mvi.MiddleWare
import com.zhasa.mvi.Reducer
import com.zhasaApp.repository.UserState
import com.zhasaApp.repository.auth.AuthRepository
import com.zhasaApp.ui.common.viewmodel.BaseViewModel
import com.zhasaApp.ui.common.viewmodel.DispatcherProvider
import com.zhasaApp.ui.main.models.MainAction
import com.zhasaApp.ui.main.models.MainState
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainReducer : Reducer<MainAction, MainState> {
    override fun reduce(action: MainAction, state: MainState): MainState {
        return when (action) {
            MainAction.CheckAuth, MainAction.NoAction -> MainState.Splash
            MainAction.SignIn -> MainState.SignIn
            MainAction.SignOut -> MainState.SignOut
        }
    }
}

class MainMiddleWare(private val authRepository: AuthRepository) : MiddleWare<MainAction> {
    override suspend fun effect(action: MainAction): MainAction {
        when (authRepository.user.value) {
            is UserState.SignIn -> MainAction.SignIn
            UserState.SignOut -> MainAction.SignOut
        }
        return MainAction.NoAction
    }
}

class MainViewModel(
    override val reducer: Reducer<MainAction, MainState>,
    mainMiddleWare: MiddleWare<MainAction>,
    dispatcherProvider: DispatcherProvider
) : BaseViewModel<MainState, MainAction>(dispatcherProvider) {
    override val stateFlow: MutableStateFlow<MainState> = MutableStateFlow(MainState.Splash)

    val imStateFlow = stateFlow.asStateFlow()

    override val actionFlow: MutableSharedFlow<MainAction> = MutableSharedFlow()
    override val middleWares: List<MiddleWare<MainAction>> = listOf(mainMiddleWare)

    override val actionFilter: (action: MainAction) -> Boolean =
        { action -> action !is MainAction.NoAction }
}
