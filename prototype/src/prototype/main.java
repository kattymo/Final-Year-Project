package prototype;

import java.util.Arrays;
import prototype.BayesClassifier;
import prototype.Classifier;

public class main {

    public static void main(String[] args) {
    	
        final Classifier<String, String> bayes =
                new BayesClassifier<String, String>();
        //examples
        final String[] Mark = "Mark said 'this'".split("\\s");
        bayes.learn("Mark", Arrays.asList(Mark));

        final String[] Kate = "Kate said 'this'".split("\\s");
        bayes.learn("Kate", Arrays.asList(Kate));
        
        //text to classify
        final String[] unknownText1 = "Mark implied 'that'".split("\\s");
        final String[] unknownText2 = "Kate said 'that'".split("\\s");

        System.out.println( // output "Mark"
        		"First text is said by " + bayes.classify(Arrays.asList(unknownText1)).getCategory());
        System.out.println( // output "Kate"
        		"Second text is said by " + bayes.classify(Arrays.asList(unknownText2)).getCategory());

       
        ((BayesClassifier<String, String>) bayes).classifyDetailed(
                Arrays.asList(unknownText1));

        bayes.setMemoryCapacity(500); // remember the last 500 learned classifications
    }

}
// codes and all the classification method inspired by https://github.com/ptnplanet/Java-Naive-Bayes-Classifier