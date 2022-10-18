package com.zhasa_app.ui.lagging.models

import com.zhasa_app.ui.delegates.YearItemsHolder
import com.zhasa_app.ui.models.AmountPresentation
import com.zhasa_app.ui.models.Percentage
import com.zhasa_app.ui.utils.YearWeekNumber


data class LaggingTableModel(
    val laggingAmount: AmountPresentation,
    val loanPortfolioAmount: AmountPresentation,
    val laggingPercentage: Percentage
)

class LaggingYearTableItemsHolder : YearItemsHolder<LaggingTableModel> {
    private val weeks = Array(53) {
        LaggingTableModel(
            AmountPresentation(0),
            AmountPresentation(0),
            Percentage(0f)
        )
    }

    override fun forEachWeek(action: (week: YearWeekNumber, item: LaggingTableModel) -> Unit) {
        weeks.forEachIndexed { index, laggingTableModel ->
            action.invoke(YearWeekNumber(index), laggingTableModel)
        }
    }

    override fun put(week: YearWeekNumber, item: LaggingTableModel) {
        weeks[week.number] = item
    }

    override fun get(week: YearWeekNumber): LaggingTableModel {
        return weeks[week.number]
    }
}
