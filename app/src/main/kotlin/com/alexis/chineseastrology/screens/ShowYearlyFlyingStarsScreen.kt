package com.alexis.chineseastrology.screens

import android.arch.lifecycle.Observer
import android.content.Context
import android.databinding.DataBindingUtil
//import android.databinding.DataBindingUtil.inflate
import android.support.v4.view.ViewPager
import android.util.AttributeSet
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.widget.LinearLayout
import com.alexis.chineseastrology.R
import com.alexis.chineseastrology.dagger.general.viewinjector.IViewWithActivity
import com.alexis.chineseastrology.dagger.general.viewinjector.ViewInjection
import com.alexis.chineseastrology.databinding.ShowYearlyFlyingStarsScreenBinding
import com.alexis.chineseastrology.general.extensions.getViewModel
import com.alexis.chineseastrology.lib.flyingstars.time.YearlyFlyingStarGroup
import com.alexis.chineseastrology.screens.viewpager.CustomPagerAdapter
import com.alexis.chineseastrology.viewmodel.IShowYearlyFlyingStarsViewModel
import com.alexis.chineseastrology.viewmodel.ShowYearlyFlyingStarsViewModel
import kotlinx.android.synthetic.main.show_yearly_flying_stars_screen.view.*
import timber.log.Timber

class ShowYearlyFlyingStarsScreen : LinearLayout, IViewWithActivity {
    constructor(context: Context?) : this(context, null, 0)
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }

    private lateinit var viewModel: IShowYearlyFlyingStarsViewModel
    private lateinit var pagerAdapter: CustomPagerAdapter

    private fun init() {
        viewModel = activity.getViewModel<ShowYearlyFlyingStarsViewModel>()
        viewModel.setup()

        val binding = DataBindingUtil.inflate<ShowYearlyFlyingStarsScreenBinding>(
                activity.fragmentActivity.layoutInflater,
                R.layout.show_yearly_flying_stars_screen,
                this,
                true
        )
        binding.viewModel = viewModel
        binding.setLifecycleOwner(activity.fragmentActivity)

        val lp = LinearLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT)
        layoutParams = lp
        orientation = VERTICAL
        ViewInjection.inject(this)
        setup()
    }

    fun setup() {
        pagerAdapter = CustomPagerAdapter(activity.fragmentActivity,
                activity.fragmentActivity.layoutInflater,
                viewModel)
        flyingStarViewPager.adapter = pagerAdapter
        flyingStarViewPager.setCurrentItem(1, false)

        flyingStarViewPager.addOnPageChangeListener(object: ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
                if (state == ViewPager.SCROLL_STATE_IDLE) {
                    val item = flyingStarViewPager.currentItem
                    if (item < 1) {
                        viewModel.moveYearToCalculate(-1)
                    } else {
                        viewModel.moveYearToCalculate(1)
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

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        viewModel.reset()
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        viewModel.reset()
    }
}
