package com.alexis.chineseastrology.screens.viewpager

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.view.View
import android.view.ViewGroup
import com.alexis.chineseastrology.lib.flyingstars.time.MonthlyFlyingStarGroup
import com.alexis.chineseastrology.redux.showmonthlyflyingstars.IShowMonthlyFlyingStarsState
import com.alexis.chineseastrology.widgets.FlyingStarCanvas

class MonthlyFlyingStarsCustomPagerAdapter(
        private val context: Context,
        private val state: IShowMonthlyFlyingStarsState
) : PagerAdapter() {

    private val observers = mutableMapOf<Int, (MonthlyFlyingStarGroup?) -> Unit>()

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
            val observer = createObserver(position, view)
            observers[position] = observer
            observer(state.monthlyFlyingStarGroup)
        }
        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, view: Any) {
        container.removeView(view as View)
        observers.remove(position)
    }

    fun onFlyingStarGroupUpdated(monthlyFlyingStarGroup: MonthlyFlyingStarGroup?) {
        observers.entries.forEach {
            it.value(monthlyFlyingStarGroup)
        }
    }

    // TODO
    // giveAdvancedFlyingStarGroup and
    // giveRewoundFlyingStarGroup should be in a processor...
    private fun createObserver(position: Int, view: FlyingStarCanvas):
            (flyingStarGroup: MonthlyFlyingStarGroup?) -> Unit
    {
        val observer: (monthlyFlyingStarGroup: MonthlyFlyingStarGroup?) -> Unit = { group ->
            group?.let { g ->
                g?.let {
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
        return observer
    }
}