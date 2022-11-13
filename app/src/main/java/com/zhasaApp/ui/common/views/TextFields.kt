package com.zhasaApp.ui.common.views

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.zhasaApp.ui.theme.Colors
import com.zhasaApp.ui.theme.Fonts

@Composable
fun SemiSmallText(modifier: Modifier = Modifier, text: String, textColor: Color = Colors.PrimaryTextColor) {
    Text(modifier = modifier, text = text, color = textColor, fontSize = Fonts.SemiSmall)
}

@Composable
fun SmallText(modifier: Modifier = Modifier, text: String, textColor: Color = Colors.PrimaryTextColor) {
    Text(modifier = modifier, text = text, color = textColor, fontSize = Fonts.Small)
}

@Composable
fun SemiNormalText(modifier: Modifier = Modifier, text: String, textColor: Color = Colors.PrimaryTextColor) {
    Text(modifier = modifier, text = text, color = textColor, fontSize = Fonts.SemiNormal)
}

@Composable
fun NormalText(modifier: Modifier = Modifier, text: String, textColor: Color = Colors.PrimaryTextColor) {
    Text(modifier = modifier, text = text, color = textColor, fontSize = Fonts.Normal)
}
