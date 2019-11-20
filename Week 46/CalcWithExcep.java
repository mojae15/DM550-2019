public class CalcWithExcep {

    private static Fraction calculate(String exp) throws CalculatorException {
        return parseE(new List(exp.split(" ")));
    }

    private static Fraction parseE(List exp) throws CalculatorException {
        Fraction temp;
        Fraction res = parseM(exp);
        String op;

        while (!exp.isEmpty() && (exp.head().equals("+") || exp.head().equals("-"))) {
            // Get first operator in expression, and remove it from the list
            op = exp.head();
            exp.tail();

            // Calculate the value of the op
            temp = parseE(exp);

            // Add or subtract the value
            if (op.equals("+")) {
                res = res.add(temp);
            } else {
                res = res.subtract(temp);
            }

        }

        return res;

    }

    private static Fraction parseM(List mul) throws CalculatorException {
        Fraction temp;
        Fraction res = parseT(mul);
        String op;

        while (!mul.isEmpty() && (mul.head().equals("*") || mul.head().equals("/"))) {
            // Get first operator in expression, and remove it from the list
            op = mul.head();
            mul.tail();

            // Calculate the value of the op
            temp = parseM(mul);

            // Multiply or divide the value
            if (op.equals("*")) {
                res = res.multiply(temp);
            } else {
                res = res.divide(temp);
            }

        }

        return res;

    }

    private static Fraction parseT(List term) throws CalculatorException {
        Fraction res;
        // Check if we are in the case: (e)
        if (term.head().equals("(")) {
            // Remove "("
            term.tail();
            res = parseE(term);

            // Remove ")"
            term.tail();

            return res;

        } else {

            try {
                // term is an integer
                res = new Fraction(Integer.parseInt(term.head()));

                // Remove the int
                term.tail();

                return res;
            } catch (NumberFormatException e) {

                return new Fraction(1);


                // throw new CalculatorException("Wrong format");
            }
        }

    }

    public static void main(String[] args) {
        String exp = "2 / t";

        try {
            System.out.println(calculate(exp));

        } catch (CalculatorException e) {
            System.out.println(e);
        }
    }
}
