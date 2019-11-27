public class ClassifierClient{

    public static void main(String[] args) {

        Classifier c = new Classifier(
                            new double[][] { {1.0, 2.0}, {1.1, 0.3} },
                            new int[] { 2, 1 });
        
        double[][] test = new double[][]{ {1.0, 2.0}, {1.1, 0.3} };

        
        System.out.println(c.error(test, new int[]{2,2}));

    }


}