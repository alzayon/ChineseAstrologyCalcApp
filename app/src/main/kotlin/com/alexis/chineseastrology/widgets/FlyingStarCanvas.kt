package com.alexis.chineseastrology.widgets

import android.content.Context
import android.support.v7.widget.GridLayoutManager
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.alexis.chineseastrology.R
import com.alexis.chineseastrology.lib.flyingstars.time.IFlyingStarGroup
import com.alexis.chineseastrology.lib.flyingstars.time.ITimeFlyingStar
import kotlinx.android.synthetic.main.flying_stars_canvas.view.*

class FlyingStarCanvas : LinearLayout {
    constructor(context: Context) : this(context, null, 0)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)  {
        init()
    }

    companion object {
        fun arrangeStarsForView(flyingStarGroup: IFlyingStarGroup): List<ITimeFlyingStar> {
            return listOf(
                        flyingStarGroup.giveSouthEastStar(),
                        flyingStarGroup.giveSouthStar(),
                        flyingStarGroup.giveSouthWestStar(),
                        flyingStarGroup.giveEastStar(),
                        flyingStarGroup.giveCenterStar(),
                        flyingStarGroup.giveWestStar(),
                        flyingStarGroup.giveNorthEastStar(),
                        flyingStarGroup.giveNorthStar(),
                        flyingStarGroup.giveNorthWestStar()
                    )
        }
    }

    private var adapter = FlyingStarCanvasAdapter()

    var flyingStarGroup: IFlyingStarGroup? = null
        get() = field
        set(value) {
            field = value
            populate()
        }

    private fun init() {
        View.inflate(context, R.layout.flying_stars_canvas, this)
        val lp = LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        layoutParams = lp
        orientation = VERTICAL
        rcvFlyingStars.layoutManager = GridLayoutManager(context, 3)
        rcvFlyingStars.adapter = adapter
    }

    private fun populate() {
        flyingStarGroup?.let {
            adapter.flyingStars = arrangeStarsForView(it)
        }?: adapter.clear()
    }
}