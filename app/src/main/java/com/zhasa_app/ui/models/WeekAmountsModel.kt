package com.zhasa_app.ui.models

import com.zhasa_app.ui.utils.WeekDayNumber


class WeekAmountsModel {

    private val days = Array(7) {
        AmountPresentation(0)
    }

    fun put(day: WeekDayNumber, amountPresentation: AmountPresentation) {
        days[day.dayNumber] = amountPresentation
    }

    fun <T> map(mapper: (amountPresentation: AmountPresentation, day: WeekDayNumber) -> T): List<T> {
        return days.mapIndexed { index, model ->
            mapper.invoke(model, WeekDayNumber(index))
        }
    }
}
