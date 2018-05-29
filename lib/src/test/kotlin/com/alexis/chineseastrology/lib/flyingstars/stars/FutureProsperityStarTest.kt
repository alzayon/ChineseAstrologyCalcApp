package com.alexis.chineseastrology.lib.flyingstars.stars

import org.junit.Assert
import org.junit.Test

class FutureProsperityStarTest {
    private var star: FutureProsperityStar = FutureProsperityStar()

    @Test
    fun `next star is victory star`() {
        val nextStar = star.next()
        Assert.assertTrue(nextStar is VictoryStar)
    }

    @Test
    fun `previous star is wealth star`() {
        val previousStar = star.previous()
        Assert.assertTrue(previousStar is WealthStar)
    }
}