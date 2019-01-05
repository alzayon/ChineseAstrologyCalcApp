package com.alexis.chineseastrology.screens

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import com.alexis.chineseastrology.R
import com.alexis.chineseastrology.screens.viewpager.MonthlyFlyingStarsCustomPagerAdapter
import com.alexis.chineseastrology.viewmodel.IShowMonthlyFlyingStarsViewModel

class ShowMonthlyFlyingStarsScreen : LinearLayout {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }

    private lateinit var viewModel: IShowMonthlyFlyingStarsViewModel
    private lateinit var pagerAdapter: MonthlyFlyingStarsCustomPagerAdapter

    private fun init() {
        View.inflate(context, R.layout.show_monthly_flying_stars_screen, this)
    }
}
