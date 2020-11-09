package predictive;

/**
 * Sigs2WordsMap.java is a command-line program used
 * for calling the signatureToWords method from the
 * MapDictionary.java class.
 *
 * Worksheet 3: Predictive Text Entry
 * @Author: Sion Davies
 * @Version: 17/02/2020
 */

public class Sigs2WordsMap {

    public static void main(String[] args) {
        MapDictionary mapDictionary = new MapDictionary("/usr/share/dict/words");
        long timeStart = System.currentTimeMillis();

        for(String s : args){
            System.out.println(s + " : " + mapDictionary.signatureToWords(s));
        }
        long timeEnd = System.currentTimeMillis();
        long timeTaken = timeEnd - timeStart;
//        System.out.println(timeTaken);

    }
}
