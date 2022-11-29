package com.zhasaApp.ui.statistic.models

import com.zhasa.mvi.MiddleWare
import com.zhasaApp.domain.WeekAmounts
import com.zhasaApp.domain.models.YearWeeklyAmounts
import com.zhasaApp.repository.statistic.StatisticRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope

class StatisticMiddleWare(private val statisticRepository: StatisticRepository) :
    MiddleWare<StatisticAction> {

    override suspend fun effect(action: StatisticAction): StatisticAction {
        return coroutineScope {
            if (action is StatisticAction.LoadUserStatistic) {
                val result1 = async {
                    statisticRepository.userLeadingWeekStatistic(
                        userId = action.userId,
                        year = action.year.year(),
                        week = action.week.number
                    )
                }
                val result2 = async {
                    statisticRepository.userLeadingYearStatistic(
                        userId = action.userId,
                        year = action.year.year()
                    )
                }
                result1.await()
                result2.await()

                return@coroutineScope StatisticAction.ShowStatistic(
                    StatisticPresentation(
                        WeekAmounts(),
                        YearWeeklyAmounts(),
                        YearWeeklyAmounts()
                    )
                )
            }
            return@coroutineScope StatisticAction.NoAction
        }
    }
}
