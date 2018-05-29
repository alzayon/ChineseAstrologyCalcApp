package com.alexis.chineseastrology.lib.flyingstars.stars

import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class IFlyingStarTest {
    private var star: IFlyingStar? = null

    @Test
    fun `advanceByPosition() will advance the star, happy path`() {
        star = IllnessStar()
        val steps = 3
        //NOTE
        //Advancing a star actually moves the number backward
        //and vice versa
        val nextStar = IFlyingStar.advanceByPosition(steps, star!!)
        Assert.assertTrue(nextStar is WealthStar)
    }

    @Test
    fun `rewindByPosition() will advance the star, happy path`() {
        star = IllnessStar()
        val steps = 4
        //NOTE
        //Advancing a star actually moves the number backward
        //and vice versa
        val nextStar = IFlyingStar.rewindByPosition(steps, star!!)
        Assert.assertTrue(nextStar is HeavenStar)
    }

    @After
    fun tearDown() {
        star = null
    }
}