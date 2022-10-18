package com.zhasa_app.domain
import java.text.DecimalFormat

@JvmInline
value class AmountModel(val amount: Long = 0L) : Comparable<AmountModel> {

    fun toPresentation(): String {
        val df = DecimalFormat("#.##")
        val presAmount = amount / 1000000.toFloat()
        return df.format(presAmount)
    }

    override fun compareTo(other: AmountModel): Int {
        return compareValuesBy(this, other, AmountModel::amount)
    }
}
