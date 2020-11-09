package predictive;

import java.io.File;
import java.util.*;

/**
 * ListDictionary.java contains the methods for
 * question 2 for the software workshop
 * worksheet 3, spring term.
 *
 * Worksheet 3: Predictive Text Entry
 * @Author: Sion Davies
 * @version 11/02/20
 */

public class ListDictionary implements Dictionary {

    private ArrayList<WordSig> dictionary = new ArrayList<>();


    /**
     * Constructor for ListDictionary objects.
     * <p>
     * The constructor takes in a String path to the users
     * dictionary of preference, reads it, and stores it
     * in an ArrayList. Each entry of the ArrayList is a pair,
     * which consists of the word that has been read in from
     * the dictionary and its' corresponding numeric signature.
     * <p>
     * In order to do this an object of Class WordSig is used
     * as they pair words to their numeric signature.
     * The wordToSignature() method is used from the
     * PredictiveProtoType.java Class to convert words to
     * numeric signatures.
     *
     * After reading the file dictionary
     * the ArrayList is sorted using Collections.sort(), this allows
     * elements in the array to be sorted in ascending order.
     *
     *
     * @param path the name of the .txt file path.
     */

    public ListDictionary(String path) {
        try {
            File listInput = new File(path);
            Scanner scanner = new Scanner(listInput);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().toLowerCase();
                WordSig wordSig = new WordSig(line, PredictivePrototype.wordToSignature(line));
                dictionary.add(wordSig);
            }
            Collections.sort(dictionary);
            scanner.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
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

    /**
     * signatureToWords() takes a given String input that is a numeric
     * signature and returns the corresponding matching word set from
     * the dictionary .txt file.
     *
     * The method uses binary search to perform look-ups for potential
     * matching words. As binary search does not necessarily land on
     * the first copy of duplicate elements, we must use two loops, one
     * going forwards and one backwards to add any potential duplicate matching
     * word copies to the set to be returned.
     *
     * @param signature The given numeric signature.
     * @return A set of matching words from the dictionary .txt file.
     */

    @Override
    public Set<String> signatureToWords(String signature) {
        if (isValidSignature(signature)) {
            Set<String> set = new TreeSet<>();
            //Get index position of signature.
            int position = Collections.binarySearch(dictionary, new WordSig(null, signature));
            //Prevents an array out of bounds error.
            if(position < 0)
                return set;
            //In event position index has duplicate signatures:
            //1: Traverse the dictionary indexes backwards from this position, adding any words
            // that match the signature to the set.
            for (int i = position; i >= 0; i--) {
                if (!dictionary.get(i).getSignature().equals(signature)) {
                    break;
                }
                set.add(dictionary.get(i).getWords().toLowerCase());
            //2: Traverse the dictionary forwards from the position, adding any words
            // that match the signature to the set.
            } for (int i = position; i < dictionary.size(); i++) {
                if (!dictionary.get(i).getSignature().equals(signature)) {
                    break;
                }
                set.add(dictionary.get(i).getWords().toLowerCase());
            }
            return set;
        } else {
            return new HashSet<>();
        }

    }
}





