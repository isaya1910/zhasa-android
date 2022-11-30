package com.zhasaApp.ui.statistic.leadingYearStatistic.models

import com.zhasa.mvi.State
import com.zhasaApp.ui.statistic.leadingYearStatistic.LeadingYearAmounts

sealed class LeadingYearStatisticState : State {
    object Initial : LeadingYearStatisticState()
    object Loading : LeadingYearStatisticState()
    data class Success(val leadingYearAmounts: LeadingYearAmounts) : LeadingYearStatisticState()
    data class Error(val errorMessage: String) : LeadingYearStatisticState()
}
