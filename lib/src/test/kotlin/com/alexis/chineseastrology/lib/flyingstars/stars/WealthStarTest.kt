package com.alexis.chineseastrology.lib.flyingstars.stars

import org.junit.Assert
import org.junit.Test

class WealthStarTest {
    private var star: WealthStar = WealthStar()

    @Test
    fun `next star is future prosperity star`() {
        val nextStar = star.next()
        Assert.assertTrue(nextStar is FutureProsperityStar)
    }

    @Test
    fun `previous star is burglary star`() {
        val previousStar = star.previous()
        Assert.assertTrue(previousStar is BurglaryStar)
    }
}