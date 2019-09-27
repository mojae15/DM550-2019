/**
 * Solution from class H7
 */

public class Bisection{

    public static void main(String[] args) {

        double estimation = bisecMethod(Double.parseDouble(args[0]), Double.parseDouble(args[1]), Double.parseDouble(args[2]));
        System.out.println(estimation);

    }

    public static double bisecMethod(double a, double b, double err){

        double c = 0;
        while ((b-a) > err ){
            c = (a+b)/2.0;
            if ( f(a) * f(c) < 0){
                b = c;

            } else {
                a = c;
            }
        }

        return a;

    }

    private static double f(double x){
        return x*x;
    }

}


public class FindZeros{

    public static void main(String[] args){

        // Solution 1:
        // String notFound = "Not found";
        // int n = 0;
        //
        // if (f(n) >= 0){
        //     System.out.println("f("+f(n)+") = 0");
        //
        // } else {
        //     System.out.println(notFound);
        // }

        // Solution 2:
        // int counter = 0;
        // int smallN = 0;
        // boolean res = false;
        //
        // while(counter < 1000000){
        //     if (f(smallN) == 0){
        //         System.out.println("Smallest n is:"+smallN);
        //         res = true;
        //     }
        //     counter++;
        //     smallN++;
        //
        // }
        //
        // System.out.println(res);





    }

    private static int f(int n){
        // Solution 1:
        // int counter = 0;
        // while(n*n != 0 && counter < 1000000000){
        //     n = n+1;
        //     counter = counter +1;
        // }
        // if (n*n == 0){
        //     return n;
        // } else {
        //     return -1;
        // }

        // Solution 2:
        // return n+1;

    }



}
