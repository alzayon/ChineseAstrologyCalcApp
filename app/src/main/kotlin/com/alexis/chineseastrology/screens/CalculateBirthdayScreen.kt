package com.alexis.chineseastrology.screens

import android.app.Activity
import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import com.alexis.chineseastrology.R
import com.alexis.chineseastrology.dagger.general.viewinjector.IViewWithActivity
import com.alexis.chineseastrology.dagger.general.viewinjector.ViewInjection
import com.alexis.chineseastrology.databinding.converters.toDefaultFormat
import com.alexis.chineseastrology.general.extensions.getViewModel
import com.alexis.chineseastrology.lib.animalsigns.IAnimalSign
import com.alexis.chineseastrology.redux.calculatebirthdayscreen.CalculateBirthdayActions
import com.alexis.chineseastrology.redux.calculatebirthdayscreen.CalculateBirthdayNotifyResults
import com.alexis.chineseastrology.viewmodel.CalculateBirthdayViewModel
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog
import kotlinx.android.synthetic.main.calculate_birthday_screen.view.*
import timber.log.Timber
import java.util.*

class CalculateBirthdayScreen :
        LinearLayout,
        IViewWithActivity,
        DatePickerDialog.OnDateSetListener {

    constructor(context: Context) : this(context, null, 0)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)  {
        init()
    }

    lateinit var viewModel: CalculateBirthdayViewModel

    private fun init() {
        viewModel = activity.getViewModel<CalculateBirthdayViewModel>()
        View.inflate(context, R.layout.calculate_birthday_screen, this)

        txtBirthdate.setOnClickListener {
            val activity = (context as? Activity)
            activity?.let {
                val calendar = Calendar.getInstance()
                viewModel.store.state.birthdate?.let {
                    calendar.time = it
                }
                val dpd = DatePickerDialog.newInstance(
                        this,
                        calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)
                )
                val fragmentManager = it.fragmentManager
                dpd.showYearPickerFirst(true)

                dpd.show(fragmentManager, "Datepickerdialog")
                dpd.setOnDateSetListener { dialog, year, month, day ->
                    calendar.set(year, month, day)
                    val date = calendar.time
                    viewModel.store.dispatch(CalculateBirthdayActions.SetBirthdate(date))
                    Timber.d("Date selected is " + date)
                }
            }
        }
        btnCalculate.setOnClickListener {
            viewModel.store.dispatch(CalculateBirthdayActions.Calculate)
        }
        ViewInjection.inject(this)
    }

    override fun onDateSet(view: DatePickerDialog, year: Int, monthOfYear: Int, dayOfMonth: Int) {
        val c = Calendar.getInstance()
        c.set(year, monthOfYear, dayOfMonth, 0, 0)
        viewModel.store.dispatch(CalculateBirthdayActions.SetBirthdate(c.time))
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        viewModel.setup(this.activity.fragmentActivity)
        setupObservers()
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        viewModel.store.reset()
    }

    private fun setupObservers() {
        viewModel.store.listen { result ->
            when (result) {
                is CalculateBirthdayNotifyResults.UpdateSelectedDate -> updateSelectedDate ()
                is CalculateBirthdayNotifyResults.CalculationResult -> showCalculationResult(result.animalSign)
                else -> throw IllegalArgumentException("A notify result was not handled!")
            }
            result.consume()
        }
    }

    private fun updateSelectedDate() {
        this.context?.let {
            txtBirthdate.text = viewModel.store.state.birthdate?.toDefaultFormat(it)
        }
    }

    private fun showCalculationResult(animalSign: IAnimalSign) {
        viewBirthdayResult.value = animalSign
    }
}
