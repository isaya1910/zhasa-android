package com.zhasaApp.ui.common.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun ProgressView(modifier: Modifier, progress: Float, color: Color) {
    Box(modifier = modifier) {
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
            progress = progress,
            color = color,
            modifier = Modifier
                .matchParentSize()
                .background(Color.Transparent)
                .align(
                    Alignment.Center
                )
        )
        SmallText(text = "40%", modifier = Modifier.align(Alignment.Center))
    }
}
