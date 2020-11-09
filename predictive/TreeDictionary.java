package predictive;

import java.io.File;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * The TreeDictionary.java class contains the methods
 * for question 4, part 1 of the software worksheet
 * 3, Spring Term.
 *
 * TreeDictionary forms a recursive data structure.
 * This class involves another implementation of the
 * of the Dictionary interface which allows users to
 * see the parts of the words they are typing whilst
 * they type.
 *
 * Worksheet 3: Predictive Text Entry
 * @Author: Sion Davies
 * @Verion: 18/02/2020
 */

public class TreeDictionary implements Dictionary {


    private Set<String> words;
    private TreeDictionary[] children;


    /**
     * Constructor for TreeDictionary.
     *
     * The constructor for TreeDictionary takes a String path
     * to the dictionary, reads each line and populates the Tree
     * with the words.
     *
     * The tree has 8 branches stored in an array for each number
     * 2-9 on the phone keypad that is allowed in a signature.
     *
     * The constructor calls the helper function addwords()
     * to populate the Tree with words.
     *
     * If an invalid source is passed an exception is caught.
     *
     * @param path the String path to the dictionary .txt file.
     */

    public TreeDictionary(String path) {
        this.words = new HashSet<>();
        this.children = new TreeDictionary[8];

        try {
            File dictionary = new File(path);
            Scanner scanner = new Scanner(dictionary);
            while (scanner.hasNextLine()){
                String line = scanner.nextLine().toLowerCase();
                if (isValidWord(line)){
                addWords(line, line);
                }
            }
        }
        catch(Exception e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * Standard constructor for TreeDictionary.
     */

    public TreeDictionary() {
        this.words = new HashSet<>();
        this.children = new TreeDictionary[8];
    }

    /**
     * Getter method for children.
     * @return children.
     */

    public TreeDictionary[] getChildren(){
        return children;
    }

    /**
     * Getter method for words.
     * @return words.
     */

    public Set<String> getWords(){
        return words;
    }

    /**
     * addWords() is used in the TreeDictionary constructor
     * to populate the Tree with words.
     *
     * The method first converts the String 'signature' to a
     * numeric signature using the wordToSignature method.
     * Then parses it into an int and gets the first index value.
     *
     * I.e. if signature == "house", '4' would be returned (as
     * the first letter of house == h and h on the keypad is stored
     * under the number '4')
     * and then 2 is subtracted from the value, so num = 2.
     *
     * 2 is subtracted from the value as we are now storing values in an
     * array of size 8.
     * For example, there are 8 keypads on a phone: 2-9, as such,
     * the first index array 0 stores the values of keypad 2, array
     * index 1 stores the values of keypad 3, array 2 the values of keypad
     * 4 etc..
     *
     * Next the method checks to see if they're no nodes
     * (if getChildren()[num] == null) - and it will create
     * an instance of a new node if not (new array of 8
     * elements with sets.
     *
     * If there's not, we set the index to a new TreeDictionary type
     * and add the word to the array index. Else, we just
     * add the word.
     *
     * Finally, a recursive call is made on the String word and
     * the substring of String signature (the remaining words)
     * which allows the process to be repeated on each individual
     * letter of the word one at a time, this repeats until
     * every letter has been assigned.
     *
     * @param word Word from the dictionary.
     * @param signature Numeric signature of word from dictionary.
     */

    public void addWords(String word, String signature) {
        if (signature.length() >= 1) {
            int num = Integer.parseInt(wordToSignature(signature.substring(0, 1))) - 2;

            if (getChildren()[num] == null) {
                getChildren()[num] = new TreeDictionary();
                getChildren()[num].getWords().add(word);

                String nextNum = signature.substring(1);
                getChildren()[num].addWords(word, nextNum);
            } else {
                getChildren()[num].getWords().add(word);

                String nextNum = signature.substring(1);
                getChildren()[num].addWords(word, nextNum);
            }
        }
    }

    /**
     * signatureToWords() takes the given numeric signature and returns a
     * possible set of matching words from the dictionary.
     * The method does not return duplicate words and returns words in
     * lower case only.
     *
     * SignatureToWords() uses the helper functions:
     *
     * isValidSignature() which checks to see is a numeric signature is
     * valid in accordance with a phone keypad which outputs words on keys
     * 2-9.
     *
     * trimWords() which trims all the words in a given list.
     *
     * @param signature the numeric signature input for matching words from
     *                     the dictionary.
     * @return a set of possible candidate words from the dictionary.
     */

    @Override
    public Set<String> signatureToWords(String signature) {
        if(isValidSignature(signature)) {
            return trimWords(signature, signature.length());
        }
        else {
            return new HashSet<>();
        }
    }

    /**
     * trimWords() is a helper function for the signatureToWords()
     * method. This function trims all words in a given list to produce
     * the output of signatureToWords.
     *
     * For example, with arguments: ("4663", 1)
     * the output will be: "g", "h", "i"
     * With arguments: (4663, 4)
     * the output will be: "hood", "good", "gone", "home" etc.
     *
     * It first checks if the input is a valid signature using the
     * isValidSignature() helper function.
     *
     * The method converts the String 'signature' to a
     * numeric signature using the wordToSignature method.
     * Then parses it into an int and gets the first index value.
     * I.e. if signature == "house", '4' would be returned (as
     * the first letter of house == h and h on the keypad is stored
     * under the number '4') and then 2 is subtracted from the value, so num = 2.
     * 2 is subtracted from the value as we are now storing values in an
     * array of size 8.
     * For example, there are 8 keypads on a phone: 2-9, as such,
     * the first index array 0 stores the values of keypad 2, array
     * index 1 stores the values of keypad 3, array 2 the values of keypad
     * 4 etc..
     *
     * Then the function checks for if they're no nodes, if not, creates
     * a new instance of nodes. Else, store the trimmed element in the
     * appropriate branch.
     *
     * Finally, recursively call the remaining elements in signature
     * to repeat the process.
     *
     * @param signature the signature to be trimmed.
     * @param length the length the signature should be trimmed by.
     * @return signature trimmed by length.
     */

    public Set<String> trimWords(String signature, int length) {

        if(!isValidSignature(signature)){
           throw new IllegalArgumentException("Invalid signature input");
        }
        int num = Integer.parseInt(signature.substring(0, 1)) - 2;
        if (getChildren()[num] == null) {
            return new HashSet<>();
        }
        else if (signature.length() == 1) {
            Set<String> set = new HashSet<>();
            Set<String> words = getChildren()[num].getWords();
            for (String s : words) {
                set.add(s.substring(0, length));
            }
            return set;
        }
        else {
            return getChildren()[num].trimWords(signature.substring(1), length);
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
     * isValidWord() is a helper function.
     * The function is used to check if a given input qualifies
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

    /**
     * isValidSignature() takes in a numeric signature of type
     * String and determines its validity of being a valid
     * numeric signature.
     * It does this by checking if the String numbers passed
     * are between the values of 2 and 9. If any value in the
     * String lies outside of this range the function will return
     * false.
     *
     * @param signature the numeric signature to be checked.
     * @return boolean value indicating if String is a valid signature.
     */

    public static boolean isValidSignature(String signature){
        if (signature.length() < 1) {
            return true;
        } else if ((signature.matches("[2-9]+")) &
                (signature.length() < 45)) {
            return true;
        } else {
            return false;
        }
    }


}
