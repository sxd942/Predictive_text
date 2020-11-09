package predictive;

import org.junit.jupiter.api.Test;
import java.util.HashSet;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for the MapDictionary.java class.
 * Worksheet 3.
 * @author Sion Davies
 * @version 17/02/20
 */

public class MapDictionaryTest {

    // Set dictionary path
    private static final MapDictionary mapDictionary = new MapDictionary("/usr/share/dict/words");
    // Illegal path used for testing constructor exception
    private static final MapDictionary illegalDictionary = new MapDictionary("illegal.txt");


    /**
     * Testing MapDictionary constructor with an invalid path dictionary path
     * file. The test should throw an exception.
     */

    @Test
    public void test1() throws Exception {
        illegalDictionary.signatureToWords("4663");
    }

    /**
     * Testing MapDictionary signatureToWords method with valid inputs.
     */
    @Test
    public void test2() {
        Set<String> expectedList = new HashSet<>();
        expectedList.add("baptizement");

        assertEquals(expectedList, mapDictionary.signatureToWords("22784936368"), "Error in signatureToWords()");
    }

    @Test
    public void test3() {
        Set<String> expectedList = new HashSet<>();
        expectedList.add("milligramme");

        assertEquals(expectedList, mapDictionary.signatureToWords("64554472663"), "Error in signatureToWords()");

    }

    @Test
    public void test4() {
        Set<String> expectedList = new HashSet<>();
        expectedList.add("sidestrokes");

        assertEquals(expectedList, mapDictionary.signatureToWords("74337876537"), "Error in signatureToWords()");

    }

    @Test
    public void test5() {
        Set<String> expectedList = new HashSet<>();
        expectedList.add("shintoist");

        assertEquals(expectedList, mapDictionary.signatureToWords("744686478"), "Error in signatureToWords()");

    }

    /**
     * Testing MapDictionary signatureToWords with invalid inputs
     */

    @Test
    public void test6() {
        Set<String> expectedList = new HashSet<>();

        //invalid number at front of signature
        assertTrue(expectedList.equals(mapDictionary.signatureToWords("0572")));
    }

    @Test
    public void test7() {
        Set<String> expectedList = new HashSet<>();

        //invalid number at end of signature
        assertTrue(expectedList.equals(mapDictionary.signatureToWords("46631")));
    }

    @Test
    public void test8() {
        Set<String> expectedList = new HashSet<>();

        //Invalid signature
        assertTrue(expectedList.equals(mapDictionary.signatureToWords("879870853445343")));
    }

    @Test
    public void test9() {
        Set<String> expectedList = new HashSet<>();

        //Invalid signature
        assertTrue(expectedList.equals(mapDictionary.signatureToWords("!4662")));
    }

}



















