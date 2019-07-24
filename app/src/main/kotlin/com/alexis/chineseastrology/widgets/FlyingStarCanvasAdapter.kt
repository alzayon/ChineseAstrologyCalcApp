package com.alexis.chineseastrology.widgets

import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import com.alexis.chineseastrology.lib.flyingstars.time.IFlyingStarGroup
import com.alexis.chineseastrology.lib.flyingstars.time.ITimeFlyingStar

class FlyingStarCanvasAdapter() :
        RecyclerView.Adapter<FlyingStarBoxViewHolder>() {

    enum class MODE {
        YEARLY, MONTHLY
    }

    var flyingStars: List<ITimeFlyingStar>? = null
        get() = field
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    var mode : MODE = MODE.YEARLY
        set (value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlyingStarBoxViewHolder {
        val flyingStarBox = FlyingStarBox(parent.context)
        if (mode == MODE.MONTHLY) {
            flyingStarBox.monthlyDisplay = true
        } else {
            flyingStarBox.monthlyDisplay = false
        }
        flyingStarBox.setup()
        return FlyingStarBoxViewHolder(flyingStarBox)
    }

    override fun getItemCount(): Int {
        flyingStars?.let {
            return it.size
        }
        return 0
    }

    override fun onBindViewHolder(holder: FlyingStarBoxViewHolder, position: Int) {
        flyingStars?.let {
            val timeFlyingStar = it.get(position)
            holder.populate(timeFlyingStar)
        }
    }

    fun clear() {
        flyingStars = listOf()
        notifyDataSetChanged()
    }
}

class FlyingStarBoxViewHolder(private val flyingStarBox: FlyingStarBox) : RecyclerView.ViewHolder(flyingStarBox) {
    fun populate(timeFlyingStar: ITimeFlyingStar) {
        flyingStarBox.populate(timeFlyingStar)
    }
}