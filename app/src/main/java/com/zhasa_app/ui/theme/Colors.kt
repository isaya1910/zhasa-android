package com.zhasa_app.ui.theme

import androidx.compose.material.darkColors
import androidx.compose.ui.graphics.Color

object Colors {
    val White = Color(0xFFFFFFFF)
    val BlackPrimary = Color(0xff1C1C1E)
    val BlackPrimaryVariant = Color(0xff25252A)
    val BlueSecondaryDark = Color(0xff5C3CDD)
    val BlueSecondaryLight = Color(0xff5E81F4)
    val BackgroundColor = Color(0xFF25252A)
    val leading1Color = Color(0xff69DB7C)
    val leading2Color = Color(0xff4DABF7)
    val leading3Color = Color(0xffFFD43B)
    val redColor = Color.Red
    val darkColors = darkColors(
        primary = BlackPrimary,
        primaryVariant = BlackPrimaryVariant,
        secondary = BlueSecondaryDark,
        secondaryVariant = BlueSecondaryLight,
        background = BlackPrimary,
    )

}