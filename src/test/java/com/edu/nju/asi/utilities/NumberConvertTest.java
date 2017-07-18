package com.edu.nju.asi.utilities;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Byron Dong on 2017/7/18.
 */
public class NumberConvertTest {

    private NumberConvert numberConvert;

    @Before
    public void before() throws Exception {
        numberConvert = new NumberConvert();
    }

    @Test
    public void convert() throws Exception {
        assertEquals("1958",numberConvert.convert("一九五八"));
        assertEquals("1958",numberConvert.convert("一95八"));
        assertEquals("1958",numberConvert.convert("1958"));
        assertEquals("10",numberConvert.convert("十"));
        assertEquals("11",numberConvert.convert("十一"));
        assertEquals("20",numberConvert.convert("二十"));
        assertEquals("21",numberConvert.convert("二十一"));
        assertEquals("0",numberConvert.convert("零"));
        assertEquals("0",numberConvert.convert("〇"));
    }

}