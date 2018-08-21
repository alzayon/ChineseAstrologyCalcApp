package com.alexis.chineseastrology.widgets

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.alexis.chineseastrology.lib.flyingstars.time.IFlyingStarGroup
import com.alexis.chineseastrology.lib.flyingstars.time.ITimeFlyingStar

internal class FlyingStarCanvasAdapter(private val flyingStarGroup: IFlyingStarGroup) :
        RecyclerView.Adapter<FlyingStarBoxViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlyingStarBoxViewHolder {
        val flyingStarBox = FlyingStarBox(parent.context)
        return FlyingStarBoxViewHolder(flyingStarBox)
    }

    override fun getItemCount(): Int {
        return flyingStarGroup.setOfFlyingStars().size
    }

    override fun onBindViewHolder(holder: FlyingStarBoxViewHolder, position: Int) {
        val timeFlyingStar = flyingStarGroup.getStarByOrder(position)
        holder.populate(timeFlyingStar)
    }
}

internal class FlyingStarBoxViewHolder(private val flyingStarBox: FlyingStarBox) : RecyclerView.ViewHolder(flyingStarBox) {
    fun populate(timeFlyingStar: ITimeFlyingStar) {
        flyingStarBox.populate(timeFlyingStar)
    }
}