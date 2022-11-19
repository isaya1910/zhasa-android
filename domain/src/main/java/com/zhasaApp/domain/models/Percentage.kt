package com.zhasaApp.domain.models

import java.text.DecimalFormat


@JvmInline
value class Percentage(
    private val value: Float
) {

    fun progress(): Float = value/100

    fun print(): String {
        val df = DecimalFormat("#.##")
        return "${df.format(value)}$"
    }
}
