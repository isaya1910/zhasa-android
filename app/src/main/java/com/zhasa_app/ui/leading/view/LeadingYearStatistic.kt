package com.zhasa_app.ui.leading.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import com.github.mikephil.charting.charts.LineChart
import com.zhasa_app.ui.charts.setYearData
import com.zhasa_app.ui.common.NormalText
import com.zhasa_app.ui.leading.WeekLeadingProgressView
import com.zhasa_app.ui.models.AmountPresentation
import com.zhasa_app.ui.models.YearWeeksAmountsModel
import com.zhasa_app.ui.theme.Colors
import com.zhasa_app.ui.theme.Size
import com.zhasa_app.ui.utils.YearWeekNumber

@Composable
@Preview
fun LeadingYearStatistic() {
    Column(modifier = Modifier.fillMaxWidth()) {
        WeekLeadingProgressView()
        Spacer(modifier = Modifier.height(Size.SPACE_2))
        Column(
            modifier = Modifier.background(
                color = Colors.BackgroundColor,
                shape = RoundedCornerShape(Size.SPACE_1)
            )
        ) {
            NormalText(
                modifier = Modifier.padding(start = Size.SPACE_1, top = Size.SPACE_1),
                text = "Данные по оп"
            )
            Spacer(modifier = Modifier.height(Size.SPACE_1))
            Box {
                AndroidView(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(Size.SPACE_24),
                    factory = { context ->
                        LineChart(context).apply {
                            setYearData(YearWeeksAmountsModel().apply {
                                put(YearWeekNumber(3), AmountPresentation(100500))
                            }, YearWeeksAmountsModel().apply {
                                put(YearWeekNumber(4), AmountPresentation(120000))
                            }, YearWeeksAmountsModel().apply {
                                put(YearWeekNumber(10), AmountPresentation(812000))
                            })
                            invalidate()
                        }
                    }
                )
            }
        }
    }
}