package com.alexis.chineseastrology.screens

import android.app.Activity
import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import com.alexis.chineseastrology.R
import com.alexis.chineseastrology.dagger.general.viewinjector.IViewWithActivity
import com.alexis.chineseastrology.dagger.general.viewinjector.ViewInjection
import com.alexis.chineseastrology.lib.IBdayCalculator
import com.alexis.chineseastrology.views.ICalculateBirthdayScreenView
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog
import kotlinx.android.synthetic.main.calculate_birthday_screen.view.*
import timber.log.Timber
import java.util.*
import javax.inject.Inject


class CalculateBirthdayScreen : ICalculateBirthdayScreenView,
        LinearLayout,
        IViewWithActivity,
        DatePickerDialog.OnDateSetListener {

    constructor(context: Context) : this(context, null, 0)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)  {
        init()
    }

    var date: Date? = null

    @Inject
    lateinit var bdayCalculator: IBdayCalculator

    private fun init() {
        View.inflate(context, R.layout.calculate_birthday_screen, this)
        birthdayTextView.setOnClickListener {
            val activity = (context as? Activity)
            activity?.let {
                val now = Calendar.getInstance()
                val dpd = DatePickerDialog.newInstance(
                        this,
                        now.get(Calendar.YEAR),
                        now.get(Calendar.MONTH),
                        now.get(Calendar.DAY_OF_MONTH)
                )
                val fragmentManager = it.fragmentManager
                dpd.showYearPickerFirst(true)
                dpd.show(fragmentManager, "Datepickerdialog")
            }
        }

        ViewInjection.inject(this)

        calculateButton.setOnClickListener {
            val result = bdayCalculator.calculate(Date())
            Timber.d("Calcuate Result %s", result)
        }
    }

    override fun onDateSet(view: DatePickerDialog, year: Int, monthOfYear: Int, dayOfMonth: Int) {
        val dateString = "" + year + "-" + (monthOfYear + 1) + "-" + dayOfMonth
        val c = Calendar.getInstance()
        c.set(year, monthOfYear, dayOfMonth, 0, 0)
        date = c.time
        birthdayTextView.setText(dateString)
    }
}