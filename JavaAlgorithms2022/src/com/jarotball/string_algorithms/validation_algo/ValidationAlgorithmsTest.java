
/*
 * Copyright (c) 2022.
 * Jahidul Arafat
 * jahidul.arafat@oracle.com
 *
 * All rights reserved.
 */

package com.jarotball.string_algorithms.validation_algo;

import com.jarotball.preinit.optimize_a_sample_algorithm.AlgorithmExample;
import org.junit.Test;

import static org.testng.AssertJUnit.*;

public class ValidationAlgorithmsTest {
    @Test
    public void stringAllUpperCases(){
        assertEquals(true, ValidationAlgorithms.checkStringAllUpperCases("DEMOSTRING"));
        assertEquals(false, ValidationAlgorithms.checkStringAllUpperCases("DEMO STRING")); // due to <space>, this will return false
        assertEquals(false, ValidationAlgorithms.checkStringAllUpperCases("Demo"));
    }

    @Test
    public void stringAllLowerCase(){
        assertEquals(true, ValidationAlgorithms.checkStringAllLowerCases("demostring"));
        assertEquals(false, ValidationAlgorithms.checkStringAllLowerCases("demo string"));
        assertEquals(false, ValidationAlgorithms.checkStringAllLowerCases("Demo"));
    }

    @Test
    public void stringAllLetters(){
        assertEquals(true, ValidationAlgorithms.checkStringAllLetters("demoString"));
        assertEquals(false, ValidationAlgorithms.checkStringAllLetters("demo$tring"));
        assertEquals(false, ValidationAlgorithms.checkStringAllLetters("demo String"));
        assertEquals(true, ValidationAlgorithms.checkStringAllLetters("demo"));
    }

    @Test
    public void stringAllDigits(){
        assertEquals(true, ValidationAlgorithms.checkStringAllDigits("01234"));
        assertEquals(false, ValidationAlgorithms.checkStringAllDigits("01234 5678"));
        assertEquals(false, ValidationAlgorithms.checkStringAllDigits("0#1234"));
        assertEquals(false, ValidationAlgorithms.checkStringAllDigits("Demo1234"));

    }

    @Test
    public void isPasswordComplex(){
        assertTrue(ValidationAlgorithms.checkIsPasswordComplex("Hell0"));
        assertFalse(ValidationAlgorithms.checkIsPasswordComplex("Hello"));
        assertFalse(ValidationAlgorithms.checkIsPasswordComplex("hell0"));
        assertFalse(ValidationAlgorithms.checkIsPasswordComplex("hello"));
        assertFalse(ValidationAlgorithms.checkIsPasswordComplex(" "));

    }


}
