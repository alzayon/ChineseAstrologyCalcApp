package com.alexis.chineseastrology.lib.flyingstars.stars

import org.junit.Assert
import org.junit.Test

class VictoryStarTest {
    private var star: VictoryStar = VictoryStar()

    @Test
    fun `next star is illness star`() {
        val nextStar = star.next()
        Assert.assertTrue(nextStar is IllnessStar)
    }

    @Test
    fun `previous star is future prosperity star`() {
        val previousStar = star.previous()
        Assert.assertTrue(previousStar is FutureProsperityStar)
    }
}