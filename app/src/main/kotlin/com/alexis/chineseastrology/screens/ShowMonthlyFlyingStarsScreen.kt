package com.alexis.chineseastrology.screens

import android.content.Context
import android.support.v4.view.ViewPager
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import com.alexis.chineseastrology.R
import com.alexis.chineseastrology.dagger.general.viewinjector.IViewWithActivity
import com.alexis.chineseastrology.dagger.general.viewinjector.ViewInjection
import com.alexis.chineseastrology.general.extensions.getViewModel
import com.alexis.chineseastrology.lib.flyingstars.time.MonthlyFlyingStarGroup
import com.alexis.chineseastrology.redux.showmonthlyflyingstarscreen.IShowMonthlyFlyingStarsStateGetters
import com.alexis.chineseastrology.redux.showmonthlyflyingstarscreen.ShowMonthlyFlyingStarsAction
import com.alexis.chineseastrology.redux.showmonthlyflyingstarscreen.ShowMonthlyFlyingStarsNotifyResults
import com.alexis.chineseastrology.screens.viewpager.MonthlyFlyingStarsCustomPagerAdapter
import com.alexis.chineseastrology.viewmodel.ShowMonthlyFlyingStarsViewModel
import com.whiteelephant.monthpicker.MonthPickerDialog
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.show_monthly_flying_stars_screen.view.*
import timber.log.Timber
import java.util.*
import java.util.concurrent.TimeUnit

class ShowMonthlyFlyingStarsScreen : LinearLayout, IViewWithActivity
{
    constructor(context: Context?) : this(context, null, 0)
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }

    private val TYPING_DEBOUNCE_MS = 500L
    private val txtYearTypingSubject = PublishSubject.create<String>()
    private val txtMonthTypingSubject = PublishSubject.create<String>()

    private lateinit var viewModel: ShowMonthlyFlyingStarsViewModel
    private lateinit var pagerAdapter: MonthlyFlyingStarsCustomPagerAdapter

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
                        viewModel.store.dispatch(ShowMonthlyFlyingStarsAction.MoveYearToCalculate(-1))
                    } else {
                        viewModel.store.dispatch(ShowMonthlyFlyingStarsAction.MoveYearToCalculate(1))
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
        setupTypingSubjectListeners(listOf(txtYearTypingSubject, txtMonthTypingSubject))
        setupTextListeners(listOf(Pair(txtYear, txtYearTypingSubject), Pair(txtMonth, txtMonthTypingSubject)))
    }

    private fun setupTextListeners(list: List<Pair<TextView, PublishSubject<String>>>) {
        list.forEach {
            val txtView = it.first
            val subject = it.second
            txtView.addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(s: Editable?) {
                    subject.onNext(s.toString())
                }

                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                }
            })
        }
    }

    private fun setupTypingSubjectListeners(list: List<Observable<String>>) {
        list.forEach {
            it.debounce(TYPING_DEBOUNCE_MS, TimeUnit.MILLISECONDS, AndroidSchedulers.mainThread())
                .subscribe({
                    try {
                        recalculateAfterTyping()
                    } catch (ex: NumberFormatException) {}
                }, {
                    //swallow error
                    Timber.e("Error %s", it.message)
                })
        }
    }

    private fun recalculateAfterTyping() {
        val month = Integer.parseInt(txtYear.text.toString())
        val year = Integer.parseInt(txtYear.text.toString())
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
        txtMonth.setText(stateGetters.monthToCalculate.toString())
        txtYear.setText(stateGetters.yearToCalculate.toString())
    }

    private fun onFlyingStarGroupUpdated() {
        pagerAdapter.onFlyingStarGroupUpdated(stateGetters.monthlyFlyingStarGroup)
    }

    private fun setupMonthSelector() {
        val calendar = Calendar.getInstance()
        val builder = MonthPickerDialog.Builder(context,
            { month, year ->

            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH)
        )

        builder.setActivatedMonth(Calendar.JULY)
                .setMinYear(1990)
                .setActivatedYear(2017)
                .setMaxYear(2030)
                .setMinMonth(Calendar.FEBRUARY)
                .setTitle("Select trading month")
                .setMonthRange(Calendar.FEBRUARY, Calendar.NOVEMBER)
                // .setMaxMonth(Calendar.OCTOBER)
                // .setYearRange(1890, 1890)
                // .setMonthAndYearRange(Calendar.FEBRUARY, Calendar.OCTOBER, 1890, 1890)
                //.showMonthOnly()
                // .showYearOnly()
                .setOnMonthChangedListener {  }
                .setOnYearChangedListener {  }
                .build()
                .show();
    }

    // region lifecycle overrides
    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        viewModel.setup(this.activity.fragmentActivity)
        setupObservers()
        setupAdapter()
        setupListeners()
        setupMonthSelector()
        viewModel.store.dispatch(ShowMonthlyFlyingStarsAction.CalculateMonthlyFlyingStars())
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        viewModel.store.reset()
    }
    // endregion lifecycle overrides
}
