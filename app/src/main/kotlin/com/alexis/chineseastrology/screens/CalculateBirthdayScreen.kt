package com.alexis.chineseastrology.screens

import android.app.Activity
import android.arch.lifecycle.ViewModel
import android.content.Context
import android.databinding.BindingAdapter
import android.databinding.DataBindingUtil
import android.util.AttributeSet
import android.widget.LinearLayout
import com.alexis.chineseastrology.R
import com.alexis.chineseastrology.dagger.general.viewinjector.IViewWithActivity
import com.alexis.chineseastrology.dagger.general.viewinjector.ViewInjection
import com.alexis.chineseastrology.databinding.CalculateBirthdayScreenBinding
import com.alexis.chineseastrology.general.extensions.getViewModel
import com.alexis.chineseastrology.lib.animalsigns.IAnimalSign
import com.alexis.chineseastrology.viewmodel.CalculateBirthdayViewModel
import com.alexis.chineseastrology.viewmodel.ICalculateBirthdayViewModel
import com.alexis.chineseastrology.views.ICalculateBirthdayScreenView
import com.alexis.chineseastrology.widgets.BirthdayResult
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog
import kotlinx.android.synthetic.main.calculate_birthday_screen.view.*
import java.util.*

class CalculateBirthdayScreen : ICalculateBirthdayScreenView,
        LinearLayout,
        IViewWithActivity,
        DatePickerDialog.OnDateSetListener {

    constructor(context: Context) : this(context, null, 0)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)  {
        init()
    }

    lateinit var viewModel: ICalculateBirthdayViewModel

    private fun init() {
        viewModel = activity.getViewModel<CalculateBirthdayViewModel>()

        val binding = DataBindingUtil.inflate<CalculateBirthdayScreenBinding>(
                activity.fragmentActivity.layoutInflater,
                R.layout.calculate_birthday_screen,
                this,
                true
        )
        binding.viewModel = viewModel
        binding.setLifecycleOwner(activity.fragmentActivity)

        txtBirthdate.setOnClickListener {
            val activity = (context as? Activity)
            activity?.let {
                val calendar = Calendar.getInstance()
                calendar.time = viewModel.getDate()
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

        ViewInjection.inject(this)
    }

    override fun onDateSet(view: DatePickerDialog, year: Int, monthOfYear: Int, dayOfMonth: Int) {
        val c = Calendar.getInstance()
        c.set(year, monthOfYear, dayOfMonth, 0, 0)
        viewModel.setDate(c.time)
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