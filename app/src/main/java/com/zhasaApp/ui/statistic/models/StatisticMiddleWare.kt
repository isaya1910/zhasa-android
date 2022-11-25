package com.zhasaApp.ui.statistic.models

import com.zhasa.mvi.MiddleWare
import com.zhasaApp.repository.statistic.StatisticRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope

class StatisticMiddleWare(private val statisticRepository: StatisticRepository) :
    MiddleWare<StatisticAction> {

    override suspend fun effect(action: StatisticAction): StatisticAction {
        return coroutineScope {
            val result1 = async {
                statisticRepository.leadingYearStatistic()
            }
            val result2 = async {
                statisticRepository.laggingYearStatistic()
            }
            result1.await()
            result2.await()
            return@coroutineScope StatisticAction.LoadStatistic
        }
    }
}