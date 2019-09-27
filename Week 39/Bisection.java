public class Bisection{

    public static void main(String[] args) {

        double a = 1.0;
        double b = 2.0;
        double err = 0.1;

        double c = (a+b)/2;

        while ((b-a) > err){
            c = (a+b)/2;
            if (f(a) * f(c) < 0){
                b = c;
            } else {
                a = c;
            }

            // System.out.println("a: "+a+", b: "+b+", c: "+c);
        }
        System.out.println(a);



    }

    private static double f(double x){
        // return x*10*((x%2)-1);

        return x*x;
    }



}
