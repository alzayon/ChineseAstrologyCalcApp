package com.alexis.chineseastrology.screens

import android.app.Activity
import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import com.alexis.chineseastrology.R
import com.alexis.chineseastrology.dagger.general.viewinjector.IViewWithActivity
import com.alexis.chineseastrology.dagger.general.viewinjector.ViewInjection
import com.alexis.chineseastrology.general.extensions.getViewModel
import com.alexis.chineseastrology.helpers.toDefaultFormat
import com.alexis.chineseastrology.lib.animalsigns.IAnimalSign
import com.alexis.chineseastrology.redux.calculatebirthdayscreen.Actions
import com.alexis.chineseastrology.redux.calculatebirthdayscreen.NotifyResults
import com.alexis.chineseastrology.redux.calculatebirthdayscreen.ICalculateBirthdayStateGetters
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

    private val stateGetters by lazy {
        viewModel.store.getters() as ICalculateBirthdayStateGetters
    }

    private fun init() {
        viewModel = activity.getViewModel<CalculateBirthdayViewModel>()
        View.inflate(context, R.layout.calculate_birthday_screen, this)
        setupEventListeners()
        ViewInjection.inject(this)
    }

    private fun setupEventListeners() {
        txtBirthdate.setOnClickListener {
            val activity = (context as? Activity)
            activity?.let {
                val calendar = Calendar.getInstance()
                stateGetters.birthdate?.let {
                    calendar.time = it
                }
                val dpd = DatePickerDialog.newInstance(
                        this,
                        calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)
                )
                setDateBoundaries(dpd)
                val fragmentManager = it.fragmentManager
                dpd.showYearPickerFirst(true)

                dpd.setOnDateSetListener { dialog, year, month, day ->
                    calendar.set(year, month, day)
                    val date = calendar.time
                    viewModel.store.dispatch(Actions.SetBirthdate(date))
                    Timber.d("Date selected is " + date)
                }

                dpd.show(fragmentManager, "Datepickerdialog")
            }
        }
        btnCalculate.setOnClickListener {
            viewModel.store.dispatch(Actions.Calculate)
        }
    }

    override fun onDateSet(view: DatePickerDialog, year: Int, monthOfYear: Int, dayOfMonth: Int) {
        val c = Calendar.getInstance()
        c.set(year, monthOfYear, dayOfMonth, 0, 0)
        viewModel.store.dispatch(Actions.SetBirthdate(c.time))
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
                is NotifyResults.UpdateSelectedDate -> updateSelectedDate ()
                is NotifyResults.CalculationResult -> showCalculationResult(result.animalSign)
                else -> throw IllegalArgumentException("A notify result was not handled!")
            }
        }
    }

    private fun updateSelectedDate() {
        this.context?.let {
            txtBirthdate.text = stateGetters.birthdate?.toDefaultFormat(it)
        }
    }

    private fun showCalculationResult(animalSign: IAnimalSign) {
        viewBirthdayResult.value = animalSign
    }

    private fun setDateBoundaries(dpd: DatePickerDialog) {
        // TODO
        // This is not working

        val calendar1 = Calendar.getInstance()
        calendar1.set(1, 1, 1)
        dpd.minDate = calendar1

        val calendar2 = Calendar.getInstance()
        calendar2.set(9999, 12, 31)
        dpd.maxDate = calendar2
    }
}
