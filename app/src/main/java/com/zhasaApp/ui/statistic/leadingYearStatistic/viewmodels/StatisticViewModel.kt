package com.zhasaApp.ui.statistic.leadingYearStatistic.viewmodels

import com.zhasa.mvi.MiddleWare
import com.zhasa.mvi.Reducer
import com.zhasaApp.ui.common.viewmodel.BaseViewModel
import com.zhasaApp.ui.common.viewmodel.DispatcherProvider
import com.zhasaApp.ui.statistic.leadingYearStatistic.models.LeadingYearStatisticAction
import com.zhasaApp.ui.statistic.leadingYearStatistic.models.LeadingYearStatisticMiddleWare
import com.zhasaApp.ui.statistic.leadingYearStatistic.models.LeadingYearStatisticReducer
import com.zhasaApp.ui.statistic.leadingYearStatistic.models.LeadingYearStatisticState
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow

class StatisticViewModel(dispatcherProvider: DispatcherProvider, middleWare: LeadingYearStatisticMiddleWare) :
    BaseViewModel<LeadingYearStatisticState, LeadingYearStatisticAction>(dispatcherProvider) {
    override val stateFlow: MutableStateFlow<LeadingYearStatisticState> =
        MutableStateFlow(LeadingYearStatisticState.Initial)
    override val actionFlow: MutableSharedFlow<LeadingYearStatisticAction> = MutableSharedFlow()
    override val middleWares: List<MiddleWare<LeadingYearStatisticAction>> = listOf(middleWare)

    override val reducer: Reducer<LeadingYearStatisticAction, LeadingYearStatisticState> = LeadingYearStatisticReducer()
    override val actionFilter: (action: LeadingYearStatisticAction) -> Boolean =
        { it -> it !is LeadingYearStatisticAction.NoAction }
}
