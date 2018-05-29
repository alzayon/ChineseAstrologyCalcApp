package com.alexis.chineseastrology.lib.flyingstars.stars

import org.junit.Assert.assertTrue
import org.junit.Test

class BurglaryStarTest {
    private var star: BurglaryStar = BurglaryStar()

    @Test
    fun `next star is wealth star`() {
        val nextStar = star.next()
        assertTrue(nextStar is WealthStar)
    }

    @Test
    fun `previous star is heaven star`() {
        val previousStar = star.previous()
        assertTrue(previousStar is HeavenStar)
    }
}