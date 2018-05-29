package com.alexis.chineseastrology.lib.flyingstars.time

import com.alexis.chineseastrology.lib.flyingstars.stars.IFlyingStar

data class MonthlyFlyingStarGroup(val monthlyFlyingStars: Set<MonthlyFlyingStar>): BaseFlyingStarGroup() {
    var year: Int = 0
    var month: Int = 0

    init {
        doBasicStarValidation("month", monthlyFlyingStars)
        val distinctMonth = monthlyFlyingStars.distinctBy { it.year.toString() + ":" +  it.month.toString() }
        if (distinctMonth.size > 1) {
            throw IllegalArgumentException("Please supply month stars that are for the same month and year.")
        }
        year = distinctMonth.get(0).year
        month = distinctMonth.get(0).month

        setupFlyingStars(monthlyFlyingStars.toList())
    }

    fun giveAdvancedFlyingStarGroup(steps: Int):
            IFlyingStarGroup {
        if (steps == 0) {
            return MonthlyFlyingStarGroup(monthlyFlyingStars)
        }
        var monthToUse = month + steps
        var yearToUse = year
        if (monthToUse > 12) {
            monthToUse = month + ((steps % 12).toInt())
        }

        val yearsMore: Int = steps / 12
        yearToUse += yearsMore

        val monthlyFlyingStars = advanceFlyingStarsBySteps(steps, monthToUse, yearToUse)
        return MonthlyFlyingStarGroup(monthlyFlyingStars)
    }

    fun giveRewoundFlyingStarGroup(steps: Int):
            IFlyingStarGroup {
        var monthToUse = month - steps
        var yearToUse = year

        if (monthToUse < 0) {
            yearToUse--

            //There is a -1 below because we need to exclude zero in the calculation
            //ie if month is 1, and step is -1, month + step should be = -1, NOT zero
            if (monthToUse < -12) {
                monthToUse = month + (Math.abs((steps % 12).toInt()))
            } else if (monthToUse < 0) {
                monthToUse = (12 - Math.abs(monthToUse))
            }
        }

        val yearsLess: Int = steps / 12
        yearToUse -= yearsLess

        val monthlyFlyingStars = rewindFlyingStarsBySteps(steps, monthToUse, yearToUse)
        return MonthlyFlyingStarGroup(monthlyFlyingStars)
    }

    private fun advanceFlyingStarsBySteps(steps: Int, monthToUse: Int,  yearToUse: Int):
            Set<MonthlyFlyingStar> {
        val setOfStars = setOfFlyingStars()
        val newSetOfStars = setOfStars.map {
            val newFlyingStar = IFlyingStar.advanceByPosition(steps, it.giveStarPosition().flyingStar)
            val newStarPosition = it.giveStarPosition().copy(flyingStar = newFlyingStar)
            val monthlyFlyingStar = it as MonthlyFlyingStar
            return@map monthlyFlyingStar.copy(starPosition = newStarPosition,
                    month = monthToUse,
                    year = yearToUse)
        }.toSet()
        return newSetOfStars
    }

    private fun rewindFlyingStarsBySteps(steps: Int, monthToUse: Int,  yearToUse: Int):
            Set<MonthlyFlyingStar> {
        val setOfStars = setOfFlyingStars()
        val newSetOfStars = setOfStars.map {
            val newFlyingStar = IFlyingStar.rewindByPosition(steps, it.giveStarPosition().flyingStar)
            val newStarPosition = it.giveStarPosition().copy(flyingStar = newFlyingStar)
            val monthlyFlyingStar = it as MonthlyFlyingStar
            return@map monthlyFlyingStar.copy(starPosition = newStarPosition,
                    month = monthToUse,
                    year = yearToUse)
        }.toSet()
        return newSetOfStars
    }
}