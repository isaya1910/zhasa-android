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
import com.zhasaApp.domain.models.YearWeekNumber
import com.zhasaApp.domain.models.YearWeeklyAmounts
import com.zhasaApp.ui.charts.setLeadingYearData
import com.zhasaApp.ui.common.views.NormalText
import com.zhasaApp.ui.theme.Colors
import com.zhasaApp.ui.theme.Size

@Composable
@Preview
fun LeadingYearStatistic() {
    Column(modifier = Modifier.fillMaxWidth()) {
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
                            setLeadingYearData(
                                YearWeeklyAmounts().apply {
                                    put(YearWeekNumber(3), Amount(100500))
                                },
                                YearWeeklyAmounts().apply {
                                    put(YearWeekNumber(4), Amount(120000))
                                    put(YearWeekNumber(10), Amount(110000))
                                },
                                YearWeeklyAmounts().apply {
                                    put(YearWeekNumber(10), Amount(812000))
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
