package predictive;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Tests for the ListDictionary.java class.
 * Worksheet 3.
 * @author Sion Davies
 * @version 11/02/20
 */

public class ListDictionaryTest {

    // Set dictionary path
    private static final ListDictionary listDictionary = new ListDictionary("/usr/share/dict/words");

    /**
     * Testing signatureToWords() for valid inputs.
     */

    @Test
    public void test1(){
        Set<String> expectedList = new HashSet<>();
        expectedList.add("baptizement");

        assertTrue(expectedList.equals(listDictionary.signatureToWords("22784936368")));

    }
    @Test
    public void test2(){
        Set<String> expectedList = new HashSet<>();
        expectedList.add("milligramme");

        assertTrue(expectedList.equals(listDictionary.signatureToWords("64554472663")));
    }
    @Test
    public void test3(){
        Set<String> expectedList = new HashSet<>();
        expectedList.add("sidestrokes");

        assertTrue(expectedList.equals(listDictionary.signatureToWords("74337876537")));
    }

    @Test
    public void test6(){
        Set<String> expectedList = new HashSet<>();
        expectedList.add("shintoist");

        assertEquals(expectedList, listDictionary.signatureToWords("744686478"), "Error in signatureToWords()");
    }


    /**
     * Testing signatureToWords() for invalid inputs.
     */

    @Test
    public void test4(){
        Set<String> expectedList = new HashSet<>();

        //invalid number at front of signature
        assertTrue(expectedList.equals(listDictionary.signatureToWords("0572")));

    }

    @Test
    public void test5(){
        Set<String> expectedList = new HashSet<>();

        //invalid number at end of signature
        assertTrue(expectedList.equals(listDictionary.signatureToWords("46631")));

    }

    @Test
    public void test7(){
        Set<String> expectedList = new HashSet<>();

        //Invalid signature.
        assertEquals(expectedList, listDictionary.signatureToWords("879870853445343"));
    }

    /**
     * Testing isValidSignature with valid inputs.
     */

    @Test
    public void test8(){
        boolean expected = true;
        boolean actual = ListDictionary.isValidSignature("2");

        assertEquals(expected, actual, "Error in isValidSignature()");

    }

    @Test
    public void test9(){
        boolean expected = true;
        boolean actual = ListDictionary.isValidSignature("9");

        assertEquals(expected, actual, "Error in isValidSignature()");

    }

    @Test
    public void test10(){
        boolean expected = true;
        boolean actual = ListDictionary.isValidSignature("2348");

        assertEquals(expected, actual, "Error in isValidSignature()");

    }

    @Test
    public void test11(){
        boolean expected = true;
        boolean actual = ListDictionary.isValidSignature("9256");

        assertEquals(expected, actual, "Error in isValidSignature()");

    }

    /**
     * Testing isValidSignature() for invalid inputs.
     */

    @Test
    public void test12(){
        boolean expected = false;
        boolean actual = ListDictionary.isValidSignature("1");

        assertEquals(expected, actual, "Error in isValidSignature()");
    }

    @Test
    public void test13(){
        boolean expected = false;
        boolean actual = ListDictionary.isValidSignature("*");

        assertEquals(expected, actual, "Error in isValidSignature()");
    }

    @Test
    public void test14(){
        boolean expected = false;
        boolean actual = ListDictionary.isValidSignature("4661");

        assertEquals(expected, actual, "Error in isValidSignature()");
    }

    @Test
    public void test15(){
        boolean expected = false;
        boolean actual = ListDictionary.isValidSignature("0663");

        assertEquals(expected, actual, "Error in isValidSignature()");
    }

    @Test
    public void test16(){
        boolean expected = false;
        boolean actual = ListDictionary.isValidSignature("!34!");

        assertEquals(expected, actual, "Error in isValidSignature()");
    }

}

