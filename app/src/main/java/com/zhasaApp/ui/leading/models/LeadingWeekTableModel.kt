package com.zhasaApp.ui.leading.models

import com.zhasaApp.domain.Amount

sealed class LeadingStatus {
    object GOOD : LeadingStatus()
    object NORMAL : LeadingStatus()
    object BAD : LeadingStatus()
}

fun generateLeadingStatus(expected: Amount, actual: Amount): LeadingStatus {
    if (actual == Amount(0L)) {
        return LeadingStatus.BAD
    }
    if (expected <= actual) {
        return LeadingStatus.GOOD
    }
    return LeadingStatus.NORMAL
}

class LeadingWeekTableModel private constructor(
    val amount: Amount,
    val leadingStatus: LeadingStatus
) {
    companion object {
        fun build(expected: Amount, actual: Amount): LeadingWeekTableModel {
            return LeadingWeekTableModel(
                Amount(actual.amount),
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
