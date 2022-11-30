package com.zhasaApp.ui.statistic.leadingYearStatistic.models

import com.zhasa.mvi.MiddleWare
import com.zhasaApp.repository.result.RequestResult
import com.zhasaApp.repository.statistic.StatisticRepository
import com.zhasaApp.ui.statistic.leadingYearStatistic.StatisticMapper

class LeadingYearStatisticMiddleWare(
    private val statisticRepository: StatisticRepository,
    private val statisticMapper: StatisticMapper
) :
    MiddleWare<LeadingYearStatisticAction> {

    override suspend fun effect(action: LeadingYearStatisticAction): LeadingYearStatisticAction {
        if (action is LeadingYearStatisticAction.LoadUserLeadingYearStatistic) {
            val result = statisticRepository.userLeadingYearStatistic(
                userId = action.userId,
                year = action.year.year()
            )
            return when (result) {
                is RequestResult.Error -> LeadingYearStatisticAction.Error(
                    result.error
                )
                is RequestResult.Success -> LeadingYearStatisticAction.ShowLeadingYearStatistic(
                    statisticMapper.from(result.data)
                )
            }
        }
        return LeadingYearStatisticAction.NoAction
    }
}
