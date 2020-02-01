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
        var monthAlreadyAdvanced = month + steps
        var yearAlreadyAdvanced = year
        if (monthAlreadyAdvanced > 12) {
            monthAlreadyAdvanced = (monthAlreadyAdvanced % 12).toInt()
        }

        val yearsMore: Int = (month + steps) / 12
        yearAlreadyAdvanced += yearsMore

        val monthlyFlyingStars = advanceFlyingStarsBySteps(steps, monthAlreadyAdvanced, yearAlreadyAdvanced)
        return MonthlyFlyingStarGroup(monthlyFlyingStars)
    }

    fun giveRewoundFlyingStarGroup(steps: Int):
            IFlyingStarGroup {
        if (steps == 0) {
            return MonthlyFlyingStarGroup(monthlyFlyingStars)
        }

        var monthAlreadyRewound = month - steps //month is within the same year **
        var yearAlreadyRewound = year // **


        // Month is in the previous years, how many?
        // Let's calculate

        if (monthAlreadyRewound <= 0) {
            val remainder = steps % 12
            if (remainder == 0) {
                monthAlreadyRewound = month
                yearAlreadyRewound = year - Math.ceil(steps.toDouble() / 12).toInt()
            } else if (monthAlreadyRewound < -12) {
                val excessOfTwelve = steps % 12
                monthAlreadyRewound = 12 - excessOfTwelve
                if (month != 12) {
                    monthAlreadyRewound += month
                    yearAlreadyRewound = year - Math.ceil(steps.toDouble() / 12).toInt()
                } else {
                    yearAlreadyRewound = year - (steps / 12)
                }

            } else if (monthAlreadyRewound <= 0) { //The month is within the previous year only
                monthAlreadyRewound = (12 - Math.abs(monthAlreadyRewound))
                yearAlreadyRewound--
            }
        }


        val monthlyFlyingStars = rewindFlyingStarsBySteps(steps, monthAlreadyRewound, yearAlreadyRewound)
        return MonthlyFlyingStarGroup(monthlyFlyingStars)
    }

    private fun advanceFlyingStarsBySteps(steps: Int, monthAlreadyAdvanced: Int, yearAlreadyAdvanced: Int):
            Set<MonthlyFlyingStar> {

        val yearlyFlyingStarGroupSet = YearlyFlyingStarGroupSet.determineYearSet(yearAlreadyAdvanced)
        val flyingStarGroup = yearlyFlyingStarGroupSet.getFlyingStarsGroup()


        val setOfStars = setOfFlyingStars()
        val newSetOfStars = setOfStars.map {
            val newFlyingStar = IFlyingStar.advanceByPosition(steps, it.giveStarPosition().flyingStar)
            val newStarPosition = it.giveStarPosition().copy(flyingStar = newFlyingStar)
            val monthlyFlyingStar = it as MonthlyFlyingStar
            return@map monthlyFlyingStar.copy(
                starPosition = newStarPosition,
                month = monthAlreadyAdvanced,
                year = yearAlreadyAdvanced,
                yearlyStarPosition = flyingStarGroup.setOfFlyingStars().filter {
                    it.giveStarPosition().compassDirection == newStarPosition.compassDirection
                }.first().giveStarPosition()
            )
        }.toSet()
        return newSetOfStars
    }

    private fun rewindFlyingStarsBySteps(steps: Int, monthAlreadyRewound: Int, yearAlreadyRewound: Int):
            Set<MonthlyFlyingStar> {


        val yearlyFlyingStarGroupSet = YearlyFlyingStarGroupSet.determineYearSet(yearAlreadyRewound)
        val flyingStarGroup = yearlyFlyingStarGroupSet.getFlyingStarsGroup()

        val setOfStars = setOfFlyingStars()
        val newSetOfStars = setOfStars.map {
            val newFlyingStar = IFlyingStar.rewindByPosition(steps, it.giveStarPosition().flyingStar)
            val newStarPosition = it.giveStarPosition().copy(flyingStar = newFlyingStar)
            val monthlyFlyingStar = it as MonthlyFlyingStar
            return@map monthlyFlyingStar.copy(
                starPosition = newStarPosition,
                month = monthAlreadyRewound,
                year = yearAlreadyRewound,
                yearlyStarPosition = flyingStarGroup.setOfFlyingStars().filter {
                    it.giveStarPosition().compassDirection == newStarPosition.compassDirection
                }.first().giveStarPosition()
            )
        }.toSet()
        return newSetOfStars
    }
}