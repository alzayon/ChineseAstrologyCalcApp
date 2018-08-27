package com.alexis.chineseastrology.widgets

import android.content.Context
import android.support.v7.widget.GridLayoutManager
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import com.alexis.chineseastrology.R
import com.alexis.chineseastrology.lib.flyingstars.time.YearlyFlyingStarGroup
import kotlinx.android.synthetic.main.flying_stars_canvas.view.*

internal class FlyingStarCanvas : LinearLayout {
    constructor(context: Context) : this(context, null, 0)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)  {
        init()
    }

    var adapter = FlyingStarCanvasAdapter()

    var yearlyFlyingStarGroup: YearlyFlyingStarGroup? = null
        get() = field
        set(value) {
            field = value
            populate()
        }

    private fun init() {
        View.inflate(context, R.layout.flying_stars_canvas, this)
        rcvFlyingStars.layoutManager = GridLayoutManager(context, 3)
        rcvFlyingStars.adapter = adapter
    }

    private fun populate() {
        adapter.flyingStarGroup = yearlyFlyingStarGroup
    }
}