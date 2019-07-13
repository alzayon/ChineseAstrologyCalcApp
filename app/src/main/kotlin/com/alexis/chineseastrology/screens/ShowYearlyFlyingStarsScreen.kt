package com.alexis.chineseastrology.screens

import android.content.Context
import android.support.v4.view.ViewPager
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import com.alexis.chineseastrology.R
import com.alexis.chineseastrology.dagger.general.viewinjector.IViewWithActivity
import com.alexis.chineseastrology.dagger.general.viewinjector.ViewInjection
import com.alexis.chineseastrology.general.extensions.getViewModel
import com.alexis.chineseastrology.lib.flyingstars.time.YearlyFlyingStarGroup
import com.alexis.chineseastrology.redux.showyearlyflyingstarscreen.IShowYearlyFlyingStarsStateGetters
import com.alexis.chineseastrology.redux.showyearlyflyingstarscreen.ShowYearlyFlyingStarsAction
import com.alexis.chineseastrology.redux.showyearlyflyingstarscreen.ShowYearlyFlyingStarsNotifyResults
import com.alexis.chineseastrology.screens.viewpager.YearlyFlyingStarsCustomPagerAdapter
import com.alexis.chineseastrology.viewmodel.ShowYearlyFlyingStarsViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.show_yearly_flying_stars_screen.view.*
import timber.log.Timber
import java.util.concurrent.TimeUnit


class ShowYearlyFlyingStarsScreen : LinearLayout, IViewWithActivity {
    constructor(context: Context?) : this(context, null, 0)
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }

    private val TYPING_DEBOUNCE_MS = 500L
    private val txtYearTypingSubject = PublishSubject.create<String>()

    private lateinit var viewModel: ShowYearlyFlyingStarsViewModel
    private lateinit var pagerAdapter: YearlyFlyingStarsCustomPagerAdapter

    private val stateGetters by lazy {
        viewModel.store.getters() as IShowYearlyFlyingStarsStateGetters
    }

    private fun init() {
        viewModel = activity.getViewModel<ShowYearlyFlyingStarsViewModel>()
        View.inflate(context, R.layout.show_yearly_flying_stars_screen, this)
        ViewInjection.inject(this)
    }

    private fun setupAdapter() {
        pagerAdapter = YearlyFlyingStarsCustomPagerAdapter(
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
                        viewModel.store.dispatch(ShowYearlyFlyingStarsAction.MoveYearToCalculate(-1))
                    } else {
                        viewModel.store.dispatch(ShowYearlyFlyingStarsAction.MoveYearToCalculate(1))
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

    private fun setupListeners() {
        txtYearTypingSubject
                .debounce(TYPING_DEBOUNCE_MS, TimeUnit.MILLISECONDS, AndroidSchedulers.mainThread())
                .subscribe({
                    try {
                        val year = Integer.parseInt(it)
                        viewModel.store.dispatch(ShowYearlyFlyingStarsAction.CalculateYearlyFlyingStars(year, true))
                    } catch (ex: NumberFormatException) {}
                }, {
                    //swallow error
                    Timber.e("Error %s", it.message)
                })

        txtYear.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                txtYearTypingSubject.onNext(s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })
    }

    private fun setupObservers() {
        viewModel.store.listen { result ->
            when (result) {
                is ShowYearlyFlyingStarsNotifyResults.YearUpdated -> onYearUpdated()
                is ShowYearlyFlyingStarsNotifyResults.YearlyFlyingStarGroupUpdated -> onFlyingStarGroupUpdated()
                else -> throw IllegalArgumentException("A notify result was not handled!")
            }
        }
    }

    private fun onYearUpdated() {
        txtYear.setText(stateGetters.yearToCalculate.toString())
    }

    private fun onFlyingStarGroupUpdated() {
        pagerAdapter.onFlyingStarGroupUpdated(stateGetters.yearlyFlyingStarGroup)
    }

    // region: lifecycle overrides
    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        viewModel.setup(this.activity.fragmentActivity)
        setupObservers()
        setupAdapter()
        setupListeners()
        viewModel.store.dispatch(ShowYearlyFlyingStarsAction.CalculateYearlyFlyingStars())
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        viewModel.store.reset()
    }
    // endregion: lifecycle overrides
}
