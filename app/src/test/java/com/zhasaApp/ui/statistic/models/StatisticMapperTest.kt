package com.zhasaApp.ui.statistic.models

import com.zhasaApp.data.models.LeadingWeekStatistic
import com.zhasaApp.data.models.LeadingWeekStatisticResponse
import com.zhasaApp.domain.Amount
import com.zhasaApp.domain.WeekAmounts
import com.zhasaApp.domain.models.WeekDayNumber
import com.zhasaApp.ui.statistic.leadingYearStatistic.LeadingWeekAmounts
import com.zhasaApp.ui.statistic.leadingYearStatistic.StatisticMapper
import org.junit.Assert
import org.junit.Test
import java.time.LocalDate

class StatisticMapperTest {

    private val testObject = StatisticMapper()

    @Test
    fun leadingWeekAmountsTest() {
        val given =
            LeadingWeekStatisticResponse(
                values = mutableListOf<LeadingWeekStatistic>().apply {
                    add(LeadingWeekStatistic(LocalDate.of(2022, 11, 30), 100, 100, 100))
                    add(LeadingWeekStatistic(LocalDate.of(2022, 12, 1), 200, 200, 200))
                    add(LeadingWeekStatistic(LocalDate.of(2022, 12, 2), 300, 300, 300))
                }
            )

        val actual = testObject.from(given)

        val expected = LeadingWeekAmounts(
            WeekAmounts().apply {
                put(WeekDayNumber(3), Amount(100))
                put(WeekDayNumber(4), Amount(200))
                put(WeekDayNumber(5), Amount(300))
            },
            WeekAmounts().apply {
                put(WeekDayNumber(3), Amount(100))
                put(WeekDayNumber(4), Amount(200))
                put(WeekDayNumber(5), Amount(300))
            },
            WeekAmounts().apply {
                put(WeekDayNumber(3), Amount(100))
                put(WeekDayNumber(4), Amount(200))
                put(WeekDayNumber(5), Amount(300))
            }
        )
        Assert.assertEquals(expected, actual)
    }
}
