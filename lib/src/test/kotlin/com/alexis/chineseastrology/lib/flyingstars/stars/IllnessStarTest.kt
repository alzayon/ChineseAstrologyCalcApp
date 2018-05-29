package com.alexis.chineseastrology.lib.flyingstars.stars

import org.junit.Assert
import org.junit.Test

class IllnessStarTest {
    private var star: IllnessStar = IllnessStar()

    @Test
    fun `next star is quarrelsome star`() {
        val nextStar = star.next()
        Assert.assertTrue(nextStar is QuarrelsomeStar)
    }

    @Test
    fun `previous star is victory star`() {
        val previousStar = star.previous()
        Assert.assertTrue(previousStar is VictoryStar)
    }
}