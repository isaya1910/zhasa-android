package com.zhasaApp.ui.theme

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
    val PrimaryTextColor = Color(0xfff8f9fa)
    val SecondaryTextColor = Color(0xFFadb5bd)
    val RedColor = Color.Red
    val darkColors = darkColors(
        primary = BlackPrimary,
        primaryVariant = BlackPrimaryVariant,
        secondary = BlueSecondaryDark,
        secondaryVariant = BlueSecondaryLight,
        background = BlackPrimary
    )
}
