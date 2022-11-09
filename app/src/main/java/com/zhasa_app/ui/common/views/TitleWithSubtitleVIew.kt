package com.zhasa_app.ui.common.views

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun TitleWithSubtitleView(modifier: Modifier = Modifier, title: String, subtitle: String) {
    Column(modifier = modifier) {
        NormalText(text = title)
        SmallText(text = subtitle, textColor = Color.Gray)
    }
}