package com.zhasaApp.ui.statistic.models

import com.zhasaApp.data.models.LaggingYearStatisticResponse
import com.zhasaApp.data.models.LeadingWeekStatisticResponse
import com.zhasaApp.data.models.LeadingYearStatisticResponse
import com.zhasaApp.repository.models.Department
import com.zhasaApp.repository.result.RequestResult
import com.zhasaApp.repository.statistic.StatisticRepository
import com.zhasaApp.ui.statistic.leadingYearStatistic.StatisticMapper
import com.zhasaApp.ui.statistic.leadingYearStatistic.models.LeadingYearStatisticMiddleWare
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

class LeadingYearStatisticMiddleWareTest {
    private val statisticRepository = object : StatisticRepository {
        override suspend fun userLeadingYearStatistic(
            year: Int,
            userId: Int
        ): RequestResult<LeadingYearStatisticResponse> {
            TODO("Not yet implemented")
        }

        override suspend fun userLaggingYearStatistic(
            year: Int,
            userId: Int
        ): RequestResult<LaggingYearStatisticResponse> {
            TODO("Not yet implemented")
        }

        override suspend fun userLeadingWeekStatistic(
            year: Int,
            week: Int,
            userId: Int
        ): RequestResult<LeadingWeekStatisticResponse> {
            TODO("Not yet implemented")
        }

        override suspend fun branchLeadingYearStatistic(
            year: Int,
            branchId: Int,
            department: Department
        ): RequestResult<LeadingYearStatisticResponse> {
            TODO("Not yet implemented")
        }

        override suspend fun branchLaggingYearStatistic(
            year: Int,
            branchId: Int,
            department: Department
        ): RequestResult<LaggingYearStatisticResponse> {
            TODO("Not yet implemented")
        }

        override suspend fun branchLeadingWeekStatistic(
            year: Int,
            week: Int,
            branchId: Int,
            department: Department
        ): RequestResult<LeadingWeekStatisticResponse> {
            TODO("Not yet implemented")
        }
    }
    private val testObject = LeadingYearStatisticMiddleWare(statisticRepository, StatisticMapper())

    @Test
    fun test() = runBlocking {
        val start = System.currentTimeMillis()
        println((System.currentTimeMillis() - start) / 1000)
        Assert.assertEquals(10, 10)
    }
}
