package com.zhasa_app.ui.lagging.view

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.zhasa_app.ui.common.AmountInputField
import com.zhasa_app.ui.common.PrimaryButton
import com.zhasa_app.ui.common.SemiNormalText
import com.zhasa_app.ui.common.WeekInputField
import com.zhasa_app.ui.theme.Colors
import com.zhasa_app.ui.theme.Size

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