package predictive;

import org.junit.jupiter.api.Test;
import java.util.HashSet;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for TreeDictionary.java
 * Worksheet 3.
 * @Author: Sion Davies
 * @Version: 18/02/20
 */

public class TreeDictionaryTest {

    // Set dictionary path
    private static final TreeDictionary treeDictionary = new TreeDictionary("/usr/share/dict/words");
    // Incorrect path used for testing constructor exception
    private static final TreeDictionary illegalTreeDictionary = new TreeDictionary("illegal.txt");

    /**
     * Testing the TreeDictionary constructor with an invalid path dictionary.
     */

    @Test
    public void test1() throws Exception {
        illegalTreeDictionary.signatureToWords("4663");
    }

    /**
     * Testing TreeDictionary signatureToWords() method with valid inputs.
     */

    @Test
    public void test2() {
        Set<String> expectedList = new HashSet<>();
        expectedList.add("baptizement");

        assertEquals(expectedList, treeDictionary.signatureToWords("22784936368"), "Error in signatureToWords()");
    }

    @Test
    public void test3() {
        Set<String> expectedList = new HashSet<>();
        expectedList.add("milligramme");

        assertEquals(expectedList, treeDictionary.signatureToWords("64554472663"), "Error in signatureToWords()");

    }

    @Test
    public void test4() {
        Set<String> expectedList = new HashSet<>();
        expectedList.add("sidestrokes");

        assertEquals(expectedList, treeDictionary.signatureToWords("74337876537"), "Error in signatureToWords()");

    }

    @Test
    public void test5() {
        Set<String> expectedList = new HashSet<>();
        expectedList.add("shintoist");

        assertEquals(expectedList, treeDictionary.signatureToWords("744686478"), "Error in signatureToWords()");

    }

    /**
     * Testing TreeDictionary signatureToWords() with invalid inputs.
     */

    @Test
    public void test6() {
        Set<String> expectedList = new HashSet<>();

        //invalid number at front of signature
        assertTrue(expectedList.equals(treeDictionary.signatureToWords("0572")));
    }

    @Test
    public void test7() {
        Set<String> expectedList = new HashSet<>();

        //invalid number at end of signature
        assertTrue(expectedList.equals(treeDictionary.signatureToWords("46631")));
    }

    @Test
    public void test8() {
        Set<String> expectedList = new HashSet<>();

        //Invalid signature
        assertTrue(expectedList.equals(treeDictionary.signatureToWords("879870853445343")));
    }

    @Test
    public void test9() {
        Set<String> expectedList = new HashSet<>();

        //Invalid signature
        assertTrue(expectedList.equals(treeDictionary.signatureToWords("!4662")));
    }

    /**
     * Testing trimWords() with invalid inputs.
     * An exception should be thrown.
     */

    @Test
    public void test10()  {
        assertThrows(IllegalArgumentException.class, () ->
                treeDictionary.trimWords("0446", 3));
    }

    @Test
    public void test11()  {
        assertThrows(IllegalArgumentException.class, () ->
                treeDictionary.trimWords("446!", 3));
    }

    @Test
    public void test13()  {
        assertThrows(IllegalArgumentException.class, () ->
                treeDictionary.trimWords("4.6", 3));
    }

    /**
     * Testing trimWords() with valid inputs.
     */

    @Test
    public void test14() {
        Set<String> expected = new HashSet<>();
        expected.add("g");
        expected.add("h");
        expected.add("i");

        Set<String> actual = treeDictionary.trimWords("4663",1);
        assertEquals(expected, actual);
    }
    @Test
    public void test15() {
        Set<String> expected = new HashSet<>();
        expected.add("im");
        expected.add("in");
        expected.add("io");
        expected.add("ho");
        expected.add("gn");
        expected.add("go");

        Set<String> actual = treeDictionary.trimWords("4663",2);
        assertEquals(expected, actual);
    }

}
