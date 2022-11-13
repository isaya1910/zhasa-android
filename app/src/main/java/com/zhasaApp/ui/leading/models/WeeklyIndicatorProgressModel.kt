package com.zhasaApp.ui.leading.models

data class WeeklyIndicatorProgressModels(
    val leading1: WeeklyIndicatorProgressModel,
    val leading2: WeeklyIndicatorProgressModel,
    val leading3: WeeklyIndicatorProgressModel
)

data class WeeklyIndicatorProgressModel(
    val progress: Float,
    val amountAndGoal: String,
    val title: String
)
