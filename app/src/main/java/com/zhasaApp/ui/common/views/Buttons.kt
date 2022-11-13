package com.zhasaApp.ui.common.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import com.zhasaApp.ui.theme.Colors
import com.zhasaApp.ui.theme.Size

@Composable
fun GradientButton(
    text: String,
    gradient: Brush,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = { }
) {
    Button(
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
        contentPadding = PaddingValues(),
        onClick = { onClick() }
    ) {
        Box(
            modifier = Modifier
                .background(gradient, shape = RoundedCornerShape(Size.SPACE_0_5))
                .then(modifier),
            contentAlignment = Alignment.Center
        ) {
            NormalText(text = text)
        }
    }
}

@Composable
fun PrimaryButton(modifier: Modifier, onClick: () -> Unit, text: String) {
    GradientButton(
        onClick = { onClick() },
        modifier = modifier,
        gradient = Brush.horizontalGradient(
            listOf(
                Colors.BlueSecondaryDark,
                Colors.BlueSecondaryLight
            )
        ),
        text = text
    )
}
