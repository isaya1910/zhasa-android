package com.zhasaApp.ui.lagging.models

import com.zhasaApp.domain.Amount
import com.zhasaApp.domain.models.Percentage

data class LaggingWeekTableModel(
    val laggingAmount: Amount,
    val loanPortfolioAmount: Amount,
    val laggingPercentage: Percentage
)
