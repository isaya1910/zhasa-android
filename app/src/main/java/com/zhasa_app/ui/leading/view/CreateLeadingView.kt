package com.zhasa_app.ui.leading.view

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.zhasa_app.ui.common.AmountInputField
import com.zhasa_app.ui.common.NormalText
import com.zhasa_app.ui.theme.Size

@Composable
fun CreateLeadingView() {
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(start = Size.SPACE_1, end = Size.SPACE_1)) {
        NormalText(text = "Введите ОП1", textColor = Color.Gray)
        AmountInputField()
        Spacer(modifier = Modifier.height(Size.SPACE_1))
        NormalText(text = "Введите ОП2", textColor = Color.Gray)
        AmountInputField()
    }
}