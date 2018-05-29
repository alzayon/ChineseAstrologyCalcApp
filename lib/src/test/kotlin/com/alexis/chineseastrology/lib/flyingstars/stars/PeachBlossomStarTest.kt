package com.alexis.chineseastrology.lib.flyingstars.stars

import org.junit.Assert
import org.junit.Test

class PeachBlossomStarTest {
    private var star: PeachBlossomStar = PeachBlossomStar()

    @Test
    fun `next star is misfortune star`() {
        val nextStar = star.next()
        Assert.assertTrue(nextStar is MisfortuneStar)
    }

    @Test
    fun `previous star is quarelsome star`() {
        val previousStar = star.previous()
        Assert.assertTrue(previousStar is QuarrelsomeStar)
    }
}