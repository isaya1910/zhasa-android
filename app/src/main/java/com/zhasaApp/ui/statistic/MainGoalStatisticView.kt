package com.zhasaApp.ui.statistic

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.zhasaApp.domain.Amount
import com.zhasaApp.domain.models.Percentage
import com.zhasaApp.ui.common.views.NormalText
import com.zhasaApp.ui.common.views.ProgressView
import com.zhasaApp.ui.theme.Colors
import com.zhasaApp.ui.theme.Size

@Composable
@Preview
fun MainGoalStatisticView() {
    val mainGoal = Amount(9100000)
    val factOfExecution = Amount(3300000)
    val progress = Percentage(40f)
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(Size.SPACE_12)
    ) {
        ProgressView(
            modifier = Modifier
                .size(Size.SPACE_11)
                .padding(Size.SPACE_1)
                .align(Alignment.CenterStart),
            progress = progress.progress(),
            color = Colors.leading2Color
        )
        Column(
            modifier = Modifier
                .padding(start = Size.SPACE_11)
                .align(Alignment.CenterStart)
        ) {
            NormalText(text = "КВЦ: ${mainGoal.print()}")
            NormalText(text = "Факт исполнения: ${factOfExecution.print()}")
        }
    }
}
