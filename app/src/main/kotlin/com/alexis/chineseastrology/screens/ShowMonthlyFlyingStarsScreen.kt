package com.alexis.chineseastrology.screens

import android.content.Context
import androidx.viewpager.widget.ViewPager
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import com.alexis.chineseastrology.R
import com.alexis.chineseastrology.dagger.general.viewinjector.IViewWithActivity
import com.alexis.chineseastrology.dagger.general.viewinjector.ViewInjection
import com.alexis.chineseastrology.general.extensions.getViewModel
import com.alexis.chineseastrology.redux.showmonthlyflyingstarscreen.IShowMonthlyFlyingStarsStateGetters
import com.alexis.chineseastrology.redux.showmonthlyflyingstarscreen.ShowMonthlyFlyingStarsAction
import com.alexis.chineseastrology.redux.showmonthlyflyingstarscreen.ShowMonthlyFlyingStarsNotifyResults
import com.alexis.chineseastrology.screens.viewpager.MonthlyFlyingStarsCustomPagerAdapter
import com.alexis.chineseastrology.viewmodel.ShowMonthlyFlyingStarsViewModel
import com.whiteelephant.monthpicker.MonthPickerDialog
import kotlinx.android.synthetic.main.show_monthly_flying_stars_screen.view.*
import timber.log.Timber
import java.util.*

class ShowMonthlyFlyingStarsScreen : LinearLayout, IViewWithActivity
{
    constructor(context: Context?) : this(context, null, 0)
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }

    private lateinit var viewModel: ShowMonthlyFlyingStarsViewModel
    private lateinit var pagerAdapter: MonthlyFlyingStarsCustomPagerAdapter
    private lateinit var monthPickerDialog: MonthPickerDialog

    private val stateGetters by lazy {
        viewModel.store.getters() as IShowMonthlyFlyingStarsStateGetters
    }

    private fun init() {
        viewModel = activity.getViewModel<ShowMonthlyFlyingStarsViewModel>()
        View.inflate(context, R.layout.show_monthly_flying_stars_screen, this)
        ViewInjection.inject(this)
    }

    private fun setupAdapter() {
        pagerAdapter = MonthlyFlyingStarsCustomPagerAdapter(
            activity.fragmentActivity,
            stateGetters,
            viewModel.store
        )
        flyingStarViewPager.adapter = pagerAdapter
        flyingStarViewPager.setCurrentItem(1, false)

        flyingStarViewPager.addOnPageChangeListener(object: ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
                if (state == ViewPager.SCROLL_STATE_IDLE) {
                    val item = flyingStarViewPager.currentItem
                    if (item < 1) {
                        viewModel.store.dispatch(ShowMonthlyFlyingStarsAction.MoveMonthToCalculate(-1))
                    } else {
                        viewModel.store.dispatch(ShowMonthlyFlyingStarsAction.MoveMonthToCalculate(1))
                    }
                    flyingStarViewPager.setCurrentItem(1, false)
                }
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                // Do nothing
            }

            override fun onPageSelected(position: Int) {
                // Do nothing
                Timber.d("Position is %s", position)
            }
        })
    }

    private fun recalculateAfterTyping(month: Int, year: Int) {
        viewModel.store.dispatch(ShowMonthlyFlyingStarsAction.CalculateMonthlyFlyingStars(
                month,
                year,
                true
            )
        )
    }

    private fun setupObservers() {
        viewModel.store.listen { result ->
            when (result) {
                is ShowMonthlyFlyingStarsNotifyResults.MonthYearUpdated -> onMonthYearUpdated()
                is ShowMonthlyFlyingStarsNotifyResults.MonthlyFlyingStarGroupUpdated -> onFlyingStarGroupUpdated()
                else -> throw IllegalArgumentException("A notify result was not handled!")
            }
        }
    }

    private fun onMonthYearUpdated() {
        txtMonthYear.setText(stateGetters.monthYearAsString)
    }

    private fun onFlyingStarGroupUpdated() {
        pagerAdapter.onFlyingStarGroupUpdated(stateGetters.monthlyFlyingStarGroup)
    }

    private fun setupMonthSelector() {
        val builder = MonthPickerDialog.Builder(context,
            { month, year ->
                recalculateAfterTyping(month, year)
            },
            stateGetters.yearToCalculate!!,
            stateGetters.monthToCalculate!!
        )

        txtMonthYear.setOnClickListener {
            // https://github.com/premkumarroyal/MonthAndYearPicker
            builder.setActivatedMonth(stateGetters.monthToCalculate!!)
                .setActivatedYear(stateGetters.yearToCalculate!!)
                .setTitle(context?.getString(R.string.enter_month_year))
                .setMinYear(1)
                .setMaxYear(9999)
                .build()
                .show()
        }
    }

    // region lifecycle overrides
    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        viewModel.setup(this.activity.fragmentActivity)
        setupObservers()
        setupAdapter()
        viewModel.store.dispatch(ShowMonthlyFlyingStarsAction.CalculateMonthlyFlyingStars())
        setupMonthSelector()
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        viewModel.store.reset()
    }
    // endregion lifecycle overrides
}
