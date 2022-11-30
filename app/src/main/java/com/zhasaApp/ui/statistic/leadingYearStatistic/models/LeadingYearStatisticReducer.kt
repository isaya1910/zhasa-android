package com.zhasaApp.ui.statistic.leadingYearStatistic.models

import com.zhasa.mvi.Reducer

class LeadingYearStatisticReducer : Reducer<LeadingYearStatisticAction, LeadingYearStatisticState> {
    override fun reduce(
        action: LeadingYearStatisticAction,
        state: LeadingYearStatisticState
    ): LeadingYearStatisticState {
        return when (action) {
            is LeadingYearStatisticAction.Error -> LeadingYearStatisticState.Error(action.errorMessage)
            is LeadingYearStatisticAction.LoadBranchLeadingYearStatistic -> LeadingYearStatisticState.Loading
            is LeadingYearStatisticAction.LoadUserLeadingYearStatistic -> LeadingYearStatisticState.Loading
            is LeadingYearStatisticAction.NoAction -> LeadingYearStatisticState.Initial
            is LeadingYearStatisticAction.ShowLeadingYearStatistic -> LeadingYearStatisticState.Success(
                action.statisticPresentation
            )
        }
    }
}
