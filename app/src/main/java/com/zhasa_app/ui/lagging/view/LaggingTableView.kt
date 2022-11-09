package com.zhasa_app.ui.lagging.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.zhasa_app.ui.common.views.HeaderItemView
import com.zhasa_app.ui.lagging.models.LaggingTableModel
import com.zhasa_app.ui.lagging.models.LaggingYearTableItemsHolder
import com.zhasa_app.ui.models.AmountPresentation
import com.zhasa_app.ui.models.Percentage
import com.zhasa_app.ui.theme.Colors
import com.zhasa_app.ui.theme.Size
import com.zhasa_app.ui.utils.YearWeekNumber

@Composable
@Preview
fun LaggingTableView() {
    val laggingYearTableItemsHolder = LaggingYearTableItemsHolder().apply {
        put(
            YearWeekNumber(4), LaggingTableModel(
                AmountPresentation(100000),
                AmountPresentation(200000),
                Percentage(50f)
            )
        )
    }
    Column {
        HeaderItemView(label1 = "ЗП", label2 = "КП", label3 = "Исп. КВЦ")
        LazyColumn {
            laggingYearTableItemsHolder.forEachWeek { week, item ->
                item {
                    LaggingTableItem(week = week, laggingTableItem = item)
                    Spacer(modifier = Modifier.height(Size.SPACE_0_2_5))
                }
            }
        }
    }
}

@Composable
fun LaggingTableItem(week: YearWeekNumber, laggingTableItem: LaggingTableModel) {
    Box(
        modifier = Modifier
            .height(Size.SPACE_5)
            .background(color = Colors.BackgroundColor)
            .fillMaxWidth()
            .padding(),
    ) {

        Text(
            text = "Week ${week.number}",
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(start = 16.dp),
            color = Color.White
        )
        Row(
            modifier = Modifier
                .align(Alignment.CenterStart)
                .fillMaxWidth()
                .padding(start = 64.dp),
        ) {
            Text(
                text = laggingTableItem.laggingAmount.value.toString(),
                modifier = Modifier
                    .padding(start = 8.dp)
                    .weight(1f),
                color = Color.Green,
                textAlign = TextAlign.Center
            )
            Text(
                text = laggingTableItem.loanPortfolioAmount.value.toString(),
                modifier = Modifier
                    .padding(start = 8.dp)
                    .weight(1f),
                color = Color.Blue,
                textAlign = TextAlign.Center
            )
            Text(
                text = laggingTableItem.laggingPercentage.toPresentation(),
                modifier = Modifier
                    .padding(start = 8.dp)
                    .weight(1f),
                color = Color.Yellow,
                textAlign = TextAlign.Center
            )
        }
    }
}