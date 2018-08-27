package com.alexis.chineseastrology.widgets

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import com.alexis.chineseastrology.R
import com.alexis.chineseastrology.lib.flyingstars.time.ITimeFlyingStar
import kotlinx.android.synthetic.main.flying_star_box.view.*

internal class FlyingStarBox : LinearLayout {

    constructor(context: Context) : this(context, null, 0)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)  {
        init()
    }

    var timeFlyingStar: ITimeFlyingStar? = null

    private fun init() {
        View.inflate(context, R.layout.flying_star_box, this)
    }

    fun populate(timeFlyingStar: ITimeFlyingStar) {
        this.timeFlyingStar = timeFlyingStar
        txtNumber.text = timeFlyingStar.giveStarPosition().flyingStar.number.toString()
    }
}