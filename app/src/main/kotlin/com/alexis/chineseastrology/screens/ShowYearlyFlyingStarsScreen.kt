package com.alexis.chineseastrology.screens

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import com.alexis.chineseastrology.R
import com.alexis.chineseastrology.dagger.general.viewinjector.IViewWithActivity
import com.alexis.chineseastrology.lib.flyingstars.time.YearlyFlyingStarGroup
import com.alexis.chineseastrology.presenter.IShowYearlyFlyingStarsPresenter
import javax.inject.Inject

class ShowYearlyFlyingStarsScreen : LinearLayout, IViewWithActivity {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }

    @Inject
    lateinit var presenter: IShowYearlyFlyingStarsPresenter

    var yearlyFlyingStarGroup: YearlyFlyingStarGroup? = null

    private fun init() {
        View.inflate(context, R.layout.show_yearly_flying_stars_screen, this)
    }

    fun setup(year: Int) {
        yearlyFlyingStarGroup = presenter.calculateYearlyFlyingStarGroup(year)
    }
}