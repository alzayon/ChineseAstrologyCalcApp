package com.alexis.chineseastrology.widgets

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.alexis.chineseastrology.lib.flyingstars.time.IFlyingStarGroup
import com.alexis.chineseastrology.lib.flyingstars.time.ITimeFlyingStar

internal class FlyingStarCanvasAdapter() :
        RecyclerView.Adapter<FlyingStarBoxViewHolder>() {

    public var flyingStarGroup: IFlyingStarGroup? = null
        get() = field
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlyingStarBoxViewHolder {
        val flyingStarBox = FlyingStarBox(parent.context)
        return FlyingStarBoxViewHolder(flyingStarBox)
    }

    override fun getItemCount(): Int {
        flyingStarGroup?.let {
            return it.setOfFlyingStars().size
        }
        return 0
    }

    override fun onBindViewHolder(holder: FlyingStarBoxViewHolder, position: Int) {
        flyingStarGroup?.let {
            val timeFlyingStar = it.getStarByOrder(position)
            holder.populate(timeFlyingStar)
        }
    }
}

internal class FlyingStarBoxViewHolder(private val flyingStarBox: FlyingStarBox) : RecyclerView.ViewHolder(flyingStarBox) {
    fun populate(timeFlyingStar: ITimeFlyingStar) {
        flyingStarBox.populate(timeFlyingStar)
    }
}