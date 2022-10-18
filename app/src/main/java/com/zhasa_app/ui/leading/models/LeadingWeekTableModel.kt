package com.zhasa_app.ui.leading.models

import com.zhasa_app.domain.AmountModel
import com.zhasa_app.ui.delegates.AmountPresentationDelegate
import com.zhasa_app.ui.delegates.YearItemsHolder
import com.zhasa_app.ui.models.AmountPresentation
import com.zhasa_app.ui.utils.YearWeekNumber

sealed class LeadingStatus {
    object GOOD : LeadingStatus()
    object NORMAL : LeadingStatus()
    object BAD : LeadingStatus()
}

fun generateLeadingStatus(expected: AmountModel, actual: AmountModel): LeadingStatus {
    if (actual == AmountModel(0L)) {
        return LeadingStatus.BAD
    }
    if (expected <= actual) {
        return LeadingStatus.GOOD
    }
    return LeadingStatus.NORMAL
}

class LeadingWeekTableModel private constructor(
    val amountPresentation: AmountPresentation,
    val leadingStatus: LeadingStatus
) {
    companion object {
        fun build(expected: AmountModel, actual: AmountModel): LeadingWeekTableModel {
            return LeadingWeekTableModel(
                AmountPresentation(actual.amount),
                generateLeadingStatus(expected, actual)
            )
        }
    }

}

class LeadingTableItem(
    val leading1: LeadingWeekTableModel,
    val leading2: LeadingWeekTableModel,
    val leading3: LeadingWeekTableModel
)

class LeadingYearTableItemsHolder : YearItemsHolder<LeadingTableItem> {
    private val weeks = Array(53) {
        LeadingTableItem(
            leading1 = LeadingWeekTableModel.build(AmountModel(), AmountModel()),
            leading2 = LeadingWeekTableModel.build(AmountModel(), AmountModel()),
            leading3 = LeadingWeekTableModel.build(AmountModel(), AmountModel())
        )
    }

    override fun forEachWeek(action: (week: YearWeekNumber, leadingTableItem: LeadingTableItem) -> Unit) {
        weeks.forEachIndexed { index, item ->
            action.invoke(YearWeekNumber(index), item)
        }
    }

    override fun put(week: YearWeekNumber, item: LeadingTableItem) {
        weeks[week.number] = item
    }

    override fun get(week: YearWeekNumber): LeadingTableItem {
        return weeks[week.number]
    }
}