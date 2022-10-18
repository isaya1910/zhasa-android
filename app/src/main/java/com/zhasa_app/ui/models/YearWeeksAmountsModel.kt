package com.zhasa_app.ui.models

import com.zhasa_app.ui.utils.YearWeekNumber

class YearWeeksAmountsModel {
    private val weeks = Array(53) {
        AmountPresentation(0)
    }

    fun put(week: YearWeekNumber, amountPresentation: AmountPresentation) {
        weeks[week.number] = amountPresentation
    }

    fun <T> map(mapper: (amountPresentation: AmountPresentation, day: YearWeekNumber) -> T): List<T> {
        return weeks.mapIndexed { index, model ->
            mapper.invoke(model, YearWeekNumber(index))
        }
    }
}