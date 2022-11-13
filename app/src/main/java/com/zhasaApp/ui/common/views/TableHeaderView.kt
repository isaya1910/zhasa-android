package com.zhasaApp.ui.common.views

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.zhasaApp.ui.theme.Size

@Composable
fun HeaderItemView(label1: String, label2: String, label3: String) {
    Box(
        modifier = Modifier
            .height(Size.SPACE_5)
            .fillMaxWidth()
            .padding()
    ) {
        Row(
            modifier = Modifier
                .align(Alignment.CenterStart)
                .fillMaxWidth()
                .padding(start = 64.dp)
        ) {
            Text(
                text = label1,
                modifier = Modifier
                    .padding(start = 8.dp)
                    .weight(1f),
                color = Color.White,
                textAlign = TextAlign.Center
            )
            Text(
                text = label2,
                modifier = Modifier
                    .padding(start = 8.dp)
                    .weight(1f),
                color = Color.White,
                textAlign = TextAlign.Center
            )
            Text(
                text = label3,
                modifier = Modifier
                    .padding(start = 8.dp)
                    .weight(1f),
                color = Color.White,
                textAlign = TextAlign.Center
            )
        }
    }
}
