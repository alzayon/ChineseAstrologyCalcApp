package com.alexis.chineseastrology.screens

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import com.alexis.chineseastrology.R
import com.alexis.chineseastrology.dagger.general.viewinjector.IViewWithActivity
import com.alexis.chineseastrology.dagger.general.viewinjector.ViewInjection
import com.alexis.chineseastrology.lib.flyingstars.time.YearlyFlyingStarGroup
import com.alexis.chineseastrology.presenter.IShowYearlyFlyingStarsPresenter
import kotlinx.android.synthetic.main.show_yearly_flying_stars_screen.view.*
import java.util.*
import javax.inject.Inject

class ShowYearlyFlyingStarsScreen : LinearLayout, IViewWithActivity {
    constructor(context: Context?) : this(context, null, 0)
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }

    @Inject
    lateinit var presenter: IShowYearlyFlyingStarsPresenter

    private var yearlyFlyingStarGroup: YearlyFlyingStarGroup? = null

    private var year: Int = Calendar.getInstance().get(Calendar.YEAR)

    private fun init() {
        View.inflate(context, R.layout.show_yearly_flying_stars_screen, this)
        ViewInjection.inject(this)
        setup()
    }

    fun setup() {
        yearlyFlyingStarGroup = presenter.calculateYearlyFlyingStarGroup(year)
        viewFlyingStarCanvas.yearlyFlyingStarGroup = yearlyFlyingStarGroup
    }
}