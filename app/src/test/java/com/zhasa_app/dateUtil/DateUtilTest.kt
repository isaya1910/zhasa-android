package com.zhasa_app.dateUtil

import com.zhasa_app.ui.utils.DateUtilImpl
import com.zhasa_app.ui.utils.WeekDates
import com.zhasa_app.ui.utils.YearWeekNumber
import junit.framework.Assert.assertEquals
import org.junit.Test
import java.time.LocalDate

class DateUtilTest {
    @Test
    fun `should return 7 days by week number`() {
        val localDate = LocalDate.of(2022, 9, 26)
        val testObject = DateUtilImpl(localDate)

        val expected = WeekDates(dates = listOf("03.01", "04.01", "05.01", "06.01", "07.01", "08.01", "09.01"))
        val actual = testObject.getWeekDatesByWeekNumberUtil(YearWeekNumber(1))
        assertEquals(expected, actual)
    }
}