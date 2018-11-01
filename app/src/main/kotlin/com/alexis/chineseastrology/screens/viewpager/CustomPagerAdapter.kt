package com.alexis.chineseastrology.screens.viewpager

import android.content.Context
import android.databinding.Observable
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alexis.chineseastrology.viewmodel.IShowYearlyFlyingStarsViewModel
import com.alexis.chineseastrology.widgets.FlyingStarCanvas

class CustomPagerAdapter(
    private val context: Context,
    private val layoutInflater: LayoutInflater,
    private val viewModel: IShowYearlyFlyingStarsViewModel
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
        viewModel.yearlyFlyingStarGroup.addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback() {
            override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                if (position == 0) {
                    view.flyingStarGroup = viewModel.yearlyFlyingStarGroup.get()?.giveRewoundFlyingStarGroup(1)
                } else if (position == 2) {
                    view.flyingStarGroup = viewModel.yearlyFlyingStarGroup.get()?.giveAdvancedFlyingStarGroup(1)

                } else {
                    view.flyingStarGroup = viewModel.yearlyFlyingStarGroup.get()
                }

            }
        })
        viewModel.yearlyFlyingStarGroup.notifyChange()
        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, view: Any) {
        container.removeView(view as View)
    }
}