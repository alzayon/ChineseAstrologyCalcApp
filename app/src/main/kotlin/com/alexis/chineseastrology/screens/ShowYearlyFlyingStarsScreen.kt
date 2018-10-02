package com.alexis.chineseastrology.screens

import android.content.Context
import android.databinding.BindingAdapter
import android.databinding.DataBindingUtil.inflate
import android.databinding.InverseBindingAdapter
import android.databinding.ObservableField
import android.util.AttributeSet
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.widget.EditText
import android.widget.LinearLayout
import com.alexis.chineseastrology.R
import com.alexis.chineseastrology.dagger.general.viewinjector.IViewWithActivity
import com.alexis.chineseastrology.dagger.general.viewinjector.ViewInjection
import com.alexis.chineseastrology.databinding.ShowYearlyFlyingStarsScreenBinding
import com.alexis.chineseastrology.general.extensions.getViewModel
import com.alexis.chineseastrology.lib.flyingstars.time.YearlyFlyingStarGroup
import com.alexis.chineseastrology.viewmodel.IShowYearlyFlyingStarsViewModel
import com.alexis.chineseastrology.viewmodel.ShowYearlyFlyingStarsViewModel
import kotlinx.android.synthetic.main.show_yearly_flying_stars_screen.view.*
import java.util.*

class ShowYearlyFlyingStarsScreen : LinearLayout, IViewWithActivity {
    constructor(context: Context?) : this(context, null, 0)
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }
    lateinit var viewModel: IShowYearlyFlyingStarsViewModel

    private var year: Int = Calendar.getInstance().get(Calendar.YEAR)

    private fun init() {
        viewModel = activity.getViewModel<ShowYearlyFlyingStarsViewModel>()

        val binding = inflate<ShowYearlyFlyingStarsScreenBinding>(
                activity.fragmentActivity.layoutInflater,
                R.layout.show_yearly_flying_stars_screen,
                this,
                true
        )
        binding.viewModel = viewModel

        val lp = LinearLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT)
        layoutParams = lp
        orientation = VERTICAL
        ViewInjection.inject(this)
        setup()
    }

    fun setup() {
        viewModel.calculateYearlyFlyingStarGroup()
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
