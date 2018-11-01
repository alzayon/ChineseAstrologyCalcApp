package com.alexis.chineseastrology.databinding.common

import android.databinding.BindingAdapter
import com.alexis.chineseastrology.lib.flyingstars.time.IFlyingStarGroup
import com.alexis.chineseastrology.widgets.FlyingStarCanvas

object CustomBindings {
    @BindingAdapter("flyingStarGroup")
    @JvmStatic
    fun FlyingStarCanvas.flyingStarGroupBinding(flyingStarGroup: IFlyingStarGroup?) {
        this.flyingStarGroup = flyingStarGroup
    }
}