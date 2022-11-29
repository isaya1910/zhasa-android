package com.zhasaApp.data.models

import com.google.gson.annotations.SerializedName
import java.time.LocalDate

open class BaseListResponse<T>(val values: List<T>)

data class LaggingYearStatistic(
    val week: Int,
    @SerializedName("lagging_indicator_sum")
    val laggingSum: Long,
    @SerializedName("lagging_indicator")
    val laggingIndicator: Long
)

data class LeadingWeekStatistic(
    val date: LocalDate,
    val li1: Long,
    val li2: Long,
    val li3: Long
)

data class LeadingYearStatistic(
    @SerializedName("date__week")
    val week: Int,
    @SerializedName("li1_sum")
    val li1Sum: Long,
    @SerializedName("li2_sum")
    val li2Sum: Long,
    @SerializedName("li3_sum")
    val li3Sum: Long
)

data class StatisticYearRequest(
    val year: Int,
    val user: Int? = null,
    val branch: Int? = null,
    val department: String? = null
)

data class StatisticWeekRequest(
    val year: Int,
    val week: Int,
    val user: Int? = null,
    val branch: Int? = null,
    val department: String? = null
)

class LaggingYearStatisticResponse(values: List<LaggingYearStatistic>) :
    BaseListResponse<LaggingYearStatistic>(values)

class LeadingYearStatisticResponse(values: List<LeadingYearStatistic>) :
    BaseListResponse<LeadingYearStatistic>(values)

class LeadingWeekStatisticResponse(values: List<LeadingWeekStatistic>) :
    BaseListResponse<LeadingWeekStatistic>(values)