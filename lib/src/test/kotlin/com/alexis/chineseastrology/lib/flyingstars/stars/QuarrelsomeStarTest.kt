package com.alexis.chineseastrology.lib.flyingstars.stars

import org.junit.Assert
import org.junit.Test

class QuarrelsomeStarTest {
    private var star: QuarrelsomeStar = QuarrelsomeStar()

    @Test
    fun `next star is peach blossom star`() {
        val nextStar = star.next()
        Assert.assertTrue(nextStar is PeachBlossomStar)
    }

    @Test
    fun `previous star is illness star`() {
        val previousStar = star.previous()
        Assert.assertTrue(previousStar is IllnessStar)
    }
}