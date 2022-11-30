package com.zhasaApp.domain

import com.zhasaApp.domain.models.WeekDayNumber
import java.text.DecimalFormat

@JvmInline
value class WeekAmounts(val values: HashMap<WeekDayNumber, Amount> = HashMap()) {
    init {
        for (i in 0..6) {
            values[WeekDayNumber(i)] = Amount(0)
        }
    }

    fun put(weekDayNumber: WeekDayNumber, amount: Amount) {
        values[weekDayNumber] = amount
    }
}

@JvmInline
value class Amount(val amount: Long = 0L) : Comparable<Amount> {

    fun print(): String {
        val df = DecimalFormat("#.##")
        val presAmount = amount / 1000000.toFloat()
        return "${df.format(presAmount)} млн."
    }

    override fun compareTo(other: Amount): Int {
        return compareValuesBy(this, other, Amount::amount)
    }
}
