package com.alexis.chineseastrology.lib.flyingstars.time

import org.junit.Assert.*
import org.junit.Test

class YearlyFlyingStarGroupTest {

    @Test
    fun `test findYearSetByNum() happy path 1`() {
        val number = 1
        val actual = YearlyFlyingStarGroupSet.findYearSetByNum(number)
        assertNotNull(actual)
        assertTrue(actual == YearlyFlyingStarGroupSet.YearSet.YEARSET1)
    }

    @Test
    fun `test findYearSetByNum() happy path 5`() {
        val number = 5
        val actual = YearlyFlyingStarGroupSet.findYearSetByNum(number)
        assertNotNull(actual)
        assertTrue(actual == YearlyFlyingStarGroupSet.YearSet.YEARSET5)
    }

    @Test
    fun `test findYearSetByNum() happy path 9`() {
        val number = 9
        val actual = YearlyFlyingStarGroupSet.findYearSetByNum(number)
        assertNotNull(actual)
        assertTrue(actual == YearlyFlyingStarGroupSet.YearSet.YEARSET9)
    }

    @Test
    fun `test determineYearSetForYear 2013`() {
        val expected = YearlyFlyingStarGroupSet.YearSet.YEARSET1
        val actual = YearlyFlyingStarGroupSet.determineYearSetForYear(2013)
        assertTrue(actual == expected)

    }

    @Test
    fun `test determineYearSetForYear 2014`() {
        val expected = YearlyFlyingStarGroupSet.YearSet.YEARSET2
        val actual = YearlyFlyingStarGroupSet.determineYearSetForYear(2014)
        assertTrue(actual == expected)

    }

    @Test
    fun `test determineYearSetForYear 2012`() {
        val expected = YearlyFlyingStarGroupSet.YearSet.YEARSET9
        val actual = YearlyFlyingStarGroupSet.determineYearSetForYear(2012)
        assertTrue(actual == expected)
    }

    @Test
    fun `test determineYearSetForYear 2011`() {
        val expected = YearlyFlyingStarGroupSet.YearSet.YEARSET8
        val actual = YearlyFlyingStarGroupSet.determineYearSetForYear(2011)
        assertTrue(actual == expected)
    }

    @Test
    fun `test determineYearSetForYear 2001`() {
        val expected = YearlyFlyingStarGroupSet.YearSet.YEARSET7
        val actual = YearlyFlyingStarGroupSet.determineYearSetForYear(2001)
        assertTrue(actual == expected)
    }

    @Test
    fun `test determineYearSetForYear 1996`() {
        val expected = YearlyFlyingStarGroupSet.YearSet.YEARSET2
        val actual = YearlyFlyingStarGroupSet.determineYearSetForYear(1996)
        assertTrue(actual == expected)
    }

    @Test
    fun `test determineYearSetForYear 1990`() {
        val expected = YearlyFlyingStarGroupSet.YearSet.YEARSET5
        val actual = YearlyFlyingStarGroupSet.determineYearSetForYear(1990)
        assertTrue(actual == expected)
    }

    @Test
    fun `test determineYearSetForYear 2033`() {
        val expected = YearlyFlyingStarGroupSet.YearSet.YEARSET3
        val actual = YearlyFlyingStarGroupSet.determineYearSetForYear(2033)
        assertTrue(actual == expected)
    }

    @Test
    fun `test determineYearSetForYear 2043`() {
        val expected = YearlyFlyingStarGroupSet.YearSet.YEARSET4
        val actual = YearlyFlyingStarGroupSet.determineYearSetForYear(2043)
        assertTrue(actual == expected)
    }

    @Test
    fun `test determineYearSetForYear 1982`() {
        val expected = YearlyFlyingStarGroupSet.YearSet.YEARSET6
        val actual = YearlyFlyingStarGroupSet.determineYearSetForYear(1982)
        assertTrue(actual == expected)
    }
}