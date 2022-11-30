package com.zhasaApp.ui.statistic.leadingYearStatistic

import com.zhasaApp.data.models.LaggingYearStatisticResponse
import com.zhasaApp.data.models.LeadingWeekStatisticResponse
import com.zhasaApp.data.models.LeadingYearStatisticResponse
import com.zhasaApp.domain.Amount
import com.zhasaApp.domain.WeekAmounts
import com.zhasaApp.domain.models.YearWeekNumber
import com.zhasaApp.domain.models.YearWeeklyAmounts
import com.zhasaApp.domain.models.toWeekDayNumber

data class LeadingYearAmounts(
    val amounts1: YearWeeklyAmounts,
    val amounts2: YearWeeklyAmounts,
    val amounts3: YearWeeklyAmounts
)

data class LaggingAmounts(
    val sumAmounts: YearWeeklyAmounts,
    val indicatorAmounts: YearWeeklyAmounts
)

data class LeadingWeekAmounts(
    val amounts1: WeekAmounts,
    val amounts2: WeekAmounts,
    val amounts3: WeekAmounts
)

class StatisticMapper {

    fun from(from: LeadingWeekStatisticResponse): LeadingWeekAmounts {
        val weekAmounts1 = WeekAmounts()
        val weekAmounts2 = WeekAmounts()
        val weekAmounts3 = WeekAmounts()
        from.values.forEach {
            weekAmounts1.put(it.date.toWeekDayNumber(), Amount(it.li1))
            weekAmounts2.put(it.date.toWeekDayNumber(), Amount(it.li2))
            weekAmounts3.put(it.date.toWeekDayNumber(), Amount(it.li3))
        }
        return LeadingWeekAmounts(weekAmounts1, weekAmounts2, weekAmounts3)
    }

    fun from(from: LeadingYearStatisticResponse): LeadingYearAmounts {
        val yearWeeklyAmounts1 = YearWeeklyAmounts()
        val yearWeeklyAmounts2 = YearWeeklyAmounts()
        val yearWeeklyAmounts3 = YearWeeklyAmounts()
        from.values.forEach {
            yearWeeklyAmounts1.put(YearWeekNumber(it.week), Amount(it.li1Sum))
            yearWeeklyAmounts2.put(YearWeekNumber(it.week), Amount(it.li2Sum))
            yearWeeklyAmounts3.put(YearWeekNumber(it.week), Amount(it.li3Sum))
        }
        return LeadingYearAmounts(yearWeeklyAmounts1, yearWeeklyAmounts2, yearWeeklyAmounts3)
    }

    fun from(from: LaggingYearStatisticResponse): LaggingAmounts {
        val indicatorAmounts = YearWeeklyAmounts()
        val sumAmounts = YearWeeklyAmounts()
        from.values.forEach {
            indicatorAmounts.put(YearWeekNumber(it.week), Amount(it.laggingIndicator))
            sumAmounts.put(YearWeekNumber(it.week), Amount((it.laggingSum)))
        }
        return LaggingAmounts(indicatorAmounts, sumAmounts)
    }
}
