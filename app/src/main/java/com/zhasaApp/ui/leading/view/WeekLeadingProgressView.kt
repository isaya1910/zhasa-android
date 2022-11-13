package com.zhasaApp.ui.leading.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.zhasaApp.R
import com.zhasaApp.ui.common.views.NormalText
import com.zhasaApp.ui.common.views.SemiSmallText
import com.zhasaApp.ui.common.views.SmallText
import com.zhasaApp.ui.leading.models.WeeklyIndicatorProgressModel
import com.zhasaApp.ui.leading.models.WeeklyIndicatorProgressModels
import com.zhasaApp.ui.theme.Colors
import com.zhasaApp.ui.theme.Size

@Composable
@Preview
fun WeekLeadingProgressView() {
    val leading1 = WeeklyIndicatorProgressModel(
        progress = 0.33f,
        amountAndGoal = "24.4 млн./100 млн.",
        title = stringResource(
            R.string.leading1
        )
    )
    val leading2 = WeeklyIndicatorProgressModel(
        progress = 0.9f,
        amountAndGoal = "30.4 млн./40 млн.",
        title = stringResource(
            R.string.leading2
        )
    )
    val leading3 = WeeklyIndicatorProgressModel(
        progress = 0.33f,
        amountAndGoal = "21.4 млн./100 млн.",
        title = stringResource(
            R.string.leading3
        )
    )
    val leadingModels = WeeklyIndicatorProgressModels(
        leading1,
        leading2,
        leading3
    )
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(color = Colors.BackgroundColor, shape = RoundedCornerShape(Size.SPACE_1))
    ) {
        NormalText(
            modifier = Modifier.padding(start = Size.SPACE_1, top = Size.SPACE_1),
            text = stringResource(R.string.leading_weekly_goal)
        )
        Spacer(modifier = Modifier.height(Size.SPACE_1))
        LeadingRow(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .wrapContentHeight(),
            weeklyIndicatorProgressModels = leadingModels
        )
    }
}

@Composable
fun LeadingRow(
    modifier: Modifier = Modifier,
    weeklyIndicatorProgressModels: WeeklyIndicatorProgressModels
) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        LeadingWeekProgress(
            leadingColor = colorResource(id = R.color.leading1),
            weeklyIndicatorProgressModels.leading1
        )
        Spacer(
            modifier = Modifier
                .width(Size.SPACE_4)
        )
        LeadingWeekProgress(
            leadingColor = colorResource(id = R.color.leading2),
            weeklyIndicatorProgressModels.leading2
        )
        Spacer(
            modifier = Modifier
                .width(Size.SPACE_4)
        )
        LeadingWeekProgress(
            leadingColor = colorResource(id = R.color.leading3),
            weeklyIndicatorProgressModels.leading3
        )
    }
}

@Composable
fun LeadingWeekProgress(
    leadingColor: Color,
    weeklyIndicatorProgressModel: WeeklyIndicatorProgressModel
) {
    Column(
        modifier = Modifier.wrapContentHeight(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SemiSmallText(text = weeklyIndicatorProgressModel.amountAndGoal)
        Spacer(modifier = Modifier.height(Size.SPACE_1))
        Box(modifier = Modifier.size(Size.SPACE_9)) {
            CircularProgressIndicator(
                progress = 1f,
                color = Color.White,
                modifier = Modifier
                    .matchParentSize()
                    .align(
                        Alignment.Center
                    )
            )
            CircularProgressIndicator(
                progress = weeklyIndicatorProgressModel.progress,
                color = leadingColor,
                modifier = Modifier
                    .matchParentSize()
                    .background(Color.Transparent)
                    .align(
                        Alignment.Center
                    )
            )
            SmallText(text = "40%", modifier = Modifier.align(Alignment.Center))
        }
        Spacer(modifier = Modifier.height(Size.SPACE_1))
        SmallText(text = weeklyIndicatorProgressModel.title, textColor = leadingColor)
        Spacer(modifier = Modifier.height(Size.SPACE_1))
    }
}
