package com.alexis.chineseastrology.screens.viewpager

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.Observer
import android.content.Context
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alexis.chineseastrology.lib.flyingstars.time.YearlyFlyingStarGroup
import com.alexis.chineseastrology.viewmodel.IShowYearlyFlyingStarsViewModel
import com.alexis.chineseastrology.widgets.FlyingStarCanvas

class YearlyFlyingStarsCustomPagerAdapter(
    private val context: Context,
    private val viewModel: IShowYearlyFlyingStarsViewModel
) : PagerAdapter() {

    private val observers = mutableMapOf<Int, Observer<YearlyFlyingStarGroup?>>()

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
        if (!observers.containsKey(position)) {
            val observer = FlyingStarChangeCallback(position, view)
            observers[position] = observer
            viewModel.yearlyFlyingStarGroup.observe(context as LifecycleOwner, observer)
        }
        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, view: Any) {
        container.removeView(view as View)
        observers[position]?.let {
            viewModel.yearlyFlyingStarGroup.removeObserver(it)
        }
    }

    private class FlyingStarChangeCallback(
        private val position: Int,
        private val view: FlyingStarCanvas
    ) : Observer<YearlyFlyingStarGroup?> {
        override fun onChanged(yearlyFlyingStarGroup: YearlyFlyingStarGroup?) {
            yearlyFlyingStarGroup?.let {
                it?.let {
                    if (position == 1) {
                        view.flyingStarGroup = it
                    } else if (position == 2) {
                        view.flyingStarGroup = it.giveAdvancedFlyingStarGroup(1)
                    } else {
                        view.flyingStarGroup = it.giveRewoundFlyingStarGroup(1)
                    }
                }
            }
        }
    }
}