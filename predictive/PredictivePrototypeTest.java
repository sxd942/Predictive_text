package predictive;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Tests for the PredictivePrototype.java class.
 * Worksheet 3.
 * @author Sion Davies
 * @version 10/02/20
 */

public class PredictivePrototypeTest {

    /**
     * Testing wordToSignature() for valid inputs
     */

    @Test
    public void test1() {
        String expectedResult = "4663";
        String actualResult = PredictivePrototype.wordToSignature("home");
        assertEquals(expectedResult, actualResult, "Error in wordToSignature()");

        String expectedResult2 = "227426657";
        String actualResult2 = PredictivePrototype.wordToSignature("cashbooks");
        assertEquals(expectedResult2, actualResult2, "Error in wordToSignature()");

    }

    /**
     * Testing wordToSignature() with an input String that
     * has an invalid character.
     */
    @Test
    public void test2() {
        String expectedResult = "2775 3";
        String actualResult = PredictivePrototype.wordToSignature("Appl!e");
        assertEquals(expectedResult, actualResult, "Error in wordToSignature()");
    }

    /**
     * Testing isValidWord() with invalid inputs
     */

    @Test
    public void test3() {
        boolean expected = false;
        boolean actual = PredictivePrototype.isValidWord("4@?");
        assertEquals(expected, actual, "Error in isValidWord");

        boolean expected2 = false;
        boolean actual2 = PredictivePrototype.isValidWord("cabbag!");
        assertEquals(expected2, actual2, "Error in isValidWord()");

        boolean expected3 = false;
        boolean actual3 = PredictivePrototype.isValidWord("  .");
        assertEquals(expected3, actual3, "Error in isValidWord()");

        boolean expected4 = false;
        boolean actual4 = PredictivePrototype.isValidWord(" ");
        assertEquals(expected4, actual4, "Error in isValidWord()");

    }

    /**
     * Testing isValidWord() with valid inputs
     */

    @Test
    public void test4() {
        boolean expected = true;
        boolean actual = PredictivePrototype.isValidWord("hello");
        assertEquals(expected, actual, "Error in isValidWord");

        boolean expected2 = true;
        boolean actual2 = PredictivePrototype.isValidWord("cabbage");
        assertEquals(expected2, actual2, "Error in isValidWord()");

        boolean expected3 = true;
        boolean actual3 = PredictivePrototype.isValidWord("A");
        assertEquals(expected3, actual3, "Error in isValidWord()");

        boolean expected4 = true;
        boolean actual4 = PredictivePrototype.isValidWord("BRILLIANT");
        assertEquals(expected4, actual4, "Error in isValidWord()");

        boolean expected5 = true;
        boolean actual5 = PredictivePrototype.isValidWord("CanNoN");
        assertEquals(expected5, actual5, "Error in isValidWord()");

        boolean expected6 = true;
        boolean actual6 = PredictivePrototype.isValidWord("AT");
        assertEquals(expected6, actual6, "Error in isValidWord()");
    }

    /**
     * Testing wordToSignature() method.
     */
    @Test
    public void test5() {
        assertEquals("2", PredictivePrototype.wordToSignature("a"));
        assertEquals("2", PredictivePrototype.wordToSignature("b"));
        assertEquals("2", PredictivePrototype.wordToSignature("c"));

    }

    @Test
    public void test6() {
        assertEquals("2", PredictivePrototype.wordToSignature("A"));
        assertEquals("2", PredictivePrototype.wordToSignature("B"));
        assertEquals("2", PredictivePrototype.wordToSignature("C"));

    }

    @Test
    public void test7() {
        assertEquals("3", PredictivePrototype.wordToSignature("d"));
        assertEquals("3", PredictivePrototype.wordToSignature("e"));
        assertEquals("3", PredictivePrototype.wordToSignature("f"));
    }

    @Test
    public void test8() {
        assertEquals("3", PredictivePrototype.wordToSignature("D"));
        assertEquals("3", PredictivePrototype.wordToSignature("E"));
        assertEquals("3", PredictivePrototype.wordToSignature("F"));
    }

    @Test
    public void test9() {
        assertEquals("4", PredictivePrototype.wordToSignature("g"));
        assertEquals("4", PredictivePrototype.wordToSignature("h"));
        assertEquals("4", PredictivePrototype.wordToSignature("i"));
    }

    @Test
    public void test10() {
        assertEquals("4", PredictivePrototype.wordToSignature("G"));
        assertEquals("4", PredictivePrototype.wordToSignature("H"));
        assertEquals("4", PredictivePrototype.wordToSignature("I"));
    }

    @Test
    public void test11() {
        assertEquals("5", PredictivePrototype.wordToSignature("j"));
        assertEquals("5", PredictivePrototype.wordToSignature("k"));
        assertEquals("5", PredictivePrototype.wordToSignature("l"));
    }

    @Test
    public void test12() {
        assertEquals("5", PredictivePrototype.wordToSignature("J"));
        assertEquals("5", PredictivePrototype.wordToSignature("K"));
        assertEquals("5", PredictivePrototype.wordToSignature("L"));
    }

    @Test
    public void test13() {
        assertEquals("6", PredictivePrototype.wordToSignature("m"));
        assertEquals("6", PredictivePrototype.wordToSignature("n"));
        assertEquals("6", PredictivePrototype.wordToSignature("o"));
    }

    @Test
    public void test14() {
        assertEquals("6", PredictivePrototype.wordToSignature("M"));
        assertEquals("6", PredictivePrototype.wordToSignature("N"));
        assertEquals("6", PredictivePrototype.wordToSignature("O"));
    }

    @Test
    public void test15() {
        assertEquals("7", PredictivePrototype.wordToSignature("p"));
        assertEquals("7", PredictivePrototype.wordToSignature("q"));
        assertEquals("7", PredictivePrototype.wordToSignature("r"));
        assertEquals("7", PredictivePrototype.wordToSignature("s"));
    }

    @Test
    public void test16() {
        assertEquals("7", PredictivePrototype.wordToSignature("P"));
        assertEquals("7", PredictivePrototype.wordToSignature("Q"));
        assertEquals("7", PredictivePrototype.wordToSignature("R"));
        assertEquals("7", PredictivePrototype.wordToSignature("S"));
    }

    @Test
    public void test17() {
        assertEquals("8", PredictivePrototype.wordToSignature("t"));
        assertEquals("8", PredictivePrototype.wordToSignature("u"));
        assertEquals("8", PredictivePrototype.wordToSignature("v"));
    }

    @Test
    public void test18() {
        assertEquals("8", PredictivePrototype.wordToSignature("T"));
        assertEquals("8", PredictivePrototype.wordToSignature("U"));
        assertEquals("8", PredictivePrototype.wordToSignature("V"));
    }

    @Test
    public void test19() {
        assertEquals("9", PredictivePrototype.wordToSignature("w"));
        assertEquals("9", PredictivePrototype.wordToSignature("x"));
        assertEquals("9", PredictivePrototype.wordToSignature("y"));
        assertEquals("9", PredictivePrototype.wordToSignature("z"));
    }

    @Test
    public void test20() {
        assertEquals("9", PredictivePrototype.wordToSignature("W"));
        assertEquals("9", PredictivePrototype.wordToSignature("X"));
        assertEquals("9", PredictivePrototype.wordToSignature("Y"));
        assertEquals("9", PredictivePrototype.wordToSignature("Z"));
    }

    @Test
    public void test21() {
        // Testing wordToSignature() with valid inputs
        assertEquals("226666", PredictivePrototype.wordToSignature("cannon"));
        assertEquals("93272", PredictivePrototype.wordToSignature("ZEBRA"));
        assertEquals("3323", PredictivePrototype.wordToSignature("Deaf"));
    }

    @Test
    public void test22() {
        // Testing wordToSignature() with invalid inputs
        assertEquals("   ", PredictivePrototype.wordToSignature("!@'"));
        assertEquals("     ", PredictivePrototype.wordToSignature(".5*(£"));
        assertEquals("  ", PredictivePrototype.wordToSignature("%^"));
    }

    @Test
    public void test23() {
        //Testing wordToSignature() with valid and invalid inputs
        assertEquals("22 6 666", PredictivePrototype.wordToSignature("ca@n non"));
        assertEquals("  93272", PredictivePrototype.wordToSignature("}}ZEBRA"));
        assertEquals("3323  ", PredictivePrototype.wordToSignature("Deaf()"));

    }

    /**
     * Testing the signatureToWords() method
     * The following tests are to check for valid inputs.
     */
    @Test
    public void test24() {
        Set<String> expectedSet = new HashSet<>();
        expectedSet.add("im");
        expectedSet.add("hm");
        expectedSet.add("in");
        expectedSet.add("gm");
        expectedSet.add("io");
        expectedSet.add("gn");
        expectedSet.add("ho");
        expectedSet.add("go");
        assertEquals(expectedSet, PredictivePrototype.signatureToWords("46"));
    }


    @Test
    public void test26() {
        Set<String> expectedSet = new HashSet<>();
        expectedSet.add("treasure");
        assertTrue(expectedSet.equals(PredictivePrototype.signatureToWords("87327873")));

    }

    /**
     * Testing the signatureToWords() method
     * The following tests are to check for invalid inputs.
     */

    @Test
    public void test27() {
        Set<String> expectedSet = new HashSet<>();
        assertEquals(expectedSet, PredictivePrototype.signatureToWords(" "));
    }
    @Test
    public void test28() {
        Set<String> expectedSet = new HashSet<>();
        assertEquals(expectedSet, PredictivePrototype.signatureToWords(" 446 3"));
    }
    @Test
    public void test29() {
        Set<String> expectedSet = new HashSet<>();
        assertEquals(expectedSet, PredictivePrototype.signatureToWords("04463"));
    }
    @Test
    public void test30() {
        Set<String> expectedSet = new HashSet<>();
        assertEquals(expectedSet, PredictivePrototype.signatureToWords("f4463"));
    }
    @Test
    public void test31() {
        Set<String> expectedSet = new HashSet<>();
        assertEquals(expectedSet, PredictivePrototype.signatureToWords("87327873f"));
    }

}





