package com.zhasaApp.ui.splash.viewmodels

import com.zhasa.mvi.MiddleWare
import com.zhasa.mvi.Reducer
import com.zhasaApp.ui.common.viewmodel.BaseViewModel
import com.zhasaApp.ui.common.viewmodel.DispatcherProvider
import com.zhasaApp.ui.splash.models.SplashAction
import com.zhasaApp.ui.splash.models.SplashMiddleWare
import com.zhasaApp.ui.splash.models.SplashReducer
import com.zhasaApp.ui.splash.models.SplashState
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow

class SplashViewModel(
    splashMiddleWare: SplashMiddleWare,
    splashReducer: SplashReducer,
    dispatcherProvider: DispatcherProvider
) :
    BaseViewModel<SplashState, SplashAction>(dispatcherProvider) {
    override val stateFlow: MutableStateFlow<SplashState> =
        MutableStateFlow(SplashState.InitialState)
    override val actionFlow: MutableSharedFlow<SplashAction> = MutableSharedFlow()
    override val middleWares: List<MiddleWare<SplashAction>> = listOf(splashMiddleWare)
    override val reducer: Reducer<SplashAction, SplashState> = splashReducer
    override val actionFilter: (action: SplashAction) -> Boolean =
        { a -> a !is SplashAction.NoAction }
}
