package com.zhasaApp.repository.statistic

import com.zhasaApp.data.models.LaggingYearStatisticResponse
import com.zhasaApp.data.models.LeadingYearStatisticResponse

interface StatisticRepository {
    suspend fun leadingYearStatistic(): LeadingYearStatisticResponse
    suspend fun laggingYearStatistic(): LaggingYearStatisticResponse
}