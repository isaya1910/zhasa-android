package com.zhasaApp.domain
import com.zhasaApp.domain.models.WeekDayNumber
import java.text.DecimalFormat

typealias WeekAmounts = HashMap<WeekDayNumber, Amount>

@JvmInline
value class Amount(val amount: Long = 0L) : Comparable<Amount> {

    fun print(): String {
        val df = DecimalFormat("#.##")
        val presAmount = amount / 1000000.toFloat()
        return df.format(presAmount)
    }

    override fun compareTo(other: Amount): Int {
        return compareValuesBy(this, other, Amount::amount)
    }
}
