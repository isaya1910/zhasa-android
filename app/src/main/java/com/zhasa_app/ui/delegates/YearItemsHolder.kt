package com.zhasa_app.ui.delegates

import com.zhasa_app.ui.utils.YearWeekNumber

interface YearItemsHolder<T> {
    fun forEachWeek(action: (week: YearWeekNumber, item: T) -> Unit)
    fun put(week: YearWeekNumber, item: T)
    fun get(week: YearWeekNumber): T
}