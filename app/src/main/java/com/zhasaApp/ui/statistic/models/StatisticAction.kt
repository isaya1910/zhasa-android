package com.zhasaApp.ui.statistic.models

import com.zhasa.mvi.Action

sealed class StatisticAction : Action {
    object LoadStatistic: StatisticAction()
    object NoAction: StatisticAction()
}