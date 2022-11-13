package com.zhasaApp.ui.charts

import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.zhasaApp.R
import com.zhasaApp.domain.Amount
import com.zhasaApp.domain.models.YearWeekNumber
import com.zhasaApp.domain.models.YearWeeklyAmounts
import com.zhasaApp.ui.charts.ChartColors.leading1Color
import com.zhasaApp.ui.charts.ChartColors.leading2Color
import com.zhasaApp.ui.charts.ChartColors.leading3Color
import com.zhasaApp.ui.charts.ChartColors.white

fun toLineChartEntry(week: YearWeekNumber, leadingModel: Amount): Entry = Entry(
    week.number.toFloat(),
    leadingModel.amount.toFloat()
)

fun LineChart.setYearData(
    weekAmountsModel1: YearWeeklyAmounts,
    weekAmountsModel2: YearWeeklyAmounts,
    weekAmountsModel3: YearWeeklyAmounts
) {
    val data1 = weekAmountsModel1.map { amountModel, day ->
        toLineChartEntry(day, amountModel)
    }
    val data2 = weekAmountsModel2.map { amountModel, day ->
        toLineChartEntry(day, amountModel)
    }
    val data3 = weekAmountsModel3.map { amountModel, day ->
        toLineChartEntry(day, amountModel)
    }

    val dataSet1 = LineDataSet(data1, "").apply {
        color = leading1Color
        mode = LineDataSet.Mode.CUBIC_BEZIER
        valueTextSize = 10f
        valueTextColor = white
        lineWidth = 3F
        setMaxVisibleValueCount(10)
    }

    val dataSet2 = LineDataSet(data2, "").apply {
        color = leading2Color
        mode = LineDataSet.Mode.CUBIC_BEZIER
        valueTextSize = 10f
        valueTextColor = white
        lineWidth = 3f
        setMaxVisibleValueCount(10)
    }
    val dataSet3 = LineDataSet(data3, "").apply {
        color = leading3Color
        mode = LineDataSet.Mode.CUBIC_BEZIER
        valueTextSize = 10f
        valueTextColor = white
        lineWidth = 3f
        setMaxVisibleValueCount(10)
    }

    this@setYearData.axisLeft.apply {
        isEnabled = false
    }
    this@setYearData.axisRight.apply {
        textColor = white
    }

    this@setYearData.xAxis.apply {
        textColor = white
        textSize = 8f
        setNoDataTextColor(white)
        setNoDataText(context.getString(R.string.no_data))
    }
    this@setYearData.data = LineData(
        dataSet1,
        dataSet2,
        dataSet3
    )
}
