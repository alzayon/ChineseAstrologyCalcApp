package com.alexis.chineseastrology.databinding.common

import android.databinding.BindingAdapter
import com.alexis.chineseastrology.lib.animalsigns.IAnimalSign
import com.alexis.chineseastrology.lib.flyingstars.time.IFlyingStarGroup
import com.alexis.chineseastrology.widgets.BirthdayResult
import com.alexis.chineseastrology.widgets.FlyingStarCanvas

object CustomBindings {
    @BindingAdapter("flyingStarGroup")
    @JvmStatic
    fun FlyingStarCanvas.flyingStarGroupBinding(flyingStarGroup: IFlyingStarGroup?) {
        this.flyingStarGroup = flyingStarGroup
    }

    @BindingAdapter("calculateBirthdayResult")
    @JvmStatic
    fun BirthdayResult.calculateBirthdayResult(animalSign: IAnimalSign?) {
        this.value = animalSign
    }
}