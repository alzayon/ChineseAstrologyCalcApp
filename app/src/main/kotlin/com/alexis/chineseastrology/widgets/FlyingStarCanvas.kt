package com.alexis.chineseastrology.widgets

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import com.alexis.chineseastrology.R
import com.alexis.chineseastrology.lib.flyingstars.time.YearlyFlyingStarGroup

internal class FlyingStarCanvas : LinearLayout {
    constructor(context: Context) : this(context, null, 0)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)  {
        init()
    }

    var yearlyFlyingStarGroup: YearlyFlyingStarGroup? = null

    private fun init() {
        View.inflate(context, R.layout.flying_stars_canvas, this)
    }
}