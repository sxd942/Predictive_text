package predictive;

/**
 * Sigs2WordsTree.java is a command-line program used
 * for calling the signatureToWords method from the
 * TreeDictionary.java class.
 *
 * Worksheet 3: Predictive Text Entry
 * @Author: Sion Davies
 * @Version: 18/02/2020
 */

/**
 * We compare the time taken to complete the execution of
 * Sigs2WordsTree, Sigs2WordsMap and Sigs2WordsTree.
 *
 * The input we will use to compare these two programs is
 * taken from the article: https://www.bbc.co.uk/sport/football/51542901
 *
 * The time taken for each program to run with this input was...
 *
 * Sigs2WordsTree: 94 milliseconds / 0.094 seconds
 * Sigs2WordsList: 89 milliseconds / 0.089 seconds
 * Sigs2WordsMap:  35 milliseconds / 0.035 seconds
 *
 * All programs were very efficient and executed extremely quickly.
 * The most efficient was the Sigs2WordsMap program.
 *
 */

public class Sigs2WordsTree {

    public static void main(String[] args){
        TreeDictionary treeDictionary = new TreeDictionary("/usr/share/dict/words");
        long timeStart = System.currentTimeMillis();

        for(String s : args) {
            System.out.println(s + " : " + treeDictionary.signatureToWords(s));
        }

        long timeEnd = System.currentTimeMillis();
        long timeTaken = timeEnd - timeStart;
//        System.out.println(timeTaken);

    }


}
