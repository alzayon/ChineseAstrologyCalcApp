package com.alexis.chineseastrology.lib.flyingstars.stars

import org.junit.Assert
import org.junit.Test

class HeavenStarTest {
    private var star: HeavenStar = HeavenStar()

    @Test
    fun `next star is burglary star`() {
        val nextStar = star.next()
        Assert.assertTrue(nextStar is BurglaryStar)
    }

    @Test
    fun `previous star is misfortune star`() {
        val previousStar = star.previous()
        Assert.assertTrue(previousStar is MisfortuneStar)
    }
}