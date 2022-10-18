package com.zhasa_app.ui.charts

import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.zhasa_app.ui.charts.ChartColors.leading1Color
import com.zhasa_app.ui.charts.ChartColors.leading2Color
import com.zhasa_app.ui.charts.ChartColors.leading3Color
import com.zhasa_app.ui.charts.ChartColors.white
import com.zhasa_app.ui.models.AmountPresentation
import com.zhasa_app.ui.models.WeekAmountsModel
import com.zhasa_app.ui.utils.DateUtilImpl
import com.zhasa_app.ui.utils.WeekDayNumber

fun toLineChartEntry(day: WeekDayNumber, leadingModel: AmountPresentation): Entry = Entry(
    day.dayNumber.toFloat(),
    leadingModel.value.toFloat(),
)


fun LineChart.setWeekData(
    weekAmountsModel1: WeekAmountsModel,
    weekAmountsModel2: WeekAmountsModel,
    weekAmountsModel3: WeekAmountsModel
) {
    val data1 = weekAmountsModel1.map { leadingModel, day ->
        toLineChartEntry(day, leadingModel)
    }
    val data2 = weekAmountsModel2.map { leadingModel, day ->
        toLineChartEntry(day, leadingModel)
    }
    val data3 = weekAmountsModel3.map { leadingModel, day ->
        toLineChartEntry(day, leadingModel)
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
        dataSet1, dataSet2, dataSet3
    )
}
