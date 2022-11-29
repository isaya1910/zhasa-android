package com.zhasaApp.ui.statistic.models

import com.zhasa.mvi.Action
import com.zhasaApp.domain.models.Year
import com.zhasaApp.domain.models.YearWeekNumber

sealed class StatisticAction : Action {
    data class LoadUserStatistic(val userId: Int, val week: YearWeekNumber, val year: Year) : StatisticAction()
    data class LoadBranchStatistic(val branchId: Int) : StatisticAction()
    data class ShowStatistic(val statisticPresentation: StatisticPresentation) : StatisticAction()
    object NoAction : StatisticAction()
}
