package com.zhasaApp.ui.statistic.models

import com.zhasa.mvi.Reducer

class StatisticReducer : Reducer<StatisticAction, StatisticState> {
    override fun reduce(action: StatisticAction, state: StatisticState): StatisticState {
        return StatisticState.Loading
    }
}