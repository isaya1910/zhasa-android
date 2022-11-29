package com.zhasaApp.repository.statistic

import com.zhasaApp.data.api.Api
import com.zhasaApp.data.models.*
import com.zhasaApp.repository.error.safeApiCall
import com.zhasaApp.repository.models.Department
import com.zhasaApp.repository.result.RequestResult

interface StatisticRepository {
    suspend fun userLeadingYearStatistic(
        year: Int,
        userId: Int
    ): RequestResult<LeadingYearStatisticResponse>

    suspend fun userLaggingYearStatistic(
        year: Int,
        userId: Int
    ): RequestResult<LaggingYearStatisticResponse>

    suspend fun userLeadingWeekStatistic(
        year: Int,
        week: Int,
        userId: Int
    ): RequestResult<LeadingWeekStatisticResponse>

    suspend fun branchLeadingYearStatistic(
        year: Int,
        branchId: Int,
        department: Department
    ): RequestResult<LeadingYearStatisticResponse>

    suspend fun branchLaggingYearStatistic(
        year: Int,
        branchId: Int,
        department: Department
    ): RequestResult<LaggingYearStatisticResponse>

    suspend fun branchLeadingWeekStatistic(
        year: Int,
        week: Int,
        branchId: Int,
        department: Department
    ): RequestResult<LeadingWeekStatisticResponse>
}

internal class RemoteStatisticRepository(private val api: Api) : StatisticRepository {
    override suspend fun userLeadingYearStatistic(
        year: Int,
        userId: Int
    ): RequestResult<LeadingYearStatisticResponse> {
        return safeApiCall {
            api.yearLeadingData(
                StatisticYearRequest(
                    user = userId,
                    year = year
                )
            )
        }
    }

    override suspend fun userLaggingYearStatistic(
        year: Int,
        userId: Int
    ): RequestResult<LaggingYearStatisticResponse> {
        return safeApiCall {
            api.yearLaggingData(
                StatisticYearRequest(
                    user = userId,
                    year = year
                )
            )
        }
    }

    override suspend fun userLeadingWeekStatistic(
        year: Int,
        week: Int,
        userId: Int
    ): RequestResult<LeadingWeekStatisticResponse> {
        return safeApiCall {
            api.weekLeadingData(
                StatisticWeekRequest(
                    user = userId,
                    year = year,
                    week = week
                )
            )
        }
    }

    override suspend fun branchLeadingYearStatistic(
        year: Int,
        branchId: Int,
        department: Department
    ): RequestResult<LeadingYearStatisticResponse> {
        return safeApiCall {
            api.yearLeadingData(
                StatisticYearRequest(
                    year = year,
                    branch = branchId,
                    department = department.getDepartmentRequest()
                )
            )
        }
    }

    override suspend fun branchLaggingYearStatistic(
        year: Int,
        branchId: Int,
        department: Department
    ): RequestResult<LaggingYearStatisticResponse> {
        return safeApiCall {
            api.yearLaggingData(
                StatisticYearRequest(
                    year = year,
                    branch = branchId,
                    department = department.getDepartmentRequest()
                )
            )
        }
    }

    override suspend fun branchLeadingWeekStatistic(
        year: Int,
        week: Int,
        branchId: Int,
        department: Department
    ): RequestResult<LeadingWeekStatisticResponse> {
        return safeApiCall {
            api.weekLeadingData(
                StatisticWeekRequest(
                    year = year,
                    week = week,
                    branch = branchId,
                    department = department.getDepartmentRequest()
                )
            )
        }
    }

}