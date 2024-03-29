package com.alexis.chineseastrology.screens.viewpager

import android.content.Context
import androidx.viewpager.widget.PagerAdapter
import android.view.View
import android.view.ViewGroup
import com.alexis.chineseastrology.lib.flyingstars.time.MonthlyFlyingStarGroup
import com.alexis.chineseastrology.redux.showmonthlyflyingstarscreen.IShowMonthlyFlyingStarsStateGetters
import com.alexis.chineseastrology.widgets.FlyingStarCanvas
import com.alexis.chineseastrology.widgets.FlyingStarCanvasAdapter
import com.alexis.redux.store.IDispatcher

class MonthlyFlyingStarsCustomPagerAdapter(
    private val context: Context,
    private val stateGetters: IShowMonthlyFlyingStarsStateGetters
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
        view.setMode(FlyingStarCanvasAdapter.MODE.MONTHLY)
        if (!observers.containsKey(position)) {
            val observer = createObserver(position, view)
            observers[position] = observer

            // Invoke the observer immediately
            observer(stateGetters.monthlyFlyingStarGroup)
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
            // Invoke the observer
            val observer = it.value
            observer(monthlyFlyingStarGroup)
        }
    }

    private fun createObserver(position: Int, view: FlyingStarCanvas):
            (flyingStarGroup: MonthlyFlyingStarGroup?) -> Unit
    {
        val observer: (monthlyFlyingStarGroup: MonthlyFlyingStarGroup?) -> Unit = { group ->
            group?.let { g ->
                g?.let {
                    if (position == 1) {
                        view.flyingStarGroup = it
                    } else if (position == 2) {
                        // TODO
                        // Use the value from the state...
                        // view.flyingStarGroup = it.giveAdvancedFlyingStarGroup(1)
                        view.flyingStarGroup = stateGetters.nextFlyingStarGroup

                    } else {
                        // TODO
                        // Use the value from the state
                        // view.flyingStarGroup = it.giveRewoundFlyingStarGroup(1)
                        view.flyingStarGroup = stateGetters.previousFlyingStarGroup
                    }
                }
            }
        }
        return observer
    }
}