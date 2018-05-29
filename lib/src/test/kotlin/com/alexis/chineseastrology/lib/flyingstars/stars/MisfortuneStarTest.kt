package com.alexis.chineseastrology.lib.flyingstars.stars

import org.junit.Assert
import org.junit.Test

class MisfortuneStarTest {
    private var star: MisfortuneStar = MisfortuneStar()

    @Test
    fun `next star is heaven star`() {
        val nextStar = star.next()
        Assert.assertTrue(nextStar is HeavenStar)
    }

    @Test
    fun `previous star is peach blossom star`() {
        val previousStar = star.previous()
        Assert.assertTrue(previousStar is PeachBlossomStar)
    }
}