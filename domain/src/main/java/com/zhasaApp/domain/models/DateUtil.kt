package com.zhasaApp.domain.models

import java.time.DayOfWeek
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.temporal.IsoFields
import java.time.temporal.TemporalAdjusters

@JvmInline
value class WeekDates(val dates: List<String>) {
    init {
        require(dates.size == 7)
    }
}


@JvmInline
value class WeekDayNumber(val dayNumber: Int) {
    init {
        require(dayNumber >= 0)
        require(dayNumber < 7)
    }
}


@JvmInline
value class YearWeekNumber(val number: Int) {
    init {
        require(number >= 0)
        require(number <= 53)
    }
}

interface DateUtil {
    fun getWeekDatesByWeekNumberUtil(yearWeekNumber: YearWeekNumber): WeekDates
    fun getCurrentWeekDates(): WeekDates
}

class DateUtilImpl(private val localDate: LocalDate = LocalDate.now()) : DateUtil {

    override fun getWeekDatesByWeekNumberUtil(yearWeekNumber: YearWeekNumber): WeekDates {
        val weekDates = mutableListOf<LocalDate>()
        val desiredDate = localDate
            .with(IsoFields.WEEK_OF_WEEK_BASED_YEAR, yearWeekNumber.number.toLong())
            .with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY))
        weekDates.add(desiredDate)
        (1..6).forEach {
            weekDates.add(desiredDate.plusDays(it.toLong()))
        }
        return WeekDates(weekDates.map {
            it.format(DateTimeFormatter.ofPattern("dd.MM"))
        })
    }

    override fun getCurrentWeekDates(): WeekDates {
        val currentWeek = LocalDate.now().get(
            IsoFields.WEEK_OF_WEEK_BASED_YEAR
        )
        return getWeekDatesByWeekNumberUtil(YearWeekNumber(currentWeek))
    }
}

