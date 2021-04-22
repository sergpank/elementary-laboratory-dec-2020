package com.hillel;

import org.junit.Assert;
import org.junit.Test;

public class ArabicToRomanTest {

    @Test
    public void convert1() {
        String actual = new ArabicToRoman().convert(1);
        Assert.assertEquals("expected result is 'I'", "I", actual);
    }

    @Test
    public void convert2() {
        String actual = new ArabicToRoman().convert(2);
        Assert.assertEquals("expected result is 'II'", "II", actual);
    }

    @Test
    public void convert3() {
        String actual = new ArabicToRoman().convert(3);
        Assert.assertEquals("expected result is 'III'", "III", actual);
    }

    @Test
    public void convert4() {
        String actual = new ArabicToRoman().convert(4);
        Assert.assertEquals("expected result is 'IV'", "IV", actual);
    }

    @Test
    public void convert5() {
        String actual = new ArabicToRoman().convert(5);
        Assert.assertEquals("expected result is 'V'", "V", actual);
    }

    @Test
    public void convert6() {
        String actual = new ArabicToRoman().convert(6);
        Assert.assertEquals("expected result is 'VI'", "VI", actual);
    }

    @Test
    public void convert7() {
        String actual = new ArabicToRoman().convert(7);
        Assert.assertEquals("expected result is 'VII'", "VII", actual);
    }

    @Test
    public void convert8() {
        String actual = new ArabicToRoman().convert(8);
        Assert.assertEquals("expected result is 'VIII'", "VIII", actual);
    }

    @Test
    public void convert9() {
        String actual = new ArabicToRoman().convert(9);
        Assert.assertEquals("expected result is 'IX'", "IX", actual);
    }

    @Test
    public void convert10() {
        String actual = new ArabicToRoman().convert(10);
        Assert.assertEquals("expected result is 'X'", "X", actual);
    }
}