package predictive;

/**
 * Sigs2WordsList.java is a command-line program used
 * for testing the ListDictionary Class.
 *
 * Worksheet 3: Predictive Text Entry
 * @Author: Sion Davies
 * @version 10/02/20
 */

/**
 * We compare the time taken to complete the execution of
 * Sigs2WordsList and Sigs2WordsProto and note whether the
 * time taken is noticeable.
 *
 * The input we will use to compare these two programs is
 * taken from the article: https://www.bbc.co.uk/sport/football/51542901
 *
 * The time taken for each program to run with this input was...
 *
 * Sigs2WordsList: 89 milliseconds / 0.089 seconds
 * Sigs2WordsProto: 14951 milliseconds / 14.951 seconds
 *
 * Therefore it can demonstrated that the Sigs2WordsList implementation
 * of the signatureToWords method is much more efficient.
 *
 */

public class Sigs2WordsList {

    public static void main(String[] args){
        ListDictionary list = new ListDictionary("/usr/share/dict/words");
        long timeStart = System.currentTimeMillis();
        for(String s : args){
            System.out.println(s + " : " + list.signatureToWords(s));
        }
        long timeEnd = System.currentTimeMillis();
        long timeTaken = timeEnd - timeStart;
//        System.out.println(timeTaken);

    }

}





