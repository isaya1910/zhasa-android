package com.zhasaApp.ui.statistic.models

import com.zhasaApp.data.models.LaggingYearStatisticResponse
import com.zhasaApp.data.models.LeadingYearStatisticResponse
import com.zhasaApp.domain.Amount
import com.zhasaApp.domain.models.Year
import com.zhasaApp.domain.models.YearWeekNumber
import com.zhasaApp.domain.models.YearWeeklyAmounts

data class LeadingWeeklyAmounts(
    val amounts1: YearWeeklyAmounts,
    val amounts2: YearWeeklyAmounts,
    val amounts3: YearWeeklyAmounts
)

data class LaggingAmounts(
    val sumAmounts: YearWeeklyAmounts,
    val indicatorAmounts: YearWeeklyAmounts
)

class StatisticMapper {
    fun to(from: LeadingYearStatisticResponse): LeadingWeeklyAmounts {
        val yearWeeklyAmounts1 = YearWeeklyAmounts()
        val yearWeeklyAmounts2 = YearWeeklyAmounts()
        val yearWeeklyAmounts3 = YearWeeklyAmounts()
        from.values.forEach {
            yearWeeklyAmounts1.put(YearWeekNumber(it.week), Amount(it.li1Sum))
            yearWeeklyAmounts2.put(YearWeekNumber(it.week), Amount(it.li2Sum))
            yearWeeklyAmounts3.put(YearWeekNumber(it.week), Amount(it.li3Sum))
        }
        return LeadingWeeklyAmounts(yearWeeklyAmounts1, yearWeeklyAmounts2, yearWeeklyAmounts3)
    }

    fun to(from: LaggingYearStatisticResponse): LaggingAmounts {
        val indicatorAmounts = YearWeeklyAmounts()
        val sumAmounts = YearWeeklyAmounts()
        from.values.forEach {
            indicatorAmounts.put(YearWeekNumber(it.week), Amount(it.laggingIndicator))
            sumAmounts.put(YearWeekNumber(it.week), Amount((it.laggingSum)))
        }
        return LaggingAmounts(indicatorAmounts, sumAmounts)
    }
}