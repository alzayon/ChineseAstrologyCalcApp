package com.alexis.chineseastrology.screens.viewpager

import android.content.Context
import androidx.viewpager.widget.PagerAdapter
import android.view.View
import android.view.ViewGroup
import com.alexis.chineseastrology.lib.flyingstars.time.IFlyingStarGroup
import com.alexis.chineseastrology.lib.flyingstars.time.YearlyFlyingStarGroup
import com.alexis.chineseastrology.redux.showyearlyflyingstarscreen.IShowYearlyFlyingStarsStateGetters
import com.alexis.chineseastrology.redux.showyearlyflyingstarscreen.ShowYearlyFlyingStarsAction
import com.alexis.chineseastrology.widgets.FlyingStarCanvas
import com.alexis.redux.store.IDispatcher

class YearlyFlyingStarsCustomPagerAdapter(
    private val context: Context,
    private val stateGetters: IShowYearlyFlyingStarsStateGetters
) : PagerAdapter() {

    private val observers = mutableMapOf<Int, (YearlyFlyingStarGroup?) -> Unit>()

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

            // Invoke the observer immediately
            observer(stateGetters.yearlyFlyingStarGroup)
        }
        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, view: Any) {
        container.removeView(view as View)
        observers.remove(position)
    }

    fun onFlyingStarGroupUpdated(yearlyFlyingStarGroup: YearlyFlyingStarGroup?) {
        observers.entries.forEach {
            // Invoke the observer
            val observer= it.value
            observer(yearlyFlyingStarGroup)
        }
    }

    private fun createObserver(position: Int, view: FlyingStarCanvas):
            (flyingStarGroup: YearlyFlyingStarGroup?) -> Unit
    {
        val observer: (yearlyFlyingStarGroup: YearlyFlyingStarGroup?) -> Unit = { group ->
            group?.let { g ->
                g?.let {
                    if (position == 1) {
                        view.flyingStarGroup = it
                    } else if (position == 2) {
                        view.flyingStarGroup = stateGetters.nextFlyingStarGroup
                    } else {
                        view.flyingStarGroup = stateGetters.previousFlyingStarGroup
                    }
                }
            }
        }
        return observer
    }
}
