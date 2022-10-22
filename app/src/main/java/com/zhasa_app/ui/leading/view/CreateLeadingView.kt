package com.zhasa_app.ui.leading.view

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.zhasa_app.ui.common.AmountInputField
import com.zhasa_app.ui.common.DateField
import com.zhasa_app.ui.common.SemiNormalText
import com.zhasa_app.ui.theme.Colors
import com.zhasa_app.ui.theme.Size

@Composable
fun CreateLeadingView() {
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(start = Size.SPACE_2, end = Size.SPACE_2)) {
        SemiNormalText(text = "Выберите дату", textColor = Colors.SecondaryTextColor)
        Spacer(modifier = Modifier.height(Size.SPACE_0_5))
        DateField()
        Spacer(modifier = Modifier.height(Size.SPACE_1))
        SemiNormalText(text = "Введите ОП1", textColor = Colors.SecondaryTextColor)
        Spacer(modifier = Modifier.height(Size.SPACE_0_5))
        AmountInputField()
        Spacer(modifier = Modifier.height(Size.SPACE_1))
        SemiNormalText(text = "Введите ОП2", textColor = Colors.SecondaryTextColor)
        Spacer(modifier = Modifier.height(Size.SPACE_0_5))
        AmountInputField()
    }
}
