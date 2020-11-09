package predictive;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * PredictivePrototype.java contains the methods for
 * question 1, parts 1 & 2 for the software workshop
 * worksheet 3, spring term.
 *
 * Worksheet 3: Predictive Text Entry
 * @Author: Sion Davies
 * @version 10/02/20
 */

public class PredictivePrototype {

    private static File path = new File("/usr/share/dict/words");

    /**
     * The wordToSignature() method takes in a word as
     * an argument and returns a numeric signature.
     * For example, if the String 'home' is passed into
     * the method it will return '4663' as an output.
     * Just like the numbers would be entered
     * on an old phone to enter the word.
     *
     * A StringBuffer class is used opposed to a String
     * because String buffer is thread safe, it is safe
     * to be used by multiple threads, if one thread is
     * accessing the string buffer, the rest have to wait.
     *
     * @param word the input word to be returned as a numeric signature.
     * @return the numeric signature of the given word.
     */

    public static String wordToSignature(String word) {

        StringBuffer numericSignature = new StringBuffer();
        word = word.toLowerCase();

        for (int i = 0; i <= word.length() - 1; i++) {
            if ((word.charAt(i) == 'a') || (word.charAt(i) == 'b') || (word.charAt(i) == 'c')) {
                numericSignature.append("2");
            } else if ((word.charAt(i) == 'd') || (word.charAt(i) == 'e') || (word.charAt(i) == 'f')) {
                numericSignature.append("3");
            } else if ((word.charAt(i) == 'g') || (word.charAt(i) == 'h') || (word.charAt(i) == 'i')) {
                numericSignature.append("4");
            } else if ((word.charAt(i) == 'j') || (word.charAt(i) == 'k') || (word.charAt(i) == 'l')) {
                numericSignature.append("5");
            } else if ((word.charAt(i) == 'm') || (word.charAt(i) == 'n') || (word.charAt(i) == 'o')) {
                numericSignature.append("6");
            } else if ((word.charAt(i) == 'p') || (word.charAt(i) == 'q') || (word.charAt(i) == 'r')
                    || (word.charAt(i) == 's')) {
                numericSignature.append("7");
            } else if ((word.charAt(i) == 't') || (word.charAt(i) == 'u') || (word.charAt(i) == 'v')) {
                numericSignature.append("8");
            } else if ((word.charAt(i) == 'w') || (word.charAt(i) == 'x') || (word.charAt(i) == 'y')
                    || (word.charAt(i) == 'z')) {
                numericSignature.append("9");
            } else if (!Character.isLetter(i)) {
                numericSignature.append(" ");
            }
        }
        return numericSignature.toString();
    }

    /**
     * setPath() is a setter method to set the path
     * to use in signatureToWords() to the dictionary
     * .txt file of the users choice.
     *
     * @param path the dictionary .txt file to be used.
     */

    public void setPath(String path) {
        this.path = new File(path);
    }

    /**
     * signatureToWords() takes the given numeric signature and returns a
     * possible set of matching words from the dictionary.
     *
     * The method does not return duplicate words and returns words in
     * lower case only.
     * The dictionary is not stored in the java program itself, but in
     * a pre-specified .txt file that is uses to locate possible matches.
     * This implementation is inefficient, as the words located in the .txt
     * file will have to be read on a line-by-line basis. A HashMap would be
     * more suited for this function, as it would be faster at retrieving
     * elements from the given dictionary.
     *
     * @param signature the numeric signature input for matching words from
     *                  the dictionary.
     * @return a set of possible candidate words from the dictionary.
     */

    public static Set<String> signatureToWords(String signature) {

        HashSet<String> contender = new HashSet<>();

        try {
            Scanner input = new Scanner(path);
            while (input.hasNextLine()) {
                String line = input.nextLine().toLowerCase();
                if (line.length() == signature.length() &&
                        isValidWord(line)) {
                    if (wordToSignature(line).equals(signature) &&
                            (!contender.contains(line))) {
                        contender.add(line);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return contender;
    }


    /**
     * isValidWord() is a helper function used in the signatureToWords()
     * method. The function is used to check if a given input qualifies
     * as a possible candidate for a valid word.
     *
     * @param word the word to verify if it is a possibly valid word.
     * @return boolean true/false to indicate validity.
     */

    public static boolean isValidWord(String word) {
       if((word.matches("[a-zA-Z]+")) && (word.length() < 45)){
           return true;
       } else {
           return false;
       }
    }

}



