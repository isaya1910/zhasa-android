package com.zhasaApp.domain.models

import com.zhasaApp.domain.Amount

class YearWeeklyAmounts {
    private val weeks = Array(53) {
        Amount(0)
    }

    fun put(week: YearWeekNumber, amount: Amount) {
        weeks[week.number] = amount
    }

    fun <T> map(mapper: (amount: Amount, day: YearWeekNumber) -> T): List<T> {
        return weeks.mapIndexed { index, model ->
            mapper.invoke(model, YearWeekNumber(index))
        }
    }
}