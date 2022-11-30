package com.zhasaApp.ui.statistic.leadingYearStatistic.models

import com.zhasa.mvi.Action
import com.zhasaApp.domain.models.Year
import com.zhasaApp.domain.models.YearWeekNumber
import com.zhasaApp.ui.statistic.leadingYearStatistic.LeadingYearAmounts

sealed class LeadingYearStatisticAction : Action {
    data class LoadUserLeadingYearStatistic(val userId: Int, val week: YearWeekNumber, val year: Year) : LeadingYearStatisticAction()
    data class LoadBranchLeadingYearStatistic(val branchId: Int) : LeadingYearStatisticAction()
    data class ShowLeadingYearStatistic(val statisticPresentation: LeadingYearAmounts) : LeadingYearStatisticAction()
    object NoAction : LeadingYearStatisticAction()
    data class Error(val errorMessage: String) : LeadingYearStatisticAction()
}
