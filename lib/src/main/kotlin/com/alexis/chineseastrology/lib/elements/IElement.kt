package com.alexis.chineseastrology.lib.elements

/**
 * Created by alzayon on 3/27/2018.
 */
interface IElement {
    val name: String
    val position: Int

    public fun getPreviousElement(): IElement {
        when (this) {
            MetalElement() -> return EarthElement()
            WaterElement() -> return MetalElement()
            WoodElement()  -> return WaterElement()
            FireElement()  -> return WoodElement()
            EarthElement() -> return FireElement()
        }
        return EarthElement()
    }
}
