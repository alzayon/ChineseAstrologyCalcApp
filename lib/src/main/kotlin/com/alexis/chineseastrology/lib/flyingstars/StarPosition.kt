package com.alexis.chineseastrology.lib.flyingstars

import com.alexis.chineseastrology.lib.general.CompassDirection
import com.alexis.chineseastrology.lib.flyingstars.stars.IFlyingStar

data class StarPosition(val compassDirection: CompassDirection,
                        val flyingStar: IFlyingStar) {

}