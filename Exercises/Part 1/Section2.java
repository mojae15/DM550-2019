public class Section2 {

    public static void main(String[] args) {

        printMultiples();

        printMultiples(10);

        printMultiples(37, 500);

        System.out.println(sumUpTo(5));

        System.out.println(sumsBeyond(5));

        System.out.println(sumBetween(10, 12));

        System.out.println(sumEven(7));

        System.out.println(factorialRec(10));

        System.out.println(factorialLoop(10));

        System.out.println(doubleFactorial(10));

        System.out.println(fibonacciRec(5));

        System.out.println(fibonacciLoop(5));

        System.out.println(logarithm(10));

        System.out.println(countDivisors((10)));

        System.out.println(isPerfect(7));

        System.out.println(countPerfect(10));

        System.out.println(isPrime(3));

        System.out.println(countPrime(10));

        System.out.println(nthPrime(10));

        System.out.println(largestDifference(272));

        System.out.println(gcdLoop(10, 55));

        System.out.println(lcm(10, 67));

        System.out.println(firstDigit(23));

        System.out.println(firstDigitBase(26, 4));

        System.out.println(isPalindrome(989));

        System.out.println(findPower(5));

    }

    // Print multiples using while loops
    // Task 1
    public static void printMultiples() {
        int i = 7;
        while (i < 500) {
            System.out.println(i);
            i = i + 7;
        }
    }

    // Task 2
    public static void printMultiples(int n) {
        int i = 7;
        while (i < n) {
            System.out.println(i);
            i = i + 7;
        }
    }

    // Task 3
    public static void printMultiples(int k, int n) {
        int i = k;
        while (i < n) {
            System.out.println(i);
            i = i + k;
        }
    }

    // Task 4 - Since it is "Up to n", should it not be "i < n" not "i <= n"?
    public static int sumUpTo(int n) {
        int i = 1;
        int sum = 0;
        while (i <= n) {
            sum = sum + i;
            i++;
        }
        return sum;
    }

    // Task 5
    public static int sumsBeyond(int k) {
        int i = 1;
        int sum = 0;

        // We want to sum all numbers until we reach k
        while (sum <= k) {
            sum = sum + i;
            i++;
        }

        // The last iteration exceeds the bound, so we subtract 1;
        return i - 1;
    }

    // Task 6
    public static int sumBetween(int m, int n) {
        int i = m + 1;
        int sum = 0;
        while (i < n) {
            sum = sum + i;
            i++;
        }

        return sum;
    }

    // Task 7
    public static int sumEven(int n) {
        int i = 0;
        int sum = 0;
        while (i < n) {
            sum = sum + i;
            i = i + 2;
        }
        return sum;
    }

    // Task 8 - Recursive
    public static int factorialRec(int n) {
        if (n == 1 || n == 0) {
            return 1;
        } else {
            return n * factorialRec(n - 1);
        }
    }

    // Task 8 - Loop
    public static int factorialLoop(int n) {
        int i = 1;
        int fac = 1;
        while (i <= n) {
            fac = fac * i;
            i++;
        }
        return fac;
    }

    // Task 9
    public static int doubleFactorial(int n) {
        int i = n % 2 + 2; // If even, i = 2, if odd, i = 3;
        int fac = 1;
        while (i <= n) {
            fac = fac * i;
            i = i + 2;
        }
        return fac;
    }

    // Task 10 - Recursive
    public static int fibonacciRec(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return fibonacciRec(n - 1) + fibonacciRec(n - 2);
        }
    }

    // Task 10 - Loop
    public static int fibonacciLoop(int n) {
        int i = 1;

        int fib = 1;
        int lastFib = 1;
        int newF;

        while (i < n) {
            newF = lastFib + fib;
            lastFib = fib;
            fib = newF;
            i++;
        }
        return fib;
    }

    // Task 11
    public static int logarithm(int n) {
        int res = 0;
        int value = n;
        while (value > 1) {
            value = value / 2;
            res++;
        }

        return res;
    }

    // Task 12
    public static int countDivisors(int n) {
        int i = 1;
        int divisors = 0;
        while (i < n) {
            if (n % i == 0) {
                divisors++;
            }
            i++;
        }
        return divisors;
    }

    // Task 13
    public static boolean isPerfect(int n) {
        int i = 1;

        int sum = 0;

        while (i < n) {
            if (n % i == 0) {
                sum = sum + i;
            }
            i++;
        }
        return (sum == n);
    }

    // Task 14
    public static int countPerfect(int n) {
        int i = 1;
        int perfectNumbers = 0;

        while (i < n) {
            if (isPerfect(i)) {
                perfectNumbers++;
            }
            i++;
        }

        return perfectNumbers;
    }

    // Task 15
    public static boolean isPrime(int n) {
        int i = 2;
        boolean flag = true;
        while ((i < n) && flag) {
            if (n % i == 0) {
                flag = false;
            }
            i++;
        }

        return ((n > 1) && flag); // n has to be bigger than 1, and the flag has to be set
    }

    // Task 16
    public static int countPrime(int n) {
        int i = 0;
        int primes = 0;
        while (i < n) {
            if (isPrime(i)) {
                primes++;
            }
            i++;
        }
        return primes;
    }

    // Task 17
    public static int nthPrime(int n) {
        int i = 0;
        int primes = 0;
        while (primes < n) {
            if (isPrime(i)) {
                primes++;
            }
            i++;
        }
        return i - 1;
    }

    // Task 18
    public static int largestDifference(int n) {
        int smallPrime = 2;
        int largePrime = 3;
        int diff = 1;
        int tempDiff;
        int i = 4;
        while (i < n) {
            if (isPrime(i)) {
                smallPrime = largePrime;
                largePrime = i;
                tempDiff = largePrime - smallPrime;
                if (tempDiff > diff) {
                    diff = tempDiff;
                }
            }
            i++;
        }

        return diff;
    }

    public static int primeGap(int n) {
        int prevPrime = -1;
        int gap = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime(i)) {
                if (prevPrime > 0) {
                    if (i - prevPrime > gap) {
                        gap = i - prevPrime;
                    }
                }
                prevPrime = i;
            }
        }
        return gap;
    }

    // Task 19 - Recursive
    public static int gcdRec(int m, int n) {
        if (m == n) {
            return m;
        } else if (m < n) {
            return gcdRec(m, n - m);
        } else {
            return gcdRec(m - n, m);
        }
    }

    // Task 19 - Loop
    public static int gcdLoop(int m, int n) {
        while (m != n) {
            if (m > n) {
                m = m - n;
            } else {
                n = n - m;
            }
        }
        return m;
    }

    // Task 20
    public static int lcm(int m, int n) {
        return m / gcdLoop(m, n) * n;
    }

    // Task 21
    public static int firstDigit(int n) {
        while (n > 10) {
            n = n / 10;
        }
        return n;
    }

    // Task 22
    public static int firstDigitBase(int n, int k) {
        while (n > k) {
            n = n / k;
        }
        return n;
    }

    // Taskl 23
    public static boolean isPalindrome(int n) {
        int originalN = n;
        int palindromeN = 0;
        while (n > 0) {
            palindromeN = palindromeN * 10 + n % 10;
            n = n / 10;
        }
        return (originalN == palindromeN);
    }

    // Task 24
    public static int findPower(int k) {
        int i = 0;
        int power = 1;
        while (firstDigit(power) != k) {
            power = power * 2;
            i++;
        }
        return i;
    }

}
