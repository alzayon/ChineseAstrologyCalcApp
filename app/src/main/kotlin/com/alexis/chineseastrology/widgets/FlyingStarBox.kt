package com.alexis.chineseastrology.widgets

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import com.alexis.chineseastrology.R
import com.alexis.chineseastrology.lib.flyingstars.time.ITimeFlyingStar
import com.alexis.chineseastrology.lib.flyingstars.time.MonthlyFlyingStar
import kotlinx.android.synthetic.main.flying_star_box_monthly.view.*

class FlyingStarBox : LinearLayout {

    constructor(context: Context) : this(context, null, 0)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    var timeFlyingStar: ITimeFlyingStar? = null
    var monthlyDisplay: Boolean = false
        set (value) {
            field = value
            setup()
        }

    fun setup() {
        if (monthlyDisplay) {
            View.inflate(context, R.layout.flying_star_box_monthly, this)
        } else {
            View.inflate(context, R.layout.flying_star_box_yearly, this)
        }
    }

    fun populate(timeFlyingStar: ITimeFlyingStar) {
        this.timeFlyingStar = timeFlyingStar
        if (monthlyDisplay) {
            val flyingStar = timeFlyingStar as MonthlyFlyingStar
            txtNumber.text = flyingStar.giveYearlyStarPosition().flyingStar.number.toString()
            txtMonthlyNumber.text = timeFlyingStar.giveStarPosition().flyingStar.number.toString()
        } else {
            txtNumber.text = timeFlyingStar.giveStarPosition().flyingStar.number.toString()
        }

    }

    public override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec) // This is the key that will make the height equivalent to its width
    }
}