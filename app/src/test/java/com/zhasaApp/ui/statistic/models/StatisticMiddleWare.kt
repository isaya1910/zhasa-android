package com.zhasaApp.ui.statistic.models

import com.zhasaApp.data.models.LaggingYearStatisticResponse
import com.zhasaApp.data.models.LeadingYearStatisticResponse
import com.zhasaApp.repository.statistic.StatisticRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class StatisticMiddleWareTest {
    private val statisticRepository = object : StatisticRepository {
        override suspend fun leadingYearStatistic(): LeadingYearStatisticResponse {
            delay(3000)
            return LeadingYearStatisticResponse(listOf())
        }

        override suspend fun laggingYearStatistic(): LaggingYearStatisticResponse {
            delay(3000)
            return LaggingYearStatisticResponse(listOf())
        }

    }
    val testObject = StatisticMiddleWare(statisticRepository)

    @Test
    fun test() = runBlocking {
        val start = System.currentTimeMillis()
        testObject.effect(StatisticAction.LoadStatistic)
        println((System.currentTimeMillis() - start)/1000)
        Assert.assertEquals(10, 10)
    }
}