package com.zhasa_app.ui.models

import java.text.DecimalFormat


@JvmInline
value class Percentage(
    private val value: Float
) {
    fun toPresentation(): String {
        val df = DecimalFormat("#.##")
        return df.format(value)
    }
}
