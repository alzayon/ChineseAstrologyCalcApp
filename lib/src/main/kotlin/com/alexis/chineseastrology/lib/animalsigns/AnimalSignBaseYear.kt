package com.alexis.chineseastrology.lib.animalsigns

import com.alexis.chineseastrology.lib.elements.*

/**
 * Created by alzayon on 3/30/2018.
 */
sealed class AnimalSignBaseYear(public val year: Int,
                                public val animalSign: IAnimalSign) {
    companion object {
        fun getFemaleBaseYears(): List<AnimalSignBaseYear> {
            return listOf(OxSignBaseYear(), RabbitSignBaseYear(),
                    SnakeSignBaseYear(), SheepSignBaseYear(),
                    RoosterSignBaseYear(), BoarSignBaseYear())
        }

        fun getMaleBaseYears(): List<AnimalSignBaseYear> {
            return listOf(RatSignBaseYear(), TigerSignBaseYear(),
                    DragonSignBaseYear(), HorseSignBaseYear(),
                    MonkeySignBaseYear(), DogSignBaseYear())
        }

        fun getAllBaseYears(): List<AnimalSignBaseYear> {
            return listOf(RatSignBaseYear(), OxSignBaseYear(),
                    TigerSignBaseYear(), RabbitSignBaseYear(),
                    DragonSignBaseYear(), SnakeSignBaseYear(),
                    HorseSignBaseYear(), SheepSignBaseYear(),
                    MonkeySignBaseYear(), RoosterSignBaseYear(),
                    DogSignBaseYear(), BoarSignBaseYear())
        }
    }
}

class RatSignBaseYear(val y:  Int = 1900,
                      val a: IAnimalSign = Rat(MetalElement())) : AnimalSignBaseYear(y, a)

class OxSignBaseYear(val y:  Int = 1901,
                      val a: IAnimalSign = Ox(MetalElement())) : AnimalSignBaseYear(y, a)

class TigerSignBaseYear(val y:  Int = 1902,
                      val a: IAnimalSign = Tiger(WaterElement())) : AnimalSignBaseYear(y, a)

class RabbitSignBaseYear(val y:  Int = 1903,
                      val a: IAnimalSign = Rabbit(WaterElement())) : AnimalSignBaseYear(y, a)

class DragonSignBaseYear(val y:  Int = 1904,
                      val a: IAnimalSign = Dragon(WoodElement())) : AnimalSignBaseYear(y, a)

class SnakeSignBaseYear(val y:  Int = 1905,
                      val a: IAnimalSign = Snake(WoodElement())) : AnimalSignBaseYear(y, a)

class HorseSignBaseYear(val y:  Int = 1906,
                      val a: IAnimalSign = Horse(FireElement())) : AnimalSignBaseYear(y, a)

class SheepSignBaseYear(val y:  Int = 1907,
                      val a: IAnimalSign = Sheep(FireElement())) : AnimalSignBaseYear(y, a)

class MonkeySignBaseYear(val y:  Int = 1908,
                      val a: IAnimalSign = Monkey(EarthElement())) : AnimalSignBaseYear(y, a)

class RoosterSignBaseYear(val y:  Int = 1909,
                      val a: IAnimalSign = Rooster(EarthElement())) : AnimalSignBaseYear(y, a)

class DogSignBaseYear(val y:  Int = 1910,
                      val a: IAnimalSign = Dog(MetalElement())) : AnimalSignBaseYear(y, a)

class BoarSignBaseYear(val y:  Int = 1911,
                      val a: IAnimalSign = Boar(MetalElement())) : AnimalSignBaseYear(y, a)