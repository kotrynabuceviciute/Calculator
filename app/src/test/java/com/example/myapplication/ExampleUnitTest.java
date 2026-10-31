package com.example.myapplication;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    @Test
    public void testPlus() {
        assertEquals("8", MainActivity.calculate("5+3"));
    }

    @Test
    public void testMinus() {
        assertEquals("6", MainActivity.calculate("10-4"));
    }

    @Test
    public void testMultiple() {
        assertEquals("25", MainActivity.calculate("5*5"));
    }

    @Test
    public void testDivide() {
        assertEquals("5", MainActivity.calculate("30/6"));
    }

    @Test
    public void testSqrt() {
        assertEquals("2", MainActivity.calculate("√4"));
    }

    @Test
    public void testNegativeSqrt() {
        assertEquals("Klaida", MainActivity.calculate("√-9"));
    }
    @Test
    public void testDivideWithDecimal() {
        assertEquals("1,25", MainActivity.calculate("5/4"));
    }
    @Test
    public void testSqrtNotPerfect() {
        assertEquals("1,41", MainActivity.calculate("√2"));
    }
    @Test
    public void testSqrtZero() {
        assertEquals("0", MainActivity.calculate("√0"));
    }
    @Test
    public void testCombinedOperations() {
        assertEquals("14", MainActivity.calculate("2+3*4"));
    }
    @Test
    public void testDivideByZero() {
        assertEquals("Klaida", MainActivity.calculate("5/0"));
    }
    @Test
    public void testEmptyInput() {
        assertEquals("Klaida", MainActivity.calculate(""));
    }
    @Test
    public void testOrderOfOperations() {
        assertEquals("23", MainActivity.calculate("3+4*5"));
    }
    @Test
    public void testNegativeNumber() {
        assertEquals("-2", MainActivity.calculate("3-5"));
    }
    @Test
    public void testDecimalInput() {
        assertEquals("7,50", MainActivity.calculate("2.5+5"));
    }
    @Test
    public void testOnlySpaces() {
        assertEquals("Klaida", MainActivity.calculate(" "));
    }

}