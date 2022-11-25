package com.zhasaApp.ui.statistic.viewmodels

import com.zhasa.mvi.MiddleWare
import com.zhasa.mvi.Reducer
import com.zhasaApp.ui.common.viewmodel.BaseViewModel
import com.zhasaApp.ui.common.viewmodel.DispatcherProvider
import com.zhasaApp.ui.statistic.models.StatisticAction
import com.zhasaApp.ui.statistic.models.StatisticMiddleWare
import com.zhasaApp.ui.statistic.models.StatisticReducer
import com.zhasaApp.ui.statistic.models.StatisticState
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow

class StatisticViewModel(dispatcherProvider: DispatcherProvider, middleWare: StatisticMiddleWare) :
    BaseViewModel<StatisticState, StatisticAction>(dispatcherProvider) {
    override val stateFlow: MutableStateFlow<StatisticState> =
        MutableStateFlow(StatisticState.StatisticSuccess)
    override val actionFlow: MutableSharedFlow<StatisticAction> = MutableSharedFlow()
    override val middleWares: List<MiddleWare<StatisticAction>> = listOf(middleWare)

    override val reducer: Reducer<StatisticAction, StatisticState> = StatisticReducer()
    override val actionFilter: (action: StatisticAction) -> Boolean =
        { it -> it !is StatisticAction.NoAction }
}