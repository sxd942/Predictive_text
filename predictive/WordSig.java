package predictive;

/**
 * WordSig.java is a class used to pair words with their
 * numeric signatures.
 *
 * @Author Sion Davies
 * @Version 11/02/20
 */

public class WordSig implements Comparable<WordSig> {

    private String words;
    private String signature;


    /**
     * The constructor used for constructing WordSig objects
     *
     * @param words the given word to be paired to the signature.
     * @param signature the numeric signature to be paired with the word.
     */

    public WordSig(String words, String signature){
        this.words = words;
        this.signature = signature;
    }

    /**
     * Getter method for retrieving words.
     *
     * @return words of WordSig object.
     */

    public String getWords() {
        return words;
    }

    /**
     * Getter method for retrieving signatures.
     *
     * @return numeric signature of WordSig object.
     */

    public String getSignature() {
        return signature;
    }

    /**
     * compareTo() is a method that must be declared in order
     * to compare objects of type WordSig, as the WordSig class
     * implements the Comparable interface.
     *
     * @param ws WordSig object to be compared.
     * @return -1, 0 or 1 dependent on whether the current object
     * is less than, equal to or greater than the object object to
     * be compared to.
     */

    @Override
    public int compareTo(WordSig ws) {
        return this.getSignature().compareTo(ws.getSignature());
    }
}
