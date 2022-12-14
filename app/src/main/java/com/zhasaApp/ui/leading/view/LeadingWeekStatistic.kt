package com.zhasaApp.ui.leading.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import com.github.mikephil.charting.charts.LineChart
import com.zhasaApp.domain.Amount
import com.zhasaApp.domain.WeekAmounts
import com.zhasaApp.domain.models.WeekDayNumber
import com.zhasaApp.ui.charts.setWeekData
import com.zhasaApp.ui.common.views.NormalText
import com.zhasaApp.ui.theme.Colors
import com.zhasaApp.ui.theme.Size

@Composable
@Preview
fun LeadingWeekStatistic() {
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
                            setWeekData(
                                WeekAmounts().apply {
                                    values[WeekDayNumber(0)] = Amount(100000)
                                    values[WeekDayNumber(1)] = Amount(110000)
                                    values[WeekDayNumber(2)] = Amount(200000)
                                    values[WeekDayNumber(3)] = Amount(100500)
                                    values[WeekDayNumber(4)] = Amount(130000)
                                    values[WeekDayNumber(5)] = Amount(120000)
                                    values[WeekDayNumber(6)] = Amount(90000)
                                },
                                WeekAmounts().apply {
                                    values[WeekDayNumber(4)] = Amount(120000)
                                },
                                WeekAmounts().apply {
                                    values[WeekDayNumber(2)] = Amount(1200000)
                                    values[WeekDayNumber(3)] = Amount(1100000)
                                }
                            )
                            invalidate()
                        }
                    }
                )
            }
        }
    }
}
