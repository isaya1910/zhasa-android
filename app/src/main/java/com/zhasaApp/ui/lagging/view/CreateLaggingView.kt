package com.zhasaApp.ui.lagging.view

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.zhasaApp.ui.common.views.AmountInputField
import com.zhasaApp.ui.common.views.PrimaryButton
import com.zhasaApp.ui.common.views.SemiNormalText
import com.zhasaApp.ui.common.views.WeekInputField
import com.zhasaApp.ui.theme.Colors
import com.zhasaApp.ui.theme.Size

@Composable
fun CreateLaggingView() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = Size.SPACE_2, end = Size.SPACE_2)
    ) {
        SemiNormalText(text = "Введите неделю", textColor = Colors.SecondaryTextColor)
        Spacer(modifier = Modifier.height(Size.SPACE_0_5))
        WeekInputField()
        Spacer(modifier = Modifier.height(Size.SPACE_2))
        SemiNormalText(text = "Введите ЗП", textColor = Colors.SecondaryTextColor)
        Spacer(modifier = Modifier.height(Size.SPACE_0_5))
        AmountInputField()
        Spacer(modifier = Modifier.height(Size.SPACE_2))
        PrimaryButton(
            modifier = Modifier
                .fillMaxWidth()
                .height(Size.SPACE_7),
            onClick = { },
            text = "Добавить"
        )
    }
}
