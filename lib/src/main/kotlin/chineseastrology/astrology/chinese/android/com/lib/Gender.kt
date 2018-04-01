package com.alexis.chineseastrology.lib

import com.alexis.chineseastrology.lib.animalsigns.*
import com.alexis.chineseastrology.lib.util.DateUtil
import java.util.*

/**
 * Created by alzayon on 3/28/2018.
 */
enum class Gender {
    MALE, FEMALE;

    companion object {
        public fun getYearGender(date: Date): Gender {
            //TODO
            //Consider first month
            val year = DateUtil.getYearFromDate(date)
            return if(year % 2 == 0) FEMALE else MALE
        }
    }

    public fun getFemaleSigns(): List<IAnimalSign> {
        return listOf(Ox(), Rabbit(), Snake(), Sheep(), Rooster(), Boar())
    }

    public fun getMaleSigns(): List<IAnimalSign> {
        return listOf(Rat(), Tiger(), Dragon(), Horse(), Monkey(), Dog())
    }


}