package com.zhasaApp.ui.statistic.models

import com.zhasa.mvi.State

sealed class StatisticState: State {
    object Initial: StatisticState()
    object Loading: StatisticState()
    object StatisticSuccess: StatisticState()
}