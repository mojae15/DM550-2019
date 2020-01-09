public class Section4 {

    public static void main(String[] args) {

        // System.out.println(sumUpTo(10));

        // System.out.println(sumBetween(1, 10));

        // System.out.println(sumEven(10));

        // System.out.println(factorial(10));

        // System.out.println(doubleFactorial(10));

        // System.out.println(fibonacci(10));

        // System.out.println(fibonacci2(10));

        Stack<Integer> s = new Stack<Integer>();
        s.add(1);
        s.add(2);
        s.add(3);

        System.out.println(s);
        System.out.println(reverse(s));

    }

    // Task 1
    public static int sumUpTo(int n) {
        if (n > 0) {
            return n - 1 + sumUpTo(n - 1);
        }
        return 0;
    }

    // Task 2
    public static int sumBetween(int m, int n) {
        if (m == n - 1) {
            return 0;
        }
        return (m + 1 + sumBetween(m + 1, n));
    }

    // Task 3
    public static int sumEven(int n) {
        if (n > 0) {
            int test = ((1 - ((n - 1) % 2)) * (n - 1));
            return test + sumEven(n - 1);
        }

        return 0;
    }

    // Task 4
    public static int factorial(int n) {
        if (n > 0) {
            return n * factorial(n - 1);
        }
        return 1;
    }

    // Task 5
    public static int doubleFactorial(int n) {
        if (n > 0) {
            return n * doubleFactorial(n - 2);
        }
        return 1;
    }

    // Task 6
    public static int fibonacci(int n) {
        if (n > 0) {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
        return 1;
    }

    // Efficient fibonacci
    public static int fibonacci2(int n) {
        return fibAux(n)[1];

    }

    // Auxilliary method for efficient fibonacci
    public static int[] fibAux(int n) {
        if (n > 0) {
            int[] prev = fibAux(n - 1);
            return new int[] { prev[1], prev[0] + prev[1] };
        }
        return new int[] { 1, 1 };
    }

    /*
     * Task 7 
     * Returns the integer base-2 logarithm of n. Assumes n>0.
     */
    public static int logarithm(int n) {
        return ((n == 1) ? 0 : 1 + logarithm(n / 2));
    }

    /*
     * Task 8 
     * Computes the gdc of m and n using Euclides' algorithm. Assumes n, m >
     * 0.
     */
    public static int gcd(int m, int n) {
        if (m == n)
            return m;
        else if (m > n)
            return gcd(m - n, n);
        else
            return gcd(m, n - m);
    }

    /*
     * Task 9 
     * Returns the first digit of the representation of n in base k.
     */
    public static int firstDigitBase(int n, int k) {
        return ((n < k) ? n : firstDigitBase(n / k, k));
    }

    /*
     * Task 10 
     * Counts the number of steps to 1 in the 3n+1 puzzle.
     */
    public static int downToOne(int n) {
        if (n == 1)
            return 0;
        else if (n % 2 == 0)
            return 1 + downToOne(n / 2);
        else
            return 1 + downToOne(3 * n + 1);
    }

    /*
     * Task 11
     * Computes the sum of all values in a stack. Destroys the original stack.
     */
    public static double sum(Stack<Double> s) {
        if (s.isEmpty())
            return 0;
        else {
            double top = s.top();
            s.pop();
            return top + sum(s);
        }
    }

    /*
     * Task 12
     * Returns the number of zeros in a stack. Destroys the original stack.
     */
    public static int zeros(Stack<Integer> s) {
        if (s.isEmpty())
            return 0;
        else {
            int top = s.top();
            s.pop();
            return ((top == 0) ? 1 : 0) + zeros(s);
        }
    }

    /*
     * Task 13
     * Counts the number of occurrences of n in s. Destroys the original stack.
     */
    public static <E> int count(Stack<E> s, E e) {
        if (s.isEmpty())
            return 0;
        else {
            E top = s.top();
            s.pop();
            return ((top == e) ? 1 : 0) + count(s, e);
        }
    }

    /*
     * Task 14
     * Returns a double linked list with the squares of all natural numbers from 1
     * to n.
     */
    public static DLList<Integer> squares(int n) {
        if (n <= 0)
            return new DLList<Integer>();
        else {
            DLList<Integer> result = squares(n - 1);
            result.add(n * n);
            return result;
        }
    }

    /*
     * Task 15
     * Returns the maximum value in v. Destroys v.
     */
    public static double max(DLList<Double> v) {
        if (v.isEmpty())
            return Double.MIN_VALUE;
        else {
            double current = v.get(0);
            v.remove(0);
            return Math.max(current, max(v));
        }
    }

    /**
     * Task 16
     * Reverse a stack
     */
    public static <T> Stack<T> reverse(Stack<T> s) {
        if (s.isEmpty()) {
            return s;
        } else {

            T t = s.top();
            s.pop();
            Stack<T> rev = reverse(s);
            s.add(t);
            return s;
        }
    }

    /*
     * Task 17
     * Splits the elements of a list according to their relationship to n. Destroys
     * the original list.
     */
    public static DLList<Integer>[] compare(DLList<Integer> v, int n) {
        if (v.isEmpty())
            return (DLList<Integer>[]) new Object[] { new DLList<Integer>(), new DLList<Integer>(),
                    new DLList<Integer>() };
        else {
            int top = v.get(0);
            v.remove(0);
            DLList<Integer>[] previous = compare(v, n);
            if (top > n)
                previous[0].add(top);
            else if (top == n)
                previous[1].add(top);
            else
                previous[2].add(top);
            return previous;
        }
    }

    /*
     * Task 18
     * Merges two ordered stacks. Destroys the argument stacks.
     */
    public static Stack<Integer> sortedJoin(Stack<Integer> s1, Stack<Integer> s2) {
        if (s1.isEmpty())
            return s2;
        else if (s2.isEmpty())
            return s1;
        else {
            int next;
            if (s1.top() < s2.top()) {
                next = s1.top();
                s1.pop();
            } else {
                next = s2.top();
                s2.pop();
            }
            Stack<Integer> result = sortedJoin(s1, s2);
            result.add(next);
            return result;
        }
    }

    /*
     * Task 19
     * Merges two stacks in order. Destroys the argument stacks.
     */
    public static <T> Stack<T> shuffle(Stack<T> s1, Stack<T> s2) {
        if (s1.isEmpty())
            return s2;
        else if (s2.isEmpty())
            return s1;
        else {
            T top = s1.top();
            s1.pop();
            Stack<T> result = shuffle(s2, s1);
            result.add(top);
            return result;
        }
    }

}