package predictive;

/**
 * Sig2WordsProto.java is a command-line program used
 * for calling the signatureToWords method from the
 * PredictiveProtoype.java class.
 *
 * Worksheet 3: Predictive Text Entry
 * @Author: Sion Davies
 * @version 10/02/20
 */

public class Sigs2WordsProto {

    public static void main(String[] args) {
        long timeStart = System.currentTimeMillis();
        for(String s : args) {
            System.out.println(s + " : " + PredictivePrototype.signatureToWords(s));
        }

        long timeEnd = System.currentTimeMillis();
        long timeTaken = timeEnd - timeStart;
//        System.out.println(timeTaken);
    }
}


