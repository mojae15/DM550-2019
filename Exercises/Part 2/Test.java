public class Test{

    public static void main(String[] args) {

        Fraction f1 = new Fraction(3,8);
        Fraction f2 = new Fraction(4,7);

        Fraction f3 = f1.add(f2);
        f3.simplify();
        System.out.println(f3);


    }



}