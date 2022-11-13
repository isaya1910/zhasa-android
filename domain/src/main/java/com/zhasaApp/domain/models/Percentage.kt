package com.zhasaApp.domain.models

import java.text.DecimalFormat


@JvmInline
value class Percentage(
    private val value: Float
) {
    fun print(): String {
        val df = DecimalFormat("#.##")
        return df.format(value)
    }
}
