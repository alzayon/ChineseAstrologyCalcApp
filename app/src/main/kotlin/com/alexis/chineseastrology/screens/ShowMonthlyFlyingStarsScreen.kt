package com.alexis.chineseastrology.screens

import android.app.Activity
import android.content.Context
import android.databinding.DataBindingUtil.inflate
import android.util.AttributeSet
import android.view.ViewGroup
import android.widget.LinearLayout
import com.alexis.chineseastrology.R
import com.alexis.chineseastrology.dagger.general.viewinjector.IViewWithActivity
import com.alexis.chineseastrology.dagger.general.viewinjector.ViewInjection
import com.alexis.chineseastrology.databinding.ShowMonthlyFlyingStarsScreenBinding
import com.alexis.chineseastrology.general.extensions.getViewModel
import com.alexis.chineseastrology.screens.viewpager.MonthlyFlyingStarsCustomPagerAdapter
import com.alexis.chineseastrology.viewmodel.IShowMonthlyFlyingStarsViewModel
import com.alexis.chineseastrology.viewmodel.ShowMonthlyFlyingStarsViewModel
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog
import java.util.*

class ShowMonthlyFlyingStarsScreen : LinearLayout,
        IViewWithActivity,
        DatePickerDialog.OnDateSetListener
{
    constructor(context: Context?) : this(context, null, 0)
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }

    private lateinit var viewModel: IShowMonthlyFlyingStarsViewModel
    private lateinit var pagerAdapter: MonthlyFlyingStarsCustomPagerAdapter

    private fun init() {
        viewModel = activity.getViewModel<ShowMonthlyFlyingStarsViewModel>()
        viewModel.setup()

        val binding = inflate<ShowMonthlyFlyingStarsScreenBinding>(
                activity.fragmentActivity.layoutInflater,
                R.layout.show_monthly_flying_stars_screen,
                this,
                true
        )
        binding.viewModel = viewModel
        binding.setLifecycleOwner(activity.fragmentActivity)

        val lp = LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        layoutParams = lp
        orientation = VERTICAL
        ViewInjection.inject(this)
        setup()
    }

    fun setup() {
        val activity = (context as? Activity)
        activity?.let {
            val calendar = Calendar.getInstance()
            calendar.time = viewModel.date.value
            val dpd = DatePickerDialog.newInstance(
                    this,
                    calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH)
            )
            val fragmentManager = it.fragmentManager
            dpd.showYearPickerFirst(true)

            dpd.show(fragmentManager, "Datepickerdialog")
        }
    }

    override fun onDateSet(view: DatePickerDialog?, year: Int, monthOfYear: Int, dayOfMonth: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
