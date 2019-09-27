public class FindZeros{

    public static void main(String[] args) {
        int n = 0;

        while(f(n) != 0 && n < 1000000000){
            n = n + 1;

        }

        System.out.println(n);


    }

    private static int f(int n){
        return n+1;
    }

}
