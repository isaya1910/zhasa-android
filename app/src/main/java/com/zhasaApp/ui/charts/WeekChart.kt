package com.zhasaApp.ui.charts

import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.zhasaApp.domain.Amount
import com.zhasaApp.domain.WeekAmounts
import com.zhasaApp.domain.models.DateUtilImpl
import com.zhasaApp.domain.models.WeekDayNumber
import com.zhasaApp.ui.charts.ChartColors.leading1Color
import com.zhasaApp.ui.charts.ChartColors.leading2Color
import com.zhasaApp.ui.charts.ChartColors.leading3Color
import com.zhasaApp.ui.charts.ChartColors.white

fun toLineChartEntry(day: WeekDayNumber, leadingModel: Amount): Entry = Entry(
    day.dayNumber.toFloat(),
    leadingModel.amount.toFloat()
)

fun LineChart.setWeekData(
    weekAmountsModel1: WeekAmounts,
    weekAmountsModel2: WeekAmounts,
    weekAmountsModel3: WeekAmounts
) {
    val data1 = weekAmountsModel1.map { (day, amount) ->
        toLineChartEntry(day, amount)
    }
    val data2 = weekAmountsModel2.map { (day, amount) ->
        toLineChartEntry(day, amount)
    }
    val data3 = weekAmountsModel3.map { (day, amount) ->
        toLineChartEntry(day, amount)
    }

    val dataSet1 = LineDataSet(data1, "").apply {
        color = leading1Color
        mode = LineDataSet.Mode.CUBIC_BEZIER
        valueTextSize = 10f
        valueTextColor = white
        lineWidth = 3F
    }

    val dataSet2 = LineDataSet(data2, "").apply {
        color = leading2Color
        mode = LineDataSet.Mode.CUBIC_BEZIER
        valueTextSize = 10f
        valueTextColor = white
        lineWidth = 3f
    }
    val dataSet3 = LineDataSet(data3, "").apply {
        color = leading3Color
        mode = LineDataSet.Mode.CUBIC_BEZIER
        valueTextSize = 10f
        valueTextColor = white
        lineWidth = 3f
    }

    val dateUtil = DateUtilImpl()

    this.axisRight.apply {
        textColor = white
    }

    this.axisLeft.apply {
        isEnabled = false
    }

    this.xAxis.apply {
        valueFormatter = IndexAxisValueFormatter(dateUtil.getCurrentWeekDates().dates)
        textColor = white
        textSize = 8f
        setNoDataTextColor(white)
        setNoDataText("No data")
    }
    this.data = LineData(
        dataSet1,
        dataSet2,
        dataSet3
    )
}
