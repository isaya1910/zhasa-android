package com.zhasaApp.ui.statistic.models

import com.zhasaApp.domain.WeekAmounts
import com.zhasaApp.domain.models.YearWeeklyAmounts

data class StatisticPresentation(
    val leadingWeekStatistic: WeekAmounts,
    val leadingYearStatistic: YearWeeklyAmounts,
    val laggingYearStatistic: YearWeeklyAmounts
)
