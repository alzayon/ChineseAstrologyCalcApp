package com.alexis.chineseastrology.lib

import com.alexis.chineseastrology.lib.animalsigns.*
import com.alexis.chineseastrology.lib.elements.*
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.lang.annotation.ElementType
import java.util.*


class BdayCalculatorTest {

    private var calculator: IBdayCalculator = BdayCalculator()

    @Test
    fun `calculate find rat sign`() {
        //June 2, 1984
        val date = Date(454953600000)

        val sign = calculator.calculate(date)

        val expected = Rat(WoodElement())
        Assert.assertEquals(expected, sign)
    }

    @Test
    fun `calculate find ox sign`() {
        //June 2, 1973
        val date = Date(107798400000)

        val sign = calculator.calculate(date)

        val expected = Ox(WaterElement())
        Assert.assertEquals(expected, sign)
    }

    @Test
    fun `calculate find tiger sign`() {
        //June 2, 1950
        val date = Date(-618048000000)

        val sign = calculator.calculate(date)

        val expected = Tiger(MetalElement())
        Assert.assertEquals(expected, sign)
    }

    @Test
    fun `calculate find rabbit sign`() {
        //June 2, 1999
        val date = Date(928252800000)

        val sign = calculator.calculate(date)

        val expected = Rabbit(EarthElement())
        Assert.assertEquals(expected, sign)
    }

    @Test
    fun `calculate find dragon sign`() {
        //June 2, 2000
        val date = Date(959875200000)

        val sign = calculator.calculate(date)

        val expected = Dragon(MetalElement())
        Assert.assertEquals(expected, sign)
    }

    @Test
    fun `calculate find snake sign`() {
        //June 2, 1965
        val date = Date(-144662400000)

        val sign = calculator.calculate(date)

        val expected = Snake(WoodElement())
        Assert.assertEquals(expected, sign)
    }

    @Test
    fun `calculate find horse sign`() {
        //June 2, 1942
        val date = Date(-870508800000)

        val sign = calculator.calculate(date)

        val expected = Horse(WaterElement())
        Assert.assertEquals(expected, sign)
    }

    @Test
    fun `calculate find monkey sign`() {
        //June 2, 2100
        val date = Date(4115548800000)

        val sign = calculator.calculate(date)

        val expected = Monkey(MetalElement())
        Assert.assertEquals(expected, sign)
    }

    @Test
    fun `calculate find rooster sign`() {
        //June 2, 2017
        val date = Date(1496332800000)

        val sign = calculator.calculate(date)

        val expected = Rooster(FireElement())
        Assert.assertEquals(expected, sign)
    }

    @Test
    fun `calculate find dog sign`() {
        //June 2, 2102
        val date = Date(4178620800000)

        val sign = calculator.calculate(date)

        val expected = Dog(WaterElement())
        Assert.assertEquals(expected, sign)
    }

    @Test
    fun `calculate find boar sign`() {
        //June 2, 2007
        val date = Date(1180713600000)

        val sign = calculator.calculate(date)

        val expected = Boar(FireElement())
        Assert.assertEquals(expected, sign)
    }
}