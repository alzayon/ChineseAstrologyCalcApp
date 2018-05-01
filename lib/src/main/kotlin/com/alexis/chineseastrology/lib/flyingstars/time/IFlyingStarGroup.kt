package com.alexis.chineseastrology.lib.flyingstars.time

interface IFlyingStarGroup {
    fun advanceFlyingStarsByStepsWithYear(steps: Int, yearOrMonthToUse: Int): YearlyFlyingStarGroup
    fun advanceFlyingStarsBySteps(steps: Int, yearOrMonthToUse: Int): Set<YearlyFlyingStar>
}