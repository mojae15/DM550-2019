public class Fraction{

    //Class Attributes
    private int numerator, denominator;

    //Constructors
    public Fraction(){
        this.numerator = 1;
        this.denominator = 1;
    }

    public Fraction(int n){
        this.numerator = n;
        this.denominator = 1;
    }

    public Fraction(int n, int m){
        this.numerator = n;
        this.denominator = m;
    }

    //Getters and Setters
    public int getNumerator(){
        return this.numerator;
    }

    public int getDenominator(){
        return this.denominator;
    }

    // public void setNumerator(int n){
    //     this.numerator = n;
    // }

    // public void setDenominator(int d){
    //     this.denominator = d;
    // }



    private static int gcd(int m, int n){
        while (m != n){
            if (m > n){
                m = m-n;
            } else {
                n = n-m;
            }
        }
        return m;
    }

    private static int lcm(int m, int n){
        return m/gcd(m, n) * n;
    }

    

    public Fraction add(Fraction f){
        int gcd = gcd(this.denominator,f.denominator);
	    return new Fraction(this.numerator*f.denominator/gcd + f.numerator*this.denominator/gcd,
			                lcm(this.denominator,f.denominator));
    }
    
    public Fraction subtract(Fraction f){
        int gcd = gcd(this.denominator,f.denominator);
	    return new Fraction(this.numerator*f.denominator/gcd - f.numerator*this.denominator/gcd,
			                lcm(this.denominator,f.denominator));

    }

    public Fraction multiply(Fraction f){
        return new Fraction(this.numerator*f.numerator,
			                this.denominator*f.denominator);
    }

    public Fraction divide(Fraction f){
        return new Fraction(this.numerator*f.denominator,
			                this.denominator*f.numerator);
        
    }

    public void simplify() {
        int gcd = gcd(numerator,denominator);
        numerator = numerator / gcd;
        denominator = denominator / gcd;
        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
    }

    public double value(){

        return this.numerator/(double) this.denominator;

    }

    public int integerPart(){
        return this.numerator/this.denominator;
    }

    public Fraction properPart(){
        return new Fraction(this.numerator%this.denominator, this.denominator);
    }

    public boolean equals(Object obj){
        if (!(obj instanceof Fraction)){
            return false;
        }

        Fraction other = (Fraction) obj;
        return (this.numerator * other.numerator == this.denominator*other.denominator);
    }

    public int hashcode(){
        return this.numerator + this.denominator*31;
    }

    public Fraction copy(){
        Fraction copy = new Fraction(this.numerator, this.denominator);
        return copy;

    }

    public String toString(){
        return ""+numerator+"/"+denominator;
    }


}