package predictive;

import java.io.File;
import java.util.*;

/**
 * MapDictionary.java contains the methods for
 * question 3, parts 1 of the software workshop
 * worksheet 3, spring term.
 *
 * Worksheet 3: Predictive Text Entry
 * @Author: Sion Davies
 * @version 17/02/20
 */

public class MapDictionary implements Dictionary {

    /**
     * A TreeMap was chosen to implement the dictionary in Map
     * form.
     * TreeMap implements the Map interface including sorted Map.
     * TreeMap provides an effective way of storing key/value
     * pairs in a sorted order.
     *
     * It does not allow null keys and contains only unique elements.
     *
     * Using a Map data can be retrieved hastily and does not
     * require scanning either side of the index. MapDictionary
     * also enables efficient insertion of new words in the dictionary
     * and allows quick look-ups.
     */

    private TreeMap<String, Set<String>> multiMap = new TreeMap<>();

    /**
     * Constructor for MapDictionary objects.
     *
     * The constructor takes in a String, path, as its argument.
     * This String takes a path to the dictionary of the users
     * preference which is stored and read in a File object.
     * This object is scanned by a Scanner object that stores the
     * dictionary entries in a multi-valued TreeMap that maps
     * each signature to set of words. If the path file is
     * incorrect an exception is thrown.
     *
     * While scanning the dictionary the words are converted to
     * lower case. Then, the word is added to the TreeMap object
     * and each signature gets mapped to a word.
     *
     * computeIfAbsent() checks if a specified key is not already
     * associated with a value, computes the value and enters it
     * into the Map unless null.
     * key == the parameter for the key which the Map will pass
     * to the lambda function for computing the value.
     *
     * It uses the helper functions:
     * isValidWords()
     * wordToSignature()
     *
     * @param path the String path to the dictionary .txt file.
     */

    public MapDictionary(String path) {

        try {
            File dictionary = new File(path);
            Scanner scanner = new Scanner(dictionary);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().toLowerCase();
                if (isValidWord(line)){
                    multiMap.computeIfAbsent(wordToSignature(line), key -> new HashSet<>()).add(line);
                }
        }
    }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }

}
    /**
     * signatureToWords() takes the given numeric signature and returns a
     * possible set of matching words from the dictionary.
     * The method does not return duplicate words and returns words in
     * lower case only.
     *
     * @param signature the numeric signature input for matching words from
     *                  the dictionary.
     * @return a set of possible candidate words from the dictionary.
     */

    @Override
    public Set<String> signatureToWords(String signature) {
        if (multiMap.get(signature) == null) {
            return new HashSet<>();
        }
        else {
            return multiMap.get(signature);
        }
    }

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
