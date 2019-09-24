public class Stars{

    public static void main(String[] args){

        // stars(5);
        // linesOfStars(5);
        // triangle(5);

        System.out.println(downToOne(10));

    }

    public static void stars(int n){

        int m = 1;

        while(m <= n){
            System.out.print("*");
            m = m+1;
        }

        System.out.println();


    }

    public static void linesOfStars(int n){
        // int i = 1;
        //
        // String lineOfStars = "*";
        //
        // while(i <= n){
        //     System.out.println(lineOfStars);
        //     lineOfStars = lineOfStars + "*";
        //     i = i+1;
        // }

        int i = 1;

        while (i <= n){
            stars(i);
            i = i+1;
        }

    }

    public static String spaces(int i, int n){
        String spaces = "";
        int rounds = n-i;

        int j = 1;
        while (j <= rounds){
            spaces = spaces + " ";
            j++;
        }

        return spaces;
    }

    public static void triangle(int n){

        // int i = 1;
        // String lineOfStars = "*";
        //
        // while (i <= n){
        //     String space = spaces(i, n);
        //     String thisLineOfStars = space + lineOfStars;
        //     System.out.println(thisLineOfStars);
        //     lineOfStars = lineOfStars + "**";
        //     i = i+1;
        // }

        int i = 1;

        while (i <= n){

            printString(n-i, " ");
            printString(2*i-1, "*");

            System.out.println();
            // System.out.println(2*i-1);
            i = i+1;

        }


    }

    public static void printString(int n, String s){
        int m = 1;

        while(m <= n){
            System.out.print(s);
            m = m+1;
        }



    }

    public static int downToOne(int n){

        int counter = 0;

        int i = 1;
        while (i < n){
            counter++;
            if (n % 2 == 0){
                n = n/2;
            } else {
                n = n*3+1;
            }
        }

        return counter;

    }

}
