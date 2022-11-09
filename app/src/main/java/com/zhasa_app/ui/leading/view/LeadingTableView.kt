package com.zhasa_app.ui.leading.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.zhasa_app.R
import com.zhasa_app.domain.AmountModel
import com.zhasa_app.ui.common.views.HeaderItemView
import com.zhasa_app.ui.leading.models.LeadingStatus
import com.zhasa_app.ui.leading.models.LeadingTableItem
import com.zhasa_app.ui.leading.models.LeadingWeekTableModel
import com.zhasa_app.ui.leading.models.LeadingYearTableItemsHolder
import com.zhasa_app.ui.theme.Colors
import com.zhasa_app.ui.theme.Size
import com.zhasa_app.ui.utils.YearWeekNumber

@Composable
@Preview
fun LeadingTableView() {
    val leadingYearTableItemsHolder = LeadingYearTableItemsHolder().apply {
        put(
            week = YearWeekNumber(4), LeadingTableItem(
                leading1 = LeadingWeekTableModel.build(
                    AmountModel(1000000),
                    AmountModel(5000000)
                ),
                leading2 = LeadingWeekTableModel.build(
                    AmountModel(10000000),
                    AmountModel(5000000)
                ),
                leading3 = LeadingWeekTableModel.build(
                    AmountModel(10000000),
                    AmountModel(5000000)
                )
            )
        )
    }
    Column {
        HeaderItemView(
            label1 = stringResource(id = R.string.leading1),
            label2 = stringResource(id = R.string.leading1),
            label3 = stringResource(id = R.string.leading1),
        )
        LazyColumn {
            item {
                LeadingTableHeaderItem(
                    leading1Goal = AmountModel(100000),
                    leading2Goal = AmountModel(100000),
                    leading3Goal = AmountModel(100000)
                )
            }
            leadingYearTableItemsHolder.forEachWeek() { week, item ->
                item {
                    Spacer(modifier = Modifier.height(Size.SPACE_0_2_5))
                    LeadingTableItem(week = week, leadingTableItem = item)
                }
            }
        }
    }
}

@Composable
fun LeadingTableHeaderItem(
    leading1Goal: AmountModel,
    leading2Goal: AmountModel,
    leading3Goal: AmountModel
) {
    Box(
        modifier = Modifier
            .height(Size.SPACE_5)
            .background(color = Colors.BackgroundColor)
            .fillMaxWidth()
            .padding(),
    ) {

        Text(
            text = stringResource(R.string.goal),
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
                text = leading1Goal.amount.toString(),
                modifier = Modifier
                    .padding(start = 8.dp)
                    .weight(1f),
                color = Colors.leading1Color,
                textAlign = TextAlign.Center
            )
            Text(
                text = leading2Goal.amount.toString(),
                modifier = Modifier
                    .padding(start = 8.dp)
                    .weight(1f),
                color = Colors.leading2Color,
                textAlign = TextAlign.Center
            )
            Text(
                text = leading3Goal.amount.toString(),
                modifier = Modifier
                    .padding(start = 8.dp)
                    .weight(1f),
                color = Colors.leading3Color,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun LeadingTableItem(week: YearWeekNumber, leadingTableItem: LeadingTableItem) {
    Box(
        modifier = Modifier
            .height(Size.SPACE_5)
            .background(color = Colors.BackgroundColor)
            .fillMaxWidth()
            .padding(),
    ) {
        val color1 = when (leadingTableItem.leading1.leadingStatus) {
            LeadingStatus.BAD -> Color.Red
            LeadingStatus.GOOD -> Color.Green
            LeadingStatus.NORMAL -> Color.Yellow
        }
        val color2 = when (leadingTableItem.leading2.leadingStatus) {
            LeadingStatus.BAD -> Color.Red
            LeadingStatus.GOOD -> Color.Green
            LeadingStatus.NORMAL -> Color.Yellow
        }
        val color3 = when (leadingTableItem.leading3.leadingStatus) {
            LeadingStatus.BAD -> Color.Red
            LeadingStatus.GOOD -> Color.Green
            LeadingStatus.NORMAL -> Color.Yellow
        }

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
                text = leadingTableItem.leading1.amountPresentation.value.toString(),
                modifier = Modifier
                    .padding(start = 8.dp)
                    .weight(1f),
                color = color1,
                textAlign = TextAlign.Center
            )
            Text(
                text = leadingTableItem.leading2.amountPresentation.toString(),
                modifier = Modifier
                    .padding(start = 8.dp)
                    .weight(1f),
                color = color2,
                textAlign = TextAlign.Center
            )
            Text(
                text = leadingTableItem.leading2.amountPresentation.value.toString(),
                modifier = Modifier
                    .padding(start = 8.dp)
                    .weight(1f),
                color = color3,
                textAlign = TextAlign.Center
            )
        }
    }
}