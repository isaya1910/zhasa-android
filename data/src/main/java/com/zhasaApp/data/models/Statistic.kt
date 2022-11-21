package com.zhasaApp.data.models

open class BaseListResponse<T>(val values: List<T>)

data class LaggingYearStatistic(val week: Int, val laggingSum: Long, val laggingIndicator: Long)
data class LeadingYearStatistic(val week: Int, val li1Sum: Long, val li2Sum: Long, val li3Sum: Long)

class LaggingYearStatisticResponse(values: List<LaggingYearStatistic>) :
    BaseListResponse<LaggingYearStatistic>(values)

class LeadingYearStatisticResponse(values: List<LeadingYearStatistic>) : BaseListResponse<LeadingYearStatistic>(values)