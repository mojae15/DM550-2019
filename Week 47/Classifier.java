public class Classifier{


    //Class Attributes
    private double[][] ref;
    private int[] species;

    //Contructor
    public Classifier(double[][] ref, int[] species){
        this.ref = ref;
        this.species = species;
    }


    /**
     * Classifies the given pattern
     */
    public int classify(double[] pattern){

        double bestLen = Double.MAX_VALUE;
        int bestMatch = -1;

        for (int i = 0; i < ref.length; i++){

            double dist = calcDistance(ref[i], pattern);
            if (dist < bestLen){
                bestLen = dist;
                bestMatch = species[i];
            }
            
        }

        return bestMatch;
    }

    /**
     * Calcualtes the distance from the point ref to the point pattern
     * ref and pattern must be the same length
     */
    private double calcDistance(double[] ref, double[] pattern){


        double len = 0;

        for (int i = 0; i < ref.length; i++){
            len = (ref[i] - pattern[i]) * (ref[i] - pattern[i]);
        }
        return Math.sqrt(len);


    }

    /**
     * Classifies the given set
     */
    public int[] classifySet(double[][] set){

        int[] res = new int[set.length];

        for (int i = 0; i < res.length; i++){

            res[i] = classify(set[i]);

        }


        return res;
    }

    /**
     * Calculates the error in the classifications based on the given set
     */
    public double error(double[][] set, int[] classifications){

        int[] res = classifySet(set);

        int errors = classifications.length;

        for (int i = 0; i < res.length; i++){

            if (res[i] == classifications[i]){
                errors--;
            }

        }

        return (errors * 100.0) / classifications.length;
    }
}