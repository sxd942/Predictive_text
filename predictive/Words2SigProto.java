package predictive;

/**
 * Words2SigProto.java is a command-line program used
 * for calling the wordsToSignature method from the
 * PredictiveProtoype.java class.
 *
 * Worksheet 3: Predictive Text Entry
 * @Author: Sion Davies
 * @version 10/02/20
 */

public class Words2SigProto {

    public static void main(String[] args){

        for(String s : args) {
            System.out.println(s + " : " + PredictivePrototype.wordToSignature(s));
        }

    }
}
