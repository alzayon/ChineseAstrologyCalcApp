package com.alexis.chineseastrology.screens.viewpager

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.alexis.chineseastrology.lib.flyingstars.time.IFlyingStarGroup
import com.alexis.chineseastrology.viewmodel.IShowYearlyFlyingStarsViewModel
import com.alexis.chineseastrology.widgets.FlyingStarCanvas
import timber.log.Timber

class CustomPagerAdapter(
    private val context: Context,
    private val layoutInflater: LayoutInflater,
    private val viewModel: IShowYearlyFlyingStarsViewModel,
    public var year: Int
) : PagerAdapter() {

    override fun isViewFromObject(view: View, obj: Any): Boolean {
        val objView = (obj as View)
        val result = view == objView
        return result
    }

    override fun getCount(): Int {
       return 3
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = FlyingStarCanvas(context)
        view.flyingStarGroup = viewModel.yearlyFlyingStarGroup.get()
        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, view: Any) {
        container.removeView(view as View)
    }

    //call this method to update fragments in ViewPager dynamically
    fun update() {
        notifyDataSetChanged()
    }
}